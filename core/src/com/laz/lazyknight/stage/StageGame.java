package com.laz.lazyknight.stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.laz.lazyknight.actor.Knight;
import com.laz.lazyknight.actor.Projectile;
import com.laz.lazyknight.control.ButtonAttack;
import com.laz.lazyknight.control.ButtonDPad;
import com.laz.lazyknight.control.ButtonJump;
import com.laz.lazyknight.control.ButtonMagic;
import com.laz.lazyknight.map.MapMain;
import com.laz.lazyknight.util.Constants;

//https://github.com/wmora/martianrun/blob/master/core/src/com/gamestudio24/martianrun/stages/GameStage.java

public class StageGame extends Stage {

    OrthographicCamera camera;
    MapMain mapMain;
    ButtonAttack btnAttack;
    ButtonJump btnJump;
    ButtonMagic btnMagic;
    ButtonDPad btnUp, btnDown, btnLeft, btnRight;
    Image imgDpadOutline;
    Knight knight;
    Projectile projectile;

    public StageGame() {
        super(new ScalingViewport(Scaling.stretch, Constants.APP_WIDTH, Constants.APP_HEIGHT, new OrthographicCamera(Constants.APP_WIDTH, Constants.APP_HEIGHT)));

        initCamera();
        initMap();
        initKnight();
        initProjectile();
        initDpad();
        initButtons();

        Gdx.input.setInputProcessor(this);
    }

    public void initCamera() {
        camera = new OrthographicCamera(Constants.APP_WIDTH, Constants.APP_HEIGHT);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0f);
    }

    public void initMap() {
        mapMain = new MapMain(camera);
    }

    public void initKnight() {
        knight = new Knight(Constants.APP_WIDTH / 2 - 90, Constants.APP_HEIGHT / 2 - 150, 90, 90, camera, mapMain);
        addActor(knight);
    }

    public void initProjectile() {
        projectile = new Projectile(Constants.APP_WIDTH / 2 - 90, Constants.APP_HEIGHT / 2 - 150, 75, 50);
        addActor(projectile);
    }

    public void initDpad() {
        imgDpadOutline = new Image(new TextureAtlas("dpad.atlas").findRegion("outline"));
        imgDpadOutline.setPosition(15, 15);
        addActor(imgDpadOutline);

        btnUp = new ButtonDPad(55, 100, 75, 75, "dpad.atlas", "up", knight);
        addActor(btnUp);

        btnDown = new ButtonDPad(55, 0, 75, 75, "dpad.atlas", "down", knight);
        addActor(btnDown);

        btnLeft = new ButtonDPad(0, 50, 75, 75, "dpad.atlas", "left", knight);
        addActor(btnLeft);

        btnRight = new ButtonDPad(105, 50, 75, 75, "dpad.atlas", "right", knight);
        addActor(btnRight);
    }

    public void initButtons() {
        btnAttack = new ButtonAttack(Constants.APP_WIDTH - 185, 25, 80, 80, "buttons.atlas", "attack");
        addActor(btnAttack);

        btnJump = new ButtonJump(Constants.APP_WIDTH - 185, 115, 80, 80, "buttons.atlas", "jump", knight);
        addActor(btnJump);

        btnMagic = new ButtonMagic(Constants.APP_WIDTH - 100, 75, 80, 80, "buttons.atlas", "magic", knight, projectile);
        addActor(btnMagic);
    }

    public void update() {
        camera.update();
        mapMain.update();
    }
}