package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import myio.MyFile;
import objects.NguyenHuuLinh.TV;
import objects.NguyenHuuLinh.TVManager;
import objects.NguyenHuuLinh.TVManagerImpl;
import objects.NguyenQuangDao.Housing;

public class TVManagerGUI extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private DefaultTableModel tableModel;
    private JTextField tfProductID, tfProductName, tfProductPrice, tfProductTotal, tfScreenSize, tfResolution, tfSearchKeyword;
    private JCheckBox cbIsSmart;
    private JTable table;
    private TVManager tvManager;
    private DecimalFormat decimalFormat;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                TVManagerGUI frame = new TVManagerGUI();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public TVManagerGUI() {
        setTitle("Quản Lý TV");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1003, 586);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout());

        JLabel lblNewLabel = new JLabel("QUẢN LÝ SẢN PHẨM TV");
        lblNewLabel.setBackground(new Color(192, 192, 192));
        lblNewLabel.setForeground(new Color(0, 0, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblNewLabel, BorderLayout.NORTH);
        
        tvManager = new TVManagerImpl();
        decimalFormat = new DecimalFormat("#.00");

        initializeTableModel();
        initializeTable();
        JPanel inputPanel = createInputPanel();
        JPanel searchPanel = createSearchPanel();
        JPanel buttonPanel = createButtonPanel();

        
        JPanel searchButtonPanel = new JPanel();
        searchButtonPanel.setLayout(new BoxLayout(searchButtonPanel, BoxLayout.Y_AXIS));
        searchButtonPanel.add(searchPanel);
        searchButtonPanel.add(buttonPanel);
        
        
        
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);
        panel.add(searchButtonPanel, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);

        loadData();
    }

    private void initializeTableModel() {
        String[] columnNames = { "Mã Sản Phẩm", "Tên Sản Phẩm", "Giá Sản Phẩm", "Số Lượng", "Kích Thước Màn Hình", "Độ Phân Giải", "Smart TV" };
        tableModel = new DefaultTableModel(columnNames, 0);
    }

    private void initializeTable() {
    	
        table = new JTable(tableModel);
        table.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    populateFieldsFromTable(selectedRow);
                }
            }
        });
    }

    private JPanel createInputPanel() {
    	JPanel inputPanel = new JPanel(new GridLayout(0, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JLabel[] labels = {
            new JLabel("Mã Sản Phẩm:"), new JLabel("Tên Sản Phẩm:"), new JLabel("Giá Sản Phẩm:"),
            new JLabel("Số Lượng:"), new JLabel("Kích Thước Màn Hình:"), new JLabel("Độ Phân Giải:"), new JLabel("Smart TV:")
        };
        tfProductID = new JTextField();
        tfProductName = new JTextField();
        tfProductPrice = new JTextField();
        tfProductTotal = new JTextField();
        tfScreenSize = new JTextField();
        tfResolution = new JTextField();
        cbIsSmart = new JCheckBox();
        JComponent[] components = {
            tfProductID, tfProductName, tfProductPrice, tfProductTotal, tfScreenSize, tfResolution, cbIsSmart
        };
        for (int i = 0; i < labels.length; i++) {
            inputPanel.add(labels[i]);
            inputPanel.add(components[i]);
        }
        return inputPanel;
    }

    private JPanel createSearchPanel() {
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        searchPanel.setBorder(BorderFactory.createTitledBorder("Tìm Kiếm"));
        JLabel lblSearchKeyword = new JLabel("Từ Khóa:");
        tfSearchKeyword = new JTextField(30);
        JButton btnSearch = new JButton("Tìm Kiếm");
        btnSearch.addActionListener(e -> searchTV());
        searchPanel.add(lblSearchKeyword);
        searchPanel.add(tfSearchKeyword);
        searchPanel.add(btnSearch);
        return searchPanel;
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton btnAdd = new JButton("Thêm TV");
        JButton btnEdit = new JButton("Chỉnh Sửa TV");
        JButton btnDelete = new JButton("Xóa TV");
        JButton btnSortByPrice = new JButton("Sắp Xếp theo Giá");
        JButton btnSortByResolution = new JButton("Sắp Xếp theo Độ Phân Giải");
        JButton btnStatis = new JButton("Thống kê");
//        btnStatis.setForeground(SystemColor.text);
//        btnStatis.setBackground(new Color(0, 100, 0));
//        btnStatis.setIcon(null);
//        btnStatis.setBounds(693, 446, 95, 33);
        
        
        btnStatis.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showStatisticsDialog();
            }
        });
        

        btnAdd.addActionListener(e -> addTV());
        btnEdit.addActionListener(e -> editTV());
        btnDelete.addActionListener(e -> deleteTV());
        btnSortByPrice.addActionListener(e -> sortByPrice());
        btnSortByResolution.addActionListener(e -> sortByResolution());

        buttonPanel.add(btnAdd);
        buttonPanel.add(btnEdit);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnSortByPrice);
        buttonPanel.add(btnSortByResolution);
        buttonPanel.add(btnStatis);

        return buttonPanel;
    }

    private void populateFieldsFromTable(int selectedRow) {
        tfProductID.setText((String) table.getValueAt(selectedRow, 0));
        tfProductName.setText((String) table.getValueAt(selectedRow, 1));
        tfProductPrice.setText((String) table.getValueAt(selectedRow, 2));
        tfProductTotal.setText(String.valueOf(table.getValueAt(selectedRow, 3)));
        tfScreenSize.setText((String) table.getValueAt(selectedRow, 4));
        tfResolution.setText((String) table.getValueAt(selectedRow, 5));
        cbIsSmart.setSelected((boolean) table.getValueAt(selectedRow, 6));
    }

    private void addTV() {
        String productID = tfProductID.getText().trim();
        String productName = tfProductName.getText().trim();
        double productPrice = Double.parseDouble(tfProductPrice.getText().trim());
        int productTotal = Integer.parseInt(tfProductTotal.getText().trim());
        double screenSize = Double.parseDouble(tfScreenSize.getText().trim());
        String resolution = tfResolution.getText().trim();
        boolean isSmart = cbIsSmart.isSelected();

        TV tv = new TV(productID, productName, productPrice, productTotal, screenSize, resolution, isSmart);

        if (tvManager.addTV(tv)) {
            Object[] rowData = { tv.getproduct_id(), tv.getproduct_name(), decimalFormat.format(tv.getproduct_price()),
                                 tv.getproduct_total(), decimalFormat.format(tv.getscreen_size()), tv.getResolution(),
                                 tv.isSmart() };
            tableModel.addRow(rowData);
            clearFields();
            JOptionPane.showMessageDialog(this, "TV được thêm thành công!", "Thành Công", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Mã Sản Phẩm đã tồn tại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadData() {
        tvManager.generateList(10);
        try {
            MyFile.binaryOutputFile("TV.bin", tvManager.searchTV(""));
            System.out.println("Ghi thành công vào TV.bin");
        } catch (IOException e) {
            System.err.println("Lỗi: " + e.getMessage());
        }

        try {
            List<TV> loadedList = (List<TV>) MyFile.binaryInputFile("TV.bin");
            updateTable(loadedList);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Lỗi: " + e.getMessage());
        }
    }
    
    private void showStatisticsDialog() {
        JDialog dialog = new JDialog();
        dialog.setTitle("Thống kê sản phẩm theo giá");
        dialog.setSize(600, 400);
        dialog.setLocationRelativeTo(this);
        dialog.getContentPane().setLayout(new BorderLayout());
        String keyword = tfSearchKeyword.getText().trim();
        List<TV> searchResult = tvManager.searchTV(keyword);
        
        DefaultCategoryDataset data = new DefaultCategoryDataset();
        double minPrice = searchResult.stream().mapToDouble(TV::getproduct_price).min().orElse(0);
        double maxPrice = searchResult.stream().mapToDouble(TV::getproduct_price).max().orElse(0);
        double avgPrice = searchResult.stream().mapToDouble(TV::getproduct_price).average().orElse(0);


        data.addValue(minPrice, "Giá", "Thấp nhất");
        data.addValue(maxPrice, "Giá", "Cao nhất");
        data.addValue(avgPrice, "Giá", "Trung bình");


        JFreeChart barChart = ChartFactory.createBarChart(
                "Thống kê giá sản phẩm",
                "Loại",
                "Giá",
                data
        );
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(560, 367));
        dialog.getContentPane().add(chartPanel, BorderLayout.CENTER);
        dialog.setVisible(true);
	}

    private void editTV() {
        int rowIndex = table.getSelectedRow();
        if (rowIndex != -1) {
            String productID = tfProductID.getText().trim();
            String productName = tfProductName.getText().trim();
            double productPrice = Double.parseDouble(tfProductPrice.getText().trim());
            int productTotal = Integer.parseInt(tfProductTotal.getText().trim());
            double screenSize = Double.parseDouble(tfScreenSize.getText().trim());
            String resolution = tfResolution.getText().trim();
            boolean isSmart = cbIsSmart.isSelected();

            TV tv = new TV(productID, productName, productPrice, productTotal, screenSize, resolution, isSmart);

            if (tvManager.editTV(tv)) {
                tableModel.setValueAt(productID, rowIndex, 0);
                tableModel.setValueAt(productName, rowIndex, 1);
                tableModel.setValueAt(decimalFormat.format(productPrice), rowIndex, 2);
                tableModel.setValueAt(productTotal, rowIndex, 3);
                tableModel.setValueAt(decimalFormat.format(screenSize), rowIndex, 4);
                tableModel.setValueAt(resolution, rowIndex, 5);
                tableModel.setValueAt(isSmart, rowIndex, 6);
                clearFields();
                JOptionPane.showMessageDialog(this, "TV được chỉnh sửa thành công!", "Thành Công", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Mã Sản Phẩm không tồn tại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void deleteTV() {
        int rowIndex = table.getSelectedRow();
        if (rowIndex != -1) {
            String productID = (String) table.getValueAt(rowIndex, 0);
            String productName = (String) table.getValueAt(rowIndex, 1);
            double productPrice = Double.parseDouble((String) table.getValueAt(rowIndex, 2));
            int productTotal = Integer.parseInt(table.getValueAt(rowIndex, 3).toString());
            double screenSize = Double.parseDouble((String) table.getValueAt(rowIndex, 4));
            String resolution = (String) table.getValueAt(rowIndex, 5);
            boolean isSmart = (boolean) table.getValueAt(rowIndex, 6);

            TV tv = new TV(productID, productName, productPrice, productTotal, screenSize, resolution, isSmart);

            if (tvManager.delTV(tv)) {
                tableModel.removeRow(rowIndex);
                clearFields();
                JOptionPane.showMessageDialog(this, "Đã xóa thành công TV!", "Thành Công",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Lỗi xóa TV!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Chọn một TV để xóa!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void searchTV() {
        String keyword = tfSearchKeyword.getText().trim();
        List<TV> searchResult = tvManager.searchTV(keyword);
        updateTable(searchResult);
    }

    private void sortByPrice() {
        List<TV> sortedList = tvManager.sortByPrice(true); // mặc định là true cho thứ tự tăng dần
        updateTable(sortedList);
    }

    private void sortByResolution() {
        List<TV> sortedList = tvManager.sortByResolution();
        updateTable(sortedList);
    }

    private void clearFields() {
        tfProductID.setText("");
        tfProductName.setText("");
        tfProductPrice.setText("");
        tfProductTotal.setText("");
        tfScreenSize.setText("");
        tfResolution.setText("");
        cbIsSmart.setSelected(false);
    }

    private void updateTable(List<TV> tvList) {
        tableModel.setRowCount(0);
        for (TV tv : tvList) {
            Object[] rowData = { tv.getproduct_id(), tv.getproduct_name(), decimalFormat.format(tv.getproduct_price()),
                                 tv.getproduct_total(), decimalFormat.format(tv.getscreen_size()), tv.getResolution(),
                                 tv.isSmart() };
            tableModel.addRow(rowData);
        }
    }
}
