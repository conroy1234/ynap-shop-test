package com.ynap.shop;

import java.io.IOException;

public class Main {
	public static void main(String args[]) throws IOException {
		YNAPShop shop = new YNAPShop();
		shop.loadProducts();
//		shop.getProducts();
//		shop.displayProducts();
//		shop.addProductToBasket("5");
//		shop.addProductToBasket("1");
//		shop.addProductToBasket("1");
//		shop.addProductToBasket("5");
//		shop.removeProductFromBasket("1");
//		shop.addProductToBasket("7");
//		shop.addProductToBasket("1");
//		shop.addProductToBasket("2");
//		shop.addProductToBasket("3");
//		shop.addProductToBasket("4");
//		shop.addProductToBasket("5");
//		shop.addProductToBasket("6");
//		shop.addProductToBasket("7");
		shop.getTotal();
		

	}
}
