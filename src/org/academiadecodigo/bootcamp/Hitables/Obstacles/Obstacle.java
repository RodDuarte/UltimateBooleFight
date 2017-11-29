package org.academiadecodigo.bootcamp.Hitables.Obstacles;

import org.academiadecodigo.bootcamp.Hitables.Hitables;

public class Obstacle implements Hitables{

    private int col;
    private int row;

    public Obstacle (int col, int row){
        this.col = col;
        this.row = row;
    }
}
