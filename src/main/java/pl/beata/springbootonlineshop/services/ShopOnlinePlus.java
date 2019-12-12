package pl.beata.springbootonlineshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.beata.springbootonlineshop.model.Product;
import pl.beata.springbootonlineshop.utils.Calculation;
import pl.beata.springbootonlineshop.utils.CalculationProperties;

import java.util.ArrayList;
import java.util.List;

@Service
@Profile("plus")
public class ShopOnlinePlus implements ShopOnlineService {
    private List<Product> products = new ArrayList<>();
    private CalculationProperties calculationProperties;
    private Calculation calculation;

    @Autowired
    public ShopOnlinePlus(CalculationProperties calculationProperties, Calculation calculation) {
        this.calculationProperties = calculationProperties;
        this.calculation = calculation;
    }

    @Override
    public List<Product> getProducts() {
        products.add(new Product("spodnie", calculation.getRandomNumber()));
        products.add(new Product("koszula", calculation.getRandomNumber()));
        products.add(new Product("garnitur", calculation.getRandomNumber()));
        products.add(new Product("krawat", calculation.getRandomNumber()));
        products.add(new Product("buty", calculation.getRandomNumber()));

        return products;
    }

    @Override
    public float getBill() {
        float netto = products
                .stream()
                .map(p -> p.getPrice())
                .reduce(0.0f, Float::sum);

        float vat = calculation.getPercent(netto, calculationProperties.getVat());

        return netto + vat;
    }

    @Override
    public String info() {
        return "Plus";
    }
}
