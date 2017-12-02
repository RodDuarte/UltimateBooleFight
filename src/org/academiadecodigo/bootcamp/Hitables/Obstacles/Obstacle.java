package org.academiadecodigo.bootcamp.Hitables.Obstacles;

import org.academiadecodigo.bootcamp.Game.GameObjects;

public class Obstacle extends GameObjects {

    private Obstacles obstacles;

    public Obstacle (int col, int row, Obstacles obstacles, String picture){

        super(col,row, picture);
        this.obstacles = obstacles;

    }

    public Obstacles getObstacles() {
        return obstacles;
    }
}
