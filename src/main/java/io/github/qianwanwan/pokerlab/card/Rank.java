package io.github.qianwanwan.pokerlab.card;

public enum Rank {
    TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13), ACE(14);

    private final int pokerValue;

    Rank(int pokerValue) {
        this.pokerValue = pokerValue;
    }

    /** 普通牌力比较使用的点数值：2～14，A 为 14。 */
    public int pokerValue() {
        return this.pokerValue;
    }
}
