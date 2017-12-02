package org.academiadecodigo.bootcamp.Game;

import org.academiadecodigo.bootcamp.Menu.Menu;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Menu menu = new Menu();

            menu.init();



        while (!menu.isStartGame()){
            System.out.println();
        }

        menu.startGame();






    }

}
