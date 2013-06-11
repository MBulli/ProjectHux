package de.hux.graphics.internal;

import java.io.InputStream;
import java.util.HashMap;

import javax.media.opengl.GL2;
import javax.media.opengl.GLContext;

import com.jogamp.opengl.util.texture.Texture;

public class TextureManager 
{
	private static GL2 gl;
	
	//Hashmap 
	private static HashMap<String,HuxTexture> Textures = new HashMap<String,HuxTexture>();
	

	public TextureManager()
	{
		
	}
		
	public  void createTexture(String filename, String type, String name)
	{
		HuxTexture texture = new HuxTexture();

		texture.setTexture(filename, type);
		Textures.put(name, texture);
		
	}
	
	public Texture getTextureGL(String Name)
	{
		HuxTexture texture = new HuxTexture();
		texture = Textures.get(Name);
		return texture.getTexture();
	
	}
	
	public InputStream getTextureStream(String Name)
	{
		HuxTexture texture = Textures.get(Name);
		InputStream is = this.getClass().getResourceAsStream(texture.getFilename());
		return is;
	}
}
