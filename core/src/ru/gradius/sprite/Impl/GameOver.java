package ru.gradius.sprite.impl;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.gradius.math.Rect;
import ru.gradius.sprite.Sprite;

public class GameOver extends Sprite {

    private static final float HEIGHT = 0.08f;

    public GameOver(TextureAtlas atlas) {
        super(atlas.findRegion("message_game_over"));
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(HEIGHT);
    }
}
