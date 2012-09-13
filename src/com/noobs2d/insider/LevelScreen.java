package com.noobs2d.insider;

import java.util.ArrayList;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.equations.Back;
import aurelienribon.tweenengine.equations.Linear;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFont.HAlignment;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.noobs2d.tweenengine.utils.DynamicDisplay;
import com.noobs2d.tweenengine.utils.DynamicDisplay.DynamicRegistration;
import com.noobs2d.tweenengine.utils.DynamicNinePatch;
import com.noobs2d.tweenengine.utils.DynamicScreen;
import com.noobs2d.tweenengine.utils.DynamicSprite;
import com.noobs2d.tweenengine.utils.DynamicText;

public abstract class LevelScreen extends DynamicScreen {

    static final int STAGE_DURATION = 90;

    ArrayList<DynamicDisplay> flyouts = new ArrayList<DynamicDisplay>();

    ArrayList<Riddle> riddles = new ArrayList<Riddle>();

    DynamicNinePatch ninePatch;
    DynamicSprite puzzle;
    DynamicSprite background;
    DynamicText stageNumber;
    float stamp = 0;

    DynamicText hintsText;
    DynamicText timerText;
    DynamicText scoreText;
    int riddleIndex = 0;
    int stageScore = 0;
    int hints = 3;

    boolean hinted = false;
    boolean paused = false;
    float elapsed = STAGE_DURATION;

    public LevelScreen(Game game) {
	super(game, Settings.WIDTH, Settings.HEIGHT);
	stamp = Gdx.graphics.getDeltaTime();
	initBackground();
	initTexts();
	initRiddles();
    }

    @Override
    public boolean keyUp(int keycode) {
	if (keycode == Keys.BACK || keycode == Keys.BACKSPACE)
	    game.setScreen(new PauseScreen(game, this));
	return false;
    }

    @Override
    public void render(float deltaTime) {
	super.render(deltaTime);
	if (elapsed <= 0) {
	    fadeExit(0);
	    elapsed = 10000;
	    Settings.currentScore -= stageScore;
	}

	spriteBatch.begin();
	background.render(spriteBatch);

	if (puzzle != null) {
	    puzzle.render(spriteBatch);
	    puzzle.update(deltaTime);
	}

	for (int i = 0; i < riddles.size(); i++)
	    riddles.get(i).object.render(spriteBatch);

	ninePatch.render(spriteBatch);
	if (riddles.size() > 0) {
	    riddles.get(riddleIndex).clue.render(spriteBatch);
	    ninePatch.height = riddles.get(riddleIndex).clue.getBounds().height + 20;
	}

	for (int i = 0; i < flyouts.size(); i++)
	    flyouts.get(i).render(spriteBatch);

	hintsText.render(spriteBatch);
	stageNumber.render(spriteBatch);
	timerText.render(spriteBatch);
	scoreText.render(spriteBatch);

	spriteBatch.end();

	if (!paused) {
	    background.update(deltaTime);
	    ninePatch.update(deltaTime);
	    hintsText.update(deltaTime);
	    stageNumber.update(deltaTime);
	    timerText.update(deltaTime);
	    scoreText.update(deltaTime);

	    for (int i = 0; i < riddles.size(); i++)
		riddles.get(i).update(deltaTime);

	    for (int i = 0; i < flyouts.size(); i++)
		flyouts.get(i).update(deltaTime);

	    updateTexts(deltaTime);
	}
    }

    @Override
    public void show() {
	super.show();
	timerText.interpolateAlpha(1f, Linear.INOUT, 500, true);
	scoreText.interpolateAlpha(1f, Linear.INOUT, 500, true);
	stageNumber.interpolateAlpha(1f, Linear.INOUT, 500, true);
	background.interpolateAlpha(1f, Linear.INOUT, 500, true);

	for (int i = 0; i < flyouts.size(); i++)
	    flyouts.get(i).interpolateAlpha(1f, Linear.INOUT, 500, true);

	for (int i = 0; i < riddles.size(); i++) {
	    riddles.get(i).clue.interpolateAlpha(1f, Linear.INOUT, 500, true);
	    riddles.get(i).object.interpolateAlpha(1f, Linear.INOUT, 500, true);
	}
    }

    @Override
    public boolean touchDown(int x, int y, int pointer, int button) {
	x *= (float) Settings.WIDTH / Gdx.graphics.getWidth();
	float scale = (float) Settings.HEIGHT / Gdx.graphics.getHeight();
	y = Gdx.graphics.getHeight() - y;
	y *= scale;
	if (pointer == 2 && hints > 0) {
	    // trigger fade-blink for hinting
	    hints--;
	    riddles.get(riddleIndex).object.tweenManager.killAll();
	    riddles.get(riddleIndex).object.interpolateAlpha(0.25f, Linear.INOUT, 250, true);
	    riddles.get(riddleIndex).object.interpolateAlpha(1f, Linear.INOUT, 250, true).delay(250);
	    riddles.get(riddleIndex).object.interpolateAlpha(0.25f, Linear.INOUT, 250, true).delay(500);
	    riddles.get(riddleIndex).object.interpolateAlpha(1f, Linear.INOUT, 250, true).delay(750);
	    riddles.get(riddleIndex).object.interpolateAlpha(0.25f, Linear.INOUT, 250, true).delay(1000);
	    riddles.get(riddleIndex).object.interpolateAlpha(1f, Linear.INOUT, 250, true).delay(1250);
	    hinted = true;
	} else
	    hinted = false;
	return false;
    }

    @Override
    public boolean touchUp(int x, int y, int pointer, int button) {
	x *= (float) Settings.WIDTH / Gdx.graphics.getWidth();
	float scale = (float) Settings.HEIGHT / Gdx.graphics.getHeight();
	y = Gdx.graphics.getHeight() - y;
	y *= scale;
	if (!hinted && pointer == 0 && !Gdx.input.isTouched(1) && !Gdx.input.isTouched(2))
	    if (puzzle != null && puzzle.getBounds().contains(x, y)) {
		Assets.start.play();
		puzzle.interpolateScaleXY(new Vector2(2f, 2f), Linear.INOUT, 5000, true);
		onPuzzlePieceObtained();
	    } else if (riddles.get(riddleIndex).object.getBounds().contains(x, y)) {
		Assets.correct.play();
		Settings.currentScore += getScore();
		stageScore += getScore();
		flyouts.add(riddles.get(riddleIndex).clue);
		flyouts.add(riddles.get(riddleIndex).object);
		ninePatch.interpolateAlpha(0f, Linear.INOUT, 1000, true);
		riddles.get(riddleIndex).clue.color.a = 0f;
		riddles.get(riddleIndex).object.tweenManager.killAll();
		riddles.get(riddleIndex).object.interpolateScaleXY(new Vector2(1.5f, 1.5f), Back.OUT, 1000, true);
		riddles.get(riddleIndex).object.interpolateScaleXY(new Vector2(0f, 0f), Linear.INOUT, 500, true).delay(1000);
		riddles.remove(riddleIndex);

		// Add score flyout
		DynamicText text = new DynamicText(new BitmapFont(Gdx.files.internal("data/fonts/TRAJANPRO28.fnt"), new TextureRegion(Assets.trajanPro28), false), "+" + getScore());
		text.color.set(Color.GREEN);
		text.position.set(x, y + 50);
		text.interpolateY(y, Back.OUT, 500, true);
		text.interpolateAlpha(0f, Linear.INOUT, 500, true).delay(2000);
		flyouts.add(text);
		if (riddles.size() > 0) {
		    riddles.get(riddleIndex).clue.position.y = -200;
		    riddles.get(riddleIndex).clue.color.a = 0f;
		    riddles.get(riddleIndex).clue.interpolateAlpha(1f, Linear.INOUT, 500, true).delay(1000);
		    riddles.get(riddleIndex).clue.interpolateXY(new Vector2(Settings.WIDTH / 2, 10f), Linear.INOUT, 500, true).delay(1000);
		    ninePatch.height = riddles.get(riddleIndex).clue.getBounds().height + 20;
		    ninePatch.position.y = 0 - ninePatch.height;
		    ninePatch.interpolateY(0f, Linear.INOUT, 500, true).delay(1000);
		    ninePatch.interpolateAlpha(.65f, Linear.INOUT, 500, true).delay(1000);
		} else
		    onAllRiddlesAnswered();

	    } else {
		Assets.wrong.play();
		if (elapsed > 3)
		    elapsed -= 3;
		else
		    elapsed = 0;
		DynamicText text = new DynamicText(new BitmapFont(Gdx.files.internal("data/fonts/TRAJANPRO28.fnt"), new TextureRegion(Assets.trajanPro28), false), "-3 sec.");
		text.color.set(Color.RED);
		text.position.set(x, y + 50);
		text.interpolateY(y, Back.OUT, 500, true);
		text.interpolateAlpha(0f, Linear.INOUT, 500, true).delay(2000);
		flyouts.add(text);
	    }
	return false;
    }

    private int getScore() {
	if (elapsed > 50)
	    return 1000;
	else if (elapsed < 51 && elapsed > 40)
	    return 800;
	else if (elapsed < 41 && elapsed > 30)
	    return 600;
	else if (elapsed < 31 && elapsed > 20)
	    return 400;
	else if (elapsed < 21 && elapsed > 10)
	    return 200;
	else
	    return 50;
    }

    protected void fadeExit(float delay) {
	timerText.interpolateY(550f, Linear.INOUT, 500, true).delay(delay);
	scoreText.interpolateAlpha(0f, Linear.INOUT, 500, true).delay(delay);
	stageNumber.interpolateAlpha(0f, Linear.INOUT, 500, true).delay(delay);
	background.interpolateAlpha(0f, Linear.INOUT, 500, true).delay(delay).setCallback(new TweenCallback() {

	    @Override
	    public void onEvent(int type, BaseTween<?> source) {
		if (type == TweenCallback.COMPLETE)
		    Settings.nextStage(game);
	    }
	});

	for (int i = 0; i < flyouts.size(); i++)
	    flyouts.get(i).interpolateAlpha(0f, Linear.INOUT, 500, true).delay(delay);

	for (int i = 0; i < riddles.size(); i++) {
	    riddles.get(i).clue.interpolateAlpha(0f, Linear.INOUT, 500, true).delay(delay);
	    riddles.get(i).object.interpolateAlpha(0f, Linear.INOUT, 500, true).delay(delay);
	}
    }

    protected abstract void initBackground();

    protected abstract void initRiddles();

    protected void initTexts() {
	hintsText = new DynamicText(new BitmapFont(Gdx.files.internal("data/fonts/TRAJANPRO35.fnt"), new TextureRegion(Assets.trajanPro35), false), "" + hints);
	hintsText.alignment = HAlignment.LEFT;
	hintsText.wrapWidth = 1250;
	hintsText.position.set(7, 433);
	hintsText.scale.set(.65f, .65f);
	hintsText.setRegistration(DynamicRegistration.TOP_LEFT);

	stageNumber = new DynamicText(new BitmapFont(Gdx.files.internal("data/fonts/TRAJANPRO35.fnt"), new TextureRegion(Assets.trajanPro35), false), "");
	stageNumber.alignment = HAlignment.LEFT;
	stageNumber.wrapWidth = Settings.WIDTH;
	stageNumber.position.set(7, 473);
	stageNumber.color.a = 0f;
	stageNumber.setRegistration(DynamicRegistration.TOP_LEFT);

	timerText = new DynamicText(new BitmapFont(Gdx.files.internal("data/fonts/TRAJANPRO42.fnt"), new TextureRegion(Assets.trajanPro42), false), "");
	timerText.wrapWidth = 250;
	timerText.color.a = 0f;
	timerText.position.set(Settings.WIDTH / 2, 460);

	scoreText = new DynamicText(new BitmapFont(Gdx.files.internal("data/fonts/TRAJANPRO35.fnt"), new TextureRegion(Assets.trajanPro35), false), "");
	scoreText.position.set(793, 473);
	scoreText.alignment = HAlignment.RIGHT;
	scoreText.color.a = 0f;
	scoreText.wrapWidth = Settings.WIDTH;
	scoreText.setRegistration(DynamicRegistration.TOP_RIGHT);

	ninePatch = new DynamicNinePatch(Assets.ninePatch, Settings.WIDTH, 200, new int[] { 16, 16, 16, 16 });
	ninePatch.setRegistration(DynamicRegistration.BOTTOM_LEFT);
	ninePatch.color.a = 0.65f;
    }

    protected void onAllRiddlesAnswered() {
	Settings.currentStage++;
	fadeExit(1000);
    }

    protected void onPuzzlePieceObtained() {

    }

    protected void updateTexts(float deltaTime) {
	elapsed -= stamp;
	hintsText.text = "HINTS: " + hints;

	String time = elapsed >= 60 ? "01:" : "00:";
	if (elapsed >= 60) {
	    float num = elapsed - 60;
	    time += num >= 10 ? "" + Float.toString(num).substring(0, 2) : "0" + Float.toString(num).charAt(0);
	} else if (elapsed < 60)
	    time += elapsed >= 10 ? Float.toString(elapsed).substring(0, 2) : "0" + Float.toString(elapsed).charAt(0);
	else
	    time += "00";
	timerText.text = time;

	if (elapsed > 35)
	    timerText.color.set(Color.GREEN);
	else if (elapsed < 35 && elapsed > 10)
	    timerText.color.set(Color.ORANGE);
	else
	    timerText.color.set(Color.RED);

	scoreText.text = "" + Settings.currentScore;
	stamp = deltaTime;
    }

}
