package io.github.qianwanwan.pokerlab.card;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RankTest {
    @Test
    void sortingByPokerValueFollowsPokerOrder() {
        List<Rank> ranks = new ArrayList<>();
        ranks.add(Rank.ACE);
        ranks.add(Rank.TWO);
        ranks.add(Rank.THREE);
        ranks.add(Rank.FOUR);
        ranks.add(Rank.FIVE);
        ranks.add(Rank.SIX);
        ranks.add(Rank.SEVEN);
        ranks.add(Rank.EIGHT);
        ranks.add(Rank.NINE);
        ranks.add(Rank.TEN);
        ranks.add(Rank.JACK);
        ranks.add(Rank.QUEEN);
        ranks.add(Rank.KING);

        ranks.sort(Comparator.comparingInt(Rank::pokerValue));

        // 排序会修改列表，所以使用 ArrayList 承载测试输入。
        assertEquals(Rank.TWO, ranks.get(0));
        assertEquals(Rank.THREE, ranks.get(1));
        assertEquals(Rank.FOUR, ranks.get(2));
        assertEquals(Rank.FIVE, ranks.get(3));
        assertEquals(Rank.SIX, ranks.get(4));
        assertEquals(Rank.SEVEN, ranks.get(5));
        assertEquals(Rank.EIGHT, ranks.get(6));
        assertEquals(Rank.NINE, ranks.get(7));
        assertEquals(Rank.TEN, ranks.get(8));
        assertEquals(Rank.JACK, ranks.get(9));
        assertEquals(Rank.QUEEN, ranks.get(10));
        assertEquals(Rank.KING, ranks.get(11));
        assertEquals(Rank.ACE, ranks.get(12));
    }

    @Test
    void pokerValuesAreUniqueAndCoverTwoThroughFourteen() {
        Set<Integer> uniqueValues = new HashSet<>();
        for (Rank rank : Rank.values()) {
            int value = rank.pokerValue();
            assertTrue(value >= 2 && value <= 14);
            uniqueValues.add(value);
        }
        // 区间内只有十三个整数，十三个不同值即可验证完整覆盖。
        assertEquals(13, uniqueValues.size());
    }
}
