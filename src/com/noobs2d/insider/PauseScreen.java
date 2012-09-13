package com.noobs2d.insider;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.noobs2d.tweenengine.utils.DynamicScreen;
import com.noobs2d.tweenengine.utils.DynamicText;

public class PauseScreen extends DynamicScreen {

    DynamicText text;
    DynamicText guide;
    LevelScreen previousScreen;

    public PauseScreen(Game game, LevelScreen previousScreen) {
	super(game, Settings.WIDTH, Settings.HEIGHT);
	text = new DynamicText(new BitmapFont(Gdx.files.internal("data/fonts/TRAJANPRO42.fnt"), new TextureRegion(Assets.trajanPro42), false), "PAUSED");
	text.position.set(Settings.WIDTH / 2, Settings.HEIGHT / 2);
	String g = "PRESS MENU TO RETURN TO MAIN MENU\nPRESS BACK TO RESUME";
	guide = new DynamicText(new BitmapFont(Gdx.files.internal("data/fonts/VERDANA24.fnt"), new TextureRegion(Assets.verdana24), false), g);
	guide.position.set(Settings.WIDTH / 2, 120);
	this.previousScreen = previousScreen;
	previousScreen.paused = true;
    }

    @Override
    public boolean keyUp(int keycode) {
	if (keycode == Keys.BACK || keycode == Keys.BACKSPACE) {
	    game.setScreen(previousScreen);
	    previousScreen.paused = false;
	} else if (keycode == Keys.MENU || keycode == Keys.ALT_LEFT)
	    game.setScreen(new MenuScreen(game));
	return false;
    }

    @Override
    public void render(float deltaTime) {
	spriteBatch.begin();
	text.render(spriteBatch);
	guide.render(spriteBatch);
	spriteBatch.end();
    }

    @Override
    public boolean touchDown(int x, int y, int pointer, int button) {
	if (pointer >= 2)
	    game.setScreen(new MenuScreen(game));
	return false;
    }
}
