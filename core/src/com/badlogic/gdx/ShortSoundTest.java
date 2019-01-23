package com.badlogic.gdx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.GdxTest;

public class ShortSoundTest extends GdxTest {

	@Override
	public void create () {
		Gdx.audio.newSound(Gdx.files.internal("data/tic.ogg")).play();
	}

}
