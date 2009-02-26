package MTUI.Controls;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import processing.core.PApplet;
import tuio.TuioCursor;
import MTUI.Constants.AppletConst;

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
	
		int i=0;
		int margin;
		for(MTToolBarButton item : Items){
			if(i>0) margin=2*AppletConst.TOOLBAR_BUTTON_MARGIN;
			else margin = AppletConst.TOOLBAR_BUTTON_MARGIN;
			
			item.setBounds(margin+this.getHeight()*i, 5, this.getHeight(), this.getHeight()-10);
			item.DrawControl(app);
			i++;
		
		}
		
	}
	
	
	public ArrayList<MTToolBarButton> getItems(){
		return this.Items;
	}


	public void addControl(MTToolBarButton toolbarButton) {
		if(toolbarButton.getBackground()==null)
			toolbarButton.setBackground(this.getBackground());
		toolbarButton.setParent(this);
		this.Items.add(toolbarButton);
	}
	
	public void setInactiveAllChildButtons(){
		
		for(MTToolBarButton button : this.Items)
			button.setActive(false);
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

	@Override
	public void Move(Point location) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Resize(Dimension size) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void refresh(long arg0) {
		// TODO Auto-generated method stub
		
	}
}
