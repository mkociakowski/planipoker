package pl.mkoc.planipoker.planning.model;

import lombok.AllArgsConstructor;
import pl.mkoc.planipoker.kernel.DomainError;

@AllArgsConstructor
enum PlanningErrors {
    GAME_FINISHED("Game is finished, can't finish, throw or change card"),
    GAME_CHANGE_NOT_THROWN_CARD("Changing not thrown card"),
    GAME_PLAYER_ALREADY_THROW_CARD("Player already throw card"),
    GAME_TITLE_EMPTY("Game title is null or empty"),
    GAME_DECK_EMPTY("Game deck is null")
    ;

    private final String description;

    DomainError error() {
        return new DomainError(name(), description);
    }
}
