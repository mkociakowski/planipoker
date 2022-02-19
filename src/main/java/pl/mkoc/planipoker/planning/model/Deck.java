package pl.mkoc.planipoker.planning.model;

import java.util.Set;

interface Deck {
    String getType();
    Set<Card> getCards();
}
