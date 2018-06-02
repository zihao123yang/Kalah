package kalah.data;

import java.util.ArrayList;

/**
 * Created by zihaoyang on 2/05/18.
 *
 * This is a data class that safely contains game board information
 */
public class GameBoardRepresentation {

    private ArrayList<Integer> _p1Houses;
    private ArrayList<Integer> _p2Houses;
    private int _p1Store;
    private int _p2Store;

    public GameBoardRepresentation(ArrayList<Integer> p1Houses, ArrayList<Integer> p2Houses, int p1Store, int p2Store) {
        _p1Houses = p1Houses;
        _p2Houses = p2Houses;
        _p1Store = p1Store;
        _p2Store = p2Store;
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
}
