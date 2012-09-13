package com.noobs2d.insider;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.noobs2d.tweenengine.utils.DynamicSprite;

public class Level08 extends LevelScreen {

    public Level08(Game game) {
	super(game);
    }

    @Override
    public void dispose() {
	Assets.lvl8.dispose();
	Assets.lvl3.dispose();
    }

    @Override
    protected void initBackground() {
	Assets.lvl8 = new Texture(Gdx.files.internal("data/gfx/LEVEL8_TEXTURE.png"));
	Assets.lvl8.setFilter(TextureFilter.Linear, TextureFilter.Linear);
	Assets.lvl3 = new Texture(Gdx.files.internal("data/gfx/LEVEL3_TEXTURE.png"));
	Assets.lvl3.setFilter(TextureFilter.Linear, TextureFilter.Linear);
	background = new DynamicSprite(new TextureRegion(Assets.lvl8, 0, 0, 800, 480), Settings.WIDTH / 2, Settings.HEIGHT / 2);
	background.color.a = 0f;
    }

    @Override
    protected void initRiddles() {
	String clue = "A bunch of charcoal, hanging here and there.";
	Riddle duhat = new Riddle(clue, new TextureRegion(Assets.lvl8, 939, 88, 85, 60), 638, 238);
	clue = "A beautiful girl, you can't count her eyes.";
	Riddle pineapple = new Riddle(clue, new TextureRegion(Assets.lvl8, 882, 81, 56, 94), 234, 298);
	clue = "House of Pedro, full of stone.";
	Riddle papaya = new Riddle(clue, new TextureRegion(Assets.lvl8, 800, 101, 82, 87), 716, 194);
	clue = "Five coconut trees, one stands out.";
	Riddle fingers = new Riddle(clue, new TextureRegion(Assets.lvl8, 865, 0, 112, 81), 746, 360);
	clue = "When I tugged on the vine, the monkeys went crazy.";
	Riddle churchBell = new Riddle(clue, new TextureRegion(Assets.lvl8, 801, 1, 64, 100), 202, 428);

	riddles.add(duhat);
	riddles.add(pineapple);
	riddles.add(papaya);
	riddles.add(fingers);
	riddles.add(churchBell);

	clue = "Only two backbones and thousands of ribs.";
	Riddle railroad = new Riddle(clue, new TextureRegion(Assets.lvl3, 0, 480, 204, 89), 478, 436);
	clue = "I have hands and a face. I sometimes have numbers on my face.";
	Riddle watch = new Riddle(clue, new TextureRegion(Assets.lvl3, 204, 480, 64, 129), 112, 426);
	clue = "A long snake that smokes. What am I?";
	Riddle train = new Riddle(clue, new TextureRegion(Assets.lvl3, 268, 480, 364, 131), 169, 66);
	clue = "What has teeth but can not bite?";
	Riddle comb = new Riddle(clue, new TextureRegion(Assets.lvl3, 0, 569, 113, 54), 327, 182);
	clue = "Take one out and scratch my head I am now black but once was red. What am I?";
	Riddle matchsticks = new Riddle(clue, new TextureRegion(Assets.lvl3, 672, 480, 42, 175), 184, 233);

	riddles.add(railroad);
	riddles.add(watch);
	riddles.add(train);
	riddles.add(comb);
	riddles.add(matchsticks);

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
	stageNumber.text = "Stage 3-2";

    }

}
