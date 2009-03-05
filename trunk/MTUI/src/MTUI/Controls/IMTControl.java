package MTUI.Controls;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

import MTUI.Processing.IProcessingApplet;
import MTUI.Processing.IProcessingControl;

import processing.core.PApplet;


/**
 * 
 * @author Nuno Santos
 * @author Paulo Teixeira
 *
 */
public interface IMTControl extends IProcessingControl, ICursorEvents {
	

	void Resize(Dimension aSize);
	void Move(Point aLocation);
	

}
