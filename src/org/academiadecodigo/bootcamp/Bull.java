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
        Position bullPosition = new Position(3*10,2*10);
        this.position = bullPosition;
    }

    public void createBull() throws InterruptedException{
        bull = new Rectangle(position.getCol(), position.getRow(), 10, 10);
        bull.draw();
        bull.setColor(Color.BLACK);
        bull.fill();
    }




    public void move(Direction direction){
        switch(direction){
            case UP:
                if(position.getRow() > 0) {
                    position.moveUp();
                }
                break;

            case DOWN:
                if(position.getRow() < (Field.getHeight())-1) { //ver height!!
                    position.moveDown();

                }
                break;
        }
    }

    public int getCol(){
        return position.getCol();
    }

    public int getRow(){
        return position.getRow();
    }

    //BULL KEYBOARDEVENTS

    public void keyBoardEvent() throws InterruptedException{

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
                System.out.println("up");
                this.position.moveUp();

                if(position.getRow() > 0){
                    bull.translate(0,-1);
                }
                System.out.println("row: " + getRow());

                break;

            case KeyboardEvent.KEY_DOWN:
                System.out.println("down");
                this.position.moveDown();

                if(position.getRow() < 0){
                    bull.translate(0,1);
                }
                System.out.println("row: " + getRow());
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

}

/*
public class Bull {

    private Position pos;
    private Rectangle rectangle;

    public Bull(){

        pos = new Position(0,6);
        rectangle = new Rectangle(0, 6*Field.CELLPIXELS,Field.CELLPIXELS,Field.CELLPIXELS);
        rectangle.setColor(Color.BLACK);
        rectangle.fill();

    }

}
*/