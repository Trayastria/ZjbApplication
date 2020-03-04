package com.example.zjbapplication.houserenting;

import java.util.List;

/**
 * 租客
 */
public class Tennat {
    private float canArea = 121;
    private float canPrice = 2000;

    public void rentRoom() {
        Mediator mediator = new Mediator();
        if (mediator.rentOut(canArea, canPrice) != null) {
            System.out.println("租到房间啦：" + mediator.rentOut(canArea, canPrice).toString());
        }
    }
}
