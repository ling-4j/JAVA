package objects.NguyenQuangDao;

import java.io.Serializable;
import java.util.Scanner;

import objects.Product;

public class Housing extends Product implements Serializable {
	private static final long serialVersionUID = 1L;
	static Scanner sc = new Scanner(System.in);
	
	public static final String HOUSING_LOCATION = "No Name";
	public static final double HOUSING_SIZE = 0;
	public static final int HOUSING_STATUS  = 0;
	
	 private String housing_location;
	    private double housing_size;
	    private String housing_status;
	
	public Housing() {
//		super();
//		System.out.println("Enter Tile's Brand: ");
//        tile_brand = sc.next();
//        System.out.println("Enter Tile's Type: " );
//        tile_type = sc.nextLine();
//        System.out.println("Enter Tile's Length: ");
//        tile_size_length = sc.nextInt();
//        System.out.println("Enter Tile's Width: ");
//        tile_size_width = sc.nextInt();
	}
	

	/**
	 * @param housing_name
	 * @param housing_price
	 * @param housing_total
	 */
	public Housing(String product_id, String product_name, double product_price, int product_total,String housing_location,double housing_size,String housing_status) {
		super(product_id, product_name, product_price, product_total);
		this.housing_location = housing_location;
		this.housing_size = housing_size;
		this.housing_status = housing_status;
	}

	

	
	
	

	public String getHousing_location() {
		return housing_location;
	}


	public void setHousing_location(String housing_location) {
		this.housing_location = housing_location;
	}


	public double getHousing_size() {
		return housing_size;
	}


	public void setHousing_size(double housing_size) {
		this.housing_size = housing_size;
	}


	public String getHousing_status() {
		return housing_status;
	}


	public void setHousing_status(String housing_status) {
		this.housing_status = housing_status;
	}


	@Override
	public String toString() {
		return "Housing ["+super.toString()+",housing_location=" + housing_location + ", housing_size=" + housing_size + ", housing_status="
				+ housing_status + "]";
	}


	
	



}
