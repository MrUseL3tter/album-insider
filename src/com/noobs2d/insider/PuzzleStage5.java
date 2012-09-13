package com.noobs2d.insider;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.noobs2d.tweenengine.utils.DynamicSprite;

public class PuzzleStage5 extends PuzzleStage {

    public PuzzleStage5(Game game) {
	super(game);
	// TODO Auto-generated constructor stub
    }

    @Override
    protected void initComponents() {
	puzzle = new DynamicSprite(new TextureRegion(Assets.puzzle, 0, 0, 301, 301), Settings.WIDTH / 2, Settings.HEIGHT / 2);
	DynamicSprite piece1 = new DynamicSprite(new TextureRegion(Assets.puzzle, 301, 0, 121, 146), 141, 111);
	DynamicSprite piece2 = new DynamicSprite(new TextureRegion(Assets.puzzle, 422, 0, 81, 123), 100, 301);
	DynamicSprite piece3 = new DynamicSprite(new TextureRegion(Assets.puzzle, 503, 0, 105, 108), 678, 363);
	DynamicSprite piece4 = new DynamicSprite(new TextureRegion(Assets.puzzle, 608, 0, 88, 131), 679, 183);
	whole = new DynamicSprite(new TextureRegion(Assets.puzzle, 301, 146, 300, 300), Settings.WIDTH / 2, Settings.HEIGHT / 2);
	whole.visible = false;
	whole.scale.set(3f, 3f);
	conclusion = new DynamicSprite(new TextureRegion(Assets.conclusion, 0, 0, 800, 480), Settings.WIDTH / 2, Settings.HEIGHT / 2);
	conclusion.color.a = 0f;
	Rectangle bounds1 = new Rectangle(408, 208, 61, 61);
	Rectangle bounds2 = new Rectangle(330, 298, 61, 61);
	Rectangle bounds3 = new Rectangle(340, 112, 61, 61);
	Rectangle bounds4 = new Rectangle(331, 201, 61, 61);

	pieces.add(piece1);
	pieces.add(piece2);
	pieces.add(piece3);
	pieces.add(piece4);

	bounds.add(bounds1);
	bounds.add(bounds2);
	bounds.add(bounds3);
	bounds.add(bounds4);
    }

}
