package kalah.game;

import kalah.data.SowResults;

public interface CaptureRule {

    public void doCapture(SowResults sowResults, int currentPlayer, GameBoard gameBoard);


}
