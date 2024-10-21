package org.loose.good.refactoring.switchstatements;

import java.util.List;

public class FoodOrder {
    private List<Item> items;
    private DeliveryType deliveryType;

    public FoodOrder(List<Item> items, DeliveryType deliveryType) {
        this.items = items;
        this.deliveryType = deliveryType;
    }

    public int getPrice() {
        int itemsTotal = 0;
        for (Item item : items) {
            itemsTotal += item.getPrice();
        }
        return itemsTotal + getDeliveryPrice();
    }

    private int getDeliveryPrice() {
        int price = 0;
        switch (deliveryType) {
            case URBAN:
                price = 10;
                break;
            case SUBURBAN:
                price = 15;
                break;
            case EXTRAURBAN:
                price = 20;
                break;
        }
        return price;
    }
}
