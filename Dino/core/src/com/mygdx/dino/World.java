package com.mygdx.dino;

import com.mygdx.dino.object.Cactus;
import com.mygdx.dino.object.Cloud;
import com.mygdx.dino.object.Dino;
import com.mygdx.dino.util.SoundEffect;

public class World {
	public static final int DEFAULT_Y = 69;
	public static boolean dead = false;
	Dino dinosaur;
	// private DinoJumpGame dinoJumpGame;

	World(DinoJumpGame dinoJumpGame) {
		// this.dinoJumpGame = dinoJumpGame;
		dinosaur = new Dino(Dino.DEFAULT_X, World.DEFAULT_Y);
		SoundEffect.playBackingTrack();
	}

	public void update(float delta) {
		if (dinosaur.isAlive()) {
			dinosaur.update(delta);
			Cactus.update(delta);
			Cloud.update(delta);
		}
	}
}
