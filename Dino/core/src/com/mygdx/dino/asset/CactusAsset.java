package com.mygdx.dino.asset;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;

public class CactusAsset {
	public AtlasRegion cactus;

	public CactusAsset(TextureAtlas atlas) {
		cactus = atlas.findRegion("cactus");
	}
}
