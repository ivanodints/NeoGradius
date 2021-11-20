package ru.gradius.screen.impl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import ru.gradius.screen.BaseScreen;

public class MenuScreen extends BaseScreen {

    private Texture spaceShip;
    private Texture space;
    private Vector2 touch;
    private Vector2 startPoint;

    private Vector2 positiveVector;
    private Vector2 negativeVector;

    private Vector2 positiveXvector;
    private Vector2 negativeXvector;

    private Vector2 positiveYvector;
    private Vector2 negativeYvector;

    private Vector2 positiveXnegativeYvector;
    private Vector2 positiveYnegativeXvector;

    @Override
    public void show() {

        super.show();
        space = new Texture("warp.png");
        spaceShip = new Texture("thunderhawk-gunship.png");
        touch = new Vector2();
        startPoint = new Vector2(0,0);

        positiveVector = new Vector2(1,1);
        negativeVector = new Vector2(-1,-1);

        positiveXvector = new Vector2(1,0);
        negativeXvector = new Vector2(-1,0);

        positiveYvector = new Vector2(0,1);
        negativeYvector = new Vector2(0,-1);

        positiveXnegativeYvector = new Vector2(1,-1);
        positiveYnegativeXvector = new Vector2(-1,1);
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        batch.begin();
        batch.draw(space, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.draw(spaceShip, startPoint.x, startPoint.y);
        batch.end();

        if(startPoint.x != touch.x && startPoint.y != touch.y){

                if (startPoint.x < touch.x && startPoint.y < touch.y) {
                    startPoint.add(positiveVector);
                } else if (startPoint.x > touch.x && startPoint.y < touch.y){
                    startPoint.add(positiveYnegativeXvector);
                } else if (startPoint.x < touch.x && startPoint.y > touch.y) {
                    startPoint.add(positiveXnegativeYvector);
                } else {
                    startPoint.add(negativeVector);
                }

        } else if (startPoint.x != touch.x && startPoint.y == touch.y) {

            if (startPoint.x < touch.x) {
                startPoint.add(positiveXvector);
            } else {
                startPoint.add(negativeXvector);
            }

        } else if (startPoint.x == touch.x && startPoint.y != touch.y) {

            if (startPoint.y < touch.y) {
                startPoint.add(positiveYvector);
            } else {
                startPoint.add(negativeYvector);
            }
        }
    }

    @Override
    public void dispose() {
        super.dispose();
        spaceShip.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        touch.set(screenX, Gdx.graphics.getHeight() - screenY);
        return super.touchDown(screenX, screenY, pointer, button);
    }
}
