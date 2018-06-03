package kalah.io;

import kalah.data.GameBoardRepresentation;

/**
 * Created by zihaoyang on 4/05/18.
 *
 * This interface should be implemented by any classes used to display the game state and obtain user input
 */
public interface UserInterface {

    void showBoard(GameBoardRepresentation gameBoardRepresentation);

    int turnPrompt(GameBoardRepresentation boardRepresentation, String currentPlayerName);

    void emptyHousePrompt();

    void gameFinishedPrompt();

    void finalScoresPrompt(int[] finalScores);
}
