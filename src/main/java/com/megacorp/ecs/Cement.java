package com.megacorp.ecs;

public class Cement {
    public String calculateQuantity(Integer bagQuantity) {
        if(bagQuantity == 0) {
            return "No bag added!";
        }
        int numberOfBag = bagQuantity % 4;
        int numberOfBox = bagQuantity / 4;
        return numberOfBox +" box and "+ numberOfBag +" bag";
    }
}
