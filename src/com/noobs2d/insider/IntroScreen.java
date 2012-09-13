package com.noobs2d.insider;

import aurelienribon.tweenengine.equations.Linear;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.noobs2d.tweenengine.utils.DynamicScreen;
import com.noobs2d.tweenengine.utils.DynamicSprite;

public class IntroScreen extends DynamicScreen {

    DynamicSprite screen1;
    DynamicSprite screen2;

    int index = 0;

    public IntroScreen(Game game) {
	super(game, Settings.WIDTH, Settings.HEIGHT);
	screen1 = new DynamicSprite(new TextureRegion(Assets.intro, 0, 0, 800, 480), Settings.WIDTH / 2, Settings.HEIGHT / 2);
	screen1.color.a = 0f;
	screen1.interpolateAlpha(1f, Linear.INOUT, 250, true);
	screen2 = new DynamicSprite(new TextureRegion(Assets.intro, 0, 480, 800, 480), Settings.WIDTH / 2, Settings.HEIGHT / 2);
	screen2.color.a = 0f;
    }

    @Override
    public void render(float deltaTime) {
	spriteBatch.begin();
	screen1.render(spriteBatch);
	screen2.render(spriteBatch);
	screen1.update(deltaTime);
	screen2.update(deltaTime);
	spriteBatch.end();
    }

    @Override
    public boolean touchUp(int x, int y, int pointer, int button) {
	index++;

	if (index == 2) {
	    Settings.currentStage++;
	    Settings.nextStage(game);
	} else if (index == 1) {
	    screen1.interpolateAlpha(0f, Linear.INOUT, 250, true);
	    screen2.interpolateAlpha(1f, Linear.INOUT, 250, true).delay(250);
	}
	return false;
    }

}
