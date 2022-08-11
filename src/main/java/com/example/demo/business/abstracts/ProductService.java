package com.example.demo.business.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.example.demo.core.utilities.results.DataResult;
import com.example.demo.core.utilities.results.Result;
import com.example.demo.entities.concretes.Product;

// iş kuralları burada yazılır
// or: bir üretici hepsiburada da kendi ürünlerinden max 100 tane ekleyebilir..
public interface ProductService {
	DataResult<List<Product>> getAll();
	
	Result add(Product product);
	
	DataResult<Product> getByProductName(String productName);
	
	DataResult<Product> getByProductNameAndCategory(String productName, int categoryId);
	
	DataResult<List<Product>> getByProductNameOrCategory(String productName, int categoryId);

	DataResult<List<Product>> getByCategoryIn(List<Integer> categories);
	
	DataResult<List<Product>> getByProductNameContains(String productName);
	
	DataResult<List<Product>> getByProductNameStartsWith(String productName);
	
	DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId);

}
