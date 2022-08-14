package com.example.demo.business.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.example.demo.core.utilities.results.DataResult;
import com.example.demo.core.utilities.results.Result;
import com.example.demo.entities.concretes.Product;
import com.example.demo.entities.dtos.ProductWithCategoryDto;

// iş kuralları burada yazılır
// or: bir üretici hepsiburada da kendi ürünlerinden max 100 tane ekleyebilir..
@Service
public interface ProductService {
	DataResult<List<Product>> getAll();
	
	DataResult<List<Product>> getAllSortedDesc();
	
	DataResult<List<Product>> getAllSortedAsc();

	DataResult<List<Product>> getAll(int pageNo, int pageSize);

	Result add(Product product);
	
	DataResult<Product> getByProductName(String productName);
	
	DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId);
  
	DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId);

	DataResult<List<Product>> getByCategoryIn(List<Integer> categories);
	
	DataResult<List<Product>> getByProductNameContains(String productName);
	
	DataResult<List<Product>> getByProductNameStartsWith(String productName);
	
	DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId);

	DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();

	
}
