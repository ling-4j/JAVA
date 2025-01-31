package objects.NguyenHuuLinh;

import java.io.Serializable;

import objects.Product;

public class TV extends Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final double SCREEN_SIZE = 0;
	public static final String RESOLUTION = "NONE";
	public static boolean ISMART = false;

	private double screen_size;
	private String resolution;
	private boolean isSmart;

	// constructor không tham số
	public TV() {
		this(TV.ID, TV.NAME, TV.PRICE, TV.TOTAL, TV.SCREEN_SIZE, TV.RESOLUTION, TV.ISMART);
	}

	// constructor đủ tham số
	public TV(String product_id, String product_name, double product_price, int product_total, double screen_size,
			String resolution, boolean isSmart) {
		super(product_id, product_name, product_price, product_total);
		this.screen_size = screen_size;
		this.resolution = resolution;
		this.isSmart = isSmart;
	}

	public double getscreen_size() {
		return screen_size;
	}

	public void setscreen_size(double screen_size) {
		this.screen_size = screen_size;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public boolean isSmart() {
		return isSmart;
	}

	public void setSmart(boolean isSmart) {
		this.isSmart = isSmart;
	}

	@Override
	public String toString() {
		return String.format("TV [screen_size=%.2f, resolution=%s, isSmart=%b, %s]", screen_size, resolution, isSmart,
				super.toString());
	}
}
