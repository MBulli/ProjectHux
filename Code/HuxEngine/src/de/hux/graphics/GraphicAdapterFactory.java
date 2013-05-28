package de.hux.graphics;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import com.jogamp.opengl.util.FPSAnimator;

import de.hux.graphics.internal.*;

public final class GraphicAdapterFactory 
{
	private GraphicAdapterFactory()
	{
		// nothing to do here, just chilling
	}
	
	public static GraphicAdapter CreateAdapter()
	{		
        final JFrame frame = new JFrame();
        
        frame.setTitle("Hux Graphics test");
        frame.pack();
        frame.setVisible(true);

		return CreateAdapter(frame);
	}
	
	public static GraphicAdapter CreateAdapter(JFrame frame)
	{
		final HuxGLCanvas canvas = new HuxGLCanvas(frame.getWidth(), frame.getHeight());
		final FPSAnimator animator = new FPSAnimator(canvas, 60, true);
		
		frame.addWindowListener(new WindowAdapter() {
	           @Override
	           public void windowClosing(WindowEvent e) {
	              // Use a dedicate thread to run the stop() to ensure that the
	              // animator stops before program exits.
	              new Thread() {
	                 @Override
	                 public void run() {
	                    // if (animator.isStarted()) animator.stop();
	                    System.exit(0);
	                 }
	              }.start();
	           }
	        });
		
		frame.getContentPane().add(canvas);
		
        animator.start();
		return canvas;
	}
}
