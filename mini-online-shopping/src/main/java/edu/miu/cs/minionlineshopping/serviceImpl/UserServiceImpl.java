package edu.miu.cs.minionlineshopping.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs.minionlineshopping.dao.UserDao;
import edu.miu.cs.minionlineshopping.model.User;

@Service
public class UserServiceImpl {

	@Autowired
	UserDao userDao;

	public User saveUser(User user) {
		return userDao.save(user);
	}

	public User updateUser(User user) {
		return userDao.save(user);
	}

	public void deleteUser(Long id) {
		userDao.deleteById(id);
	}

	public Optional<User> findUser(Long id) {
		return userDao.findById(id);
	}

	public List<User> findAllUser() {
		return userDao.findAll();
	}
}
