package com.CreditCard.Model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CreditCards")
public class CreditCards {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long cardId;
	
	String bankName;
	String expDate;
	Long pin;
	Long cardNo;
	float creditBalance;
	
	
	
	@Enumerated(EnumType.STRING)
	private CreditCardType creditCardType;



	public CreditCards(Long cardId, String bankName, String expDate, Long pin, Long cardNo, float creditBalance,
			CreditCardType creditCardType) {
		super();
		this.cardId = cardId;
		this.bankName = bankName;
		this.expDate = expDate;
		this.pin = pin;
		this.cardNo = cardNo;
		this.creditBalance = creditBalance;
		this.creditCardType = creditCardType;
	}



	public CreditCards() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Long getCardId() {
		return cardId;
	}



	public void setCardId(Long cardId) {
		this.cardId = cardId;
	}



	



	public String getExpDate() {
		return expDate;
	}



	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}



	public Long getPin() {
		return pin;
	}



	public void setPin(Long pin) {
		this.pin = pin;
	}



	public Long getCardNo() {
		return cardNo;
	}



	public void setCardNo(Long cardNo) {
		this.cardNo = cardNo;
	}



	public float getCreditBalance() {
		return creditBalance;
	}



	public void setCreditBalance(float creditBalance) {
		this.creditBalance = creditBalance;
	}



	public CreditCardType getCreditCardType() {
		return creditCardType;
	}



	public void setCreditCardType(CreditCardType creditCardType) {
		this.creditCardType = creditCardType;
	}


	
	

	public String getBankName() {
		return bankName;
	}



	public void setBankName(String bankName) {
		this.bankName = bankName;
	}



	@Override
	public String toString() {
		return "CreditCards [cardId=" + cardId + ", bankName=" + bankName + ", expDate=" + expDate + ", pin=" + pin
				+ ", cardNo=" + cardNo + ", creditBalance=" + creditBalance + ", creditCardType=" + creditCardType
				+ "]";
	}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
