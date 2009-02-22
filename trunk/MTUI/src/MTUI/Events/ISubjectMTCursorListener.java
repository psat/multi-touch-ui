package MTUI.Events;

public interface ISubjectMTCursorListener {
	
	public void addMTCursorListener(IMTCursorListener CursorListener);
	public void removeMTCursorListener(IMTCursorListener CursorListener);
	public void fireMTCursorListener(MTCursorEvent e);
}
