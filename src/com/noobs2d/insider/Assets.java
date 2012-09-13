package com.noobs2d.insider;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;

public class Assets {

    static Texture conclusion;
    static Texture filler;
    static Texture instruction;
    static Texture intro;
    static Texture lvl1;
    static Texture lvl2;
    static Texture lvl3;
    static Texture lvl4;
    static Texture lvl5;
    static Texture lvl6;
    static Texture lvl7;
    static Texture lvl8;
    static Texture lvl9;
    static Texture lvl10;
    static Texture lvl11;
    static Texture lvl12;
    static Texture lvl13;
    static Texture lvl14;
    static Texture lvl15;
    static Texture mainMenu;
    static Texture ninePatch;
    static Texture puzzle;
    static Texture puzzle1;
    static Texture puzzle2;
    static Texture trajanPro28;
    static Texture trajanPro35;
    static Texture trajanPro42;
    static Texture verdana24;

    static Sound correct;
    static Sound wrong;
    static Sound start;
    static Sound over;
    static Music bgm;

    public static void dispose() {
	conclusion.dispose();
	filler.dispose();
	intro.dispose();
	mainMenu.dispose();
	ninePatch.dispose();
	puzzle.dispose();
	trajanPro28.dispose();
	trajanPro35.dispose();
	trajanPro42.dispose();
	verdana24.dispose();
	correct.dispose();
	wrong.dispose();
	start.dispose();
	over.dispose();
	bgm.dispose();
    }

    public static void load() {
	conclusion = new Texture(Gdx.files.internal("data/gfx/FINAL.png"));
	conclusion.setFilter(TextureFilter.Linear, TextureFilter.Linear);

	filler = new Texture(Gdx.files.internal("data/gfx/FILLER.png"));

	instruction = new Texture(Gdx.files.internal("data/gfx/INSTRUCTION.png"));
	instruction.setFilter(TextureFilter.Linear, TextureFilter.Linear);

	intro = new Texture(Gdx.files.internal("data/gfx/INTRO.png"));
	intro.setFilter(TextureFilter.Linear, TextureFilter.Linear);

	//	lvl1 = new Texture(Gdx.files.internal("data/gfx/LEVEL1_TEXTURE.png"));
	//	lvl1.setFilter(TextureFilter.Linear, TextureFilter.Linear);
	//	lvl2 = new Texture(Gdx.files.internal("data/gfx/LEVEL2_TEXTURE.png"));
	//	lvl2.setFilter(TextureFilter.Linear, TextureFilter.Linear);
	//	lvl3 = new Texture(Gdx.files.internal("data/gfx/LEVEL3_TEXTURE.png"));
	//	lvl3.setFilter(TextureFilter.Linear, TextureFilter.Linear);
	//	lvl4 = new Texture(Gdx.files.internal("data/gfx/LEVEL4_TEXTURE.png"));
	//	lvl4.setFilter(TextureFilter.Linear, TextureFilter.Linear);
	//	lvl5 = new Texture(Gdx.files.internal("data/gfx/LEVEL5_TEXTURE.png"));
	//	lvl5.setFilter(TextureFilter.Linear, TextureFilter.Linear);
	//	lvl6 = new Texture(Gdx.files.internal("data/gfx/LEVEL6_TEXTURE.png"));
	//	lvl6.setFilter(TextureFilter.Linear, TextureFilter.Linear);
	//	lvl7 = new Texture(Gdx.files.internal("data/gfx/LEVEL7_TEXTURE.png"));
	//	lvl7.setFilter(TextureFilter.Linear, TextureFilter.Linear);
	//	lvl8 = new Texture(Gdx.files.internal("data/gfx/LEVEL8_TEXTURE.png"));
	//	lvl8.setFilter(TextureFilter.Linear, TextureFilter.Linear);
	//	lvl9 = new Texture(Gdx.files.internal("data/gfx/LEVEL9_TEXTURE.png"));
	//	lvl9.setFilter(TextureFilter.Linear, TextureFilter.Linear);
	//	lvl10 = new Texture(Gdx.files.internal("data/gfx/LEVEL10_TEXTURE.png"));
	//	lvl10.setFilter(TextureFilter.Linear, TextureFilter.Linear);
	//	lvl11 = new Texture(Gdx.files.internal("data/gfx/LEVEL11_TEXTURE.png"));
	//	lvl11.setFilter(TextureFilter.Linear, TextureFilter.Linear);
	//	lvl12 = new Texture(Gdx.files.internal("data/gfx/LEVEL12_TEXTURE.png"));
	//	lvl12.setFilter(TextureFilter.Linear, TextureFilter.Linear);
	//	lvl13 = new Texture(Gdx.files.internal("data/gfx/LEVEL13_TEXTURE.png"));
	//	lvl13.setFilter(TextureFilter.Linear, TextureFilter.Linear);
	//	lvl14 = new Texture(Gdx.files.internal("data/gfx/LEVEL14_TEXTURE.png"));
	//	lvl14.setFilter(TextureFilter.Linear, TextureFilter.Linear);
	//	lvl15 = new Texture(Gdx.files.internal("data/gfx/LEVEL15_TEXTURE.png"));
	//	lvl15.setFilter(TextureFilter.Linear, TextureFilter.Linear);

	mainMenu = new Texture(Gdx.files.internal("data/gfx/MAINMENU.png"));
	mainMenu.setFilter(TextureFilter.Linear, TextureFilter.Linear);

	ninePatch = new Texture(Gdx.files.internal("data/gfx/NINEPATCH.png"));
	ninePatch.setFilter(TextureFilter.Linear, TextureFilter.Linear);

	puzzle = new Texture(Gdx.files.internal("data/gfx/PUZZLE.png"));
	puzzle.setFilter(TextureFilter.Linear, TextureFilter.Linear);

	puzzle1 = new Texture(Gdx.files.internal("data/gfx/PUZZLES1.png"));
	puzzle1.setFilter(TextureFilter.Linear, TextureFilter.Linear);

	puzzle2 = new Texture(Gdx.files.internal("data/gfx/PUZZLES2.png"));
	puzzle2.setFilter(TextureFilter.Linear, TextureFilter.Linear);

	trajanPro28 = new Texture(Gdx.files.internal("data/fonts/TRAJANPRO28.png"));
	trajanPro28.setFilter(TextureFilter.Linear, TextureFilter.Linear);
	trajanPro35 = new Texture(Gdx.files.internal("data/fonts/TRAJANPRO35.png"));
	trajanPro35.setFilter(TextureFilter.Linear, TextureFilter.Linear);
	trajanPro42 = new Texture(Gdx.files.internal("data/fonts/TRAJANPRO42.png"));
	trajanPro42.setFilter(TextureFilter.Linear, TextureFilter.Linear);

	verdana24 = new Texture(Gdx.files.internal("data/fonts/VERDANA24.png"));
	verdana24.setFilter(TextureFilter.Linear, TextureFilter.Linear);

	correct = Gdx.audio.newSound(Gdx.files.internal("data/sfx/CHIME.ogg"));
	wrong = Gdx.audio.newSound(Gdx.files.internal("data/sfx/WRONG.ogg"));
	over = Gdx.audio.newSound(Gdx.files.internal("data/sfx/GAMEOVER.mp3"));
	start = Gdx.audio.newSound(Gdx.files.internal("data/sfx/START.mp3"));
	bgm = Gdx.audio.newMusic(Gdx.files.internal("data/sfx/BACKGROUND.mp3"));
    }
}
