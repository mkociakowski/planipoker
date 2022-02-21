package pl.mkoc.planipoker.planning.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode(of = "id")
@AllArgsConstructor
class Player {
    private final UUID id;
    private final String name;

    Player(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }
}
