package io.github.qianwanwan.pokerlab.card;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DeckTest {
    @Test
    void newDeckContainsExactly52DistinctCards() {
        Deck deck = new Deck();
        List<Card> cards = deck.cards();
        assertEquals(52, cards.size());
        assertEquals(52, deck.size());
        for (Card card : cards) {
            assertNotNull(card);
        }
        // 数量正确仍可能有重复，需同时验证不同牌的数量。
        assertEquals(52, new HashSet<>(cards).size());
    }

    @Test
    void cardsCannotBeModifiedExternally() {
        Deck deck = new Deck();
        // 在异常断言外取得列表，确保检查的是修改操作抛出的异常。
        List<Card> cards = deck.cards();
        assertThrows(UnsupportedOperationException.class, cards::clear);
        assertEquals(52, deck.size());
    }

    @Test
    void drawReturnsAndRemovesLastCard() {
        Deck deck = new Deck();
        List<Card> snapshot = deck.cards();
        Card expectedCard = snapshot.get(snapshot.size() - 1);
        Card drawnCard = deck.draw();
        assertEquals(expectedCard, drawnCard);
        assertEquals(51, deck.size());
        assertFalse(deck.cards().contains(drawnCard));
    }

    @Test
    void drawingAllCardsReturnsEveryOriginalCardExactlyOnce() {
        Deck deck = new Deck();
        Set<Card> expectedCards = new HashSet<>(deck.cards());
        Set<Card> drawnCards = new HashSet<>();
        for (int i = 0; i < 52; i++) {
            drawnCards.add(deck.draw());
        }
        assertEquals(expectedCards, drawnCards);
        assertEquals(0, deck.size());
    }

    @Test
    void drawingFromEmptyDeckThrowsWithoutChangingState() {
        Deck deck = new Deck();
        for (int i = 0; i < 52; i++) {
            deck.draw();
        }
        List<Card> emptySnapshot = deck.cards();
        assertThrows(IllegalStateException.class, deck::draw);
        assertEquals(0, deck.size());
        assertEquals(emptySnapshot, deck.cards());
    }

    @Test
    void drawingDoesNotChangePreviouslyReturnedSnapshot() {
        Deck deck = new Deck();
        List<Card> initialSnapshot = deck.cards();
        deck.draw();
        // 只读视图仍可能随内部列表变化，因此需单独验证快照独立性。
        assertEquals(52, initialSnapshot.size());
        assertEquals(51, deck.size());
        assertEquals(51, deck.cards().size());
    }
}
