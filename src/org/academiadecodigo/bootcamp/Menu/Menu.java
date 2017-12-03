package org.academiadecodigo.bootcamp.Menu;

import org.academiadecodigo.bootcamp.Field;
import org.academiadecodigo.bootcamp.Game.Game;
import org.academiadecodigo.bootcamp.Game.SoundEffects;
import org.academiadecodigo.bootcamp.Position;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Menu implements KeyboardHandler {

    private boolean startGame;
    private boolean instructions;
    private boolean credits;
    private boolean exit;
    private boolean back;
    private Picture[] options = new Picture[4];
    private Position selection;
    private Picture[] select = new Picture[4];
    private Field menu;
    private Game game;
    private Picture pageSelected;
    private Picture background;
    SoundEffects soundEffects = new SoundEffects();
    GameOver gameOver;
    Score score;

    public Menu() throws InterruptedException {
        startGame = false;
        instructions = false;
        credits = false;
        exit = false;
        back = false;
        background = new Picture(0,0,"menu.png");
        selection = new Position(1,1);
        menu = new Field(3,6);
        gameOver = new GameOver(this);
        score = new Score(this);

    }

    public void init() throws InterruptedException {

        background.draw();
        selection.setRow(selection.getRow());

        options[0] = new Picture(6.5 * Field.CELLPIXELS, 1.75 * Field.CELLPIXELS, "start.png");
        options[1] = new Picture(6.5 * Field.CELLPIXELS, 3.25 * Field.CELLPIXELS, "credits.png");
        options[2] = new Picture(6.5 * Field.CELLPIXELS, 4.75 * Field.CELLPIXELS, "instructions.png");
        options[3] = new Picture(6.5 * Field.CELLPIXELS, 6.25 * Field.CELLPIXELS, "quit.png");
        options[0].draw();
        options[1].draw();
        options[2].draw();
        options[3].draw();

        select[0] = new Picture(6.5*Field.CELLPIXELS,1.75*Field.CELLPIXELS, "startSelected.png");
        select[1] = new Picture(6.5*Field.CELLPIXELS,3.25*Field.CELLPIXELS, "creditsSelected.png");
        select[2] = new Picture(6.5*Field.CELLPIXELS,4.75*Field.CELLPIXELS, "instructionsSelect.png");
        select[3] = new Picture(6.5*Field.CELLPIXELS,6.25*Field.CELLPIXELS, "quitSelected.png");

        moveSelection();


    }

    public void gameScreen(){
        options[0].delete();
        options[1].delete();
        options[2].delete();
        options[3].delete();
        select[0].delete();
        background.draw();
    }

    public void startGame() throws InterruptedException {

        game = new Game();
        game.init();
    }


    public boolean isStartGame() {
        return startGame;
    }

    public boolean isInstructions() {
        return instructions;
    }

    public boolean isCredits() {
        return credits;
    }

    public boolean isExit() {
        return exit;
    }

    public boolean isBack() {
        return back;
    }

    public void moveSelection() {

        if(selection.getPosition().getRow()==1){
            select[0].draw();
            select[1].delete();

        }
        if(selection.getPosition().getRow()==2){
            select[0].delete();
            select[1].draw();
            select[2].delete();

        }
        if(selection.getPosition().getRow()==3){
            select[1].delete();
            select[2].draw();
            select[3].delete();

        }

        if(selection.getPosition().getRow()==4){
            select[2].delete();
            select[3].draw();

        }

    }

    public void backToMenu() {
        startGame = false;
        instructions = false;
        credits = false;
        exit = false;
        back = false;

    }

    public Game getGame() {
        return game;
    }

    public GameOver getGameOver() {
        return gameOver;
    }

    public Score getScore() {
        return score;
    }

    public void keyBoardEvent() throws InterruptedException{

        Keyboard keyboard = new Keyboard(this);


        KeyboardEvent pressUp = new KeyboardEvent();
        pressUp.setKey(KeyboardEvent.KEY_UP);
        pressUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent pressDown = new KeyboardEvent();
        pressDown.setKey(KeyboardEvent.KEY_DOWN);
        pressDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent pressEnter = new KeyboardEvent();
        pressEnter.setKey(KeyboardEvent.KEY_SPACE);
        pressEnter.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent pressBack = new KeyboardEvent();
        pressBack.setKey(KeyboardEvent.KEY_LEFT);
        pressBack.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(pressUp);
        keyboard.addEventListener(pressDown);
        keyboard.addEventListener(pressEnter);
        keyboard.addEventListener(pressBack);

    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent){

        switch(keyboardEvent.getKey()){
            case KeyboardEvent.KEY_UP:
                    if (selection.getPosition().getRow() > 1 && selection.getPosition().getRow() <= 4 &&!isStartGame() && !instructions && !credits && !score.isScore() && !gameOver.isGameOver()) {
                        selection.getPosition().setRow(selection.getRow() - 1);
                        moveSelection();


                    }
                break;

            case KeyboardEvent.KEY_DOWN:
                    if (selection.getPosition().getRow() < 4 && selection.getPosition().getRow() >= 1 &&!isStartGame() && !instructions && !credits && !score.isScore() && !gameOver.isGameOver()) {
                        selection.getPosition().setRow(selection.getRow() + 1);
                        moveSelection();


                    }
                break;

            case KeyboardEvent.KEY_SPACE:
                if(!instructions && !credits) {
                    if (selection.getPosition().getRow() == 1) {
                        background.draw();
                        startGame = true;

                    }
                    if (selection.getPosition().getRow() == 2) {
                        instructions = true;
                        pageSelected = new Picture(0, 0, "creditsPage.png");
                        pageSelected.draw();
                    }
                    if (selection.getPosition().getRow() == 3) {
                        credits = true;
                        pageSelected = new Picture(0, 0, "instructionsPage.png");
                        pageSelected.draw();

                    }
                    if (selection.getPosition().getRow() == 4) {
                        exit = true;
                    }
                }
                break;

            case KeyboardEvent.KEY_LEFT:
                if(instructions || credits){
                    back = true;
                    pageSelected.delete();
                    instructions = false;
                    credits = false;
                }
                break;
        }


    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {


    }
}

