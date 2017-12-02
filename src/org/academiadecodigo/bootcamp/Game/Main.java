package org.academiadecodigo.bootcamp.Game;

import org.academiadecodigo.bootcamp.Field;
import org.academiadecodigo.bootcamp.Menu.Menu;
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
                Rectangle end = new Rectangle(0, 0, 1800, 1165);
                end.setColor(Color.BLACK);
                end.fill();
            }
        }

        menu.gameScreen();
        //Rectangle walk = new Rectangle(0,7* Field.CELLPIXELS,18*Field.CELLPIXELS, 85);
        //walk.setColor(Color.BLACK);
        //walk.fill();
        menu.startGame();





    }

}
