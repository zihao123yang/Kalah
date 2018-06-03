package kalah.game.pieces;

/**
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
}
