package edu.miu.cs.minionlineshopping.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Product {

	@Id
	@GeneratedValue
	private long id;

	@Column
	private String name;

	@Column
	private String description;

	@Column
	private double price;

	@JsonIgnoreProperties("products")
	@ManyToOne
	private Seller seller;

	protected Product() {

	}

	public Product(String name, String description, double price, Seller seller) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.seller = seller;
		this.seller.addProduct(this);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", seller=" + seller.toString() + "]";
	}
}
