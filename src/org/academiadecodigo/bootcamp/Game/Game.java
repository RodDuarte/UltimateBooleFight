package org.academiadecodigo.bootcamp.Game;

import org.academiadecodigo.bootcamp.Bull;
import org.academiadecodigo.bootcamp.Field;
import org.academiadecodigo.bootcamp.Hitables.Characters.Character;
import org.academiadecodigo.bootcamp.Menu.GameOver;
import org.academiadecodigo.bootcamp.Menu.Menu;

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
    private Character[] character;

    public Game(){

        sky = new Field(20,5,false);
        road = new Field(20,4, true);
        delay = 200;

    }

    public void init(){

        road.init();
        sky.init();

        bull = new Bull();
        bull.keyBoardEvent();

        character = new Character[1];
        character[0] = new Character(19,5);


    }

    public void start() throws InterruptedException{

        while (true) {

            Thread.sleep(delay);

            character[0].moveForward();

        }

    }

    public void createCages(){

        cages = new Cages[4];
        for(int i = 0; i < cages.length; i++){
            cages[i] = new Cages(18,i+1);
        }

    }

}
