import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TestScore {
	
	Score score;
	
	@Before
	public void setUp() throws Exception {
		score = new Score();
	}

	@Test
	public void testScoreManualExpectedOne() {
		assertEquals(score.calculateScore("ACMP"), 1);
	}
	
	@Test
	public void testScoreAutomaticExpectedFive() {
		assertEquals(score.calculateScore("ACAP"), 5);
	}
	
	@Test
	public void testScoreManualACExpectedThree() {
		assertEquals(score.calculateScore("ACMR"), 3);
	}
	
	@Test
	public void testScoreAutomaticACExpectedSeven() {
		assertEquals(score.calculateScore("ACAR"), 7);
	}
	
	@Test
	public void testScoreNoScoringExpectedZero() {
		assertEquals(score.calculateScore("ACTA"), 0);
	}

}
