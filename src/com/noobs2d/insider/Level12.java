package com.noobs2d.insider;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.noobs2d.tweenengine.utils.DynamicSprite;

public class Level12 extends LevelScreen {

    public Level12(Game game) {
	super(game);
    }

    @Override
    public void dispose() {
	Assets.lvl12.dispose();
	Assets.lvl7.dispose();
    }

    @Override
    protected void initBackground() {
	Assets.lvl12 = new Texture(Gdx.files.internal("data/gfx/LEVEL12_TEXTURE.png"));
	Assets.lvl12.setFilter(TextureFilter.Linear, TextureFilter.Linear);
	Assets.lvl7 = new Texture(Gdx.files.internal("data/gfx/LEVEL7_TEXTURE.png"));
	Assets.lvl7.setFilter(TextureFilter.Linear, TextureFilter.Linear);
	background = new DynamicSprite(new TextureRegion(Assets.lvl12, 0, 0, 800, 480), Settings.WIDTH / 2, Settings.HEIGHT / 2);
	background.color.a = 0f;
    }

    @Override
    protected void initRiddles() {
	String clue = "I bought a slave, taller than myself.";
	Riddle hat = new Riddle(clue, new TextureRegion(Assets.lvl12, 451, 480, 106, 93), 72, 412);
	clue = "I saw two boats; only one person was on board.";
	Riddle shoes = new Riddle(clue, new TextureRegion(Assets.lvl12, 349, 480, 102, 66), 411, 192);
	clue = "People need me but they always give me away. What am I?";
	Riddle money = new Riddle(clue, new TextureRegion(Assets.lvl12, 170, 480, 168, 103), 378, 51);
	clue = "I go in dry and come out wet, the longer I'm in, the stronger I get. What am I?";
	Riddle teaBag = new Riddle(clue, new TextureRegion(Assets.lvl12, 106, 480, 64, 64), 422, 315);
	clue = "Round like an apple, deep like a cup, yet all the king's horses cannot pull it up.";
	Riddle well = new Riddle(clue, new TextureRegion(Assets.lvl12, 0, 480, 106, 211), 756, 388);

	riddles.add(hat);
	riddles.add(shoes);
	riddles.add(money);
	riddles.add(teaBag);
	riddles.add(well);

	clue = "Her skin is green, her seed is black, her tissue is red, who is she?";
	Riddle watermelon = new Riddle(clue, new TextureRegion(Assets.lvl7, 800, 0, 78, 101), 187, 429);
	clue = "What fruit in the world that the seed is out?";
	Riddle cashew = new Riddle(clue, new TextureRegion(Assets.lvl7, 878, 0, 66, 61), 624, 133);
	clue = "An island pig with a hair as hard as a nail.";
	Riddle jackfruit = new Riddle(clue, new TextureRegion(Assets.lvl7, 944, 0, 54, 68), 351, 379);
	clue = "The queen tilt her head but the crown did not fall";
	Riddle guava = new Riddle(clue, new TextureRegion(Assets.lvl7, 800, 101, 67, 61), 609, 449);
	clue = "There is a sky, there is soil, there is water, but no fish.";
	Riddle coconut = new Riddle(clue, new TextureRegion(Assets.lvl7, 800, 162, 79, 80), 275, 225);

	riddles.add(watermelon);
	riddles.add(cashew);
	riddles.add(jackfruit);
	riddles.add(guava);
	riddles.add(coconut);

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
	//	puzzle = new DynamicSprite(new TextureRegion(Assets.puzzle, 608, 0, 88, 131), Settings.WIDTH / 2, Settings.HEIGHT / 2);
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
	stageNumber.text = "Stage 4-3";

    }

}
