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
import edu.miu.cs.minionlineshopping.dao.CartItemDao;
import edu.miu.cs.minionlineshopping.model.Address;
import edu.miu.cs.minionlineshopping.model.Buyer;
import edu.miu.cs.minionlineshopping.model.Cart;
import edu.miu.cs.minionlineshopping.model.CartItem;
import edu.miu.cs.minionlineshopping.model.OrderLine;
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
	@Autowired
	private CartItemDao cartItemDao;

	@Override
	public void run(String... args) throws Exception {

		// ADDRESS
		Address userAddress = new Address("1000 N 4th Street", "Iowa", "Fairfield", 52557);
		addressDao.save(userAddress);

		Address userAddress2 = new Address("1000 N 4th Street", "Dallas", "Texas", 56558);
		addressDao.save(userAddress2);

		// SELLER
		Seller seller = new Seller("Tadiyos", 34, "tadi", "tadi157851", userAddress);
		sellerDao.save(seller);

		// BUYER
		Buyer buyer = new Buyer("Kidist", 33, "kidi", "kidi157851", userAddress, new Cart());
		buyerDao.save(buyer);

		Buyer buyer2 = new Buyer("Blen", 33, "blen", "blen157851", userAddress2, new Cart());
		buyerDao.save(buyer2);

		// PRODUCT
		Product product1 = new Product("Tomato", "This is a Tomato", 20.22, seller);
		productDao.save(product1);
		Product product2 = new Product("Apple", "This is an apple", 10.5, seller);
		productDao.save(product2);

		// CART ITEM
		CartItem cartItem1 = new CartItem(product1, 2);
		CartItem cartItem2 = new CartItem(product2, 5);
		cartItemDao.save(cartItem1);
		cartItemDao.save(cartItem2);

		CartItem cartItem3 = new CartItem(product2, 15);
		cartItemDao.save(cartItem3);

		// ADD PRODUT INTO A CART
		// INTO BUYER1
		Cart cart = buyer.getCart();

		cart.addCartItem(cartItem1);
		cart.addCartItem(cartItem2);
		CartDao.save(cart);

		// INTO BUYER2
		Cart cart2 = buyer2.getCart();
		cart2.addCartItem(cartItem3);
		CartDao.save(cart2);

		// ORDER LINE
//		OrderLine orderLine1 = new OrderLine(quantity, cart2)

	}

}
