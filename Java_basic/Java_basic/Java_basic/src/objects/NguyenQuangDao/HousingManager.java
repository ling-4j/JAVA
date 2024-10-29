package objects.NguyenQuangDao;

import java.util.*;

public interface HousingManager {
	
	public boolean addTile(Housing t);
	public boolean editTile(Housing t);
	public boolean delTile(Housing t);
	public List<Housing> searchHousing(String name);
	public List<Housing> sortedHousing(boolean isASC);
}
