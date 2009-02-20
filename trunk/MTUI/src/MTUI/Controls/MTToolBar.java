package MTUI.Controls;

import java.awt.MenuComponent;
import java.util.ArrayList;

import processing.core.PApplet;
import tuio.TuioCursor;
import MTUI.Controls.*;

/**
 * An implementation of a Tool bar for Processing applet. 
 * You add MTToolBarButton objects to the tool bar to construct a tool bar. 
 * 
 * @author Nuno Santos
 * @author Paulo Teixeira
 * 
 */
public class MTToolBar extends MTAbstractControl{

	private static final long serialVersionUID = 1L;

	private ArrayList<MTToolBarButton> Items = new ArrayList<MTToolBarButton>();
	
	
	@Override
	public void DrawControl(PApplet app){
		app.fill(this.getBackground().getRed(),this.getBackground().getGreen(), this.getBackground().getBlue());
		app.rect((float)this.getBounds().getX(), (float)this.getBounds().getY(), (float)this.getBounds().getWidth(), (float)this.getBounds().getHeight());
	
	
		for(MTToolBarButton item : Items){
			item.setBounds(5, 5, this.getHeight(), this.getHeight()-10);
			item.DrawControl(app);
		 
		
		}
		
	}
	
	
	public ArrayList<MTToolBarButton> getItems(){
		return this.Items;
	}


	public void addControl(MTToolBarButton toolbarButton) {
		if(toolbarButton.getBackground()==null)
			toolbarButton.setBackground(this.getBackground());
		this.Items.add(toolbarButton);
		
	}
	
	@Override
	public void addTuioCursor(TuioCursor cursor) {
		for(IMTControl control : this.Items){
			control.addTuioCursor(cursor);
		}
	}
	@Override
	public void updateTuioCursor(TuioCursor cursor) {
		for(IMTControl control : this.Items){
			control.updateTuioCursor(cursor);
		}
	}
	@Override
	public void removeTuioCursor(TuioCursor cursor) {
		for(IMTControl control : this.Items){
			control.removeTuioCursor(cursor);
		}
	}
}
