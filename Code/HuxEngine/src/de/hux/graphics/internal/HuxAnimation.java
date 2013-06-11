package de.hux.graphics.internal;

import java.util.Date;

import de.hux.graphics.AnimationContext;
import de.hux.graphics.Drawable;

public class HuxAnimation
{
	private final int delay;
	private final int duration;
		
	private HuxAnimationCallback callback;
	
	private long startTime;
	private long lastUpdateTime;
		
	private boolean isStoped;
	
	public HuxAnimation(float duration, float delay)
	{
		this.delay = (int) Math.floor(delay * 1000); // sec -> ms
		this.duration = (int) Math.floor(duration * 1000);
	}
	
	void setCallback(HuxAnimationCallback cb)
	{
		this.callback = cb;
	}
	
	public boolean getIsStoped()
	{
		return isStoped;
	}
	
	void Start()
	{
		startTime = new Date().getTime();
		
		
		isStoped = false;
	}
	
	void Stop()
	{
		
		
		isStoped = true;
	}
	
	void Update()
	{
		// TODO get time from canvas
		long newUpdateTime = new Date().getTime();
		
		
		{
			long delta = newUpdateTime - lastUpdateTime;
			float progress = (newUpdateTime - startTime) / (float)duration;
			
			System.out.printf("s: %d c: %d c-s: %d d: %d p: %f\n", startTime, newUpdateTime, (newUpdateTime - startTime), duration, progress);
			
			progress = Math.min(1.0f, progress);
			
			this.callback.UpdateAnimation(progress);
			
			if (progress == 1.0f)
			{
				Stop();
			}
			
		}
		
		lastUpdateTime = newUpdateTime;
	}
}
