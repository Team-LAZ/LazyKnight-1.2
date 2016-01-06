package com.laz.lazyknight.stage;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.laz.lazyknight.knight.KnightData;
import com.laz.lazyknight.util.Constants;

public class HUDStage extends Stage {

    OrthographicCamera camera;
    Image imgHPOutline, imgManaOutline, imgHP, imgMana;
    Label lblXP, lblXPAmt, lblArmor, lblAttack, lblMagic;

    public HUDStage() {
        super(new ScalingViewport(Scaling.stretch, Constants.APP_WIDTH, Constants.APP_HEIGHT, new OrthographicCamera(Constants.APP_WIDTH, Constants.APP_HEIGHT)));

        initCamera();
        initBars();
        initLabels();
    }

    public void initCamera() {
        camera = new OrthographicCamera(Constants.APP_WIDTH, Constants.APP_HEIGHT);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0f);
    }

    public void initBars() {
        imgHPOutline = new Image(new Texture("baroutline.png"));
        imgHPOutline.setPosition(10, Constants.APP_HEIGHT - 32);

        imgManaOutline = new Image(new Texture("baroutline.png"));
        imgManaOutline.setPosition(Constants.APP_WIDTH / 2 - 150, Constants.APP_HEIGHT - 32);

        imgHP = new Image(new Texture("healthbar.png"));
        imgHP.setPosition(imgHPOutline.getX() + 3, imgHPOutline.getY() + 3);

        imgMana = new Image(new Texture("manabar.png"));
        imgMana.setPosition(imgManaOutline.getX() + 3, imgManaOutline.getY() + 3);

        addActor(imgHPOutline);
        addActor(imgManaOutline);
        addActor(imgHP);
        addActor(imgMana);
    }

    public void initLabels() {
        lblXP = new Label("XP:", new LabelStyle(new BitmapFont(), Color.YELLOW));
        lblXP.setPosition(Constants.APP_WIDTH - 75, Constants.APP_HEIGHT - 25);

        lblXPAmt = new Label(KnightData.nXP + " / " + KnightData.nNextLevel, new LabelStyle(new BitmapFont(), Color.WHITE));
        lblXPAmt.setPosition(Constants.APP_WIDTH - 95 + String.valueOf(KnightData.nXP).length() + String.valueOf(KnightData.nNextLevel).length(), Constants.APP_HEIGHT - 50);

        lblArmor = new Label("ARMOR: Level " + KnightData.nLVLArmor, new LabelStyle(new BitmapFont(), Color.WHITE));
        lblArmor.setPosition(50, Constants.APP_HEIGHT - 50);

        lblAttack = new Label("ATTACK: Level " + KnightData.nLVLAttack, new LabelStyle(new BitmapFont(), Color.WHITE));
        lblAttack.setPosition(Constants.APP_WIDTH / 2 + 125, Constants.APP_HEIGHT - 50);

        lblMagic = new Label("MAGIC: Level " + KnightData.nLVLMagic, new LabelStyle(new BitmapFont(), Color.WHITE));
        lblMagic.setPosition(Constants.APP_WIDTH / 2 - 100, Constants.APP_HEIGHT - 50);

        addActor(lblXP);
        addActor(lblXPAmt);
        addActor(lblArmor);
        addActor(lblAttack);
        addActor(lblMagic);
    }

    public void updateHUD() {
        imgHP.setWidth(KnightData.fHP);
        imgMana.setWidth(KnightData.fMana);
    }
}
