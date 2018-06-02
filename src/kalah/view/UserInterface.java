package kalah.view;

import kalah.data.GameBoardRepresentation;

/**
 * Created by zihaoyang on 4/05/18.
 *
 * This interface should be implemented by any classes used to display the game state and obtain user input
 */
public interface UserInterface {

    public void showBoard(GameBoardRepresentation gameBoardRepresentation);

    public int turnPrompt(String playerName, int numHousesPerPlayer);

    public void emptyHousePrompt();

    public void gameFinishedPrompt();

    public void finalScoresPrompt(int[] finalScores);
}
