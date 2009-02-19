package MTUI_WT.Processing;

import java.awt.event.MouseListener;

public interface IProcessingApplet extends MouseListener {
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
