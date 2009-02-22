package MTUI.Events;

import java.util.EventListener;

public interface IMTCursorListener extends EventListener {

	public void processCursorPress();
	public void processCursorRelease();
	public void processCursorMove();
}
