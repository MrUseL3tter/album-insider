package com.noobs2d.insider;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.noobs2d.tweenengine.utils.DynamicSprite;

public class Level15 extends LevelScreen {

    public Level15(Game game) {
	super(game);
    }

    @Override
    public void dispose() {
	Assets.lvl15.dispose();
	Assets.lvl5.dispose();
    }

    @Override
    protected void initBackground() {
	Assets.lvl15 = new Texture(Gdx.files.internal("data/gfx/LEVEL15_TEXTURE.png"));
	Assets.lvl15.setFilter(TextureFilter.Linear, TextureFilter.Linear);
	Assets.lvl5 = new Texture(Gdx.files.internal("data/gfx/LEVEL5_TEXTURE.png"));
	Assets.lvl5.setFilter(TextureFilter.Linear, TextureFilter.Linear);
	background = new DynamicSprite(new TextureRegion(Assets.lvl15, 0, 0, 800, 480), Settings.WIDTH / 2, Settings.HEIGHT / 2);
	background.color.a = 0f;
    }

    @Override
    protected void initRiddles() {
	String clue = "When young, I am sweet in the sun. When middle-aged, I make you gay. When old, I am valued more than ever.";
	Riddle wine = new Riddle(clue, new TextureRegion(Assets.lvl15, 0, 480, 49, 174), 610, 190);
	clue = "What makes a loud noise when changing its jacket, becomes larger but weighs less?";
	Riddle popcorn = new Riddle(clue, new TextureRegion(Assets.lvl15, 49, 480, 72, 100), 39, 312);
	clue = "What goes into the water black and comes out red?";
	Riddle lobster = new Riddle(clue, new TextureRegion(Assets.lvl15, 121, 485, 122, 89), 256, 306);
	clue = "What can't be burned in a fire nor drowned in water?";
	Riddle ice = new Riddle(clue, new TextureRegion(Assets.lvl15, 248, 480, 159, 110), 555, 378);
	clue = "Kings and queens may cling to power and the jester's got his call but, as you may all discover, the common one outranks them all.";
	Riddle ace = new Riddle(clue, new TextureRegion(Assets.lvl15, 407, 480, 116, 75), 259, 85);

	riddles.add(wine);
	riddles.add(popcorn);
	riddles.add(lobster);
	riddles.add(ice);
	riddles.add(ace);

	clue = "What's white when it's dirty?";
	Riddle blackboard = new Riddle(clue, new TextureRegion(Assets.lvl5, 0, 480, 111, 54), 714, 320);
	clue = "What building has the most stories?";
	Riddle library = new Riddle(clue, new TextureRegion(Assets.lvl5, 111, 480, 177, 105), 109, 449);
	clue = "What goes up a chimney down, and down a chimney up?";
	Riddle umbrella = new Riddle(clue, new TextureRegion(Assets.lvl5, 290, 480, 223, 182), 758, 161);
	clue = "I am the red tongue of the Earth; I bury cities beneath.";
	Riddle volcano = new Riddle(clue, new TextureRegion(Assets.lvl5, 513, 480, 86, 135), 94, 137);
	clue = "It has three eyes, all in a row. When the red one opens, all freeze.";
	Riddle trafficLight = new Riddle(clue, new TextureRegion(Assets.lvl5, 599, 480, 126, 148), 615, 421);

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
	stageNumber.text = "Stage 5-3";

    }

}
