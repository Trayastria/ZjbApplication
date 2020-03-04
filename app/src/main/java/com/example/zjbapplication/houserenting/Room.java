package com.example.zjbapplication.houserenting;

public class Room {
    //租房面积
    private float area;
    //价格
    private float price;

    /**
     *
     * @param area 面积
     * @param price 单价
     */
    public Room(float area, float price){
        this.area = area;
        this.price = price;
    }

    public float getArea() {
        return area;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Room{" +
                "area=" + area +
                ", price=" + price +
                '}';
    }
}
