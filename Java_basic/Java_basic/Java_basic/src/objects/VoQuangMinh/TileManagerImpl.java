package objects.VoQuangMinh;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.StringReader;
import java.util.*;

import myio.MyStream;



public class TileManagerImpl implements TileManager,Serializable {
	private static final long serialVersionUID = 1L;
	public List<Tile> list;
	private static final String FILE_NAME = "Tile.bin";
	public TileManagerImpl() {
		list = new ArrayList<Tile>();
		loadData();
	}

	
	@Override
	public boolean addTile(Tile t) {
		// TODO Auto-generated method stub
		boolean find = false;
		for(Tile item: this.list) {
			if(item.getproduct_id() == t.getproduct_id()) {
				find = true;
				break;
			}
			
		}
		if(!find) {
			this.list.add(t);
			this.exportFile();
			return true;
		} else {
			//Tawng so luong trong kho
			return false;
		}
	}
	
	@Override
	public boolean editTile(Tile t) {
		// TODO Auto-generated method stub
		boolean find = false;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getproduct_id().equals(t.getproduct_id())) {
				list.set(i, t);
				find = true;
				this.exportFile();
				break;
			}
			
		}
		if(!find) {
			return true;
		} else {
			//Tawng so luong trong kho
			return false;
		}
	}

	
	@Override
	public boolean delTile(Tile t) {
		// TODO Auto-generated method stub
		boolean find = false;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getproduct_id().equals(t.getproduct_id())) {
				list.remove(i);
				find = true;
				this.exportFile();
				break;
			}
		}
		return find;
	}

	@Override
	public List<Tile> searchTileByName(String name) {
		// TODO Auto-generated method stub
		List<Tile> results = new ArrayList<Tile>();
		for(Tile item: this.list) {
			if(item.getproduct_name().contains(name)) {
				results.add(item);
			}
			
		}
		return results;
	}

	

	@Override
	public List<Tile> searchTileByPrice(double price) {
		// TODO Auto-generated method stub
		List<Tile> results = new ArrayList<Tile>();
		for(Tile item: this.list) {
			if(item.getproduct_price()== price) {
				results.add(item);
			}
			
		}
		return results;
	}
	
	@Override
	public List<Tile> searchTileByBrand(String brand) {
		// TODO Auto-generated method stub
		List<Tile> results = new ArrayList<Tile>();
		for(Tile item: this.list) {
			if(item.getTile_brand().contains(brand)) {
				results.add(item);
			}
			
		}
		return results;
	}
	
	@Override
	public List<Tile> sortedTileByPrice(boolean isASC) {
		// TODO Auto-generated method stub
//		List<Tile> results = new ArrayList<Tile>();
		
		this.list.sort(Comparator.comparing(Tile::getproduct_price));
		if(!isASC) {
			Collections.reverse(list);
		}
		return null;
	}

	
	@Override
	public List<Tile> sortedTileByBrand(boolean isASC) {
		// TODO Auto-generated method stub
		this.list.sort(Comparator.comparing(Tile::getTile_brand));
		if(!isASC) {
			Collections.reverse(list);
		}
		return null;
	}
	@Override
	public List<Tile> sortedTileByType(boolean isASC) {
		// TODO Auto-generated method stub
		this.list.sort(Comparator.comparing(Tile::getTile_type));
		if(!isASC) {
			Collections.reverse(list);
		}
		return null;
	}
	
	
	public void printInfor() {
		this.list.forEach(go -> {
			System.out.println(go.toString());
			
		});
	}
	
	public void exportFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(list);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	@SuppressWarnings("unchecked")
	public void loadData() {
        try {
        	createFile();
        	FileInputStream fi = new FileInputStream(FILE_NAME);
        	ObjectInputStream ois = new ObjectInputStream(fi);
            list = (List<Tile>) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
	
	private void createFile() {
		File f = new File(FILE_NAME);
    	if(!f.exists()) {
    		list = new ArrayList<Tile>();
    		exportFile();
    	}
	}
	
	public static void main(String[] args) {
		
	}
}



