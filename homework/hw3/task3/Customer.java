import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Customer {

	private int id;
	private String name;
	private int age;
	private String address;
	private String phoneNumber;
	private String ssn;
	private int creditScore;
	private Date dateJoined;
	private ArrayList<Account> accounts;
	private ArrayList<Loan> loans;
	private int declaredAnnualIncome;
	
	
	public Customer(CreditReport cr, int id, String name, int age, String address, int declaredAnnualIncome, String phoneNumber, String ssn) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.ssn = ssn;
		this.declaredAnnualIncome = declaredAnnualIncome;
		accounts = new ArrayList<Account>();
		loans = new ArrayList<Loan>();
		this.dateJoined = Calendar.getInstance().getTime();
		this.creditScore = cr.getScore(ssn);
	}
	
	public int applyForLoan(Loan l) {
		if (l == null)
			throw new NullPointerException("loan null");
		LoanType lt = l.getLt();
		int la = l.getAmount();
		l.requestLoan(this, lt, la);
		loans.add(l);
		return l.getAmount();
	}

	
	public double applyForSavingsAccount(Savings sv) {
		if (sv == null)
			throw new NullPointerException("Savings null");
		double balance = sv.getBalance();
		sv.open(this, balance);
		accounts.add(sv);
		return sv.getInterestRate();
	}
	
	public boolean applyForCheckingAccount(Checking ck) {
		if (ck == null)
			throw new NullPointerException("Checking null");
		double balance = ck.getBalance();
		ck.open(this, balance);
		accounts.add(ck);
		return true;
	}
	
	public double closeAccount(Account account) {
		double amount = -1;
		for (Account acc: accounts) {
			if (acc.equals(account))
				amount = account.destroy();
		}
		return amount;
	}
	
	public boolean requestCheckBooklet(Checking account, int count) {
		for (Account acc: accounts) {
			if (acc.equals(account))
				return account.requestCheckBooklet(count);
		}
		return false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public int getCreditScore() {
		return creditScore;
	}

	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}

	public Date getDateJoined() {
		return dateJoined;
	}

	public void setDateJoined(Date dateJoined) {
		this.dateJoined = dateJoined;
	}

	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}

	public ArrayList<Loan> getLoans() {
		return loans;
	}

	public void setLoans(ArrayList<Loan> loans) {
		this.loans = loans;
	}

	public int getDeclaredAnnualIncome() { return declaredAnnualIncome;	}

	public void setDeclaredAnnualIncome(int declaredAnnualIncome) { this.declaredAnnualIncome = declaredAnnualIncome; }
	
}
