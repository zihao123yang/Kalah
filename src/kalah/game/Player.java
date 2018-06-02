package kalah.game;

public class Player {
    private String _name;
    private boolean _myTurn;
    private int _playerNumber;

    public Player(String name, int playerNumber) {
        _name = name;
        _playerNumber = playerNumber;
        _myTurn = false;
    }

    protected boolean isMyTurn() {
        return _myTurn;
    }

    protected void giveTurn() {
        _myTurn = true;
    }

    protected void takeAwayTurn() {
        _myTurn = false;
    }

    protected String provideName() {
        return _name;
    }

    protected int providePlayerNumber() {
        return _playerNumber;
    }
}
