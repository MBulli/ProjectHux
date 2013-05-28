package de.hux.graphics.internal;

public class Colorf
{
	public final float a;
	public final float r;
	public final float g;
	public final float b;
	
	public Colorf()
	{
		this(1.0f, 0, 0, 0);
	}
	
	public Colorf(Color c)
	{
		this.a = c.a / 255.0f;
		this.r = c.r / 255.0f;
		this.g = c.g / 255.0f;
		this.b = c.b / 255.0f;
	}
	
	public Colorf(float r, float g, float b)
	{
		this(255, r, g, b);
	}
	
	public Colorf(float a, float r, float g, float b)
	{
		this.a = a;
		
		this.r = r;
		this.g = g;
		this.b = b;
	}
}
