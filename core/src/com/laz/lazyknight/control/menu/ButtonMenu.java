package com.laz.lazyknight.control.menu;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class ButtonMenu extends Button {

    TextureAtlas taMenu;
    Skin skMenu;
    ButtonStyle bsMenu;

    public ButtonMenu(float fX, float fY, float fWidth, float fHeight, String sName) {
        setBounds(fX, fY, fWidth, fHeight);

        taMenu = new TextureAtlas("menu.atlas");

        skMenu = new Skin();
        skMenu.addRegions(taMenu);

        bsMenu = new ButtonStyle();
        bsMenu.up = skMenu.getDrawable(sName + "-up");
        bsMenu.over = skMenu.getDrawable(sName + "-over");
        bsMenu.down = skMenu.getDrawable(sName + "-down");
        setStyle(bsMenu);
    }
}
