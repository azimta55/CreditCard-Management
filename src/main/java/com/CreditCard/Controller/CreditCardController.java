package com.CreditCard.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.CreditCard.Exception.CreditCardServiceException;
import com.CreditCard.Model.CreditCards;
import com.CreditCard.Model.Users;
import com.CreditCard.Repository.CreditCardRepository;
import com.CreditCard.Repository.UserRepository;
import com.CreditCard.Service.CreditCardService;




@RestController
@RequestMapping("/xpay")
public class CreditCardController {
	
	@Autowired 
	CreditCardService service;
	
	
	@Autowired
	UserRepository userrepository;
	
	@Autowired 
	CreditCardRepository creditcardrepository;
	
	
	
	

	
	//CRUD : Create   Save User
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Users> saveUserProfile(@RequestBody String user)  {
		return ResponseEntity.ok(service.saveUser(user));

	}
	
	
	
	
	// Credit Transaction
	
	@RequestMapping(value = "/Transaction", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<String> Transaction(@RequestBody CreditCardDTO transaction)  {
		return ResponseEntity.ok(service.saveTransaction(transaction));

	}
	
	
	
	//Upload User Profile Image
	

	@PostMapping(value = "/ProfileimageUpload", consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE })
	public ResponseEntity<String> uploadimage(@RequestPart("userId") CreditCardDTO dto,@RequestPart("file") MultipartFile file) {

		return ResponseEntity.ok(service.saveImage(dto,file));
	}
	
	
	
	
	//Download User Profile image using UserID
		@RequestMapping(value = "/downloadFile/{userId}", produces = MediaType.IMAGE_JPEG_VALUE)
		public @ResponseBody byte[] downloadFile(@PathVariable Long userId, HttpServletRequest request) {

			return userrepository.findById(userId).get().getUserimage();

		}
		
		
		
		
		//CRUD : Read	
	// Get All User
	
		@RequestMapping(value = "/GetAllUser", method = RequestMethod.GET, produces = "application/json")
		public ResponseEntity<List<Users>> userList()  {
			return ResponseEntity.ok(userrepository.findAll());
			
			

		}
		
		
		
		// Get All CreditCards
		@RequestMapping(value = "/GetAllCreditCards", method = RequestMethod.GET, produces = "application/json")
		public ResponseEntity<List<CreditCards>> CreditCardList()  {
			return ResponseEntity.ok(creditcardrepository.findAll());

		}
		
		
		
		
		
		
	//CRUD : Update	 Update User
		
		 @PutMapping("/UpdateUser/{userId}")
		    public ResponseEntity<Users> updateEmployee(@PathVariable(value = "userId") Long userId, @RequestBody Users userDetails)throws CreditCardServiceException {
			 Users user = userrepository.findById(userId)
		        .orElseThrow(() -> new CreditCardServiceException("User Not Found " + userId));

			 user.setName(userDetails.getName());
			
		        final Users updatedUsers = userrepository.save(user);
		        return ResponseEntity.ok(updatedUsers);
		        
		    }
		 
		 
		 
		//CRUD : Delete	 Delete User 
		 
		 
		 @DeleteMapping("/deleteUser/{userId}")
		    public Map<String, Boolean> deleteUser(@PathVariable(value = "userId") Long userId) throws CreditCardServiceException {
			 Users user = userrepository.findById(userId)
		      .orElseThrow(() -> new CreditCardServiceException("User ID Not Found " + userId));

			 userrepository.delete(user);
		        Map<String, Boolean> response = new HashMap<>();
		        response.put("deleted", Boolean.TRUE);
		        return response;
		    }
		 
		 
		 //MySQL Query Find Credit cards Owned for Each User
		 
		 @RequestMapping(value = "/findCreditCards", method = RequestMethod.POST, produces = "application/json")
			public ResponseEntity<List<CreditCards>> MySQLQuery(@RequestBody CreditCardDTO transaction)  {
				return ResponseEntity.ok(service.findCreditCard(transaction));

			}
		 
		 
		
		
	
}
