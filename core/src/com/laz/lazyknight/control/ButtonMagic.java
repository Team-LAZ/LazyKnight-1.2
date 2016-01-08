package com.laz.lazyknight.control;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.laz.lazyknight.actor.ActorKnight;
import com.laz.lazyknight.actor.ActorProjectile;
import com.laz.lazyknight.util.UserData;

public class ButtonMagic extends ButtonGame {

    public ButtonMagic(float fX, float fY, float fWidth, float fHeight, String sAtlas, String sName, final ActorKnight actKnight, final ActorProjectile actProjectile) {
        super(fX, fY, fWidth, fHeight, sAtlas, sName);
        this.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float fX, float fY) {
                if (!actProjectile.isAlive && UserData.fMana > 0) {
                    actProjectile.fDir = actKnight.fDir;
                    actProjectile.fY = actKnight.fY;
                    actProjectile.isAlive = true;
                    UserData.fMana -= 22.625;
                }
            }
        });
    }
}