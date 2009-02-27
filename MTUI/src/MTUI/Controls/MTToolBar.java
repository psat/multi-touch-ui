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
	
	public MTToolBar(){
		this.setZIndex(5000);
	}
	
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
		this.Items.add(toolbarButton);
	}
	
	public void setInactiveAllChildButtons(){
		
		for(MTToolBarButton button : this.Items)
			button.setActive(false);
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
	public void addPointer(MTPointer pointer) {
		for(MTToolBarButton button : this.Items){
			if(pointer.getBounds().intersects(button.getBounds())){
				button.addPointer(pointer);
				break;
			}
		}
		super.addPointer(pointer);
	}
	@Override
	public void removePointer(MTPointer pointer) {
		for(MTToolBarButton button : this.Items){
			if(button.getPointers().contains(pointer)){
				button.removePointer(pointer);
				break;
			}
		}
		super.removePointer(pointer);
	}

}
