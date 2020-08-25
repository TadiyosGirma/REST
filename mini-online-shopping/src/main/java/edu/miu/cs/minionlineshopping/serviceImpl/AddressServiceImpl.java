package edu.miu.cs.minionlineshopping.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs.minionlineshopping.dao.AddressDao;
import edu.miu.cs.minionlineshopping.model.Address;

@Service
public class AddressServiceImpl {

	@Autowired
	AddressDao addressDao;

	public void createAddress(Address address) {
		addressDao.save(address);
	}
}
