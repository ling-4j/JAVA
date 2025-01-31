package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import objects.HoNgocQuyen.Painting;

import static gui.PaintUI.list;
import static gui.PaintUI.saveToFile;
import javax.swing.SwingConstants;

public class AddEditDialog extends JDialog {

    private static final long serialVersionUID = 1L;
    private boolean isEdit;
    private int rowIndex;
    private PaintUI parent;
    private JTextField txtProductId;
    private JTextField txtProductName;
    private JTextField txtProductPrice;
    private JTextField txtProductTotal;
    private JTextField txtManufacturer;
    private JComboBox<String> cbColor;
    private JTextField txtFrom;

    public AddEditDialog( String title, Object[] product, int rowIndex) {
        
        this.rowIndex = rowIndex;
        setSize(509, 385);
        

        JPanel panel = new JPanel();
        panel.setLayout(null);
        getContentPane().add(panel);

        JLabel label = new JLabel("Product Id");
        label.setFont(new Font("Tahoma", Font.BOLD, 12));
        label.setBounds(24, 63, 91, 32);
        panel.add(label);
        txtProductId = new JTextField();
        txtProductId.setBounds(117, 65, 69, 32);
        panel.add(txtProductId);

        JLabel lblProductName = new JLabel("Product Name");
        lblProductName.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblProductName.setBounds(212, 63, 96, 32);
        panel.add(lblProductName);
        txtProductName = new JTextField();
        txtProductName.setBounds(308, 64, 156, 32);
        panel.add(txtProductName);

        JLabel lblProductPrice = new JLabel("Product Price");
        lblProductPrice.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblProductPrice.setBounds(24, 107, 91, 32);
        panel.add(lblProductPrice);
        txtProductPrice = new JTextField();
        txtProductPrice.setBounds(134, 109, 91, 32);
        panel.add(txtProductPrice);

        JLabel lblProductTotal = new JLabel("Product Total");
        lblProductTotal.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblProductTotal.setBounds(248, 107, 107, 32);
        panel.add(lblProductTotal);
        txtProductTotal = new JTextField();
        txtProductTotal.setBounds(351, 109, 134, 32);
        panel.add(txtProductTotal);

        JLabel lblColor = new JLabel("Color");
        lblColor.setFont(new Font("Dialog", Font.BOLD, 12));
        lblColor.setBounds(35, 166, 61, 32);
        panel.add(lblColor);
        cbColor = new JComboBox<>();
        cbColor.setModel(new DefaultComboBoxModel<>(new String[]{"Đỏ", "Cam", "Vàng", "Xanh lục", "Xanh dương", "Đen", "Trắng"}));
        cbColor.setBounds(111, 167, 69, 32);
        panel.add(cbColor);

        JLabel lblManufacturer = new JLabel("Manufacturer");
        lblManufacturer.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblManufacturer.setBounds(240, 166, 91, 32);
        panel.add(lblManufacturer);
        txtManufacturer = new JTextField();
        txtManufacturer.setBounds(350, 168, 91, 32);
        panel.add(txtManufacturer);

        JLabel lblFrom = new JLabel("From");
        lblFrom.setFont(new Font("Dialog", Font.BOLD, 12));
        lblFrom.setBounds(35, 232, 61, 32);
        panel.add(lblFrom);

        
        JButton btnSave = new JButton("Save");
        btnSave.setBounds(63, 298, 116, 32);
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (validateForm()) {
                    if (isEdit) {
                        updateFile(rowIndex);
                    } else {
                        saveFile();
                    }
                    dispose();
                }
            }
        });
        panel.add(btnSave);

        JButton btnCancel = new JButton("Hủy");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnCancel.setBounds(248, 298, 116, 32);
        panel.add(btnCancel);
        
        txtFrom = new JTextField();
        txtFrom.setBounds(111, 232, 114, 32);
        panel.add(txtFrom);
        txtFrom.setColumns(10);
        
        JLabel lblTitle = new JLabel(title);
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblTitle.setBounds(111, 10, 220, 43);
        panel.add(lblTitle);

        if (product != null) {
            isEdit = true;
            setProductData(product);
        }
    }

    private boolean validateForm() {
        for (int i = 0; i < list.size(); i++) {
            if (txtProductId.getText().equalsIgnoreCase(list.get(i).getproduct_id())) {
                JOptionPane.showMessageDialog(parent, "Duplicate product ID");
                return false;
            }
        }
        return true;
    }
    

    private void saveFile() {
        Painting tv = new Painting();
        tv.setproduct_id(txtProductId.getText());
        tv.setproduct_name(txtProductName.getText());
        tv.setproduct_price(Double.parseDouble(txtProductPrice.getText()));
        tv.setproduct_total(Integer.parseInt(txtProductTotal.getText()));
        tv.setColor((String) cbColor.getSelectedItem());
        tv.setManufacturer(txtManufacturer.getText());
        tv.setImportDate(txtFrom.getText());
        list.add(tv);
        saveToFile();
    }

    private void updateFile(int rowIndex) {
        if (rowIndex >= 0 && rowIndex < list.size()) {
            Painting tv = list.get(rowIndex);
            tv.setproduct_id(txtProductId.getText());
            tv.setproduct_name(txtProductName.getText());
            tv.setproduct_price(Double.parseDouble(txtProductPrice.getText()));
            tv.setproduct_total(Integer.parseInt(txtProductTotal.getText()));
            tv.setColor((String) cbColor.getSelectedItem());
            tv.setManufacturer(txtManufacturer.getText());
            tv.setImportDate(txtFrom.getText());
            list.set(rowIndex, tv);
            saveToFile();
            
        } else {
            throw new IndexOutOfBoundsException("Index " + rowIndex + " out of bounds for length " + list.size());
        }
    }

    

    private void setProductData(Object[] product) {
        txtProductId.setText(product[0].toString());
        txtProductName.setText(product[1].toString());
        txtProductPrice.setText(product[2].toString());
        txtProductTotal.setText(product[3].toString());
        cbColor.setSelectedItem(product[4]);
        txtManufacturer.setText(product[5].toString());
        txtFrom.setText(product[6].toString());
    }
}
