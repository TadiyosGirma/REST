package edu.miu.cs.minionlineshopping.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs.minionlineshopping.exceptions.OrderLineNotFoundException;
import edu.miu.cs.minionlineshopping.model.OrderLine;
import edu.miu.cs.minionlineshopping.serviceImpl.OrderLineServiceImpl;

@RestController
public class OrderLineController {

	@Autowired
	OrderLineServiceImpl orderLineService;

	@GetMapping("/buyers/{id}/carts/{cartId}/orderLines/{orderLineId}")
	public Optional<OrderLine> retriveOrderLine(@PathVariable Long orderLineId) {
		Optional<OrderLine> orderLineReturned = orderLineService.findAOrderLine(orderLineId);

		if (!orderLineReturned.isPresent()) {
			throw new OrderLineNotFoundException("iddddd: " + orderLineId);
		} else {
			return orderLineReturned;
		}
	}

	@GetMapping("/buyers/{id}/carts/{cartId}/orderLines")
	public List<OrderLine> retriveAllOrderLines() {
		List<OrderLine> orderLinesReturned = orderLineService.findAllOrderLines();

		if (orderLinesReturned.isEmpty()) {
			throw new OrderLineNotFoundException("There are no order lines for this user");
		} else {
			return orderLinesReturned;
		}
	}

}
