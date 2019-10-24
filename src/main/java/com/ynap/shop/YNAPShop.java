package com.ynap.shop;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.ynap.shop.model.Product;
import com.ynap.shop.service.ProductService;
import com.ynap.shop.util.ShopUtil;

public class YNAPShop {
	double sum;

	ProductService productService = new ProductService();

	/**
	 * Load products from the .csv file
	 * 
	 * @throws IOException
	 */
	public void loadProducts() throws IOException {
		List<String> fileData = productService.loadProducts();

		System.out.println(fileData);
	}

	/**
	 * List available products
	 * 
	 * @throws IOException
	 */
	public List<String> getProducts() throws IOException {

		return productService.loadProducts();
	}

	/**
	 * Display available products
	 * 
	 * @throws IOException
	 */
	public String displayProducts() throws IOException {
		System.out.println("products on display");
		return productService.loadProducts().toString();
	}

	/**
	 * Add a product to the Basket
	 * 
	 * @throws IOException
	 */
	public void addProductToBasket(String productId) throws IOException {

		List<String> productList = productService.loadProducts();

		productList.add(productId);
		List<Product> basket = Arrays.asList(new Product(productList.get(5), productList.get(1), productList.get(2)));
		System.out.println(" product added to basket " + basket);
	}

	/**
	 * Get the items in the basket
	 * 
	 * @throws IOException
	 */
	public List<Product> getBasketItems() throws IOException {

		List<String> productList = productService.loadProducts();

		List<Product> basket = Arrays.asList(new Product(productList.get(5), productList.get(1), productList.get(2)),
				new Product(productList.get(0), productList.get(1), productList.get(6)));

		return basket;
	}

	/**
	 * Remove a product from the Basket
	 * 
	 * @throws IOException
	 */
	public void removeProductFromBasket(String productId) throws IOException {
		List<String> productList = productService.loadProducts();
		productList.remove(productId);
		System.out.println("Remove Product has completed");
	}

	/**
	 * Return the total value of the products in the basket
	 * 
	 * @throws IOException
	 */
	public BigDecimal getTotal() throws IOException {
		/*
		 * extract all the values from the file and split them into comma separated
		 * array replace all pound sign remove all alfabetical charactors remove the
		 * integer count 1 to seven
		 */
		List<String> totalAsListOfStrings = productService.loadProducts().stream().filter(s -> s.contains("."))
				.map(s -> s.replace("£", "")).map(s -> s.replaceAll("[^\\d.]", "")).map(s -> s.substring(1))
				.collect(Collectors.toList());

		// convert the list of strings to a list of doubles

		List<Double> totalAslistOfDoubles = ShopUtil.convertStringListToIntList(totalAsListOfStrings,
				Double::parseDouble);

		// calculate the total
		double total = totalAslistOfDoubles.stream().mapToDouble(Double::doubleValue).sum();
		// return the total with only 2 decimol places

		return BigDecimal.valueOf(ShopUtil.round(total, 2));

	}

}
