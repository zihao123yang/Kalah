package kalah.data;

/**
 * This is a data class that safely contains information from the results of a player move, after all the seeds have been sowed.
 */
public class SowResults {
    private String _endingPlayer;
    private int _lastSeedPosition;
    private boolean _lastPositionEmpty;

    public SowResults(String name, int lastSeedPosition, boolean lastPositionEmpty) {
        _endingPlayer = name;
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

    public String getEndingPlayer() {
        return _endingPlayer;
    }

    public int lastHouseSowed() {
        return _lastSeedPosition;
    }
}
