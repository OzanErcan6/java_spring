package com.example.demo.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.business.abstracts.ProductService;
import com.example.demo.core.utilities.results.DataResult;
import com.example.demo.core.utilities.results.Result;
import com.example.demo.core.utilities.results.SuccessDataResult;
import com.example.demo.core.utilities.results.SuccessResult;
import com.example.demo.dataAccess.abstracts.ProductDao;
import com.example.demo.entities.concretes.Product;


// asıl işlerin yapıldığı yer
@Service
public class ProductManager implements ProductService{
	
	private ProductDao productDao; 
	
	
	@Autowired // ProductDao'nun somut olan bir sınıfının newlenmiş nesnesini sağlar
	public ProductManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}
	
	@Override
	public 	DataResult <List<Product>> getAll(){
		return new SuccessDataResult <List<Product>>
			(this.productDao.findAll(),"Data listelendi");
	}

	@Override
	public Result add(Product product) {
		this.productDao.save(product);
		return new SuccessResult("ürün eklendi");
	}
}