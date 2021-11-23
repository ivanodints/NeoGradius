package ru.gradius.screen.impl;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import ru.gradius.math.Rect;
import ru.gradius.screen.BaseScreen;
import ru.gradius.sprite.Impl.Background;

public class MenuScreen extends BaseScreen {


    private Texture ship;
    private Texture space;

    private Vector2 position;
    private Background background;




    @Override
    public void show() {

        super.show();
        space = new Texture("textures/warp.png");
        ship = new Texture("textures/thunderhawk-gunship.png");
        background = new Background(space);
        position = new Vector2();

    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        batch.begin();
        background.draw(batch);
        batch.end();

    }

    @Override
    public void dispose() {
        super.dispose();
        ship.dispose();
        space.dispose();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {

        position.set(touch);
        return super.touchDown(touch, pointer, button);
    }
}
