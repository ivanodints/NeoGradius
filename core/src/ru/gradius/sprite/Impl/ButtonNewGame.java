package ru.gradius.sprite.impl;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.gradius.math.Rect;
import ru.gradius.screen.impl.GameScreen;
import ru.gradius.sprite.BaseButton;

public class ButtonNewGame extends BaseButton {

    private static final float HEIGHT = 0.08f;


    private final GameScreen gameScreen;

    public ButtonNewGame(TextureAtlas atlas, GameScreen gameScreen) {
        super(atlas.findRegion("button_new_game"));
        this.gameScreen = gameScreen;
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(HEIGHT);

    }

    @Override
    public void action() {
        gameScreen.startNewGame();
    }
}
