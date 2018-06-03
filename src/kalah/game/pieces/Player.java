package kalah.game.pieces;

public class Player {
    private String _name;
    private boolean _myTurn;
    private int _playerNumber;

    protected Player(String name, int playerNumber) {
        _name = name;
        _playerNumber = playerNumber;
        _myTurn = false;
    }

    public boolean isMyTurn() {
        return _myTurn;
    }

    public void giveTurn() {
        _myTurn = true;
    }

    public void takeAwayTurn() {
        _myTurn = false;
    }

    public String provideName() {
        return _name;
    }

    public int providePlayerNumber() {
        return _playerNumber;
    }
}
