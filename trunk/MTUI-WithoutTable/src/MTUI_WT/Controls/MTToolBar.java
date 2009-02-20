package MTUI_WT.Controls;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import processing.core.PApplet;

public class MTToolBar extends MTAbstractControl {

	private static final long serialVersionUID = 1L;

	private ArrayList<IMTControl> Items = new ArrayList<IMTControl>();
	
	
	@Override
	public void DrawControl(PApplet app){
		app.fill(this.getBackground().getRed(),this.getBackground().getGreen(), this.getBackground().getBlue());
		app.rect((float)this.getBounds().getX(), (float)this.getBounds().getY(), (float)this.getBounds().getWidth(), (float)this.getBounds().getHeight());
	
	
		for(IMTControl item : Items){
			((MTToolBarButton)item).setBounds(5, 5, this.getHeight(), this.getHeight()-10);
			((MTToolBarButton)item).DrawControl(app);
			
		
		}
		
	}
	
	
	public ArrayList<IMTControl> getItems(){
		return this.Items;
	}


	public void addControl(MTToolBarButton toolbarButton) {
		if(toolbarButton.getBackground()==null)
			toolbarButton.setBackground(this.getBackground());
		this.Items.add(toolbarButton);
		
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		for(IMTControl item: this.Items){
			if(item instanceof MTToolBarButton){
				MTToolBarButton button = (MTToolBarButton) item;
				if(button.getBounds().intersects(new Rectangle(e.getX(), e.getY(), 2,2)))
					button.setMouseOver(true);
				else
					button.setMouseOver(false);
			}
		}
		// TODO Auto-generated method stub
		super.mouseMoved(e);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		for(IMTControl item: this.Items){
			if(item instanceof MTToolBarButton){
				MTToolBarButton button = (MTToolBarButton) item;
				if(button.getBounds().intersects(new Rectangle(e.getX(), e.getY(), 2,2)))
					if (button.getMousePressed()) button.setMousePressed(false);
					else button.setMousePressed(true);
			}
		}
		
		super.mousePressed(e);
	}
	

	
	
	
}
