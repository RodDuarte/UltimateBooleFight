package org.academiadecodigo.bootcamp.Game;

import org.academiadecodigo.bootcamp.Bull;
import org.academiadecodigo.bootcamp.Hitables.Characters.Character;

public class CollisionDetector {

    private Bull bull;

    public CollisionDetector(Bull bull) {
        this.bull = bull;
    }

    public boolean check(GameObjects gameObject) {

        if ((bull.getPosition().getCol()) == (gameObject.getPosition().getCol()) &&
                (bull.getPosition().getRow()) == (gameObject.getPosition().getRow())) {
            return true;
        }
        return false;
    }

    public boolean check(Cages cages) {

        if ((bull.getPosition().getCol()) == (cages.getPos().getCol())) {
            return true;
        }
        return false;
    }

}

