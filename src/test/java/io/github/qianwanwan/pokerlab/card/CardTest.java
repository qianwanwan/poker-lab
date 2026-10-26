package io.github.qianwanwan.pokerlab.card;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CardTest {
    @Test
    void exposesRankAndSuit() {
        Card card = new Card(Rank.ACE, Suit.SPADES);
        assertEquals(Rank.ACE, card.rank());
        assertEquals(Suit.SPADES, card.suit());
    }

    @Test
    void sameRankAndSuitAreEqual() {
        Card card1 = new Card(Rank.ACE, Suit.SPADES);
        Card card2 = new Card(Rank.ACE, Suit.SPADES);
        assertEquals(card1, card2);
        assertEquals(card1.hashCode(), card2.hashCode());
    }

    @Test
    void differentRanksAreNotEqual() {
        Card card1 = new Card(Rank.ACE, Suit.SPADES);
        Card card2 = new Card(Rank.KING, Suit.SPADES);
        assertNotEquals(card1, card2);
    }

    @Test
    void differentSuitsAreNotEqual() {
        Card card1 = new Card(Rank.ACE, Suit.SPADES);
        Card card2 = new Card(Rank.ACE, Suit.HEARTS);
        assertNotEquals(card1, card2);
    }

    @Test
    void rejectsNullRank() {
        assertThrows(NullPointerException.class, () -> new Card(null, Suit.SPADES));
    }

    @Test
    void rejectsNullSuit() {
        assertThrows(NullPointerException.class, () -> new Card(Rank.ACE, null));
    }
}
