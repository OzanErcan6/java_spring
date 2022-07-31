package com.example.demo.business.abstracts;

import java.util.List;

import com.example.demo.core.utilities.results.DataResult;
import com.example.demo.core.utilities.results.Result;
import com.example.demo.entities.concretes.Product;

// iş kuralları burada yazılır
// or: bir üretici hepsiburada da kendi ürünlerinden max 100 tane ekleyebilir..
public interface ProductService {
	DataResult<List<Product>> getAll();
	Result add(Product product);
}
