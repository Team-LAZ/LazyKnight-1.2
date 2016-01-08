package com.laz.lazyknight.control;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.laz.lazyknight.actor.Knight;
import com.laz.lazyknight.actor.Projectile;
import com.laz.lazyknight.util.UserData;

public class ButtonMagic extends ButtonGame {

    public ButtonMagic(float fX, float fY, float fWidth, float fHeight, String sAtlas, String sName, final Knight knight, final Projectile projectile) {
        super(fX, fY, fWidth, fHeight, sAtlas, sName);
        this.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float fX, float fY) {
                if (!projectile.isAlive && UserData.fMana > 0) {
                    projectile.fDir = knight.fDir;
                    projectile.fY = knight.fY;
                    projectile.isAlive = true;
                    UserData.fMana -= 22.625;
                }
            }
        });
    }
}