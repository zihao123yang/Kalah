package kalah.game;

public class Player {
    private String _name;
    private boolean _myTurn;

    public Player(String name) {
        _name = name;
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
}
