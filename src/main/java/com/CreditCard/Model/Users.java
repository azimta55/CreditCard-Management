package com.CreditCard.Model;

import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;



import com.CreditCard.address.HomeAddress;

@Entity
@Table(name = "Users")
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long userId;
	String name;
	

	@Embedded
	private HomeAddress homeAddress;
	
	
	@Lob
	private byte[] userimage;
	
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "users_creditcards", joinColumns = @JoinColumn(name = "users_userid", referencedColumnName = "userid"), inverseJoinColumns = @JoinColumn(name = "creditcards_cardid", referencedColumnName = "cardid"))
	private List<CreditCards> creditcards;



	public Users(Long userId, String name, HomeAddress homeAddress, byte[] userimage, List<CreditCards> creditcards) {
		super();
		this.userId = userId;
		this.name = name;
		this.homeAddress = homeAddress;
		this.userimage = userimage;
		this.creditcards = creditcards;
	}



	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Long getUserId() {
		return userId;
	}



	public void setUserId(Long userId) {
		this.userId = userId;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public HomeAddress getHomeAddress() {
		return homeAddress;
	}



	public void setHomeAddress(HomeAddress homeAddress) {
		this.homeAddress = homeAddress;
	}



	public byte[] getUserimage() {
		return userimage;
	}



	public void setUserimage(byte[] userimage) {
		this.userimage = userimage;
	}



	public List<CreditCards> getCreditcards() {
		return creditcards;
	}



	public void setCreditcards(List<CreditCards> creditcards) {
		this.creditcards = creditcards;
	}



	@Override
	public String toString() {
		return "Users [userId=" + userId + ", name=" + name + ", homeAddress=" + homeAddress + ", userimage="
				+ Arrays.toString(userimage) + ", creditcards=" + creditcards + "]";
	}
	
	
	
	
	
	
	

}
