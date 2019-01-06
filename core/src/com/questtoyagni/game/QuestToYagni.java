/**
 * @author: Levent K
 */

package com.questtoyagni.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.questtoyagni.game.Screens.MenuScreen;
import com.questtoyagni.game.Screens.PlayScreen;

public class QuestToYagni extends Game {
	public SpriteBatch batch; 	//Public damit alles auf diesen SpriteBatch zugreift
								// weil für alles einen eigenen SpriteBatch zu erstellen ist sehr Rechenintensiv
	
	
	
	public static final int V_WIDTH = 1920;
	public static final int V_HEIGHT = 1080;


	Texture img;
	Music music;

	/**
	 * Initalisiert ein SpriteBatch worauf quasi die GUI gezeichnet wird. Außerdem wird das Menu Screen und die Musik initalisiert und geladen.
	 */
	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(new MenuScreen(this));
		music = Gdx.audio.newMusic(Gdx.files.internal("..\\core\\assets\\maintheme.mp3"));
	}

	/**
	 * Wird zum Programmstart ausgeführt. Kümmert sich um die Musik und darum, dass die GUI gerendert wird.
	 */
	@Override
	public void render () {
		super.render();
		music.setVolume(0.5f);
		music.setLooping(true);
		music.play();
	}

	/**
	 * Schafft Speicherplatz, indem die Methode dispose() ausgeführt wird, wenn Elemente nicht mehr benötigt werden.
	 */
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
