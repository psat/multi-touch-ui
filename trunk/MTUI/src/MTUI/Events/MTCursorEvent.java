package MTUI.Events;

import java.awt.Component;
import java.awt.event.MouseEvent;

public class MTCursorEvent extends MouseEvent {




	

	public MTCursorEvent(Component source, int id, long when, int modifiers,
			int x, int y, int clickCount, boolean popupTrigger, int button) {
		super(source, id, when, modifiers, x, y, clickCount, popupTrigger, button);
	}
	public MTCursorEvent(Component source, int id, long when, int modifiers,
			int x, int y, int clickCount, boolean popupTrigger) {
		super(source, id, when, modifiers, x, y, clickCount, popupTrigger);
	}
	
	public MTCursorEvent(Component source, int id, long when, int modifiers,
			int x, int y, int abs, int abs2, int clickCount,
			boolean popupTrigger, int button) {
		super(source, id, when, modifiers, x, y, abs, abs2, clickCount, popupTrigger,
				button);
	}

	private static final long serialVersionUID = 1L;

}
