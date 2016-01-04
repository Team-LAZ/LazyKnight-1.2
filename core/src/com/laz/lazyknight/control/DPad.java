package com.laz.lazyknight.control;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

//TODO possibly move dpad and buttons into one class as most code is shared
public class DPad extends Button {

    public static Image imgOutline;
    TextureAtlas taDPad;
    Skin skDPad;
    ButtonStyle bsDPad;

    public DPad(String sID, float fX, float fY) {
        setBounds(fX, fY, 75, 75); //x, y, width, height of directional arrows

        taDPad = new TextureAtlas("dpad.atlas");

        skDPad = new Skin();
        skDPad.addRegions(taDPad);

        bsDPad = new Button.ButtonStyle();
        bsDPad.up = skDPad.getDrawable(sID);
        setStyle(bsDPad);

        imgOutline = new Image(taDPad.findRegion("outline")); //border around dpad
        imgOutline.setPosition(15, 15);
    }
}