package edu.miu.cs.minionlineshopping.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.miu.cs.minionlineshopping.model.Address;

@Repository
public interface AddressDao extends JpaRepository<Address, Long> {

}
