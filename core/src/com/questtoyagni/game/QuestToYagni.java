package com.questtoyagni.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.questtoyagni.board.Board;
import com.questtoyagni.coordinates.Coordinate;
import com.questtoyagni.game.screens.PlayScreen;
import com.questtoyagni.player.Player;

/**
 * main-screen shows actual state of the game-logic and controls the board
 * @author: Levent K
 */

public class QuestToYagni extends Game {
	public SpriteBatch batch; 	//Public damit alles auf diesen SpriteBatch zugreift
								// weil für alles einen eigenen SpriteBatch zu erstellen ist sehr Rechenintensiv
	
	
	
	public static final int V_WIDTH = 1280;
	public static final int V_HEIGHT = 720;


	Music music;
	PlayScreen playscreen;

	public Board board;
	public Player player;
	int boardwidth;
	int boardheight;

	public QuestToYagni(int boardwidth, int boardheight){
		this.boardwidth = boardwidth;
		this.boardheight = boardheight;
	}

	/**
	 * initializes a SpriteBatch on which the GUI is drawn. 
	 * also loads and initializes the Menu Screen and the music.
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
	 * runs at program-start, it controls the music and renders  the GUI
	 */
	@Override
	public void render () {
		super.render();
		music.setVolume(0.5f);
		music.setLooping(true);
		//music.play();
	}

	/**
	 * creates memory-space by calling the dispose() method, if the elements are not in use anymore
	 */
	@Override
	public void dispose () {
		batch.dispose();
	}

	/**
	 * @return board
	 */
    public Board getBoard() {
        return this.board;
    }
}
