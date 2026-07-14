package com.productdao;

import java.util.List;

public interface ProductDAO {

	void addProduct(Product p);
	void updateProduct(Product p);
	void deleteProduct(int id);
	Product searchProduct(int id);
	List<Product> displayAllProducts();
}
