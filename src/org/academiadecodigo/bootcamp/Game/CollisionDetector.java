package org.academiadecodigo.bootcamp.Game;

import org.academiadecodigo.bootcamp.Bull;
import org.academiadecodigo.bootcamp.Hitables.Characters.Character;

public class CollisionDetector {

    private Bull bull;

    public CollisionDetector(Bull bull) {
        this.bull = bull;
    }

    public boolean check(GameObjects gameObject) {

        if ((bull.getPosition()).equals(gameObject.getPosition())) {
            return true;
        }
        return false;
    }

}

