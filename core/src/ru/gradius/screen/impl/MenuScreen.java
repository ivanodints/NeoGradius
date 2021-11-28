package ru.gradius.screen.impl;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import ru.gradius.math.Rect;
import ru.gradius.screen.BaseScreen;
import ru.gradius.sprite.Impl.Background;
import ru.gradius.sprite.Impl.SpaceShip;

public class MenuScreen extends BaseScreen {


    private Texture ship;
    private Texture space;

    private Background background;
    private SpaceShip spaceShip;




    @Override
    public void show() {

        super.show();
        space = new Texture("textures/warp.png");
        ship = new Texture("textures/thunderhawk-gunship.png");
        spaceShip = new SpaceShip(ship);
        background = new Background(space);

    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
        spaceShip.resize(worldBounds);
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        batch.begin();
        background.draw(batch);
        spaceShip.draw(batch);
        batch.end();

        spaceShip.move();

    }

    @Override
    public void dispose() {
        super.dispose();
        ship.dispose();
        space.dispose();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {

        spaceShip.touchDown(touch, pointer, button);

        return false;
    }

}
