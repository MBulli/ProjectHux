package de.hux.graphics.primitives;

public class Rectangle
{
	public final int x;
	public final int y;
	public final int width;
	public final int height;
	
	public final int left;
	public final int top;
	public final int right;
	public final int bottom;
	
	public Rectangle(int x, int y, int width, int height)
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
