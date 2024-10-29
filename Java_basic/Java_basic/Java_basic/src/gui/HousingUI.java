package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import objects.NguyenQuangDao.*;
import objects.VoQuangMinh.Tile;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HousingUI extends JFrame {
	HousingManagerImpl housing;
	Housing h = new Housing();
	private int pos = 0;

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtPrice;
	private JTextField txtTotal;
	private JTextField txtSearch;
	private JTable tblHousing;
	private JTextField txtLoca;
	private JTextField txtSize;
	private JTextField txtStatus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HousingUI frame = new HousingUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HousingUI() {
		housing = new HousingManagerImpl();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 983, 547);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Mã sản phẩm:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(50, 161, 95, 14);
		contentPane.add(lblNewLabel_1);

		txtId = new JTextField();
		txtId.setText((String) null);
		txtId.setColumns(10);
		txtId.setBounds(169, 160, 106, 20);
		contentPane.add(txtId);

		JLabel lblNewLabel_1_1 = new JLabel("Tên sản phẩm:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(50, 195, 95, 14);
		contentPane.add(lblNewLabel_1_1);

		txtName = new JTextField();
		txtName.setText((String) null);
		txtName.setColumns(10);
		txtName.setBounds(169, 194, 106, 20);
		contentPane.add(txtName);

		JLabel lblNewLabel_1_2 = new JLabel("Đơn giá:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(50, 228, 95, 14);
		contentPane.add(lblNewLabel_1_2);

		txtPrice = new JTextField();
		txtPrice.setText("0.0");
		txtPrice.setColumns(10);
		txtPrice.setBounds(169, 227, 106, 20);
		contentPane.add(txtPrice);

		JLabel lblNewLabel_1_3 = new JLabel("Số lượng:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(50, 263, 95, 14);
		contentPane.add(lblNewLabel_1_3);

		txtTotal = new JTextField();
		txtTotal.setText("0");
		txtTotal.setColumns(10);
		txtTotal.setBounds(169, 262, 106, 20);
		contentPane.add(txtTotal);

		JPanel panel = new JPanel();
		panel.setForeground(Color.LIGHT_GRAY);
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 967, 82);
		contentPane.add(panel);

		JLabel lblQunLHousing = new JLabel("QUẢN LÝ BẤT ĐỘNG SẢN");
		lblQunLHousing.setHorizontalAlignment(SwingConstants.CENTER);
		lblQunLHousing.setForeground(new Color(0, 0, 255));
		lblQunLHousing.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblQunLHousing.setBackground(Color.LIGHT_GRAY);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.TRAILING).addGap(0, 967, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap(274, Short.MAX_VALUE)
						.addComponent(lblQunLHousing, GroupLayout.PREFERRED_SIZE, 443, GroupLayout.PREFERRED_SIZE)
						.addGap(250)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGap(0, 82, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup().addGap(25).addComponent(lblQunLHousing).addContainerGap(28,
						Short.MAX_VALUE)));
		panel.setLayout(gl_panel);

		txtSearch = new JTextField();
		txtSearch.setColumns(10);
		txtSearch.setBounds(321, 93, 163, 26);
		contentPane.add(txtSearch);

		JButton btnSearch = new JButton("Tìm kiếm");
		btnSearch.addActionListener(e -> ViewSearch());
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSearch.setBackground(new Color(0, 128, 192));
		btnSearch.setBounds(496, 93, 89, 26);
		contentPane.add(btnSearch);

		JButton btnSortPrice = new JButton("Sort by Price");
		btnSortPrice.addActionListener(e -> ViewSortbyPrice());
		btnSortPrice.setBounds(794, 93, 125, 26);
		contentPane.add(btnSortPrice);

		JButton btnAdd = new JButton("Thêm mới");
		btnAdd.addActionListener(e->HandleAdd());
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAdd.setBackground(new Color(0, 128, 0));
		btnAdd.setBounds(255, 446, 95, 33);
		contentPane.add(btnAdd);

		JButton btnUpdate = new JButton("Sửa");
		btnUpdate.addActionListener(e -> HandleUpdate());
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUpdate.setBackground(new Color(232, 116, 0));
		btnUpdate.setBounds(369, 446, 95, 33);
		contentPane.add(btnUpdate);

		JButton btnDel = new JButton("Xóa");
		btnDel.addActionListener(e -> HandleDel());
		btnDel.setForeground(Color.WHITE);
		btnDel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDel.setBackground(new Color(232, 0, 0));
		btnDel.setBounds(479, 446, 95, 33);
		contentPane.add(btnDel);

		JButton btnCancel = new JButton("Hủy bỏ");
		btnCancel.addActionListener(e -> HandleCancel());
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancel.setBackground(Color.GRAY);
		btnCancel.setBounds(587, 446, 95, 33);
		contentPane.add(btnCancel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(321, 144, 604, 270);
		contentPane.add(scrollPane);

		JButton btnStatis = new JButton("Thống kê");
        btnStatis.setForeground(SystemColor.text);
        btnStatis.setBackground(new Color(0, 100, 0));
        btnStatis.setIcon(null);
        btnStatis.setBounds(693, 446, 95, 33);
        contentPane.add(btnStatis);
        
        btnStatis.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showStatisticsDialog();
            }
        });
		
		tblHousing = new JTable();
		tblHousing.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				pos = tblHousing.getSelectedRow();
				View();
			}
		});
		tblHousing.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				pos = tblHousing.getSelectedRow();
				View();
			}
		});
		tblHousing.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "Price", "Total", "Location", "Size", "Status"
			}
		));
		tblHousing.getTableHeader();
		scrollPane.setViewportView(tblHousing);
		tblHousing.setToolTipText("");
		tblHousing.setRowHeight(28);
		tblHousing.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tblHousing.setFillsViewportHeight(true);
		tblHousing.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tblHousing.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

		JLabel lblNewLabel_1_4 = new JLabel("Vị trí");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_4.setBounds(50, 294, 95, 14);
		contentPane.add(lblNewLabel_1_4);

		txtLoca = new JTextField();
		txtLoca.setText((String) null);
		txtLoca.setColumns(10);
		txtLoca.setBounds(169, 293, 106, 20);
		contentPane.add(txtLoca);

		JLabel lblNewLabel_1_1_1 = new JLabel("Diện tích");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(50, 328, 95, 14);
		contentPane.add(lblNewLabel_1_1_1);

		txtSize = new JTextField();
		txtSize.setText("0.0");
		txtSize.setColumns(10);
		txtSize.setBounds(169, 327, 106, 20);
		contentPane.add(txtSize);

		JLabel lblNewLabel_1_2_1 = new JLabel("Tình trạng");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1.setBounds(50, 361, 95, 14);
		contentPane.add(lblNewLabel_1_2_1);

		txtStatus = new JTextField();
		txtStatus.setColumns(10);
		txtStatus.setBounds(169, 360, 106, 20);
		contentPane.add(txtStatus);

		housing.list.add(new Housing("1", "Bất động sản Hưng Yên",900000000, 5, "Hưng Yên", 200, "Còn"));
		housing.list.add(new Housing("2", "Bất động sản Phú Thọ", 1800000000, 3, "Phú Thọ", 200, "Đã bán"));
		housing.list.add(new Housing("3", "Vinhome OceanPark", 2000000000, 8, "OceanPark", 90, "Đã cọc"));
		housing.list.add(new Housing("4", "EcoPark", 1750000000, 15, "EcoPark", 100, "Chưa cọc"));
		housing.list.add(new Housing("5", "BĐS Hà Tĩnh", 1250000000, 5, "Hà Tĩnh", 300, "Còn"));
		housing.list.add(new Housing("6", "BĐS Thái Bình", 215000000, 6, "Thái Bình", 300, "Đã bán"));
		housing.list.add(new Housing("7", "Landmark 72", 325000000, 3, "Hà Nội", 90, "Còn"));
		housing.list.add(new Housing("8", "Vinhome Smart City", 250000000, 10, "VinHome SmartCity", 100, "Đã cọc"));
		View();
		ViewTable();
	}

	public void View() {
		h = housing.list.get(pos);
		this.txtId.setText(h.getproduct_id());
		this.txtName.setText(h.getproduct_name());
		this.txtPrice.setText("" + h.getproduct_price());
		this.txtTotal.setText("" + h.getproduct_total());
		this.txtLoca.setText(h.getHousing_location());
		this.txtSize.setText("" + h.getHousing_size());
		this.txtStatus.setText(h.getHousing_status());
	}

	public void ViewTable() {
		DefaultTableModel model = (DefaultTableModel) this.tblHousing.getModel();
		model.setNumRows(0);
//		int n = 1;
		for (Housing x : housing.list) {
			model.addRow(new Object[] { x.getproduct_id(), x.getproduct_name(), x.getproduct_price(),
					x.getproduct_total(), x.getHousing_location(), x.getHousing_size(), x.getHousing_status() });
		}
	}
	
	
	public void HandleAdd() {
		Housing t = new Housing();
		t.setproduct_id(this.txtId.getText());
		t.setproduct_name(this.txtName.getText());
		t.setproduct_price(Double.parseDouble(this.txtPrice.getText()));
		t.setproduct_total(Integer.parseInt(this.txtTotal.getText()));
		t.setHousing_location(this.txtLoca.getText());
		t.setHousing_size(Double.parseDouble(this.txtSize.getText()));
		t.setHousing_status(this.txtStatus.getText());
		if(housing.addTile(t)) {
			JOptionPane.showConfirmDialog(this, "Thêm mới sản phẩm thành công!", "Thành công",
					JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showConfirmDialog(this, "Sản phẩm trùng mã với sản phẩm đã tồn tại!", "Lỗi",
					JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
		}
		ViewTable();
	}
	public void HandleUpdate() {
		Housing t = new Housing();
		t.setproduct_id(this.txtId.getText());
		t.setproduct_name(this.txtName.getText());
		t.setproduct_price(Double.parseDouble(this.txtPrice.getText()));
		t.setproduct_total(Integer.parseInt(this.txtTotal.getText()));
		t.setHousing_location(this.txtLoca.getText());
		t.setHousing_size(Double.parseDouble(this.txtSize.getText()));
		t.setHousing_status(this.txtStatus.getText());
		if(housing.editTile(t)) {
			JOptionPane.showConfirmDialog(this, "Sản phẩm chưa có trong danh sách!", "Lỗi",
					JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
		} else {
			JOptionPane.showConfirmDialog(this, "Sửa thông sản phẩm thành công!", "Thành công",
					JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
		}
		ViewTable();
	}
	public void HandleDel() {
		Housing t = new Housing();
		t.setproduct_id(this.txtId.getText());
		t.setproduct_name(this.txtName.getText());
		t.setproduct_price(Double.parseDouble(this.txtPrice.getText()));
		t.setproduct_total(Integer.parseInt(this.txtTotal.getText()));
		t.setHousing_location(this.txtLoca.getText());
		t.setHousing_size(Double.parseDouble(this.txtSize.getText()));
		t.setHousing_status(this.txtStatus.getText());
		if(housing.delTile(t)) {
			JOptionPane.showConfirmDialog(this, "Xóa sản phẩm thành công!", "Thành công",
					JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showConfirmDialog(this, "Sản phẩm không tồn tại!", "Lỗi",
					JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
		}
		ViewTable();
	}
	
	public void ViewSearch() {
		String str = this.txtSearch.getText();

			// TODO: handle exception
			List<Housing> rs = new ArrayList<Housing>();
			rs = housing.searchHousing(str);
			DefaultTableModel model = (DefaultTableModel) this.tblHousing.getModel();
			model.setNumRows(0);
//			int n = 1;
			for(Housing x : rs) {
				model.addRow(new Object[] {x.getproduct_id(),x.getproduct_name(),x.getproduct_price(),x.getproduct_total(),x.getHousing_location(),x.getHousing_size(),x.getHousing_status()});
			}
		
		
	}
	
	
	public void ViewSortbyPrice() {
//		String str = this.txtSearch.getText();
		housing.sortedHousing(true);
		DefaultTableModel model = (DefaultTableModel) this.tblHousing.getModel();
		model.setNumRows(0);
//		int n = 1;
		for(Housing x : housing.list) {
			model.addRow(new Object[] {x.getproduct_id(),x.getproduct_name(),x.getproduct_price(),x.getproduct_total(),x.getHousing_location(),x.getHousing_size(),x.getHousing_status()});
		}
	}
	
	private void showStatisticsDialog() {
        JDialog dialog = new JDialog();
        dialog.setTitle("Thống kê sản phẩm theo giá");
        dialog.setSize(600, 400);
        dialog.setLocationRelativeTo(this);
        dialog.getContentPane().setLayout(new BorderLayout());

        DefaultCategoryDataset data = new DefaultCategoryDataset();
        double minPrice = housing.list.stream().mapToDouble(Housing::getproduct_price).min().orElse(0);
        double maxPrice = housing.list.stream().mapToDouble(Housing::getproduct_price).max().orElse(0);
        double avgPrice = housing.list.stream().mapToDouble(Housing::getproduct_price).average().orElse(0);


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
	
	public void HandleCancel() {
		this.txtId.setText("");
		this.txtName.setText("");
		this.txtPrice.setText("");
		this.txtTotal.setText("");
		this.txtLoca.setText("");
		this.txtSize.setText("");
		this.txtStatus.setText("");
		this.txtSearch.setText("");
		ViewTable();
	}
	
}
