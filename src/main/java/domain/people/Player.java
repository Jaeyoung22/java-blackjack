package domain.people;

import java.util.ArrayList;
import java.util.List;

import domain.card.Card;
import domain.game.BetAmount;
import domain.game.ProfitRatio;
import view.ErrorMessage;

public final class Player {
    private static final int MAX_PLAYER_NAME_LENGTH = 10;
    private static final int BLACKJACK_VALUE = 21;
    private static final String COMMA = ",";
    private static final int BLACKJACK_HAND_VALUE = -1;

    private final Participant participant;
    private BetAmount betAmount;

    public Player(final String name) {
        validate(name);
        participant = new Participant(new ArrayList<>(), name);
    }

    private void validate(final String name) {
        validateNotNull(name);
        validateNotEmpty(name);
        validateNoDealer(name);
        validateDoesNotContainComma(name);
        validateNameLength(name);
    }

    private void validateNotNull(final String name) {
        if (name == null) {
            throw new IllegalArgumentException(ErrorMessage.NAME_IS_NULL.getMessage());
        }
    }

    private void validateNotEmpty(final String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.NAME_IS_EMPTY.getMessage());
        }
    }

    private void validateNoDealer(final String name) {
        if (InvalidNames.isInvalidNames(name)) {
            throw new IllegalArgumentException(ErrorMessage.NAME_IS_DEALER.getMessage());
        }
    }

    private void validateDoesNotContainComma(final String name) {
        if (name.contains(COMMA)) {
            throw new IllegalArgumentException(ErrorMessage.NAME_CONTAINS_COMMA.getMessage());
        }
    }

    private void validateNameLength(final String name) {
        if (name.length() > MAX_PLAYER_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NAME_LENGTH.getMessage());
        }
    }

    public String fetchPlayerName() {
        return participant.getName();
    }

    public boolean hasBlackJack(final int initHandCount) {
        return participant.fetchHandValue() == BLACKJACK_VALUE && participant.fetchHand().size() == initHandCount;
    }

    public void receiveCard(final Card card) {
        participant.receiveCard(card);
    }

    public List<Card> fetchHand() {
        return participant.fetchHand();
    }

    public int fetchHandValue(final int initHandCount) {
        int handValue = participant.fetchHandValue();
        if (hasBlackJack(initHandCount)) {
            handValue = BLACKJACK_HAND_VALUE;
        }
        return handValue;
    }

    public boolean isBust() {
        return participant.isBust();
    }

    public void assignBetAmount(final int betAmount) {
        this.betAmount = new BetAmount(betAmount);
    }

    public int fetchProfit(final int initHandCount, final int dealerHandValue) {
        return betAmount.calculateProfit(
            ProfitRatio.fetchProfitRatio(
                fetchHandValue(initHandCount), dealerHandValue));
    }
}
