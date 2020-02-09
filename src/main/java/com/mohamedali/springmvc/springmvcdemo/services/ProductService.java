package com.mohamedali.springmvc.springmvcdemo.services;

import com.mohamedali.springmvc.springmvcdemo.domain.Product;

import java.util.List;

public interface ProductService {

    List<Product> listAllProducts();
    Product getProductById(Integer id);
    Product saveOrUpdate(Product product);

    void deleteProduct(Integer productId);
}
