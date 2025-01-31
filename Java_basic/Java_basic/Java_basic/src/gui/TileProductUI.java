package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import objects.HoNgocQuyen.Painting;
import objects.VoQuangMinh.Tile;
import objects.VoQuangMinh.TileManagerImpl;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import org.jfree.data.category.DefaultCategoryDataset;
public class TileProductUI extends JFrame {
	TileManagerImpl tile;
	Tile t = new Tile();
	private int pos = 1;

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtPrice;
	private JTextField txtTotal;
	private JTextField txtBrand;
	private JTextField txtLength;
	private JTextField txtWidth;
	private JTextField txtType;
	private JTable tblTile;
	private JTextField txtSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TileProductUI frame = new TileProductUI();
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
	public TileProductUI() {
		tile = new TileManagerImpl();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 983, 547);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(244, 244, 244));
		contentPane.setForeground(new Color(0, 128, 255));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setForeground(new Color(192, 192, 192));
		panel.setBounds(0, 0, 967, 82);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("QUẢN LÝ SẢN PHẨM GẠCH ỐP LÁT");
		lblNewLabel.setBackground(new Color(192, 192, 192));
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(274, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 443, GroupLayout.PREFERRED_SIZE)
					.addGap(250))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(25)
					.addComponent(lblNewLabel)
					.addContainerGap(28, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JLabel lblNewLabel_1 = new JLabel("Mã sản phẩm:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(47, 142, 95, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên sản phẩm:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(47, 176, 95, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Đơn giá:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(47, 209, 95, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Số lượng:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(47, 244, 95, 14);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Thương hiệu:");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3_1.setBounds(47, 280, 95, 17);
		contentPane.add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_1_3_2 = new JLabel("Loại:");
		lblNewLabel_1_3_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3_2.setBounds(47, 317, 95, 14);
		contentPane.add(lblNewLabel_1_3_2);
		
		JLabel lblNewLabel_1_3_3 = new JLabel("Chiều dài:");
		lblNewLabel_1_3_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3_3.setBounds(47, 354, 95, 14);
		contentPane.add(lblNewLabel_1_3_3);
		
		JLabel lblNewLabel_1_3_4 = new JLabel("Chiều rộng:");
		lblNewLabel_1_3_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3_4.setBounds(47, 392, 95, 17);
		contentPane.add(lblNewLabel_1_3_4);
		
		txtId = new JTextField();
		txtId.setBounds(166, 141, 106, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(166, 175, 106, 20);
		contentPane.add(txtName);
		
		txtPrice = new JTextField();
		txtPrice.setColumns(10);
		txtPrice.setBounds(166, 208, 106, 20);
		contentPane.add(txtPrice);
		
		txtTotal = new JTextField();
		txtTotal.setColumns(10);
		txtTotal.setBounds(166, 243, 106, 20);
		contentPane.add(txtTotal);
		
		txtBrand = new JTextField();
		txtBrand.setColumns(10);
		txtBrand.setBounds(166, 280, 106, 20);
		contentPane.add(txtBrand);
		
		txtType = new JTextField();
		txtType.setColumns(10);
		txtType.setBounds(166, 316, 106, 20);
		contentPane.add(txtType);
		
		txtLength = new JTextField();
		txtLength.setColumns(10);
		txtLength.setBounds(166, 353, 106, 20);
		contentPane.add(txtLength);
		
		txtWidth = new JTextField();
		txtWidth.setColumns(10);
		txtWidth.setBounds(166, 392, 106, 20);
		contentPane.add(txtWidth);
		
		
		txtSearch = new JTextField();
		txtSearch.setColumns(10);
		txtSearch.setBounds(331, 104, 163, 26);
		contentPane.add(txtSearch);
		
		JButton btnSearch = new JButton("Tìm kiếm");
		btnSearch.addActionListener(e->ViewSearch());
		btnSearch.setForeground(new Color(255, 255, 255));
		btnSearch.setBackground(new Color(0, 128, 192));
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSearch.setBounds(506, 104, 89, 26);
		contentPane.add(btnSearch);
		
		JButton btnAdd = new JButton("Thêm mới");
		btnAdd.addActionListener(e->HandleAdd());
		btnAdd.setBackground(new Color(0, 128, 0));
		btnAdd.setForeground(new Color(255, 255, 255));
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAdd.setBounds(265, 457, 95, 33);
		contentPane.add(btnAdd);
		
		JButton btnUpdate = new JButton("Sửa");
		btnUpdate.addActionListener(e->HandleUpdate());
		btnUpdate.setForeground(new Color(255, 255, 255));
		btnUpdate.setBackground(new Color(232, 116, 0));
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUpdate.setBounds(379, 457, 95, 33);
		contentPane.add(btnUpdate);
		
		JButton btnDel = new JButton("Xóa");
		btnDel.addActionListener(e->HandleDel());
		btnDel.setBackground(new Color(232, 0, 0));
		btnDel.setForeground(new Color(255, 255, 255));
		btnDel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDel.setBounds(489, 457, 95, 33);
		contentPane.add(btnDel);
		
		JButton btnCancel = new JButton("Hủy bỏ");
		btnCancel.addActionListener(e->HandleCancel());
		btnCancel.setForeground(new Color(255, 255, 255));
		btnCancel.setBackground(new Color(128, 128, 128));
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancel.setBounds(597, 457, 95, 33);
		contentPane.add(btnCancel);
		
		JButton btnSortPrice = new JButton("Sort by Price");
		btnSortPrice.addActionListener(e->ViewSortbyPrice());
		btnSortPrice.setBounds(697, 107, 114, 23);
		contentPane.add(btnSortPrice);
		
		JButton btnSortBrand = new JButton("Sort by Brand");
		btnSortBrand.addActionListener(e->ViewSortbyBrand());
		btnSortBrand.setBounds(821, 107, 114, 23);
		contentPane.add(btnSortBrand);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(331, 142, 604, 270);
		contentPane.add(scrollPane);
		
		 JButton btnStatis = new JButton("Thống kê");
	        btnStatis.setForeground(SystemColor.text);
	        btnStatis.setBackground(new Color(0, 100, 0));
	        btnStatis.setIcon(null);
	        btnStatis.setBounds(706, 457, 95, 33);
	        contentPane.add(btnStatis);
	        
	        btnStatis.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                showStatisticsDialog();
	            }
	        });

		
		tblTile = new JTable();
		scrollPane.setViewportView(tblTile);
		tblTile.setFillsViewportHeight(true);
		tblTile.setToolTipText("");
		tblTile.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tblTile.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				pos = tblTile.getSelectedRow();
				View();
			}
		});
		tblTile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pos = tblTile.getSelectedRow();
				View();
			}
		});
		tblTile.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tblTile.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Name", "Price", "Total", "Brand", "Type", "Length", "Width"
			}
		));
		tblTile.getTableHeader();
		
		tblTile.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JTableHeader header = tblTile.getTableHeader();
		//		header.show();
		//		header.addMouseListener(new SortHeader(this));
				tblTile.setRowHeight(28);
				
				
				 tile.list.add(new
				 Tile("T1","Gạch granite",200000,10,"Viglacia","Vân đá",800,800));
			 tile.list.add(new
				 Tile("T2","Gạch ceramic",1800000,20,"Apodio","Vân gỗ",600,900));
				 tile.list.add(new
				 Tile("T3","Gạch granite",200000,30,"Casagranda","Thiết kế",800,600));
				 tile.list.add(new Tile("T4","Gạch Prime",175000,50,"TASA","Vân đá",300,300));
				 tile.list.add(new
				 Tile("T5","Gạch Taicera",125000,25,"Apodio","Xương bán sứ",300,600));
				 tile.list.add(new
				 Tile("T6","Gạch KIS",215000,40,"Viglacia","Vân gỗ",600,600));
				 tile.list.add(new
				 Tile("T7","Gạch Glassmare",225000,28,"Casagranda","Xương bán sứ",800,600));
				 tile.list.add(new
				 Tile("T8","Gạch Granite Nano",250000,55,"Viglacia","Vân gỗ",900,900));
				 
				 
		View();
		ViewTable();
		
	}
	
	public void View() {
		t = tile.list.get(pos);
		this.txtId.setText(""+t.getproduct_id());
		this.txtName.setText(t.getproduct_name());
		this.txtPrice.setText(""+t.getproduct_price());
		this.txtTotal.setText(""+t.getproduct_total());
		this.txtBrand.setText(t.getTile_brand());
		this.txtType.setText(t.getTile_type());
		this.txtLength.setText(""+t.getTile_size_length());
		this.txtWidth.setText(""+t.getTile_size_width());
	}
	public void ViewTable() {
		DefaultTableModel model = (DefaultTableModel) this.tblTile.getModel();
		model.setNumRows(0);
//		int n = 1;
		for(Tile x : tile.list) {
			model.addRow(new Object[] {x.getproduct_id(),x.getproduct_name(),x.getproduct_price(),x.getproduct_total(),x.getTile_brand(),x.getTile_type(),x.getTile_size_length(),x.getTile_size_width()});
		}
	}
	
	public void HandleAdd() {
		Tile t = new Tile();
		t.setproduct_id(this.txtId.getText());
		t.setproduct_name(this.txtName.getText());
		t.setproduct_price(Double.parseDouble(this.txtPrice.getText()));
		t.setproduct_total(Integer.parseInt(this.txtTotal.getText()));
		t.setTile_brand(this.txtBrand.getText());
		t.setTile_type(this.txtType.getText());
		t.setTile_size_length(Integer.parseInt(this.txtLength.getText()));
		t.setTile_size_width(Integer.parseInt(this.txtWidth.getText()));
		if(tile.addTile(t)) {
			JOptionPane.showConfirmDialog(this, "Thêm mới sản phẩm thành công!", "Thành công",
					JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showConfirmDialog(this, "Sản phẩm trùng mã với sản phẩm đã tồn tại!", "Lỗi",
					JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
		}
		ViewTable();
	}
	public void HandleUpdate() {
		Tile t = new Tile();
		t.setproduct_id(this.txtId.getText());
		t.setproduct_name(this.txtName.getText());
		t.setproduct_price(Double.parseDouble(this.txtPrice.getText()));
		t.setproduct_total(Integer.parseInt(this.txtTotal.getText()));
		t.setTile_brand(this.txtBrand.getText());
		t.setTile_type(this.txtType.getText());
		t.setTile_size_length(Integer.parseInt(this.txtLength.getText()));
		t.setTile_size_width(Integer.parseInt(this.txtWidth.getText()));
		if(tile.editTile(t)) {
			JOptionPane.showConfirmDialog(this, "Sản phẩm chưa có trong danh sách!", "Lỗi",
					JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
		} else {
			JOptionPane.showConfirmDialog(this, "Sửa thông sản phẩm thành công!", "Thành công",
					JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
		}
		ViewTable();
	}
	public void HandleDel() {
		Tile t = new Tile();
		t.setproduct_id(this.txtId.getText());
		t.setproduct_name(this.txtName.getText());
		t.setproduct_price(Double.parseDouble(this.txtPrice.getText()));
		t.setproduct_total(Integer.parseInt(this.txtTotal.getText()));
		t.setTile_brand(this.txtBrand.getText());
		t.setTile_type(this.txtType.getText());
		t.setTile_size_length(Integer.parseInt(this.txtLength.getText()));
		t.setTile_size_width(Integer.parseInt(this.txtWidth.getText()));
		if(tile.delTile(t)) {
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
		try {
			Double price = Double.parseDouble(str);
			List<Tile> rs = new ArrayList<Tile>();
			rs = tile.searchTileByPrice(price);
			DefaultTableModel model = (DefaultTableModel) this.tblTile.getModel();
			model.setNumRows(0);
//			int n = 1;
			for(Tile x : rs) {
				model.addRow(new Object[] {x.getproduct_id(),x.getproduct_name(),x.getproduct_price(),x.getproduct_total(),x.getTile_brand(),x.getTile_type(),x.getTile_size_length(),x.getTile_size_width()});
			}
		} catch (Exception e) {
			// TODO: handle exception
			List<Tile> rs = new ArrayList<Tile>();
			rs = tile.searchTileByName(str);
			DefaultTableModel model = (DefaultTableModel) this.tblTile.getModel();
			model.setNumRows(0);
//			int n = 1;
			for(Tile x : rs) {
				model.addRow(new Object[] {x.getproduct_id(),x.getproduct_name(),x.getproduct_price(),x.getproduct_total(),x.getTile_brand(),x.getTile_type(),x.getTile_size_length(),x.getTile_size_width()});
			}
		}
		
	}
	
	
	public void ViewSortbyPrice() {
//		String str = this.txtSearch.getText();
		tile.sortedTileByPrice(true);
		DefaultTableModel model = (DefaultTableModel) this.tblTile.getModel();
		model.setNumRows(0);
//		int n = 1;
		for(Tile x : tile.list) {
			model.addRow(new Object[] {x.getproduct_id(),x.getproduct_name(),x.getproduct_price(),x.getproduct_total(),x.getTile_brand(),x.getTile_type(),x.getTile_size_length(),x.getTile_size_width()});
		}
	}
	
	public void ViewSortbyBrand() {
		tile.sortedTileByBrand(true);
		DefaultTableModel model = (DefaultTableModel) this.tblTile.getModel();
		model.setNumRows(0);
	//	int n = 1;
		for(Tile x : tile.list) {
			model.addRow(new Object[] {x.getproduct_id(),x.getproduct_name(),x.getproduct_price(),x.getproduct_total(),x.getTile_brand(),x.getTile_type(),x.getTile_size_length(),x.getTile_size_width()});
		}
	}
	
	private void showStatisticsDialog() {
        JDialog dialog = new JDialog();
        dialog.setTitle("Thống kê sản phẩm theo giá");
        dialog.setSize(600, 400);
        dialog.setLocationRelativeTo(this);
        dialog.getContentPane().setLayout(new BorderLayout());

        DefaultCategoryDataset data = new DefaultCategoryDataset();
        double minPrice = tile.list.stream().mapToDouble(Tile::getproduct_price).min().orElse(0);
        double maxPrice = tile.list.stream().mapToDouble(Tile::getproduct_price).max().orElse(0);
        double avgPrice = tile.list.stream().mapToDouble(Tile::getproduct_price).average().orElse(0);


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
		this.txtBrand.setText("");
		this.txtType.setText("");
		this.txtLength.setText("");
		this.txtWidth.setText("");
		this.txtSearch.setText("");
		ViewTable();
	}
}
