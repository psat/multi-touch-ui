package MTUI_WT.Processing;



public interface IProcessingApplet {
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
