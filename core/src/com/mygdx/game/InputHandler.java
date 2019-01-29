package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;

public class InputHandler implements InputProcessor {



    InputHandler() {}

    public static boolean isClicked() {

      return Gdx.input.justTouched();

    }

    public static boolean isPressed() {

        return  Gdx.input.isTouched();
    }


    public static Vector2 getMousePosition() {

        return new Vector2(Gdx.input.getX(), Gdx.input.getY());
    }

    @Override
    public boolean keyDown(int keycode) {

      if (keycode == Input.Keys.ALT_RIGHT ) {
          System.out.println("true");
          return true;
      }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {

        /*
        switch(keycode)
        {
            case Input.Keys.LEFT:

                SantaClaus.leftMove = false;
                isStop = true;
                break;

            case Input.Keys.RIGHT:

                rightMove = false;
                isStop = true;
                break;
            case Input.Keys.UP:
                // jump(-100);
                upMove = false;
                isStop = true;
                PressedupMove = false;
        }
        return true;
        */
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

}

