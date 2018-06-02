package kalah.game;

import kalah.data.SowResults;

public interface RepeatTurnRule {

    public int doRepeatTurn(SowResults sowResults, int currentPlayer);
}
