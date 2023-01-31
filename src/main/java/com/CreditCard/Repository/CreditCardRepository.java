package com.CreditCard.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CreditCard.Model.CreditCards;

public interface CreditCardRepository extends JpaRepository<CreditCards, Long> {
	
	
	

}
