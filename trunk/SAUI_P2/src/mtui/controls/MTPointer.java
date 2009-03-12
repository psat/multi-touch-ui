package mtui.controls;

import java.awt.*;

import java.util.ArrayList;

/**
 * Extended class from <b>mtui.controls.MTAbstractPointer</b> representing the cursor of the interactive table.
 * <p>
 * Each finger at the interactive table represents one cursor. This cursor in the application is treated like an MTPointer.
 * @author Nuno Santos
 * @see mtui.controls.MTAbstractPointer
 *
 */

public class MTPointer extends MTAbstractPointer {

	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor of the MTPointer representing the finger in the interactive table
	 * @param fingerID (int) The ID provided from TuioCursor
	 * @param appControls (ArrayList<MTAbstractControl>) A list of the objects that exists on the canvas 
	 * @param aBounds (Rectangle) The size and location of the pointer for drawing
	 */
	public MTPointer(int fingerID, ArrayList<MTAbstractControl> appControls, Rectangle aBounds) {
		super(fingerID, appControls, aBounds);
		this.setBackground(new Color(0,205,0));
	}

	





}
