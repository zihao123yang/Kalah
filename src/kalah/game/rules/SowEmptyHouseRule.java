package kalah.game.rules;

import kalah.data.GameBoardRepresentation;
import kalah.game.pieces.Player;

public interface SowEmptyHouseRule {

    public boolean enforceRule(GameBoardRepresentation boardRepresentation, int playerInput, Player playerWithTurn);
}
