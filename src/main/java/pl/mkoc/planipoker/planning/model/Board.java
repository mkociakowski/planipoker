package pl.mkoc.planipoker.planning.model;

import java.util.Set;
import java.util.UUID;

class Board {
    private UUID session;
    private Set<Game> games;
    private Set<Player> players;

    Board(UUID session) {
        this.session = session;
    }

    void registerPlayer(Player player) {
        this.players.add(player);
    }

    void newGame(Game game) {
        this.games.add(game);
    }
}
