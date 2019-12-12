package pl.beata.springbootonlineshop.services;

import pl.beata.springbootonlineshop.model.Product;

import java.util.List;

public interface ShopOnlineService {

    List<Product> getProducts();
    float getBill();

    String info();
}
