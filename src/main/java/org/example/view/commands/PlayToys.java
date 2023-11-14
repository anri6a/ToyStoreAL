package org.example.view.commands;

import org.example.view.ConsoleUI;

public class PlayToys extends Command {
    public PlayToys(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Провести розыгрыш игрушек";
    }

    public void execute(){
        consoleUI.getPlayToys();
    }
}


