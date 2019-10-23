package com.ynap.shop.service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import com.ynap.shop.repository.ProductRepository;

/**
 * this class act as a service that pass the data that comes from the files
 * receive data from productRepository
 */
public class ProductService {

	/**
	 * path to the file
	 */
	private static final String PATH_TO_FILE = "src/main/resources/product-data.csv";

	/**
	 * return data from product repository
	 * 
	 * @return
	 * @throws IOException
	 */
	public List<String> loadProducts() throws IOException {
		return ProductRepository.getInstance().readFile(PATH_TO_FILE).collect(Collectors.toList());
	}
}
