package org.academiadecodigo.bootcamp.Game;

import org.academiadecodigo.bootcamp.Field;
import org.academiadecodigo.bootcamp.Game.SoundEffects;
import org.academiadecodigo.bootcamp.Menu.GameOver;
import org.academiadecodigo.bootcamp.Menu.Menu;
import org.academiadecodigo.bootcamp.kuusisto.tinysound.Sound;
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
        GameOver gameOver;


        while (!menu.isExit()) {
            menu = new Menu();
            gameOver = new GameOver(menu);
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
            if (!menu.getGame().bullLiveStatus()) {
                menu.backToMenu();
                gameOver.init();
                gameOver.keyBoardEvent();
                while (!gameOver.isBackToMenu()) {
                    System.out.println();
                }
            }
            else {

                menu.backToMenu();
                gameOver.init();
                gameOver.keyBoardEvent();
                while (!gameOver.isBackToMenu()) {
                    System.out.println();
                }
            }
        }
        System.exit(0);
    }
    

}
