package de.hux.graphics.primitives;

public class Vector2D
{
	public final float x;
	public final float y;
	
	public Vector2D()
	{
		this(0, 0);
	}
	
	public Vector2D(float x, float y)
	{
		this.x = x;
		this.y = y;
	}
	
	public Vector2D Add(Vector2D v)
	{
		return Add(v.x, v.y);
	}
	
	public Vector2D Add(float dx, float dy)
	{
		return new Vector2D(this.x + dx, this.y + dy);
	}
	
	public Vector2D ScalarMultiply(float s)
	{
		return new Vector2D(this.x * s, this.y * s);
	}
}
