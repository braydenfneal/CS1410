package a10;

/**
 * For this turn's move, returns whatever the human played last turn.
 * 
 * This opponent always plays ROCK as its first move.
 */
public class CopyPreviousOpponent implements Opponent {

	private RPS pick = RPS.ROCK;

	/**
	 * Returns whatever the user plays
	 * 
	 * @param humanMove the play the human chooses
	 * @return the humans last move
	 * 
	 */
	@Override
	public RPS getResponse(RPS humanMove) {
		// TODO: Implement this method, adding extra details to the class as necessary
		RPS temp = pick;
		pick = humanMove;
		return temp;
	}
}
