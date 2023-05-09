package com.mygdx.dino.object;

import com.mygdx.dino.util.SoundEffect;

public class Dino {
	private int x, y, init_y;
	private float dieSensitivity;
	private boolean alive;
	public static float GRAVITY = -2000;
	public static float INITIAL_SPEED = 600;
	public static int DEFAULT_X = 100;

	private boolean jumping;
	private boolean ducking;

	private float time_counter = 0;

	public Dino(int x, int y) {
		this.x = x;
		this.y = y;
		this.init_y = y;
		this.dieSensitivity = 10;
		this.alive = true;
		this.jumping = false;
		this.ducking = false;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean isJumping() {
		return jumping;
	}

	public void jump() {
		// This is bad.
		if (!this.jumping && this.isAlive()) {
			SoundEffect.playJumpSound();
		}
		this.jumping = true;
	}

	public boolean isDucking() {
		return this.ducking;
	}

	public void duck() {
		if (!this.ducking && this.isAlive()) {
			SoundEffect.playDuckSound();
		}
		this.ducking = true;
	}

	public void unDuck() {
		this.ducking = false;
	}

	public boolean isAlive() {
		return this.alive;
	}

	public void die() {
		this.alive = false;
		SoundEffect.stopBackingTrack();
		SoundEffect.playDieTrack();
	}

	public void update(float delta) {
		if (this.alive) {
			for (int i = 0; i < Cactus.getCactiPosition().size(); i++) {
				if (Math.abs(Cactus.getCactiPosition().get(i) - Dino.DEFAULT_X) < this.dieSensitivity
						&& !this.isJumping()) {
					this.die();
				}
			}

			if (this.jumping) {
				if (time_counter <= .6) {
					this.y = init_y
							+ (int) ((INITIAL_SPEED * time_counter) + 0.5 * GRAVITY * Math.pow(time_counter, 2));
				} else {
					time_counter = 0;
					this.jumping = false;
					this.y = this.init_y;
				}
				time_counter += delta;
			}
			dieSensitivity += 0.02;
		}
	}
}
