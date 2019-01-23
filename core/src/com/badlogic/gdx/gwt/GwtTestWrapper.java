/*******************************************************************************
 * Copyright 2011 See AUTHORS file.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

package com.badlogic.gdx.gwt;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.AccelerometerTest;
import com.badlogic.gdx.ActionSequenceTest;
import com.badlogic.gdx.ActionTest;
import com.badlogic.gdx.AlphaTest;
import com.badlogic.gdx.AnimationTest;
import com.badlogic.gdx.AnnotationTest;
import com.badlogic.gdx.AssetManagerTest;
import com.badlogic.gdx.AtlasIssueTest;
import com.badlogic.gdx.BitmapFontAlignmentTest;
import com.badlogic.gdx.BitmapFontFlipTest;
import com.badlogic.gdx.BitmapFontMetricsTest;
import com.badlogic.gdx.BitmapFontTest;
import com.badlogic.gdx.BlitTest;
import com.badlogic.gdx.Box2DCharacterControllerTest;
import com.badlogic.gdx.Box2DTest;
import com.badlogic.gdx.Box2DTestCollection;
import com.badlogic.gdx.BufferUtilsTest;
import com.badlogic.gdx.ColorTest;
import com.badlogic.gdx.ComplexActionTest;
import com.badlogic.gdx.CustomShaderSpriteBatchTest;
import com.badlogic.gdx.DecalTest;
import com.badlogic.gdx.EdgeDetectionTest;
import com.badlogic.gdx.FilterPerformanceTest;
import com.badlogic.gdx.FrameBufferTest;
import com.badlogic.gdx.FramebufferToTextureTest;
import com.badlogic.gdx.GLProfilerErrorTest;
import com.badlogic.gdx.GWTLossyPremultipliedAlphaTest;
import com.badlogic.gdx.GestureDetectorTest;
import com.badlogic.gdx.GroupCullingTest;
import com.badlogic.gdx.GroupFadeTest;
import com.badlogic.gdx.I18NSimpleMessageTest;
import com.badlogic.gdx.ImageScaleTest;
import com.badlogic.gdx.ImageTest;
import com.badlogic.gdx.IndexBufferObjectShaderTest;
import com.badlogic.gdx.IntegerBitmapFontTest;
import com.badlogic.gdx.InterpolationTest;
import com.badlogic.gdx.InverseKinematicsTest;
import com.badlogic.gdx.IsometricTileTest;
import com.badlogic.gdx.KinematicBodyTest;
import com.badlogic.gdx.LabelScaleTest;
import com.badlogic.gdx.LabelTest;
import com.badlogic.gdx.LifeCycleTest;
import com.badlogic.gdx.MeshShaderTest;
import com.badlogic.gdx.MipMapTest;
import com.badlogic.gdx.MultitouchTest;
import com.badlogic.gdx.MusicTest;
import com.badlogic.gdx.ParallaxTest;
import com.badlogic.gdx.ParticleEmitterTest;
import com.badlogic.gdx.PixelsPerInchTest;
import com.badlogic.gdx.PixmapPackerTest;
import com.badlogic.gdx.ProjectiveTextureTest;
import com.badlogic.gdx.ReflectionCorrectnessTest;
import com.badlogic.gdx.ReflectionTest;
import com.badlogic.gdx.RotationTest;
import com.badlogic.gdx.Scene2dTest;
import com.badlogic.gdx.ShapeRendererTest;
import com.badlogic.gdx.SimpleAnimationTest;
import com.badlogic.gdx.SimpleDecalTest;
import com.badlogic.gdx.SimpleStageCullingTest;
import com.badlogic.gdx.SortedSpriteTest;
import com.badlogic.gdx.SoundTest;
import com.badlogic.gdx.SpriteBatchShaderTest;
import com.badlogic.gdx.SpriteCacheOffsetTest;
import com.badlogic.gdx.SpriteCacheTest;
import com.badlogic.gdx.StageTest;
import com.badlogic.gdx.TableTest;
import com.badlogic.gdx.TextButtonTest;
import com.badlogic.gdx.TextureAtlasTest;
import com.badlogic.gdx.TiledMapAtlasAssetManagerTest;
import com.badlogic.gdx.TiledMapObjectLoadingTest;
import com.badlogic.gdx.TimeUtilsTest;
import com.badlogic.gdx.UITest;
import com.badlogic.gdx.VertexBufferObjectShaderTest;
import com.badlogic.gdx.YDownTest;
import com.badlogic.gdx.conformance.DisplayModeTest;
import com.badlogic.gdx.extensions.ControllersTest;
import com.badlogic.gdx.g3d.ModelCacheTest;
import com.badlogic.gdx.g3d.ShadowMappingTest;
import com.badlogic.gdx.net.OpenBrowserExample;
import com.badlogic.gdx.superkoalio.SuperKoalio;
import com.badlogic.gdx.utils.GdxTest;

import java.util.Arrays;
import java.util.Comparator;

public class GwtTestWrapper extends GdxTest {
	Stage ui;
	Table container;
	Skin skin;
	BitmapFont font;
	GdxTest test;
	boolean dispose = false;

	@Override
	public void create () {
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		Gdx.app.log("GdxTestGwt", "Setting up for " + tests.length + " tests.");

		ui = new Stage();
		skin = new Skin(Gdx.files.internal("data/uiskin.json"));
		font = new BitmapFont(Gdx.files.internal("data/arial-15.fnt"), false);
		container = new Table();
		ui.addActor(container);
		container.debug();
		Table table = new Table();
		ScrollPane scroll = new ScrollPane(table);
		container.add(scroll).expand().fill();
		table.pad(10).defaults().expandX().space(4);
		Arrays.sort(tests, new Comparator<Instancer>() {
			@Override
			public int compare (Instancer o1, Instancer o2) {
				return o1.instance().getClass().getName().compareTo(o2.instance().getClass().getName());
			}
		});
		for (final Instancer instancer : tests) {
			table.row();
			TextButton button = new TextButton(instancer.instance().getClass().getName(), skin);
			button.addListener(new ClickListener() {
				@Override
				public void clicked (InputEvent event, float x, float y) {
					((InputWrapper)Gdx.input).multiplexer.removeProcessor(ui);
					test = instancer.instance();
					Gdx.app.log("GdxTestGwt", "Clicked on " + test.getClass().getName());
					test.create();
					test.resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
				}
			});
			table.add(button).expandX().fillX();
		}
		container.row();
		container.add(new Label("Click on a test to start it, press ESC to close it.", new LabelStyle(font, Color.WHITE))).pad(5, 5,
			5, 5);

		Gdx.input = new InputWrapper(Gdx.input) {
			@Override
			public boolean keyUp (int keycode) {
				if (keycode == Keys.ESCAPE) {
					if (test != null) {
						Gdx.app.log("GdxTestGwt", "Exiting current test.");
						dispose = true;
					}
				}
				return false;
			}

			@Override
			public boolean touchDown (int screenX, int screenY, int pointer, int button) {
				if (screenX < Gdx.graphics.getWidth() / 10.0 && screenY < Gdx.graphics.getHeight() / 10.0) {
					if (test != null) {
						dispose = true;
					}
				}
				return false;
			}
		};
		((InputWrapper)Gdx.input).multiplexer.addProcessor(ui);

		Gdx.app.log("GdxTestGwt", "Test picker UI setup complete.");
	}

	public void render () {
		if (test == null) {
			Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
			Gdx.gl.glClearColor(0, 0, 0, 0);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			ui.act(Gdx.graphics.getDeltaTime());
			ui.draw();
		} else {
			if (dispose) {
				test.pause();
				test.dispose();
				test = null;
				Gdx.graphics.setVSync(true);
				InputWrapper wrapper = ((InputWrapper)Gdx.input);
				wrapper.multiplexer.addProcessor(ui);
				wrapper.multiplexer.removeProcessor(wrapper.lastProcessor);
				wrapper.lastProcessor = null;
				dispose = false;
			} else {
				test.render();
			}
		}
	}

	public void resize (int width, int height) {
		ui.getViewport().update(width, height, true);
		container.setSize(width, height);
		if (test != null) {
			test.resize(width, height);
		}
	}

	class InputWrapper extends InputAdapter implements Input {
		Input input;
		InputProcessor lastProcessor;
		InputMultiplexer multiplexer;

		public InputWrapper (Input input) {
			this.input = input;
			this.multiplexer = new InputMultiplexer();
			this.multiplexer.addProcessor(this);
			input.setInputProcessor(multiplexer);
		}

		@Override
		public float getAccelerometerX () {
			return input.getAccelerometerX();
		}

		@Override
		public float getAccelerometerY () {
			return input.getAccelerometerY();
		}

		@Override
		public float getAccelerometerZ () {
			return input.getAccelerometerZ();
		}

		@Override
		public float getGyroscopeX () {
			// TODO Auto-generated method stub
			return input.getGyroscopeX();
		}

		@Override
		public float getGyroscopeY () {
			// TODO Auto-generated method stub
			return input.getGyroscopeY();
		}

		@Override
		public float getGyroscopeZ () {
			// TODO Auto-generated method stub
			return input.getGyroscopeZ();
		}

//		@Override
//		public int getMaxPointers () {
//			return input.getMaxPointers();
//		}

		@Override
		public int getX () {
			return input.getX();
		}

		@Override
		public int getX (int pointer) {
			return input.getX(pointer);
		}

		@Override
		public int getDeltaX () {
			return input.getDeltaX();
		}

		@Override
		public int getDeltaX (int pointer) {
			return input.getDeltaX(pointer);
		}

		@Override
		public int getY () {
			return input.getY();
		}

		@Override
		public int getY (int pointer) {
			return input.getY(pointer);
		}

		@Override
		public int getDeltaY () {
			return input.getDeltaY();
		}

		@Override
		public int getDeltaY (int pointer) {
			return input.getDeltaY(pointer);
		}

		@Override
		public boolean isTouched () {
			return input.isTouched();
		}

		@Override
		public boolean justTouched () {
			return input.justTouched();
		}

		@Override
		public boolean isTouched (int pointer) {
			return input.isTouched(pointer);
		}

		@Override
		public float getPressure () {
			return input.getPressure();
		}

		@Override
		public float getPressure (int pointer) {
			return input.getPressure(pointer);
		}

		@Override
		public boolean isButtonPressed (int button) {
			return input.isButtonPressed(button);
		}

		@Override
		public boolean isKeyPressed (int key) {
			return input.isKeyPressed(key);
		}

		@Override
		public boolean isKeyJustPressed (int key) {
			return input.isKeyJustPressed(key);
		}

		@Override
		public void getTextInput (TextInputListener listener, String title, String text, String hint) {
			input.getTextInput(listener, title, text, hint);
		}

		@Override
		public void setOnscreenKeyboardVisible (boolean visible) {
			input.setOnscreenKeyboardVisible(visible);
		}

		@Override
		public void vibrate (int milliseconds) {
			input.vibrate(milliseconds);
		}

		@Override
		public void vibrate (long[] pattern, int repeat) {
			input.vibrate(pattern, repeat);
		}

		@Override
		public void cancelVibrate () {
			input.cancelVibrate();
		}

		@Override
		public float getAzimuth () {
			return input.getAzimuth();
		}

		@Override
		public float getPitch () {
			return input.getPitch();
		}

		@Override
		public float getRoll () {
			return input.getRoll();
		}

		@Override
		public void getRotationMatrix (float[] matrix) {
			input.getRotationMatrix(matrix);
		}

		@Override
		public long getCurrentEventTime () {
			return input.getCurrentEventTime();
		}

		@Override
		public void setCatchBackKey (boolean catchBack) {
			input.setCatchBackKey(catchBack);
		}

		@Override
		public boolean isCatchBackKey () {
			return input.isCatchBackKey();
		}

		@Override
		public void setCatchMenuKey (boolean catchMenu) {
			input.setCatchMenuKey(catchMenu);
		}

		@Override
		public boolean isCatchMenuKey () {
			return input.isCatchMenuKey();
		}

		@Override
		public void setInputProcessor (InputProcessor processor) {
			multiplexer.removeProcessor(lastProcessor);
			multiplexer.addProcessor(processor);
			lastProcessor = processor;
		}

		@Override
		public InputProcessor getInputProcessor () {
			return input.getInputProcessor();
		}

		@Override
		public boolean isPeripheralAvailable (Peripheral peripheral) {
			return input.isPeripheralAvailable(peripheral);
		}

		@Override
		public int getRotation () {
			return input.getRotation();
		}

		@Override
		public Orientation getNativeOrientation () {
			return input.getNativeOrientation();
		}

		@Override
		public void setCursorCatched (boolean catched) {
			input.setCursorCatched(catched);
		}

		@Override
		public boolean isCursorCatched () {
			return input.isCursorCatched();
		}

		@Override
		public void setCursorPosition (int x, int y) {
			setCursorPosition(x, y);
		}
	}

	interface Instancer {
		public GdxTest instance ();
	}

	Instancer[] tests = {new Instancer() {
		public GdxTest instance () {
			return new AccelerometerTest();
		}
	}, new Instancer() {
		public GdxTest instance () {
			return new ActionTest();
		}
	}, new Instancer() {
		public GdxTest instance () {
			return new ActionSequenceTest();
		}
	}, new Instancer() {
		public GdxTest instance () {
			return new AlphaTest();
		}
	}, new Instancer() {
		public GdxTest instance () {
			return new AnimationTest();
		}
	}, new Instancer() {
		public GdxTest instance () {
			return new AnnotationTest();
		}
	}, new Instancer() {
		public GdxTest instance () {
			return new AssetManagerTest();
		}
	}, new Instancer() {
		public GdxTest instance () {
			return new AtlasIssueTest();
		}
	}, new Instancer() {
		public GdxTest instance () {
			return new BitmapFontAlignmentTest();
		}
	}, new Instancer() {
		public GdxTest instance () {
			return new BitmapFontFlipTest();
		}
	}, new Instancer() {
		public GdxTest instance () {
			return new BitmapFontTest();
		}
	}, new Instancer() {
		public GdxTest instance () {
			return new BitmapFontMetricsTest();
		}
	}, new Instancer() {
		public GdxTest instance () {
			return new BlitTest();
		}
	}, new Instancer() {
		public GdxTest instance () {
			return new Box2DCharacterControllerTest();
		}
	}, new Instancer() {
		public GdxTest instance () {
			return new Box2DTest();
		}
	}, new Instancer() {
		public GdxTest instance () {
			return new Box2DTestCollection();
		}
	}, new Instancer() {
		public GdxTest instance () {
			return new BufferUtilsTest();
		}
	}, new Instancer() {
		public GdxTest instance () {
			return new ColorTest();
		}
	}, new Instancer() {
		public GdxTest instance () {
			return new ComplexActionTest();
		}
	}, new Instancer() {
		public GdxTest instance () {
			return new ControllersTest();
		}
	}, new Instancer() {
		public GdxTest instance () {
			return new CustomShaderSpriteBatchTest();
		}
	}, new Instancer() {
		public GdxTest instance () {
			return new DecalTest();
		}
	}, new Instancer() {
		public GdxTest instance () {
			return new DisplayModeTest();
		}
	}, new Instancer() {
		public GdxTest instance () {
			return new LabelScaleTest();
		}
	}, new Instancer() {
		public GdxTest instance () {
			return new EdgeDetectionTest();
		}
	}, new Instancer() {
		public GdxTest instance () {
			return new FilterPerformanceTest();
		}
	},
// new Instancer() {public GdxTest instance(){return new FlickScrollPaneTest();}}, // FIXME this messes up stuff, why?
		new Instancer() {
			public GdxTest instance () {
				return new FrameBufferTest();
			}
		}, new Instancer() {
			public GdxTest instance () {
				return new FramebufferToTextureTest();
			}
		}, new Instancer() {
			public GdxTest instance () {
				return new GestureDetectorTest();
			}
		}, new Instancer() {
			public GdxTest instance () {
				return new GLProfilerErrorTest();
			}
		}, new Instancer() {
			public GdxTest instance () {
				return new GroupCullingTest();
			}
		}, new Instancer() {
			public GdxTest instance () {
				return new GroupFadeTest();
			}
		}, new Instancer() {
			public GdxTest instance () {
				return new GwtWindowModeTest();
			}
		}, new Instancer() {
			public GdxTest instance () {
				return new I18NSimpleMessageTest();
			}
		}, new Instancer() {
			public GdxTest instance () {
				return new ImageScaleTest();
			}
		}, new Instancer() {
			public GdxTest instance () {
				return new ImageTest();
			}
		}, new Instancer() {
			public GdxTest instance () {
				return new IndexBufferObjectShaderTest();
			}
		}, new Instancer() {
			public GdxTest instance () {
				return new IntegerBitmapFontTest();
			}
		}, new Instancer() {
			public GdxTest instance () {
				return new InterpolationTest();
			}
		}, new Instancer() {
			public GdxTest instance () {
				return new InverseKinematicsTest();
			}
		}, new Instancer() {
			public GdxTest instance () {
				return new IsometricTileTest();
			}
		}, new Instancer() {
			public GdxTest instance () {
				return new KinematicBodyTest();
			}
		}, new Instancer() {
			public GdxTest instance () {
				return new LifeCycleTest();
			}
		}, new Instancer() {
			public GdxTest instance () {
				return new LabelTest();
			}
		},
		// new Instancer() {public GdxTest instance(){return new MatrixJNITest();}}, // No purpose
		new Instancer() {
			public GdxTest instance () {
				return new MeshShaderTest();
			}
		}, new Instancer() {
			public GdxTest instance () {
				return new MipMapTest();
			}
		}, new Instancer() {
			public GdxTest instance () {
				return new ModelCacheTest();
			}
		}, new Instancer() {
			public GdxTest instance () {
				return new MultitouchTest();
			}
		}, new Instancer() {
			public GdxTest instance () {
				return new MusicTest();
			}
		}, new Instancer() {
			public GdxTest instance () {
				return new OpenBrowserExample();
			}
// }, new Instancer() { public GdxTest instance () { return new NoncontinuousRenderingTest(); } // FIXME doesn't compile due to
// the use of Thread
		}, new Instancer() {
			public GdxTest instance () {
				return new ParallaxTest();
			}
		}, new Instancer() {
			public GdxTest instance () {
				return new ParticleEmitterTest();
			}
		}, new Instancer() {
			public GdxTest instance () {
				return new PixelsPerInchTest();
			}
		}, new Instancer() {
			public GdxTest instance () {
				return new PixmapPackerTest();
			}
		},
		// new Instancer() {public GdxTest instance(){return new PixmapBlendingTest();}}, // FIXME no idea why this doesn't work
		new Instancer() {
			public GdxTest instance () {
				return new ProjectiveTextureTest();
			}
		}, new Instancer() {
			public GdxTest instance () {
				return new RotationTest();
			}
		}, new Instancer() {
			public GdxTest instance () {
				return new ReflectionCorrectnessTest();
			}
		}, new Instancer() {
			public GdxTest instance () {
				return new Scene2dTest();
			}

// new Instancer() {public GdxTest instance(){return new RunnablePostTest();}}, // Goes into infinite loop
// new Instancer() {public GdxTest instance(){return new ScrollPaneTest();}}, // FIXME this messes up stuff, why?
// new Instancer() {public GdxTest instance(){return new ShaderMultitextureTest();}}, // FIXME fucks up stuff
		}, new Instancer() {
			public GdxTest instance () {
				return new ShadowMappingTest();
			}
		}, new Instancer() {
			public GdxTest instance () {
				return new ShapeRendererTest();
			}
		}, new Instancer() {
			public GdxTest instance () {
				return new SimpleAnimationTest();
			}
		}, new Instancer() {
			public GdxTest instance () {
				return new SimpleDecalTest();
			}
		}, new Instancer() {
			public GdxTest instance () {
				return new SimpleStageCullingTest();
			}
		}, new Instancer() {
			public GdxTest instance () {
				return new SortedSpriteTest();
			}
		}, new Instancer() {
			public GdxTest instance () {
				return new SpriteBatchShaderTest();
			}
		}, new Instancer() {
			public GdxTest instance () {
				return new SpriteCacheOffsetTest();
			}
		}, new Instancer() {
			public GdxTest instance () {
				return new SpriteCacheTest();
			}
		}, new Instancer() {
			public GdxTest instance () {
				return new SoundTest();
			}
		}, new Instancer() {
			public GdxTest instance () {
				return new StageTest();
			}
		},
		// new Instancer() {public GdxTest instance(){return new StagePerformanceTest();}}, // FIXME borks out
		new Instancer() {
			public GdxTest instance () {
				return new TableTest();
			}
		}, new Instancer() {
			public GdxTest instance () {
				return new TextButtonTest();
			}
		}, new Instancer() {
			public GdxTest instance () {
				return new TextButtonTest();
			}
		}, new Instancer() {
			public GdxTest instance () {
				return new TextureAtlasTest();
			}
		}, new Instancer() {
			public GdxTest instance () {
				return new TiledMapObjectLoadingTest();
			}
		}, new Instancer() {
			public GdxTest instance () {
				return new UITest();
			}
		}, new Instancer() {
			public GdxTest instance () {
				return new VertexBufferObjectShaderTest();
			}
		}, new Instancer() {
			public GdxTest instance () {
				return new YDownTest();
			}
		}, new Instancer() {
			public GdxTest instance () {
				return new SuperKoalio();
			}
		}, new Instancer() {
			public GdxTest instance () {
				return new ReflectionTest();
			}
		}, new Instancer() {
			public GdxTest instance () {
				return new TiledMapAtlasAssetManagerTest();
			}
		}, new Instancer() {
			public GdxTest instance () {
				return new TimeUtilsTest();
			}
		}, new Instancer() {
			public GdxTest instance () {
				return new GWTLossyPremultipliedAlphaTest();
			}
		}};
}