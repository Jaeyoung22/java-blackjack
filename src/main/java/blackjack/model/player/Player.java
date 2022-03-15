package blackjack.model.player;

import blackjack.model.Card;
import blackjack.model.Cards;
import blackjack.model.Score;
import java.util.List;

public abstract class Player {

    protected final Cards cards;
    private final String name;

    public Player(String name, Cards cards) {
        this.name = name;
        this.cards = cards;
    }

    public String getName() {
        return name;
    }

    public Cards getCards() {
        return cards;
    }

    public void take(Card card) {
        if (!isHittable()) {
            throw new IllegalStateException("카드를 더 이상 발급 받을 수 없습니다.");
        }
        cards.takeCard(card);
    }

    public Score score() {
        return cards.bestScore();
    }

    public abstract List<Card> openCards();

    public abstract boolean isHittable();
}