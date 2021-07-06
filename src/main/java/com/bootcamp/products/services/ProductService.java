package com.bootcamp.products.services;


import com.bootcamp.products.daos.ProductDAO;
import com.bootcamp.products.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductDAO productDAO;

    public void add(Product product) {
        productDAO.add(product);
    }

    public List<Product> getAll() {
        return productDAO.getAll();
    }

    public Product getProductById(String id) {
        return productDAO.getProductById(id);
    }

    public Product update(Product product) {
        return productDAO.update(product);
    }

    public void deleteProductById(String id) {
        productDAO.deletarProduto(id);
    }
}
