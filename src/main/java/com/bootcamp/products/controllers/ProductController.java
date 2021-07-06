package com.bootcamp.products.controllers;

import com.bootcamp.products.entities.Product;
import com.bootcamp.products.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    @ResponseBody
    public List<Product> getProducts() {
        return productService.getAll();
    }

    @PostMapping
    public ResponseEntity<Product> add(@RequestBody Product product, UriComponentsBuilder uriBuilder) {
        productService.add(product);
        URI uri = uriBuilder.path("product/{id}").buildAndExpand(product.getCode()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        productService.deleteProductById(id);
    }

    @PutMapping
    public ResponseEntity<Product> update(@RequestBody Product product) {
        return new ResponseEntity<>(productService.update(product), HttpStatus.OK);
    }
}
