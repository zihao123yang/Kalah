package kalah.io;

import com.qualitascorpus.testsupport.IO;
import kalah.data.GameBoardRepresentation;

import java.util.ArrayList;

/**
 * Created by zihaoyang on 25/04/18.
 *
 * This class is responsible for interacting with the user via an ASCII interface
 */
public class ASCIIUserInterface implements UserInterface {

    private IO _io;

    public ASCIIUserInterface(IO io) {
        _io = io;
    }

    public void showBoard(GameBoardRepresentation gameBoard) {

        ArrayList<Integer> p1Houses = gameBoard.getP1Houses();
        ArrayList<Integer> p2Houses = gameBoard.getP2Houses();
        int p1Store = gameBoard.getP1Store();
        int p2Store = gameBoard.getP2Store();
        String player1 = gameBoard.getP1Name();
        String player2 = gameBoard.getP2Name();


        StringBuilder p2BoardBuilder = new StringBuilder();
        p2BoardBuilder.append("| ").append(player2).append(" | ");
        for (int i = p2Houses.size() - 1; i >= 0; i--) {
            p2BoardBuilder.append(i + 1).append("[").append(determineSpace(p2Houses.get(i))).append(p2Houses.get(i)).append("] | ");
        }
        p2BoardBuilder.append(determineSpace(p1Store)).append(gameBoard.getP1Store()).append(" |");


        StringBuilder p1BoardBuilder = new StringBuilder();
        p1BoardBuilder.append("| ").append(determineSpace(p2Store)).append(gameBoard.getP2Store()).append(" | ");
        for (int i = 0; i < p1Houses.size(); i++) {
            p1BoardBuilder.append(i + 1).append("[").append(determineSpace(p1Houses.get(i))).append(p1Houses.get(i)).append("] | ");
        }
        p1BoardBuilder.append(player1).append(" |");


        _io.println("+----+-------+-------+-------+-------+-------+-------+----+");
        _io.println(p2BoardBuilder.toString());
        _io.println("|    |-------+-------+-------+-------+-------+-------|    |");
        _io.println(p1BoardBuilder.toString());
        _io.println("+----+-------+-------+-------+-------+-------+-------+----+");
    }


    public int turnPrompt(GameBoardRepresentation boardRepresentation, String currentPlayerName) {
        //to do- change
        return _io.readInteger("Player " + currentPlayerName + "'s turn - Specify house number or 'q' to quit: ",
                1, boardRepresentation.getP1Houses().size(), -1, "q");
    }

    public void emptyHousePrompt() {
        _io.println("House is empty. Move again.");
    }

    public void gameFinishedPrompt() {
        _io.println("Game over");
    }

    public void finalScoresPrompt(int[] finalScores) {
        _io.println("\tplayer 1:" + finalScores[0]);
        _io.println("\tplayer 2:" + finalScores[1]);

        if (finalScores[0] > finalScores[1]) {
            _io.println("Player 1 wins!");
        } else if (finalScores[1] > finalScores[0]){
            _io.println("Player 2 wins!");
        } else {
            _io.println("A tie!");
        }
    }

    private String determineSpace(int value) {
        String space = " ";
        if (value > 9) {
            space = "";
        }
        return space;
    }


}
