package edu.miu.cs.minionlineshopping.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class Address {

	@Id
	@GeneratedValue
	private long id;

	@Column
	private String street;

	@Column(name = "city")
	private String city;

	@Column(name = "state")
	private String state;

	@Column(name = "zip_code")
	private int zip;

//	@OneToMany(mappedBy = "address", cascade = CascadeType.ALL)
//	List<User> users;

	public Address() {

	}

	public Address(String street, String state, String city, int zip) {
		this.street = street;
		this.state = state;
		this.city = city;
		this.zip = zip;
	}

//	public void addUser(User user) {
//		if (users == null) {
//			users = new ArrayList<User>();
//		}
//		users.add(user);
//	}
//
//	public List<User> getUsers() {
//		return users;
//	}
//
//	public void setUsers(List<User> users) {
//		this.users = users;
//	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", state=" + state + ", city=" + city + ", zip=" + zip + "]";
	}
}
