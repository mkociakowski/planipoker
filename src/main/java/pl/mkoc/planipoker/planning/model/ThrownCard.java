package pl.mkoc.planipoker.planning.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
class ThrownCard {
    private Player player;
    private Card card;
}
