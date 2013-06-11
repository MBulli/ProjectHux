package de.hux.graphics;

public interface AnimationManager
{
	boolean getIsActive();
	
	void Begin();
	void End();
	
	Animation CreateAnimation(AnimationDescriptor animDesc);
}
