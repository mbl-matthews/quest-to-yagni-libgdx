package com.questtoyagni.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.questtoyagni.game.QuestToYagni;
import com.questtoyagni.game.Screnes.Hud;

public class PlayScreen implements Screen {
    private QuestToYagni game;
    Texture texture;
    private OrthographicCamera gamecam; //Für Viewport
    private Viewport gameport;
    private Hud hud;

    public PlayScreen(QuestToYagni game){
        this.game = game;
        texture = new Texture("logo_trans.png");
        gamecam = new OrthographicCamera();
        gameport = new FitViewport(QuestToYagni.V_WIDTH,QuestToYagni.V_HEIGHT,gamecam);
        hud = new Hud(game.batch);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.setProjectionMatrix(hud.stage.getCamera().combined); //Es soll nur das gerendert werden, was die Kamera sieht
        hud.stage.draw();
        game.batch.begin();
        game.batch.draw(texture,0,0,1920,1920);
        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {
        gameport.update(width,height);
    }

    @Override
    public void pause() {

    }

    public void update(float dt){
        hud.update(dt);
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
