package com.example.demo.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data // lombok getter ve setter verir
@Entity
@Table(name="categories")
@AllArgsConstructor // lombok parametrelı constructor getirir
@NoArgsConstructor // lombok parametresiz constructor getirir
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","products"})
public class Category {
	@Id
	@Column(name="category_id")
	private int categoryId;
	
	@Column(name="category_name")
	private String categoryName;
	
	//category'lerden productlara one to many iliski var
	@OneToMany(mappedBy = "category")
	private List<Product> products;
}
