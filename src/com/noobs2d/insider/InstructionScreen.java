package com.noobs2d.insider;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.equations.Linear;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.noobs2d.tweenengine.utils.DynamicScreen;
import com.noobs2d.tweenengine.utils.DynamicSprite;

public class InstructionScreen extends DynamicScreen {

    DynamicSprite background;
    DynamicSprite back;

    public InstructionScreen(Game game) {
	super(game, Settings.WIDTH, Settings.HEIGHT);
	background = new DynamicSprite(new TextureRegion(Assets.instruction, 0, 0, 800, 480), Settings.WIDTH / 2, Settings.HEIGHT / 2);
	background.color.a = 0f;
	background.interpolateAlpha(1f, Linear.INOUT, 500, true);
	back = new DynamicSprite(new TextureRegion(Assets.mainMenu, 800, 222, 150, 37), 85, 42);
	back.color.a = 0f;
	back.interpolateAlpha(1f, Linear.INOUT, 500, true);
    }

    @Override
    public void render(float deltaTime) {
	spriteBatch.begin();
	background.render(spriteBatch);
	background.update(deltaTime);
	back.render(spriteBatch);
	back.update(deltaTime);
	spriteBatch.end();
    }

    @Override
    public boolean touchUp(int x, int y, int pointer, int button) {
	x *= (float) Settings.WIDTH / Gdx.graphics.getWidth();
	float scale = (float) Settings.HEIGHT / Gdx.graphics.getHeight();
	y = Gdx.graphics.getHeight() - y;
	y *= scale;
	if (back.getBounds().contains(x, y)) {
	    background.interpolateAlpha(0f, Linear.INOUT, 500, true);
	    back.interpolateAlpha(0f, Linear.INOUT, 500, true).setCallback(new TweenCallback() {

		@Override
		public void onEvent(int type, BaseTween<?> source) {
		    if (type == TweenCallback.COMPLETE)
			game.setScreen(new MenuScreen(game));
		}
	    });
	}
	return false;
    }

}
