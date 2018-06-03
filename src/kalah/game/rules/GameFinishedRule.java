package kalah.game.rules;

import kalah.data.GameBoardRepresentation;

public interface GameFinishedRule {

    public boolean enforceRule(GameBoardRepresentation boardRepresentation, int playerNumber);

}
