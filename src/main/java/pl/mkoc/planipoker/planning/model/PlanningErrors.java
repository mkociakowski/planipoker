package pl.mkoc.planipoker.planning.model;

import lombok.AllArgsConstructor;
import pl.mkoc.planipoker.kernel.DomainError;

@AllArgsConstructor
enum PlanningErrors {
    GAME_FINISHED("Game is finished, cant throw or change card");

    private final String description;

    DomainError error() {
        return new DomainError(name(), description);
    }
}
