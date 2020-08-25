package edu.miu.cs.minionlineshopping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.miu.cs.minionlineshopping.dao.AddressDao;
import edu.miu.cs.minionlineshopping.dao.BuyerDao;
import edu.miu.cs.minionlineshopping.dao.ProductDao;
import edu.miu.cs.minionlineshopping.dao.SellerDao;
import edu.miu.cs.minionlineshopping.dao.CartDao;
import edu.miu.cs.minionlineshopping.model.Address;
import edu.miu.cs.minionlineshopping.model.Buyer;
import edu.miu.cs.minionlineshopping.model.Cart;
import edu.miu.cs.minionlineshopping.model.Product;
import edu.miu.cs.minionlineshopping.model.Seller;
import edu.miu.cs.minionlineshopping.serviceImpl.AddressServiceImpl;

@Component
public class OnlineShoppingCommandLineRunner implements CommandLineRunner {

	@Autowired
	private SellerDao sellerDao;
	@Autowired
	private BuyerDao buyerDao;
	@Autowired
	private AddressDao addressDao;
	@Autowired
	private CartDao CartDao;
	@Autowired
	private ProductDao productDao;

	@Override
	public void run(String... args) throws Exception {

		// ADDRESS
		Address userAddress = new Address("1000 N 4th Street", "Iowa", "Fairfield", 52557);
		addressDao.save(userAddress);

		// SELLER
		Seller seller = new Seller("Tadiyos", 34, "tadi", "tadi157851", userAddress);
		sellerDao.save(seller);

		// BUYER
		Buyer buyer = new Buyer("Kidist", 33, "kidi", "kidi157851", userAddress, new Cart());
		buyerDao.save(buyer);

		// PRODUCT
		Product product1 = new Product("Tomato", "This is a Tomato", 20.22, seller);
		productDao.save(product1);
		Product product2 = new Product("Apple", "This is an apple", 10.5, seller);
		productDao.save(product2);

		buyer.getCart().addProduct(product1);
//		seller.addProduct(product1);
		buyer.getCart().addProduct(product2);
//		seller.addProduct(product2);
	}

}
