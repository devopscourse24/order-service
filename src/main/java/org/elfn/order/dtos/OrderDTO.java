package org.elfn.order.dtos;

import java.util.List;

public class OrderDTO {

    private Integer orderId;
    private List<FoodItem> foodItemList;
    private Restaurant restaurant;
    private User userDTO;



    public OrderDTO(Integer orderId, List<FoodItem> foodItemList, Restaurant restaurant, User userDTO) {
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

    public User getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(User userDTO) {
        this.userDTO = userDTO;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
