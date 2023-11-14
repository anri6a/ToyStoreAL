package org.example.view.commands;

import org.example.view.ConsoleUI;

public class AddToys extends Command{
    public AddToys(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить игрушку";
    }

    public void execute(){
        consoleUI.addToys();
    }
}
