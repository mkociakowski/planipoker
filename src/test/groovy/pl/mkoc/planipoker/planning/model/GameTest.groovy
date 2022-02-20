package pl.mkoc.planipoker.planning.model

import spock.lang.Specification

class GameTest extends Specification {
    def "player thrown with success card"() {
        given:
        var deck = Mock(Deck)
        var game = new Game("ZAD-1234", "", deck)
        var player = new Player("JohnQ")
        var card = new Card("2", 2)
        when:
        game.throwCard(player, card)
        then:
        game.thrownCards.size() == 1
    }

    def "player change his card with success - not implemented"() {
        given:
        var deck = Mock(Deck)
        var game = new Game("ZAD-1234", "", deck)
        var player = new Player("John")
        var card = new Card("2", 2)
        when:
        game.changeCard(player, card)
        then:
        thrown(UnsupportedOperationException)
    }

    def "game is finished with success"() {
        given:
        var game = new Game("ZAD-1234", "", Mock(Deck))
        when:
        game.finish()
        then:
        game.finished
    }
}
