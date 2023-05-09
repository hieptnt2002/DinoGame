package com.mygdx.dino.asset;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;

public class DinoAsset {
	public final AtlasRegion dino_jump, dino_ducking, dino_default;

	public DinoAsset(TextureAtlas atlas) {
		dino_jump = atlas.findRegion("dino_jump");
		dino_ducking = atlas.findRegion("dino_duck");
		dino_default = atlas.findRegion("dino_default");
	}
}
