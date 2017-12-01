package org.academiadecodigo.bootcamp.Menu;

public class GameOver {

    private boolean backToMenu;

    public GameOver(){
        backToMenu = false;
    }

    public void setBackToMenu() {
        backToMenu = true;
    }

    public boolean isBackToMenu() {
        return backToMenu;
    }
}
