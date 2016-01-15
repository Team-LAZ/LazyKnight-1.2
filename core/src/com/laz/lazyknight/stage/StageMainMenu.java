package com.laz.lazyknight.stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.laz.lazyknight.util.Constants;

public class StageMainMenu extends Stage {

    OrthographicCamera camera;
    Label lblTitle;

    public StageMainMenu() {
        super(new ScalingViewport(Scaling.stretch, Constants.APP_WIDTH, Constants.APP_HEIGHT, new OrthographicCamera(Constants.APP_WIDTH, Constants.APP_HEIGHT)));

        initCamera();
        initLabels();

        Gdx.input.setInputProcessor(this);
    }

    public void initCamera() {
        camera = new OrthographicCamera(Constants.APP_WIDTH, Constants.APP_HEIGHT);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0f);
    }

    public void initLabels() {
        lblTitle = new Label("LAZY KNIGHT " + Constants.VERSION, new LabelStyle(new BitmapFont(), Color.WHITE));
        lblTitle.setPosition(Constants.APP_WIDTH / 2 - 50, Constants.APP_HEIGHT / 2 + 150);
        addActor(lblTitle);
    }
}
