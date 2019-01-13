package com.questtoyagni.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.questtoyagni.board.Board;
import com.questtoyagni.game.QuestToYagni;
import com.questtoyagni.game.scenes.GameOverlay;

/**
 * renders the play-screen
 * @author: Levent K
 */

public class PlayScreen implements Screen {
    private QuestToYagni game;
    private Texture texture;
    private OrthographicCamera gamecam; //Für Viewport
    private Viewport gameport;
    private GameOverlay gameoverlay;
    private Board board;
    private ShapeRenderer shape;
    private Sprite playerModel;

  /**
   * @param game QuestToYagni-object
   */
    public PlayScreen(QuestToYagni game){
        this.game = game;
        //System.out.println(new File("..\\core\\assets\\logo_trans.png"));
        texture = new Texture("..\\core\\assets\\logo_trans.png");
        gamecam = new OrthographicCamera();
        gameport = new FitViewport(QuestToYagni.V_WIDTH,QuestToYagni.V_HEIGHT,gamecam);
        gameoverlay = new GameOverlay(game.batch);
        playerModel = new Sprite(new Texture("..\\core\\assets\\player_coloured.png"));
        //System.out.println("W:"+pM.getWidth()+" H:"+pM.getHeight());
        //playerModel = new Sprite(pM);
        //System.out.println("W:"+playerModel.getWidth()+" H:"+playerModel.getHeight());
        shape = new ShapeRenderer();
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
        int kastengroesse=0;
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
        
        //initial draw of player
        playerModel.draw(game.batch);
        if(playerModel.getX() == 0.0f && playerModel.getY() == 0.0f) {
        	playerModel.setX(playerX);
        	playerModel.setY(playerY);
        }
        playerModel.setSize(kastengroesse*0.645f,kastengroesse);
        
        //controls
        if(Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
        	if(game.player.getCoordinates().getY() != 0) {
        		playerModel.translateY(kastengroesse);
        	}
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
        	if(game.player.getCoordinates().getY() != game.getBoard().getHeight()) {
        		playerModel.translateY(-kastengroesse);
        	}
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
        	if(game.player.getCoordinates().getX() != 0) {
        		playerModel.translateY(kastengroesse);
        	}
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
        	if(game.player.getCoordinates().getY() != game.getBoard().getWidth()) {
        		playerModel.translateY(kastengroesse);
        	}
        }
        
        game.batch.end();
        
        
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
