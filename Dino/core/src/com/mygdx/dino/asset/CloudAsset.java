package com.mygdx.dino.asset;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;

public class CloudAsset {
	public AtlasRegion cloud;

	public CloudAsset(TextureAtlas atlas) {
		cloud = atlas.findRegion("cloud1");
	}
}
