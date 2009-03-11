package MTUI.Controls.Compound;

import java.util.ArrayList;

import processing.core.PApplet;
import MTUI.Controls.Compound.IMTCompound;
import MTUI.Controls.Compound.Component.MTAbstractCompoundComponent;
import MTUI.Controls.MTAbstractControl;
import MTUI.Controls.MTAbstractPointer;

public class MTAbstractCompound extends MTAbstractControl implements IMTCompound {

	protected ArrayList<MTAbstractCompoundComponent> Controls = new ArrayList<MTAbstractCompoundComponent>();
	
	@Override
	public void DrawControl(PApplet app) {
		for(MTAbstractCompoundComponent component : this.Controls){
			component.DrawControl(app);	
		}
	}

	@Override
	public void addControl(MTAbstractCompoundComponent control) {
		control.UpdateSizeAndLocation(this.getBounds());
		if(control.getBackground()==null) control.setBackground(this.getBackground());
		this.Controls.add(control);
	}
	
	@Override
	public void setBounds(int x, int y, int width, int height) {
		super.setBounds(x, y, width, height);
		if(this.Controls!=null){
			for(MTAbstractCompoundComponent component: this.Controls)
				component.UpdateSizeAndLocation(this.getBounds());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void CursorAdd(MTAbstractPointer pointer) {
		super.CursorAdd(pointer);
		for(MTAbstractCompoundComponent component : 
						(ArrayList<MTAbstractCompoundComponent>)this.Controls.clone())
			if(component.getBounds().intersects(pointer.getBounds()))
				component.CursorAdd(pointer);
	}
	@SuppressWarnings("unchecked")
	@Override
	public void CursorOver(MTAbstractPointer pointer) {
		super.CursorOver(pointer);
		for(MTAbstractCompoundComponent component : 
						(ArrayList<MTAbstractCompoundComponent>) this.Controls.clone())
			if(component.getBounds().intersects(pointer.getBounds()))
				component.CursorOver(pointer);
	}
	@SuppressWarnings("unchecked")
	@Override
	public void CursorOut(MTAbstractPointer pointer) {
		super.CursorOut(pointer);
		for(MTAbstractCompoundComponent component : 
						(ArrayList<MTAbstractCompoundComponent>) this.Controls.clone())
			if(component.getBounds().intersects(pointer.getBounds()))
				component.CursorOut(pointer);
	}
	




}
