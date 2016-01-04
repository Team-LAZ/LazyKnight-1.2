package com.laz.lazyknight.knight;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class MagicProjectile extends Image {

    float fX, fY, fWidth, fHeight;

    public MagicProjectile(float fX, float fY, float fWidth, float fHeight) {
        this.fX = fX;
        this.fY = fY;
        this.fWidth = fWidth;
        this.fHeight = fHeight;
    }

    @Override
    public void act (float fDelta) {

    }

    @Override
    public void draw (Batch batch, float fAlpha) {
        //batch.draw(trFrame, fX, fY, fWidth, fHeight); //update magic projectile
    }
}
