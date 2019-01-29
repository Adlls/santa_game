package com.mygdx.game.desktop;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.MainGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Santa Clause vs gnomes";
		config.width = 800;
		config.height = 480;
		config.resizable = false;
		LwjglApplication lwapp = new LwjglApplication(new MainGame(), config);

	}
}
