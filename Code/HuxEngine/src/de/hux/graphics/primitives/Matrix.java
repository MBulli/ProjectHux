package de.hux.graphics.primitives;

public class Matrix
{
	/* 
	 * Matrix struktur:
	 * 
	 * / M11 M12 0 \
	 * | M21 M22 0 |
	 * \ M31 M32 1 /
	 * 
	 * Da wir uns nur in 2D befinden ist der letzte Vektor (3. Spalte) konstant.
	 */
	
	public final float M11;
	public final float M12;
	public final float M21;
	public final float M22;
	public final float M31;
	public final float M32;
	
	/*
	 * / 1 0 0 \
	 * | 0 1 0 |
	 * \ 0 0 1 /
	 */
	public static final Matrix identiy = new Matrix(1, 0, 0, 1, 0, 0);
	
	public Matrix()
	{
		this.M11 = 0;
		this.M12 = 0;
		this.M21 = 0;
		this.M22 = 0;
		this.M31 = 0;
		this.M32 = 0;
	}
	
	public Matrix(float m11, float m12, float m21, float m22, float m31, float m32)
	{
		this.M11 = m11;
		this.M12 = m12;
		this.M21 = m21;
		this.M22 = m22;
		this.M31 = m31;
		this.M32 = m32;
	}
	
	public Matrix Multiply(Matrix right)
	{
		float m11 = this.M11 * right.M11 + this.M12 * right.M21;
		float m12 = this.M11 * right.M12 + this.M12 * right.M22;
		float m21 = this.M21 * right.M11 + this.M22 * right.M21;
		float m22 = this.M21 * right.M12 + this.M22 * right.M22;
		float m31 = this.M31 * right.M11 + this.M32 * right.M21 + right.M31;
		float m32 = this.M31 * right.M12 + this.M32 * right.M22 + right.M32;
        
        return new Matrix(m11, m12, m21, m22, m31, m32);
	}
}
