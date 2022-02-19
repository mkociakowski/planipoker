package pl.mkoc.planipoker.planning.model;

import java.util.UUID;

class Player {
    private UUID id;
    private String name;

    Player(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }
}
