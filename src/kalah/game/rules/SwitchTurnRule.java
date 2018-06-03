package kalah.game.rules;

import kalah.data.SowResults;
import kalah.game.pieces.Player;

public interface SwitchTurnRule {

    public void enforceRule(SowResults sowResults, Player p1, Player p2, Player playWithTurn);
}
