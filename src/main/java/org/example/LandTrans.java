package org.example;

public class LandTrans {
    private int id;
    private String name;
    private int capacity;
    private int yearEnding;
    private boolean isAvailable;

    public LandTrans(int id, String name, int capacity, int yearEnding, boolean isAvailable) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.yearEnding = yearEnding;
        this.isAvailable = isAvailable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getYearEnding() {
        return yearEnding;
    }

    public void setYearEnding(int yearEnding) {
        this.yearEnding = yearEnding;
    }

    public boolean isAvailable(boolean b) {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "com.hw10.exam.garage.LandTrans{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                ", yearEnding=" + yearEnding +
                ", isAvailable=" + isAvailable +
                '}';
    }

    public void add(LandTrans transport) {
    }
}