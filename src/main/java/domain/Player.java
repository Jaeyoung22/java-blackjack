package domain;

import view.ErrorMessage;

public class Player {
    private final String name;

    public Player(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        validateNotNull(name);
        validateNotEmpty(name);
    }

    private void validateNotEmpty(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.NAME_IS_EMPTY.getMessage());
        }
    }

    private void validateNotNull(String name) {
        if (name == null) {
            throw new IllegalArgumentException(ErrorMessage.NAME_IS_NULL.getMessage());
        }
    }
}