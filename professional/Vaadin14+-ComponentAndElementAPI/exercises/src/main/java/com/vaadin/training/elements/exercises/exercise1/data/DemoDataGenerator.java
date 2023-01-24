package com.vaadin.training.elements.exercises.exercise1.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DemoDataGenerator {
    private static final String[] FILLING = new String[] { "Strawberry", "Chocolate", "Blueberry", "Raspberry",
            "Vanilla" };
    private static final String[] TYPE = new String[] { "Cake", "Pastry", "Tart", "Muffin", "Biscuit", "Bread", "Bagel",
            "Bun", "Brownie", "Cookie", "Cracker", "Cheese Cake" };

    private final static Random random = new Random(100L);

    public static List<Product> createProducts(int numberOfItems) {
        List<Product> products  = new ArrayList<>();
        for (int i = 0; i < numberOfItems; i++) {
            Product product = new Product();
            product.setName(getRandomProductName());
            double doublePrice = 2.0 + random.nextInt(100) / 100.0d;
            product.setPrice(doublePrice);
            products.add(product);
        }
        return products;
    }

    private static String getRandomProductName() {
        String firstFilling = getRandom(FILLING);
        String name;
        if (random.nextBoolean()) {
            String secondFilling;
            do {
                secondFilling = getRandom(FILLING);
            } while (secondFilling.equals(firstFilling));

            name = firstFilling + " " + secondFilling;
        } else {
            name = firstFilling;
        }
        name += " " + getRandom(TYPE);

        return name;
    }

    private static <T> T  getRandom(T[] array) {
        return array[random.nextInt(array.length)];
    }
}
