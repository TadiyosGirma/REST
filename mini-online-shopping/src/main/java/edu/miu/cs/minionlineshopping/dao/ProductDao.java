package edu.miu.cs.minionlineshopping.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.miu.cs.minionlineshopping.model.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Long> {

}
