package com.questtoyagni.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.questtoyagni.game.QuestToYagni;

/**
 * Initialises the game with libgdx-library
 * @author Levent K.
 */
public class MainGame {
	public static void mainGame (int width, int height, boolean fullscreen) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = width;
		config.height = height;
		config.fullscreen = fullscreen;
		LwjglApplication gameapplication = new LwjglApplication(new QuestToYagni(5,7), config);
	}
}
