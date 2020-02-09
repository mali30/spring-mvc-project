package com.mohamedali.springmvc.springmvcdemo.services;

import com.mohamedali.springmvc.springmvcdemo.domain.Product;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.math.BigDecimal;
import java.util.*;

@Service
public class ProductServiceImple implements ProductService {

    // persistent storage
    public static Map<Integer,Product> productMap =
            new HashMap<>();




    public ProductServiceImple(){
        // calling in constructor
        loadProducts();
    }



    @Override
    public List<Product> listAllProducts() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public Product getProductById(Integer id) {
        return productMap.get(id);
    }

    @Override
    public Product saveOrUpdate(Product product) throws NullPointerException {
        if(product != null){
            if(product.getId() == null){
                product.setId(getNextKey());
            }
            productMap.put(product.getId() , product);
            return product;
        }else{
            throw new NullPointerException("Cannot be NULL");
        }
    }

    @Override
    public void deleteProduct(Integer productId) {
        if (productId != null) {
                productMap.remove(productId);
            }
        System.out.println("product deleted");
        }


    // gets highest key value adds 1 and returns it.
    private Integer getNextKey() {
        return Collections.max(productMap.keySet()) + 1;
    }

    public void loadProducts(){

        Product product1 = new Product();
        product1.setId(1);
        product1.setDescription("Product 1");
        product1.setImageUrl("http://product.com/1");
        product1.setPrice(new BigDecimal("100.20"));


        Product product2 = new Product();

        product2.setId(2);
        product2.setDescription("Product 2");
        product2.setImageUrl("http://product.com/2");
        product2.setPrice(new BigDecimal("100.20"));

        Product product3 = new Product();
        product3.setId(3);
        product3.setDescription("Product 3");
        product3.setImageUrl("http://product.com/3");
        product3.setPrice(new BigDecimal("100.20"));





        productMap.put(1, product1);
        productMap.put(2, product2);
        productMap.put(3, product3);

    }
}
