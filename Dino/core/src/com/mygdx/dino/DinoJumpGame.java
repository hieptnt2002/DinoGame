package com.mygdx.dino;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.dino.asset.Assets;

public class DinoJumpGame extends Game {
	public static SpriteBatch batch;

	public void create() {
		batch = new SpriteBatch();
		setScreen(new GameScreen(this));
	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	public void dispose() {
		super.dispose();
		Assets.instance.dispose();
	}
}
