/**
 * @author: Levent K
 */

package com.questtoyagni.game.Scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.questtoyagni.game.QuestToYagni;
import com.questtoyagni.game.Screens.PlayScreen;

public class Menu {
    public Stage stage;
    private Viewport viewport;
    TextButton button;
    TextButton.TextButtonStyle textButtonStyle;
    BitmapFont font;
    Skin skin;
    TextureAtlas buttonAtlas;
    FileHandle file = Gdx.files.local("..\\core\\assets\\arial.fnt");

    /**
     * @param sb - SpriteBatch auf welchem das Hauptmenü abgebildet werden soll
     */
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
        button.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("not pressed");
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("pressed");
                return true;
            }
        });


        //Tabelle zur Stage hinzurfügen
        stage.addActor(table);

    }

    public void update(){
    }
}
