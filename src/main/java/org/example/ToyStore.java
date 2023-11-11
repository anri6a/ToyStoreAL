package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ToyStore implements Serializable{
    private int toyId;
    private List<Toy> toys;
    private List<Toy> prizeToys;
    private Random random ;
    private String fileName;

    public ToyStore() {
        this.toys = new ArrayList<>();
        prizeToys = new ArrayList<>();
        random = new Random();
        fileName = "fileName.txt";
//        loadToys();
    }

    public void addToy(Toy toy) {
        if (!toys.contains(toy)) {
            toys.add(toy);
            toy.setId(toyId++);
        }
        saveToys();
    }

    public void editToyWeight(int id, double weight) {
        for (Toy toy : toys) {
            if (toy.getId() == id) {
                toy.setWeight(weight);
                saveToys();
                break;
            }
        }
    }

    public Toy play(){
        double totalWeight = 0;
        for (Toy toy: toys){
            totalWeight += toy.getWeight();
        }
        double randomWeight = random.nextDouble() * totalWeight;
        double weightSum = 0;
        for (Toy toy: toys){
            weightSum += toy.getWeight() * toy.getCount();
            if (randomWeight <= weightSum){
                prizeToys.add(toy);
                toy.setCount(toy.getCount() - 1);
                if (toy.getCount() == 0){
                    toys.remove(toy);
                }
                saveToys();
                return toy;
            }
        }
        return null;
    }

    public List getPrizeToys(){
        return prizeToys;
    }

    private void saveToys(){
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(toys);
            oos.close();
            fos.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private void loadToys(){
        try {
            File file = new File(fileName);
            if(file.exists()){
                FileInputStream fis = new FileInputStream(fileName);
                ObjectInputStream ois = new ObjectInputStream(fis);
                toys = (List) ois.readObject();
                ois.close();
                fis.close();
            }
            } catch (IOException e){
                e.printStackTrace();
            } catch (ClassNotFoundException e){
                e.printStackTrace();
            }
        }

    public String getToyListInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("in store ");
        stringBuilder.append(toys.size());
        stringBuilder.append(" toys\n");
        for (Toy toy : toys) {
            stringBuilder.append(toy);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return getToyListInfo();
    }
}
