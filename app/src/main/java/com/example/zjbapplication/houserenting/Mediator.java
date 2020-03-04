package com.example.zjbapplication.houserenting;

import java.util.ArrayList;
import java.util.List;

/**
 * 中介
 */
public class Mediator {
    private List<Room> rooms = new ArrayList<>();

    public Mediator() {
        for (int i = 0; i < 5; i++) {
            rooms.add(new Room(121 + i, 1500 + i * 200));
        }
    }
    //获取所有房源
    private List<Room> getAllRooms() {
        return rooms;
    }

    //符合租户条件的房源
    public Room rentOut(float canArea, float canPrice) {
        for (Room room : getAllRooms()) {
            if (isRentRoom(canArea, canPrice, room)) {
                return room;
            }
        }
        return null;
    }

    //是否符合租户的条件
    private boolean isRentRoom(float canArea, float canPrice, Room room) {
        return room.getArea() > canArea && room.getPrice() < canPrice;
    }
}
