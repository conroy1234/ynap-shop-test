package com.ynap.shop.repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * this class read from the file that will be pass to ProductService
 */
public class ProductRepository {

	/**
	 * make constructor private so that class cannot be instantiated out side of
	 * this class
	 */
	private ProductRepository() {

	}

	/**
	 * create a singleton that will be return when ever an instance of this class is
	 * required
	 */
	private static ProductRepository instance;

	/**
	 * Instantiate the instance
	 */
	public static ProductRepository getInstance() {
		instance = new ProductRepository();
		return instance;
	}

	/**
	 * this method read from the file and return a stream of data
	 */
	public Stream<String> readFile(String file) throws IOException {
		Stream<String> stream = Files.lines(Paths.get(file));

		return stream;
	}
}
