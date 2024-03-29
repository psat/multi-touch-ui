package mtui.controls.compound;


import mtui.constants.DrawConstants;
import mtui.controls.MTAbstractPointer;
import mtui.controls.compound.component.MTAbstractCompoundComponent;
import processing.core.PApplet;

/**
 * An implementation of a Toolbar for Processing applet. 
 * You add MTToolBarButton objects to the tool bar to construct a toolbar. 
 * 
 * @author Nuno Santos
 * 
 */
public class MTToolbar extends MTAbstractCompound{

	private static final long serialVersionUID = 1L;

	
	@Override
	public void DrawControl(PApplet app){
		app.noStroke();
		app.fill(this.getBackground().getRed(),this.getBackground().getGreen(), this.getBackground().getBlue());
		app.rect((float)this.getX(), (float)this.getY(), (float)this.getWidth(), (float)this.getHeight());
	
		super.DrawControl(app);
	}
	
	
	public MTToolbar(){
		this.setZIndex(DrawConstants.TOOLBAR_ZINDEX);
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
		for(MTAbstractCompoundComponent button :this.Controls){
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
		for(MTAbstractCompoundComponent button :this.Controls){
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
		for(MTAbstractCompoundComponent button :this.Controls){
			if(button.getBounds().intersects(pointer.getBounds())){
				button.CursorOver(pointer);
				pointer.setCurrentControl(button);
				break;
			}
		}
	}






}
