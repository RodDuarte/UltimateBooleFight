package org.academiadecodigo.bootcamp.Hitables.Obstacles;

public enum  Obstacles {
    ROCK ,
    BEER ,
    GARBAGECAN;

    public static int random (){

        return (int) Math.floor(Math.random() * 3);

    }

}