package MTUI_WT.Controls;

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





	
	
}
