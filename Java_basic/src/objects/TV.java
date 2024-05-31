package objects;

public class TV extends Product {
	
    public static final double SCREEN_SIZE = 0;
    public static final String RESOLUTION = "NONE";
    public static boolean ISMART = false;
	
    private double screen_size;
    private String resolution;
    private boolean isSmart;

    //constructor không tham số
    public TV() {
    	this(TV.ID, TV.NAME, TV.PRICE, TV.TOTAL, TV.SCREEN_SIZE, TV.RESOLUTION, TV.ISMART);
    	
    }

    //constructor đủ tham số
    public TV(String product_id, String product_name, double product_price, int product_total, double screen_size, String resolution, boolean isSmart) {
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
        return String.format("TV [screen_size=%.2f, resolution=%s, isSmart=%b, %s]", 
                              screen_size, resolution, isSmart, super.toString());
    }
    
    public static void main(String[] args) {
        //tv1 
        TV tv1 = new TV();
        System.out.println("TV1: " + tv1);

        System.out.println("============================================================");
        //tv2
        TV tv2 = new TV("TV001", "Samsung Smart TV", 500.0, 10, 55, "4K", true);
        System.out.println("TV2: " + tv2);

        System.out.println("============================================================");
        
        tv2.setproduct_id("TV002");
        tv2.setproduct_name("LG OLED TV");
        tv2.setproduct_price(8_600_000);
        tv2.setproduct_total(5);
        tv2.setscreen_size(65);
        tv2.setResolution("4K");
        tv2.setSmart(true);

        System.out.println("Update TV2: " + tv2);
        System.out.println("Product ID: " + tv2.getproduct_id());
        System.out.println("Product Name: " + tv2.getproduct_name());
        System.out.println("Product Price: " + tv2.getproduct_price());
        System.out.println("Product Total: " + tv2.getproduct_total());
        System.out.println("Screen Size: " + tv2.getscreen_size());
        System.out.println("Resolution: " + tv2.getResolution());
        System.out.println("Is Smart: " + tv2.isSmart());
        System.out.println("============================================================");
    }

}
