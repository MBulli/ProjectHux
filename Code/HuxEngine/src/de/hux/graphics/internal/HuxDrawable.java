package de.hux.graphics.internal;

import java.util.ArrayList;

import javax.media.opengl.GL2;

import de.hux.graphics.*;
import de.hux.graphics.primitives.*;

public abstract class HuxDrawable implements Drawable
{
	protected final HuxGLCanvas glCanvas;
	
	private boolean isDirty = true;
	
	private TransformGroup transformGroup;
	
	private Vector2D position = new Vector2D();
	private RotateTransform rotate = new RotateTransform();
	private ScaleTransform scale = new ScaleTransform();
	
	private ArrayList<HuxAnimation> animations = new ArrayList<HuxAnimation>();
	
	
	protected HuxDrawable(HuxGLCanvas canvas)
	{
		this.glCanvas = canvas;
	}
	
	Transform getTransform()
	{
		if(isDirty)
			transformGroup = new TransformGroup(new Transform[] { new TranslateTransform(position), this.rotate, this.scale });
		
		isDirty = false;
		
		return this.transformGroup;
	}
	
	public final void Render(GL2 gl)
	{
		RenderInternal(gl);
	}
	
	public final void Update()
	{	
		for	(int i = 0; i < animations.size(); i++)
		{
			HuxAnimation ha = animations.get(i);
			
			if(ha.getIsStoped())
			{
				animations.remove(i);
				i--;
			}
			else
			{
				ha.Update();
			}
		}
		
		UpdateInternal();
	}
	
	protected abstract void RenderInternal(GL2 gl);
	protected abstract void UpdateInternal();
		
	@Override
	public void setPosition(Vector2D pos)
	{
		setPosition(pos, false);
	}
	
	public void setPosition(Vector2D pos, boolean animated)
	{
		if(!animated && !glCanvas.getAnimationManger().getIsActive())
		{
			this.position = pos;
			this.isDirty = true;
		}
		else if(glCanvas.getAnimationManger().getIsActive())
		{
			// animation objekt erzeugen
			// ao ruft lamda mit progress zwischen 0-1f auf
			// this nimmt (x*progress, y*progress)
			
			final HuxDrawable target = this;
			final Vector2D targetPos = pos;
			final Vector2D startPos = this.getPosition();
						
			final HuxAnimation ani = new HuxAnimation(2.0f, 0.0f);
			
			ani.setCallback(new HuxAnimationCallback()
			{
				@Override
				public void UpdateAnimation(float progress)
				{
					Vector2D newPos = startPos.Add(targetPos.ScalarMultiply(progress));
					
					System.out.printf("New pos: (x: %f y: %f)\n", newPos.x, newPos.y);
										
					target.setPosition(newPos, false);
				}
			});
			
			animations.add(ani);

			ani.Start();
		}
		else
		{
			// TODO default animation
		}
	}

	@Override
	public Vector2D getPosition()
	{
		return this.position;
	}
	
	@Override
	public void setRotation(RotateTransform rotate)
	{
		setRotation(rotate, false);
	}
	
	public void setRotation(RotateTransform rotate, boolean animated)
	{
		if(!animated && !glCanvas.getAnimationManger().getIsActive())
		{
			this.rotate = rotate;
			this.isDirty = true;
		}
		else if(glCanvas.getAnimationManger().getIsActive())
		{
			final HuxDrawable target = this;
			final float targetAngle = rotate.angle;
			final float startAngle = this.getRotation().angle;
						
			final HuxAnimation ani = new HuxAnimation(2.0f, 0.0f);
			
			ani.setCallback(new HuxAnimationCallback()
			{
				@Override
				public void UpdateAnimation(float progress)
				{
					float newAngle = startAngle + (targetAngle * progress);
					
					System.out.printf("New angle: %f\n", newAngle);
										
					target.setRotation(new RotateTransform(newAngle, null), false);
				}
			});
			
			animations.add(ani);

			ani.Start();
		}
		else
		{
			// TODO default animation
		}
	}

	@Override
	public RotateTransform getRotation()
	{
		return this.rotate;
	}
	
	@Override
	public void setScale(ScaleTransform scale)
	{
		this.scale = scale;
		isDirty = true;
	}

	@Override
	public ScaleTransform getScale()
	{
		return this.scale;
	}

	@Override
	public Rectangle getBoundingBox()
	{
		// TODO Auto-generated method stub
		return null;
	}
	

}
