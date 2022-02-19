package pl.mkoc.planipoker.planning.model;

import java.util.Set;
import java.util.UUID;

class Game {
    private UUID id;
    private String title;
    private String description;
    private Deck deck;
    private Set<ThrownCard> thrownCards;
    private boolean finished;

    Game(String title, String description, Deck deck) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.description = description;
        this.deck = deck;
    }

    void throwCard(Player player, Card card) {
        thrownCards.add(new ThrownCard(player, card));
    }

    void changeCard(Player player, Card card) {
        ;
    }

    void finish() {
        this.finished = true;
    }
}
