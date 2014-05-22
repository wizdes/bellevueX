/*
 * Copyright (C) 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.bellevuex.hearts;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.camera.hud.HUD;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.ui.activity.BaseGameActivity;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.entity.Entity;

public class HeartsActivity extends BaseGameActivity {
    private BitmapTextureAtlas cardTexture;
    private ITextureRegion cardTextureRegion;
    private Sprite c;

    public static final int CELLS_HORIZONTAL = 16;
    public static final int CELLS_VERTICAL = 12;

    public static final int CELL_WIDTH = 32;
    public static final int CELL_HEIGHT = CELL_WIDTH;

    private static final int CAMERA_WIDTH = CELLS_HORIZONTAL * CELL_WIDTH; // 640
    private static final int CAMERA_HEIGHT = CELLS_VERTICAL * CELL_HEIGHT; // 480

    // Scene Layers
    private static final int LAYER_COUNT = 2;

    private static final int LAYER_BACKGROUND = 0;
    private static final int LAYER_TABLE = LAYER_BACKGROUND + 1;

    @Override
    public EngineOptions onCreateEngineOptions() {
        EngineOptions eo = new EngineOptions(true, ScreenOrientation.LANDSCAPE_FIXED, new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT));
        eo.getAudioOptions().setNeedsSound(true);
        return eo;
    }

    @Override
    public void onCreateResources(OnCreateResourcesCallback onCreateResourcesCallback) throws Exception {
        loadGraphics();
        loadFonts();
        loadSounds();
        createControllers();
        onCreateResourcesCallback.onCreateResourcesFinished();
    }

    private void loadGraphics()
    {
        cardTexture = new BitmapTextureAtlas(getTextureManager(), 142, 198, TextureOptions.DEFAULT);
        cardTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(cardTexture, this, "image.png", 0, 0);
        cardTexture.load();
    }

    private void loadFonts()
    {

    }

    private void loadSounds()
    {

    }

    @Override
    public void onCreateScene(OnCreateSceneCallback onCreateSceneCallback) throws Exception {
        Scene scene = new Scene();
        scene.setBackground(new Background(0.09804f, 0.6274f, 0.8784f));

        for(int i = 0; i < LAYER_COUNT; i++) {
            scene.attachChild(new Entity());
        }

        c = new Sprite(100.0f,100.0f, cardTextureRegion, getVertexBufferObjectManager());
        scene.getChildByIndex(LAYER_TABLE).attachChild(c);
        c.setRotation(90);
        onCreateSceneCallback.onCreateSceneFinished(scene);
    }

    @Override
    public void onPopulateScene(Scene scene, OnPopulateSceneCallback onPopulateSceneCallback) throws Exception {

        onPopulateSceneCallback.onPopulateSceneFinished();
    }

    private void createControllers()
    {
        HUD yourHud = new HUD();

        final Rectangle left = new Rectangle(20, 0, 60, 60, getVertexBufferObjectManager())
        {
            public boolean onAreaTouched(TouchEvent touchEvent, float X, float Y)
            {
                if (touchEvent.isActionUp())
                {
                    c.setPosition(200, 100);
                    c.setRotation(90);
                }
                return true;
            };
        };

        final Rectangle right = new Rectangle(100, 0, 60, 60, getVertexBufferObjectManager())
        {
            public boolean onAreaTouched(TouchEvent touchEvent, float X, float Y)
            {
                if (touchEvent.isActionUp())
                {
                    c.setPosition(100, 100);
                    c.setRotation(-90);
                }
                return true;
            };
        };

        yourHud.registerTouchArea(left);
        yourHud.registerTouchArea(right);
        yourHud.attachChild(left);
        yourHud.attachChild(right);

        getEngine().getCamera().setHUD(yourHud);
    }
}