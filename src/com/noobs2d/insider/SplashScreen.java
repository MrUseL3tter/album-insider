package com.noobs2d.insider;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.equations.Linear;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.noobs2d.tweenengine.utils.DynamicDisplay.DynamicRegistration;
import com.noobs2d.tweenengine.utils.DynamicScreen;
import com.noobs2d.tweenengine.utils.DynamicSprite;

public class SplashScreen extends DynamicScreen implements TweenCallback {

    DynamicSprite background;

    public SplashScreen(Game game) {
	super(game, Settings.WIDTH, Settings.HEIGHT);
	background = new DynamicSprite(new TextureRegion(Assets.mainMenu, 0, 0, 800, 480), 0, 0);
	background.color.a = 0f;
	background.interpolateAlpha(1f, Linear.INOUT, 1000, true);
	background.interpolateAlpha(0f, Linear.INOUT, 1000, true).delay(5000).setCallback(this);
	background.setRegistration(DynamicRegistration.BOTTOM_LEFT);
    }

    @Override
    public void onEvent(int type, BaseTween<?> source) {
	if (type == TweenCallback.COMPLETE)
	    game.setScreen(new MenuScreen(game));

    }

    @Override
    public void render(float deltaTime) {
	spriteBatch.begin();
	background.render(spriteBatch);
	background.update(deltaTime);
	spriteBatch.end();
    }

    @Override
    public boolean touchDown(int x, int y, int pointer, int button) {
	background.tweenSpeed *= 2;
	return false;
    }

}
