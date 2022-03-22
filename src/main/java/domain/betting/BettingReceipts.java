package domain.betting;

import domain.participant.Name;
import java.util.Map;

public class BettingReceipts {

    private static final String ABSENT_NAME_ERROR_MESSAGE_FORMAT = "[Error] \"%s\" : 이름이 존재하지 않습니다.";

    private final Map<Name, BettingMoney> maps;

    public BettingReceipts(Map<Name, BettingMoney> maps) {
        this.maps = Map.copyOf(maps);
    }

    public BettingMoney getBettingMoney(Name name) {
        if (!maps.containsKey(name)) {
            throw new IllegalArgumentException(String.format(ABSENT_NAME_ERROR_MESSAGE_FORMAT, name.getValue()));
        }
        return maps.get(name);
    }
}