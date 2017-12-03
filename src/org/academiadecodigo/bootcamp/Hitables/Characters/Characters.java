package org.academiadecodigo.bootcamp.Hitables.Characters;

public enum Characters {

    COP (30),
    SELLER (10),
    FIGHTER(50),
    TOURIST(20);

    private int points;

    Characters (int points){
        this.points=points;
    }

    public static int random (){
        return (int) Math.floor(Math.random() * 4);
    }

    public int getPoints() {
        return points;
    }

}