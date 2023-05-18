package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Supply;

public interface SupplyRepo extends JpaRepository<Supply, Integer> {

}
