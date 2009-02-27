package MTUI.Utils;

import java.util.Comparator;

import MTUI.Controls.IMTControl;

public class byZIndex implements Comparator<IMTControl>{

	@Override
	public int compare(IMTControl c1, IMTControl c2) {
		return  c1.getZIndex()-c2.getZIndex();
	}

}
