public class Checking extends Account {
	private double atmFee;
	private double maintenanceFee;
	private boolean checkBookletRequested;
	
	public Checking() {
		super();
	}
	protected Checking(double balance, Customer owner, double atmFee, double mFee) {
		super(balance, owner);
		this.atmFee = atmFee;
		this.maintenanceFee = mFee;
		checkBookletRequested = false;
	}
	
	public Checking open(Customer customer, double initialAmount) {
		return new Checking(initialAmount, customer, getATMFee(initialAmount), getMaintenanceFee(initialAmount));
	}
	
	public boolean requestCheckBooklet(int count) {
		if (getBalance() > 100)
			checkBookletRequested = true;
		return checkBookletRequested;
	}

	private static double getATMFee(double balance) {
		return 2;
	}
	
	private static double getMaintenanceFee(double balance) {
		if (balance >= 1000)
			return 0;
		else
			return 5;
	}
	
	public double getATMFee() {
		return atmFee;
	}

	public void setAtmFee(double atmFee) {
		this.atmFee = atmFee;
	}

	public double getMaintenanceFee() {
		return maintenanceFee;
	}

	public void setMaintenanceFee(double maintenanceFee) {
		this.maintenanceFee = maintenanceFee;
	}

}
