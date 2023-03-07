public class Savings extends Account {
    enum CompoundType {
		Yearly, Monthly, Daily, Continuously;
	}

	private double interestRate;
	private boolean isCompound;
	private CompoundType compoundType;
	
	public Savings() {
		super();
	}
	public Savings(double balance, Customer owner, double interestRate, boolean isCompound,
			CompoundType compoundType) {
		super(balance, owner);
		this.interestRate = interestRate;
		this.isCompound = isCompound;
		this.compoundType = compoundType;
	}
	
	public Savings open(Customer customer, double initialAmount) {
		return new Savings(initialAmount, customer, getRate(), true, CompoundType.Continuously);
	}
	private static double getRate() {
		return 0.02;
	}

	public boolean isCompound() {
		return isCompound;
	}

	public void setCompound(boolean isCompound) {
		this.isCompound = isCompound;
	}

	public CompoundType getCompoundType() {
		return compoundType;
	}

	public void setCompoundType(CompoundType compoundType) {
		this.compoundType = compoundType;
	}

	public double getInterestRate() {
		return this.interestRate;
	}
	
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	
}
