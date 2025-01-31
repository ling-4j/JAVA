package objects.HoNgocQuyen;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

import objects.Product;

public class Painting extends Product implements Serializable{
	@Serial
	private static final long serialVersionUID = 1L;
	private static final Scanner sc = new Scanner(System.in);
    private String color;
    private String manufacturer;
    private String importDate;

    // Constructor
    public Painting() {
    }

    public Painting(String product_id, String product_name, double product_price, int product_total, String color, String manufacturer, String importDate) {
        super(product_id, product_name, product_price, product_total);
        this.color = color;
        this.manufacturer = manufacturer;
        this.importDate = importDate;
    }

    // Getter and Setter methods for Painting class attributes
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getImportDate() {
        return importDate;
    }

    public void setImportDate(String importDate) {
        this.importDate = importDate;
    }
    
  

    
}
