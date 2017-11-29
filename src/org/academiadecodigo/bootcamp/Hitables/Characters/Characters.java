package org.academiadecodigo.bootcamp.Hitables.Characters;

public enum Characters {

    COP (20),
    SELLER (5),
    FIGHTER(10),
    TOURIST(15);

    private int points;

    Characters (int points){
        this.points=points;
    }

    public static int random (){

        return (int) Math.floor(Math.random() * 3);

    }

    public int getPoints() {
        return points;
    }
}