package org.example;


import org.example.model.Toy;
import org.example.model.store.ToyStore;
import org.example.view.ConsoleUI;
import org.example.view.View;

public class Main {
    public static void main(String[] args) {

        View view = new ConsoleUI();
        view.start();

//        ToyStore store = new ToyStore();
//        store.addToy(new Toy("qwe",1,46));
//        store.addToy(new Toy("rty",3,17));
//        store.addToy(new Toy("aad",2,64));
//        store.addToy(new Toy("zxc",3,27));
//        store.addToy(new Toy("cvb",1,32));
//        store.addToy(new Toy("fds",1,44));
//        store.addToy(new Toy("hgf",2,49));
    }
}
