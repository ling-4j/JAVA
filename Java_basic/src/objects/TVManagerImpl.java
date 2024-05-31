package objects;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class TVManagerImpl implements TVManager {
	protected ArrayList<TV> list = new ArrayList<>();

	// Kiểm tra TV đã tồn tại
	private boolean isExisting(TV t) {
		boolean flag = false;
		for (TV tv : list) {
			if (tv.getproduct_id().equals(t.getproduct_id())) {
				flag = true;
			}
		}
		return flag;
	}

	@Override
	public boolean addTV(TV t) {
		if (isExisting(t)) {
			return false;
		}
		return list.add(t);
	}

	@Override
	public boolean editTV(TV t) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getproduct_id().equals(t.getproduct_id())) {
				list.set(i, t);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean delTV(TV t) {
	    for (int i = 0; i < list.size(); i++) {
	        if (list.get(i).equals(t)) {
	            list.remove(i);
	            return true;
	        }
	    }
	    return false;
	}


	@Override
	public List<TV> searchTV(String keyword) {
	    List<TV> result = new ArrayList<>();
	    for (TV tv : list) {
	        if (tv.getproduct_name().toLowerCase().contains(keyword.toLowerCase()) || tv.getResolution().toLowerCase().contains(keyword.toLowerCase())) {
	            result.add(tv);
	        }
	    }
	    return result;
	}


	@Override
	public List<TV> searchByPrice(double price) {
	    List<TV> result = new ArrayList<>();
	    for (TV tv : list) {
	        if (tv.getproduct_price() == price) {
	            result.add(tv);
	        }
	    }
	    return result;
	}

	@Override
	public List<TV> sortByPrice(boolean isINC) {
	    int n = list.size();
	    for (int i = 0; i < n - 1; i++) {
	        for (int j = 0; j < n - i - 1; j++) {
	            TV tv1 = list.get(j);
	            TV tv2 = list.get(j + 1);
	            if (isINC) {
	                if (tv1.getproduct_price() > tv2.getproduct_price()) {
	                    // đổi chỗ
	                    list.set(j, tv2);
	                    list.set(j + 1, tv1);
	                }
	            } else {
	                if (tv1.getproduct_price() < tv2.getproduct_price()) {
	                    list.set(j, tv2);
	                    list.set(j + 1, tv1);
	                }
	            }
	        }
	    }
	    return list;
	}

	@Override
	public List<TV> sortByResolution() {
	    Collections.sort(list, Comparator.comparing(tv -> {
	        String resolution = tv.getResolution();
	        switch (resolution) {
	            case "UHD":
	                return 0;
	            case "QHD":
	                return 1;
	            case "FHD":
	                return 2;
	            case "HD":
	                return 3;
	            default:
	                return Integer.MAX_VALUE; //xử lý các giá trị khác
	        }
	    }));
	    return list;
	}


    @Override
    public void generateList(int n) {
        String[] brands = {"Samsung", "LG", "Sony", "Panasonic", "Toshiba"};
        String[] res = {"UHD", "QHD", "FHD", "HD"};
        Random rand = new Random();

        for (int i = 1; i <= n; i++) {
            String product_id = "TV" + i;
            String product_name = brands[rand.nextInt(brands.length)] + " TV " + i;
            double product_price = (double) (Math.random() * 1000);
            int product_total = (int) (Math.random() * 10);
            double screen_size = 32 + (double) (Math.random() * 100);
            String resolution = res[rand.nextInt(res.length)];
            boolean isSmart = rand.nextBoolean();

            TV tv = new TV(product_id, product_name, product_price, product_total, screen_size, resolution.toString(), isSmart);
            addTV(tv);
        }
    }

    public static void main(String[] args) {
        TVManager tvManager = new TVManagerImpl();

        // Test generateList
        tvManager.generateList(10);
        tvManager.sortByPrice(false).forEach(System.out::println);

        System.out.println("==================1==========================================");

        // Test add, edit, delete, search, sort functionality as before

        TV tv1 = new TV("TV11", "Samsung Smart TV", 300, 10, 55, "10K", true);
        TV tv8 = new TV("TV8", "Sony Basic TV", 100, 7, 50, "FHD", false);

        // Test add
        System.out.println("Test add TV1: " + tvManager.addTV(tv1)); // ok
        System.out.println("Test add TV8: " + tvManager.addTV(tv8)); // ok
        System.out.println("Test add TV1 again: " + tvManager.addTV(tv1)); // err(trùng)
        System.out.println("===================2=========================================");
        tvManager.sortByPrice(false).forEach(System.out::println);

        System.out.println("============================================================");

        // Tìm kiếm theo tên, theo giá, và theo thuộc tính được đề xuất riêng ở ý 1.2.
        System.out.println("Search by resolution 'UHD': ");
        tvManager.searchTV("UHD").forEach(System.out::println);
        System.out.println("Search by price 100: " + tvManager.searchByPrice(653.66) + "\n");
        System.out.println("sắp xếp giảm theo giá:");
        tvManager.sortByPrice(false).forEach(System.out::println);
        System.out.println("===================3=========================================");
        System.out.println("Sorted by resolution 'UHD': ");
        tvManager.sortByResolution().forEach(System.out::println);
        System.out.println("===================3=========================================");

        // Test sửa
        TV editTV = new TV("TV3", "Sony TV NEW", 650.0, 6, 52, "HD", true);
        System.out.println("Sửa TV3: " + tvManager.editTV(editTV));
        System.out.println("Đã sửa TV3?:");
        tvManager.sortByPrice(false).forEach(System.out::println);

        // Test xóa
        System.out.println("Xóa TV1: " + tvManager.delTV(tv1));
        System.out.println("Đã xóa TV8?:");
        tvManager.sortByPrice(false).forEach(System.out::println);

        System.out.println("====================4========================================");
    }

}



