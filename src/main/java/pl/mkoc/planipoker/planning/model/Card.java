package pl.mkoc.planipoker.planning.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
class Card {
    private String name;
    private Integer weight;
}
