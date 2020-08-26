package edu.miu.cs.minionlineshopping.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs.minionlineshopping.dao.AddressDao;
import edu.miu.cs.minionlineshopping.model.Address;

@Service
public class AddressServiceImpl {

	@Autowired
	AddressDao addressDao;

	public Address createAddress(Address address) {
		return addressDao.save(address);
	}

	public List<Address> findAllAddresses() {
		return addressDao.findAll();
	}

	public Optional<Address> findAnAddresses(Long id) {
		return addressDao.findById(id);
	}

	public Address updateAddress(Address address) {
		return addressDao.save(address);
	}

	public void deleteAddress(Long id) {
		Optional<Address> addressOpt = findAnAddresses(id);

		if (addressOpt.isPresent()) {
			Address addressObj = addressOpt.get();
			addressDao.delete(addressObj);
		}
	}
}
