package com.laz.lazyknight.control;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.laz.lazyknight.actor.ActorKnight;

public class ButtonJump extends ButtonGame {

    public ButtonJump(float fX, float fY, float fWidth, float fHeight, String sAtlas, String sName, final ActorKnight actKnight) {
        super(fX, fY, fWidth, fHeight, sAtlas, sName);
        this.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float fX, float fY) {
                if (!actKnight.isJumping && !actKnight.isFalling) {
                    actKnight.isJumping = true;
                }
            }
        });
    }
}
