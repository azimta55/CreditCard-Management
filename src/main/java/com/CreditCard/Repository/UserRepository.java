package com.CreditCard.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.CreditCard.Model.CreditCards;
import com.CreditCard.Model.Users;

public interface UserRepository extends JpaRepository<Users, Long> {
	
	@Query(value = "SELECT u.creditcards FROM Users u WHERE u.userId=?1")
	public List<CreditCards> findCreditCardsById(Long userId);

	
	


}
