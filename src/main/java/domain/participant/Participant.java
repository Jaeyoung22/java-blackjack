package domain.participant;

import domain.card.Card;
import domain.card.Cards;
import domain.card.Deck;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import utils.ExceptionMessages;

public abstract class Participant {

    protected Cards cards;
    protected final Name name;

    public Participant(String name) {
        this.cards = Cards.of(new ArrayList<>());
        this.name = new Name(name);
    }

    public abstract boolean canHit();

    public void hit(Deck deck) {
        if (!canHit()) {
            throw new IllegalStateException(ExceptionMessages.OVER_CARD_LIMIT_ERROR);
        }
        this.cards = cards.addCard(deck.handOut());
    }

    public void pickTwoCards(Deck deck) {
        this.cards = cards.addCards(deck.handOutCards());
    }

    public int calculateScore() {
        return cards.calculateScore();
    }

    protected boolean isBust() {
        return cards.isBust();
    }

    public String getName() {
        return name.getValue();
    }

    public List<Card> getCards() {
        return Collections.unmodifiableList(cards.getCards());
    }

}