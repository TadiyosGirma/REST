package edu.miu.cs.minionlineshopping.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class CustomerOrder {

	@Id
	@GeneratedValue
	private long id;

	@Column
	private Date orderDate;

	@Column
	private Date arrivalDate;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private Buyer buyer;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "order_line_id")
	private OrderLine orerLine;

	protected CustomerOrder() {

	}

	public CustomerOrder(Date orderDate, Date arrivalDate, OrderLine orerLine) {
		this.orderDate = orderDate;
		this.arrivalDate = arrivalDate;
//		this.buyer = buyer;
		this.orerLine = orerLine;
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

	public void setOrderDate(Date orderDarte) {
		this.orderDate = orderDarte;
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

	public OrderLine getOrerLine() {
		return orerLine;
	}

	public void setOrerLine(OrderLine orerLine) {
		this.orerLine = orerLine;
	}

	@Override
	public String toString() {
		return "Order2 [id=" + id + ", orderDarte=" + orderDate + ", arrivalDate=" + arrivalDate + ", buyer=" + buyer
				+ ", orerLine=" + orerLine + "]";
	}
}
