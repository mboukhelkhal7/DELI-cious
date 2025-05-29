package com.Pluralsight.businessEntities;

import com.Pluralsight.types.ToppingType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class ToppingTest {
    @Test
    public void testRegularToppingPrice() {
        Topping topping = new Topping("lettuce", ToppingType.REGULAR, false);
        assertEquals(0.0, topping.getPrice(), 0.001);
    }

    @Test
    public void testExtraMeatPrice() {
        Topping topping = new Topping("turkey", ToppingType.MEAT, true);
        assertEquals(1.00, topping.getPrice(), 0.001);
    }

    @Test
    public void testExtraCheesePrice() {
        Topping topping = new Topping("cheddar", ToppingType.CHEESE, true);
        assertEquals(0.75, topping.getPrice(), 0.001);
    }

    @Test
    public void testExtraSaucePrice() {
        Topping topping = new Topping("mayo", ToppingType.SAUCE, true);
        assertEquals(0.50, topping.getPrice(), 0.001);
    }

    @Test
    public void testExtraRegularToppingPrice() {
        Topping topping = new Topping("pickles", ToppingType.REGULAR, true);
        assertEquals(0.25, topping.getPrice(), 0.001);
    }
}