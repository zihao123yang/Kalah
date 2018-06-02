package kalah.game;

import kalah.data.SowResults;
import kalah.data.GameBoardRepresentation;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by zihaoyang on 25/04/18.
 *
 * This class represents a Kalah game board
 */
public class GameBoard {

    protected static final int DEFAULT_HOUSES_PER_PLAYER = 6;
    protected static final int DEFAULT_SEEDS_PER_HOUSE = 4;

    private HashMap<Integer, HalfBoard> _boardComponents;
    private int _housesPerPlayer;

    protected GameBoard() {
        _boardComponents = new HashMap<Integer, HalfBoard>();
        _boardComponents.put(0, new HalfBoard(DEFAULT_HOUSES_PER_PLAYER, DEFAULT_SEEDS_PER_HOUSE, 0));
        _boardComponents.put(1, new HalfBoard(DEFAULT_HOUSES_PER_PLAYER, DEFAULT_SEEDS_PER_HOUSE, 1));

        _housesPerPlayer = DEFAULT_HOUSES_PER_PLAYER;
    }


    protected SowResults sow(int player, int houseIndex) {
        HalfBoard originalSide = _boardComponents.get(player);
        HalfBoard currentSide = originalSide;
        int numSeedsToSow = currentSide.getNumberOfSeeds(houseIndex);
        int positionToSow = houseIndex + 1;

        currentSide.removeSeeds(houseIndex);

        while (numSeedsToSow > 0) {
            if (positionToSow == _housesPerPlayer) {
                if (originalSide == currentSide) {
                    positionToSow = currentSide.sowSeedInStore();
                } else {
                    currentSide = switchSidesOnBoard(currentSide);
                    positionToSow = currentSide.sowSeed(0);
                }
            } else if (positionToSow < 0) {
                currentSide = switchSidesOnBoard(currentSide);
                positionToSow = currentSide.sowSeed(0);
            } else {
                positionToSow = currentSide.sowSeed(positionToSow);
            }
            numSeedsToSow--;
        }

        return createSowResults(positionToSow, currentSide);

    }

    protected void capture(int player, int houseIndex) {
        HalfBoard capturingSide = _boardComponents.get(player);
        HalfBoard capturedSide = switchSidesOnBoard(capturingSide);
        int capturedHouse = _housesPerPlayer - 1 - houseIndex;

        if (!capturedSide.isHouseEmpty(capturedHouse)) {

            capturingSide.moveSeedsToStore(houseIndex);
            int numSeedsCaptured = capturedSide.getNumberOfSeeds(capturedHouse);

            capturedSide.removeSeeds(capturedHouse);
            capturingSide.addSeedsToStore(numSeedsCaptured);
        }
    }

    protected GameBoardRepresentation createBoardRepresentation() {

        GameBoardRepresentation gameBoardRepresentation = new GameBoardRepresentation(getSeedsInHouses(0),
                getSeedsInHouses(1), getSeedsInStore(0), getSeedsInStore(1));

        return gameBoardRepresentation;
    }


    protected int getNumHousesPerPlayer() {
        return _housesPerPlayer;
    }

    protected int[] getFinalScores() {
        int[] finalScores = new int[2];

        for (int i = 0; i < DEFAULT_HOUSES_PER_PLAYER; i++) {
            finalScores[0] = finalScores[0] + _boardComponents.get(0).getNumberOfSeeds(i);
            finalScores[1] = finalScores[1] + _boardComponents.get(1).getNumberOfSeeds(i);
        }

        finalScores[0] = finalScores[0] + _boardComponents.get(0).getNumSeedsInStore();
        finalScores[1] = finalScores[1] + _boardComponents.get(1).getNumSeedsInStore();


        return finalScores;
    }

    protected boolean isPlayerHouseEmpty(int houseNumber, int player) {
        return _boardComponents.get(player).isHouseEmpty(houseNumber);
    }

    protected boolean isCurrentSideEmpty(int player) {
        return _boardComponents.get(player).areHousesEmpty();
    }

    //Helper methods

    private HalfBoard switchSidesOnBoard(HalfBoard originalSide) {
        HalfBoard otherSide = _boardComponents.get(0);
        if (originalSide.equals(_boardComponents.get(0))) {
            otherSide = _boardComponents.get(1);
        }
        return otherSide;
    }

    private ArrayList<Integer> getSeedsInHouses(int player) {
        return _boardComponents.get(player).getSeedsDistribution();
    }

    private int getSeedsInStore(int player) {
        return _boardComponents.get(player).getNumSeedsInStore();
    }

    private SowResults createSowResults(int nextPositionToSow, HalfBoard currentSide) {
        boolean lastPositionEmpty = false;
        int lastPositionSowed = -1;
        if (nextPositionToSow != -1) {
            lastPositionSowed = nextPositionToSow -1;
        }
        if (lastPositionSowed != -1 && currentSide.getNumberOfSeeds(lastPositionSowed) == 1) {
            lastPositionEmpty = true;
        }
        return new SowResults(currentSide.getOwner(), lastPositionSowed, lastPositionEmpty);
    }
}
