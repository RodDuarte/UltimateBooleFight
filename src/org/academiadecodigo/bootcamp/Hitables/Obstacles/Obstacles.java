package org.academiadecodigo.bootcamp.Hitables.Obstacles;

public enum  Obstacles {
    ROCK (10),
    TRUCK (10),
    GARBAGECAN(10);

    private int lostHealth;

    Obstacles (int lostHealth){
        this.lostHealth=lostHealth;
    }

    public static int random (){

        return (int) Math.floor(Math.random() * 3);

    }

    public int getLostHealth() {
        return lostHealth;
    }
}