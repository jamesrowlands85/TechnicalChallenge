
public class Score {
	
	public int calculateScore(String sipp) {
		int score = 0;
		if(sipp.charAt(2) == 'M') {
			score += 1;
		}
		if(sipp.charAt(2) == 'A') {
			score += 5;
		}
		if(sipp.charAt(3) == 'R') {
			score += 2;
		}
		return score;
	}

}
