package objects;

public class Product {
	
    public static final String ID = "NO ID";
    public static final String NAME = "NO NAME";
    public static final double PRICE = 0;
    public static final Integer TOTAL = 0;
	
    private String product_id;
    private String product_name;
    private double product_price;
    private int product_total;

    //constructor không tham số
    public Product() {
    	this(Product.ID, Product.NAME, Product.PRICE, Product.TOTAL);
    }

    //constructor đủ tham số
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
    
    public static void main(String[] args) {
        //p1
        Product product1 = new Product();
        System.out.println("Product1: " + product1);

        System.out.println("============================================================");
        //p2
        Product product2 = new Product("P001", "Laptop", 1200.0, 10);
        System.out.println("Product2: " + product2);

        System.out.println("============================================================");
        product2.setproduct_id("P002");
        product2.setproduct_name("Smartphone");
        product2.setproduct_price(800.0);
        product2.setproduct_total(15);

        System.out.println("Update Product2: " + product2);
        System.out.println("Product ID: " + product2.getproduct_id());
        System.out.println("Product Name: " + product2.getproduct_name());
        System.out.println("Product Price: " + product2.getproduct_price());
        System.out.println("Product Total: " + product2.getproduct_total());
        
        System.out.println("============================================================");
    }
}
