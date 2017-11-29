package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;


public class Bull implements KeyboardHandler{

    Position position;
    int health = 100;
    boolean isAlive = true;
    private Rectangle bull;

    public Bull(){
        position = new Position(0,6);
        bull = new Rectangle(0, 6*Field.CELLPIXELS, Field.CELLPIXELS, Field.CELLPIXELS);
        bull.setColor(Color.BLACK);
        bull.fill();

    }

    public int getCol(){
        return position.getCol();
    }

    public int getRow(){
        return position.getRow();
    }

    //BULL KEYBOARD EVENTS

    public void keyBoardEvent() /*throws InterruptedException*/{

        Keyboard keyboard = new Keyboard(this);


        KeyboardEvent pressUp = new KeyboardEvent();
        pressUp.setKey(KeyboardEvent.KEY_UP);
        pressUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent pressDown = new KeyboardEvent();
        pressDown.setKey(KeyboardEvent.KEY_DOWN);
        pressDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);


        //Adding events
        keyboard.addEventListener(pressUp);
        keyboard.addEventListener(pressDown);

    }//End keyBoardEvents();


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch(keyboardEvent.getKey()){

            case KeyboardEvent.KEY_UP:
                if(position.getRow() > 5 && position.getRow() <= 8){
                    this.position.moveUp();
                    bull.translate(0,-Field.CELLPIXELS);
                }

                break;

            case KeyboardEvent.KEY_DOWN:
                if(position.getRow() >= 5 && position.getRow() < 8){
                    this.position.moveDown();
                    bull.translate(0,Field.CELLPIXELS);
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

}
