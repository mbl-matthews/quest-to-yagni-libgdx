/**
 * @author: Levent K
 */

package com.questtoyagni.game.Screens;

import java.io.File;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.questtoyagni.game.QuestToYagni;
import com.questtoyagni.game.Screnes.Menu;

public class MenuScreen implements Screen {
    private QuestToYagni game;
    Texture texture;
    private OrthographicCamera gamecam; //Für Viewport
    private Viewport gameport;
    private Menu menu;

    /**
     * MenuScreen Konstruktor
     * */
    public MenuScreen(QuestToYagni game){
        this.game = game;
        //System.out.println(new File("..\\core\\assets\\logo_trans.png"));
        texture = new Texture("..\\core\\assets\\logo_trans.png");
        gamecam = new OrthographicCamera();
        gameport = new FitViewport(QuestToYagni.V_WIDTH,QuestToYagni.V_HEIGHT,gamecam);
        menu = new Menu(game.batch);
    }

    @Override
    public void show() {

    }

    /**
     * @param delta - Zeitdifferenz zwischen dem letzten Aufruf von render() und dem jetzigen
     */
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.setProjectionMatrix(gamecam.combined); //Es soll nur das gerendert werden, was die Kamera sieht
        menu.stage.draw();
        game.batch.begin();
        game.batch.draw(texture,0,500,1920,1920);
        game.batch.end();
    }

    /**
     * Aktualisiert das Bild, wenn die Größe des Fensters verändert wird
     * @param width  -  neue Bildschirmbreite
     * @param height -  neue Bildschirmhöhe
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

    }
}
