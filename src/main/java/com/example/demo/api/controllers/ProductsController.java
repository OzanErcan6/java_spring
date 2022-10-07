package com.example.demo.api.controllers;

import java.util.List;

import com.example.demo.entities.dtos.CategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.abstracts.ProductService;
import com.example.demo.core.utilities.results.DataResult;
import com.example.demo.core.utilities.results.Result;
import com.example.demo.entities.concretes.Product;
import com.example.demo.entities.dtos.ProductWithCategoryDto;

// controller api katmanıdır, dış dünyanya iletişim kurulur
@RestController //  The RestController allows to handle all REST APIs such as GET, POST, Delete, PUT requests.
@RequestMapping("/api/products")
@CrossOrigin
public class ProductsController {

	private ProductService productService;

	@Autowired
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@GetMapping("/getall")
	public DataResult<List<Product>> getAll(){
		return this.productService.getAll();
	}

	@GetMapping("/getallByPage")
	public DataResult<List<Product>> getAll(@RequestParam int pageNo,@RequestParam int pageSize){
		return this.productService.getAll(pageNo, pageSize);
	}

	@GetMapping("/getAllSortedDesc")
	public DataResult<List<Product>> getAllSortedDesc(){
		return this.productService.getAllSortedDesc();
	}

	@GetMapping("/getAllSortedAsc")
	public DataResult<List<Product>> getAllSortedAsc(){
		return this.productService.getAllSortedAsc();
	}

	@PostMapping("/add")
	public Result add(@RequestBody Product product){
		return this.productService.add(product);
	}

	@GetMapping("/getByProductName")
	public DataResult<Product> getByProductName(@RequestParam String productName){
		return this.productService.getByProductName(productName);
	}

	@GetMapping("/getByProductNameAndCategoryId")
	public DataResult<Product> getByProductNameAndCategory(@RequestParam("productName") String productName, @RequestParam("categoryId") int categoryId){
		return this.productService.getByProductNameAndCategoryId(productName, categoryId);
	}

	@GetMapping("/getByProductNameOrCategoryId")
	DataResult<List<Product>> getByProductNameOrCategoryId(@RequestParam("productName") String productName, @RequestParam("categoryId") int categoryId){
		return this.productService.getByProductNameOrCategoryId(productName, categoryId);
	}

	@GetMapping("/getByCategoryId")
	DataResult<List<Product>> getByCategoryId(@RequestParam("categoryId") int categoryId){
		return this.productService.getByCategoryId(categoryId);
	}


	@GetMapping("/getByProductNameContains")
	DataResult<List<Product>> getByProductNameContains(@RequestParam String productName){
		return this.productService.getByProductNameContains(productName);
	}

	@GetMapping("/getProductWithCategoryDetails")
	DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails(){
		return this.productService.getProductWithCategoryDetails();
	}

	@GetMapping("/getCategories")
	DataResult<List<CategoryDto>> getCategories(){
		return this.productService.getCategoryTypes();
	}

}
