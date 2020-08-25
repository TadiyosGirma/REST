package edu.miu.cs.minionlineshopping.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.miu.cs.minionlineshopping.model.Buyer;

public interface BuyerDao extends JpaRepository<Buyer, Long> {

}
