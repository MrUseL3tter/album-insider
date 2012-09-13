package com.noobs2d.insider;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;

public class AlbumInsiderDesktop {

    public static void main(String[] args) {
	new LwjglApplication(new AlbumInsider(), "Album Insider", Settings.WIDTH, Settings.HEIGHT, false);
    }

}
