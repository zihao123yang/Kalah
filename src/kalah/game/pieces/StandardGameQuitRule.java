package kalah.game.pieces;

import kalah.game.rules.GameQuitRule;

public class StandardGameQuitRule implements GameQuitRule {

    public boolean enforceRule(int playerInput) {
        if (playerInput == -1) {
            return true;
        } else {
            return false;
        }
    }
}
