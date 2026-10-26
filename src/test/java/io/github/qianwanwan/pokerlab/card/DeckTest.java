package io.github.qianwanwan.pokerlab.card;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
}
