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

    /**
     * 从列表末尾（牌顶）移除并返回一张牌。
     *
     * @throws IllegalStateException 牌堆为空，此时牌堆保持不变
     */
    public Card draw() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("牌堆为空");
        }
        return cards.remove(cards.size() - 1);
    }

    /** 返回当前牌序的只读快照，后续牌堆变化不会影响该列表。 */
    public List<Card> cards() {
        return List.copyOf(cards);
    }
}
