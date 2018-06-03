package kalah.data;

import java.util.ArrayList;

/**
 * This is a data class that safely contains game board information
 */
public class GameBoardRepresentation {

    private ArrayList<Integer> _p1Houses;
    private ArrayList<Integer> _p2Houses;
    private int _p1Store;
    private int _p2Store;
    private String _p1;
    private String _p2;

    public GameBoardRepresentation(ArrayList<Integer> p1Houses, ArrayList<Integer> p2Houses, int p1Store, int p2Store,
                                   String p1, String p2) {
        _p1Houses = p1Houses;
        _p2Houses = p2Houses;
        _p1Store = p1Store;
        _p2Store = p2Store;
        _p1 = p1;
        _p2 = p2;
    }

    public ArrayList<Integer> getP1Houses() {
        return _p1Houses;
    }

    public ArrayList<Integer> getP2Houses() {
        return _p2Houses;
    }

    public int getP1Store() {
        return _p1Store;
    }

    public int getP2Store() {
        return _p2Store;
    }

    public String getP1Name() {
        return _p1;
    }

    public String getP2Name() {
        return _p2;
    }

    public boolean isSideEmpty(int playerNumber) {
        boolean sideIsEmpty = true;
        if (playerNumber == 1) {
            for (int i = 0; i < _p1Houses.size(); i++) {
                if (_p1Houses.get(i) != 0) {
                    sideIsEmpty = false;
                    break;
                }
            }
        } else if (playerNumber == 2) {
            for (int i = 0; i < _p2Houses.size(); i++) {
                if (_p2Houses.get(i) != 0) {
                    sideIsEmpty = false;
                    break;
                }
            }
        }

        return sideIsEmpty;
    }

    public boolean ishouseEmpty(int houseIndex, int playerNumber) {
        boolean houseIsEmpty = false;
        if (playerNumber == 1) {
            if (_p1Houses.get(houseIndex) == 0) {
                houseIsEmpty = true;
            }
        } else if (playerNumber == 2) {
            if (_p2Houses.get(houseIndex) == 0) {
                houseIsEmpty = true;
            }
        }

        return houseIsEmpty;
    }
}
