package com.example.demo.business.abstracts;

import java.util.List;

import com.example.demo.entities.concretes.Product;

public interface ProductService {
	List<Product> getAll();
}
