package objects.VoQuangMinh;

import java.util.*;

public interface TileManager {
	
	public boolean addTile(Tile t);
	public boolean editTile(Tile t);
	public boolean delTile(Tile t);
	public List<Tile> searchTileByName(String name);
	public List<Tile> searchTileByPrice(double price);
	public List<Tile> searchTileByBrand(String brand);
	public List<Tile> sortedTileByPrice(boolean isASC);
	public List<Tile> sortedTileByBrand(boolean isASC);
	public List<Tile> sortedTileByType(boolean isASC);
}
