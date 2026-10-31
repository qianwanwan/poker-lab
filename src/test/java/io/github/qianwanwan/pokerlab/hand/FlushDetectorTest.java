package io.github.qianwanwan.pokerlab.hand;

import io.github.qianwanwan.pokerlab.card.Card;
import io.github.qianwanwan.pokerlab.card.Rank;
import io.github.qianwanwan.pokerlab.card.Suit;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FlushDetectorTest {
    private final FlushDetector detector = new FlushDetector();

    @Test
    void detectsFlushFeatureIncludingStraightFlush() {
        assertTrue(detector.hasFlush(spadeHand()));
        assertTrue(detector.hasFlush(straightFlushHand()));
    }

    @Test
    void aDifferentSuitAtAnyPositionPreventsFlush() {
        for (int position = 0; position < 5; position++) {
            List<Card> hand = new ArrayList<>(spadeHand());
            Card original = hand.get(position);
            hand.set(position, new Card(original.rank(), Suit.HEARTS));
            assertFalse(detector.hasFlush(hand), "异色牌位置：" + position);
        }
    }

    private List<Card> spadeHand() {
        return List.of(
                new Card(Rank.ACE, Suit.SPADES),
                new Card(Rank.NINE, Suit.SPADES),
                new Card(Rank.SEVEN, Suit.SPADES),
                new Card(Rank.FOUR, Suit.SPADES),
                new Card(Rank.TWO, Suit.SPADES)
        );
    }

    private List<Card> straightFlushHand() {
        return List.of(
                new Card(Rank.NINE, Suit.SPADES),
                new Card(Rank.EIGHT, Suit.SPADES),
                new Card(Rank.SEVEN, Suit.SPADES),
                new Card(Rank.SIX, Suit.SPADES),
                new Card(Rank.FIVE, Suit.SPADES)
        );
    }
}
