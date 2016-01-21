package com.laz.lazyknight.control.menu;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.laz.lazyknight.LazyKnight;
import com.laz.lazyknight.screen.ScreenGame;

public class ButtonPlay extends ButtonMenu {

    LazyKnight game;

    public ButtonPlay(float fX, float fY, float fWidth, float fHeight, String sName, LazyKnight game) {
        super(fX, fY, fWidth, fHeight, sName);
        this.game = game;
        this.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float fX, float fY) {
                play();
            }
        });
    }

    public void play() {
        game.setScreen(new ScreenGame());
    }
}
