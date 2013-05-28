package de.hux.graphics;

import de.hux.graphics.primitives.Rectangle;
import de.hux.graphics.primitives.RotateTransform;
import de.hux.graphics.primitives.ScaleTransform;
import de.hux.graphics.primitives.Vector2D;

public interface Drawable
{
	void setPosition(Vector2D pos);
	Vector2D getPosition();
	
	void setRotation(RotateTransform rotate);
	RotateTransform getRotation();
	
	void setScale(ScaleTransform scale);
	ScaleTransform getScale();
	
	Drawable Clone();
	
	Rectangle getBoundingBox();
}
