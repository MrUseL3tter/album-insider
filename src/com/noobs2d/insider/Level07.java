package com.noobs2d.insider;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.noobs2d.tweenengine.utils.DynamicSprite;

public class Level07 extends LevelScreen {

    public Level07(Game game) {
	super(game);
    }

    @Override
    public void dispose() {
	Assets.lvl7.dispose();
	Assets.lvl6.dispose();
    }

    @Override
    protected void initBackground() {
	Assets.lvl7 = new Texture(Gdx.files.internal("data/gfx/LEVEL7_TEXTURE.png"));
	Assets.lvl7.setFilter(TextureFilter.Linear, TextureFilter.Linear);
	Assets.lvl6 = new Texture(Gdx.files.internal("data/gfx/LEVEL6_TEXTURE.png"));
	Assets.lvl6.setFilter(TextureFilter.Linear, TextureFilter.Linear);
	background = new DynamicSprite(new TextureRegion(Assets.lvl7, 0, 0, 800, 480), Settings.WIDTH / 2, Settings.HEIGHT / 2);
	background.color.a = 0f;
    }

    @Override
    protected void initRiddles() {
	String clue = "Her skin is green, her seed is black, her tissue is red, who is she?";
	Riddle watermelon = new Riddle(clue, new TextureRegion(Assets.lvl7, 800, 0, 78, 101), 158, 415);
	clue = "What fruit in the world that the seed is out?";
	Riddle cashew = new Riddle(clue, new TextureRegion(Assets.lvl7, 878, 0, 66, 61), 251, 57);
	clue = "An island pig with a hair as hard as a nail.";
	Riddle jackfruit = new Riddle(clue, new TextureRegion(Assets.lvl7, 944, 0, 54, 68), 393, 399);
	clue = "The queen tilt her head but the crown did not fall";
	Riddle guava = new Riddle(clue, new TextureRegion(Assets.lvl7, 800, 101, 67, 61), 251, 258);
	clue = "There is a sky, there is soil, there is water, but no fish.";
	Riddle coconut = new Riddle(clue, new TextureRegion(Assets.lvl7, 800, 162, 79, 80), 674, 215);

	riddles.add(watermelon);
	riddles.add(cashew);
	riddles.add(jackfruit);
	riddles.add(guava);
	riddles.add(coconut);

	clue = "Rice cake of the king that you can’t divide.";
	Riddle water = new Riddle(clue, new TextureRegion(Assets.lvl6, 0, 480, 26, 48), 609, 209);
	clue = "Pedro hides but you can see his head.";
	Riddle nail = new Riddle(clue, new TextureRegion(Assets.lvl6, 162, 480, 77, 110), 318, 244);
	clue = "If you want me to last longer, I must die.";
	Riddle candle = new Riddle(clue, new TextureRegion(Assets.lvl6, 108, 483, 54, 63), 490, 193);
	clue = "When it was young, it had a tail. When it grew up, it had knees.";
	Riddle frog = new Riddle(clue, new TextureRegion(Assets.lvl6, 26, 483, 68, 56), 404, 178);
	clue = "Cotton that hangs high cannot be wrapped.";
	Riddle clouds = new Riddle(clue, new TextureRegion(Assets.lvl6, 239, 480, 165, 90), 596, 445);

	riddles.add(water);
	riddles.add(nail);
	riddles.add(candle);
	riddles.add(frog);
	riddles.add(clouds);

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
	stageNumber.text = "Stage 3-1";

    }

}
