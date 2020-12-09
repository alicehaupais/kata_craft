package com.megacorp.ecs;

import java.util.HashMap;

public class CopperWire extends Perpend {

    @Override
    // This is not right, please do not use.
    public int getQuantity() {
        // The exception is normal ==> DO NOT USE !!
        String a = null;
        a.isEmpty();

        return super.getQuantity();
    }

    // Use this instead, the calculus is correct
    public HashMap<String, Integer> getWireQuantity() {
        int coil = quantity / 50;
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("wire", quantity % 50);
        hashMap.put("coil", coil);
        return hashMap;
    }

    @Override
    public void show() {
        System.out.println(" - " + getWireQuantity().get("coil") + " copper wire coils (50m)");
        System.out.println(" - " + getWireQuantity().get("wire") + " copper wire meters");
    }
}
