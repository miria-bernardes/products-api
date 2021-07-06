package com.bootcamp.products.daos;


import com.bootcamp.products.entities.Product;
import com.bootcamp.products.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductDAO {

    private static List<Product> products = new ArrayList<>();

    public List<Product> getAll() {
        return products;
    }

    public Product getProductById(String id) {
        Optional<Product> produto = products.stream().filter(p -> p.getCode() == id).findFirst();

        if (Objects.isNull(produto)) {
            throw new NotFoundException("Produto não encontrado");
        }

        return produto.get();
    }

    public void add(Product product) {
        products.add(product);
    }

    public Product update(Product product) {
        int indice = 0;

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getCode().equals(product.getCode())) {
                indice = i;
            }
        }

        products.add(indice, product);
        //irá remover o proximo produto da lista
        products.remove(indice + 1);
        return product;
    }

    public void deletarProduto(String codigo) {
        products.removeIf(p -> p.getCode().equals(codigo));
    }
}
