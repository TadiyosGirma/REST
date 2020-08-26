package edu.miu.cs.minionlineshopping.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.miu.cs.minionlineshopping.model.CartItem;

@Repository
public interface CartItemDao extends JpaRepository<CartItem, Long> {

}
