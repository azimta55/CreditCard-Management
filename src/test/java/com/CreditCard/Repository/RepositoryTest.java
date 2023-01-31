package com.CreditCard.Repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.CreditCard.CreditCardApplication;
import com.CreditCard.Model.Users;
import com.CreditCard.address.HomeAddress;


@ExtendWith(SpringExtension.class)
@Transactional
@SpringBootTest(classes = CreditCardApplication.class)
public class RepositoryTest {
	
	
	 @Autowired
	 UserRepository repository;
	 
	 
	
	 @Test
	 public void testSave() {
		 Users user = getUserProfile();
		 repository.save(user);
		 Users found = repository.findById(user.getUserId()).get();
	      assertEquals(user.getUserId(), found.getUserId());	     
	   }

	  
	 

	 
	 
	 
	 
	 
	  public Users getUserProfile() {
		  Users userprofile = new Users();
		  userprofile.setName("Harry");
		  userprofile.setHomeAddress(homeAddress());  
          return userprofile;
       }



   public HomeAddress homeAddress() {
       HomeAddress home = new HomeAddress();
       home.setBuildingName("Thotumguham");
       home.setCity("aluva");
       home.setCountry("india");
       home.setPostalCode("434343");
       home.setState("kerala");
       home.setStreet("neerugal");
    return home;      
   }
}
