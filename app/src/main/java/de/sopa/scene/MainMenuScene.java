package de.sopa.scene;

import de.sopa.MainActivity;
import de.sopa.manager.SceneManager;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.util.color.Color;

/**
 * David Schilling - davejs92@gmail.com
 */
public class MainMenuScene extends BaseScene  {

    @Override
    public void createScene(Object o) {
        createBackground();
        createMenuChildScene();
    }

    @Override
    public void onBackKeyPressed() {
        System.exit(0);
    }

    @Override
    public SceneManager.SceneType getSceneType() {
        return SceneManager.SceneType.SCENE_MENU;
    }

    @Override
    public void disposeScene() {

    }

    private void createBackground() {
        setBackground(new Background(Color.BLACK));
    }

    private void createMenuChildScene() {
        Sprite playItemSprite = new Sprite(0, 0, resourcesManager.play_region, vbom) {
            @Override
            public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
                SceneManager.getInstance().loadGameScene(engine);
                return true;
            }
        };
        playItemSprite.setPosition(MainActivity.CAMERA_WIDTH / 2 - playItemSprite.getWidthScaled() /2, MainActivity.CAMERA_HEIGHT / 2 - playItemSprite.getHeightScaled());
        attachChild(playItemSprite);
        registerTouchArea(playItemSprite);
        Sprite levelItemSprite = new Sprite(0, 0, resourcesManager.level_mode_region, vbom){
            @Override
            public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
                SceneManager.getInstance().loadLevelChoiceScene(engine);
                return true;
            }

        };


        levelItemSprite.setPosition(MainActivity.CAMERA_WIDTH / 2 - levelItemSprite.getWidthScaled() /2, MainActivity.CAMERA_HEIGHT / 2);
        attachChild(levelItemSprite);
        registerTouchArea(levelItemSprite);
    }
}
