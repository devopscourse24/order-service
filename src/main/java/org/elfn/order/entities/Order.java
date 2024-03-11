package org.elfn.order.entities;

import org.elfn.order.dtos.FoodItem;
import org.elfn.order.dtos.Restaurant;
import org.elfn.order.dtos.User;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("order")
public class Order {
    private Integer orderId;
    private List<FoodItem> foodItemList;
    private Restaurant restaurant;
    private User userDTO;

    public Order(Integer orderId, List<FoodItem> foodItemList, Restaurant restaurant, User userDTO) {
        this.orderId = orderId;
        this.foodItemList = foodItemList;
        this.restaurant = restaurant;
        this.userDTO = userDTO;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public List<FoodItem> getFoodItemList() {
        return foodItemList;
    }

    public void setFoodItemList(List<FoodItem> foodItemList) {
        this.foodItemList = foodItemList;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public User getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(User userDTO) {
        this.userDTO = userDTO;
    }
}
