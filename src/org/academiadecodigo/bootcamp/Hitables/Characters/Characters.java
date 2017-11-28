package org.academiadecodigo.bootcamp.Hitables.Characters;

public enum Characters {

    COP (10),
    SELLER (10),
    FIGHTER(10),
    TOURIST(10);

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