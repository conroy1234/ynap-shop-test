package com.ynap.shop;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

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
		System.out.println(basket.get(0));
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
		List<String> productList = productService.loadProducts();

		// extract all the values from the file and split them into comma separated
		// array
		String intLines[][] = { ShopUtil.splitter(productList.get(1)), ShopUtil.splitter(productList.get(2)),
				ShopUtil.splitter(productList.get(3)), ShopUtil.splitter(productList.get(4)),
				ShopUtil.splitter(productList.get(5)), ShopUtil.splitter(productList.get(6)),
				ShopUtil.splitter(productList.get(7)) };

		// extract all the cost and into a separate array
		String digitExtracter[] = { intLines[0][2], intLines[1][2], intLines[2][2], intLines[3][2], intLines[4][2],
				intLines[5][2], intLines[6][2] };

		// remove the pound sign so that the values can be calculated
		String replacingArray[] = { ShopUtil.replacing(digitExtracter[0], "£", ""),
				ShopUtil.replacing(digitExtracter[1], "£", ""), ShopUtil.replacing(digitExtracter[2], "£", ""),
				ShopUtil.replacing(digitExtracter[3], "£", ""), ShopUtil.replacing(digitExtracter[4], "£", ""),
				ShopUtil.replacing(digitExtracter[5], "£", ""), ShopUtil.replacing(digitExtracter[6], "£", "") };

		// place all the double values into a double array ready to sum all the values
		double totalValue[] = { Double.parseDouble(replacingArray[0]), Double.parseDouble(replacingArray[1]),
				Double.parseDouble(replacingArray[2]), Double.parseDouble(replacingArray[3]),
				Double.parseDouble(replacingArray[4]), Double.parseDouble(replacingArray[5]),
				Double.parseDouble(replacingArray[6]) };

		// loop through the total value array and add the values to sum
		for (double result : totalValue) {
			sum += result;

		}
		double total = ShopUtil.round(sum, 2);
		System.out.println(" total :" + total);

		return BigDecimal.valueOf(total);
	}

}
