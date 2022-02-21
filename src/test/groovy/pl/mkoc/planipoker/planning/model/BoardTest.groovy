package pl.mkoc.planipoker.planning.model

import spock.lang.Specification

class BoardTest extends Specification {
    def "players registered with success"() {
        given:
        var board = new Board(UUID.randomUUID())
        var player1 = new Player("John")
        var player2 = new Player("Tom")
        when:
        board.registerPlayer(player1)
        board.registerPlayer(player2)
        then:
        board.players.size() == 2
    }

    def "players removed with success"() {
        given:
        var board = new Board(UUID.randomUUID())
        var player1ID = UUID.randomUUID().toString()
        var player1 = new Player(UUID.fromString(player1ID), "John")
        board.registerPlayer(player1)
        board.registerPlayer(new Player("Tom"))
        board.registerPlayer(new Player("Mel"))
        when:
        board.removePlayer(new Player(UUID.fromString(player1ID), "John"))
        then:
        board.players.size() == 2
        !board.players.contains(player1)
    }

    def "new game created with success"() {
        given:
        var board = new Board(UUID.randomUUID())
        var game = new Game("TASK-1234", "", Mock(Deck))
        when:
        board.newGame(game)
        then:
        board.games.size() == 1
    }
}
