package org.academiadecodigo.bootcamp.Game;

import org.academiadecodigo.bootcamp.Bull;
import org.academiadecodigo.bootcamp.Field;
import org.academiadecodigo.bootcamp.Hitables.Characters.Character;
import org.academiadecodigo.bootcamp.Hitables.Factory;
import org.academiadecodigo.bootcamp.Hitables.Hitables;
import org.academiadecodigo.bootcamp.Menu.GameOver;
import org.academiadecodigo.bootcamp.Menu.Menu;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Game {

    private Field road;
    private Field sky;
    private Cages[] cages;
    private CollisionDetector collisionDetector;
    private int delay;
    private int score;
    private Bull bull;
    private Menu menu;
    private GameOver gameOver;
    private GameObjects[] gameObjects;
    private Factory factory;
    private double iterator = -2;

    public Game(){

        sky = new Field(20,5,false);
        road = new Field(20,4, true);
        delay = 175;

    }

    public void init(){

        road.init();
        sky.init();


        bull = new Bull();
        bull.keyBoardEvent();
        createObjects();
        collisionDetector = new CollisionDetector(bull);


    }

    public void start() throws InterruptedException{

        while (true) {

            Thread.sleep(delay);

            for (int i = 0; i < gameObjects.length; i++) {
                    gameObjects[i].setColor(Color.ORANGE);
                    gameObjects[i].fill();
                    gameObjects[i].moveForward();

                    /*if(collisionDetector.check(gameObjects[i])){
                        gameObjects[i].delete();
                        System.out.println("Delete");
                    }*/

                    if (iterator <= i) {
                        iterator += 0.10;
                        break;
                    }

            }


        }

    }

    public void createCages(){

        cages = new Cages[4];
        for(int i = 0; i < cages.length; i++){
            cages[i] = new Cages(18,i+1);
        }

    }

    public void createObjects(){

        factory = new Factory();
        gameObjects = new GameObjects[10];


        for (int i=0; i < gameObjects.length; i++){

            if (i%3 == 0 && i != 0){

                gameObjects[i] = factory.obstacleFactory();
                continue;

            }

            gameObjects[i] = factory.characterFactory();

        }

    }

}
