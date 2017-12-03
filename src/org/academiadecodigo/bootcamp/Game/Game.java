package org.academiadecodigo.bootcamp.Game;

import org.academiadecodigo.bootcamp.Bull;
import org.academiadecodigo.bootcamp.Field;
import org.academiadecodigo.bootcamp.Hitables.Characters.Character;
import org.academiadecodigo.bootcamp.Hitables.Factory;
import org.academiadecodigo.bootcamp.Hitables.Obstacles.Obstacle;
import org.academiadecodigo.bootcamp.Menu.GameOver;
import org.academiadecodigo.bootcamp.kuusisto.tinysound.TinySound;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.bootcamp.Game.SoundEffects;

public class Game implements KeyboardHandler {

    private Field road;
    private Field sky;
    private Cages cages;
    private int delay;
    private Integer score = 0;
    private GameObjects[] gameObjectsToHit;
    private GameObjects[] gameObjectsClouds;
    private GameObjects[] gameObjectsHouses;
    private Bull bull;
    private double iterator = -1;
    private Text textScore;
    private Picture[] bullLife = new Picture[3];
    private Picture bull2;
    private int bullPicCounter;
    private SoundEffects soundEffects;
    private boolean gamePlayed = false;

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
        soundEffects = new SoundEffects();


    }

    public void init() throws InterruptedException {
            soundEffects.tsInit();
            road.init();
            sky.initBackground();
            textScore.draw();
            bullLife[0].draw();
            bullLife[1].draw();
            bullLife[2].draw();
            createObjects();
            if(!gamePlayed) {
                start();
                gamePlayed = true;
            }
            if(gamePlayed){
                goingToCages();
                gamePlayed = false;
            }
    }

    public void start() throws InterruptedException{
            int deletedCounter = 0;
            bull = new Bull();
            keyBoardEvent();
            CollisionDetector collisionDetector = new CollisionDetector(bull);
            soundEffects.playEntry();


            while (bull.isAlive() && deletedCounter < 1) {

                bull2 = getPic(bull.getBull());
                bull2.draw();

                for (int i = 0; i < gameObjectsToHit.length; i++) {

                    if(!gameObjectsToHit[i].isDeleted()) {
                        gameObjectsToHit[i].moveForward();
                        gameObjectsToHit[i].draw();
                    }
                        gameObjectsClouds[i].moveForward();
                        gameObjectsClouds[i].moveForward();
                        gameObjectsClouds[i].draw();
                        gameObjectsClouds[i + 50].moveForward();
                        gameObjectsClouds[i + 50].draw();
                    if (!gameObjectsHouses[i].isDeleted()) {
                        gameObjectsHouses[i].moveForward();
                        gameObjectsHouses[i].draw();
                    }

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
                        if (collisionDetector.check(gameObjectsToHit[i]) && !gameObjectsToHit[i].isDeleted()) {

                            if (gameObjectsToHit[i] instanceof Character) {
                                soundEffects.playCoinSound();
                                Character character = (Character) gameObjectsToHit[i];
                                score += character.getCharacters().getPoints();
                                textScore.setText("Score: " + score.toString());
                                textScore.draw();

                            } else if (gameObjectsToHit[i] instanceof Obstacle) {
                                soundEffects.playCrashSound();
                                bullLife[bull.getHealth() - 1].delete();
                                bull.setHealth(bull.getHealth() - 1);

                            }
                            gameObjectsToHit[i].setDeleted();
                            gameObjectsToHit[i].delete();
                        }


                        if (i > (2 * gameObjectsToHit.length) / 4 && i <= (2 * gameObjectsToHit.length) / 4) {
                            delay = 90;
                        }
                        if (i > gameObjectsToHit.length / 4) {
                            delay = 70;
                        }
                        if (i > gameObjectsToHit.length / 3) {
                            delay = 60;
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

        TinySound.shutdown();


    }

    public void goingToCages() throws InterruptedException{
        if (bullLiveStatus()) {
            road.init();
            sky.initBackground();

            bull = new Bull();

            keyBoardEvent();
            CollisionDetector collisionDetector = new CollisionDetector(bull);
            createCages();

            while (cages.getPos().getCol() > 1) {
                bull2 = getPic(bull.getBull());
                bull2.draw();

                cages.moveCages();

                if (collisionDetector.check(cages)) {
                    cages.deleteCages();
                    bull2.delete();
                    return;
                }

                Thread.sleep(100);
                bull2.delete();

            }
        }

    }


    public boolean bullLiveStatus(){
        return bull.isAlive();
    }

    public void createCages(){
        cages = new Cages();
    }


    public Picture getPic(Picture[] picArray){

        bullPicCounter++;

        if(bullPicCounter==5){

            bullPicCounter=0;

        }

        return picArray[bullPicCounter];
    }

    public Integer getScore() {
        return score;
    }

    public void createObjects(){

        Factory factory = new Factory();
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
