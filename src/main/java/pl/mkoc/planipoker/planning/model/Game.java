package pl.mkoc.planipoker.planning.model;

import java.util.HashSet;
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
        this.thrownCards = new HashSet<>();
    }

    void throwCard(Player player, Card card) {
        if (this.finished) {
            throw PlanningErrors.GAME_FINISHED.error();
        }
        thrownCards.add(new ThrownCard(player, card));
    }

    void changeCard(Player player, Card card) {
        if (this.finished) {
            throw PlanningErrors.GAME_FINISHED.error();
        }
        thrownCards.stream()
                .filter(c -> c.getPlayer().equals(player))
                .forEach(c -> c.changeCard(card));
    }

    void finish() {
        this.finished = true;
    }
}
