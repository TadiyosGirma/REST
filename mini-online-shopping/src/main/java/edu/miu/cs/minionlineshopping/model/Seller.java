package edu.miu.cs.minionlineshopping.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Seller extends User {

	@JsonIgnoreProperties("seller")
	@OneToMany(mappedBy = "seller", cascade = CascadeType.ALL)
	private List<Product> products;

	protected Seller() {

	}

	public Seller(String name, int age, String userName, String passWord, Address address) {
		super(name, age, userName, passWord, address);
	}

	public void addProduct(Product product) {
		if (products == null) {
			products = new ArrayList<Product>();
			products.add(product);
		} else {
			products.add(product);
		}
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

//	@Override
//	public String toString() {
//		return "Seller [products=" + products + "]";
//	}
}
