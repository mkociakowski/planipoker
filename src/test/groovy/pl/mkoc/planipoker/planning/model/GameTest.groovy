package pl.mkoc.planipoker.planning.model

import pl.mkoc.planipoker.kernel.DomainError
import spock.lang.Specification

class GameTest extends Specification {
    def "create game without title or deck with thrown error"(String title, Deck deck, String error) {
        when:
            new Game(title, "", deck)
        then:
            var e = thrown(DomainError)
            e.code == error
        where:
            title | deck       | error
            ""    | Mock(Deck) | "GAME_TITLE_EMPTY"
            null  | Mock(Deck) | "GAME_TITLE_EMPTY"
            "Tit" | null       | "GAME_DECK_EMPTY"
    }

    def "player thrown card with success"() {
        given:
            var deck = Mock(Deck)
            var game = new Game("TASK-1234", "", deck)
            var player = new Player("JohnQ")
            var card = new Card("2", 2)
        when:
            game.throwCard(player, card)
        then:
            game.thrownCards.size() == 1
    }

    def "player can't throw card when game is finished"() {
        given:
            var deck = Mock(Deck)
            var game = new Game("TASK-1234", "", deck)
            game.finish()
            var player = new Player("JohnQ")
            var card = new Card("2", 2)
        when:
            game.throwCard(player, card)
        then:
            var e = thrown(DomainError)
            e.code == PlanningErrors.GAME_FINISHED.name()
    }

    def "player change his card with success"() {
        given:
            var deck = Mock(Deck)
            var game = new Game("TASK-1234", "", deck)
            var player = new Player("John")
            game.throwCard(player, new Card("2", 2))
            game.throwCard(new Player("Mel"), new Card("2", 2))
        when:
            game.changeCard(player, new Card("3", 3))
        then:
            game.thrownCards.size() == 2
            game.thrownCards.get(player).name == "3"
    }

    def "player can't change his card when game is finished"() {
        given:
            var deck = Mock(Deck)
            var game = new Game("TASK-1234", "", deck)
            var player = new Player("John")
            game.throwCard(player, new Card("2", 2))
            game.throwCard(new Player("Mel"), new Card("2", 2))
            game.finish()
        when:
            game.changeCard(player, new Card("3", 3))
        then:
            var e = thrown(DomainError)
            e.code == PlanningErrors.GAME_FINISHED.name()
    }

    def "game is finished with success"() {
        given:
            var game = new Game("TASK-1234", "", Mock(Deck))
        when:
            game.finish()
        then:
            game.finished
    }
}
