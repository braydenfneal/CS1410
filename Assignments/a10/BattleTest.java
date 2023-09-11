package a10;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import a7.StringSet;

class BattleTest {
	private ResultsPanel resultsPanel = new ResultsPanel();

	@Test
	public void computerWinTest() {
		RPS computer = RPS.ROCK;
		RPS human = RPS.PAPER;
		String winner = "Winner: Human wins!";
		assertEquals(resultsPanel.updateResults(computer, human), winner);	
	}
	
	@Test
	public void humanWinTest() {
		RPS computer = RPS.PAPER;
		RPS human = RPS.ROCK;
		
		assertEquals(resultsPanel.updateResults(computer, human), "Winner: Computer :(");	
	}
	
	@Test
	public void TieTest() {
		RPS computer = RPS.ROCK;
		RPS human = RPS.ROCK;
		
		assertEquals(resultsPanel.updateResults(computer, human), "Winner: It was a tie");	
	}


}
