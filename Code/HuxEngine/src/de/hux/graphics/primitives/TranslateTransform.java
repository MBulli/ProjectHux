package de.hux.graphics.primitives;

import javax.media.opengl.GL2;

public class TranslateTransform extends Transform
{
	public final int dX;
	public final int dY;
	
	public TranslateTransform()
	{
		this(0, 0);
	}
	
	public TranslateTransform(Vector2D v)
	{
		this(v.x, v.y);
	}
	
	public TranslateTransform(int dx, int dy)
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
