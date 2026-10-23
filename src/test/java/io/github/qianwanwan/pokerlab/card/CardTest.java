package io.github.qianwanwan.pokerlab.card;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CardTest {
    // 每个测试按“准备数据 → 执行操作 → 断言结果”填写。
    // 写完对应断言后，删除该方法里的 fail；它用于明确标记尚未完成的测试。

    @Test
    void exposesRankAndSuit() {
        // 创建一张黑桃 A，分别用 assertEquals 检查 rank() 和 suit()。
        Card card = new Card(Rank.ACE, Suit.SPADES);
        assertEquals(Rank.ACE, card.rank());
        assertEquals(Suit.SPADES, card.suit());
    }

    @Test
    void sameRankAndSuitAreEqual() {
        // 分别 new 两张黑桃 A，用 assertEquals 检查两个对象相等。
        Card card1 = new Card(Rank.ACE, Suit.SPADES);
        Card card2 = new Card(Rank.ACE, Suit.SPADES);
        assertEquals(card1, card2);
        // TODO：再检查两个对象的 hashCode() 相等。
        assertEquals(card1.hashCode(), card2.hashCode());
    }

    @Test
    void differentRanksAreNotEqual() {
        // 比较黑桃 A 和黑桃 K，用 assertNotEquals 检查两者不相等。
        Card card1 = new Card(Rank.ACE, Suit.SPADES);
        Card card2 = new Card(Rank.KING, Suit.SPADES);
        assertNotEquals(card1, card2);
    }

    @Test
    void differentSuitsAreNotEqual() {
        // 比较黑桃 A 和红桃 A，用 assertNotEquals 检查两者不相等。
        Card card1 = new Card(Rank.ACE, Suit.SPADES);
        Card card2 = new Card(Rank.ACE, Suit.HEARTS);
        assertNotEquals(card1, card2);
    }

    @Test
    void rejectsNullRank() {
        // 花色使用合法值，点数传 null。
        // 第二个参数用 () -> ...，把构造 Card 的操作交给 JUnit 执行。
        assertThrows(NullPointerException.class, () -> new Card(null, Suit.SPADES));
    }

    @Test
    void rejectsNullSuit() {
        // 点数使用合法值，花色传 null。
        assertThrows(NullPointerException.class, () -> new Card(Rank.ACE, null));
    }
}
