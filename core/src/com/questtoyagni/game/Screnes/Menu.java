/**
 * @author: Levent K
 */

package com.questtoyagni.game.Screnes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.questtoyagni.game.QuestToYagni;

public class Menu {
    public Stage stage;
    private Viewport viewport;
    TextButton button;
    TextButton.TextButtonStyle textButtonStyle;
    BitmapFont font;
    Skin skin;
    TextureAtlas buttonAtlas;
    FileHandle file = Gdx.files.local("..\\core\\assets\\arial.fnt");

    public Menu(SpriteBatch sb){
        viewport = new FitViewport(QuestToYagni.V_WIDTH,QuestToYagni.V_WIDTH,new OrthographicCamera());
        stage = new Stage(viewport,sb);
        Gdx.input.setInputProcessor(stage);
        font = new BitmapFont(file);
        skin = new Skin();

        Table table = new Table();
        table.bottom().pad(50); //Tabelle wird zentriert ausgerichtet
        table.setFillParent(true); //Table hat größe der Stage

        textButtonStyle = new TextButton.TextButtonStyle();
        font.getData().setScale(5,10);
        textButtonStyle.font = font;
        textButtonStyle.fontColor = Color.BLACK;
        button = new TextButton("Start Game", textButtonStyle);
        table.add(button);


        //Tabelle zur Stage hinzurfügen
        stage.addActor(table);

    }

    public void update(){
    }
}
