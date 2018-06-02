package kalah;

import com.qualitascorpus.testsupport.IO;
import com.qualitascorpus.testsupport.MockIO;
import kalah.game.GameManager;
import kalah.view.ASCIIUserInterface;

/**
 * This class is the starting point for a Kalah implementation using
 * the test infrastructure.
 */
public class Kalah {
	public static void main(String[] args) {
		new Kalah().play(new MockIO());
	}
	public void play(IO io) {
		ASCIIUserInterface output = new ASCIIUserInterface(io);
		GameManager gameMaster = new GameManager(output);
		gameMaster.play();
	}
}
