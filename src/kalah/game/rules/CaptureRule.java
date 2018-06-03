package kalah.game.rules;

import kalah.data.SowResults;
import kalah.game.pieces.GameBoard;
import kalah.game.pieces.Player;

public interface CaptureRule {

    public void enforceRule(SowResults sowResults, Player p1, Player p2, Player playerWithTurn, GameBoard gameBoard);


}
