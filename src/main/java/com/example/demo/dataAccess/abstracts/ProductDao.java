package com.example.demo.dataAccess.abstracts;

import java.util.List;

import com.example.demo.entities.dtos.CategoryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.concretes.Product;
import com.example.demo.entities.dtos.ProductWithCategoryDto;

//Product tablosu için integer tipinde primary key için interface
public interface ProductDao extends JpaRepository<Product, Integer>{

	// get by where product_name = productName
	Product getByProductName(String productName);

	Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);

	List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);

	List<Product> getByCategoryIn(List<Integer> categories);

	List<Product> getByProductNameContains(String productName);

	List<Product> getByProductNameStartsWith(String productName);

	//Veritabani tablosu değil entitydeki isimleri kullan
	@Query("From Product where productName=:productName and category.categoryId=:categoryId")
	List<Product> getByNameAndCategory(String productName, int categoryId);

	// asagidaki sorgu ->  Select p.product_id, p.product_name, c.category_name from products p inner join categories c on c.category_id = p.category_id
	// daha cok sorgu -> Select p.product_id, p.product_name, c.category_name from categories c inner join products p on p.category_id = c.category_id
	@Query("Select new com.example.demo.entities.dtos.ProductWithCategoryDto(p.id, p.productName, c.categoryName) From Category c Inner Join c.products p")
	List <ProductWithCategoryDto> getProductWithCategoryDetails();

	@Query("Select new com.example.demo.entities.dtos.CategoryDto(c.categoryId, c.categoryName, c.description) From Category c")
	List <CategoryDto> getCategoryTypes();
}
