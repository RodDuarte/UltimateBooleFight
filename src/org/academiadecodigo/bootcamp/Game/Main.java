package org.academiadecodigo.bootcamp.Game;

import org.academiadecodigo.bootcamp.Field;
import org.academiadecodigo.bootcamp.Menu.Menu;
import org.academiadecodigo.bootcamp.kuusisto.tinysound.TinySound;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Picture intro = new Picture(0, 0, "intro.png");
        intro.draw();
        Thread.sleep(3500);
        Menu menu = new Menu();

        menu.init();
        intro.delete();
        menu.keyBoardEvent();

        while (!menu.isStartGame()) {
            System.out.println();
            if (menu.isBack()) {
                menu.backToMenu();
                menu.init();
            }
            if (menu.isExit()) {
                System.exit(0);
        }
        }

        menu.gameScreen();
        menu.startGame();





    }
    

}
