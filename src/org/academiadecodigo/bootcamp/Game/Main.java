package org.academiadecodigo.bootcamp.Game;

import org.academiadecodigo.bootcamp.Menu.Menu;

public class Main {

    public static void main(String[] args) throws InterruptedException{

        //Menu menu = new Menu();
        //menu.init();

        Game g = new Game();

        //if (menu.isStartGame()){
            g.init();
            g.start();

        //}

    }

}
