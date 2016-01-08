package com.laz.lazyknight.actor;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class ActorGame extends Actor {

    public float fX, fY, fWidth, fHeight, fVelX, fVelY, fDir, fStateTime;
    TextureAtlas taActor;
    TextureRegion trFrame, trLeft[], trRight[];
    Animation aniActor[];

    public ActorGame(float fX, float fY, float fWidth, float fHeight, String sAtlas) {
        setBounds(fX, fY, fWidth, fHeight);

        taActor = new TextureAtlas(sAtlas);

        trLeft = new TextureRegion[3];
        trRight = new TextureRegion[3];
        for (int i = 0; i < 3; i++) {
            trLeft[i] = taActor.findRegion("left" + (i + 1));
            trRight[i] = taActor.findRegion("right" + (i + 1));
        }
        trFrame = new TextureRegion(trRight[0]);

        aniActor = new Animation[2];
        aniActor[0] = new Animation(0.1f, trLeft);
        aniActor[1] = new Animation(0.1f, trRight);
    }
}
