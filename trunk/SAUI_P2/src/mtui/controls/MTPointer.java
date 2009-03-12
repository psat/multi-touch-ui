package mtui.controls;

import java.awt.*;

import java.util.ArrayList;


public class MTPointer extends MTAbstractPointer {

	
	private static final long serialVersionUID = 1L;
	
	
	public MTPointer(int fingerID, ArrayList<MTAbstractControl> appControls, Rectangle aBounds) {
		super(fingerID, appControls, aBounds);
		this.setBackground(new Color(0,205,0));
	}

	





}
