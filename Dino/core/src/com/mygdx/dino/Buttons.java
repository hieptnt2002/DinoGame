package com.mygdx.dino;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.mygdx.dino.object.Cactus;

public class Buttons {
	// private DinoJumpGame dinoJumpGame;
	private World world;

	Buttons(DinoJumpGame dinoJumpGame, World world) {
		// this.dinoJumpGame = dinoJumpGame;
		this.world = world;
	}

	private String dinosaurKeypress() {
		if (Gdx.input.isKeyPressed(Keys.UP) || Gdx.input.isKeyPressed(Keys.SPACE)) {
			return "JUMP";
		} else if (Gdx.input.isKeyPressed(Keys.DOWN)) {
			return "DUCK";
		}
		return null;
	}

	public void update(float delta) {
		if (dinosaurKeypress() == "JUMP") {
			this.world.dinosaur.jump();
			Cactus.spawn();
		} else if (dinosaurKeypress() == "DUCK") {
			this.world.dinosaur.duck();
		} else {
			this.world.dinosaur.unDuck();
		}
	}
}
