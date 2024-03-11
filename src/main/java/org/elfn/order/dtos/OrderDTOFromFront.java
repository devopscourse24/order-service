package org.elfn.order.dtos;

import java.util.List;

public class OrderDTOFromFront {

    private List<FoodItem> foodItemList;
    private Restaurant restaurant;
    private Integer userId;

    public OrderDTOFromFront(List<FoodItem> foodItemList, Restaurant restaurant, Integer userId) {
        this.foodItemList = foodItemList;
        this.restaurant = restaurant;
        this.userId = userId;
    }

    public List<FoodItem> getFoodItemList() {
        return foodItemList;
    }

    public void setFoodItemList(List<FoodItem> foodItemList) {
        this.foodItemList = foodItemList;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

}
