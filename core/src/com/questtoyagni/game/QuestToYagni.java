/**
 * @author: Levent K
 */

package com.questtoyagni.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.questtoyagni.Board.Board;
import com.questtoyagni.Player.Player;
import com.questtoyagni.coordinates.Coordinate;
import com.questtoyagni.game.Screens.PlayScreen;

public class QuestToYagni extends Game {
	public SpriteBatch batch; 	//Public damit alles auf diesen SpriteBatch zugreift
								// weil für alles einen eigenen SpriteBatch zu erstellen ist sehr Rechenintensiv
	
	
	
	public static final int V_WIDTH = 1280;
	public static final int V_HEIGHT = 720;


	Texture img;
	Music music;
	PlayScreen playscreen;

	Board board;
	Player player;
	int boardwidth;
	int boardheight;

	public QuestToYagni(int boardwidth, int boardheight){
		this.boardwidth = boardwidth;
		this.boardheight = boardheight;
	}

	/**
	 * Initalisiert ein SpriteBatch worauf quasi die GUI gezeichnet wird. Außerdem wird das Menu Screen und die Musik initalisiert und geladen.
	 */
	@Override
	public void create () {
		//Game Logic
		this.board = new Board(boardwidth,boardheight);
		Coordinate start = board.getStartfieldCoordinates();
		this.player = new Player("Player", start,board);

		//GDX Logic
		batch = new SpriteBatch();
		this.playscreen = new PlayScreen(this);
		setScreen(this.playscreen);
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
