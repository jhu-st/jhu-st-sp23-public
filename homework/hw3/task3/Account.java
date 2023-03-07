import java.util.Calendar;
import java.util.Date;

public abstract class Account {

	private static int idGenerate = 0;
	private int id;
	private double balance;
	private Date dateOpenned;
	private Date dateClosed;
	private Customer owner;
	
	public Account() {
		
	}
	protected Account(double balance, Customer owner) {
		super();
		id = idGenerate++;
		this.balance = balance;
		this.dateOpenned = Calendar.getInstance().getTime();
		this.owner = owner;
		this.dateClosed = null;
	}
	
	public int getId() {
		return id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Date getDateOpenned() {
		return dateOpenned;
	}
	
	public Customer getOwner() {
		return owner;
	}
	public void setOwner(Customer owner) {
		this.owner = owner;
	}
	public Date getDateClosed() {
		return dateClosed;
	}

	public double destroy() {
		owner = null;
		double t = balance;
		balance = 0;
		dateClosed = Calendar.getInstance().getTime();
		return t;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((dateOpenned == null) ? 0 : dateOpenned.hashCode());
		result = prime * result + id;
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (dateOpenned == null) {
			if (other.dateOpenned != null)
				return false;
		} else if (!dateOpenned.equals(other.dateOpenned))
			return false;
		if (id != other.id)
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		return true;
	}
	
}
