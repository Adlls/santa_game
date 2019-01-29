package com.mygdx.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;





public class Hub {
    public Stage stage;
    public Viewport viewport;

    private static Integer score;
    private Integer timeCount;
    private Integer WorldTimer;

    Label scoreLabel;
    Label countdownLabel;
    Label timeLabel;
    Label levelLabel;
    Label worldLabel;
    Label santaLabel;


    public Hub(SpriteBatch batch) {
        WorldTimer = 300;
        timeCount = 0;
        score = 0;

        viewport = new FitViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight(), new OrthographicCamera());
        stage = new Stage(viewport,batch);

        Table table = new Table();
        table.top();
        table.setFillParent(true);


         scoreLabel =  new Label(String.format("0", score), new Label.LabelStyle(new BitmapFont(), Color.WHITE)) ;
         countdownLabel = new Label(String.format("%03d", WorldTimer), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
         timeLabel =  new Label("TIME", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
         levelLabel = new Label("1-1", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
         worldLabel = new Label("PILOT", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
         santaLabel = new Label("SANTA", new Label.LabelStyle(new BitmapFont(), Color.WHITE));

         //scoreLabel.setText("100");

         table.add(santaLabel).expandX().padTop(10);
         table.add(worldLabel).expandX().padTop(10);
         table.add(timeLabel).expandX().padTop(10);
         table.row();
         table.add(scoreLabel).expandX();
         table.add(levelLabel).expandX();
        table.add(countdownLabel).expandX();





        stage.addActor(table);


    }


    public static Integer getScore() {
        return score;
    }

    public static void setScore(Integer score) {
        Hub.score = score;
    }


    public void setTextScore(int score) {
        scoreLabel.setText(""+score);
    }

    public void setTime(int time) {
        countdownLabel.setText(""+time);
    }



}
