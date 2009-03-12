package mtui.controls;

/**
 * Interface for the cursor events.
 * <P>
 * Define any action at the interactive table that interacts with an object.
 * @author Nuno Santos
 *
 */
public interface ICursorEvents {

	/**
	 * When the cursor leaves the object, either when finger is up or the movement leaves the object behind
	 * @param pointer (MTPointer) The cursor that is responsible for the action
	 */
	void CursorOut(MTAbstractPointer pointer);
	
	/**
	 * When the cursor goes trough an object
	 * @param pointer (MTPointer) The cursor that is responsible for the action
	 */
	void CursorOver(MTAbstractPointer pointer);
	
	/**
	 * When new cursor is added and is over an object
	 * @param pointer (MTPointer) The cursor that is responsible for the action
	 */
	void CursorAdd(MTAbstractPointer pointer);
}
