package ru.geekbraines.service;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.geekbraines.model.Product;
import ru.geekbraines.repository.ProductRepository;

@Component
public class ProductDataGenerator {

    @Autowired
    private ProductRepository productRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void generateDataOnStartUp(){
        Faker faker = new Faker();

        for (int i = 0; i <20 ; i++) {

        Product product = new Product();
        product.setTitle(faker.animal().name());
        product.setCost(faker.number().numberBetween(10,110));

        productRepository.save(product);

        }

    }



}
