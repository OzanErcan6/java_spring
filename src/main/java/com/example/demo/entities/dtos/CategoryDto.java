package com.example.demo.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
// dto -> data transformation object
public class CategoryDto {
    private int categoryId;
    private String categoryName;
    private String description;
}
