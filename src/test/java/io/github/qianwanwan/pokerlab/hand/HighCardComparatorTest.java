package io.github.qianwanwan.pokerlab.hand;

import io.github.qianwanwan.pokerlab.card.Card;
import io.github.qianwanwan.pokerlab.card.Rank;
import io.github.qianwanwan.pokerlab.card.Suit;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HighCardComparatorTest {
    private final HighCardComparator comparator = new HighCardComparator();

    @Test
    void higherTopCardWinsEvenWhenOtherHandHasLargerRankSum() {
        assertTrue(comparator.compare(aceHighHand(), kingHighHand()) > 0);
        assertTrue(comparator.compare(kingHighHand(), aceHighHand()) < 0);
    }

    @Test
    void fifthCardBreaksTieWhenHigherCardsMatch() {
        List<Card> leftHand = List.of(
                new Card(Rank.ACE, Suit.SPADES),
                new Card(Rank.NINE, Suit.DIAMONDS),
                new Card(Rank.SEVEN, Suit.SPADES),
                new Card(Rank.FOUR, Suit.CLUBS),
                new Card(Rank.THREE, Suit.HEARTS)
        );
        List<Card> rightHand = List.of(
                new Card(Rank.ACE, Suit.SPADES),
                new Card(Rank.NINE, Suit.DIAMONDS),
                new Card(Rank.SEVEN, Suit.SPADES),
                new Card(Rank.FOUR, Suit.CLUBS),
                new Card(Rank.TWO, Suit.HEARTS)
        );

        assertTrue(comparator.compare(leftHand, rightHand) > 0);
    }

    @Test
    void sameRanksTieRegardlessOfSuitsAndInputOrder() {
        List<Card> leftHand = List.of(
                new Card(Rank.ACE, Suit.SPADES),
                new Card(Rank.NINE, Suit.DIAMONDS),
                new Card(Rank.SEVEN, Suit.SPADES),
                new Card(Rank.FOUR, Suit.CLUBS),
                new Card(Rank.TWO, Suit.HEARTS)
        );
        List<Card> rightHand = List.of(
                new Card(Rank.TWO, Suit.DIAMONDS),
                new Card(Rank.NINE, Suit.CLUBS),
                new Card(Rank.SEVEN, Suit.DIAMONDS),
                new Card(Rank.FOUR, Suit.SPADES),
                new Card(Rank.ACE, Suit.HEARTS)
        );
        assertEquals(0, comparator.compare(leftHand, rightHand));
    }

    @Test
    void comparisonDoesNotModifyInputLists() {
        List<Card> leftHand = new ArrayList<>(aceHighHand());
        List<Card> rightHand = new ArrayList<>(kingHighHand());
        List<Card> leftSnapshot = List.copyOf(leftHand);
        List<Card> rightSnapshot = List.copyOf(rightHand);
        // 使用可修改列表才能直接观察到错误的原地排序行为。
        comparator.compare(leftHand, rightHand);
        assertEquals(leftSnapshot, leftHand);
        assertEquals(rightSnapshot, rightHand);
    }

    @Test
    void rejectsHandsWithWrongCardCount() {
        List<Card> leftHand = List.of(
                new Card(Rank.ACE, Suit.SPADES),
                new Card(Rank.NINE, Suit.DIAMONDS),
                new Card(Rank.SEVEN, Suit.SPADES),
                new Card(Rank.FOUR, Suit.CLUBS)
        );
        List<Card> rightHand = List.of(
                new Card(Rank.ACE, Suit.SPADES),
                new Card(Rank.NINE, Suit.DIAMONDS),
                new Card(Rank.SEVEN, Suit.SPADES),
                new Card(Rank.FOUR, Suit.CLUBS),
                new Card(Rank.TWO, Suit.HEARTS),
                new Card(Rank.THREE, Suit.HEARTS)
        );
        List<Card> hand = List.of(
                new Card(Rank.ACE, Suit.SPADES),
                new Card(Rank.NINE, Suit.DIAMONDS),
                new Card(Rank.SEVEN, Suit.SPADES),
                new Card(Rank.FOUR, Suit.CLUBS),
                new Card(Rank.THREE, Suit.HEARTS)
        );
        assertThrows(IllegalArgumentException.class, () -> comparator.compare(leftHand, hand));
        assertThrows(IllegalArgumentException.class, () -> comparator.compare(hand, rightHand));
    }

    @Test
    void rejectsDuplicateCardsWithinEitherHand() {
        List<Card> leftHand = List.of(
                new Card(Rank.ACE, Suit.SPADES),
                new Card(Rank.NINE, Suit.DIAMONDS),
                new Card(Rank.SEVEN, Suit.SPADES),
                new Card(Rank.FOUR, Suit.CLUBS),
                new Card(Rank.ACE, Suit.SPADES) // 重复牌
        );
        List<Card> rightHand = List.of(
                new Card(Rank.ACE, Suit.SPADES),
                new Card(Rank.NINE, Suit.DIAMONDS),
                new Card(Rank.SEVEN, Suit.SPADES),
                new Card(Rank.FOUR, Suit.CLUBS),
                new Card(Rank.NINE, Suit.DIAMONDS) // 重复牌
        );
        assertThrows(IllegalArgumentException.class, () -> comparator.compare(leftHand, aceHighHand()));
        assertThrows(IllegalArgumentException.class, () -> comparator.compare(aceHighHand(), rightHand));
    }

    @Test
    void rejectsNullHandsAndNullCards() {
        assertThrows(NullPointerException.class, () -> comparator.compare(null, aceHighHand()));
        assertThrows(NullPointerException.class, () -> comparator.compare(aceHighHand(), null));
        // 输入数据在 assertThrows 外准备，避免误把 List.of 拒绝 null 当成比较器的行为。
        List<Card> handWithNull = new ArrayList<>(aceHighHand());
        handWithNull.set(2, null);
        assertThrows(NullPointerException.class, () -> comparator.compare(handWithNull, aceHighHand()));
        assertThrows(NullPointerException.class, () -> comparator.compare(aceHighHand(), handWithNull));
    }

    // 混合花色且不构成顺子；故意乱序，便于发现依赖输入顺序的实现。
    private List<Card> aceHighHand() {
        return List.of(
                new Card(Rank.FOUR, Suit.CLUBS),
                new Card(Rank.ACE, Suit.SPADES),
                new Card(Rank.TWO, Suit.HEARTS),
                new Card(Rank.NINE, Suit.DIAMONDS),
                new Card(Rank.SEVEN, Suit.SPADES)
        );
    }

    private List<Card> kingHighHand() {
        return List.of(
                new Card(Rank.QUEEN, Suit.SPADES),
                new Card(Rank.THREE, Suit.DIAMONDS),
                new Card(Rank.KING, Suit.HEARTS),
                new Card(Rank.JACK, Suit.CLUBS),
                new Card(Rank.EIGHT, Suit.HEARTS)
        );
    }
}
