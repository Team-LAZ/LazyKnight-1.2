package com.laz.lazyknight.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.laz.lazyknight.LazyKnight;
import com.laz.lazyknight.stage.StageMainMenu;

public class ScreenMainMenu implements Screen {

    LazyKnight game;
    StageMainMenu stage;

    public ScreenMainMenu(LazyKnight game) {
        this.game = game;

        stage = new StageMainMenu(game);
    }

    @Override
    public void render(float fDelta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glClearColor(1f, 1f, 1f, 1f);

        stage.draw();
        stage.act(fDelta);
    }


    @Override
    public void show() {

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
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
