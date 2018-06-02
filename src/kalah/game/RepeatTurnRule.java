package kalah.game;

import kalah.data.SowResults;

interface RepeatTurnRule {

    public int doRepeatTurn(SowResults sowResults, int currentPlayer);
}
