package org.loose.good.refactoring.switchstatements;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FoodOrderTest {

    private FoodOrder foodOrder;
    private int expectedUrbanPrice;
    private int expectedSuburbanPrice;
    private int expectedExtraurbanPrice;

    @Before
    public void setUp() {
        int expectedItemsPrice = 48;
        expectedUrbanPrice = expectedItemsPrice + 10;
        expectedSuburbanPrice = expectedItemsPrice + 15;
        expectedExtraurbanPrice = expectedItemsPrice + 20;
    }

    @Test
    public void getUrbanPrice() {
        foodOrder = getUrbanFoodOrder();
        assertEquals(expectedUrbanPrice, foodOrder.getPrice());
    }

    @Test
    public void getSuburbanPrice() {
        foodOrder = getSuburbanFoodOrder();
        assertEquals(expectedSuburbanPrice, foodOrder.getPrice());
    }

    @Test
    public void getExtraurbanPrice() {
        foodOrder = getExtraurbanFoodOrder();
        assertEquals(expectedExtraurbanPrice, foodOrder.getPrice());
    }

    private FoodOrder getUrbanFoodOrder() {
        return new FoodOrder(getItems(), DeliveryType.URBAN);
    }

    private FoodOrder getSuburbanFoodOrder() {
        return new FoodOrder(getItems(), DeliveryType.SUBURBAN);
    }

    private FoodOrder getExtraurbanFoodOrder() {
        return new FoodOrder(getItems(), DeliveryType.EXTRAURBAN);
    }

    private List<Item> getItems() {
        return Arrays.asList(
                new Item(8, "Soup"),
                new Item(9, "Chicken breast"),
                new Item(5, "Wedges"),
                new Item(4, "Salad"),
                new Item(12, "Cheese cake"),
                new Item(10, "Orange juice")
        );
    }
}