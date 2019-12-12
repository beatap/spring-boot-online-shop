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
@Profile("pro")
public class ShopOnlinePro implements ShopOnlineService {

    private List<Product> products = new ArrayList<>();
    private CalculationProperties calculationProperties;
    private Calculation calculation;


    @Autowired
    public ShopOnlinePro(CalculationProperties calculationProperties, Calculation calculation) {
        this.calculationProperties = calculationProperties;
        this.calculation = calculation;
    }

    @Override
    public List<Product> getProducts() {

        products.add(new Product("telewizor", calculation.getRandomNumber()));
        products.add(new Product("subwoofer", calculation.getRandomNumber()));
        products.add(new Product("słuchawki", calculation.getRandomNumber()));
        products.add(new Product("xbox one", calculation.getRandomNumber()));
        products.add(new Product("call of duty", calculation.getRandomNumber()));

        return products;
    }

    @Override
    public float getBill() {
        float netto = products
                .stream()
                .map(p -> p.getPrice())
                .reduce(0.0f, Float::sum);

        float vat = calculation.getPercent(netto, calculationProperties.getVat());
        float discount = calculation.getPercent(netto, calculationProperties.getDiscount());

        return (netto - discount) + vat;
    }

    @Override
    public String info() {
        return "Pro";
    }
}
