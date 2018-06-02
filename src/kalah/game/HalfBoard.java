package kalah.game;

import java.util.ArrayList;

/**
 * Created by zihaoyang on 2/05/18.
 *
 * This class represents a single player's side of a Kalah game board
 */
public class HalfBoard {

    private ArrayList<House> _houses;
    private Store _store;
    private int _owner;

    protected HalfBoard(int numHouses, int numSeeds, int player) {
        _houses = new ArrayList<House>();
        for (int i = 0; i < numHouses; i++) {
            _houses.add(new House(numSeeds));
        }
        _store = new Store();
        _owner = player;
    }

    protected ArrayList<Integer> getSeedsDistribution() {
        ArrayList<Integer> seedsDistribution = new ArrayList<Integer>();
        for (House house: _houses) {
            seedsDistribution.add(house.getNumSeeds());
        }
        return seedsDistribution;
    }

    protected int getNumSeedsInStore() {
        return _store.getNumSeeds();
    }

    protected int getNumberOfSeeds(int houseIndex) {
        return _houses.get(houseIndex).getNumSeeds();
    }

    protected int getOwner() {
        return _owner;
    }


    protected boolean isHouseEmpty(int houseNumber) {
        if (_houses.get(houseNumber).getNumSeeds() == 0) {
            return true;
        }
        return false;
    }

    protected boolean areHousesEmpty() {
        boolean housesEmpty = true;
        for (House house : _houses) {
            if (!house.isEmpty()) {
                housesEmpty = false;
                break;
            }
        }
        return housesEmpty;
    }

    protected int sowSeed(int position) {
        int nextPosition = position;
        if (position < _houses.size()) {
            _houses.get(position).addSeed();
            nextPosition++;
        }

        return nextPosition;
    }

    protected int sowSeedInStore() {
        _store.addSeeds(1);
        return -1;
    }

    protected void moveSeedsToStore(int houseIndex) {
        addSeedsToStore(_houses.get(houseIndex).getNumSeeds());
        _houses.get(houseIndex).empty();
    }

    protected void addSeedsToStore(int numSeeds) {
        _store.addSeeds(numSeeds);
    }

    protected void removeSeeds(int houseIndex) {
        _houses.get(houseIndex).empty();
    }


    protected boolean equals(HalfBoard other) {
        if (this._owner == other.getOwner()) {
            return true;
        }

        return false;
    }






}
