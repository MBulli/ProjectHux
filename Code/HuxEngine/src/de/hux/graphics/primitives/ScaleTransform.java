package de.hux.graphics.primitives;

import javax.media.opengl.GL2;

public class ScaleTransform extends Transform
{
	public final int scaleX;
	public final int scaleY;
	
	public ScaleTransform()
	{
		this.scaleX = 1;
		this.scaleY = 1;
	}
	
	public ScaleTransform(int sX, int sY)
	{
		this.scaleX = sX;
		this.scaleY = sY;
	}
	
	@Override
	public void Apply(GL2 gl)
	{
		gl.glScalef(scaleX, scaleY, 1.0f);
	}
}
