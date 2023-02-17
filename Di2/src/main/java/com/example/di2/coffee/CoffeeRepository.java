package com.example.di2.coffee;

import java.util.HashMap;
import java.util.Map;

public class CoffeeRepository {
    private static Map<Long, Coffee> drinks = new HashMap<>();

    void postCoffee(Coffee coffee){
        drinks.put(coffee.getCoffeeId(),coffee);
    }

    public Coffee patchCoffee(Long coffeeId, String korName, int pirce){
        Coffee drink = drinks.get(coffeeId);
        drink.setkorName(korName);
        drink.setPrice(pirce);

        return drinks.put(coffeeId, drink);
    }

    public Coffee getCoffee(Long coffeeId){
        return drinks.get(coffeeId);
    }

    public void deleteCoffee(Long coffeeId){
        drinks.remove(coffeeId);
    }
}
