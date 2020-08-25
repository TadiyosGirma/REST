package edu.miu.cs.minionlineshopping.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.miu.cs.minionlineshopping.model.Cart;

public interface CartDao extends JpaRepository<Cart, Long> {

}
