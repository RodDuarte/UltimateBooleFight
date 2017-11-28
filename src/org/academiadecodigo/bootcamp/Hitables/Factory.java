package org.academiadecodigo.bootcamp.Hitables;

import org.academiadecodigo.bootcamp.Hitables.Characters.*;
import org.academiadecodigo.bootcamp.Hitables.Obstacles.GarbageCan;
import org.academiadecodigo.bootcamp.Hitables.Obstacles.Obstacles;
import org.academiadecodigo.bootcamp.Hitables.Obstacles.Rock;
import org.academiadecodigo.bootcamp.Hitables.Obstacles.Truck;

public class Factory {
    public Hitables characterFactory(){

        switch (Characters.values()[Characters.random()]){
            case COP:
                return new Cop(2,2);


            case SELLER:
                return new Seller(4,5);

            case FIGHTER:
                return new Fighter(4,5);

            case TOURIST:
                return new Tourist(4, 5);

            default:
                return null;
        }
    }

    public Hitables obstacleFactory(){

        switch (Obstacles.values()[Obstacles.random()]){

            case ROCK:
                return new Rock(4,5);

            case TRUCK:
                return new Truck(4,5);

            case GARBAGECAN:
                return new GarbageCan(4,5);

            default:
                return null;

        }

    }
}
