package de.hux.graphics.primitives;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.media.opengl.GL2;

public class TransformGroup extends Transform
{
	private ArrayList<Transform> children;
	
	public TransformGroup()
	{
		this.children = new ArrayList<Transform>();
	}
	
	public TransformGroup(List<Transform> children)
	{
		this.children = new ArrayList<Transform>(children);
	}
	
	public TransformGroup(Transform[] children)
	{
		this.children = new ArrayList<Transform>(children.length);
		Collections.addAll(this.children, children);
	}
	
	public void addChild(Transform child)
	{
		this.children.add(child);
	}
	
	public void removeChild(Transform child)
	{
		this.children.remove(child);
	}
	
	public void setChildren(List<Transform> children)
	{
		this.children = new ArrayList<Transform>(children);
	}
	
	public List<Transform> getChildren()
	{
		return this.children;
	}
	
	@Override
	public void Apply(GL2 gl)
	{
		for (Transform child: this.children)
		{
			child.Apply(gl);
		}
	}
}
