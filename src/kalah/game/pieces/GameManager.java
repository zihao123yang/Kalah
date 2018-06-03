package kalah.game.pieces;

import kalah.data.GameBoardRepresentation;
import kalah.data.SowResults;
import kalah.io.UserInterface;
import kalah.game.rules.*;

/**
 * This class is responsible for managing the flow of the game, and for enforcing the high level rules of Kalah
 */
public class GameManager {

    public enum GameState {
        RUNNING, QUIT, FINISHED;
    }

    private GameBoard _gameBoard;
    private UserInterface _userInterface;
    private Player _p1;
    private Player _p2;
    private GameState _gameState;

    private CaptureRule _captureRule;
    private SwitchTurnRule _switchTurnRule;
    private GameQuitRule _gameQuitRule;
    private GameFinishedRule _gameFinishedRule;
    private SowEmptyHouseRule _sowEmptyHouseRule;


    public GameManager(UserInterface userInterface, CaptureRule captureRule, SwitchTurnRule switchTurnRule,
                       GameQuitRule gameQuitRule, GameFinishedRule gameFinishedRule, SowEmptyHouseRule sowEmptyHouseRule) {
        _p1 = new Player("P1", 1);
        _p2 = new Player("P2", 2);
        _p1.giveTurn();
        _gameBoard = new GameBoard(_p1, _p2);
        _userInterface = userInterface;
        _gameState = GameState.RUNNING;

        _captureRule = captureRule;
        _switchTurnRule = switchTurnRule;
        _gameQuitRule = gameQuitRule;
        _gameFinishedRule = gameFinishedRule;
        _sowEmptyHouseRule = sowEmptyHouseRule;
    }

    public void play() {
        while (_gameState == GameState.RUNNING) {
            GameBoardRepresentation boardRepresentation = _gameBoard.createBoardRepresentation();

            _userInterface.showBoard(boardRepresentation);

            if (_gameFinishedRule.enforceRule(boardRepresentation, playerWithTurn().providePlayerNumber())) {
                _gameState = GameState.FINISHED;

            } else {
                int playerInput = _userInterface.turnPrompt(boardRepresentation, playerWithTurn().provideName());

                if (_gameQuitRule.enforceRule(playerInput)) {
                    _gameState = GameState.QUIT;

                } else if (_sowEmptyHouseRule.enforceRule(boardRepresentation, playerInput, playerWithTurn())) {
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

        _captureRule.enforceRule(result, _p1, _p2, playerWithTurn(), _gameBoard);

        _switchTurnRule.enforceRule(result, _p1, _p2, playerWithTurn());

    }

    private Player playerWithTurn() {
        if (_p2.isMyTurn()) {
            return _p2;
        } else {
            return _p1;
        }
    }
}
