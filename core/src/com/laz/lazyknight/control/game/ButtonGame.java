package com.laz.lazyknight.control.game;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class ButtonGame extends Button {

    TextureAtlas taButton;
    Skin skButton;
    ButtonStyle bsButton;

    public ButtonGame(float fX, float fY, float fWidth, float fHeight, String sAtlas, String sName) {
        setBounds(fX, fY, fWidth, fHeight);
        setName(sName);

        taButton = new TextureAtlas(sAtlas);

        skButton = new Skin();
        skButton.addRegions(taButton);

        bsButton = new ButtonStyle();
        bsButton.up = skButton.getDrawable(sName);
        setStyle(bsButton);
    }
}
