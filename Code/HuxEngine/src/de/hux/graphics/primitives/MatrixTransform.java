package de.hux.graphics.primitives;

import javax.media.opengl.GL2;

import de.hux.graphics.internal.GLHelper;

public class MatrixTransform extends Transform
{
	private final Matrix transformMatrix;
	

	public MatrixTransform()
	{
		this.transformMatrix = Matrix.identiy;
	}
	
	public MatrixTransform(Matrix transformation)
	{
		this.transformMatrix = transformation;
	}
	
	@Override
	public void Apply(GL2 gl)
	{
		gl.glMultMatrixf(GLHelper.ConvertToGLComponents(this.transformMatrix), 0);
	}
}
