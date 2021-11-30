package ru.gradius.screen.impl;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import ru.gradius.math.Rect;
import ru.gradius.screen.BaseScreen;
import ru.gradius.sprite.impl.Background;
import ru.gradius.sprite.impl.ButtonExit;
import ru.gradius.sprite.impl.ButtonPlay;
import ru.gradius.sprite.impl.Star;

public class MenuScreen extends BaseScreen {


    private static final int STAR_COUNT = 256;

    private final Game game;

    private Texture bg;
    private Background background;

    private TextureAtlas atlas;
    private TextureAtlas atlas2;
    private Star[] stars;
    private ButtonExit buttonExit;
    private ButtonPlay buttonPlay;

    public MenuScreen(Game game) {
        this.game = game;
    }

    @Override
    public void show() {
        super.show();
        bg = new Texture("textures/warp.png");
        background = new Background(bg);

        atlas = new TextureAtlas("textures/menuAtlas.tpack");
        atlas2 = new TextureAtlas("textures/menu.pack");


        stars = new Star[STAR_COUNT];
        for (int i = 0; i < stars.length; i++) {
            stars[i] = new Star(atlas);
        }
        buttonExit = new ButtonExit(atlas2);
        buttonPlay = new ButtonPlay(atlas2, game);
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
        for (Star star : stars) {
            star.resize(worldBounds);
        }
        buttonExit.resize(worldBounds);
        buttonPlay.resize(worldBounds);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update(delta);
        draw();
    }

    @Override
    public void dispose() {
        super.dispose();
        bg.dispose();
        atlas.dispose();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        buttonExit.touchDown(touch, pointer, button);
        buttonPlay.touchDown(touch, pointer, button);
        return false;
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer, int button) {
        buttonExit.touchUp(touch, pointer, button);
        buttonPlay.touchUp(touch, pointer, button);
        return false;
    }

    private void update(float delta) {
        for (Star star : stars) {
            star.update(delta);
        }
    }

    private void draw() {
        batch.begin();
//        batch.setColor(1f, 1f, 1f, 1f);
        background.draw(batch);
        for (Star star : stars) {
//            batch.setColor(Color.YELLOW);
            star.draw(batch);
//            batch.setColor(Color.CLEAR);
        }
        buttonExit.draw(batch);
        buttonPlay.draw(batch);
        batch.end();
    }

}
