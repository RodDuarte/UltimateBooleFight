package org.academiadecodigo.bootcamp.Menu;

import org.academiadecodigo.bootcamp.Field;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class Score implements KeyboardHandler {

    private boolean backToMenu;
    private Picture background;
    private Menu menu;
    private Text scoreText;
    private boolean score;



    public Score(Menu menu){
        this.menu = menu;
        background = new Picture(0,0,"Score.png");
        backToMenu = false;
        score = false;
    }

    public void init(Integer score){
        background.draw();
        this.score = true;
        scoreText = new Text(870,580, "" + score);
        scoreText.grow(170,100);
        scoreText.draw();
    }

    public boolean isBackToMenu() {
        return backToMenu;
    }

    public boolean isScore() {
        return score;
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
                score = false;
                background.delete();
                scoreText.delete();
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {


    }

}
