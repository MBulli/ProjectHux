package de.hux.graphics.internal;

import javax.media.opengl.GL2;

import de.hux.graphics.*;
import de.hux.graphics.primitives.*;

public abstract class HuxDrawable implements Drawable
{
	private boolean isDirty = true;
	
	private TransformGroup transformGroup;
	
	private Vector2D position = new Vector2D();
	private RotateTransform rotate = new RotateTransform();
	private ScaleTransform scale = new ScaleTransform();
	
	Transform getTransform()
	{
		if(isDirty)
			transformGroup = new TransformGroup(new Transform[] { new TranslateTransform(position), this.rotate, this.scale });
		
		isDirty = false;
		
		return this.transformGroup;
	}
	
	public abstract void Render(GL2 gl);
		
	@Override
	public void setPosition(Vector2D pos)
	{
		this.position = pos;
		isDirty = true;
	}

	@Override
	public Vector2D getPosition()
	{
		return this.position;
	}
	
	@Override
	public void setRotation(RotateTransform rotate)
	{
		this.rotate = rotate;
		isDirty = true;
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
