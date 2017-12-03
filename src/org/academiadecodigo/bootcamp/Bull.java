package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Bull {

    private Position position;
    private Integer health = 3;
    private boolean isAlive = true;
    private Picture[] bull = new Picture[5];
    private int bullPicCounter = 0;



    public Bull() throws InterruptedException {
        position = new Position(1, 6);
        bull[0] = new Picture(position.getCol(), position.getRow() * Field.CELLPIXELS, "bullMove1.png");
        bull[1] = new Picture(position.getCol(), position.getRow() * Field.CELLPIXELS, "bullMove2.png");
        bull[2] = new Picture(position.getCol(), position.getRow() * Field.CELLPIXELS, "bullMove3.png");
        bull[3] = new Picture(position.getCol(), position.getRow() * Field.CELLPIXELS, "bullMove4.png");
        bull[4] = new Picture(position.getCol(), position.getRow() * Field.CELLPIXELS, "bullMove5.png");
    }


    public double getCol(){
        return position.getCol();
    }

    public int getRow(){
        return position.getRow();
    }


    public Position getPosition() {
        return position;
    }


    public Integer getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setDeath() {
        isAlive = false;
    }

    public Picture[] getBull() {
        return bull;
    }


    public Picture getPic(Picture[] picArray){

        bullPicCounter++;

        if(bullPicCounter==5){

            bullPicCounter=0;

        }

        return picArray[bullPicCounter];
    }

}
