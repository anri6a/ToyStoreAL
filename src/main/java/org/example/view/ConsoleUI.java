package org.example.view;

import org.example.model.Toy;
import org.example.presenter.Presenter;

import java.util.List;
import java.util.Scanner;

public class ConsoleUI implements View{
    private static final String INPUT_ERROR = "Вы ввели неверное значение";
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu menu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new MainMenu(this);
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        hello();
        presenter.loadToys();
        while (work){
            printMenu();
            execute();
        }
    }

    public void finish() {
        System.out.println("Приятно было пообщаться");
        work = false;
    }

    public void getToysListInfo() {
        presenter.getToysListInfo();
    }
    public void getPrizeToysListInfo() {
        presenter.getPrizeToysListInfo();
    }

    public void addToys() {
        System.out.println("Введите название игрушки");
        String name = scanner.nextLine();
        System.out.println("Укажите колличество игрушек");
        String countToys = scanner.nextLine();
        //сделать проверку ввода
        int count = Integer.parseInt(countToys);
        System.out.println("Укажите вес игрушеки");
        String weightToys = scanner.nextLine();
        //сделать проверку ввода
        double weight = Double.parseDouble(weightToys);
        presenter.addToy(name, count, weight);
    }

    private void hello(){
        System.out.println("Доброго времени суток!");
    }

    private void execute(){
        String line = scanner.nextLine();
        if (checkTextForInt(line)){
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand)){
                menu.execute(numCommand);
            }
        }
    }

    private boolean checkTextForInt(String text){
        if (text.matches("[0-9]+")){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private boolean checkCommand(int numCommand){
        if (numCommand <= menu.getSize()){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private void printMenu(){
        System.out.println(menu.menu());
    }

    private void inputError(){
        System.out.println(INPUT_ERROR);
    }

    public void getPlayToys() {
        presenter.getPlayToys();
    }
}
