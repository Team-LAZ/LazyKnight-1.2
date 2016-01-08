package com.laz.lazyknight.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.laz.lazyknight.map.MapMain;

public class Knight extends Actor {

    public float fX, fY, fPosX, fPosY, fDir, fWidth, fHeight, fStateTime, fVelX, fVelY;
    public boolean isJumping, isFalling;
    public String sAction;
    TextureAtlas taKnight;
    TextureRegion trFrame, trLeft[], trRight[];
    Animation aniKnight[];
    OrthographicCamera camera;
    MapMain mapMain;

    public Knight(float fX, float fY, float fWidth, float fHeight, OrthographicCamera camera, MapMain mapMain) {
        this.fX = fX; //x position of knight
        this.fY = fY; //y position of knight
        this.fWidth = fWidth;
        this.fHeight = fHeight;
        this.camera = camera;
        this.mapMain = mapMain;

        fStateTime = 0;
        fDir = 1; //default direction set to right, TODO read from file
        fPosX = 0; //x position of camera, TODO read from file and move to better place (camera class? / mapMain class?)
        fPosY = 0; //y position of camera, TODO read from file and move to better place (camera class? / mapMain class?)
        fVelX = 4;
        fVelY = 5;
        sAction = "";

        taKnight = new TextureAtlas("knight.atlas");

        trLeft = new TextureRegion[3];
        trRight = new TextureRegion[3];
        for (int i = 0; i < 3; i++) {
            trLeft[i] = taKnight.findRegion("left" + (i + 1)); //load left-facing images
            trRight[i] = taKnight.findRegion("right" + (i + 1)); //load right-facing images
        }
        trFrame = new TextureRegion(trRight[0]); //set default image, TODO read from file

        aniKnight = new Animation[2];
        aniKnight[0] = new Animation(0.1f, trLeft); //load left-facing animations
        aniKnight[1] = new Animation(0.1f, trRight); //load right-facing animations
    }

    @Override
    public void act(float fDelta) {
        if (sAction.equals("up")) {
            System.out.println("Up");
        } else if (sAction.equals("down")) {
            System.out.println("Down");
        } else if (sAction.equals("left")) {
            fDir = 0;
            trFrame = aniKnight[0].getKeyFrame(fStateTime, true);
            if (fPosX > -300) {
                fPosX -= fVelX;
                camera.translate(-4, 0);
            }
        } else if (sAction.equals("right")) {
            fDir = 1;
            trFrame = aniKnight[1].getKeyFrame(fStateTime, true);
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
    }

    @Override
    public void draw(Batch batch, float fAlpha) {
        batch.draw(trFrame, fX, fY, fWidth, fHeight); //update knight
        fStateTime += Gdx.graphics.getDeltaTime(); //update state time
    }
}