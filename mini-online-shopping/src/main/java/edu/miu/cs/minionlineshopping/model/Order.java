package edu.miu.cs.minionlineshopping.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Order {

	@Id
	@GeneratedValue
	private long id;

	@Column(name = "order_date")
	private Date orderDate;

	@Column(name = "arrival_date")
	private Date arrivalDate;

	@ManyToOne
	@JoinColumn(name = "buyer_id")
	private Buyer buyer;

	@OneToOne
	@JoinColumn(name = "orderLine_id")
	private OrderLine orderLine;

	public Order() {

	}

	public Order(Date orderDate, Date arrivalDate, Buyer buyer, OrderLine orderLine) {
		this.orderDate = orderDate;
		this.arrivalDate = arrivalDate;
		this.buyer = buyer;
		this.orderLine = orderLine;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public Buyer getBuyer() {
		return buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

	public OrderLine getOrderLine() {
		return orderLine;
	}

	public void setOrderLine(OrderLine orderLine) {
		this.orderLine = orderLine;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderDate=" + orderDate + ", arrivalDate=" + arrivalDate + ", buyer=" + buyer
				+ ", orderLine=" + orderLine + "]";
	}
}
