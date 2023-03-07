public class Loan {
	
	private int amount;
	private LoanType lt;
	
	public Loan(int amount, LoanType lt) {
		this.amount = amount;
		this.lt = lt;
	}
	
	private static Loan loanFactory(Customer cs, LoanType lt, int loanAmount) {
		if(lt == null){
			return null;
		}		
			
		if(lt == LoanType.Auto || lt == LoanType.Home || lt == LoanType.Personal || lt == LoanType.Other){
			return new Loan(loanAmount, lt);
		}
		return null;
	}
	
	public boolean isEligibleForLoan(Customer customer) {
		if (customer.getAge() < 18 || customer.getCreditScore() < 650 
		    || customer.getAccounts().size() < 2 || customer.getDeclaredAnnualIncome() < 50000)
			return false;
		return true;
	}
	
	public Loan requestLoan(Customer customer, LoanType lt, int loanAmount) {
		if (isEligibleForLoan(customer)) {
			return loanFactory(customer, lt, loanAmount);
		}
		return null;
	}

	public int getAmount() {
		return amount;
	}

	public LoanType getLt() {
		return lt;
	}

	
}
