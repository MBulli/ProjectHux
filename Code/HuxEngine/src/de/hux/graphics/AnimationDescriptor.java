package de.hux.graphics;

public final class AnimationDescriptor
{
	private float duration;
	private float delay;
	private AnimationContext context;
	
	public AnimationDescriptor(float delay, float duration)
	{
		this(delay, duration, null);
	}
	
	public AnimationDescriptor(float delay, float duration, AnimationContext context)
	{
		this.delay = delay;
		this.duration = duration;
		this.context = context;
	}
	
	public void setAnimations(AnimationContext context)
	{
		this.context = context;
	}
	
	public float getDuration()
	{
		return this.duration;
	}
	
	public void setDuration(float durationInSec)
	{
		this.duration = durationInSec;
	}
	
	public float getDelay()
	{
		return this.delay;
	}
	
	public void setDelay(float delayInSec)
	{
		this.delay = delayInSec;
	}
	
	public AnimationContext getContext()
	{
		return context;	
	}
}
