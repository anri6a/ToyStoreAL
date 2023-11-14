package org.example.model;

import org.example.model.store.ToyStore;

public class Service {
    private ToyStore toys;
//    private ToyStore prizeToys;

    public Service() {
        toys = new ToyStore();
    }


    public void addToy(String name, int count, double weight){
        Toy toy = new Toy(name, count, weight);
        toys.addToy(toy);
    }

    public String getToysInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список игрушек:\n");
        for (Object toy: toys){
            stringBuilder.append(toy);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public String getPrizeToysInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список разыграных игрушек:\n");
        if (toys.getPrizeToys().isEmpty()){
            stringBuilder.append("Список пуст\n");
            stringBuilder.append("****************");
        }else {
            for (Object toy : toys.getPrizeToys()) {
                stringBuilder.append(toy);
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }

    public void playToys() {
        toys.playToys();
    }

    public void loadToys() {
        toys.loadToys();
    }
}
