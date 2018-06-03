package kalah;

import com.qualitascorpus.testsupport.IO;
import com.qualitascorpus.testsupport.MockIO;
import kalah.game.pieces.StandardCaptureRule;
import kalah.game.pieces.StandardSwitchTurnRule;
import kalah.game.pieces.StandardGameQuitRule;
import kalah.game.pieces.StandardGameFinishedRule;
import kalah.game.pieces.StandardSowEmptyHouseRule;
import kalah.game.pieces.GameManager;
import kalah.io.ASCIIUserInterface;
import kalah.io.UserInterface;
import kalah.game.rules.*;

/**
 * This class is the starting point for a Kalah implementation using
 * the test infrastructure.
 */
public class Kalah {
	public static void main(String[] args) {
		new Kalah().play(new MockIO());
	}
	public void play(IO io) {
		UserInterface output = new ASCIIUserInterface(io);

		CaptureRule captureRule = new StandardCaptureRule();
		SwitchTurnRule switchTurnRule = new StandardSwitchTurnRule();
		GameQuitRule gameQuitRule = new StandardGameQuitRule();
		GameFinishedRule gameFinishedRule = new StandardGameFinishedRule();
		SowEmptyHouseRule sowEmptyHouseRule = new StandardSowEmptyHouseRule();

		GameManager gameMaster = new GameManager(output, captureRule, switchTurnRule, gameQuitRule, gameFinishedRule, sowEmptyHouseRule);
		gameMaster.play();
	}
}
