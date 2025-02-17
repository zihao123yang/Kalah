package kalah.data;

/**
 * Created by zihaoyang on 3/05/18.
 *
 * This is a data class that safely contains information from the results of a player move, after all the seeds have been sowed.
 */
public class SowResults {
    private int _endingSide;
    private int _lastSeedPosition;
    private boolean _lastPositionEmpty;

    public SowResults(int endingSide, int lastSeedPosition, boolean lastPositionEmpty) {
        _endingSide = endingSide;
        _lastSeedPosition = lastSeedPosition;
        _lastPositionEmpty = lastPositionEmpty;
    }

    public boolean lastHouseEmpty() {
        return _lastPositionEmpty;
    }

    public boolean endedInStore() {
        boolean lastSeedInStore = false;
        if (_lastSeedPosition == -1) {
            lastSeedInStore = true;
        }
        return lastSeedInStore;
    }

    public int getEndingBoardSide() {
        return _endingSide;
    }

    public int lastHouseSowed() {
        return _lastSeedPosition;
    }
}
