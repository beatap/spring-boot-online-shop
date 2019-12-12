package pl.beata.springbootonlineshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import pl.beata.springbootonlineshop.services.ShopOnlineService;

@SpringBootApplication
public class SpringBootOnlineShopApplication {

    ShopOnlineService shopOnlineService;

    @Autowired
    public SpringBootOnlineShopApplication(ShopOnlineService shopOnlineService) {
        this.shopOnlineService = shopOnlineService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootOnlineShopApplication.class, args);
    }


    @EventListener(ApplicationReadyEvent.class)
    public void writeStartup() {

        System.out.println(shopOnlineService.getProducts());
        System.out.println("Rachunek: " + shopOnlineService.getBill());
    }

}
