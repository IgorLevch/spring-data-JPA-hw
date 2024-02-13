package ru.geekbraines.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.geekbraines.model.Product;
import ru.geekbraines.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        return productService.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public List<Product> getAll(){
        return productService.getAll();
    }


    @DeleteMapping("/delete/{id}")
    public void remove(@PathVariable Long id){
        productService.delete(id);

    }
    @GetMapping("/more_min")
    public List<Product> moreThanMinimalCost(){
            return productService.moreThanMinimalCost();
    }
    @GetMapping("/less_max")
    public List<Product> lessThanMaximalCost(){
        return productService.lessThanMaximalCost();
    }


}
