package kodlamaio.northwind.api.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;


@RestController
@RequestMapping("/api/products")
@CrossOrigin
public class ProductsController {
	
	//Bir kere backend multiple frontend
	
	@Autowired
	private ProductService productsService;
	
	public ProductsController(ProductService productsService) {
		super();
		this.productsService = productsService;
	}

	@GetMapping("/getall")
	public DataResult<List<Product>> getAll(){
		return this.productsService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Product product) {
		return this.productsService.add(product);
	}
	
	@GetMapping("/getByProductName")
	public DataResult<Product> getByProductName(@RequestParam String productName){
		return this.productsService.getByProductName(productName);
		
	}
	
	@GetMapping("/getByProductNameAndCategoryId")
	DataResult<Product> getByProductNameAndCategoryId
	(@RequestParam("productName") String productName, @RequestParam("categoryId") int categoryId){
		return this.productsService.getByProductNameAndCategoryId(productName, categoryId);
	}
	
	@GetMapping("getByProductNameContains")
	public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName){
		return this.productsService.getByProductNameContains(productName);
	}
	
	@GetMapping("/getAllByPage")
	DataResult<List<Product>> getAll(int pageNo, int pageSize){
		return this.productsService.getAll(pageNo, pageSize);
	}
	
	@GetMapping("/getAllDesc")
	public DataResult<List<Product>> getAllSorted(){
		return this.productsService.getAllSorted();
	}
	
	@GetMapping("/getProductWithCategoryDetails")
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails(){
		return this.productsService.getProductWithCategoryDetails();
	}
}