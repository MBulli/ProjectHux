package de.hux.graphics.primitives;

public class Rectangle
{
	public final float x;
	public final float y;
	public final float width;
	public final float height;
	
	public final float left;
	public final float top;
	public final float right;
	public final float bottom;
	
	public Rectangle(float x, float y, float width, float height)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		this.left = x;
		this.top = y;
		this.right = x + width;
		this.bottom = x + width + y + height;
	}
}
