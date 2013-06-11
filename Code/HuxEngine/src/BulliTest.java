import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import de.hux.graphics.GraphicAdapter;
import de.hux.graphics.GraphicAdapterFactory;
import de.hux.graphics.Shape;
import de.hux.graphics.internal.HuxSprite;
import de.hux.graphics.internal.TextureManager;
import de.hux.graphics.primitives.Color;
import de.hux.graphics.primitives.RotateTransform;
import de.hux.graphics.primitives.ScaleTransform;
import de.hux.graphics.primitives.Vector2D;


public class BulliTest
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run()
			{
				final JFrame wnd = new JFrame();
				wnd.setSize(680, 400);

				GraphicAdapter adapter = GraphicAdapterFactory.CreateAdapter(wnd);
		
			
				
				Shape triangle = adapter.createTriangleShape(new Vector2D(0, 100), 
															 new Vector2D(50, 0),
															 new Vector2D(100, 100),
															 Color.redColor,
															 Color.greenColor,
															 Color.blueColor);
				
				Vector2D[] vRect = new Vector2D[] { new Vector2D(0, 0),
													new Vector2D(100, 0),
													new Vector2D(100, 100),
													new Vector2D(0, 100) };

				Vector2D[] groﬂ = new Vector2D[] {new Vector2D(0, 0),
													new Vector2D(0, 200),
													new Vector2D(200, 200),
													new Vector2D(200, 0) };
				
				Vector2D[] mittel = new Vector2D[] {new Vector2D(0, 0),
						new Vector2D(0,100),
						new Vector2D(100, 100),
						new Vector2D(100, 0) };
				
				Vector2D[] klein = new Vector2D[] {new Vector2D(0, 0),
						new Vector2D(0, 70),
						new Vector2D(70, 70),
						new Vector2D(70, 0) };
				
				
				
				Shape rect = adapter.createRectangle(vRect, Color.greenColor);
				Shape rect2 = adapter.createRectangle(vRect, Color.redColor);
				Shape rect3 = adapter.createRectangle(vRect, Color.blueColor);
				Shape rect4 = adapter.createRectangle(vRect, Color.greyColor);

				rect.setPosition(new Vector2D(200, 200));
				
				rect2.setPosition(new Vector2D(200, 200));
				rect2.setRotation(new RotateTransform(45, new Vector2D(0, 0)));
				
				rect3.setPosition(new Vector2D(200, 200));
				rect3.setScale(new ScaleTransform(2, 2));
				
				rect4.setPosition(new Vector2D(450, 200));
				rect4.setRotation(new RotateTransform(45, null));
				rect4.setScale(new ScaleTransform(2, 3));

				adapter.addDrawableToWorld(triangle);
				
				adapter.addDrawableToWorld(rect2);
				adapter.addDrawableToWorld(rect);
				adapter.addDrawableToWorld(rect3);
			    adapter.addDrawableToWorld(rect4);
				
				
				TextureManager tm = TextureManager.getInstance();
				tm.createTexture("awesome.png", ".png", "awesome");
				// Test Sprites
				HuxSprite p = new HuxSprite(groﬂ);
				p.setPosition(new Vector2D(100,100));
				p.attachTexture("awesome");
				
				HuxSprite p1 = new HuxSprite(mittel);
				p1.setPosition(new Vector2D(250,100));
				p1.setTransparency(0.5f);
				p1.attachTexture("awesome");
				
				HuxSprite p2 = new HuxSprite(klein);
				p2.setPosition(new Vector2D(450, 300));
				p2.setTransparency(0.1f);
				p2.setRotation(new RotateTransform(90,null));
				p2.attachTexture("awesome");
				
				//Add Sprites to renderloop
				
				adapter.addDrawableToWorld(p);
			    adapter.addDrawableToWorld(p1);
			    adapter.addDrawableToWorld(p2);
				
				wnd.setTitle("HUX GFX Test");
				wnd.pack();
				wnd.setVisible(true);
			
				
			
			}
			
		});
	}

}
