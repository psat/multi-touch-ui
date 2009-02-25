package MTUI.Controls;

import java.awt.Dimension;
import java.awt.Point;

import processing.core.PApplet;
import tuio.TuioCursor;
import tuio.TuioListener;

/**
 * 
 * @author Nuno Santos
 * @author Paulo Teixeira
 *
 */
public interface IMTControl extends TuioListener {
	
	void DrawControl(PApplet app);
	
	void Resize(Dimension aSize);
	void Move(Point aLocation);
	

}
