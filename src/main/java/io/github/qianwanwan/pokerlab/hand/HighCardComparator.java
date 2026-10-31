package io.github.qianwanwan.pokerlab.hand;

import io.github.qianwanwan.pokerlab.card.Card;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 比较两手已确认属于高牌牌型的牌；牌型识别由后续评估器负责。
 * 忽略花色和输入顺序，保持调用方的列表不变。
 */
public class HighCardComparator implements Comparator<List<Card>> {
    /**
     * 返回正数表示左手更强，负数表示右手更强，零表示点数完全相同。
     *
     * @throws NullPointerException 任一列表或其中的牌为 null
     * @throws IllegalArgumentException 任一手牌不是五张，或同一手内有重复牌
     */
    @Override
    public int compare(List<Card> left, List<Card> right) {
        FiveCardHandValidator.validate(left);
        FiveCardHandValidator.validate(right);

        List<Card> leftSorted = new ArrayList<>(left);
        leftSorted.sort((c1, c2) -> Integer.compare(c2.rank().pokerValue(), c1.rank().pokerValue()));
        List<Card> rightSorted = new ArrayList<>(right);
        rightSorted.sort((c1, c2) -> Integer.compare(c2.rank().pokerValue(), c1.rank().pokerValue()));

        for (int i = 0; i < 5; i++) {
            int result = Integer.compare(leftSorted.get(i).rank().pokerValue(), rightSorted.get(i).rank().pokerValue());
            if (result != 0) {
                return result;
            }
        }
        return 0;
    }

}
