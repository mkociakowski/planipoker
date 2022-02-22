package pl.mkoc.planipoker.planning.model;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

class Game {
    private UUID id;
    private String title;
    private String description;
    private Deck deck;
    private Map<Player, Card> thrownCards;
    private boolean finished;

    Game(String title, String description, Deck deck) {
        if (title == null || title.isEmpty()) {
            throw PlanningErrors.GAME_TITLE_EMPTY.error();
        }
        if (deck == null) {
            throw PlanningErrors.GAME_DECK_EMPTY.error();
        }

        this.id = UUID.randomUUID();
        this.thrownCards = new HashMap<>();
        this.title = title;
        this.description = description;
        this.deck = deck;
    }

    void throwCard(Player player, Card card) {
        if (finished) {
            throw PlanningErrors.GAME_FINISHED.error();
        }
        if (thrownCards.containsKey(player)) {
            throw PlanningErrors.GAME_PLAYER_ALREADY_THROW_CARD.error();
        }
        thrownCards.put(player, card);
    }

    void changeCard(Player player, Card card) {
        if (finished) {
            throw PlanningErrors.GAME_FINISHED.error();
        }
        if (!thrownCards.containsKey(player)) {
            throw PlanningErrors.GAME_CHANGE_NOT_THROWN_CARD.error();
        }
        thrownCards.replace(player, card);
    }

    void finish() {
        if (finished) {
            throw PlanningErrors.GAME_FINISHED.error();
        }
        this.finished = true;
    }
}
