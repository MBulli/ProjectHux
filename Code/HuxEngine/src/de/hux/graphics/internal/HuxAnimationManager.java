package de.hux.graphics.internal;

import de.hux.graphics.Animation;
import de.hux.graphics.AnimationDescriptor;
import de.hux.graphics.AnimationManager;

public class HuxAnimationManager implements AnimationManager
{
	private boolean isActive;
	
	public void Begin()
	{
		isActive = true;
	}
	
	public void End()
	{
		isActive = false;
	}
	
	public boolean getIsActive()
	{
		return isActive;
	}
	
	@Override
	public Animation CreateAnimation(AnimationDescriptor animDesc)
	{
		// TODO Auto-generated method stub
		
		Begin();
		
		animDesc.getContext().UpdateAnimation();
		
		End();
		
		return null;
	}
}
