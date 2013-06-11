import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import de.hux.graphics.*;
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
		
			
				
				final Shape triangle = adapter.createTriangleShape(new Vector2D(0, 100), 
															 new Vector2D(50, 0),
															 new Vector2D(100, 100),
															 Color.redColor,
															 Color.greenColor,
															 Color.blueColor);
				

				Vector2D[] vRect = new Vector2D[] { new Vector2D(0, 0),
													new Vector2D(100, 0),
													new Vector2D(100, 100),
													new Vector2D(0, 100) };

				adapter.getAnimationManger().CreateAnimation(new AnimationDescriptor(0, 5, new AnimationContext()
				{
					@Override
					public void UpdateAnimation()
					{
						triangle.setPosition(new Vector2D(200, 200));
						triangle.setRotation(new RotateTransform(180, null));
					}
				}));
												
				
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


				Sprite p = adapter.createSprite("awesome", 100, 100, 200, 200);
				Sprite p1 = adapter.createSprite("awesome", 250, 100, 100, 100);
				Sprite p2 = adapter.createSprite("awesome", 450, 300, 70, 70);

				p1.setTransparency(0.5f);
				p2.setTransparency(0.1f);
				p2.setRotation(new RotateTransform(90,null));
				
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
