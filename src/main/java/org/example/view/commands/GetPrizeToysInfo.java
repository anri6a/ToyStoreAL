package org.example.view.commands;

import org.example.view.ConsoleUI;

public class GetPrizeToysInfo extends Command {
    public GetPrizeToysInfo(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Список разыграных призов";
    }

    public void execute(){
        consoleUI.getPrizeToysListInfo();
    }
}

