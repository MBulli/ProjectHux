package de.hux.graphics;

import de.hux.graphics.primitives.Color;
import de.hux.graphics.primitives.Vector2D;

public interface GraphicAdapter 
{
	Shape createRectangle(Vector2D[] points, Color color);
	Shape createRectangle(Vector2D pt1, Vector2D pt2, Vector2D pt3, Vector2D pt4, Color color);
	
	Shape createTriangleShape(Vector2D pt1, Vector2D pt2, Vector2D pt3, Color color);
	Shape createTriangleShape(Vector2D pt1, Vector2D pt2, Vector2D pt3, Color color1, Color color2, Color color3);
	
	void addDrawableToWorld(Drawable drawable);
	
	void Draw();
}
