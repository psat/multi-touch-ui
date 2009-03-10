package MTUI.Controls.Toolbar;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import processing.core.PApplet;
import tuio.TuioCursor;
import MTUI.Constants.AppletConst;
import MTUI.Controls.MTAbstractControl;
import MTUI.Controls.MTAbstractPointer;
import MTUI.Controls.Toolbar.Buttons.MTAbstractToolBarButton;

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

	private ArrayList<MTAbstractToolBarButton> Items = new ArrayList<MTAbstractToolBarButton>();
	
	public MTToolBar(){
		this.setZIndex(5000);
	}
	
	@Override
	public void DrawControl(PApplet app){
		app.fill(this.getBackground().getRed(),this.getBackground().getGreen(), this.getBackground().getBlue());
		app.rect((float)this.getBounds().getX(), (float)this.getBounds().getY(), (float)this.getBounds().getWidth(), (float)this.getBounds().getHeight());
	
		int i=0;
		int margin = 2* AppletConst.TOOLBAR_BUTTON_MARGIN;
		for(MTAbstractToolBarButton item : Items){
			//if(i>0) margin=2*AppletConst.TOOLBAR_BUTTON_MARGIN;
			//else margin = AppletConst.TOOLBAR_BUTTON_MARGIN;
			
			item.setBounds(margin+this.getHeight()*i, AppletConst.TOOLBAR_BUTTON_MARGIN, this.getHeight()-margin, this.getHeight()-margin);
			item.DrawControl(app);
			i++;
		
		}
	}
	
	
	public ArrayList<MTAbstractToolBarButton> getItems(){
		return this.Items;
	}


	public void addControl(MTAbstractToolBarButton toolbarButton) {
		if(toolbarButton.getBackground()==null)
			toolbarButton.setBackground(this.getBackground());
		this.Items.add(toolbarButton);
	}
	
	public void setInactiveAllChildButtons(){
		
		for(MTAbstractToolBarButton button : this.Items)
			button.setActive(false);
	}

	@Override
	@Deprecated
	public void Move(int aDistX, int aDistY) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Deprecated
	public void Resize(int distX, int distY, int otherDistX, int intOtherDistY) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void CursorAdd(MTAbstractPointer pointer) {
		this.getPointers().add(pointer);
		for(MTAbstractToolBarButton button :this.Items){
			if(button.getBounds().intersects(pointer.getBounds())){
				button.CursorAdd(pointer);
				pointer.setCurrentControl(button);
				break;
			}
		}
		
	}

	@Override
	public void CursorOut(MTAbstractPointer pointer) {
		this.getPointers().remove(pointer);
		for(MTAbstractToolBarButton button :this.Items){
			if(button.getPointers().contains(pointer)){
				button.CursorOut(pointer);
				break;
			}
		}
		
	}

	@Override
	public void CursorOver(MTAbstractPointer pointer) {
		if(!this.getPointers().contains(pointer)){
			this.getPointers().add(pointer);
		}
		for(MTAbstractToolBarButton button :this.Items){
			if(button.getBounds().intersects(pointer.getBounds())){
				button.CursorOver(pointer);
				pointer.setCurrentControl(button);
				break;
			}
		}
	}



}
