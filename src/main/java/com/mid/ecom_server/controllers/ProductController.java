package com.mid.ecom_server.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mid.ecom_server.models.Product;
import com.mid.ecom_server.repos.ProductRepo;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired ProductRepo productRepo;
	
	@GetMapping("/all")
	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}
	@PostMapping("/add")
	public Product addProduct(@RequestBody Product newproduct) {
		return productRepo.save(newproduct);
	}
	@DeleteMapping("/product/delete/{id}")
	public String deleteProduct(@PathVariable String id) {
		Product findproduct = productRepo.findById(id).get();
		if(findproduct != null) {
			productRepo.deleteById(id);
			return "Product Deleted "+ findproduct.getName();
		}else {
			return "Failed to delete product";
		}
	}
//	@PutMapping("/product/edt/{id")
//	public Product editProduct@Variable String id, @RequestBody Product new product){
//		Product findProduct 
//	}
}
