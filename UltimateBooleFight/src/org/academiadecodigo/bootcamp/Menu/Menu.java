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
    private Picture[] options;
    private Position selection;
    private Picture[] select;
    private Field menu;


    public Menu(){

        startGame = false;
        instructions = false;
        credits = false;
        exit = false;

    }

    public void init(){
        selection = new Position(1,1);
        menu = new Field(3,6);
        options[0] = new Picture();
        options[1] = new Picture();
        options[2] = new Picture();
        options[3] = new Picture();
        options[0].draw();
        options[1].draw();
        options[2].draw();
        options[3].draw();

        select[0] = new Picture();
        select[1] = new Picture();
        select[2] = new Picture();
        select[3] = new Picture();
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
        pressDown.setKey(KeyboardEvent.KEY_SPACE);
        pressDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(pressUp);
        keyboard.addEventListener(pressDown);
        keyboard.addEventListener(pressEnter);

    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch(keyboardEvent.getKey()){

            case KeyboardEvent.KEY_UP:
                if(selection.getPosition().getRow() >= 4 && selection.getPosition().getRow() < 1){

                    this.selection.getPosition().moveUp();

                        moveSelection();

                }

                break;

            case KeyboardEvent.KEY_DOWN:
                if(selection.getPosition().getRow() > 4 && selection.getPosition().getRow() <= 1){

                    this.selection.getPosition().moveDown();

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

