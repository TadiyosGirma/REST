package edu.miu.cs.minionlineshopping.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Seller extends User {

	@OneToMany(mappedBy = "seller")
	private List<Product> products;

	public Seller() {

	}

	public Seller(String name, int age, String userName, String passWord, Address address) {
		super(name, age, userName, passWord, address);
	}

	public void addProduct(Product product) {
		products.add(product);
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Seller [products=" + products + "]";
	}
}
