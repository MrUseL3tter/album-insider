package com.noobs2d.insider;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.noobs2d.tweenengine.utils.DynamicSprite;

public class Level02 extends LevelScreen {

    public Level02(Game game) {
	super(game);
    }

    @Override
    public void dispose() {
	Assets.lvl2.dispose();
	Assets.lvl4.dispose();
    }

    @Override
    protected void initBackground() {
	Assets.lvl2 = new Texture(Gdx.files.internal("data/gfx/LEVEL2_TEXTURE.png"));
	Assets.lvl2.setFilter(TextureFilter.Linear, TextureFilter.Linear);
	Assets.lvl4 = new Texture(Gdx.files.internal("data/gfx/LEVEL4_TEXTURE.png"));
	Assets.lvl4.setFilter(TextureFilter.Linear, TextureFilter.Linear);
	background = new DynamicSprite(new TextureRegion(Assets.lvl2, 0, 0, 800, 480), Settings.WIDTH / 2, Settings.HEIGHT / 2);
	background.color.a = 0f;
    }

    @Override
    protected void initRiddles() {
	String clue = "I look at you, you look at me, I raise my right, you raise your left. What is this object?";
	Riddle mirror = new Riddle(clue, new TextureRegion(Assets.lvl2, 0, 480, 73, 106), 145, 370);
	clue = "Take off my skin, I won't cry, but you will. What am I?";
	Riddle onion = new Riddle(clue, new TextureRegion(Assets.lvl2, 73, 480, 78, 94), 419, 204);
	clue = "What do you fill with empty hands?";
	Riddle gloves = new Riddle(clue, new TextureRegion(Assets.lvl2, 151, 480, 86, 79), 353, 252);
	clue = "What do you serve that you can't eat?";
	Riddle ball = new Riddle(clue, new TextureRegion(Assets.lvl2, 237, 480, 65, 65), 597, 332);
	clue = "You answer me, although I never ask you questions. What am I?";
	Riddle telephone = new Riddle(clue, new TextureRegion(Assets.lvl2, 307, 480, 93, 71), 48, 137);
	clue = "Take away the whole and some still remains. What is it?";
	Riddle donut = new Riddle(clue, new TextureRegion(Assets.lvl4, 231, 480, 51, 33), 143, 87);
	clue = "What burns during the day and sleeps at night?";
	Riddle sun = new Riddle(clue, new TextureRegion(Assets.lvl4, 151, 480, 80, 80), 436, 319);
	clue = "I can run but not walk. whenever I go, thought follows close behind. what am I?";
	Riddle nose = new Riddle(clue, new TextureRegion(Assets.lvl4, 72, 525, 69, 74), 247, 311);
	clue = "I am mother and father, but never birth or nurse. I'm rarely still, but I never wonder. what am I?";
	Riddle tree = new Riddle(clue, new TextureRegion(Assets.lvl4, 72, 480, 60, 45), 387, 447);
	clue = "The man who invented it doesnt want it. The man who bought it doesnt need it. What is it?";
	Riddle coffin = new Riddle(clue, new TextureRegion(Assets.lvl4, 0, 480, 66, 204), 33, 355);

	riddles.add(donut);
	riddles.add(sun);
	riddles.add(nose);
	riddles.add(tree);
	riddles.add(coffin);
	riddles.add(mirror);
	riddles.add(onion);
	riddles.add(gloves);
	riddles.add(ball);
	riddles.add(telephone);

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
	stageNumber.text = "Stage 1-2";

    }

}
