package org.academiadecodigo.bootcamp.Game;

import org.academiadecodigo.bootcamp.Field;
import org.academiadecodigo.bootcamp.Position;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GameObjects{

    private Position position;
    private boolean deleted;
    private Picture object;


     public GameObjects(int col, int row, String picture){
         this.position = new Position(col,row);
         object = new Picture(col*Field.CELLPIXELS, row*Field.CELLPIXELS, picture);
         deleted = false;
     }

     public GameObjects(int row){

         this.position = new Position(18, row);
         object = new Picture(18*Field.CELLPIXELS, (row*Field.CELLPIXELS)-(Field.CELLPIXELS/2), "cloud.jpg");

     }

     public GameObjects (){

         this.position = new Position(16,1);
         int random = (int) (Math.round(Math.random())*1)+1;
         System.out.println(random);
         switch (random){
             case 0:
                 object = new Picture(16*Field.CELLPIXELS+18, Field.CELLPIXELS+10, "house1.png");
                 break;
             case 1:
                 object = new Picture(16*Field.CELLPIXELS+18, Field.CELLPIXELS+10, "house2.png");
                 break;
             case 2:
                 object = new Picture(16*Field.CELLPIXELS+18, Field.CELLPIXELS+10, "house3.png");
                 break;

             default:
                 break;
         }


     }

    public Position getPosition() {
        return position;
    }

    public void moveForward(){
        if(getPosition().getCol() >= -2 && getPosition().getCol() <= 20) {
            if (getPosition().getCol() == -2) {
                object.delete();
                deleted = true;
            }
            getPosition().moveLeft();
            object.translate(-Field.CELLPIXELS,0);
        }
    }

    public void dodgeUp(){
        if (getPosition().getCol() == 1) {
            object.translate(0,-Field.CELLPIXELS);
        }
    }
    public void dodgeDown(){
        if (getPosition().getCol() == 1) {
            object.translate(0,Field.CELLPIXELS);
        }
    }

    public void draw(){
        object.draw();
    }

    public void delete(){

        object.delete();

    }

    public boolean isDeleted() {
        return deleted;
    }
}
