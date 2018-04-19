package serviceinterface;

import java.util.List;

import model.Pictures;

public interface PictureService {
	public void insertPicture(Pictures picures);
	
	public void delelePicture(String tbname, Integer idhorseonsale);
	
	public List<String> selectPicture(String tbname, Integer idhorseonsale);
	
}
