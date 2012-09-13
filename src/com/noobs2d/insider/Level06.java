package com.noobs2d.insider;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.noobs2d.tweenengine.utils.DynamicSprite;

public class Level06 extends LevelScreen {

    public Level06(Game game) {
	super(game);
    }

    @Override
    public void dispose() {
	Assets.lvl6.dispose();
	Assets.lvl12.dispose();
    }

    @Override
    protected void initBackground() {
	Assets.lvl6 = new Texture(Gdx.files.internal("data/gfx/LEVEL6_TEXTURE.png"));
	Assets.lvl6.setFilter(TextureFilter.Linear, TextureFilter.Linear);
	Assets.lvl12 = new Texture(Gdx.files.internal("data/gfx/LEVEL12_TEXTURE.png"));
	Assets.lvl12.setFilter(TextureFilter.Linear, TextureFilter.Linear);
	background = new DynamicSprite(new TextureRegion(Assets.lvl6, 0, 0, 800, 480), Settings.WIDTH / 2, Settings.HEIGHT / 2);
	background.color.a = 0f;
    }

    @Override
    protected void initRiddles() {
	String clue = "Rice cake of the king that you can’t divide.";
	Riddle water = new Riddle(clue, new TextureRegion(Assets.lvl6, 0, 480, 26, 48), 416, 308);
	clue = "Pedro hides but you can see his head.";
	Riddle nail = new Riddle(clue, new TextureRegion(Assets.lvl6, 162, 480, 77, 110), 454, 100);
	clue = "If you want me to last longer, I must die.";
	Riddle candle = new Riddle(clue, new TextureRegion(Assets.lvl6, 108, 483, 54, 63), 466, 323);
	clue = "When it was young, it had a tail. When it grew up, it had knees.";
	Riddle frog = new Riddle(clue, new TextureRegion(Assets.lvl6, 26, 483, 68, 56), 298, 243);
	clue = "Cotton that hangs high cannot be wrapped.";
	Riddle clouds = new Riddle(clue, new TextureRegion(Assets.lvl6, 239, 480, 165, 90), 159, 155);

	riddles.add(water);
	riddles.add(nail);
	riddles.add(candle);
	riddles.add(frog);
	riddles.add(clouds);

	clue = "I bought a slave, taller than myself.";
	Riddle hat = new Riddle(clue, new TextureRegion(Assets.lvl12, 451, 480, 106, 93), 366, 467);
	clue = "I saw two boats; only one person was on board.";
	Riddle shoes = new Riddle(clue, new TextureRegion(Assets.lvl12, 349, 480, 102, 66), 665, 264);
	clue = "People need me but they always give me away. What am I?";
	Riddle money = new Riddle(clue, new TextureRegion(Assets.lvl12, 170, 480, 168, 103), 145, 335);
	clue = "I go in dry and come out wet, the longer I'm in, the stronger I get. What am I?";
	Riddle teaBag = new Riddle(clue, new TextureRegion(Assets.lvl12, 106, 480, 64, 64), 553, 356);
	clue = "Round like an apple, deep like a cup, yet all the king's horses cannot pull it up.";
	Riddle well = new Riddle(clue, new TextureRegion(Assets.lvl12, 0, 480, 106, 211), 769, 429);

	riddles.add(hat);
	riddles.add(shoes);
	riddles.add(money);
	riddles.add(teaBag);
	riddles.add(well);

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
	//	puzzle = new DynamicSprite(new TextureRegion(Assets.puzzle, 422, 0, 81, 123), Settings.WIDTH / 2, Settings.HEIGHT / 2);
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
	stageNumber.text = "Stage 2-3";

    }

}
