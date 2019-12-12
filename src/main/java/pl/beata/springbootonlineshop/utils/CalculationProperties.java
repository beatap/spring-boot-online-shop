package pl.beata.springbootonlineshop.utils;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "calc")
@Getter
@Setter
public class CalculationProperties {

    private int vat;
    private int discount;
}
