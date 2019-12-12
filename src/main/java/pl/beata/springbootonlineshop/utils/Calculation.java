package pl.beata.springbootonlineshop.utils;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Calculation {

    private static float MIN = 50.0f;
    private static float MAX = 300.0f;

    public float getPercent(float base, int percent) {
        float val = base / (percent * 100);
        return round(val);
    }

    public float getRandomNumber() {
        float randomNumber = MIN + new Random().nextFloat() * (MAX - MIN);

        return round(randomNumber);
    }


    private float round(float val) {
        return (float) (Math.round(val * 100.0) / 100.0);
    }


}
