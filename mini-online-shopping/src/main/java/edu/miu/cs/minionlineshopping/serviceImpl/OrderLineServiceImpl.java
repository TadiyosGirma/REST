package edu.miu.cs.minionlineshopping.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs.minionlineshopping.dao.OrderLineDao;
import edu.miu.cs.minionlineshopping.model.OrderLine;

@Service
public class OrderLineServiceImpl {

	@Autowired
	OrderLineDao orderLineDao;

	public Optional<OrderLine> findAOrderLine(Long id) {
		return orderLineDao.findById(id);
	}

	public List<OrderLine> findAllOrderLines() {
		return orderLineDao.findAll();
	}
}
