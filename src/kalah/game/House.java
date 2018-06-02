package kalah.game;

/**
 * Created by zihaoyang on 25/04/18.
 *
 * This class represents a House in the the Kalah game
 */
public class House {

    private int _numSeeds;

    protected House(int numSeeds) {
        _numSeeds = numSeeds;
    }

    protected int getNumSeeds() {
        return _numSeeds;
    }

    protected void empty() {
        _numSeeds = 0;
    }

    protected void addSeed() {
        _numSeeds++;
    }

    protected boolean isEmpty() {
        boolean empty = false;
        if (_numSeeds == 0) {
            empty = true;
        }
        return empty;
    }
}
