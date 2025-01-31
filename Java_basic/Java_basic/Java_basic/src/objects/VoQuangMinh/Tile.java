package objects.VoQuangMinh;

import java.io.Serializable;
import java.util.Scanner;

import objects.Product;

public class Tile extends Product implements Serializable {
	private static final long serialVersionUID = 1L;
	static Scanner sc = new Scanner(System.in);
	
	public static final String TILE_BRAND = "No Brand";
	public static final String TILE_TYPE = "No Type";
	public static final int TILE_SIZE_LENGTH = 0;
	public static final int TILE_SIZE_WIDTH  = 0;
	
	private String tile_brand;
	private String tile_type;
	private int tile_size_length;
	private int tile_size_width;
	
	public Tile() {
	}

	public Tile(String product_id, String product_name, double product_price, int product_total,String tile_brand, String tile_type, int tile_size_length, int tile_size_width) {
		super(product_id, product_name, product_price, product_total);
		this.tile_brand = tile_brand;
		this.tile_type = tile_type;
		this.tile_size_length = tile_size_length;
		this.tile_size_width = tile_size_width;
	}

	public String getTile_brand() {
		return tile_brand;
	}

	public void setTile_brand(String tile_brand) {
		this.tile_brand = tile_brand;
	}

	public String getTile_type() {
		return tile_type;
	}

	public void setTile_type(String tile_type) {
		this.tile_type = tile_type;
	}

	public int getTile_size_length() {
		return tile_size_length;
	}

	public void setTile_size_length(int tile_size_length) {
		this.tile_size_length = tile_size_length;
	}

	public int getTile_size_width() {
		return tile_size_width;
	}

	public void setTile_size_width(int tile_size_width) {
		this.tile_size_width = tile_size_width;
	}

	@Override
	public String toString() {
		return "Tile ["+super.toString()+", tile_brand=" + tile_brand + ", tile_type=" + tile_type + ", tile_size_length=" + tile_size_length
				+ ", tile_size_width=" + tile_size_width + "]";
	}
}
