package com.CreditCard.Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.CreditCard.Model.Users;
import com.CreditCard.Service.CreditCardService;
import com.CreditCard.address.HomeAddress;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ControllerTest {


	 @Autowired
	  MockMvc mockMvc;

	  @Autowired
	  ObjectMapper objectMapper;
	  
	  @MockBean
	  CreditCardService serviceimpl;
	

	  
	  
	  
	  
	  
	  @Test
	  @Order(1)
	  public void testAddUser() throws Exception {

		  Users user = getUserProfile();
			
	       
	      mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8085/xpay/addUser")
	              .contentType(MediaType.APPLICATION_JSON)
	              .content(objectMapper.writeValueAsString(user))
	              .accept(MediaType.APPLICATION_JSON))
	              .andExpect(status().isOk());
	  }
  
	  
	  
	  @Test
	  @Order(3)
	  public void getAllUser() throws Exception 
	  {
		  mockMvc.perform(MockMvcRequestBuilders
	    			.get("/xpay/GetAllUser")
	    			.accept(MediaType.APPLICATION_JSON))
	        .andDo(print())
	        .andExpect(status().isOk());
	     
	  }  
	
	   
	   @Test
	   @Order(2)
	   public void updateUser() throws Exception {
	      String uri = "http://localhost:8085/xpay/UpdateUser/1";
	      Users user = new Users();
	      user.setName("James Bond");
	      
	      String inputJson = mapToJson(user);
	      MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	     
	   }
	   
	   
	   
	   
	   
//		  @Test
//		  @Order(4)
//		  public void DeleteUser() throws Exception 
//		  {
//			  String uri = "http://localhost:8085/xpay/deleteUser/13";
//			  
//		      MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
//		      int status = mvcResult.getResponse().getStatus();
//		      assertEquals(200, status);
//		   
//		   }
	   
		  
		  
		  
		  
	  
	    String mapToJson(Object obj) throws JsonProcessingException {
		      ObjectMapper objectMapper = new ObjectMapper();
		      return objectMapper.writeValueAsString(obj);
		   }
		    <T> T mapFromJson(String json, Class<T> clazz)
		      throws JsonParseException, JsonMappingException, IOException {
		      
		      ObjectMapper objectMapper = new ObjectMapper();
		      return objectMapper.readValue(json, clazz);
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

