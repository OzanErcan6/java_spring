package com.example.demo.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.business.abstracts.ProductService;
import com.example.demo.dataAccess.abstracts.ProductDao;
import com.example.demo.entities.concretes.Product;


@Service
public class ProductManager implements ProductService{
	
	private ProductDao productDao; 
	
	@Autowired
	public ProductManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}
	
	@Override
	public List<Product> getAll(){
		return this.productDao.findAll();
	}
}