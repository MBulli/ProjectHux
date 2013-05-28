package de.hux.graphics;

import de.hux.graphics.primitives.Vector2D;

public interface Shape extends Drawable
{
	int getShapeType();
	Vector2D[] getPoints();
	
	@Override
	public Shape Clone();
}


