package kalah.game;

import kalah.data.SowResults;

public interface CaptureRule {

    public void doCapture(SowResults sowResults, Player p1, Player p2, GameBoard gameBoard);


}
