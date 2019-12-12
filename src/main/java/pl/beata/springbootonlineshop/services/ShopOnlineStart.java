package pl.beata.springbootonlineshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.beata.springbootonlineshop.model.Product;
import pl.beata.springbootonlineshop.utils.Calculation;

import java.util.ArrayList;
import java.util.List;

@Service
@Profile("start")
@Primary
public class ShopOnlineStart implements ShopOnlineService {

    private List<Product> products = new ArrayList<>();
    private Calculation calculation;

    @Autowired
    public ShopOnlineStart(Calculation calculation) {
        this.calculation = calculation;
    }

    @Override
    public List<Product> getProducts() {

        products.add(new Product("masło", calculation.getRandomNumber()));
        products.add(new Product("chleb", calculation.getRandomNumber()));
        products.add(new Product("szynka", calculation.getRandomNumber()));
        products.add(new Product("mleko", calculation.getRandomNumber()));
        products.add(new Product("jajka", calculation.getRandomNumber()));

        return products;
    }

    @Override
    public float getBill() {
        float bill = products
                .stream()
                .map(p -> p.getPrice())
                .reduce(0.0f, Float::sum);

        return bill;
    }

    @Override
    public String info() {
        return "Start";
    }
}
