package com.example.demo.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
// dto -> data transformation object 
public class ProductWithCategoryDto {
	private int id;
	private String productName;
	private String categoryName;

}
