package ru.gradius;

import com.badlogic.gdx.Game;

import ru.gradius.screen.impl.MenuScreen;

public class NeoGradius extends Game {


	@Override
	public void create() {
		setScreen(new MenuScreen());
	}
}
