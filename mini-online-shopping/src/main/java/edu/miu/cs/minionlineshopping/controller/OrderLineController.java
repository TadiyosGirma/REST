package edu.miu.cs.minionlineshopping.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs.minionlineshopping.model.OrderLine;
import edu.miu.cs.minionlineshopping.serviceImpl.OrderLineServiceImpl;

@RestController
public class OrderLineController {

	@Autowired
	OrderLineServiceImpl orderLineService;

	@GetMapping("/buyers/{id}/carts/{cartId}/orderLines")
	public List<OrderLine> findAllOrderLines() {
		return orderLineService.findAllOrderLines();
	}

	@GetMapping("/buyers/{id}/carts/{cartId}/orderLines/{orderLineId}")
	public Optional<OrderLine> findAnOrderLine(@PathVariable Long orderLineId) {
		return orderLineService.findAOrderLine(orderLineId);
	}
}
