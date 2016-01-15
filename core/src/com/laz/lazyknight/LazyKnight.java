package com.laz.lazyknight;

import com.badlogic.gdx.Game;
import com.laz.lazyknight.screen.ScreenMainMenu;

public class LazyKnight extends Game {

    @Override
    public void create() {
        setScreen(new ScreenMainMenu(this));
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