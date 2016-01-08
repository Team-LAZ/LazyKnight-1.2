package com.laz.lazyknight.control;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public abstract class ButtonGame extends Button {

    TextureAtlas taButtons;
    Skin skButtons;
    ButtonStyle bsButtons;

    public ButtonGame(float fX, float fY, float fWidth, float fHeight, String sAtlas, String sName) {
        setBounds(fX, fY, fWidth, fHeight);
        setName(sName);

        taButtons = new TextureAtlas(sAtlas);

        skButtons = new Skin();
        skButtons.addRegions(taButtons);

        bsButtons = new ButtonStyle();
        bsButtons.up = skButtons.getDrawable(sName);
        setStyle(bsButtons);
    }
}
