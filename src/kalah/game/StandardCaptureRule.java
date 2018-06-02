package kalah.game;

import kalah.data.SowResults;

public class StandardCaptureRule implements CaptureRule {

    public void doCapture(SowResults result , int currentPlayer, GameBoard gameBoard) {
        if (result.lastHouseEmpty() && result.getEndingBoardSide() == currentPlayer) {
            gameBoard.capture(currentPlayer, result.lastHouseSowed());
        }

    }
}
