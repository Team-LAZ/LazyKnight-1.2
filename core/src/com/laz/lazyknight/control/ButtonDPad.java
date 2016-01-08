package com.laz.lazyknight.control;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.laz.lazyknight.actor.Knight;

public class ButtonDPad extends ButtonGame {

    public ButtonDPad(float fX, float fY, float fWidth, float fHeight, String sAtlas, String sName, final Knight knight) {
        super(fX, fY, fWidth, fHeight, sAtlas, sName);

        this.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                knight.sAction = getName();
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                knight.sAction = "";
            }
        });
    }
}