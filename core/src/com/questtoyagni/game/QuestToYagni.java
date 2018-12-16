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
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(new MenuScreen(this));
		music = Gdx.audio.newMusic(Gdx.files.internal("..\\core\\assets\\maintheme.mp3"));
	}

	@Override
	public void render () {
		super.render();
		music.setVolume(0.5f);
		music.setLooping(true);
		music.play();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
