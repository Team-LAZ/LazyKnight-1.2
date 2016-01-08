package com.laz.lazyknight.control;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.laz.lazyknight.actor.Knight;

public class ButtonJump extends ButtonGame {

    public ButtonJump(float fX, float fY, float fWidth, float fHeight, String sAtlas, String sName, final Knight knight) {
        super(fX, fY, fWidth, fHeight, sAtlas, sName);
        this.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float fX, float fY) {
                if (!knight.isJumping && !knight.isFalling) {
                    knight.isJumping = true;
                }
            }
        });
    }
}
