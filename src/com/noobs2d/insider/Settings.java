package com.noobs2d.insider;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public class Settings {

    static final boolean DEBUG_MODE = false;
    static final int STAGES_MAX = 20;
    static final int WIDTH = 800;
    static final int HEIGHT = 480;

    static int[] highscores = new int[] { 1000, 800, 600, 400, 200 };
    static int currentStage = 0;
    static int currentScore = 0;

    public static void load() {
	try {
	    BufferedReader in = new BufferedReader(new InputStreamReader(Gdx.files.external("/.insider").read()));
	    currentStage = Integer.parseInt(in.readLine());
	    currentScore = Integer.parseInt(in.readLine());
	    for (int i = 0; i < 5; i++)
		highscores[i] = Integer.parseInt(in.readLine());
	    in.close();

	    for (int i = 0; i < 5; i++)
		System.out.println(highscores[i]);
	} catch (Exception e) {
	    System.out.println("Settings file not found!");
	}
    }

    public static void nextStage(Game game) {
	save();
	switch (Settings.currentStage) {
	    case 0:
		game.setScreen(new IntroScreen(game));
		break;
	    case 1:
		game.setScreen(new Level01(game));
		break;
	    case 2:
		game.setScreen(new Level02(game));
		break;
	    case 3:
		game.setScreen(new Level03(game));
		break;
	    case 4:
		game.setScreen(new PuzzleStage1(game));
		break;
	    case 5:
		game.setScreen(new Level04(game));
		break;
	    case 6:
		game.setScreen(new Level05(game));
		break;
	    case 7:
		game.setScreen(new Level06(game));
		break;
	    case 8:
		game.setScreen(new PuzzleStage2(game));
		break;
	    case 9:
		game.setScreen(new Level07(game));
		break;
	    case 10:
		game.setScreen(new Level08(game));
		break;
	    case 11:
		game.setScreen(new Level09(game));
		break;
	    case 12:
		game.setScreen(new PuzzleStage3(game));
		break;
	    case 13:
		game.setScreen(new Level10(game));
		break;
	    case 14:
		game.setScreen(new Level11(game));
		break;
	    case 15:
		game.setScreen(new Level12(game));
		break;
	    case 16:
		game.setScreen(new PuzzleStage4(game));
		break;
	    case 17:
		game.setScreen(new Level13(game));
		break;
	    case 18:
		game.setScreen(new Level14(game));
		break;
	    case 19:
		game.setScreen(new Level15(game));
		break;
	    case 20:
		game.setScreen(new PuzzleStage5(game));
		break;
	    default:
		currentScore = 0;
		currentStage = 0;
		game.setScreen(new IntroScreen(game));

	}
    }

    public static void save() {
	System.out.println("Saving settings file...");
	try {

	    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(Gdx.files.external("/.insider").write(false)));
	    out.write("" + currentStage + "\n");
	    out.write("" + currentScore + "\n");
	    for (int i = 0; i < 5; i++)
		out.write("" + highscores[i] + "\n");
	    out.close();
	} catch (Exception e) {
	    System.out.println("Error saving settings file! " + e);
	}
    }

    public static void sortHighscores() {
	int temp = currentScore;
	for (int i = 0; i < 5; i++)
	    if (temp > highscores[i]) {
		int s = temp;
		temp = highscores[i];
		highscores[i] = s;
	    }
    }
}
