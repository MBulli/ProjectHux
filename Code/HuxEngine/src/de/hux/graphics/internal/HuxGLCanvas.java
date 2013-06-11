package de.hux.graphics.internal;

import java.awt.*;
import java.util.ArrayList;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.awt.GLCanvas;
import javax.media.opengl.glu.GLU;

import static javax.media.opengl.GL.*;  // GL constants
import static javax.media.opengl.GL2.*; // GL2 constants

import de.hux.graphics.*;
import de.hux.graphics.Shape;
import de.hux.graphics.primitives.Color;
import de.hux.graphics.primitives.Colorf;
import de.hux.graphics.primitives.Vector2D;

public class HuxGLCanvas extends GLCanvas implements GLEventListener, GraphicAdapter
{
	private static final long serialVersionUID = 1L;
	
	private GLU glu;
	private int clientWidth;
	private int clientHeight;
	
	private final AnimationManager animationManager = new HuxAnimationManager();
	private final TextureManager textureManger = new TextureManager();
		
	private final ArrayList<HuxDrawable> worldList;
	
	public HuxGLCanvas(int width, int height)
	{
		this.addGLEventListener(this);
		
		this.clientWidth = width;
		this.clientHeight = height;
		
		this.setPreferredSize(new Dimension(width, height));
		
		this.worldList = new ArrayList<HuxDrawable>();
	}
	
	public HuxGLCanvas(boolean fullscreen)
	{
		this.worldList = new ArrayList<HuxDrawable>();
	}
	
	@Override
	public void Draw()
	{
		this.display();
	}
	
	@Override
	public void addDrawableToWorld(Drawable drawable)
	{
		this.worldList.add((HuxDrawable)drawable);
	}
	
	@Override
	public Shape createTriangleShape(Vector2D pt1, Vector2D pt2, Vector2D pt3, Color color)
	{
		return this.createTriangleShape(pt1, pt2, pt3, color, color, color);
	}
	
	@Override
	public Shape createTriangleShape(Vector2D pt1, Vector2D pt2, Vector2D pt3, Color color1, Color color2, Color color3)
	{
		return new HuxPrimitiveShape(this, 0, new Vector2D[] { pt1, pt2, pt3 }, new Colorf[] { color1.toColorf(),  color2.toColorf(), color3.toColorf() });
	}
	
	@Override
	public Shape createRectangle(Vector2D[] points, Color color)
	{
		Colorf c = color.toColorf();
		return new HuxPrimitiveShape(this, 1, points, new Colorf[] { c, c, c, c });
	}
	
	@Override
	public Shape createRectangle(Vector2D pt1, Vector2D pt2, Vector2D pt3, Vector2D pt4, Color color)
	{
		Colorf c = color.toColorf();
		return new HuxPrimitiveShape(this, 1, new Vector2D[] { pt1, pt2, pt3, pt4 }, new Colorf[] { c, c, c, c });
	}
	
	@Override
	public Sprite createSprite(String texname, float x, float y, float width,
			float height)
	{
		// TODO @Alex Dateiendung aus texname nehmen
		textureManger.createTexture(texname + ".png", ".png", texname);
		// Test Sprites
		
		Vector2D[] v = { new Vector2D(0, 0),
						 new Vector2D(0, height),
						 new Vector2D(width, height),
						 new Vector2D(width, 0) };
		
		HuxSprite p = new HuxSprite(this, v);
		p.setPosition(new Vector2D(x, y));
		p.attachTexture(texname);
		
		return  p;
	}
	
	
	// JOGL overrides
	
	@Override
	public void init(GLAutoDrawable drawable)
	{
		GL2 gl = drawable.getGL().getGL2();
		glu = new GLU();
	    
		// Wir benutzten den Tiefentest um unsere 2D Objekte an der Z Ache zu sortieren,
		// so müssen wir nicht per Hand unsere Ebenen in der richtigen Reinfolge zeichnen
		//gl.glEnable(GL_DEPTH_TEST);
		
	    gl.glDepthFunc(GL_LESS);
	    
	    gl.glEnable(GL_TEXTURE_2D);
	    
	    //Alpha und Blending
		gl.glAlphaFunc(GL.GL_NEAREST, 0.1f);
		gl.glEnable(GL.GL_BLEND);
		gl.glBlendFunc(GL.GL_ONE, GL.GL_ONE_MINUS_SRC_ALPHA);
		
	    // "Kamera" konfigurieren
 		gl.glClearDepth(GL_DEPTH_BUFFER_BIT);
 		gl.glMatrixMode(GL_PROJECTION);
 		gl.glLoadIdentity();
 		gl.glViewport(0, 0, clientWidth, clientHeight);
 		// diese Zeile setzt unsere Projektionsmatrix auf eine Orthogonale.
 		// d.h. Elemente mit einem hohen Z-Wert werden nicht verzerrt
 		// um den Eindruck einer Tiefe zu vermitteln.
 		// TODO:  In den Tuts die ich gefunden habe werden entweder feste Werte
 		//        oder die Fenstergröße verwendet.
 		//		  Ersteres erzeugt ein virtuelles Koordinatensystem welches unabhänig der Auflösung ist
 		//		  Zweiteres erleaubt es Pixel genau bzw. 1:1 zu zeichen. Was ist nun sinnvoll? (Bulli)
 		gl.glOrtho(0, clientWidth, clientHeight, 0, 0, 1.0f);
	}
	
	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) 
	{
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glViewport(0, 0, width, height);
		gl.glMatrixMode(GL_PROJECTION);
		gl.glLoadIdentity();
		
		this.clientWidth = width;
		this.clientHeight = height;
		
		gl.glOrtho(0, width, 0, height,  0, 1);

		gl.glMatrixMode(GL_MODELVIEW);
		gl.glLoadIdentity();
	}
	
	@Override
	public void display(GLAutoDrawable drawable)
	{
		GL2 gl = drawable.getGL().getGL2();
		
		// siehe: http://wiki.delphigl.com/index.php/Tutorial_Matrix2
		gl.glMatrixMode(GL_MODELVIEW);
		gl.glLoadIdentity(); // model view matrix reseten
		
		gl.glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
				
		for (HuxDrawable item: this.worldList)
		{
			gl.glPushMatrix();
			
			item.Update();
			
			item.getTransform().Apply(gl);
			item.Render(gl);
			
			gl.glPopMatrix();
		}
		
	}

	@Override
	public void dispose(GLAutoDrawable arg0)
	{
		this.removeGLEventListener(this);
	}
	
	public AnimationManager getAnimationManger()
	{
		return animationManager;
	}
	
	public TextureManager getTextureManager()
	{
		return textureManger;
	}
}