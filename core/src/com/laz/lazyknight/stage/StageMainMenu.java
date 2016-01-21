package com.laz.lazyknight.stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.laz.lazyknight.LazyKnight;
import com.laz.lazyknight.control.menu.ButtonOptions;
import com.laz.lazyknight.control.menu.ButtonPlay;
import com.laz.lazyknight.util.Constants;

public class StageMainMenu extends Stage {

    LazyKnight game;

    OrthographicCamera camera;
    ButtonPlay btnPlay;
    ButtonOptions btnOptions;

    public StageMainMenu(LazyKnight game) {
        super(new ScalingViewport(Scaling.stretch, Constants.APP_WIDTH, Constants.APP_HEIGHT, new OrthographicCamera(Constants.APP_WIDTH, Constants.APP_HEIGHT)));

        this.game = game;

        initCamera();
        initButtons();

        Gdx.input.setInputProcessor(this);
    }

    public void initCamera() {
        camera = new OrthographicCamera(Constants.APP_WIDTH, Constants.APP_HEIGHT);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0f);
    }

    public void initButtons() {
        btnPlay = new ButtonPlay((Constants.APP_WIDTH / 2 - Constants.APP_WIDTH / 6) - 32.5f, Constants.APP_HEIGHT / 4, 65, 64, "play", game);
        addActor(btnPlay);

        btnOptions = new ButtonOptions((Constants.APP_WIDTH / 2 + Constants.APP_WIDTH / 6) - 32.5f, Constants.APP_HEIGHT / 4, 65, 64, "options", game);
        addActor(btnOptions);

        //customize = new CustomizeButton((Constants.APP_WIDTH / 2) - 32.5f, Constants.APP_HEIGHT / 4, 65, 64, "customize", game);
        //addActor(customize);
    }
}
