package objects;

import java.util.List;

public interface TVManager {
    public boolean addTV(TV t);
    public boolean editTV(TV t);
    public boolean delTV(TV t);
    
    public void generateList(int n); // Sinh data
    
    //tìm kiếm
    public List<TV> searchTV(String keyword); // Tìm kiếm theo tên hoặc theo kích thước
    public List<TV> searchByPrice(double price); // Tìm kiếm theo giá
    
    //sắp xếp
    public List<TV> sortByPrice(boolean isINC); // Sắp xếp theo giá
    public List<TV> sortByResolution(); // Sắp xếp theo độ phân giải
}
