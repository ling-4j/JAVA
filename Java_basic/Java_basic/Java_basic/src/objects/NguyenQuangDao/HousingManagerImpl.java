package objects.NguyenQuangDao;

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
import objects.VoQuangMinh.Tile;



public class HousingManagerImpl implements HousingManager,Serializable {
	private static final long serialVersionUID = 1L;
	public List<Housing> list;
	private static final String FILE_NAME = "Housing.bin";
	public HousingManagerImpl() {
		list = new ArrayList<Housing>();
		loadData();
	}
//	public TileManagerImpl(int n) {
//		this.list = new ArrayList<Tile>(n);
//		for(int i=0; i<this.list.size(); i++) {
//			this.list.get(i).setProduct_id(i);
//		}
//	}
	
	@Override
	public boolean addTile(Housing t) {
		// TODO Auto-generated method stub
		boolean find = false;
		for(Housing item: this.list) {
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
	public boolean editTile(Housing t) {
		// TODO Auto-generated method stub
		boolean find = false;
		for(Housing item: this.list) {
			if(item.getproduct_id().equals(t.getproduct_id())) {
				item.setproduct_name(t.getproduct_name());
				item.setproduct_price(t.getproduct_price());
				item.setproduct_total(t.getproduct_total());
				item.setHousing_location(t.getHousing_location());
				item.setHousing_size(t.getHousing_size());
				item.setHousing_status(t.getHousing_status());
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
	public boolean delTile(Housing t) {
		// TODO Auto-generated method stub
		boolean find = false;
		for(Housing item: this.list) {
			if(item.getproduct_id().equals(t.getproduct_id())) {
				
				this.list.remove(item);
				find = true;
				this.exportFile();
				break;
			}
		}
		return find;
	}

	@Override
	public List<Housing> searchHousing(String name) {
		// TODO Auto-generated method stub
		List<Housing> results = new ArrayList<Housing>();
		for(Housing item: this.list) {
			if(item.getproduct_name().contains(name)) {
				results.add(item);
			}
			
		}
		return results;
	}

	

	
	@Override
	public List<Housing> sortedHousing(boolean isASC) {
		// TODO Auto-generated method stub
//		List<Tile> results = new ArrayList<Tile>();
		this.list.sort(Comparator.comparing(Housing::getproduct_price));
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
            list = (List<Housing>) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
	
	private void createFile() {
		File f = new File(FILE_NAME);
    	if(!f.exists()) {
    		list = new ArrayList<Housing>();
    		exportFile();
    	}
	}

	
	
	
	
}



