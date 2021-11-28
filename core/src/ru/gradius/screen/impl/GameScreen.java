package ru.gradius.screen.impl;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import ru.gradius.math.Rect;
import ru.gradius.screen.BaseScreen;
import ru.gradius.sprite.impl.Background;
import ru.gradius.sprite.impl.SpaceShip;
import ru.gradius.sprite.impl.Star;

public class GameScreen extends BaseScreen {

    private Texture bg;
    private Background background;
    private TextureAtlas atlas1;
    private TextureAtlas atlas2;
    private Star[] stars;
    private SpaceShip spaceShip;
    private static final int STAR_COUNT = 256;

    @Override
    public void show() {
        super.show();
        bg = new Texture("textures/warp.png");
        atlas1 = new TextureAtlas("textures/spaceship.pack");
        atlas2 = new TextureAtlas("textures/menuAtlas.tpack");
        background = new Background(bg);
        spaceShip = new SpaceShip(atlas1);

        stars = new Star[STAR_COUNT];
        for (int i = 0; i < stars.length; i++) {
            stars[i] = new Star(atlas2);
        }
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update(delta);
        draw();
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
        spaceShip.resize(worldBounds);
        for (Star star : stars) {
            star.resize(worldBounds);
        }


    }

    @Override
    public void dispose() {
        super.dispose();
        bg.dispose();
        atlas1.dispose();
        atlas2.dispose();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {

        return spaceShip.touchDown(touch, pointer, button);

    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer, int button) {

        return spaceShip.touchUp(touch, pointer, button);

    }

    private void update(float delta) {

        spaceShip.update(delta);

        for (Star star : stars) {
            star.update(delta);
        }
    }

    private void draw() {
        batch.begin();
        background.draw(batch);
        spaceShip.draw(batch);
        for (Star star : stars) {
            star.draw(batch);
        }
        batch.end();

    }
}