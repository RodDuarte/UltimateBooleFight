package org.academiadecodigo.bootcamp.Hitables.Characters;

import org.academiadecodigo.bootcamp.Field;
import org.academiadecodigo.bootcamp.Game.GameObjects;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Character extends GameObjects{

    private Characters characters;

    public Character(int col, int row, Characters characters, String picture){
        super(col,row , picture);
        this.characters = characters;
    }

    public Characters getCharacters() {
        return characters;
    }
}
