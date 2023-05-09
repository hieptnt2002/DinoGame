package com.mygdx.dino;

import java.util.ArrayList;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.dino.asset.Assets;
import com.mygdx.dino.object.Cactus;
import com.mygdx.dino.object.Cloud;
import com.mygdx.dino.object.Dino;

// SOMETHING'S VERY WRONG ON STATIC/NON-STATIC HERE.
public class WorldRenderer {
	DinoJumpGame dinoJumpGame;
	World world;
	Dino dinosaur;
	Cactus cactus;
	TextureRegion cloudSprite, cactusSprite, dinosaurSprite, floorTile, gameOverOverlay;
	BitmapFont kanitFont;
	Texture test;

	WorldRenderer(DinoJumpGame dinoJumpGame, World world) {

		this.dinoJumpGame = dinoJumpGame;
		this.world = world;
		this.dinosaur = world.dinosaur;
		this.dinosaurSprite = Assets.instance.dino.dino_default;
		this.cactusSprite = Assets.instance.cactus.cactus;
		this.cloudSprite = Assets.instance.cloud.cloud;
		test = new Texture("cloud1.png");
		TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("dino.atlas"));
		this.floorTile = atlas.findRegion("floor_tile");
		this.gameOverOverlay = atlas.findRegion("gameover");

		this.kanitFont = new BitmapFont(Gdx.files.internal("kanit_regular_32pt.fnt"));
	}

	public void updateDinosaurSprite(Dino dinosaur) {
		if (!dinosaur.isAlive()) {
			this.dinosaurSprite = Assets.instance.dino.dino_default;
		} else if (dinosaur.isJumping()) {
			this.dinosaurSprite = Assets.instance.dino.dino_jump;
		} else if (dinosaur.isDucking()) {
			this.dinosaurSprite = Assets.instance.dino.dino_ducking;

		} else {
			this.dinosaurSprite = Assets.instance.dino.dino_default;
		}
	}

	public void render() {

		SpriteBatch batch = DinoJumpGame.batch;
		batch.begin();
		// Clears screen
		Gdx.gl.glClearColor((float) 0.875, (float) 0.9648, (float) 0.9804, (float) 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		// Clouds
		ArrayList<Vector2> cloudsPosition = Cloud.getCloudsPosition();
		for (int i = 0; i < cloudsPosition.size(); i++) {
			batch.draw(cloudSprite, (int) cloudsPosition.get(i).x, (int) cloudsPosition.get(i).y);
		}

		// Draws background
		batch.draw(floorTile, 0, 0);

		// Gets the position after movement calculation
		int x = world.dinosaur.getX();
		int y = world.dinosaur.getY();
		// Updates dinosaur sprite
		updateDinosaurSprite(world.dinosaur);
		// and draw
		batch.draw(this.dinosaurSprite, x, y);

		// Cactus
		for (int i = 0; i < Cactus.getCactiPosition().size(); i++) {
			batch.draw(cactusSprite, Cactus.getCactusPosition(i), World.DEFAULT_Y);
		}

		if (dinosaur.isAlive()) {
			kanitFont.draw(batch, "" + Math.round(Cactus.time * 5), 10, 30);

		} else {
			batch.draw(gameOverOverlay, -110, 0);
			kanitFont.draw(batch, "Your score is " + Math.round(Cactus.time * 5) + ".", 200, 120);
		}

		batch.end();
	}
}