package org.academiadecodigo.bootcamp.Game;

import org.academiadecodigo.bootcamp.Field;
import org.academiadecodigo.bootcamp.Game.SoundEffects;
import org.academiadecodigo.bootcamp.Menu.GameOver;
import org.academiadecodigo.bootcamp.Menu.Menu;
import org.academiadecodigo.bootcamp.Menu.Score;
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

        while (!menu.isExit()) {
            menu = new Menu();
            menu.init();
            intro.delete();
            menu.keyBoardEvent();

            while (!menu.isStartGame()) {
                System.out.println();
                if (menu.isBack()) {
                    menu.backToMenu();
                }
                if (menu.isExit()) {
                    System.exit(0);
                }
            }

            menu.gameScreen();
            menu.startGame();

            Thread.sleep(2000);

            if (!menu.getGame().bullLiveStatus()) {
                menu.backToMenu();
                menu.getGameOver().init();
                menu.getGameOver().keyBoardEvent();
                while (!menu.getGameOver().isBackToMenu()) {
                    System.out.println();
                }
            }
            else {

                menu.backToMenu();
                menu.getScore().init(menu.getGame().getScore());
                menu.getScore().keyBoardEvent();
                while (!menu.getScore().isBackToMenu()) {
                    System.out.println();
                }
            }
        }
        System.exit(0);
    }
    

}
