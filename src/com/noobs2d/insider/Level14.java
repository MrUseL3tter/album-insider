package com.noobs2d.insider;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.noobs2d.tweenengine.utils.DynamicSprite;

public class Level14 extends LevelScreen {

    public Level14(Game game) {
	super(game);
    }

    @Override
    public void dispose() {
	Assets.lvl14.dispose();
	Assets.lvl4.dispose();
    }

    @Override
    protected void initBackground() {
	Assets.lvl14 = new Texture(Gdx.files.internal("data/gfx/LEVEL14_TEXTURE.png"));
	Assets.lvl14.setFilter(TextureFilter.Linear, TextureFilter.Linear);
	Assets.lvl4 = new Texture(Gdx.files.internal("data/gfx/LEVEL4_TEXTURE.png"));
	Assets.lvl4.setFilter(TextureFilter.Linear, TextureFilter.Linear);
	background = new DynamicSprite(new TextureRegion(Assets.lvl14, 0, 0, 800, 480), Settings.WIDTH / 2, Settings.HEIGHT / 2);
	background.color.a = 0f;
    }

    @Override
    protected void initRiddles() {
	String clue = "I am a box that holds keys without locks, yet they can unlock your soul. What am I?";
	Riddle piano = new Riddle(clue, new TextureRegion(Assets.lvl14, 0, 480, 168, 61), 479, 129);
	clue = "It's red, blue, and purple and green, no one can reach it, not even the queen. What is it?";
	Riddle rainbow = new Riddle(clue, new TextureRegion(Assets.lvl14, 170, 480, 108, 82), 358, 420);
	clue = "A box without hinges, lock or key, yet golden treasure lies within. What is it?";
	Riddle egg = new Riddle(clue, new TextureRegion(Assets.lvl14, 278, 480, 54, 65), 453, 244);
	clue = "A man who always carries his house along with him.";
	Riddle turtle = new Riddle(clue, new TextureRegion(Assets.lvl14, 334, 480, 132, 102), 96, 62);
	clue = "It stands on one leg with its heart in its head.";
	Riddle cabbage = new Riddle(clue, new TextureRegion(Assets.lvl14, 467, 484, 76, 78), 134, 244);

	riddles.add(piano);
	riddles.add(rainbow);
	riddles.add(egg);
	riddles.add(turtle);
	riddles.add(cabbage);

	clue = "Take away the whole and some still remains. What is it?";
	Riddle donut = new Riddle(clue, new TextureRegion(Assets.lvl4, 231, 480, 51, 33), 561, 82);
	clue = "What burns during the day and sleeps at night?";
	Riddle sun = new Riddle(clue, new TextureRegion(Assets.lvl4, 151, 480, 80, 80), 595, 450);
	clue = "I can run but not walk. whenever I go, thought follows close behind. what am I?";
	Riddle nose = new Riddle(clue, new TextureRegion(Assets.lvl4, 72, 525, 69, 74), 526, 373);
	clue = "I am mother and father, but never birth or nurse. I'm rarely still, but I never wonder. what am I?";
	Riddle tree = new Riddle(clue, new TextureRegion(Assets.lvl4, 72, 480, 60, 45), 790, 450);
	clue = "The man who invented it doesnt want it. The man who bought it doesnt need it. What is it?";
	Riddle coffin = new Riddle(clue, new TextureRegion(Assets.lvl4, 0, 480, 66, 204), 602, 231);

	riddles.add(donut);
	riddles.add(sun);
	riddles.add(nose);
	riddles.add(tree);
	riddles.add(coffin);

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
    protected void updateTexts(float deltaTime) {
	super.updateTexts(deltaTime);
	stageNumber.text = "Stage 5-2";

    }

}
