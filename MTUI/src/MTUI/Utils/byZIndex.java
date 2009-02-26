package MTUI.Utils;

import java.util.Comparator;

import MTUI.Controls.IMTControl;

public class byZIndex implements Comparator{

	@Override
	public int compare(Object obj1, Object obj2) {
		return  ((IMTControl)obj1).getZIndex()-((IMTControl)obj2).getZIndex();
	}

}
