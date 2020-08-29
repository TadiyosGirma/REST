package edu.miu.cs.minionlineshopping.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import edu.miu.cs.minionlineshopping.dao.AddressDao;
import edu.miu.cs.minionlineshopping.exceptions.AddressNotFoundException;
import edu.miu.cs.minionlineshopping.model.Address;

@Service
public class AddressServiceImpl {

	@Autowired
	AddressDao addressDao;

	public ResponseEntity<Address> createAddress(Address address) {
		Address savedAddress = addressDao.save(address);
		return new ResponseEntity<Address>(savedAddress, HttpStatus.CREATED);
	}

	public List<Address> findAllAddresses() {
		List<Address> addressesReturned = addressDao.findAll();

		if (addressesReturned.isEmpty()) {
			throw new AddressNotFoundException("There are no registered addresses");
		} else {
			return addressesReturned;
		}
	}

	public Optional<Address> findAnAddresses(Long id) {
		Optional<Address> addressReturned = addressDao.findById(id);

		if (!addressReturned.isPresent()) {
			throw new AddressNotFoundException("id: " + id);
		} else {
			return addressReturned;
		}
	}

	public ResponseEntity<Address> updateAddress(Long id, Address address) {
		Optional<Address> addressExisting = addressDao.findById(id);

		if (!addressExisting.isPresent()) {
			throw new AddressNotFoundException("id: " + id);
		} else {
			Address addressUpdated = addressDao.save(address);
			return new ResponseEntity<Address>(addressUpdated, HttpStatus.CREATED);
		}
	}

	public void deleteAddress(Long id) {
		Optional<Address> address = addressDao.findById(id);

		if (!address.isPresent()) {
			throw new AddressNotFoundException("id: " + id);
		} else {
			addressDao.deleteById(id);
		}
	}
}
