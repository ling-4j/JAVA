package objects.NguyenHuuLinh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class TVManagerImpl implements TVManager {
	protected ArrayList<TV> list = new ArrayList<>();

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
			if (list.get(i).getproduct_id().equals(t.getproduct_id())) {
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
			if (tv.getproduct_name().toLowerCase().contains(keyword.toLowerCase())
					|| tv.getResolution().toLowerCase().contains(keyword.toLowerCase())
					|| String.valueOf(tv.getscreen_size()).contains(keyword)
					|| String.valueOf(tv.getproduct_price()).contains(keyword)) {
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
				return Integer.MAX_VALUE; // xử lý các giá trị khác
			}
		}));
		return list;
	}

	@Override
	public void generateList(int n) {
		String[] brands = { "Samsung", "LG", "Sony", "Panasonic", "Toshiba" };
		String[] res = { "UHD", "QHD", "FHD", "HD" };
		Random rand = new Random();

		for (int i = 1; i <= n; i++) {
			String product_id = "TV" + i;
			String product_name = brands[rand.nextInt(brands.length)] + " TV " + i;
			double product_price = (double) (Math.random() * 1000);
			int product_total = (int) (Math.random() * 10);
			double screen_size = 32 + (double) (Math.random() * 100);
			String resolution = res[rand.nextInt(res.length)];
			boolean isSmart = rand.nextBoolean();

			TV tv = new TV(product_id, product_name, product_price, product_total, screen_size, resolution.toString(),
					isSmart);
			addTV(tv);
		}
	}
}
