package com.laz.lazyknight.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.laz.lazyknight.stage.GameStage;
import com.laz.lazyknight.stage.HUDStage;

//https://github.com/wmora/martianrun/blob/master/core/src/com/gamestudio24/martianrun/screens/GameScreen.java

public class GameScreen implements Screen {

    GameStage stage;
    HUDStage hud;

    public GameScreen() {
        stage = new GameStage();
        hud = new HUDStage();
    }

    @Override
    public void render(float fDelta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.updateMap();
        stage.draw();
        stage.act(fDelta);

        hud.updateHUD();
        hud.draw();
        hud.act(fDelta);
    }

    @Override
    public void resize(int nWidth, int nHeight) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}