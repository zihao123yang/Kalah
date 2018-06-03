package kalah.game;

import kalah.data.SowResults;

public class StandardCaptureRule implements CaptureRule {

    public void doCapture(SowResults result , Player p1, Player p2, GameBoard gameBoard) {
        Player playerWithTurn = playerWithTurn(p1, p2);
        if (result.lastHouseEmpty() && result.getEndingPlayer().equals(playerWithTurn.provideName())) {
            gameBoard.capture(playerWithTurn.providePlayerNumber(), result.lastHouseSowed());
        }

    }

    private Player playerWithTurn(Player p1, Player p2) {
        if (p2.isMyTurn()) {
            return p2;
        } else {
            return p1;
        }
    }
}
