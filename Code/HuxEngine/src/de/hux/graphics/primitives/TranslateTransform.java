package de.hux.graphics.primitives;

import javax.media.opengl.GL2;

public class TranslateTransform extends Transform
{
	public final float dX;
	public final float dY;
	
	public TranslateTransform()
	{
		this(0, 0);
	}
	
	public TranslateTransform(Vector2D v)
	{
		this(v.x, v.y);
	}
	
	public TranslateTransform(float dx, float dy)
	{
		this.dX = dx;
		this.dY = dy;
	}
	
	@Override
	public void Apply(GL2 gl)
	{
		gl.glTranslatef(dX, dY, 0.0f);
	}
}
