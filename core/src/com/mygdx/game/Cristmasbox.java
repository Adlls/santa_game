package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;


public class Cristmasbox  {
    private Vector2 velocity;
    private Vector2 position;
    private Texture texture;
    private Rectangle rect;

    private final int WIDTH_BOX = 30;
    private final int HEIGHT_BOX = 30;

     //ArrayList<Rectangle> cristmasbox;

    private long lastDropTime;




    public Cristmasbox() {

        this.position = new Vector2(50 + (int) (Math.random() * Gdx.graphics.getWidth() - 50), Gdx.graphics.getHeight());
        this.velocity = new Vector2(-3,-3);
        rect = new Rectangle(position.x,position.y,WIDTH_BOX,HEIGHT_BOX);
        texture = new Texture((Gdx.files.internal("christmasbox.png")));
       // cristmasbox = new ArrayList<Rectangle>();
       // spawnBox();

    }



    public void render(SpriteBatch batch) {

        batch.draw(texture,position.x,position.y,WIDTH_BOX,HEIGHT_BOX);
       // if(TimeUtils.nanoTime() - lastDropTime > 1000000000) spawnBox();
        rect.setPosition(position.x,position.y);

    }



    public void update() {
        position.add(0,velocity.y);


    }


/*
    private void spawnBox() {
        Rectangle raindrop = new Rectangle();
        raindrop.x = MathUtils.random(0, 800-64);
        raindrop.y = 480;
        raindrop.width = WIDTH_BOX;
        raindrop.height = HEIGHT_BOX;
        cristmasbox.add(raindrop);
        lastDropTime = TimeUtils.nanoTime();
    }
*/

    public Vector2 getVelocity() {
        return velocity;
    }

    public Vector2 getPosition() {
        return position;
    }

    public Texture getTexture() {
        return texture;
    }

    public Rectangle getRect() {
        return rect;
    }

    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }


    public void setRect(Rectangle rect) {
        this.rect = rect;
    }
}



