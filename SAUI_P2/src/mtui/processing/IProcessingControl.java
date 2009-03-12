package mtui.processing;

import processing.core.PApplet;

/**
 * Interface that defines an structure to the objects in order to be added to the processing applet
 * 
 * @author Nuno Santos
 *
 */
public interface IProcessingControl {
	
	/**
	 * Method that is call recusrsivly to the all objects in the canvas of the processing applet
	 * 
	 * @param aApp (PApplet) Processing applet responsible for the object's draw
	 */
	void DrawControl(PApplet aApp);

	/**
	 * set a deep order on the processing canvas
	 * 
	 * @param aZIndex (int) index indicating level of deep. (0 is the deepest)
	 */
	void setZIndex(int aZIndex);
	/**
	 * get the deep index order
	 * @return (int) 0 is the deepest
	 */
	int getZIndex();
}
