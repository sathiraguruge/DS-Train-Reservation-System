package sampathservice;

import java.io.Serializable;

public class CreditCard implements Serializable{
	private String creditCardNo;
	private String cvcNo;
	private String cardHolder;
	private double limit;
	private double currentAmount;
	private String expireDate;
	
	public CreditCard(){}
	
	public CreditCard(String creditCardNo, String cvcNo, String cardHolder, double limit, double currentAmount, String expireDate){
		this.creditCardNo = creditCardNo;
		this.cvcNo = cvcNo;
		this.cardHolder = cardHolder;
		this.limit = limit;
		this.currentAmount = currentAmount;
		this.expireDate = expireDate;
	}
	
	public String getCreditCardNo() {
		return creditCardNo;
	}

	public void setCreditCardNo(String creditCardNo) {
		this.creditCardNo = creditCardNo;
	}

	public String getCvcNo() {
		return cvcNo;
	}

	public void setCvcNo(String cvcNo) {
		this.cvcNo = cvcNo;
	}

	public String getCardHolder() {
		return cardHolder;
	}

	public void setCardHolder(String cardHolder) {
		this.cardHolder = cardHolder;
	}

	public double getLimit() {
		return limit;
	}

	public void setLimit(double limit) {
		this.limit = limit;
	}

	public double getCurrentAmount() {
		return currentAmount;
	}

	public void setCurrentAmount(double currentAmount) {
		this.currentAmount = currentAmount;
	}

	public String getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}

}
