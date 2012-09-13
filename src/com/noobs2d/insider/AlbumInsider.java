package com.noobs2d.insider;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;

public class AlbumInsider extends Game {

    @Override
    public void create() {
	Gdx.input.setCatchBackKey(true);
	Assets.load();
	if (!Settings.DEBUG_MODE) {
	    Settings.load();
	    setScreen(new SplashScreen(this));
	    Assets.bgm.play();
	    Assets.bgm.setLooping(true);
	} else
	    Settings.nextStage(this);
    }

    @Override
    public void pause() {
	if (Assets.bgm != null && Assets.bgm.isPlaying())
	    Assets.bgm.pause();
    }

    @Override
    public void render() {
	Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
	super.render();
    }

    @Override
    public void resume() {
	if (Assets.bgm != null && !Assets.bgm.isPlaying())
	    Assets.bgm.play();
    }

}
