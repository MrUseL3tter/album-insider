package com.noobs2d.insider;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.noobs2d.tweenengine.utils.DynamicSprite;

public class Level01 extends LevelScreen {

    public Level01(Game game) {
	super(game);
    }

    @Override
    public void dispose() {
	Assets.lvl1.dispose();
	Assets.lvl2.dispose();
    }

    @Override
    protected void initBackground() {
	Assets.lvl1 = new Texture(Gdx.files.internal("data/gfx/LEVEL1_TEXTURE.png"));
	Assets.lvl1.setFilter(TextureFilter.Linear, TextureFilter.Linear);
	Assets.lvl2 = new Texture(Gdx.files.internal("data/gfx/LEVEL2_TEXTURE.png"));
	Assets.lvl2.setFilter(TextureFilter.Linear, TextureFilter.Linear);
	background = new DynamicSprite(new TextureRegion(Assets.lvl1, 0, 0, 800, 480), Settings.WIDTH / 2, Settings.HEIGHT / 2);
	background.color.a = 0f;
    }

    @Override
    protected void initRiddles() {
	String clue = "What goes up and down stairs\nwithout moving?";
	Riddle carpet = new Riddle(clue, new TextureRegion(Assets.lvl1, 5, 480, 336, 114), 490, 70);
	clue = "Give it food and it will live;\ngive it water and it will die.";
	Riddle fire = new Riddle(clue, new TextureRegion(Assets.lvl1, 0, 586, 65, 93), 359, 423);
	clue = "Remove the outside, cook the inside,\neat the outside, throw away the inside.";
	Riddle corn = new Riddle(clue, new TextureRegion(Assets.lvl1, 65, 587, 109, 103), 191, 381);
	clue = "They come at night without being called and are lost in the day without being stolen.";
	Riddle stars = new Riddle(clue, new TextureRegion(Assets.lvl1, 341, 480, 31, 33), 230, 160);
	clue = "What kind of room\nhas no windows or doors?";
	Riddle mushroom = new Riddle(clue, new TextureRegion(Assets.lvl1, 372, 480, 26, 28), 322, 261);

	clue = "I look at you, you look at me, I raise my right, you raise your left. What is this object?";
	Riddle mirror = new Riddle(clue, new TextureRegion(Assets.lvl2, 0, 480, 73, 106), 76, 436);
	clue = "Take off my skin, I won't cry, but you will. What am I?";
	Riddle onion = new Riddle(clue, new TextureRegion(Assets.lvl2, 73, 480, 78, 94), 466, 349);
	clue = "What do you fill with empty hands?";
	Riddle gloves = new Riddle(clue, new TextureRegion(Assets.lvl2, 151, 480, 86, 79), 714, 215);
	clue = "What do you serve that you can't eat?";
	Riddle ball = new Riddle(clue, new TextureRegion(Assets.lvl2, 237, 480, 65, 65), 41, 95);
	clue = "You answer me, although I never ask you questions. What am I?";
	Riddle telephone = new Riddle(clue, new TextureRegion(Assets.lvl2, 307, 480, 93, 71), 324, 160);

	riddles.add(carpet);
	riddles.add(fire);
	riddles.add(corn);
	riddles.add(stars);
	riddles.add(mushroom);

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
	stageNumber.text = "Stage 1-1";

    }
}
