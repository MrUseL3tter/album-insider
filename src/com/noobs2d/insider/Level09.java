package com.noobs2d.insider;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.noobs2d.tweenengine.utils.DynamicSprite;

public class Level09 extends LevelScreen {

    public Level09(Game game) {
	super(game);
    }

    @Override
    public void dispose() {
	Assets.lvl9.dispose();
	Assets.lvl10.dispose();
    }

    @Override
    protected void initBackground() {
	Assets.lvl9 = new Texture(Gdx.files.internal("data/gfx/LEVEL9_TEXTURE.png"));
	Assets.lvl9.setFilter(TextureFilter.Linear, TextureFilter.Linear);
	Assets.lvl10 = new Texture(Gdx.files.internal("data/gfx/LEVEL10_TEXTURE.png"));
	Assets.lvl10.setFilter(TextureFilter.Linear, TextureFilter.Linear);
	background = new DynamicSprite(new TextureRegion(Assets.lvl9, 0, 0, 800, 480), Settings.WIDTH / 2, Settings.HEIGHT / 2);
	background.color.a = 0f;
    }

    @Override
    protected void initRiddles() {
	String clue = "Here comes Kaka, walking with an open leg.";
	Riddle scissors = new Riddle(clue, new TextureRegion(Assets.lvl9, 800, 480, 174, 82), 655, 63);
	clue = "Adam's hair, you can't count.";
	Riddle rain = new Riddle(clue, new TextureRegion(Assets.lvl9, 800, 350, 142, 121), 402, 240);
	clue = "It has one entrance, but has three exit";
	Riddle dress = new Riddle(clue, new TextureRegion(Assets.lvl9, 800, 219, 121, 131), 341, 415);
	clue = "I have a friend and he is with me everywhere I go.";
	Riddle shadow = new Riddle(clue, new TextureRegion(Assets.lvl9, 800, 86, 200, 152), 368, 52);
	clue = "I have a pet, his body is full of coins.";
	Riddle churchBell = new Riddle(clue, new TextureRegion(Assets.lvl9, 800, 0, 96, 86), 207, 85);

	riddles.add(scissors);
	riddles.add(rain);
	riddles.add(dress);
	riddles.add(shadow);
	riddles.add(churchBell);

	clue = "I'm white, I'm round, but not always around. Sometimes you see me, sometimes you don't. What am I?";
	Riddle moon = new Riddle(clue, new TextureRegion(Assets.lvl10, 363, 480, 125, 125), 205, 449);
	clue = "I'm full of holes, yet I'm full of water. What am I?";
	Riddle sponge = new Riddle(clue, new TextureRegion(Assets.lvl10, 286, 480, 77, 67), 473, 349);
	clue = "House of the Lieutenant,with only one post.";
	Riddle umbrella = new Riddle(clue, new TextureRegion(Assets.lvl10, 250, 480, 27, 250), 788, 325);
	clue = "What's black when you get it, red when you use it, and white when you're all through with it?";
	Riddle charcoal = new Riddle(clue, new TextureRegion(Assets.lvl10, 125, 480, 125, 100), 80, 210);
	clue = "What starts with a T, ends with a T, and has T in it?";
	Riddle teapot = new Riddle(clue, new TextureRegion(Assets.lvl10, 0, 480, 125, 82), 629, 301);

	riddles.add(moon);
	riddles.add(sponge);
	riddles.add(umbrella);
	riddles.add(charcoal);
	riddles.add(teapot);

	for (int i = 0; i < riddles.size(); i++) {
	    riddles.get(i).clue.color.a = 0f;
	    riddles.get(i).object.color.a = 0f;
	}

	// Shuffle the riddles.
	for (int i = 0; i < riddles.size(); i++) {
	    riddles.get(i).clue.color.a = 0f;
	    riddles.get(i).object.color.a = 0f;
	    Riddle temp = riddles.remove(i);
	    riddles.add((int) (Math.random() * riddles.size()), temp);
	}

	//	riddles.remove(4);
	//	riddles.remove(3);

	riddles.get(0).visible = true;
    }

    @Override
    protected void onAllRiddlesAnswered() {
	super.onAllRiddlesAnswered();
	//	puzzle = new DynamicSprite(new TextureRegion(Assets.puzzle, 503, 0, 105, 108), Settings.WIDTH / 2, Settings.HEIGHT / 2);
	//	puzzle.interpolateY(puzzle.position.y + 50, Sine.OUT, 500, true);
	//	puzzle.interpolateY(puzzle.position.y, Sine.IN, 500, true).delay(500);
    }

    @Override
    protected void onPuzzlePieceObtained() {
	super.onPuzzlePieceObtained();
	//	Settings.currentStage++;
	//	fadeExit(5000);
    }

    @Override
    protected void updateTexts(float deltaTime) {
	super.updateTexts(deltaTime);
	stageNumber.text = "Stage 3-3";

    }

}
