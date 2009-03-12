package mtui.controls;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

import mtui.processing.IProcessingApplet;
import mtui.processing.IProcessingControl;


import processing.core.PApplet;


/**
 * Interface that defines the different handlers of controls 
 * @author Nuno Santos
 * 
 */
public interface IMTControl extends IProcessingControl, ICursorEvents {
	

	/**
	 * For resizing an object must have two pointers at the object.
	 * <p>
	 * Depending on the location of the cursors the resizing must be different, 
	 * because we have to consider that only size is affected or even location
	 * of the object should be changed.
	 * 
	 * 
	 * @param aDistX (int) the distance of the cursor movement in the xx axis
	 * @param aDistY (int) the distance of the cursor movement in the yy axis
	 * @param aOtherDistX (int) the distance to the other cursor in the xx axis
	 * @param aOtherDistY (int) the distance to the other cursor in the yy axis
	 */
	void Resize(int aDistX, int aDistY, int aOtherDistX, int aOtherDistY);
	
	/**
	 * Moving objects. Only single cursors can handle this.
	 * 
	 * @param aDistX (int) the distance of the cursor movement in the xx axis
	 * @param aDistY (int) the distance of the cursor movement in the yy axis
	 */
	void Move(int aDistX, int aDistY);
	

}
