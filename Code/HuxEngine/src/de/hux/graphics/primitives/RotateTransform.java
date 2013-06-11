package de.hux.graphics.primitives;

import javax.media.opengl.GL2;

public class RotateTransform extends Transform
{
	public final float angle;
	public final Vector2D center;
	
	public RotateTransform()
	{
		this.angle = 0;
		this.center = new Vector2D();
	}
	
	public RotateTransform(float angle, float centerX, float centerY)
	{
		this(angle, new Vector2D(centerX, centerY));
	}
	
	public RotateTransform(float angle, Vector2D center)
	{
		this.angle = angle;
		this.center = center;
	}
	
	@Override
	public void Apply(GL2 gl)
	{
		// TODO: Center
		//gl.glTranslatef(center.x, center.y, 1.0f);
		gl.glRotatef(angle, 0.0f, 0.0f, 1.0f);
		
	}
}
