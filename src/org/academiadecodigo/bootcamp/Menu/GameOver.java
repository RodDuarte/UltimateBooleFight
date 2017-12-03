package org.academiadecodigo.bootcamp.Menu;

import org.academiadecodigo.bootcamp.Field;
import org.academiadecodigo.bootcamp.Position;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GameOver implements KeyboardHandler {

    private boolean backToMenu;
    private Picture background;
    private Menu menu;


    public GameOver(Menu menu){
        this.menu = menu;
        background = new Picture(0,0,"GameOVer.png");
        backToMenu = false;
    }

    public void init(){
        background.draw();
    }

    public boolean isBackToMenu() {
        return backToMenu;
    }

    public void keyBoardEvent() throws InterruptedException{

        Keyboard keyboard = new Keyboard(this);
        KeyboardEvent pressEnter = new KeyboardEvent();
        pressEnter.setKey(KeyboardEvent.KEY_SPACE);
        pressEnter.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(pressEnter);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_SPACE:
                backToMenu = true;
                background.delete();
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {


    }
}
