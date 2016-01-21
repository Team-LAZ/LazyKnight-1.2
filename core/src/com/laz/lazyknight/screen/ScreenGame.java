package com.laz.lazyknight.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.laz.lazyknight.stage.StageGame;
import com.laz.lazyknight.stage.StageHUD;

//https://github.com/wmora/martianrun/blob/master/core/src/com/gamestudio24/martianrun/screens/GameScreen.java

public class ScreenGame implements Screen {

    StageGame stage;
    StageHUD hud;

    public ScreenGame() {
        stage = new StageGame();
        hud = new StageHUD();
    }

    @Override
    public void render(float fDelta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f);

        stage.update();
        stage.draw();
        stage.act(fDelta);

        hud.update();
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