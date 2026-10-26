package io.github.qianwanwan.pokerlab.card;

import java.util.Objects;

public record Card(Rank rank, Suit suit) {
    public Card {
        Objects.requireNonNull(rank, "Rank cannot be null");
        Objects.requireNonNull(suit, "Suit cannot be null");
    }
}
