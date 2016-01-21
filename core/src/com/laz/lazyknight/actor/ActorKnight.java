package com.laz.lazyknight.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.laz.lazyknight.map.MapMain;

public class ActorKnight extends ActorGame {

    public float fPosX;
    public boolean isJumping, isFalling;
    public String sAction;
    Rectangle recBounds;
    OrthographicCamera camera;
    MapMain mapMain;

    public ActorKnight(float fX, float fY, float fWidth, float fHeight, String sAtlas, OrthographicCamera camera, MapMain mapMain) {
        super(fX, fY, fWidth, fHeight, sAtlas);
        this.fX = fX;
        this.fY = fY;
        this.fWidth = fWidth;
        this.fHeight = fHeight;
        this.camera = camera;
        this.mapMain = mapMain;

        fDir = 1;
        fVelX = 4;
        fVelY = 5;
        sAction = "";

        recBounds = new Rectangle();
    }

    @Override
    public void act(float fDelta) {
        if (sAction.equals("up")) {
            System.out.println("Up");
        } else if (sAction.equals("down")) {
            System.out.println("Down");
        } else if (sAction.equals("left")) {
            fDir = 0;
            trFrame = aniActor[0].getKeyFrame(fStateTime, true);
            if (fPosX > -300) {
                fPosX -= fVelX;
                camera.translate(-4, 0);
            }
        } else if (sAction.equals("right")) {
            fDir = 1;
            trFrame = aniActor[1].getKeyFrame(fStateTime, true);
            if (fPosX < 1200) {
                fPosX += fVelX;
                camera.translate(4, 0);
            }
        } else {
            if (fDir == 0) trFrame = trLeft[0];
            else if (fDir == 1) trFrame = trRight[0];
        }

        if (isJumping) {
            if (fVelY >= 0) {
                fY += fVelY * 2;
                fVelY -= 0.2;
            } else {
                isJumping = false;
                isFalling = true;
                fVelY = 0;
            }
        }

        if (isFalling) {
            if (fVelY >= 5) {
                isFalling = false;
                fVelY = 5;
            } else {
                fY -= fVelY * 2;
                fVelY += 0.2;
            }
        }

        updateBounds();
    }

    @Override
    public void draw(Batch batch, float fAlpha) {
        batch.draw(trFrame, fX, fY, fWidth, fHeight);
        fStateTime += Gdx.graphics.getDeltaTime();
    }

    public void updateBounds() {
        recBounds.x = fX - fWidth / 2;
        recBounds.y = fY - fHeight / 2;
        recBounds.width = fWidth;
        recBounds.height = fHeight;
    }
}