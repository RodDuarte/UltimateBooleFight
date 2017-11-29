package org.academiadecodigo.bootcamp.Hitables;

import org.academiadecodigo.bootcamp.Game.GameObjects;
import org.academiadecodigo.bootcamp.Hitables.Characters.*;
import org.academiadecodigo.bootcamp.Hitables.Obstacles.GarbageCan;
import org.academiadecodigo.bootcamp.Hitables.Obstacles.Obstacles;
import org.academiadecodigo.bootcamp.Hitables.Obstacles.Rock;
import org.academiadecodigo.bootcamp.Hitables.Obstacles.Truck;

public class Factory {

    public GameObjects characterFactory(){

        int range = (8 - 5) + 1;
        int random = (int)Math.floor((Math.random() * range) + 5);

        switch (Characters.values()[Characters.random()]){
            case COP:
                return new Cop(19,random);

            case SELLER:
                return new Seller(19,random);

            case FIGHTER:
                return new Fighter(19,random);

            case TOURIST:
                return new Tourist(19, random);

            default:
                return null;
        }
    }

    public GameObjects obstacleFactory(){

        int range = (8 - 5) + 1;
        int random = (int)Math.floor((Math.random() * range) + 5);

        switch (Obstacles.values()[Obstacles.random()]){

            case ROCK:
                return new Rock(19,random);

            case TRUCK:
                return new Truck(19,random);

            case GARBAGECAN:
                return new GarbageCan(19,random);

            default:
                return null;

        }

    }
}
