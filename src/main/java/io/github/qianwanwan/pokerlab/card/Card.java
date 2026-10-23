package io.github.qianwanwan.pokerlab.card;

import java.util.Objects;

public record Card(Rank rank, Suit suit) {
    public Card {
        // TODO 3：分别校验 rank 和 suit 非空，为空时抛出 NullPointerException。
        // 提示：使用 Objects.requireNonNull，并给出能识别对应参数的消息。
        // 这是 record 的紧凑构造器，编译器会在此代码执行后自动给字段赋值。
        Objects.requireNonNull(rank, "Rank cannot be null");
        Objects.requireNonNull(suit, "Suit cannot be null");
    }
}
