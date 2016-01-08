package com.laz.lazyknight.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.laz.lazyknight.util.Constants;

public class ActorProjectile extends ActorGame {

    public float fCurrentLife;
    public boolean isAlive;

    public ActorProjectile(float fX, float fY, float fWidth, float fHeight, String sAtlas) {
        super(fX, fY, fWidth, fHeight, sAtlas);
        this.fX = fX;
        this.fY = fY;
        this.fWidth = fWidth;
        this.fHeight = fHeight;
        this.setVisible(false);

        fVelX = 5;
    }

    @Override
    public void act(float fDelta) {
        if (isAlive) {
            this.setVisible(true);
            if (fDir == 0) {
                trFrame = aniActor[0].getKeyFrame(fStateTime, true);
                fX -= fVelX;
            } else if (fDir == 1) {
                trFrame = aniActor[1].getKeyFrame(fStateTime, true);
                fX += fVelX;
            }
            fCurrentLife--;
        }

        if (fCurrentLife == 0) {
            resetProjectile();
        }
    }

    public void resetProjectile() {
        this.setVisible(false);
        isAlive = false;
        fCurrentLife = 75;
        fX = Constants.APP_WIDTH / 2 - 90;
    }

    @Override
    public void draw(Batch batch, float fAlpha) {
        batch.draw(trFrame, fX, fY, fWidth, fHeight);
        fStateTime += Gdx.graphics.getDeltaTime();
    }
}
