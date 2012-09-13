package com.noobs2d.insider;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFont.HAlignment;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.noobs2d.tweenengine.utils.DynamicDisplay.DynamicRegistration;
import com.noobs2d.tweenengine.utils.DynamicScreen;
import com.noobs2d.tweenengine.utils.DynamicText;

public class StartPrompt extends DynamicScreen {

    DynamicText cont;
    DynamicText yes;
    DynamicText no;

    public StartPrompt(Game game) {
	super(game, Settings.WIDTH, Settings.HEIGHT);
	cont = new DynamicText(new BitmapFont(Gdx.files.internal("data/fonts/TRAJANPRO42.fnt"), new TextureRegion(Assets.trajanPro42), false), "");
	cont.position.set(400, 360);
	cont.wrapWidth = 650;
	cont.scale.set(.75f, .75f);
	cont.text = "Would you like to continue your saved game?";

	yes = new DynamicText(new BitmapFont(Gdx.files.internal("data/fonts/TRAJANPRO35.fnt"), new TextureRegion(Assets.trajanPro35), false), "Yes");
	yes.color.set(Color.GREEN);
	yes.position.set(200, 120);
	yes.wrapWidth = Settings.WIDTH;
	yes.setRegistration(DynamicRegistration.LEFT_CENTER);

	no = new DynamicText(new BitmapFont(Gdx.files.internal("data/fonts/TRAJANPRO35.fnt"), new TextureRegion(Assets.trajanPro35), false), "New Game");
	no.color.set(Color.RED);
	no.position.set(650, 120);
	no.alignment = HAlignment.RIGHT;
	no.wrapWidth = Settings.WIDTH;
	no.setRegistration(DynamicRegistration.RIGHT_CENTER);
    }

    @Override
    public void render(float deltaTime) {
	spriteBatch.begin();
	cont.render(spriteBatch);
	yes.render(spriteBatch);
	no.render(spriteBatch);
	cont.update(deltaTime);
	yes.update(deltaTime);
	no.update(deltaTime);
	spriteBatch.end();
    }

    @Override
    public boolean touchUp(int x, int y, int pointer, int button) {
	x *= (float) Settings.WIDTH / Gdx.graphics.getWidth();
	float scale = (float) Settings.HEIGHT / Gdx.graphics.getHeight();
	y = Gdx.graphics.getHeight() - y;
	y *= scale;
	if (yes.getBounds().contains(x, y)) {
	    System.out.println("YES");
	    Settings.nextStage(game);
	    cont.visible = false;
	    yes.visible = false;
	    no.visible = false;
	} else if (no.getBounds().contains(x, y)) {
	    System.out.println("NO");
	    Settings.currentStage = 0;
	    Settings.currentScore = 0;
	    Settings.nextStage(game);
	    cont.visible = false;
	    yes.visible = false;
	    no.visible = false;
	}
	return false;
    }
}
