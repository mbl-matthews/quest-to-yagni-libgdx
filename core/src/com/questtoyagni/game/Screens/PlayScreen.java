package com.questtoyagni.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.questtoyagni.Board.Board;
import com.questtoyagni.game.QuestToYagni;
import com.questtoyagni.game.Scenes.GameOverlay;

/**
 * renders the play-screen
 * @author: Levent K
 */

public class PlayScreen implements Screen {
    private QuestToYagni game;
    Texture texture;
    private OrthographicCamera gamecam; //Für Viewport
    private Viewport gameport;
    private GameOverlay gameoverlay;
    Board board;
    ShapeRenderer shape;


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


        //For Schleife cumms here
        for(int i=0; i<this.game.getBoard().getWidth(); i++){
            for(int j=0; j<this.game.getBoard().getHeight(); j++){
                shape.rect((QuestToYagni.V_WIDTH/2)-kastengroesse*(i-0.5f),QuestToYagni.V_HEIGHT-kastengroesse*(j+1),kastengroesse-5,kastengroesse-5);
            }
        }

        shape.end();
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
