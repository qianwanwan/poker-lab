package io.github.qianwanwan.pokerlab.hand;

import io.github.qianwanwan.pokerlab.card.Card;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

/** 比较器与特征检测器共用的五张牌输入约定。 */
final class FiveCardHandValidator {
    private FiveCardHandValidator() {
    }

    static void validate(List<Card> hand) {
        Objects.requireNonNull(hand, "手牌列表不能为 null");
        for (Card card : hand) {
            Objects.requireNonNull(card, "手牌中的每张牌不能为 null");
        }
        if (hand.size() != 5) {
            throw new IllegalArgumentException("手牌必须包含五张牌");
        }
        if (new HashSet<>(hand).size() != 5) {
            throw new IllegalArgumentException("手牌内不能有重复的牌");
        }
    }
}
