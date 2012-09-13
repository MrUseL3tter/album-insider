package com.noobs2d.insider;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.noobs2d.tweenengine.utils.DynamicSprite;

public class Level11 extends LevelScreen {

    public Level11(Game game) {
	super(game);
    }

    @Override
    public void dispose() {
	Assets.lvl11.dispose();
	Assets.lvl5.dispose();
    }

    @Override
    protected void initBackground() {
	Assets.lvl11 = new Texture(Gdx.files.internal("data/gfx/LEVEL11_TEXTURE.png"));
	Assets.lvl11.setFilter(TextureFilter.Linear, TextureFilter.Linear);
	Assets.lvl5 = new Texture(Gdx.files.internal("data/gfx/LEVEL5_TEXTURE.png"));
	Assets.lvl5.setFilter(TextureFilter.Linear, TextureFilter.Linear);
	background = new DynamicSprite(new TextureRegion(Assets.lvl11, 0, 0, 800, 480), Settings.WIDTH / 2, Settings.HEIGHT / 2);
	background.color.a = 0f;
    }

    @Override
    protected void initRiddles() {
	String clue = "What has a head, a tail, is brown, and has no legs?";
	Riddle penny = new Riddle(clue, new TextureRegion(Assets.lvl11, 250, 480, 76, 86), 696, 54);
	clue = "Alive without breath, as cold as death, clad in mail never clinking, Never thirsty, ever drinking.";
	Riddle fish = new Riddle(clue, new TextureRegion(Assets.lvl11, 146, 479, 104, 68), 571, 443);
	clue = "I have a mouth on my head and eat everything. What am I?";
	Riddle backpack = new Riddle(clue, new TextureRegion(Assets.lvl11, 48, 480, 98, 134), 83, 141);
	clue = "I live in a busy place in the city, I'll let you stay with me for awhile, If you don't feed me, I can get you into trouble. What am I?";
	Riddle parkingMeter = new Riddle(clue, new TextureRegion(Assets.lvl11, 0, 480, 48, 104), 229, 323);
	clue = "What gets wetter as it dries?";
	Riddle towel = new Riddle(clue, new TextureRegion(Assets.lvl11, 326, 479, 185, 89), 373, 215);

	riddles.add(penny);
	riddles.add(fish);
	riddles.add(backpack);
	riddles.add(parkingMeter);
	riddles.add(towel);

	clue = "What's white when it's dirty?";
	Riddle blackboard = new Riddle(clue, new TextureRegion(Assets.lvl5, 0, 480, 111, 54), 742, 421);
	clue = "What building has the most stories?";
	Riddle library = new Riddle(clue, new TextureRegion(Assets.lvl5, 111, 480, 177, 105), 104, 446);
	clue = "What goes up a chimney down, and down a chimney up?";
	Riddle umbrella = new Riddle(clue, new TextureRegion(Assets.lvl5, 290, 480, 223, 182), 544, 287);
	clue = "I am the red tongue of the Earth; I bury cities beneath.";
	Riddle volcano = new Riddle(clue, new TextureRegion(Assets.lvl5, 513, 480, 86, 135), 352, 124);
	clue = "It has three eyes, all in a row. When the red one opens, all freeze.";
	Riddle trafficLight = new Riddle(clue, new TextureRegion(Assets.lvl5, 599, 480, 126, 148), 369, 412);

	riddles.add(blackboard);
	riddles.add(library);
	riddles.add(umbrella);
	riddles.add(volcano);
	riddles.add(trafficLight);

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
	stageNumber.text = "Stage 4-2";

    }

}
