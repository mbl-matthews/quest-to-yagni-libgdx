package com.questtoyagni.game.screens;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.questtoyagni.coordinates.Directions;
import com.questtoyagni.event.Event;
import com.questtoyagni.field.Eventfield;
import com.questtoyagni.field.Finishfield;
import com.questtoyagni.field.Playfield;
import com.questtoyagni.game.QuestToYagni;
import com.questtoyagni.game.sceenes.GameOverlay;

/**
 * renders the play-screen
 * @author Levent K
 */

public class PlayScreen implements Screen {
    private QuestToYagni game;
    private Texture texture;
    private OrthographicCamera gamecam; //Für Viewport
    private Viewport gameport;
    private ShapeRenderer shape;
    private Sprite playerModel;
    private int kastengroesse;
    private int finish = 0;
    private BitmapFont font;
    private String displayMsg = "";
    private GameOverlay gameoverlay;

  /**
   * @param game QuestToYagni-object
   */
    public PlayScreen(QuestToYagni game){
        this.game = game;
        texture = new Texture("..\\core\\assets\\logo_trans.png");
        gamecam = new OrthographicCamera();
        gameport = new FitViewport(QuestToYagni.V_WIDTH,QuestToYagni.V_HEIGHT,gamecam);
        gameoverlay = new GameOverlay(game.batch);
        playerModel = new Sprite(new Texture("..\\core\\assets\\player_coloured.png"));
        shape = new ShapeRenderer();
        font = new BitmapFont(Gdx.files.local("..\\core\\assets\\arial.fnt"),false);
    }

    @Override
    public void show() {

    }

    /**
     * @param delta - time-difference between last render() call and actual call
     */
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        game.batch.setProjectionMatrix(gamecam.combined); //Es soll nur das gerendert werden, was die Kamera sieht
        gameoverlay.stage.draw();
        game.batch.begin();
        game.batch.draw(texture,0,0,200,200);
        game.batch.end();

        shape.begin(ShapeRenderer.ShapeType.Filled);
        shape.setColor(new Color(0.3f,0.3f,0.3f,1));
        //Kästchengröße berechnen
        kastengroesse=0;
        if(QuestToYagni.V_WIDTH<QuestToYagni.V_HEIGHT){
            if(this.game.getBoard().getWidth()<this.game.getBoard().getHeight()){
                kastengroesse = QuestToYagni.V_WIDTH/this.game.getBoard().getHeight();
            }else {
                kastengroesse = QuestToYagni.V_WIDTH/this.game.getBoard().getWidth();
            }
        }else {
            if(this.game.getBoard().getWidth()<this.game.getBoard().getHeight()){
                kastengroesse = QuestToYagni.V_HEIGHT/this.game.getBoard().getHeight();
            }else {
                kastengroesse = QuestToYagni.V_HEIGHT/this.game.getBoard().getWidth();
            }
        }

        int boardwidth=this.game.getBoard().getWidth();
        //For Schleife cumms here
        for(int i=0; i<this.game.getBoard().getWidth(); i++){
            for(int j=0; j<this.game.getBoard().getHeight(); j++){
                shape.rect(((QuestToYagni.V_WIDTH/2)-(boardwidth/2)*kastengroesse)+kastengroesse*i,QuestToYagni.V_HEIGHT-kastengroesse*(j+1),kastengroesse-5,kastengroesse-5);
            }
        }

        shape.end();
        
        float playerX = (((QuestToYagni.V_WIDTH/2)-(boardwidth/2)*kastengroesse)+kastengroesse*game.player.getCoordinates().getX())+15;
        float playerY = QuestToYagni.V_HEIGHT-kastengroesse*(game.player.getCoordinates().getY()-2)-20;
        
        game.batch.begin();
        
        font.setColor(Color.BLACK);
        font.draw(game.batch,splitTextInLines(displayMsg,30),20,QuestToYagni.V_HEIGHT);
        font.getData().setScale(0.75f, 1f);
        
        //initial draw of player
        playerModel.draw(game.batch);
        if(playerModel.getX() == 0.0f && playerModel.getY() == 0.0f) {
        	playerModel.setX(playerX);
        	playerModel.setY(playerY);
        }
        playerModel.setSize(kastengroesse*0.645f,kastengroesse);
        
        //controls
        if(finish == 0) {
	        if(Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
	        	if(game.player.move(Directions.NORTH.toString())) {
                    playerModel.translateY(kastengroesse*1.78f);
	        		finish = handleEvent();
	        	}
	        }
	        if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
	        	if(game.player.move(Directions.SOUTH.toString())) {
	        		playerModel.translateY(-kastengroesse*1.78f);
	        		finish = handleEvent();
	        	}
	        }
	        if(Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
	        	if(game.player.move(Directions.WEST.toString())) {
	        		playerModel.translateX(-kastengroesse);
	        		finish = handleEvent();
	        	}
	        }
	        if(Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
	        	if(game.player.move(Directions.EAST.toString())) {
	        		playerModel.translateX(kastengroesse);
	        		finish = handleEvent();
	        	}
	        }
        }
        
        game.batch.end();
        
        
    }
    
    /**
     * Handles the event that could be triggered after moving on the field
     * @return returns 1 if the finishfield was trigger, 0 if not
     */
    private int handleEvent() {
    	
    	if(game.board.getField(game.player.getPosition()).getType().equals(Finishfield.type)) {
        	Finishfield finish=(Finishfield) game.board.getField(game.player.getPosition());
        	Event event=finish.getEvent();
        	String msg=event.triggerEvent(game.player, game.board);
        	
        	displayMsg = msg;
        	
        	return 1;
        } else if(game.board.getField(game.player.getPosition()).getType().equals(Eventfield.type)) {
        	int boardwidth=this.game.getBoard().getWidth();
            
        	Eventfield eventfield=(Eventfield) game.board.getField(game.player.getPosition());
        	Event event=eventfield.getEvent();
        	String msg=event.triggerEvent(game.player, game.board);
        	
        	float playerX = ((QuestToYagni.V_WIDTH/2)-(boardwidth/2)*kastengroesse)+(kastengroesse*game.player.getCoordinates().getX());
            float playerY = QuestToYagni.V_HEIGHT-kastengroesse*(game.player.getCoordinates().getY()+1);
            System.out.println(game.player.getCoordinates().getX()+" "+game.player.getCoordinates().getY()+"\nX:"+playerX+" Y:"+playerY);
            
            displayMsg = msg;
            
            playerModel.setX(playerX+15);
            playerModel.setY(playerY*1.78f+2*20);
        } else if(game.board.getField(game.player.getPosition()).getType().equals(Playfield.type)) {
        	displayMsg = "";
        }
        return 0;
    }
    
    /**
     * Splits a given line of text into multiple lines after the length of the given numberOfCharacters is exceeded.
     * For exmaple:
     * splitTextInLines("This is a line of text with words",5); would return
     * "This is
     * a line
     * of text
     * with words"
     * 
     * @param text The text that will be split
     * @param numberOfCharacters The number of Characters after the line will be split
     */
    private String splitTextInLines(String text, int numberOfCharacters) {
    	String[] tokens = text.split(" ");
    	ArrayList<String> msg = new ArrayList<String>();
    	StringBuilder sb = new StringBuilder("");
    	for(int i = 0; i<tokens.length;i++) {
    		String token = tokens[i];
    		sb.append(token+" ");
    		if(sb.toString().trim().length()>=numberOfCharacters) {
    			sb.append("\n");
    			msg.add(sb.toString());
    			sb.setLength(0);
    		} else if(i==tokens.length-1) {
    			msg.add(sb.toString());
    		}
    	}
    	
    	StringBuilder finalText = new StringBuilder("");
    	for(String line : msg) {
    		finalText.append(line);
    	}
    	
    	return finalText.toString();
    }
    
    /**
     * refreshes the screen, if window-size is changed
     * @param width  -  new screen-width
     * @param height -  new screen-height
     */
    @Override
    public void resize(int width, int height) {
        gameport.update(width,height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        shape.dispose();
    }
}
