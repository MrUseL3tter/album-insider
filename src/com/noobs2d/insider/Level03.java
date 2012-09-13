package com.noobs2d.insider;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.noobs2d.tweenengine.utils.DynamicSprite;

public class Level03 extends LevelScreen {

    public Level03(Game game) {
	super(game);
    }

    @Override
    public void dispose() {
	Assets.lvl3.dispose();
	Assets.lvl11.dispose();

    }

    @Override
    protected void initBackground() {
	Assets.lvl3 = new Texture(Gdx.files.internal("data/gfx/LEVEL3_TEXTURE.png"));
	Assets.lvl3.setFilter(TextureFilter.Linear, TextureFilter.Linear);
	Assets.lvl1 = new Texture(Gdx.files.internal("data/gfx/LEVEL1_TEXTURE.png"));
	Assets.lvl1.setFilter(TextureFilter.Linear, TextureFilter.Linear);
	background = new DynamicSprite(new TextureRegion(Assets.lvl3, 0, 0, 800, 480), Settings.WIDTH / 2, Settings.HEIGHT / 2);
	background.color.a = 0f;
    }

    @Override
    protected void initRiddles() {
	String clue = "Only two backbones and thousands of ribs.";
	Riddle railroad = new Riddle(clue, new TextureRegion(Assets.lvl3, 0, 480, 204, 89), 636, 316);
	clue = "I have hands and a face. I sometimes have numbers on my face.";
	Riddle watch = new Riddle(clue, new TextureRegion(Assets.lvl3, 204, 480, 64, 129), 771, 415);
	clue = "A long snake that smokes. What am I?";
	Riddle train = new Riddle(clue, new TextureRegion(Assets.lvl3, 268, 480, 364, 131), 182, 65);
	clue = "What has teeth but can not bite?";
	Riddle comb = new Riddle(clue, new TextureRegion(Assets.lvl3, 0, 569, 113, 54), 544, 84);
	clue = "Take one out and scratch my head I am now black but once was red. What am I?";
	Riddle matchsticks = new Riddle(clue, new TextureRegion(Assets.lvl3, 672, 480, 42, 175), 45, 372);

	clue = "What goes up and down stairs\nwithout moving?";
	Riddle carpet = new Riddle(clue, new TextureRegion(Assets.lvl1, 5, 480, 336, 114), 490, 79);
	clue = "Give it food and it will live;\ngive it water and it will die.";
	Riddle fire = new Riddle(clue, new TextureRegion(Assets.lvl1, 0, 586, 65, 93), 99, 268);
	clue = "Remove the outside, cook the inside,\neat the outside, throw away the inside.";
	Riddle corn = new Riddle(clue, new TextureRegion(Assets.lvl1, 65, 586, 109, 103), 749, 133);
	clue = "They come at night without being called and are lost in the day without being stolen.";
	Riddle stars = new Riddle(clue, new TextureRegion(Assets.lvl1, 341, 480, 31, 33), 483, 260);
	clue = "What kind of room\nhas no windows or doors?";
	Riddle mushroom = new Riddle(clue, new TextureRegion(Assets.lvl1, 372, 480, 26, 28), 322, 261);

	riddles.add(railroad);
	riddles.add(watch);
	riddles.add(train);
	riddles.add(comb);
	riddles.add(matchsticks);

	riddles.add(carpet);
	riddles.add(fire);
	riddles.add(corn);
	riddles.add(stars);
	riddles.add(mushroom);

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
	//	puzzle = new DynamicSprite(new TextureRegion(Assets.puzzle, 301, 0, 121, 146), Settings.WIDTH / 2, Settings.HEIGHT / 2);
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
	stageNumber.text = "Stage 1-3";

    }

}
