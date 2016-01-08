package com.laz.lazyknight;

import com.badlogic.gdx.Game;
import com.laz.lazyknight.screen.ScreenGame;

public class LazyKnight extends Game {

    @Override
    public void create() {
        setScreen(new ScreenGame());
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}