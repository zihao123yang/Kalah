package kalah.game;

import kalah.data.SowResults;

public class StandRepeatTurnRule implements RepeatTurnRule {

    public int doRepeatTurn(SowResults result, int currentPlayer) {
        return 2;
    }

}
