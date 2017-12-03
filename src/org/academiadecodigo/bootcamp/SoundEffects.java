package org.academiadecodigo.bootcamp.Game;
import org.academiadecodigo.bootcamp.kuusisto.tinysound.Sound;
import org.academiadecodigo.bootcamp.kuusisto.tinysound.Music;
import org.academiadecodigo.bootcamp.kuusisto.tinysound.TinySound;

public class SoundEffects{

    private Music entry;
    private Sound coinsSound;
    private Sound crashSound;

    public void tsInit(){

        TinySound.init();
        entry = TinySound.loadMusic("entry.wav");
        coinsSound = TinySound.loadSound("coinSound.wav");
        crashSound = TinySound.loadSound("crashSound.wav");
    }


    public void playCoinSound(){
        coinsSound.play();
    }


    public void playEntry(){
        entry.play(true);
    }

    public void playCrashSound(){
        crashSound.play();
    }
}