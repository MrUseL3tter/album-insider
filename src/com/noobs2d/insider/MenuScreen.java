package com.noobs2d.insider;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.equations.Linear;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.noobs2d.tweenengine.utils.DynamicScreen;
import com.noobs2d.tweenengine.utils.DynamicSprite;

public class MenuScreen extends DynamicScreen {

    DynamicSprite background;
    DynamicSprite play;
    DynamicSprite instructions;
    DynamicSprite highscores;
    DynamicSprite exit;

    public MenuScreen(Game game) {
	super(game, Settings.WIDTH, Settings.HEIGHT);
	background = new DynamicSprite(new TextureRegion(Assets.mainMenu, 0, 0, 800, 480), 400, 240);
	play = new DynamicSprite(new TextureRegion(Assets.mainMenu, 800, 0, 150, 37), 109, 220);
	instructions = new DynamicSprite(new TextureRegion(Assets.mainMenu, 800, 37, 150, 37), 152, 162);
	highscores = new DynamicSprite(new TextureRegion(Assets.mainMenu, 800, 185, 150, 37), 200, 106);
	exit = new DynamicSprite(new TextureRegion(Assets.mainMenu, 800, 111, 150, 37), 259, 52);
    }

    @Override
    public void render(float deltaTime) {
	super.render(deltaTime);
	spriteBatch.begin();
	background.render(spriteBatch);
	play.render(spriteBatch);
	instructions.render(spriteBatch);
	highscores.render(spriteBatch);
	exit.render(spriteBatch);
	spriteBatch.end();
	background.update(deltaTime);
	play.update(deltaTime);
	instructions.update(deltaTime);
	highscores.update(deltaTime);
	exit.update(deltaTime);
    }

    @Override
    public void show() {
	background.color.a = 0f;
	background.interpolateAlpha(1f, Linear.INOUT, 750, true);
	play.color.a = 0f;
	play.interpolateAlpha(1f, Linear.INOUT, 750, true);
	highscores.color.a = 0f;
	highscores.interpolateAlpha(1f, Linear.INOUT, 750, true);
	instructions.color.a = 0f;
	instructions.interpolateAlpha(1f, Linear.INOUT, 750, true);
	exit.color.a = 0f;
	exit.interpolateAlpha(1f, Linear.INOUT, 750, true);
    }

    @Override
    public boolean touchUp(int x, int y, int pointer, int button) {
	x *= (float) Settings.WIDTH / Gdx.graphics.getWidth();
	float scale = (float) Settings.HEIGHT / Gdx.graphics.getHeight();
	y = Gdx.graphics.getHeight() - y;
	y *= scale;
	if (pointer == 0)
	    if (play.getBounds().contains(x, y)) {
		Assets.start.play();
		fadeExit(new TweenCallback() {

		    @Override
		    public void onEvent(int type, BaseTween<?> source) {
			if (type == TweenCallback.COMPLETE)
			    if (Settings.currentStage != 0)
				game.setScreen(new StartPrompt(game));
			    else
				Settings.nextStage(game);
		    }
		}, 5000);
	    } else if (instructions.getBounds().contains(x, y))
		fadeExit(new TweenCallback() {

		    @Override
		    public void onEvent(int type, BaseTween<?> source) {
			if (type == TweenCallback.COMPLETE)
			    game.setScreen(new InstructionScreen(game));
		    }
		}, 500);
	    else if (highscores.getBounds().contains(x, y))
		fadeExit(new TweenCallback() {

		    @Override
		    public void onEvent(int type, BaseTween<?> source) {
			if (type == TweenCallback.COMPLETE)
			    game.setScreen(new HighscoresScreen(game));
		    }
		}, 500);
	    else if (exit.getBounds().contains(x, y))
		fadeExit(new TweenCallback() {

		    @Override
		    public void onEvent(int type, BaseTween<?> source) {
			if (type == TweenCallback.COMPLETE) {
			    Assets.dispose();
			    System.exit(0);
			    Settings.save();
			}
		    }
		}, 500);
	return false;
    }

    private void fadeExit(TweenCallback callback, int duration) {
	background.interpolateAlpha(0f, Linear.INOUT, duration, true);
	play.interpolateAlpha(0f, Linear.INOUT, duration, true);
	instructions.interpolateAlpha(0f, Linear.INOUT, duration, true);
	highscores.interpolateAlpha(0f, Linear.INOUT, duration, true);
	exit.interpolateAlpha(0f, Linear.INOUT, duration, true).setCallback(callback);
    }
}
