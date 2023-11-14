package org.example.model.store;

import org.example.model.Service;
import org.example.model.Toy;
import org.example.model.store.iterators.ToysIterator;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class ToyStore implements Serializable, StoreItem, Iterable {
    private int toyId;
    private List<Toy> toys;
    private List<Toy> prizeToys;
    private Random random = new Random();;
    private String fileName = "storeToy.txt";
    private Toy toy;

    public ToyStore() {
        this.toys = new ArrayList<>();
        prizeToys = new ArrayList<>();
    }


    public void addToy(Toy toy) {
        if (!toys.isEmpty() && (!toys.contains(toy))){
            toys.add(toy);
            toy.setId(toys.size());
        }else {
            toys.add(toy);
            toy.setId(toyId++);
        }
        saveToys();
    }

    public void editToyWeight(int id, double weight) {
        for (Toy toy : toys) {
            if (getId() == id) {
                setWeight(weight);
                saveToys();
                break;
            }
        }
    }

    public void playToys() {
        Toy prizeToy = play();
        if (prizeToy == null) {
            System.out.println("------------------");
            System.out.println("Все призы разыграны!");
            System.out.println("------------------");
        } else {
            System.out.println("------------------");
            System.out.println("Вы выиграли: " + prizeToy.getName());
            System.out.println("------------------");
//            List prizeToys = getPrizeToys();
//            prizeToys.add(prizeToy);
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
            weightSum += toy.getWeight();
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

    public void loadToys(){
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

    @Override
    public int getId() {
        return toy.getId();
    }

    @Override
    public void setId(int i) {
        this.toy.setId(i);
    }

    @Override
    public String getName() {
        return toy.getName();
    }

    @Override
    public int getCount() {
        return toy.getCount();
    }

    @Override
    public void setCount(int i) {
        this.toy.setCount(i);
    }



    @Override
    public double getWeight() {
        return toy.getWeight();
    }

    @Override
    public void setWeight() {
        toy.setWeight();
    }
    private void setWeight(double weight) {
    }

    @Override
    public Iterator iterator() {
        return new ToysIterator(toys);
    }

}
