package com.example.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.northwind.business.abstracts.ProductService;
import com.example.northwind.core.utilities.results.DataResult;
import com.example.northwind.core.utilities.results.Result;
import com.example.northwind.entities.concretes.Product;
import com.example.northwind.entities.dtos.ProductWithCategoryDto;

@RestController
@RequestMapping("/api/products")
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
	
	@GetMapping("/getProductWithCategoryDto")
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDto() {
		return this.productService.getProductWithCategoryDetails();
	}
	
	@GetMapping("/add")
	public Result add(@RequestBody Product product) {
		return this.productService.add(product);
	}
	
	@GetMapping("/getByProductName")
	public DataResult<Product> getByProductName(@RequestParam String productName) {
		return this.productService.getByProductName(productName);
	}
	 
	@GetMapping("/getByProductNameAndCategory")
	public DataResult<List<Product>> getByProductNameAndCategory (@RequestParam("productName") String productName,@RequestParam("categoryId") int categoryId){
		return this.productService.getByNameAndCategory(productName, categoryId);
	}
	
	@GetMapping("/getByProductNameOrCategory_CategoryId")
	public DataResult<List<Product>> getByProductNameOrCategory_CategoryId(@RequestParam String productName,@RequestParam int categoryId){
		return this.productService.getByProductNameOrCategory_CategoryId(productName, categoryId);
	}
	
	@GetMapping("/getByCategory_CategoryIdIn")
	public DataResult<List<Product>> getByCategory_CategoryIdIn(@RequestParam List<Integer> categories){
		return this.productService.getByCategory_CategoryIdIn( categories);
	}
	
	@GetMapping("/getByProductNameContains")
	public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName){
		return this.productService.getByProductNameContains(productName);
	}
	
	@GetMapping("/getByProductNameStartsWith")
	public DataResult<List<Product>> getByProductNameStartsWith(@RequestParam String productName){
		return this.productService.getByProductNameStartsWith(productName);
	}
	
	@GetMapping("/getByNameAndCategory")
	public DataResult<List<Product>> getByNameAndCategory(@RequestParam String productName,@RequestParam int categoryId){
		return this.productService.getByNameAndCategory(productName, categoryId);
	}
	
	@GetMapping("/getAllByPage")
	DataResult<List<Product>> getAll(int pageNo, int pageSize){
		return this.productService.getAll(pageNo, pageSize);
	}
	
	@GetMapping("/getAllDesc")
	public DataResult<List<Product>> getAllSorted() {
		return this.productService.getAllSorted();
	}
	
	
	
	
	
	

}
