package de.hux.graphics.internal;

public class Color
{
	public final int a;
	public final int r;
	public final int g;
	public final int b;
	
	public static final Color redColor   = new Color(255, 0, 0);
	public static final Color greenColor = new Color(0, 255, 0);
	public static final Color blueColor  = new Color(0, 0, 255);
	public static final Color greyColor  = new Color(128, 128, 128);

	
	public Color()
	{
		this(255, 0, 0, 0);
	}
	
	public Color(Colorf c)
	{
		this.a = Math.round(c.a * 255.0f);
		this.r = Math.round(c.r * 255.0f);
		this.g = Math.round(c.g * 255.0f);
		this.b = Math.round(c.b * 255.0f);
	}
	
	public Color(int r, int g, int b)
	{
		this(255, r, g, b);
	}
	
	public Color(int a, int r, int g, int b)
	{
		this.a = a;
		
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	public Colorf toColorf()
	{
		return new Colorf(this);
	}
}