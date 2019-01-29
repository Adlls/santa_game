package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;




public class SantaClaus implements InputProcessor {

    private  static Vector2 position;
    private  static Vector2 velocity;


    private static final int FRAME_COLS = 4; //#1
    private static final int FRAME_ROWS = 4; //#2
    private static  Texture texture_santa;
    private static int WIDTH_SANTA;
    private static int HEIGHT_SANTA;

    private Animation walkAnimation; //#3
    private TextureRegion[] walkFrames; //#4
    private static TextureRegion currentFrame; //#5
    private InputHandler inputHandler; //#6
    private float stateTime; //#7
    private Rectangle rect;

    private static boolean leftMove;
    private static boolean rightMove;
    private static boolean upMove;
    private static boolean isStop = true;
    private static boolean TurnMoveleft;
    private static boolean TurnMoveright = true;
    private static boolean TurnMoveUp;
    private static boolean TurnMoveDown = false;
    private static boolean looping = false;



    SantaClaus() {

        this.position = new Vector2(0,0);
        this.velocity = new Vector2(5,5);

        texture_santa = new Texture(Gdx.files.internal("santaclaus.jpg"));
        WIDTH_SANTA = texture_santa.getWidth()/FRAME_ROWS;
        HEIGHT_SANTA = texture_santa.getHeight()/FRAME_COLS;
        rect = new Rectangle(position.x,position.y,WIDTH_SANTA,HEIGHT_SANTA);
        Gdx.input.setInputProcessor(this);
        runAnimation();
    }



    public void runAnimation() {

        TextureRegion[][] tmp = TextureRegion.split(texture_santa, WIDTH_SANTA, HEIGHT_SANTA);

        walkFrames = new TextureRegion[FRAME_COLS*FRAME_ROWS];

        int index = 0;
        for (int i = 0; i < FRAME_ROWS; i++) {
            for (int j = 0; j < FRAME_COLS; j++) {
                walkFrames[index++] = tmp[i][j];
            }
        }

        walkAnimation = new Animation(0.02f,walkFrames);
        currentFrame = (TextureRegion) walkAnimation.getKeyFrame(stateTime);
    }




    public void render(SpriteBatch batch) {


        System.out.println(position.x);

        stateTime +=  Gdx.graphics.getDeltaTime(); //#12
        batch.draw(currentFrame, position.x,position.y,WIDTH_SANTA,HEIGHT_SANTA);
        currentFrame = (TextureRegion) walkAnimation.getKeyFrame(stateTime, looping);

        if (isStop) { looping = false; }
        else { looping = true; }

        if (TurnMoveleft && WIDTH_SANTA > 0) {

            //Чтобы повернуть Санту, надо задать отрицательную ширину и прибавить к position.x ширину Санты.

                //Важно position.x задать до того как я напишу отрицательную длинну
                position.x = position.x + WIDTH_SANTA;
                WIDTH_SANTA = -1*WIDTH_SANTA;
        }
        if (TurnMoveright && WIDTH_SANTA < 0) {

                WIDTH_SANTA = -1*WIDTH_SANTA;
                position.x = position.x - WIDTH_SANTA;
        }

        if (TurnMoveDown) { MoveDown();}
        if (TurnMoveUp) {MoveUp();}



       if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {upMove = true;}

       rect.setPosition(position.x,position.y);


       /*
        if(position.x < 0) position.x = Gdx.graphics.getWidth() - WIDTH_SANTA;
        if(position.x >  Gdx.graphics.getWidth()) position.x = WIDTH_SANTA;
*/



       if (position.x >= Gdx.graphics.getWidth() - WIDTH_SANTA) {

           position.x = Gdx.graphics.getWidth() - WIDTH_SANTA;
       }



       /*
       if (position.x <= Gdx.graphics.getWidth()) {
           position.x = -Gdx.graphics.getWidth() + WIDTH_SANTA;
       }
*/





    }


    public void MoveDown() {

        if (position.y != 0) {position.add(0,-velocity.y);}
        if (position.y  <= 0) {position.y = 0;}
        TurnMoveUp = false;
    }

    public void MoveUp() {
        //position.y += 15;
        //position.add(0,velocity.y+50);

        while (position.y <= 150) {
           // position.add(0,velocity.y-4);
            position.y = position.y + 0.5f;
            //position.add(0,velocity.y);
        }

        //if (position.y == 50) {position.y = 50;}
        TurnMoveDown = false;
        upMove = false;
    }

    public void update() {

        if (leftMove) {
            position.add(-velocity.x,0);
            TurnMoveleft = true;
            TurnMoveright = false;

        }

        if (rightMove) {
            position.add(velocity.x,0);
            TurnMoveleft = false;
            TurnMoveright = true;


        }

        if (upMove) {
            TurnMoveDown = false;
            TurnMoveUp = true;

        }

        if (!upMove) {
            TurnMoveDown = true;
            TurnMoveUp = false;
        }


       // System.out.print(position.x+" ");
       // System.out.println(position.y);


     }




    public static Texture getTexture_santa() {
        return texture_santa;
    }

    public Vector2 getPosition() {
        return position;
    }

    public Vector2 getVelocity() {
        return velocity;
    }



    public static int getFrameCols() {
        return FRAME_COLS;
    }

    public static int getFrameRows() {
        return FRAME_ROWS;
    }

    public Animation getWalkAnimation() {
        return walkAnimation;
    }

    public TextureRegion[] getWalkFrames() {
        return walkFrames;
    }

    public TextureRegion getCurrentFrame() {
        return currentFrame;
    }

    public InputHandler getInputHandler() {
        return inputHandler;
    }

    public float getStateTime() {
        return stateTime;
    }
    public Rectangle getRect() {
        return rect;
    }

    public static boolean isLeftMove() {
        return leftMove;
    }

    public static boolean isRightMove() {
        return rightMove;
    }


    public static int getWidthSanta() {
        return WIDTH_SANTA;
    }

    public static int getHeightSanta() {
        return HEIGHT_SANTA;
    }

    public static boolean isUpMove() {
        return upMove;
    }



    public static boolean isIsStop() {
        return isStop;
    }

    public static boolean isTurnMoveleft() {
        return TurnMoveleft;
    }

    public static boolean isTurnMoveright() {
        return TurnMoveright;
    }

    public static boolean isTurnMoveUp() {
        return TurnMoveUp;
    }

    public static boolean isTurnMoveDown() {
        return TurnMoveDown;
    }

    public static boolean isLooping() {
        return looping;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
    }


    public void setWalkAnimation(Animation walkAnimation) {
        this.walkAnimation = walkAnimation;
    }

    public void setWalkFrames(TextureRegion[] walkFrames) {
        this.walkFrames = walkFrames;
    }

    public void setCurrentFrame(TextureRegion currentFrame) {
        this.currentFrame = currentFrame;
    }

    public void setInputHandler(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public void setStateTime(float stateTime) {
        this.stateTime = stateTime;
    }



    public void jump(float y) {
        position.y += y;
    }


    public  void setLeftMove(boolean t) {
        if(rightMove && t) rightMove = false;
        leftMove = t;
    }
    public  void setRightMove(boolean t) {
        if(leftMove && t) leftMove = false;
        rightMove = t;
    }






    //обработка событий

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode)
        {
            case Input.Keys.LEFT:
                leftMove = true;
                isStop = false;
                break;
            case Input.Keys.RIGHT:
                rightMove = true;
                isStop = false;
                break;
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
         switch(keycode)
        {
            case Input.Keys.LEFT:

                leftMove = false;
                isStop = true;
                break;
            case Input.Keys.RIGHT:
                rightMove = false;
                isStop = true;
                break;


        }
        return true;
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
