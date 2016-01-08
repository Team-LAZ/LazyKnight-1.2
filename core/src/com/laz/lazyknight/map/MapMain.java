package com.laz.lazyknight.map;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class MapMain {

    TiledMap tmTown;
    TiledMapRenderer tmrTown;
    TiledMapTileLayer tmtlPortal;
    OrthographicCamera camera;

    public MapMain(OrthographicCamera camera) {
        this.camera = camera;

        tmTown = new TmxMapLoader().load("maptown.tmx");

        tmrTown = new OrthogonalTiledMapRenderer(tmTown);

        tmtlPortal = (TiledMapTileLayer) tmTown.getLayers().get("Portal");
    }

    public void update() {
        tmrTown.setView(camera);
        tmrTown.render();
    }
}