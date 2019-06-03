package dialogservice;

public class Phone {
	private String mobileNo;
	private String owner;
	private double balance;
	private int pin;

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public Phone() {
	}

	public Phone(String mobileNo, String owner, double balance, int pin) {
		this.mobileNo = mobileNo;
		this.owner = owner;
		this.balance = balance;
		this.pin = pin;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
}
