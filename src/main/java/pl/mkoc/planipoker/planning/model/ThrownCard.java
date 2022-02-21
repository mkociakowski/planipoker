package pl.mkoc.planipoker.planning.model;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@EqualsAndHashCode(of = "player")
class ThrownCard {
    @Getter
    private Player player;
    private Card card;

    void changeCard(Card card) {
        this.card = card;
    }
}
