package com.noobs2d.insider;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.noobs2d.tweenengine.utils.DynamicSprite;

public class Level13 extends LevelScreen {

    public Level13(Game game) {
	super(game);
    }

    @Override
    public void dispose() {
	Assets.lvl13.dispose();
	Assets.lvl11.dispose();
    }

    @Override
    protected void initBackground() {
	Assets.lvl13 = new Texture(Gdx.files.internal("data/gfx/LEVEL13_TEXTURE.png"));
	Assets.lvl13.setFilter(TextureFilter.Linear, TextureFilter.Linear);
	Assets.lvl11 = new Texture(Gdx.files.internal("data/gfx/LEVEL11_TEXTURE.png"));
	Assets.lvl11.setFilter(TextureFilter.Linear, TextureFilter.Linear);
	background = new DynamicSprite(new TextureRegion(Assets.lvl13, 0, 0, 800, 480), Settings.WIDTH / 2, Settings.HEIGHT / 2);
	background.color.a = 0f;
    }

    @Override
    protected void initRiddles() {
	String clue = "What do you throw out to use and take in when you're done?";
	Riddle anchor = new Riddle(clue, new TextureRegion(Assets.lvl13, 0, 480, 64, 102), 759, 340);
	clue = "Gets rid of bad ones, short and tall, tightens when used one size fits all.";
	Riddle noose = new Riddle(clue, new TextureRegion(Assets.lvl13, 64, 480, 56, 137), 47, 420);
	clue = "At night closed; in day open.";
	Riddle window = new Riddle(clue, new TextureRegion(Assets.lvl13, 126, 480, 106, 115), 575, 420);
	clue = "He pulled out a stick and it was followed by a snake.";
	Riddle needle = new Riddle(clue, new TextureRegion(Assets.lvl13, 235, 482, 51, 67), 312, 200);
	clue = "I am walking leaving tracks where I walk.";
	Riddle pen = new Riddle(clue, new TextureRegion(Assets.lvl13, 286, 481, 131, 70), 363, 86);

	riddles.add(anchor);
	riddles.add(noose);
	riddles.add(window);
	riddles.add(needle);
	riddles.add(pen);

	clue = "What has a head, a tail, is brown, and has no legs?";
	Riddle penny = new Riddle(clue, new TextureRegion(Assets.lvl11, 250, 480, 76, 86), 589, 202);
	clue = "Alive without breath, as cold as death, clad in mail never clinking, Never thirsty, ever drinking.";
	Riddle fish = new Riddle(clue, new TextureRegion(Assets.lvl11, 146, 479, 104, 68), 191, 426);
	clue = "I have a mouth on my head and eat everything. What am I?";
	Riddle backpack = new Riddle(clue, new TextureRegion(Assets.lvl11, 48, 480, 98, 134), 485, 311);
	clue = "I live in a busy place in the city, I'll let you stay with me for awhile, If you don't feed me, I can get you into trouble. What am I?";
	Riddle parkingMeter = new Riddle(clue, new TextureRegion(Assets.lvl11, 0, 480, 48, 104), 686, 436);
	clue = "What gets wetter as it dries?";
	Riddle towel = new Riddle(clue, new TextureRegion(Assets.lvl11, 326, 479, 185, 89), 98, 235);

	riddles.add(penny);
	riddles.add(fish);
	riddles.add(backpack);
	riddles.add(parkingMeter);
	riddles.add(towel);

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
	stageNumber.text = "Stage 5-1";

    }

}
