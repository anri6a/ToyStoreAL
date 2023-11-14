package org.example.model;

import org.example.model.store.StoreItem;

import java.io.Serializable;

public class Toy implements Serializable, StoreItem {
    private int id;
    private String name;
    private int count;
    private double weight;

    public Toy(String name, int count, double weight) {
        this.id = 1;
        this.name = name;
        this.count = count;
        this.weight = weight;
    }
    public Toy(){

    }

    @Override
    public String toString() {
        return "Toy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int i) {
        this.id = i;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public void setCount(int i) {
        this.count = i;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public void setWeight() {
    }

}
