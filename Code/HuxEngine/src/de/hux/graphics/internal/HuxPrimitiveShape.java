package de.hux.graphics.internal;


import javax.media.opengl.GL2;

import de.hux.graphics.*;
import de.hux.graphics.primitives.Vector2D;

import static javax.media.opengl.GL.*;  // GL constants


public class HuxPrimitiveShape extends HuxDrawable implements Shape
{
	private final int type;
	private Vector2D[] vertices;
	private Colorf[] colors;
	
	public HuxPrimitiveShape(int type, Vector2D[] vertices, Colorf[] colors)
	{
		// TODO: type really required?
		// 0 = Triangle, 1 = Rectangle
		this.type = type;
		
		this.vertices = vertices;
		this.colors = colors;
	}
	
	@Override
	public void Render(GL2 gl)
	{			
		gl.glBegin(GL_TRIANGLE_FAN);
		
			for(int i = 0; i < this.vertices.length; i++)
			{
				gl.glColor3f(colors[i].r, colors[i].g, colors[i].b);
				gl.glVertex2f(vertices[i].x, vertices[i].y);
			}
				
		gl.glEnd();
	}
	
	@Override
	public int getShapeType()
	{
		return this.type;
	}

	@Override
	public Vector2D[] getPoints()
	{
		return this.vertices;
	}
	
	@Override
	public Shape Clone()
	{
		return new HuxPrimitiveShape(this.type, this.vertices, this.colors);
	}
}
