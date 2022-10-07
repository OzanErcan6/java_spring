package com.example.demo.business.concretes;


import java.util.List;

import com.example.demo.entities.dtos.CategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.business.abstracts.ProductService;
import com.example.demo.core.utilities.results.DataResult;
import com.example.demo.core.utilities.results.Result;
import com.example.demo.core.utilities.results.SuccessDataResult;
import com.example.demo.core.utilities.results.SuccessResult;
import com.example.demo.dataAccess.abstracts.ProductDao;
import com.example.demo.entities.concretes.Product;
import com.example.demo.entities.dtos.ProductWithCategoryDto;


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
	public DataResult<List<Product>> getAllSortedDesc() {
		Sort sort = Sort.by(Sort.Direction.DESC, "productName");
		return new SuccessDataResult <List<Product>>
		(this.productDao.findAll(sort),"Data listelendi");
	}

	@Override
	public DataResult<List<Product>> getAllSortedAsc() {
		Sort sort = Sort.by(Sort.Direction.ASC, "productName");
		return new SuccessDataResult <List<Product>>
		(this.productDao.findAll(sort),"Data listelendi");
	}

	@Override
	public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		return new SuccessDataResult <List<Product>> (this.productDao.findAll(pageable).getContent(),"Data listelendi");
	}

	@Override
	public Result add(Product product) {
		this.productDao.save(product);
		return new SuccessResult("ürün eklendi");
	}

	@Override
	public DataResult<Product> getByProductName(String productName) {
		return new SuccessDataResult <Product>
		(this.productDao.getByProductName(productName),"Data listelendi");
	}

	@Override
	public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
		return new SuccessDataResult <Product>
		(this.productDao.getByProductNameAndCategory_CategoryId(productName,categoryId),"Data listelendi");
	}

	@Override
	public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
		return new SuccessDataResult <List<Product>>
		(this.productDao.getByProductNameOrCategory_CategoryId(productName, categoryId),"Data listelendi");
	}


	@Override
	public DataResult<List<Product>> getByCategoryId(int categoryId) {
		return new SuccessDataResult <List<Product>>
				(this.productDao.getByCategoryId(categoryId),"Data listelendi");
	}
	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		return new SuccessDataResult <List<Product>>
		(this.productDao.getByProductNameContains(productName),"Data listelendi");
	}

	@Override
	public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
		return new SuccessDataResult <List<Product>>
		(this.productDao.getByProductNameStartsWith(productName),"Data listelendi");
	}

	@Override
	public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
		return new SuccessDataResult <List<Product>>
		(this.productDao.getByNameAndCategory(productName,categoryId),"Data listelendi");
	}

	@Override
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
		return new SuccessDataResult <List<ProductWithCategoryDto>>
		(this.productDao.getProductWithCategoryDetails(),"Data listelendi");
	}

	@Override
	public DataResult<List<CategoryDto>> getCategoryTypes() {
		return new SuccessDataResult <List<CategoryDto>>
				(this.productDao.getCategoryTypes(),"Data listelendi");

	}


}
