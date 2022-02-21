package pl.mkoc.planipoker.planning.model;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

class Board {
    private UUID session;
    private Set<Game> games;
    private Set<Player> players;

    Board(UUID session) {
        this.session = session;
        this.games = new HashSet<>();
        this.players = new HashSet<>();
    }

    void registerPlayer(Player player) {
        this.players.add(player);
    }

    void removePlayer(Player player) {
        this.players.removeIf(p -> p.equals(player));
    }

    void newGame(Game game) {
        this.games.add(game);
    }
}
