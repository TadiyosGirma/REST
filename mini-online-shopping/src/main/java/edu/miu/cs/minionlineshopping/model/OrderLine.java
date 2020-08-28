package edu.miu.cs.minionlineshopping.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class OrderLine {

	@Id
	@GeneratedValue
	private long id;

	@OneToOne
	@JoinColumn(name = "cart_id")
	private Cart cart;

	@Column
	private double totalBeforeTax;

	@Column
	private Tax tax;

	@Column
	private double totalAfterTax;

	public OrderLine() {

	}

	public OrderLine(Cart cart, Tax taxPercentage) {
		this.cart = cart;
		tax = taxPercentage;
		calculatePayment(cart);
	}

	private void calculatePayment(Cart cart) {

		List<CartItem> cartItems = cart.getCartItems();

		for (CartItem cartItem : cartItems) {
			totalBeforeTax += (cartItem.getQuantity() * cartItem.getProduct().getPrice());
		}

		totalAfterTax = tax.getValue()/100 * totalBeforeTax;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public double getTotalBeforeTax() {
		return totalBeforeTax;
	}

	public void setTotalBeforeTax(double totalBeforeTax) {
		this.totalBeforeTax = totalBeforeTax;
	}

	public Tax getTax() {
		return tax;
	}

	public void setTax(Tax tax) {
		this.tax = tax;
	}

	public double getTotalAfterTax() {
		return totalAfterTax;
	}

	public void setTotalAfterTax(double totalAfterTax) {
		this.totalAfterTax = totalAfterTax;
	}
}
