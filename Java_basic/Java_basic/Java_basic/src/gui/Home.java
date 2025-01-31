package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;


public class Home extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private TVManagerGUI tvManagerGUI;
	private TileProductUI tileProductUI;
	private HousingUI housingUI;
	private PaintUI paintUI;
	private LoginForm login;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1003, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitle = new JLabel("CÔNG TY MDLQ");
		lblTitle.setForeground(Color.BLUE);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(10, 10, 964, 30); // Adjusted bounds for centering
		contentPane.add(lblTitle);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 50, 960, 586);
		contentPane.add(tabbedPane);
		housingUI = new HousingUI();
		tabbedPane.addTab("Quản lý BĐS", null, housingUI.getContentPane(), null);
		
		// Tab Quản lý Gạch ốp lát
		tileProductUI = new TileProductUI();
		tabbedPane.addTab("Quản lý Gạch ốp lát", null, tileProductUI.getContentPane(), null);
				

		// Tab Quản lý TV
		tvManagerGUI = new TVManagerGUI();
		tabbedPane.addTab("Quản lý TV", null, tvManagerGUI.getContentPane(), null);
		
		
		paintUI = new PaintUI();
		tabbedPane.addTab("Quản lý Sơn tường", null, paintUI, null);
		
	}

}
