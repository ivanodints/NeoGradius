package ru.gradius.sprite.impl;

import ru.gradius.sprite.Sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import ru.gradius.math.Rect;


public class SpaceShip extends Sprite {

    private static final float HEIGHT = 0.15f;
    private static final float MARGIN = 0.05f;
    private static final int ERROR_POINT = -1;

    private final Vector2 vector1;
    private final Vector2 vector2;
    private Rect worldBounds;
    private int left = ERROR_POINT;
    private int right = ERROR_POINT;

    public SpaceShip(TextureAtlas atlas) {

        super(atlas.findRegion("thunderhawk"));
        this.vector1 = new Vector2();
        this.vector2 = new Vector2(0.3f, 0);
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        this.worldBounds = worldBounds;
        setHeightProportion(HEIGHT);
        setBottom(worldBounds.getBottom() + MARGIN);
    }

    @Override
    public void update(float delta) {

        pos.mulAdd(vector1, delta);

        if (getRight() > worldBounds.getRight()) {
            setRight(worldBounds.getRight());
            stop();
        }
        if (getLeft() < worldBounds.getLeft()) {
            setLeft(worldBounds.getLeft());
            stop();
        }

    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        if (touch.x < worldBounds.pos.x) {
            if (left != ERROR_POINT) {
                return false;
            }
            left = pointer;
            moveLeft();
        } else {
            if (right != ERROR_POINT) {
                return false;
            }
            right = pointer;
            moveRight();
        }
        return false;
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer, int button) {
        if (pointer == left) {
            left = ERROR_POINT;
            if (right != ERROR_POINT) {
                moveRight();
            } else {
                stop();
            }
        } else if (pointer == right) {
            right = ERROR_POINT;
            if (left != ERROR_POINT) {
                moveLeft();
            } else {
                stop();
            }
        }
        return false;
    }

    private void moveLeft() {
        vector1.set(vector2).rotateDeg(180);
    }


    private void moveRight() {
        vector1.set(vector2);
    }

    private void stop() {
        vector1.setZero();
    }

}
