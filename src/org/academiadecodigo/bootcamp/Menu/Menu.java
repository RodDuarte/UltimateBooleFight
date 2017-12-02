package org.academiadecodigo.bootcamp.Menu;

import org.academiadecodigo.bootcamp.Field;
import org.academiadecodigo.bootcamp.Position;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
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
    private Picture[] options = new Picture[4];
    private Position selection;
    private Picture[] select = new Picture[4];
    private Field menu;


    public Menu(){

        startGame = false;
        instructions = false;
        credits = false;
        exit = false;

    }

    public void init() throws InterruptedException {
        selection = new Position(1,1);
        menu = new Field(3,6);
        options[0] = new Picture(6*Field.CELLPIXELS,1*Field.CELLPIXELS, "start.png");
        options[1] = new Picture(6*Field.CELLPIXELS,3*Field.CELLPIXELS, "credits.png");
        options[2] = new Picture(6*Field.CELLPIXELS,5*Field.CELLPIXELS, "credits.png");
        options[3] = new Picture(6*Field.CELLPIXELS,7*Field.CELLPIXELS, "quit.png");
        options[0].draw();
        options[1].draw();
        options[2].draw();
        options[3].draw();
        System.out.println(selection.getRow());

        select[0] = new Picture(6*Field.CELLPIXELS,1*Field.CELLPIXELS, "startSelected.png");
        select[1] = new Picture(6*Field.CELLPIXELS,3*Field.CELLPIXELS, "creditsSelected.png");
        select[2] = new Picture(6*Field.CELLPIXELS,5*Field.CELLPIXELS, "creditsSelected.png");
        select[3] = new Picture(6*Field.CELLPIXELS,7*Field.CELLPIXELS, "quitSelected.png");
        keyBoardEvent();
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

    public void moveSelection(){

        if(selection.getPosition().getRow()==1){
            select[1].delete();
            select[0].draw();
        }
        if(selection.getPosition().getRow()==2){
            select[0].delete();
            select[2].delete();
            select[1].draw();
        }
        if(selection.getPosition().getRow()==3){
            select[1].delete();
            select[3].delete();
            select[2].draw();
        }
        if(selection.getPosition().getRow()==4){
            select[2].delete();
            select[3].draw();
        }

    }

    public void backToMenu(){
        startGame = false;
        instructions = false;
        credits = false;
        exit = false;
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

        keyboard.addEventListener(pressUp);
        keyboard.addEventListener(pressDown);
        keyboard.addEventListener(pressEnter);

    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch(keyboardEvent.getKey()){

            case KeyboardEvent.KEY_UP:
                if(selection.getPosition().getRow() > 1 /*&& selection.getPosition().getRow() < 7*/){
                    System.out.println("Move up "+ selection.getRow());
                    this.selection.getPosition().setRow(selection.getRow()-1);

                        moveSelection();

                }

                break;

            case KeyboardEvent.KEY_DOWN:
                if(/*selection.getPosition().getRow() >  && */selection.getPosition().getRow() < 4){
                    System.out.println("Move Down"+ selection.getRow());
                    this.selection.getPosition().setRow(selection.getRow()+1);

                    moveSelection();

                }

                break;

            case KeyboardEvent.KEY_SPACE:

                if(selection.getPosition().getRow() == 1){
                    startGame = true;
                }
                if(selection.getPosition().getRow() == 2){
                    instructions = true;
                }
                if(selection.getPosition().getRow() == 3){
                    credits = true;
                }
                if(selection.getPosition().getRow() == 4){
                    exit = true;
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}

