package de.hux.graphics.internal;

import java.io.IOException;
import java.io.InputStream;

import javax.media.opengl.GL2;
import javax.media.opengl.GLException;

import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;

import de.hux.graphics.Drawable;
import de.hux.graphics.Sprite;
import de.hux.graphics.primitives.Colorf;
import de.hux.graphics.primitives.Vector2D;

public class HuxSprite extends HuxDrawable implements Sprite
{

	private Vector2D[] vertices;
	private Colorf[] colors;
	
	//Texture
	private Texture texture;
	private String TextureName = null;
	boolean Transparent = false;
	private float Alpha;
	
	private boolean load = false;
	
	

	public HuxSprite(HuxGLCanvas canvas, Vector2D[] Vertices)
	{
		super(canvas);
		
		this.vertices = Vertices;
	}
	
	//Flag setzen und Wert übernehemn
	public void setTransparency(float value)
	{
		this.Transparent = true;
		this.Alpha = value;
	}
	
	
	//Texture über den TextureManager beziehen, wird einmalig beim 1-Render durchlauf geladen
	// im moment bekommt jeder Sprite seinen eigenen Stream etc.
	//TODO: Texture.getTarget() ist für eine bessere Performance
	public void loadTexture()
	{	
		TextureManager tm = glCanvas.getTextureManager();
		try {
			this.texture = TextureIO.newTexture(tm.getTextureStream(this.TextureName), false,".png");
		} catch (GLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void UpdateInternal()
	{
		
	}
	
	@Override
	public void RenderInternal(GL2 gl) 
	{
		//Trivial
		if (this.TextureName != null)
		{
			if(!load){
				loadTexture();
				load = true;
				System.out.println("Texture geladen");
			}
		}
		
		texture.bind(gl);
		texture.enable(gl);
		
		//Da der Sprite mit Texture gezeichnet wird wird das ganze in eine Switch/Case bedinung genkünpft. 
		//Die Texture wird immer komplett aufgespannt
		
		gl.glBegin(gl.GL_TRIANGLE_FAN);
		for (int i = 0; i < this.vertices.length; i++)
		{
			
			switch (i)
			{
			case 0 :
			{
				if (this.Transparent)
				{
					gl.glColor4f(Alpha,Alpha,Alpha,Alpha);
				}
				
				//gl.glColor3f(colors[i].r, colors[i].g, colors[i].b);
				gl.glVertex2f(vertices[i].x, vertices[i].y);
				gl.glTexCoord2f(0.0f, 0.0f);
				break;
			}
			case 1 :
			{
				if (this.Transparent)
				{
					gl.glColor4f(Alpha,Alpha,Alpha,Alpha);
				}
				
				//gl.glColor3f(colors[i].r, colors[i].g, colors[i].b);
				gl.glVertex2f(vertices[i].x, vertices[i].y);
				gl.glTexCoord2f(1.0f, 0.0f);
				break;
			}
			case 2 :
			{
				if (this.Transparent)
				{
					gl.glColor4f(Alpha,Alpha,Alpha,Alpha);
				}
				
				//gl.glColor3f(colors[i].r, colors[i].g, colors[i].b);
				gl.glVertex2f(vertices[i].x, vertices[i].y);
				gl.glTexCoord2f(1.0f, 1.0f);
				break;
			}
			case 3:
			{
				if (this.Transparent)
				{
					gl.glColor4f(Alpha,Alpha,Alpha,Alpha);
				}
				
				//gl.glColor3f(colors[i].r, colors[i].g, colors[i].b);
				gl.glVertex2f(vertices[i].x, vertices[i].y);
				gl.glTexCoord2f(0.0f, 1.0f);
				break;
			}
			
			}
			//farben zurücksetzen
			gl.glColor4f(1.0f,1.0f,1.0f,1.0f);
			
		}
		
		gl.glEnd();
		texture.disable(gl);
	}
	
	//Trivial
	public void attachTexture(String Name)
	{
		this.TextureName = Name;
	}
		
	@Override
	public Drawable Clone() {
		// TODO Auto-generated method stub
		return null;
	}

	

}