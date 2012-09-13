package com.noobs2d.insider;

import java.util.ArrayList;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.equations.Expo;
import aurelienribon.tweenengine.equations.Linear;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.noobs2d.tweenengine.utils.DynamicScreen;
import com.noobs2d.tweenengine.utils.DynamicSprite;

public abstract class PuzzleStage extends DynamicScreen {

    ArrayList<DynamicSprite> pieces = new ArrayList<DynamicSprite>();
    ArrayList<Rectangle> bounds = new ArrayList<Rectangle>();

    DynamicSprite puzzle;
    DynamicSprite whole;
    DynamicSprite dragElement;
    DynamicSprite conclusion;

    boolean[] placed = new boolean[] { false, false, false, false };

    boolean solved = false;

    public PuzzleStage(Game game) {
	super(game, Settings.WIDTH, Settings.HEIGHT);
	initComponents();
    }

    @Override
    public boolean mouseMoved(int x, int y) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public void render(float deltaTime) {
	spriteBatch.begin();

	for (int i = 0; i < pieces.size(); i++)
	    pieces.get(i).render(spriteBatch);

	puzzle.render(spriteBatch);
	whole.render(spriteBatch);
	conclusion.render(spriteBatch);

	for (int i = 0; i < pieces.size(); i++)
	    pieces.get(i).update(deltaTime);

	puzzle.update(deltaTime);
	whole.update(deltaTime);
	conclusion.update(deltaTime);

	spriteBatch.end();
    }

    @Override
    public boolean touchDown(int x, int y, int pointer, int button) {
	x *= (float) Settings.WIDTH / Gdx.graphics.getWidth();
	float scale = (float) Settings.HEIGHT / Gdx.graphics.getHeight();
	y = Gdx.graphics.getHeight() - y;
	y *= scale;
	if (pointer == 0)
	    for (int i = 0; i < pieces.size(); i++)
		if (pieces.get(i).getBounds().contains(x, y))
		    dragElement = pieces.get(i);

	if (solved)
	    onNext();
	return false;
    }

    @Override
    public boolean touchDragged(int x, int y, int pointer) {
	x *= (float) Settings.WIDTH / Gdx.graphics.getWidth();
	float scale = (float) Settings.HEIGHT / Gdx.graphics.getHeight();
	y = Gdx.graphics.getHeight() - y;
	y *= scale;
	if (pointer == 0)
	    for (int i = 0; i < pieces.size(); i++)
		if (!placed[i] && dragElement != null && dragElement.equals(pieces.get(i)) && pieces.get(i).getBounds().contains(x, y)) {
		    pieces.get(i).position.x += x - pieces.get(i).position.x;
		    pieces.get(i).position.y += y - pieces.get(i).position.y;
		} else if (!placed[i] && dragElement != null && dragElement.equals(pieces.get(i)) && pieces.get(i).getBounds().contains(x, y)) {
		    pieces.get(i).position.x += x - pieces.get(i).position.x;
		    pieces.get(i).position.y += y - pieces.get(i).position.y;
		} else if (!placed[i] && dragElement != null && dragElement.equals(pieces.get(i)) && pieces.get(i).getBounds().contains(x, y)) {
		    pieces.get(i).position.x += x - pieces.get(i).position.x;
		    pieces.get(i).position.y += y - pieces.get(i).position.y;
		} else if (!placed[i] && dragElement != null && dragElement.equals(pieces.get(i)) && pieces.get(i).getBounds().contains(x, y)) {
		    pieces.get(i).position.x += x - pieces.get(i).position.x;
		    pieces.get(i).position.y += y - pieces.get(i).position.y;
		}
	return false;
    }

    @Override
    public boolean touchUp(int x, int y, int pointer, int button) {
	x *= (float) Settings.WIDTH / Gdx.graphics.getWidth();
	dragElement = null;
	float scale = (float) Settings.HEIGHT / Gdx.graphics.getHeight();
	y = Gdx.graphics.getHeight() - y;
	y *= scale;
	if (pointer == 0)
	    for (int i = 0; i < pieces.size(); i++)
		if (!solved && bounds.get(i).overlaps(pieces.get(i).getBounds()) && pieces.get(i).getBounds().contains(x, y)) {
		    System.out.println(i);
		    placed[i] = true;
		    pieces.get(i).position.set(bounds.get(i).x + bounds.get(i).width / 2, bounds.get(i).y + bounds.get(i).height / 2);
		    Assets.correct.play();
		}

	boolean allSolved = true;
	for (int i = 0; i < placed.length; i++)
	    allSolved &= placed[i];
	if (!solved && placed[0] && allSolved) {
	    whole.visible = true;
	    whole.color.a = 0f;
	    whole.interpolateScaleXY(new Vector2(1.3f, 1.3f), Expo.OUT, 3000, true).delay(1550);
	    whole.interpolateAlpha(1f, Linear.INOUT, 3000, true).delay(1550).setCallback(new TweenCallback() {

		@Override
		public void onEvent(int type, BaseTween<?> source) {
		    if (type == TweenCallback.COMPLETE) {
			Assets.start.play();
			solved = true;
			onPuzzleSolved();
		    }

		}
	    });
	}
	return false;
    }

    protected abstract void initComponents();

    protected void onNext() {
	Assets.over.play();
	Settings.currentStage = 0;
	Settings.sortHighscores();
	Settings.save();
	puzzle.interpolateAlpha(0f, Linear.INOUT, 250, true);
	for (int i = 0; i < pieces.size(); i++)
	    pieces.get(i).interpolateAlpha(0f, Linear.INOUT, 250, true);
	whole.interpolateAlpha(0f, Linear.INOUT, 250, true);
	conclusion.interpolateAlpha(0f, Linear.INOUT, 250, true).setCallback(new TweenCallback() {

	    @Override
	    public void onEvent(int type, BaseTween<?> source) {
		if (type == TweenCallback.COMPLETE)
		    game.setScreen(new MenuScreen(game));

	    }
	});
    }

    protected void onPuzzleSolved() {
	conclusion.interpolateAlpha(1f, Linear.INOUT, 500, true).delay(2000);
    }

}
