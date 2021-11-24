package ru.gradius.sprite.Impl;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.gradius.math.Rect;
import ru.gradius.sprite.Sprite;

public class SpaceShip extends Sprite {

    private static final float V_LEN = 0.005f;

    private final Vector2 touch;
    private final Vector2 vector;

    public SpaceShip(Texture texture) {
        super(new TextureRegion(texture));

        touch = new Vector2();
        vector = new Vector2();
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.2f);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        this.touch.set(touch);
        vector.set(touch.cpy().sub(pos)).setLength(V_LEN);
        return false;
    }

    public void move() {
        if (touch.dst(pos) > V_LEN) {
            pos.add(vector);
        } else {
            pos.set(touch);
        }
    }
}
