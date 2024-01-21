package org.example.transport;

import org.example.LandTrans;
import org.example.list.type;

public class Bus extends LandTrans {
    private type type;

    public Bus(int id, String name, int capacity, int yearEnding, boolean isAvailable) {
        super(id, name, capacity, yearEnding, isAvailable);
        this.type = type.bus;
    }

    @Override
    public String toString() {
        return "com.hw10.exam.garage.Bus{" +
                "com.hw10.exam.garage.list.type=" + type +
                "} " + super.toString();
    }
}