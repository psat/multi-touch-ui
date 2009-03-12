package mtui.controls;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

import mtui.processing.IProcessingApplet;
import mtui.processing.IProcessingControl;


import processing.core.PApplet;


/**
 * 
 * @author Nuno Santos
 * @author Paulo Teixeira
 *
 */
public interface IMTControl extends IProcessingControl, ICursorEvents {
	

	void Resize(int aDistX, int aDistY, int aOtherDistX, int aOtherDistY);
	void Move(int aDistX, int aDistY);
	

}
