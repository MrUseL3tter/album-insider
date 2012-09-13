package com.noobs2d.insider;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.noobs2d.tweenengine.utils.DynamicDisplay.DynamicRegistration;
import com.noobs2d.tweenengine.utils.DynamicSprite;
import com.noobs2d.tweenengine.utils.DynamicText;

public class Riddle {

    DynamicText clue;
    DynamicSprite object;

    boolean visible = false;

    public Riddle(String clue, TextureRegion object, float objectX, float objectY) {
	this.clue = new DynamicText(new BitmapFont(Gdx.files.internal("data/fonts/VERDANA24.fnt"), new TextureRegion(Assets.verdana24), false), clue);
	this.clue.setRegistration(DynamicRegistration.BOTTOM_CENTER);
	this.clue.position.set(Settings.WIDTH / 2, 10);
	this.clue.wrapWidth = Settings.WIDTH;
	this.object = new DynamicSprite(object, objectX, objectY);
    }

    public void render(SpriteBatch spriteBatch) {
	if (visible) {
	    clue.render(spriteBatch);
	    object.render(spriteBatch);
	}
    }

    public void update(float deltaTime) {
	clue.update(deltaTime);
	object.update(deltaTime);

    }
}
