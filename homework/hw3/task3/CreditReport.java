import java.util.Random;

public class CreditReport {
	
	// return a credit score between 550 and 850
	public int getScore(String ssn) {
		return 550 + new Random().nextInt(301); 		
	}
	
}
