package kalah.game;

import kalah.data.SowResults;

public class StandRepeatTurnRule implements RepeatTurnRule {

    public int doRepeatTurn(SowResults result, int currentPlayer) {
        if (!result.endedInStore() || result.getEndingBoardSide() != currentPlayer) {
            int nextPlayer = (currentPlayer == 0) ? 1 : 0;
            return nextPlayer;
        }
    }

}
