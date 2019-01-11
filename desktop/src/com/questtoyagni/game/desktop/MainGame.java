/**
 * Initalisiert das Spiel mithilfe der libgdx-library
 * @author Levent K.
 */

package com.questtoyagni.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.questtoyagni.game.QuestToYagni;

public class MainGame {
	public static void mainGame (int width, int height, boolean fullscreen) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = width;
		config.height = height;
		config.fullscreen = fullscreen;
		new LwjglApplication(new QuestToYagni(), config);
	}
}