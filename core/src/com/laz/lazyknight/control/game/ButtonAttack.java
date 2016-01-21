package com.laz.lazyknight.control.game;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class ButtonAttack extends ButtonGame {

    public ButtonAttack(float fX, float fY, float fWidth, float fHeight, String sAtlas, String sName) {
        super(fX, fY, fWidth, fHeight, sAtlas, sName);
        this.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float fX, float fY) {
                System.out.println("Attack");
            }
        });
    }
}
