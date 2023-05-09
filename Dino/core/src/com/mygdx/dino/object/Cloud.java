package com.mygdx.dino.object;

import java.util.ArrayList;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.dino.util.Constants;

public class Cloud {
	private static ArrayList<Float> cloudsTime = new ArrayList<Float>() {

		private static final long serialVersionUID = 1L;

		{
			add((float) 0);
		}
	};
	private static ArrayList<Vector2> cloudsPosition = new ArrayList<Vector2>();

	public static float speed = 300;
	public static float time = 0;

	public static void spawn() {
		cloudsTime.add((float) (Math.random() * (3) + 1 + cloudsTime.get(cloudsTime.size() - 1)));
	}

	public static void spawnWithCustomTime(float time) {
		cloudsTime.add(time);
	}

	public static void update(float delta) {
		time += delta;
		while (cloudsTime.size() < 10) {
			Cloud.spawn();
		}
		cloudsPosition.clear();
		for (int i = 0; i < cloudsTime.size(); i++) {
			cloudsPosition.add(new Vector2(Math.round((cloudsTime.get(i) - Cloud.time) * speed) + 50, 200));
		}
		for (int i = 0; i < cloudsPosition.size(); i++) {
			if (cloudsPosition.get(i).x < -100) {
				cloudsTime.remove(i);
				cloudsPosition.remove(i);
				Cloud.spawn();
			}
		}
		speed += Constants.CACTUS_ACCELERATION;
	}

	public static ArrayList<Float> getCloudsTime() {
		return cloudsTime;
	}

	public static ArrayList<Vector2> getCloudsPosition() {
		return cloudsPosition;
	}
}
