package kalah.game.pieces;

import kalah.data.SowResults;
import kalah.game.rules.CaptureRule;

public class StandardCaptureRule implements CaptureRule {

    public void enforceRule(SowResults result , Player p1, Player p2, Player playerWithTurn, GameBoard gameBoard) {
        if (result.lastHouseEmpty() && result.getEndingPlayer().equals(playerWithTurn.provideName())) {
            gameBoard.capture(playerWithTurn.providePlayerNumber(), result.lastHouseSowed());
        }

    }
}
