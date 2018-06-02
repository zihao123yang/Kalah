package kalah.game;

/**
 * Created by zihaoyang on 25/04/18.
 *
 * This class represents a store in a Kalah game
 */
public class Store {
    private int _numSeeds;

    protected Store() {
        _numSeeds = 0;
    }

    protected void addSeeds(int number) {
        _numSeeds = _numSeeds + number;
    }

    protected int getNumSeeds() {
        return _numSeeds;
    }
}
