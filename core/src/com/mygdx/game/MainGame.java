package com.mygdx.game;


import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.Viewport;


import javax.print.attribute.standard.PrinterStateReason;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;


public class MainGame extends Game  {

	SpriteBatch batch;
	SantaClaus santa;
	Cristmasbox cristmasbox;
	Hub hub;
	Texture backgroundTexture;
	Sprite backgroundSprite;
	Preferences pref;
	int score = 0;


	int deltaT = 10;
	Timer timer;

	private OrthographicCamera camera;
	private Viewport gamePort;







	private ArrayList<Cristmasbox> cristmasboxs = new ArrayList<Cristmasbox>();
    private long lastDropTimeBox;



	@Override
	public void create () {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);


		batch = new SpriteBatch();
		santa = new SantaClaus();

		cristmasbox = new Cristmasbox();
        backgroundTexture = new Texture("background.jpg");
        backgroundSprite = new Sprite(backgroundTexture);




		cristmasboxs = new ArrayList<Cristmasbox>();
		spawnBox();


         Gdx.input.setInputProcessor(santa);


        hub = new Hub(batch);

		batch.setProjectionMatrix(hub.stage.getCamera().combined);




		/*
		gamePort = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), gamecam);
		gamecam = new OrthographicCamera();
		gamecam.position.set(gamePort.getScreenWidth() / 2, gamePort.getScreenHeight() / 2, 0);




*/

	}

	@Override
	public void render() {
		update();
	    Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();

		backgroundSprite.draw(batch);

		santa.render(batch);

		resume();
		//cristmasbox.render(batch);

		//batch.draw(dropImage, raindrop.x, raindrop.y)


		for(Cristmasbox boxdrop: cristmasboxs) boxdrop.render(batch);


		if(TimeUtils.nanoTime() - lastDropTimeBox > 1000000000) {

            deltaT--;
            System.out.println(deltaT);
            hub.setTime(deltaT);
			spawnBox();
		}


		if (deltaT == 0) {

		//	santa.setPosition(new Vector2(0,0));
		//	for(Cristmasbox boxdrop: cristmasboxs) boxdrop.setPosition(new Vector2(0,0));


		}


		Iterator<Cristmasbox> iter = cristmasboxs.iterator();
		while(iter.hasNext()) {
			Cristmasbox boxdrop = iter.next();
			boxdrop.getPosition().y -= 200 * Gdx.graphics.getDeltaTime();
			if(boxdrop.getPosition().y + 64 < 0) iter.remove();

			//dropSound.play();
			//System.out.println("kek");

			if(santa.getRect().overlaps(boxdrop.getRect())) {
				score += 10;
			    hub.setTextScore(score);
				iter.remove();
			}




/*
			if (santa.getRect().getX() == boxdrop.getRect().getX() || santa.getRect().getY() == boxdrop.getRect().getY()) {
				System.out.println("kek");
				//santa.getPosition().y = land.getY();
			}
*/






		}
		batch.end();
		batch.setProjectionMatrix(hub.stage.getCamera().combined);
		hub.stage.draw();
	}


	private void spawnBox() {

		Cristmasbox boxdrop = new Cristmasbox();
		//boxdrop.setPosition(new Vector2(  MathUtils.random(0, 800-64),480));
		cristmasboxs.add(boxdrop);
		lastDropTimeBox = TimeUtils.nanoTime();
	}


	@Override
	public void dispose () {
		batch.dispose();

	}




	public void update() {


		if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {

		//camera.position.x += 100;
		}

		camera.update();
		santa.update();
		cristmasbox.update();

		/*

		for (int i = 0; i < countbox.length; i++) {
			countbox[i].update();
		}
		*/

	}







}
