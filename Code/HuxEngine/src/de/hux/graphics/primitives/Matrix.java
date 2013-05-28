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
	
	public final int M11;
	public final int M12;
	public final int M21;
	public final int M22;
	public final int M31;
	public final int M32;
	
	public Matrix()
	{
		this.M11 = 0;
		this.M12 = 0;
		this.M21 = 0;
		this.M22 = 0;
		this.M31 = 0;
		this.M32 = 0;
		
	}
	
}
