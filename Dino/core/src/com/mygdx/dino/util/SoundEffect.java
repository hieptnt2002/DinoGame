package com.mygdx.dino.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

public class SoundEffect {
	public static Sound startSound = Gdx.audio.newSound(Gdx.files.local("dadodi.mp3"));
	public static Sound jumpSound = Gdx.audio.newSound(Gdx.files.local("dadi.mp3"));
	public static Sound duckSound = Gdx.audio.newSound(Gdx.files.local("didoda.mp3"));
	public static Sound dieSound = Gdx.audio.newSound(Gdx.files.local("dada.mp3"));
	public static Sound backingTrack = Gdx.audio.newSound(Gdx.files.local("oogoe.mp3"));
	public static Sound dieTrack = Gdx.audio.newSound(Gdx.files.local("365.mp3"));

	public SoundEffect() {
		backingTrack.setLooping(0, true);
	}

	public static void playStartSound() {
		startSound.play(1.0f);
	}

	public static void playJumpSound() {
		jumpSound.play(1.0f);
	}

	public static void playDuckSound() {
		duckSound.play(1.0f);
	}

	public static void playDieSound() {
		dieSound.play(1.0f);
	}

	public static void playBackingTrack() {
		backingTrack.setLooping(0, true);
		backingTrack.loop(1.0f);
	}

	public static void stopBackingTrack() {
		backingTrack.stop();
	}

	public static void playDieTrack() {
		dieTrack.play();
	}
}
