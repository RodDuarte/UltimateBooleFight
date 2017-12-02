package org.academiadecodigo.bootcamp.Game;

import org.academiadecodigo.bootcamp.Bull;
import org.academiadecodigo.bootcamp.Field;
import org.academiadecodigo.bootcamp.Hitables.Characters.Character;
import org.academiadecodigo.bootcamp.Hitables.Factory;
import org.academiadecodigo.bootcamp.Hitables.Obstacles.Obstacle;
import org.academiadecodigo.bootcamp.Menu.GameOver;
import org.academiadecodigo.bootcamp.Menu.Menu;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game implements KeyboardHandler {

    private Field road;
    private Field sky;
    private Cages[] cages;
    private CollisionDetector collisionDetector;
    private int delay;
    private Integer score = 0;
    private Bull bull;
    private GameOver gameOver;
    private GameObjects[] gameObjectsToHit;
    private GameObjects[] gameObjectsClouds;
    private GameObjects[] gameObjectsHouses;
    private Factory factory;
    private double iterator = -1;
    private Text textScore;
    private int deletedCounter;
    private Picture[] bullLife = new Picture[3];
    private Picture bull2;
    private int bullPicCounter;

    public Game() throws InterruptedException {
        sky = new Field(18,5,false);
        road = new Field(18,4, true);
        delay = 100;
        textScore = new Text(30,10, "Score: "+score.toString());
        textScore.setColor(Color.DARK_GRAY);
        textScore.grow(20, 10);
        bullLife[0] = new Picture(1687, 10, "bullLife1.png");
        bullLife[1] = new Picture(1723, 10, "bullLife1.png");
        bullLife[2] = new Picture(1759, 10, "bullLife1.png");


    }

    public void init() throws InterruptedException {

            road.init();
            sky.initBackground();
            textScore.draw();
            bullLife[0].draw();
            bullLife[1].draw();
            bullLife[2].draw();

            createObjects();
            start();
    }

    public void start() throws InterruptedException{
            bull = new Bull();
            keyBoardEvent();
            collisionDetector = new CollisionDetector(bull);

            while (bull.isAlive() && deletedCounter < 1) {

                bull2 = getPic(bull.getBull());
                bull2.draw();

                //Thread.sleep(delay);


                for (int i = 0; i < gameObjectsToHit.length; i++) {

                    gameObjectsToHit[i].moveForward();
                    gameObjectsToHit[i].draw();
                    gameObjectsClouds[i].moveForward();
                    gameObjectsClouds[i].moveForward();
                    gameObjectsClouds[i].draw();
                    gameObjectsClouds[i + 50].moveForward();
                    gameObjectsClouds[i + 50].draw();
                    gameObjectsHouses[i].moveForward();
                    gameObjectsHouses[i].draw();

                    if (gameObjectsToHit[i] instanceof Character) {
                        Character fighter = (Character) gameObjectsToHit[i];
                        if (fighter.getCharacters().getPoints() == 50 && fighter.getPosition().getCol() == 1) {
                            if (fighter.getPosition().getRow() == 3) {
                                gameObjectsToHit[i].getPosition().moveDown();
                                gameObjectsToHit[i].dodgeDown();
                            } else if (fighter.getPosition().getRow() == 6) {
                                gameObjectsToHit[i].getPosition().moveUp();
                                gameObjectsToHit[i].dodgeUp();
                            } else {
                                int randomMove = (int) Math.floor(Math.random() * 2);
                                switch (randomMove) {

                                    case 0:
                                        gameObjectsToHit[i].getPosition().moveUp();
                                        gameObjectsToHit[i].dodgeUp();
                                        break;
                                    case 1:
                                        gameObjectsToHit[i].getPosition().moveDown();
                                        gameObjectsToHit[i].dodgeDown();
                                        break;
                                    default:
                                        break;

                                }
                            }
                        }

                    }
                    if (collisionDetector.check(gameObjectsToHit[i])) {
                        if (gameObjectsToHit[i] instanceof Character) {

                            Character character = (Character) gameObjectsToHit[i];
                            score += character.getCharacters().getPoints();
                            textScore.setText("Score: " + score.toString());
                            textScore.draw();

                        } else if (gameObjectsToHit[i] instanceof Obstacle) {

                            bullLife[bull.getHealth() - 1].delete();
                            bull.setHealth(bull.getHealth() - 1);

                        }
                        gameObjectsToHit[i].delete();
                        if (i > (2 * gameObjectsToHit.length) / 4 && i <= (2 * gameObjectsToHit.length) / 4) {
                            delay = 80;
                        }
                        if (i > gameObjectsToHit.length / 4) {
                            delay = 60;
                        }

                        if (i > gameObjectsToHit.length / 3) {
                            delay = 50;
                        }
                    }

                    if (iterator <= i) {
                        iterator += 0.10;
                        break;
                    }


                    if (bull.getHealth() <= 0) {
                        bull.setDeath();
                    }

                }

                if (gameObjectsToHit[gameObjectsToHit.length - 1].isDeleted()) {
                    deletedCounter++;
                }


                Thread.sleep(delay);
                bull2.delete();


            }

            //if(bull.isAlive()){
              //  createCages();
            //}


    }

    public void createCages(){

        cages = new Cages[4];
        for(int i = 0; i < cages.length; i++){
            cages[i] = new Cages(18,i+1);
        }

    }


    public Picture getPic(Picture[] picArray){

        bullPicCounter++;

        if(bullPicCounter==5){

            bullPicCounter=0;

        }

        return picArray[bullPicCounter];
    }


    public void createObjects(){

        factory = new Factory();
        gameObjectsClouds = new GameObjects[100];
        gameObjectsToHit = new GameObjects[50];
        gameObjectsHouses = new GameObjects[50];
        for (int i = 0; i < gameObjectsClouds.length; i++) {

            gameObjectsClouds[i] = new GameObjects((int) (Math.floor(Math.random() * 2)+1));

        }
        for (int i = 0; i < gameObjectsToHit.length; i++){

            gameObjectsHouses[i] = new GameObjects();


            if (i%3 == 0 && i != 0){
                gameObjectsToHit[i] = factory.obstacleFactory();
                continue;

            }

            gameObjectsToHit[i] = factory.characterFactory();

        }

    }

    public void keyBoardEvent() throws InterruptedException{

        Keyboard keyboard = new Keyboard(this);


        KeyboardEvent pressUp = new KeyboardEvent();
        pressUp.setKey(KeyboardEvent.KEY_UP);
        pressUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent pressDown = new KeyboardEvent();
        pressDown.setKey(KeyboardEvent.KEY_DOWN);
        pressDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);


        keyboard.addEventListener(pressUp);
        keyboard.addEventListener(pressDown);

    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch(keyboardEvent.getKey()){

            case KeyboardEvent.KEY_UP:
                if(bull.getPosition().getRow() > 3 && bull.getPosition().getRow() <= 6){

                    this.bull.getPosition().moveUp();
                    for (Picture pic: bull.getBull()) {
                        pic.translate(0, -Field.CELLPIXELS);
                    }
                }

                break;

            case KeyboardEvent.KEY_DOWN:
                if(bull.getPosition().getRow() >= 3 && bull.getPosition().getRow() < 6){
                    this.bull.getPosition().moveDown();
                    for (Picture pic: bull.getBull()) {
                        pic.translate(0, Field.CELLPIXELS);
                    }
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

}
