package ru.geekbraines.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.geekbraines.model.Product;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


    @Query("select c from Product c where c.cost>(select min(c2.cost) from Product c2)")
   public List<Product> moreThanMinimalCost();

    @Query("select c from Product c where c.cost<(select max(c2.cost) from Product c2)")
    public List<Product> lessThanMaximalCost();


}
