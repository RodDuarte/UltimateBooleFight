package org.academiadecodigo.bootcamp.Menu;

public class Menu {

    private boolean startGame;
    private boolean instructions;
    private boolean credits;
    private boolean exit;


    public Menu(){
        startGame = false;
        instructions = false;
        credits = false;
        exit = false;

    }

    public void setStartGame() {
        startGame = true;
    }

    public void setInstructions() {
        instructions = true;
    }

    public void setCredits() {
        credits = true;
    }

    public void setExit() {
        exit = true;
    }

    public boolean isStartGame() {
        return startGame;
    }

    public boolean isInstructions() {
        return instructions;
    }

    public boolean isCredits() {
        return credits;
    }

    public boolean isExit() {
        return exit;
    }
}

