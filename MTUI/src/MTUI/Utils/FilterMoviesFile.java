package MTUI.Utils;

import java.io.File;
import java.io.FilenameFilter;

public class FilterMoviesFile implements FilenameFilter {

	@Override
	public boolean accept(File dir, String name) {
		if(name.indexOf(".mpeg")!=-1 || name.indexOf(".mov")!=-1 || name.indexOf(".wmv")!=-1){
			return true;
		}
		else return false;
	}

}
