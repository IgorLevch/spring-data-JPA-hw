package ru.geekbraines.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbraines.model.Product;
import ru.geekbraines.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Optional<Product> findById(Long id){
        return productRepository.findById(id);
    }

    public List<Product> getAll(){
        return productRepository.findAll();
    }

    public void delete(Long id){
        productRepository.deleteById(id);

    }

    public List<Product> moreThanMinimalCost(){
        return productRepository.moreThanMinimalCost();
    }

    public List<Product> lessThanMaximalCost(){
        return productRepository.lessThanMaximalCost();
    }








}
