//é para apagar.
package shapes;

import MTUI.Controls.MTAbstractControl;
import processing.core.*;
import tuio.TuioCursor;

@SuppressWarnings("serial")
public class Square extends MTAbstractControl{
	
	public Square(){
	}
	
	@Override
	public void DrawControl(PApplet app) {
		//app.fill(this.getBackground().getRed(),this.getBackground().getGreen(), this.getBackground().getBlue());
		app.rect(300, 300, 40, 40);
	}
	
	@Override
	public void addTuioCursor(TuioCursor cursor) {
		//this.cursorPressed = true;
		super.addTuioCursor(cursor);
	}
}
