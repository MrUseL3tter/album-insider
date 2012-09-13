package com.noobs2d.insider;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.equations.Linear;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.noobs2d.tweenengine.utils.DynamicSprite;

public class PuzzleStage2 extends PuzzleStage {

    public PuzzleStage2(Game game) {
	super(game);
    }

    @Override
    protected void initComponents() {
	puzzle = new DynamicSprite(new TextureRegion(Assets.puzzle1, 729, 0, 243, 340), Settings.WIDTH / 2, Settings.HEIGHT / 2);
	DynamicSprite piece1 = new DynamicSprite(new TextureRegion(Assets.puzzle1, 608, 227, 121, 113), 120, 374);
	DynamicSprite piece2 = new DynamicSprite(new TextureRegion(Assets.puzzle1, 608, 0, 121, 114), 193, 183);
	DynamicSprite piece3 = new DynamicSprite(new TextureRegion(Assets.puzzle1, 608, 113, 121, 113), 657, 104);
	whole = new DynamicSprite(new TextureRegion(Assets.puzzle1, 486, 0, 243, 340), Settings.WIDTH / 2, Settings.HEIGHT / 2);
	whole.visible = false;
	whole.scale.set(3f, 3f);
	conclusion = new DynamicSprite(new TextureRegion(Assets.puzzle1, 0, 0, 800, 480), Settings.WIDTH / 2, Settings.HEIGHT / 2);
	conclusion.color.a = 0f;
	Rectangle bounds1 = new Rectangle(430, 96, 60, 60);
	Rectangle bounds2 = new Rectangle(430, 320, 60, 60);
	Rectangle bounds3 = new Rectangle(430, 210, 60, 60);

	pieces.add(piece1);
	pieces.add(piece2);
	pieces.add(piece3);

	bounds.add(bounds1);
	bounds.add(bounds2);
	bounds.add(bounds3);

	placed = new boolean[] { false, false, false };

    }

    @Override
    protected void onNext() {
	Settings.currentStage++;
	Settings.save();
	puzzle.interpolateAlpha(0f, Linear.INOUT, 250, true);
	for (int i = 0; i < pieces.size(); i++)
	    pieces.get(i).interpolateAlpha(0f, Linear.INOUT, 250, true);
	whole.interpolateAlpha(0f, Linear.INOUT, 250, true).setCallback(new TweenCallback() {

	    @Override
	    public void onEvent(int type, BaseTween<?> source) {
		if (type == TweenCallback.COMPLETE)
		    Settings.nextStage(game);
	    }
	});
    }

    @Override
    protected void onPuzzleSolved() {
    }

}
