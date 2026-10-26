package io.github.qianwanwan.pokerlab.card;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    private final List<Card> cards = new ArrayList<>();

    public Deck() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(rank, suit));
            }
        }
    }

    public int size() {
        return cards.size();
    }

    /** 返回当前牌序的只读快照，后续牌堆变化不会影响该列表。 */
    public List<Card> cards() {
        return List.copyOf(cards);
    }
}
