package com.example.demo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.concretes.Product;

//Product tablosu için integer tipinde primary key için interface
public interface ProductDao extends JpaRepository<Product, Integer>{
}
