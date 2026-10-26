package io.github.qianwanwan.pokerlab.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Random;

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

    /**
     * 使用调用方提供的随机源，原地重排当前剩余的牌。
     * 空牌堆和单张牌堆保持原样。
     *
     * @throws NullPointerException random 为 null，此时牌堆保持不变
     */
    public void shuffle(Random random) {
        Objects.requireNonNull(random, "随机源不能为 null");
        Collections.shuffle(cards, random);
    }

    /** 返回当前牌序的只读快照，后续牌堆变化不会影响该列表。 */
    public List<Card> cards() {
        return List.copyOf(cards);
    }
}
