package mtui.controls.compound;

import mtui.controls.IMTControl;
import mtui.controls.compound.component.MTAbstractCompoundComponent;

/**
 * Interface that defines a compound control.
 * <p>
 * Compounds controls are defined for being an structure of other controls
 * 
 * @author Nuno Santos
 *
 */
public interface IMTCompound extends IMTControl {

	/**
	 * Add control to the compound control
	 * 
	 * @param control (MTAbstractCompoundComponent) Child control
	 */
	void addControl(MTAbstractCompoundComponent control);
	/**
	 * <b>Lock the object. </b>
	 * <p>Set inactive for iteraction as a draw object and allows user to interact as a piano instrument
	 */
	public void Lock();

	/**
	 * <b>Unlock the piano.</b> 
	 * <p>User stop interacting with the object as a piano, and can now interact as a draw object
	 */
	public void unLock();
	/**
	 * Retrieve piano lock information.
	 * @return (boolean) True -> Piano; False -> DrawObject
	 */
	public boolean IsLocked();
}
