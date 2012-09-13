package com.noobs2d.insider;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.noobs2d.tweenengine.utils.DynamicSprite;

public class Level05 extends LevelScreen {

    public Level05(Game game) {
	super(game);
    }

    @Override
    public void dispose() {
	Assets.lvl5.dispose();
	Assets.lvl8.dispose();
    }

    @Override
    protected void initBackground() {
	Assets.lvl5 = new Texture(Gdx.files.internal("data/gfx/LEVEL5_TEXTURE.png"));
	Assets.lvl5.setFilter(TextureFilter.Linear, TextureFilter.Linear);
	Assets.lvl8 = new Texture(Gdx.files.internal("data/gfx/LEVEL8_TEXTURE.png"));
	Assets.lvl8.setFilter(TextureFilter.Linear, TextureFilter.Linear);
	background = new DynamicSprite(new TextureRegion(Assets.lvl5, 0, 0, 800, 480), Settings.WIDTH / 2, Settings.HEIGHT / 2);
	background.color.a = 0f;
    }

    @Override
    protected void initRiddles() {
	String clue = "What's white when it's dirty?";
	Riddle blackboard = new Riddle(clue, new TextureRegion(Assets.lvl5, 0, 480, 111, 54), 265, 251);
	clue = "What building has the most stories?";
	Riddle library = new Riddle(clue, new TextureRegion(Assets.lvl5, 111, 480, 177, 105), 82, 441);
	clue = "What goes up a chimney down, and down a chimney up?";
	Riddle umbrella = new Riddle(clue, new TextureRegion(Assets.lvl5, 290, 480, 223, 182), 690, 99);
	clue = "I am the red tongue of the Earth; I bury cities beneath.";
	Riddle volcano = new Riddle(clue, new TextureRegion(Assets.lvl5, 513, 480, 86, 135), 513, 290);
	clue = "It has three eyes, all in a row. When the red one opens, all freeze.";
	Riddle trafficLight = new Riddle(clue, new TextureRegion(Assets.lvl5, 599, 480, 126, 148), 258, 404);

	riddles.add(blackboard);
	riddles.add(library);
	riddles.add(umbrella);
	riddles.add(volcano);
	riddles.add(trafficLight);

	clue = "A bunch of charcoal, hanging here and there.";
	Riddle duhat = new Riddle(clue, new TextureRegion(Assets.lvl8, 939, 88, 85, 60), 469, 120);
	clue = "A beautiful girl, you can't count her eyes.";
	Riddle pineapple = new Riddle(clue, new TextureRegion(Assets.lvl8, 882, 81, 56, 94), 281, 120);
	clue = "House of Pedro, full of stone.";
	Riddle papaya = new Riddle(clue, new TextureRegion(Assets.lvl8, 800, 101, 82, 87), 704, 248);
	clue = "Five coconut trees, one stands out.";
	Riddle fingers = new Riddle(clue, new TextureRegion(Assets.lvl8, 865, 0, 112, 81), 746, 419);
	clue = "When I tugged on the vine, the monkeys went crazy.";
	Riddle churchBell = new Riddle(clue, new TextureRegion(Assets.lvl8, 801, 1, 64, 100), 451, 440);

	riddles.add(duhat);
	riddles.add(pineapple);
	riddles.add(papaya);
	riddles.add(fingers);
	riddles.add(churchBell);

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
	stageNumber.text = "Stage 2-2";

    }

}
