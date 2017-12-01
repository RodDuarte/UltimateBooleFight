package org.academiadecodigo.bootcamp.Hitables;

import org.academiadecodigo.bootcamp.Game.GameObjects;
import org.academiadecodigo.bootcamp.Hitables.Characters.*;
import org.academiadecodigo.bootcamp.Hitables.Characters.Character;
import org.academiadecodigo.bootcamp.Hitables.Obstacles.*;

public class Factory {

    public GameObjects characterFactory(){

        int range = (8 - 5) + 1;
        int random = (int)Math.floor((Math.random() * range) + 3);

        switch (Characters.values()[Characters.random()]){
            case COP:
                return new Character(18,random, Characters.COP, "police.png");

            case SELLER:
                return new Character(18,random, Characters.SELLER, "sellerMan.png");

            case FIGHTER:
                return new Character(18,random, Characters.FIGHTER, "tourist.png");

            case TOURIST:
                return new Character(18, random, Characters.TOURIST, "tourist.png");

            default:
                return null;
        }
    }

    public GameObjects obstacleFactory(){

        int range = (8 - 5) + 1;
        int random = (int)Math.floor((Math.random() * range) + 3);

        switch (Obstacles.values()[Obstacles.random()]){

            case ROCK:
                return new Obstacle(17,random, Obstacles.ROCK, "rock.png");

            case BEER:
                return new Obstacle(18,random, Obstacles.BEER, "superBock.png");

            case GARBAGECAN:
                return new Obstacle(18,random, Obstacles.GARBAGECAN, "garbageCan.png");

            default:
                return null;

        }

    }
}
