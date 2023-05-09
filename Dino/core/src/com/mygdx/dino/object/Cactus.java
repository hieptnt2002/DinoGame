package com.mygdx.dino.object;

import java.util.ArrayList;

import com.mygdx.dino.util.Constants;

public class Cactus {
	private static ArrayList<Float> cactiTime = new ArrayList<Float>() {

		private static final long serialVersionUID = 1L;

		{
			add((float) Constants.TIME_BEFORE_FIRST_CACTUS);
		}
	};
	private static ArrayList<Float> cactiDelta = new ArrayList<Float>();
	private static ArrayList<Integer> cactiPosition = new ArrayList<Integer>();
	public static float speed = Constants.INITIAL_CACTUS_VELOCITY;
	public static float time = 0;

	public static void spawn() {
		cactiTime.add((float) (Math.random() * (Constants.CACTUS_TIME_GAP) + (Constants.CACTUS_MIN_TIME)
				+ cactiTime.get(cactiTime.size() - 1)));
	}

	public static void spawnWithCustomTime(float time) {
		cactiTime.add(time);
	}

	public static void update(float delta) {
		time += delta;
		while (cactiTime.size() < 5) {
			Cactus.spawn();
		}
		cactiDelta.clear();
		for (int i = 0; i < cactiTime.size(); i++) {
			cactiDelta.add(cactiTime.get(i) - Cactus.time);
		}
		cactiPosition.clear();
		for (int i = 0; i < cactiTime.size(); i++) {
			cactiPosition.add(Math.round((cactiTime.get(i) - Cactus.time) * speed) + 50);
		}
		for (int i = 0; i < cactiTime.size(); i++) {
			if (cactiDelta.get(i) < -1) {
				cactiTime.remove(i);
				cactiDelta.remove(i);
				cactiPosition.remove(i);
			}
		}
		speed += Constants.CACTUS_ACCELERATION;
	}

	public static ArrayList<Float> getCactiTime() {
		return cactiTime;
	}

	public static float getCactusTime(int i) {
		return cactiTime.get(i);
	}

	public static ArrayList<Integer> getCactiPosition() {
		return cactiPosition;
	}

	public static int getCactusPosition(int i) {
		return cactiPosition.get(i);
	}
}
