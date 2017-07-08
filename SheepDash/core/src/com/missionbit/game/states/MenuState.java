package com.missionbit.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.missionbit.game.GameTutorial;

/**
 * Created by MissionBit on 6/22/17.
 */

public class MenuState extends State {


    private Texture background;
    private Texture playBtn;
    private Texture instBtn;
    private Stage stage;
    private Button buttonPlay;
    private Button buttonInst;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        background = new Texture("MenuScreen.png");
        playBtn = new Texture("PlayBtn.png");
        instBtn = new Texture("instBtn.png");
        stage = new Stage();
        buttonPlay = new Button();
        buttonPlay.setSize(playBtn.getWidth(), playBtn.getHeight());
        buttonPlay.setStyle(new Button.ButtonStyle());
        buttonPlay.getStyle().up = new TextureRegionDrawable(new TextureRegion(playBtn));
        buttonPlay.getStyle().down = new TextureRegionDrawable(new TextureRegion(playBtn));
        buttonPlay.setPosition((float)(GameTutorial.WIDTH - playBtn.getWidth()) / 2, (GameTutorial.HEIGHT - (playBtn.getHeight()))*4/7);
        Gdx.input.setInputProcessor(stage);
        /*buttonPlay.addListener(new ClickListener() {
            @Override
            public boolean click (Event event) {
                System.out.println("it works");
                return false;
            }
        });*/
        buttonInst = new Button();
        buttonInst.setSize(instBtn.getWidth(), instBtn.getHeight());
        buttonInst.setStyle(new Button.ButtonStyle());
        buttonInst.getStyle().up = new TextureRegionDrawable(new TextureRegion(instBtn));
        buttonInst.getStyle().down = new TextureRegionDrawable(new TextureRegion(instBtn));
        buttonInst.setPosition((float)(GameTutorial.WIDTH - instBtn.getWidth()) / 2, (GameTutorial.HEIGHT - (instBtn.getHeight()))*2/7);
        stage.addActor(buttonPlay);
        stage.addActor(buttonInst);
    }

    @Override
    public void handleInput() {

    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background, 0, 0, GameTutorial.WIDTH, GameTutorial.HEIGHT);
        //sb.draw(playBtn, () / 2);
        sb.end();
        stage.draw();
    }

    @Override
    public void dispose() {
        background.dispose();
        playBtn.dispose();
    }
}
