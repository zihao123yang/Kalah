package kalah.game;

import kalah.data.SowResults;
import kalah.view.ASCIIUserInterface;

/**
 * Created by zihaoyang on 25/04/18.
 *
 * This class is responsible for managing the flow of the game, and for enforcing the high level rules of Kalah
 */
public class GameManager {

    private static final String DEFAULT_PLAYER1_NAME = "P1";
    private static final String DEFAULT_PLAYER2_NAME = "P2";

    public enum GameState {
        RUNNING, QUIT, FINISHED;
    }

    private GameBoard _gameBoard;
    private ASCIIUserInterface _userInterface;
    private int _currentPlayerIndex;
    private GameState _gameState;
    private String[] _players;


    public GameManager(ASCIIUserInterface userInterface) {
        _gameBoard = new GameBoard();
        _userInterface = userInterface;
        _currentPlayerIndex = 0;
        _gameState = GameState.RUNNING;
        _players = new String[2];
        _players[0] = DEFAULT_PLAYER1_NAME;
        _players[1] = DEFAULT_PLAYER2_NAME;
    }

    public void play() {
        while (_gameState == GameState.RUNNING) {
            _userInterface.showBoard(_gameBoard.createBoardRepresentation(), _players[0], _players[1]);

            if (_gameBoard.isCurrentSideEmpty(_currentPlayerIndex)) {
                _gameState = GameState.FINISHED;
            } else {
                int playerInput = _userInterface.turnPrompt(_players[_currentPlayerIndex], _gameBoard.getNumHousesPerPlayer());
                if (playerInput == -1) {
                    _gameState = GameState.QUIT;
                } else if (_gameBoard.isPlayerHouseEmpty(playerInput - 1, _currentPlayerIndex)) {
                    _userInterface.emptyHousePrompt();
                } else {
                    executeMove(playerInput);
                }
            }
        }

        _userInterface.gameFinishedPrompt();
        _userInterface.showBoard(_gameBoard.createBoardRepresentation(), _players[0], _players[1]);

        if (_gameState == GameState.FINISHED) {
            _userInterface.finalScoresPrompt(_gameBoard.getFinalScores());
        }

    }

    private void executeMove(int playerInput) {
        SowResults result = _gameBoard.sow(_currentPlayerIndex, playerInput - 1);

        if (result.lastHouseEmpty() && result.getEndingBoardSide() == _currentPlayerIndex) {
            _gameBoard.capture(_currentPlayerIndex, result.lastHouseSowed());
        }

        if (!result.endedInStore() || result.getEndingBoardSide() != _currentPlayerIndex) {
            _currentPlayerIndex = (_currentPlayerIndex == 0) ? 1 : 0;
        }

    }

}
