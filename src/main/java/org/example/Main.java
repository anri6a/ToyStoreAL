package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        ToyStore store = new ToyStore();

        store.addToy(new Toy("qwe", 1, 46));
        store.addToy(new Toy("rty", 3, 17));
        store.addToy(new Toy("aad", 2, 64));
        store.addToy(new Toy("zxc", 3, 27));
        store.addToy(new Toy("cvb", 1, 32));
        store.addToy(new Toy("fds", 1, 44));
        store.addToy(new Toy("hgf", 2, 49));

        for (int i = 0; i < 9; i++) {
            playToy(store);
            System.out.println(store);
        }


    }

    static ToyStore playToy(ToyStore store) {
        Toy prizeToy = store.play();
        if (prizeToy == null) {
            System.out.println("Все призы разыграны!");
        } else {
            System.out.println("Вы выиграли: " + prizeToy.getName());
            List prizeToys = store.getPrizeToys();
            prizeToys.add(prizeToy);
        }
        return store;
    }

}