package a10;

import java.util.Random;

/**
 * Returns a random response independent of the human's move.
 */
public class RandomOpponent implements Opponent {

	public RPS getResponse(RPS humanMove) {
		Random rng = new Random();
		return RPS.values()[rng.nextInt(3)];
	}

}