package de.hux.graphics.internal;

import java.io.IOException;

import javax.media.opengl.GLException;

import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;

public class HuxTexture {
	
	private Texture texture;
	private int Pattern_widht;
	
	private String Filename;
	private String Type;
	private String Name;
	
	public HuxTexture()
	{
		
	}
	
	//Name = HashMap key
	public HuxTexture(String name)
	{
		this.Name = name;
	}
	
	
	public void setTexture(String filename, String type)
	{
		this.Filename = filename;
		this.Type = type;
	}
	
	//gibt die reine GL Texture zurück
	public Texture getTexture()
	{
		if (this.texture != null)
		{
		return this.texture;
		} else return null;
	}
	
	public String getFilename()
	{
		return this.Filename;
	}
	
	public void setPattern(int Width)
	{
		if (Width > 0) this.Pattern_widht = Width;
	}

}
