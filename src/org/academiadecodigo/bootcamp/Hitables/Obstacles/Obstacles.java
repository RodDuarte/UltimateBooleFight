package org.academiadecodigo.bootcamp.Hitables.Obstacles;

public enum  Obstacles {
    ROCK (20),
    TRUCK (30),
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