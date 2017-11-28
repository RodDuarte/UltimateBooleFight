package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;

public class Game {

    private Field road;
    private Field sky;
    private Cages[] cages;
    private CollisionDetector collisionDetector;
    private int delay;
    private int score;
    private Bull bull;

    public Game(){


        sky = new Field(20,5,false);
        road = new Field(20,4, true);
        delay = 100;

    }

    public void init(){

        road.init();
        sky.init();

        cages = new Cages[4];
        for(int i = 0; i < cages.length; i++){
            cages[i] = new Cages(18,i+1);
        }

        bull = new Bull();

    }

    /*public void start(){

        while (true) {

            // Pause for a while
            Thread.sleep(delay);

            //move();

        }

    }*/

}
