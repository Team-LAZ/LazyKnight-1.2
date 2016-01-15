package com.laz.lazyknight.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.laz.lazyknight.LazyKnight;
import com.laz.lazyknight.stage.StageMainMenu;

public class ScreenMainMenu implements Screen {

    StageMainMenu stage;
    LazyKnight game;

    public ScreenMainMenu(LazyKnight game) {
        this.game = game;

        stage = new StageMainMenu();
    }

    @Override
    public void render(float fDelta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.draw();
        stage.act(fDelta);

        if (Gdx.input.isTouched()) {
            game.setScreen(new ScreenGame());
        }
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
