package com.ecommerce.app.controllers;

import com.ecommerce.app.model.Product;
import com.ecommerce.app.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/clone")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public List<Product> getAll(){
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProduct(@PathVariable("id") int id){
        return productService.getProduct(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Product save(@RequestBody Product product){
        return productService.save(product);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Product update(@RequestBody Product product){
        return productService.update(product);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return productService.delete(id);
    }

    @GetMapping("/price/{price}")
    public List<Product> getByPrice(@PathVariable("price") double price){
        return productService.getByPrice(price);
    }

    @GetMapping("/description/{description}")
    public List<Product> getByDescriptionContains(@PathVariable("description") String description){
        return productService.getByDescriptionContains(description);
    }
}
