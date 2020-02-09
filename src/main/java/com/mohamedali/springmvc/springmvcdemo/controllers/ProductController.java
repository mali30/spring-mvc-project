package com.mohamedali.springmvc.springmvcdemo.controllers;


import com.mohamedali.springmvc.springmvcdemo.domain.Product;
import com.mohamedali.springmvc.springmvcdemo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {

    private ProductService productService;

    // doing dependency injection here
    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }




    @RequestMapping("/products")
    public String listProducts(Model model){
        // appending attributes to the model
        model.addAttribute("products" , productService.listAllProducts());
        return "products";
    }

    @RequestMapping("/product/{id}")
    public String getProductById(@PathVariable Integer id , Model model){
        model.addAttribute("product", productService.getProductById(id));
        return "product";
    }



    @RequestMapping("/product/edit/{id}")
    public String editProductById(@PathVariable Integer id , Model model){
        model.addAttribute("product", productService.getProductById(id));
        return "productForm";
    }

    @RequestMapping("/product/new")
    public String newProduct(Model model){
        model.addAttribute("product", new Product());
        return "productForm";
    }

    @RequestMapping(value = "/product")
    public String saveOrUpdate(Product product) {
        Product savedProduct = productService.saveOrUpdate(product);
        // redirects to the saved product
        return "redirect:/product/" + savedProduct.getId();
    }


    @RequestMapping(value = "/product/delete/{id}" )
        public String deleteProduct(@PathVariable("id") Integer productId){
        productService.deleteProduct(productId);
//        Integer deletedProduct = productService.deleteProduct(productId);
        return "redirect:/products";
    }






}
