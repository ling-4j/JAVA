package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import objects.HoNgocQuyen.*;


public class PaintUI extends JPanel {
    protected static List<Painting> list = new ArrayList<>();
    private static final long serialVersionUID = 1L;
    private JTable table;
    private JTextField txtSearch;
    private DefaultTableModel model;

    /**
     * Create the panel.
     */
    public PaintUI() {
    	setLayout(null);

        JPanel rootPanel = new JPanel();
        rootPanel.setBackground(new Color(255, 255, 255));
        rootPanel.setBounds(10, 10, 931, 545);
        add(rootPanel);
        rootPanel.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(60, 135, 811, 316);
        rootPanel.add(scrollPane);
        loadFromFile();
        Object[][] data = new Object[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            Painting tv = list.get(i);
            // Chuyển đổi từng đối tượng TV thành một mảng Object
            Object[] rowData = {
                    tv.getproduct_id(),
                    tv.getproduct_name(),
                    tv.getproduct_price(),
                    tv.getproduct_total(),
                    tv.getColor(),
                    tv.getManufacturer(),
                    tv.getImportDate() != null ? tv.getImportDate().toString(): ""
            };
            data[i] = rowData;
        }
//        list.add(new Painting("001", "Sơn A", 250000, 100, "Đỏ", "Nhà sản xuất A", "20/3/2024"));
//        list.add(new Painting("002", "Sơn B", 300000, 200, "Xanh", "Nhà sản xuất B", "20/3/2024"));
//        list.add(new Painting("003", "Sơn C", 350000, 150, "Vàng", "Nhà sản xuất C", "20/3/2024"));
//        list.add(new Painting("004", "Sơn D", 400000, 180, "Trắng", "Nhà sản xuất D", "20/3/2024"));
//        list.add(new Painting("005", "Sơn E", 450000, 120, "Đen", "Nhà sản xuất E", "20/3/2024"));
//        list.add(new Painting("006", "Sơn F", 500000, 110, "Hồng", "Nhà sản xuất F", "20/3/2024"));
//        list.add(new Painting("007", "Sơn G", 550000, 90, "Nâu", "Nhà sản xuất G", "20/3/2024"));
//        list.add(new Painting("008", "Sơn H", 600000, 130, "Cam", "Nhà sản xuất H", "20/3/2024"));
//        list.add(new Painting("009", "Sơn I", 650000, 170, "Tím", "Nhà sản xuất I", "20/3/2024"));
//        list.add(new Painting("010", "Sơn J", 700000, 160, "Xám", "Nhà sản xuất J", "20/3/2024"));
//        list.add(new Painting("011", "Sơn K", 750000, 140, "Be", "Nhà sản xuất K", "20/3/2024"));
//        list.add(new Painting("012", "Sơn L", 800000, 100, "Xanh lá", "Nhà sản xuất L", "20/3/2024"));
//        list.add(new Painting("013", "Sơn M", 850000, 90, "Xanh dương", "Nhà sản xuất M", "20/3/2024"));
//        list.add(new Painting("014", "Sơn N", 900000, 180, "Trắng sữa", "Nhà sản xuất N", "20/3/2024"));
//        list.add(new Painting("015", "Sơn O", 950000, 200, "Đỏ đô", "Nhà sản xuất O", "20/3/2024"));

        table = new JTable();
        model = new DefaultTableModel(
                data,
                new String[]{
                        "Product ID", "Product Name", "Product Price", "Product Total", "Color", "Manufacturer", "Import Date"
                }
        );
        table.setModel(model);
        scrollPane.setViewportView(table);

        JButton btnAdd = new JButton("Thêm mới");
        btnAdd.setForeground(SystemColor.text);
        btnAdd.setBackground(SystemColor.textHighlight);
        btnAdd.setIcon(null);
        btnAdd.setBounds(89, 473, 126, 40);
        rootPanel.add(btnAdd);

        JButton btnEdit = new JButton("Sửa ");
        btnEdit.setForeground(SystemColor.text);
        btnEdit.setBackground(Color.ORANGE);
        btnEdit.setIcon(null);
        btnEdit.setBounds(304, 473, 126, 40);
        rootPanel.add(btnEdit);

        JButton btnDel = new JButton("Xóa");
        btnDel.setForeground(SystemColor.text);
        btnDel.setBackground(Color.RED);
        btnDel.setIcon(null);
        btnDel.setBounds(519, 473, 126, 40);
        rootPanel.add(btnDel);
        
        JLabel lblPaintTiltle = new JLabel("QUẢN LÝ SẢN PHẨM SƠN TƯỜNG");
        lblPaintTiltle.setForeground(new Color(0, 0, 255));
        lblPaintTiltle.setBackground(Color.LIGHT_GRAY);
//        lblPaintTiltle.setIcon(new ImageIcon("images/Justicon-Free-Simple-Line-Management-Page-Website-Browser-Target.32.png"));
        lblPaintTiltle.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblPaintTiltle.setBounds(261, 10, 409, 33);
        rootPanel.add(lblPaintTiltle);

        JLabel lblSearch = new JLabel("Tìm kiếm");
        lblSearch.setIcon(new ImageIcon("images/Ampeross-Qetto-2-Search.24.png"));
        lblSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblSearch.setBounds(43, 64, 110, 25);
        rootPanel.add(lblSearch);

        txtSearch = new JTextField();
        txtSearch.setBackground(SystemColor.menu);
        txtSearch.setBounds(157, 66, 235, 25);
        rootPanel.add(txtSearch);
        txtSearch.setColumns(10);

        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
        comboBox.setModel(new DefaultComboBoxModel<>(new String[]{"Sắp xếp tăng dần", "Sắp xếp giảm dần"}));
        comboBox.setBounds(669, 66, 213, 25);
        rootPanel.add(comboBox);

        JLabel lblSort = new JLabel("Sắp xếp");
        lblSort.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblSort.setBounds(596, 64, 86, 25);
        rootPanel.add(lblSort);

        JButton btnStatis = new JButton("Thống kê");
        btnStatis.setForeground(SystemColor.text);
        btnStatis.setBackground(new Color(0, 100, 0));
        btnStatis.setIcon(null);
        btnStatis.setBounds(734, 473, 126, 40);
        rootPanel.add(btnStatis);

        JLabel lblList = new JLabel("Danh sách sản phẩm sơn tường");
        lblList.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
        lblList.setBounds(32, 98, 510, 27);
        rootPanel.add(lblList);

       

        // Add button action
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add new item
            	new AddEditDialog("Thêm mới", null, -1).setVisible(true);
            	updateTable(list);
            	saveToFile();
            }
        });

        // Edit button action
        btnEdit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	int row = table.getSelectedRow();
            	Object[] product = new Object[table.getColumnCount()];
                for (int i = 0; i < table.getColumnCount(); i++) {
                    product[i] = table.getValueAt(row, i);
                }
                new AddEditDialog( "Sửa sản phẩm", product, row).setVisible(true);
                updateTable(list);
              
                }
            
        });

        // Delete button action
        btnDel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Delete selected item
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    list.remove(selectedRow);
                    model.removeRow(selectedRow);
                    updateTable(list);
                    saveToFile();
                }
                
            }
        });

        // Search action
        txtSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String searchText = txtSearch.getText();
                List<Painting> filteredList = list.stream()
                        .filter(p -> p.getproduct_name().contains(searchText))
                        .collect(Collectors.toList());
                updateTable(filteredList);
            
            }
        });

        // Sort action
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String sortType = (String) comboBox.getSelectedItem();
                if ("Sắp xếp tăng dần".equals(sortType)) {
                    list.sort((p1, p2) -> Double.compare(p1.getproduct_price(), p2.getproduct_price()));
                } else if ("Sắp xếp giảm dần".equals(sortType)) {
                    list.sort((p1, p2) -> Double.compare(p2.getproduct_price(), p1.getproduct_price()));
                }
                updateTable(list);
            }
        });
        btnStatis.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showStatisticsDialog();
            }
        });
    
    }

    private void loadData() {
        ProductIO.loadFromFile(list);
        for (Painting p : list) {
            model.addRow(new Object[]{
                    p.getproduct_id(),
                    p.getproduct_name(),
                    p.getproduct_price(),
                    p.getproduct_total(),
                    p.getColor(),
                    p.getManufacturer(),
                    p.getImportDate()
            });
        }
    }

    private void updateTable(List<Painting> dataList) {
        model.setRowCount(0);
        for (Painting p : dataList) {
            model.addRow(new Object[]{
                    p.getproduct_id(),
                    p.getproduct_name(),
                    p.getproduct_price(),
                    p.getproduct_total(),
                    p.getColor(),
                    p.getManufacturer(),
                    p.getImportDate()
            });
        }
        saveToFile();
    }
    
    public static void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Paint.bin"))) {
            oos.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to load tvList from a file
    public static void loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Paint.bin"))) {
            list = (List<Painting>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("File 'Painting.bin' not found. Creating a new file...");
            saveToFile(); // Tạo một tệp mới
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private void showStatisticsDialog() {
        JDialog dialog = new JDialog();
        dialog.setTitle("Thống kê sản phẩm theo giá");
        dialog.setSize(600, 400);
        dialog.setLocationRelativeTo(this);
        dialog.getContentPane().setLayout(new BorderLayout());

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        double minPrice = list.stream().mapToDouble(Painting::getproduct_price).min().orElse(0);
        double maxPrice = list.stream().mapToDouble(Painting::getproduct_price).max().orElse(0);
        double avgPrice = list.stream().mapToDouble(Painting::getproduct_price).average().orElse(0);


        dataset.addValue(minPrice, "Giá", "Thấp nhất");
        dataset.addValue(maxPrice, "Giá", "Cao nhất");
        dataset.addValue(avgPrice, "Giá", "Trung bình");


        JFreeChart barChart = ChartFactory.createBarChart(
                "Thống kê giá sản phẩm",
                "Loại",
                "Giá",
                dataset
        );

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(560, 367));
        dialog.getContentPane().add(chartPanel, BorderLayout.CENTER);
        dialog.setVisible(true);
    }
}
