/**
 * @author: Levent K
 */

package com.questtoyagni.game.Screnes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.questtoyagni.game.QuestToYagni;

public class Hud {
    public Stage stage;
    private Viewport viewport;

    private Integer worldTimer;
    private float timeCount;

    Label levelLabel;
    Label worldLabel;
    Label countdownLabel;
    Label titleLabel;


    /**
     * Konstruktor
     * @param sb - SpriteBatch auf die das HUD abgebildet werden soll
     */
    public Hud(SpriteBatch sb){
        worldTimer = 60;
        timeCount = 0;

        viewport = new FitViewport(QuestToYagni.V_WIDTH,QuestToYagni.V_WIDTH,new OrthographicCamera());
        stage = new Stage(viewport,sb);

        Table table = new Table();
        table.top(); //Tabelle wird zum oberen Bildschirmrand gebracht
        table.setFillParent(true); //Table hat größe der Stage
        BitmapFont font = new BitmapFont();
        font.getData().setScale(3,7);
        countdownLabel = new Label(String.format("%03d",worldTimer), new Label.LabelStyle(font, Color.BLACK));
        titleLabel = new Label("QUEST TO YAGNI",new Label.LabelStyle(font, Color.BLACK));
        table.add(countdownLabel).expandX().padTop(1);
        table.add(titleLabel).expandX().padTop(1);

        //Tabelle zur Stage hinzurfügen
        stage.addActor(table);

    }

    /**
     * @param dt - Zeitdifferenz zwischen dem letzten Aufruf von update() und dem jetzigen
     */
    public void update(float dt){
        this.timeCount += dt;
        if(timeCount >= 1){
            worldTimer--;
            countdownLabel.setText(String.format("%03d",worldTimer));
        }
    }
}
