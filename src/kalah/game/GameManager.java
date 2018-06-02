package kalah.game;

import kalah.data.GameBoardRepresentation;
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
    private Player _p1;
    private Player _p2;
    private GameState _gameState;

    CaptureRule _captureRule;
    RepeatTurnRule _repeatTurnRule;
    GameQuitRule _gameQuitRule;
    GameFinishedRule _gameFinishedRule;


    public GameManager(ASCIIUserInterface userInterface, CaptureRule captureRule, RepeatTurnRule repeatTurnRule,
                       GameQuitRule gameQuitRule, GameFinishedRule gameFinishedRule) {
        _p1 = new Player("P1", 1);
        _p2 = new Player("P2", 2);
        _p1.giveTurn();
        _gameBoard = new GameBoard(_p1, _p2);
        _userInterface = userInterface;
        _gameState = GameState.RUNNING;

        _captureRule = captureRule;
        _repeatTurnRule = repeatTurnRule;
        _gameQuitRule = gameQuitRule;
        _gameFinishedRule = gameFinishedRule;
    }

    public void play() {
        while (_gameState == GameState.RUNNING) {
            GameBoardRepresentation boardRepresentation = _gameBoard.createBoardRepresentation();
            _userInterface.showBoard(boardRepresentation);

            if (_gameBoard.isCurrentSideEmpty(playerWithTurn().providePlayerNumber())) {
                _gameState = GameState.FINISHED;
            } else {
                int playerInput = _userInterface.turnPrompt(boardRepresentation, playerWithTurn().provideName());
                if (playerInput == -1) {
                    _gameState = GameState.QUIT;
                } else if (_gameBoard.isPlayerHouseEmpty(playerInput - 1, playerWithTurn().providePlayerNumber())) {
                    _userInterface.emptyHousePrompt();
                } else {
                    executeMove(playerInput);
                }
            }
        }

        _userInterface.gameFinishedPrompt();
        _userInterface.showBoard(_gameBoard.createBoardRepresentation());

        if (_gameState == GameState.FINISHED) {
            _userInterface.finalScoresPrompt(_gameBoard.getFinalScores());
        }

    }

    private void executeMove(int playerInput) {
        SowResults result = _gameBoard.sow(playerWithTurn().providePlayerNumber(), playerInput - 1);

        if (result.lastHouseEmpty() && result.getEndingPlayer().equals(playerWithTurn().provideName())) {
            _gameBoard.capture(playerWithTurn().providePlayerNumber(), result.lastHouseSowed());
        }

        if (!result.endedInStore() || !result.getEndingPlayer().equals(playerWithTurn().provideName())) {
            switchTurn();

        }

    }

    private void switchTurn() {
        if (_p1.isMyTurn()) {
            _p1.takeAwayTurn();
            _p2.giveTurn();
        } else {
            _p2.takeAwayTurn();
            _p1.giveTurn();
        }
    }

    private Player playerWithTurn() {
        if (_p2.isMyTurn()) {
            return _p2;
        } else {
            return _p1;
        }
    }
}
