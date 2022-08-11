package com.example.demo.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.concretes.Product;

//Product tablosu için integer tipinde primary key için interface
public interface ProductDao extends JpaRepository<Product, Integer>{
	Product getByProductName(String productName);
	
	Product getByProductNameAndCategory(String productName, int categoryId);
	
	List<Product> getByProductNameOrCategory(String productName, int categoryId);

	List<Product> getByCategoryIn(List<Integer> categories);
	
	List<Product> getByProductNameContains(String productName);
	
	List<Product> getByProductNameStartsWith(String productName);
	
	//Veritabani tablosu değil entitydeki isimleri kullan
	@Query("From Product where productName=:productName and category.categoryId=:categoryId")
	List<Product> getByNameAndCategory(String productName, int categoryId);

}
