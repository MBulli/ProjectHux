package de.hux.graphics.primitives;

import javax.media.opengl.GL2;

public class ScaleTransform extends Transform
{
	public final float scaleX;
	public final float scaleY;
	
	public ScaleTransform()
	{
		this.scaleX = 1;
		this.scaleY = 1;
	}
	
	public ScaleTransform(float sX, float sY)
	{
		this.scaleX = sX;
		this.scaleY = sY;
	}
	
	public ScaleTransform(Vector2D v)
	{
		this.scaleX = v.x;
		this.scaleY = v.y;
	}
	
	@Override
	public void Apply(GL2 gl)
	{
		gl.glScalef(scaleX, scaleY, 1.0f);
	}
}
