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
import com.laz.lazyknight.util.Constants;
import com.laz.lazyknight.util.UserData;

public class StageHUD extends Stage {

    OrthographicCamera camera;
    Image imgHPOutline, imgManaOutline, imgHP, imgMana;
    Label lblXP, lblXPAmt, lblArmor, lblAttack, lblMagic;

    public StageHUD() {
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
        addActor(imgHPOutline);

        imgManaOutline = new Image(new Texture("baroutline.png"));
        imgManaOutline.setPosition(Constants.APP_WIDTH / 2 - 150, Constants.APP_HEIGHT - 32);
        addActor(imgManaOutline);

        imgHP = new Image(new Texture("healthbar.png"));
        imgHP.setPosition(imgHPOutline.getX() + 3, imgHPOutline.getY() + 3);
        addActor(imgHP);

        imgMana = new Image(new Texture("manabar.png"));
        imgMana.setPosition(imgManaOutline.getX() + 3, imgManaOutline.getY() + 3);
        addActor(imgMana);
    }

    public void initLabels() {
        lblXP = new Label("XP:", new LabelStyle(new BitmapFont(), Color.YELLOW));
        lblXP.setPosition(Constants.APP_WIDTH - 75, Constants.APP_HEIGHT - 25);
        addActor(lblXP);

        lblXPAmt = new Label(UserData.nXP + " / " + UserData.nNextLevel, new LabelStyle(new BitmapFont(), Color.WHITE));
        lblXPAmt.setPosition(Constants.APP_WIDTH - 95 + String.valueOf(UserData.nXP).length() + String.valueOf(UserData.nNextLevel).length(), Constants.APP_HEIGHT - 50);
        addActor(lblXPAmt);

        lblArmor = new Label("ARMOR: Level " + UserData.nLVLArmor, new LabelStyle(new BitmapFont(), Color.WHITE));
        lblArmor.setPosition(50, Constants.APP_HEIGHT - 50);
        addActor(lblArmor);

        lblAttack = new Label("ATTACK: Level " + UserData.nLVLAttack, new LabelStyle(new BitmapFont(), Color.WHITE));
        lblAttack.setPosition(Constants.APP_WIDTH / 2 + 125, Constants.APP_HEIGHT - 50);
        addActor(lblAttack);

        lblMagic = new Label("MAGIC: Level " + UserData.nLVLMagic, new LabelStyle(new BitmapFont(), Color.WHITE));
        lblMagic.setPosition(Constants.APP_WIDTH / 2 - 100, Constants.APP_HEIGHT - 50);
        addActor(lblMagic);
    }

    public void update() {
        imgHP.setWidth(UserData.fHP);
        imgMana.setWidth(UserData.fMana);
    }
}
