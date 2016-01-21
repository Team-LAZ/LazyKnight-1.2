package com.laz.lazyknight.control.game;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.laz.lazyknight.actor.ActorKnight;

public class ButtonDPad extends ButtonGame {

    public ButtonDPad(float fX, float fY, float fWidth, float fHeight, String sAtlas, String sName, final ActorKnight actKnight) {
        super(fX, fY, fWidth, fHeight, sAtlas, sName);

        this.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                actKnight.sAction = getName();
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                actKnight.sAction = "";
            }
        });
    }
}