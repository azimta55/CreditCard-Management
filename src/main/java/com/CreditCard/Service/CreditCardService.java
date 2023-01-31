package com.CreditCard.Service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.CreditCard.Controller.CreditCardDTO;
import com.CreditCard.Exception.CreditCardServiceException;
import com.CreditCard.Model.CreditCards;
import com.CreditCard.Model.Transaction;
import com.CreditCard.Model.Users;
import com.CreditCard.Repository.CreditCardRepository;
import com.CreditCard.Repository.TransactionRepository;
import com.CreditCard.Repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CreditCardService {
	
	@Autowired 
	CreditCardRepository creditcardrepository;
	
	
	@Autowired
	UserRepository userrepository;
	
	@Autowired
	TransactionRepository transcationrepository;
	
	

	public Users saveUser(String user) throws CreditCardServiceException {
		
	Users users = new Users();
		
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			users = objectMapper.readValue(user, Users.class);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		users	= userrepository.save(users);
		
	
		
		return users;
	}

	public String saveTransaction(CreditCardDTO transaction) throws CreditCardServiceException {

		
		// Logic behind credit transaction
		float balance=0;
		
		float creditTransactionAmount=0;
		
		float newBalance=0;
		
		
		Transaction transactions = new Transaction();
		
		CreditCards creditcard =null;
		
		creditcard = 	creditcardrepository.findById(transaction.getCardId()).get();
		
		
		
		balance =creditcard.getCreditBalance();
		
		creditTransactionAmount =transaction.getAmount();
		
		
		newBalance =(balance - creditTransactionAmount);
		

		creditcard.setCreditBalance(newBalance);
		
		creditcardrepository.save(creditcard);
		
		//Transaction taken from UI
		transactions.setAmount(transaction.getAmount());
		transactions.setBankName(transaction.getBankName());
		transactions.setCardNo(transaction.getCardNo());
		
		transcationrepository.save(transactions);
		
		
		
		
		
		return "Bank Name = "+transaction.getBankName()+"     "+"New Credit Balance = "+newBalance;
	}
	
	
	

	public String saveImage(CreditCardDTO dto, MultipartFile file) throws CreditCardServiceException {
		
		Users user = userrepository.findById(dto.getUserId()).get();
		
		try {
			user.setUserimage(file.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		userrepository.save(user);
		
		
		return "Image Saved";
	}

	
	
	public List<CreditCards> findCreditCard(CreditCardDTO transaction) {
		
		List<CreditCards> cards = userrepository.findCreditCardsById(transaction.getUserId());
		
		
		
		return cards;
	}

	
	

	

}
