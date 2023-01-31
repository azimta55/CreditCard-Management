package com.CreditCard.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Transaction")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long transactionId;
	
	String bankName;
	Long cardNo;
	

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@Column(nullable = false,name ="transactionDate")
	private Date transactionDate;
	

	@PrePersist
	private void onCreate() {
		transactionDate = new Date();
	}

	 float amount;

	 
	 
	 
	 
	public Transaction(Long transactionId, String bankName, Long cardNo, Date transactionDate, float amount) {
		super();
		this.transactionId = transactionId;
		this.bankName = bankName;
		this.cardNo = cardNo;
		this.transactionDate = transactionDate;
		this.amount = amount;
	}





	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}





	public Long getTransactionId() {
		return transactionId;
	}





	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}





	public String getBankName() {
		return bankName;
	}





	public void setBankName(String bankName) {
		this.bankName = bankName;
	}





	public Long getCardNo() {
		return cardNo;
	}





	public void setCardNo(Long cardNo) {
		this.cardNo = cardNo;
	}





	public Date getTransactionDate() {
		return transactionDate;
	}





	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}





	public float getAmount() {
		return amount;
	}





	public void setAmount(float amount) {
		this.amount = amount;
	}





	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", bankName=" + bankName + ", cardNo=" + cardNo
				+ ", transactionDate=" + transactionDate + ", amount=" + amount + "]";
	}
	 
	 
	 
	
	
	
	
	
	
	
	
}