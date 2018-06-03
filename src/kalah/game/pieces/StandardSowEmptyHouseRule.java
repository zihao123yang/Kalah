package kalah.game.pieces;

import kalah.data.GameBoardRepresentation;
import kalah.game.rules.SowEmptyHouseRule;

public class StandardSowEmptyHouseRule implements SowEmptyHouseRule {
    public boolean enforceRule(GameBoardRepresentation boardRepresentation, int playerInput, Player playWithTurn) {
        return boardRepresentation.ishouseEmpty(playerInput - 1, playWithTurn.providePlayerNumber());
    }

}
