package com.mygdx.dino;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.mygdx.dino.asset.Assets;
import com.mygdx.dino.object.Dino;

public class GameScreen extends ScreenAdapter {
	DinoJumpGame dinoJumpGame;
	Dino dinosaur;
	World world;
	WorldRenderer worldRenderer;
	Buttons buttons;

	public GameScreen(DinoJumpGame dinoJumpGame) {
		Assets.instance.init(new AssetManager());
		this.dinoJumpGame = dinoJumpGame;
		this.world = new World(dinoJumpGame);
		this.worldRenderer = new WorldRenderer(dinoJumpGame, world);
		this.buttons = new Buttons(dinoJumpGame, world);
	}

	@Override
	public void render(float delta) {
		world.update(delta);
		worldRenderer.render();
		buttons.update(delta);
	}
}