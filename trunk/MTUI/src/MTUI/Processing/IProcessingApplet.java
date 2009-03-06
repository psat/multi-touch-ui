package MTUI.Processing;

import tuio.TuioListener;


/**
 * An extended interface from TuioListener that provide the implementation of applets that contains processing programming
 * <p>
 * TuioListener belongs to Tuio.jar and provides the listener for the cursors and objects detected on tBeta application
 * @author Nuno Santos
 * @author Paulo Teixeira
 *
 */
public interface IProcessingApplet extends TuioListener {
	/**
	 * First draw of the Processing Applet.<p>
	 * Configuration of the UI
	 */
	void setup();
	
	/**
	 * Method responsible for the constant draw of the UI
	 */
	void draw();

}
