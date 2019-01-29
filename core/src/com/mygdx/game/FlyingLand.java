package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

import java.util.Random;

public class FlyingLand {

    private Texture land;
    private Random rand;
    private Rectangle rect;
    private float x;
    private float y;


    public FlyingLand(float x, float y) {

        this.x = x;
        this.y = y;
        rect = new Rectangle(x,y,land.getWidth(),land.getHeight());
        rect.setPosition(x,y);

    }


    public Texture getLand() {
        return land;
    }

    public Random getRand() {
        return rand;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public Rectangle getRect() {
        return rect;
    }
}
