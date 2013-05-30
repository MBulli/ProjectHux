package de.hux.graphics.internal;

import de.hux.graphics.primitives.Matrix;

public final class GLHelper
{
	private GLHelper()
	{
		
	}
	
	public static float[] ConvertToGLComponents(Matrix m)
	{
		/*
		 *  OpenGL benötigt die Matrix als float[16] also in Form einer 4x4 Matrix
		 *  
		 * +-           -+
		 * | 0  4  8  12 |
		 * | 1  5  9  13 |
		 * | 2  6  10 14 |
		 * | 3  7  11 15 |
		 * +-           -+
		 * 
		 * wir erzeugen die 4x4 Matrix wie folgt:
		 *
		 * +-              -+
		 * | M11  M12  0  0 |
		 * | M21  M22  0  0 |
		 * | M31  M32  1  0 |
		 * |  0    0   0  1 |
		 * +-              -+
		 */
		
		return new float[] { m.M11, m.M21, m.M31, 0, m.M12, m.M22, m.M32, 0, 0, 0, 1, 0, 0, 0, 0, 1 };
	}
}
