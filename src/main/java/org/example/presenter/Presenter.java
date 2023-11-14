package org.example.presenter;

import org.example.model.Service;
import org.example.model.store.ToyStore;
import org.example.view.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addToy(String name, int count, double weight) {
        service.addToy(name, count, weight);
        getToysListInfo();
    }

    public void getToysListInfo() {
        String info = service.getToysInfo();
        view.printAnswer(info);
    }
    public void getPrizeToysListInfo() {
        String info = service.getPrizeToysInfo();
        view.printAnswer(info);
    }

    public void getPlayToys() {
        service.playToys();
    }

    public void loadToys() {
        service.loadToys();
    }
}
