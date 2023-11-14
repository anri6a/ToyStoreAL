package org.example.view.commands;

import org.example.view.ConsoleUI;

public class GetToysInfo extends Command {
    public GetToysInfo(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Получить список игрушек";
    }

    public void execute(){
        consoleUI.getToysListInfo();
    }
}
