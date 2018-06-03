package kalah.game.pieces;

import kalah.data.SowResults;
import kalah.game.rules.SwitchTurnRule;

public class StandardSwitchTurnRule implements SwitchTurnRule {

    public void enforceRule(SowResults result, Player p1, Player p2, Player playerWithTurn) {
        if (!result.endedInStore() || !result.getEndingPlayer().equals(playerWithTurn.provideName())) {
            switchTurn(p1, p2);

        }
    }

    private void switchTurn(Player p1, Player p2) {
        if (p1.isMyTurn()) {
            p1.takeAwayTurn();
            p2.giveTurn();
        } else {
            p2.takeAwayTurn();
            p1.giveTurn();
        }
    }

}
