package kalah.game.pieces;

import kalah.data.GameBoardRepresentation;
import kalah.game.rules.GameFinishedRule;

public class StandardGameFinishedRule implements GameFinishedRule {

    public boolean enforceRule(GameBoardRepresentation boardRepresentation, int playerNumber) {
        return boardRepresentation.isSideEmpty(playerNumber);
    }
}
