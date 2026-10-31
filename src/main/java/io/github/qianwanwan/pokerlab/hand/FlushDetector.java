package io.github.qianwanwan.pokerlab.hand;

import io.github.qianwanwan.pokerlab.card.Card;
import io.github.qianwanwan.pokerlab.card.Suit;

import java.util.List;

public class FlushDetector {
    /**
     * 五张牌具有同花特征时返回 true；同花顺也满足此特征。
     *
     * @throws NullPointerException 列表或其中的牌为 null
     * @throws IllegalArgumentException 不是五张牌，或存在重复牌
     */
    public boolean hasFlush(List<Card> hand) {
        FiveCardHandValidator.validate(hand);
        Suit flushSuit = hand.get(0).suit();
        for (Card card : hand) {
            if (card.suit() != flushSuit) {
                return false;
            }
        }
        return true;
    }
}
