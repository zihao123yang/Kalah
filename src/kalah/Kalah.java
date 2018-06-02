package kalah;

import com.qualitascorpus.testsupport.IO;
import com.qualitascorpus.testsupport.MockIO;
import kalah.game.*;
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
		CaptureRule captureRule = new StandardCaptureRule();
		RepeatTurnRule repeatTurnRule = new StandRepeatTurnRule();
		GameQuitRule gameQuitRule = new StandardGameQuitRule();
		GameFinishedRule gameFinishedRule = new StandardGameFinishedRule();

		GameManager gameMaster = new GameManager(output, captureRule, repeatTurnRule, gameQuitRule, gameFinishedRule);
		gameMaster.play();
	}
}
