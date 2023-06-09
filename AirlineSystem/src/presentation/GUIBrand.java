package presentation;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Cursor;
import javax.swing.JSeparator;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class GUIBrand extends JFrame {

	private JPanel contentPane;
	private JLabel lWelcomeBrand;
	private JLabel lNameBrands;
	private JTextField tNameBrands;
	private JButton btnRegisterBrand;
	private JButton btnRemoveBrand;
	private JButton btnEditBrands;
	private JButton btnConsultBrand;
	private JButton btnReadBrand;
	//private JTextField textField_1;
	private JLabel lTextBrandsReg;
	private JSeparator separator;
	//--------------------------------------
	private DefaultTableModel dtmTBrands;
	private JTable tBrands;
	
	private JScrollPane spTBrands;
	private Object dataTable[][];
	//--------------------------------------

	public GUIBrand() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 487, 595);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLWelcomeBrand());
		contentPane.add(getLNameBrands());
		contentPane.add(getTNameBrands());
		contentPane.add(getBtnRegisterBrand());
		contentPane.add(getBtnRemoveBrand());
		contentPane.add(getBtnEditBrands());
		contentPane.add(getBtnConsultBrand());
		contentPane.add(getBtnReadBrand());
		//----------------------------------------------------------
		setDTMTBrands(dataTable, getColumnsNames());
		setTBrands(dtmTBrands);
		setSPTBrands(tBrands);
		contentPane.add(spTBrands);
		//----------------------------------------------------------
		//contentPane.add(getTextField_1());
		contentPane.add(getLTextBrandsReg());
		contentPane.add(getSeparator());
		setVisible(true);
	}
	
	
	public JLabel getLWelcomeBrand() {
		if (lWelcomeBrand == null) {
			lWelcomeBrand = new JLabel("Bienvenido a Gestión de Marcas de Aviones");
			lWelcomeBrand.setBorder(new LineBorder(new Color(0, 0, 0)));
			lWelcomeBrand.setBackground(new Color(255, 255, 255));
			lWelcomeBrand.setHorizontalAlignment(SwingConstants.CENTER);
			lWelcomeBrand.setFont(new Font("Roboto Black", Font.PLAIN, 18));
			lWelcomeBrand.setBounds(10, 10, 452, 41);
		}
		return lWelcomeBrand;
	}
	public JLabel getLNameBrands() {
		if (lNameBrands == null) {
			lNameBrands = new JLabel("Ingrese la Marca del Avión");
			lNameBrands.setBackground(new Color(0, 128, 128));
			lNameBrands.setHorizontalAlignment(SwingConstants.LEFT);
			lNameBrands.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			lNameBrands.setBounds(10, 80, 200, 25);
		}
		return lNameBrands;
	}
	public JTextField getTNameBrands() {
		if (tNameBrands == null) {
			tNameBrands = new JTextField();
			tNameBrands.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
			tNameBrands.setBorder(null);
			tNameBrands.setBounds(10, 113, 300, 25);
			tNameBrands.setColumns(10);
		}
		return tNameBrands;
	}
	public JButton getBtnRegisterBrand() {
		if (btnRegisterBrand == null) {
			btnRegisterBrand = new JButton("Registrar");
			btnRegisterBrand.setOpaque(false);
			btnRegisterBrand.setFont(new Font("Segoe UI", Font.BOLD, 15));
			btnRegisterBrand.setForeground(new Color(0, 0, 128));
			btnRegisterBrand.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnRegisterBrand.setBorder(null);
			btnRegisterBrand.setBackground(new Color(95, 158, 160));
			btnRegisterBrand.setBounds(10, 150, 85, 25);
		}
		return btnRegisterBrand;
	}
	public JButton getBtnRemoveBrand() {
		if (btnRemoveBrand == null) {
			btnRemoveBrand = new JButton("Eliminar");
			btnRemoveBrand.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnRemoveBrand.setBackground(new Color(165, 42, 42));
			btnRemoveBrand.setBorder(null);
			btnRemoveBrand.setFont(new Font("Segoe UI", Font.BOLD, 15));
			btnRemoveBrand.setBounds(362, 525, 100, 25);
		}
		return btnRemoveBrand;
	}
	public JButton getBtnEditBrands() {
		if (btnEditBrands == null) {
			btnEditBrands = new JButton("Editar");
			btnEditBrands.setForeground(new Color(0, 0, 128));
			btnEditBrands.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnEditBrands.setOpaque(false);
			btnEditBrands.setBorder(null);
			btnEditBrands.setFont(new Font("Segoe UI", Font.BOLD, 15));
			btnEditBrands.setBounds(302, 237, 50, 25);
		}
		return btnEditBrands;
	}
	public JButton getBtnConsultBrand() {
		if (btnConsultBrand == null) {
			btnConsultBrand = new JButton("Consultar");
			btnConsultBrand.setForeground(new Color(0, 0, 128));
			btnConsultBrand.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnConsultBrand.setOpaque(false);
			btnConsultBrand.setBorder(null);
			btnConsultBrand.setFont(new Font("Segoe UI", Font.BOLD, 15));
			btnConsultBrand.setBounds(190, 237, 102, 25);
		}
		return btnConsultBrand;
	}
	public JButton getBtnReadBrand() {
		if (btnReadBrand == null) {
			btnReadBrand = new JButton("Mostrar");
			btnReadBrand.setForeground(new Color(0, 0, 128));
			btnReadBrand.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnReadBrand.setOpaque(false);
			btnReadBrand.setBorder(null);
			btnReadBrand.setFont(new Font("Segoe UI", Font.BOLD, 15));
			btnReadBrand.setBounds(362, 237, 100, 25);
		}
		return btnReadBrand;
	}
	/*
	public JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setBounds(10, 268, 452, 247);
			textField_1.setColumns(10);
		}
		return textField_1;
	}*/
	
	//-------------------------------------------------------------------------------------
	public void setDTMTBrands(Object data[][], String [] columnsNames) {
		dtmTBrands = new DefaultTableModel(data, columnsNames);
	}
	public DefaultTableModel getDTMTBrands() {
		return dtmTBrands;
	}
	
	public void setTBrands(DefaultTableModel dtmTBrands) {
		tBrands = new JTable(dtmTBrands);
		tBrands.setEnabled(false);
		tBrands.getTableHeader().setReorderingAllowed(false);
		tBrands.getTableHeader().setResizingAllowed(false);
	}
	public JTable getTBrands() {
		return this.tBrands;
	}
	
	public void setSPTBrands(JTable tBrands) {
		spTBrands = new JScrollPane(tBrands);
		spTBrands.setBounds(10, 268, 452, 247);
	}
	public JScrollPane getSPTPeople() {
		return this.spTBrands;
	}
	
	public String[] getColumnsNames() {
		String columnsName[] = {"Marca de Avión"};
		return columnsName;
	}
	//-------------------------------------------------------------------------------------
	
	public JLabel getLTextBrandsReg() {
		if (lTextBrandsReg == null) {
			lTextBrandsReg = new JLabel("Marcas registradas");
			lTextBrandsReg.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			lTextBrandsReg.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			lTextBrandsReg.setBounds(10, 237, 132, 25);
		}
		return lTextBrandsReg;
	}
	public JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(10, 138, 300, 1);
		}
		return separator;
	}
}
