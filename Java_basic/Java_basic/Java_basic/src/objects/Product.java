package objects;

import java.io.Serializable;

public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String ID = "NO ID";
	public static final String NAME = "NO NAME";
	public static final double PRICE = 0;
	public static final Integer TOTAL = 0;

	private String product_id;
	private String product_name;
	private double product_price;
	private int product_total;

	// constructor không tham số
	public Product() {
		this(Product.ID, Product.NAME, Product.PRICE, Product.TOTAL);
	}

	// constructor đủ tham số
	public Product(String product_id, String product_name, double product_price, int product_total) {
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_total = product_total;
	}

	public String getproduct_id() {
		return product_id;
	}

	public void setproduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getproduct_name() {
		return product_name;
	}

	public void setproduct_name(String product_name) {
		this.product_name = product_name;
	}

	public double getproduct_price() {
		return product_price;
	}

	public void setproduct_price(double product_price) {
		this.product_price = product_price;
	}

	public int getproduct_total() {
		return product_total;
	}

	public void setproduct_total(int product_total) {
		this.product_total = product_total;
	}

	@Override
	public String toString() {
		return String.format("Product [product_id=%s, product_name=%s, product_price=%.2f, product_total=%d]",
				product_id, product_name, product_price, product_total);
	}
}
