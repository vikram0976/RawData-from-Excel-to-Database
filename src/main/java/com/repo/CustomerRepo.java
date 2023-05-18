package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer,Integer> {
	

}
