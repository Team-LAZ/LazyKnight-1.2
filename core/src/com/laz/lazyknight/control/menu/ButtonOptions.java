package com.laz.lazyknight.control.menu;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.laz.lazyknight.LazyKnight;

public class ButtonOptions extends ButtonMenu {

    LazyKnight game;

    public ButtonOptions(float fX, float fY, float fWidth, float fHeight, String sName, LazyKnight game) {
        super(fX, fY, fWidth, fHeight, sName);
        this.game = game;
        this.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float fX, float fY) {
                options();
            }
        });
    }

    public void options() {

    }
}
