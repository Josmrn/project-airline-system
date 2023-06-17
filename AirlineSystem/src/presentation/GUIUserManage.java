package presentation;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;


import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;

@SuppressWarnings("serial")

public class GUIUserManage extends JInternalFrame {

	private JPanel contentPane;
	private JLabel lWelcomeUserManage;
	private JButton btnConsultUser;
	private JButton btnEditUsers;
	private JButton btnUpdateUsers;
	private JButton btnRemoveUser;
	
	private DefaultTableModel dtmTUsers;
	private JTable tUsers;
	private Object dataTable[][];
	private JScrollPane spTUsers;
	private JTextField tUser;
	private JSeparator separator;
	private JButton btnReadUsers;
	private JLabel lUser;
	private JLabel lNewPass;
	private JPasswordField passwordField;
	private JSeparator separator_1;
	private JLabel lTypeUser;
	@SuppressWarnings("rawtypes")
	private JComboBox CXTypeUser;
	private JLabel lState;
	@SuppressWarnings("rawtypes")
	private JComboBox cxState;
	private JButton btnRegister;

	
	public GUIUserManage() {
		setTitle("Airline Software");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 791, 662);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLWelcomeUserManage());
		contentPane.add(getBtnConsultUser());
		contentPane.add(getBtnEditUsers());
		contentPane.add(getBtnUpdateUsers());
		contentPane.add(getBtnRemoveUser());
		contentPane.add(getBtnReadUsers());
		contentPane.add(getBtnRegister());
		setDTMTUsers(dataTable, getColumnsNames());
		setTUsers(dtmTUsers);
		setSPTUsers(tUsers);
		getContentPane().add(spTUsers);
		contentPane.add(getTUser());
		contentPane.add(getSeparator());
		contentPane.add(getLUser());
		contentPane.add(getLNewPass());
		contentPane.add(getJNewPassword());
		contentPane.add(getSeparator_1());
		contentPane.add(getLTypeUser());
		contentPane.add(getCXTypeUser());
		contentPane.add(getLState());
		contentPane.add(getCxState());
		
		
		setVisible(true);
	}
	public JLabel getLWelcomeUserManage() {
		if (lWelcomeUserManage == null) {
			lWelcomeUserManage = new JLabel("Bienvenido a Gestión de Usuarios");
			lWelcomeUserManage.setHorizontalAlignment(SwingConstants.CENTER);
			lWelcomeUserManage.setFont(new Font("Dialog", Font.PLAIN, 18));
			lWelcomeUserManage.setBorder(new LineBorder(new Color(0, 0, 0)));
			lWelcomeUserManage.setBackground(Color.WHITE);
			lWelcomeUserManage.setBounds(10, 10, 360, 40);
		}
		return lWelcomeUserManage;
	}
	public JButton getBtnConsultUser() {
		if (btnConsultUser == null) {
			btnConsultUser = new JButton("Consultar");
			btnConsultUser.setOpaque(false);
			btnConsultUser.setForeground(new Color(0, 0, 128));
			btnConsultUser.setFont(new Font("Segoe UI", Font.BOLD, 15));
			btnConsultUser.setContentAreaFilled(false);
			btnConsultUser.setBorder(null);
			btnConsultUser.setBounds(187, 278, 80, 25);
		}
		return btnConsultUser;
	}
	public JButton getBtnEditUsers() {
		if (btnEditUsers == null) {
			btnEditUsers = new JButton("Editar");
			btnEditUsers.setOpaque(false);
			btnEditUsers.setForeground(new Color(0, 0, 128));
			btnEditUsers.setFont(new Font("Segoe UI", Font.BOLD, 15));
			btnEditUsers.setContentAreaFilled(false);
			btnEditUsers.setBorder(null);
			btnEditUsers.setBounds(277, 278, 50, 25);
		}
		return btnEditUsers;
	}
	public JButton getBtnUpdateUsers() {
		if (btnUpdateUsers == null) {
			btnUpdateUsers = new JButton("Actualizar");
			btnUpdateUsers.setOpaque(false);
			btnUpdateUsers.setForeground(new Color(0, 0, 128));
			btnUpdateUsers.setFont(new Font("Segoe UI", Font.BOLD, 15));
			btnUpdateUsers.setContentAreaFilled(false);
			btnUpdateUsers.setBorder(null);
			btnUpdateUsers.setBounds(337, 278, 80, 25);
		}
		return btnUpdateUsers;
	}
	public JButton getBtnRemoveUser() {
		if (btnRemoveUser == null) {
			btnRemoveUser = new JButton("Eliminar");
			btnRemoveUser.setOpaque(false);
			btnRemoveUser.setForeground(new Color(0, 0, 128));
			btnRemoveUser.setFont(new Font("Segoe UI", Font.BOLD, 15));
			btnRemoveUser.setContentAreaFilled(false);
			btnRemoveUser.setBorder(null);
			btnRemoveUser.setBounds(427, 278, 85, 25);
		}
		return btnRemoveUser;
	}
	
	public JButton getBtnRegister() {
		if (btnRegister == null) {
			btnRegister = new JButton("Registrar");
			btnRegister.setOpaque(false);
			btnRegister.setForeground(new Color(0, 0, 128));
			btnRegister.setFont(new Font("Segoe UI", Font.BOLD, 15));
			btnRegister.setContentAreaFilled(false);
			btnRegister.setBorder(null);
			btnRegister.setBounds(578, 279, 100, 25);
		}
		return btnRegister;
	}
	
	public void setDTMTUsers(Object data[][], String [] columnsNames) {
		dtmTUsers = new DefaultTableModel(data, columnsNames);
	}
	public DefaultTableModel getDTMTUsers() {
		return dtmTUsers;
	}
	
	public void setTUsers(DefaultTableModel dtmTBrands) {
		tUsers = new JTable(dtmTBrands);
		tUsers.setEnabled(false);
		tUsers.getTableHeader().setReorderingAllowed(false);
		tUsers.getTableHeader().setResizingAllowed(false);
	}
	public JTable getTUsers() {
		return this.tUsers;
	}
	
	public void setSPTUsers(JTable tBrands) {
		spTUsers = new JScrollPane(tBrands);
		spTUsers.setBounds(10, 314, 673, 247);
	}
	public JScrollPane getSPTPeople() {
		return this.spTUsers;
	}
	
	public String[] getColumnsNames() {
		String columnsName[] = {"Usuario","Contraseña","Tipo de Usuario","Estado del Usuario"};
		return columnsName;
	}
	public JTextField getTUser() {
		if (tUser == null) {
			tUser = new JTextField();
			tUser.setColumns(10);
			tUser.setBorder(null);
			tUser.setBounds(78, 80, 145, 25);
		}
		return tUser;
	}
	public JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(78, 105, 145, 2);
		}
		return separator;
	}
	public JButton getBtnReadUsers() {
		if (btnReadUsers == null) {
			btnReadUsers = new JButton("Mostrar");
			btnReadUsers.setOpaque(false);
			btnReadUsers.setForeground(new Color(0, 0, 128));
			btnReadUsers.setFont(new Font("Segoe UI", Font.BOLD, 15));
			btnReadUsers.setContentAreaFilled(false);
			btnReadUsers.setBorder(null);
			btnReadUsers.setBounds(508, 278, 80, 25);
		}
		return btnReadUsers;
	}
	public JLabel getLUser() {
		if (lUser == null) {
			lUser = new JLabel("Usuario:");
			lUser.setHorizontalAlignment(SwingConstants.CENTER);
			lUser.setFont(new Font("Dialog", Font.BOLD, 15));
			lUser.setBorder(null);
			lUser.setBackground(Color.WHITE);
			lUser.setBounds(10, 71, 64, 38);
		}
		return lUser;
	}
	public JLabel getLNewPass() {
		if (lNewPass == null) {
			lNewPass = new JLabel("Nueva contraseña");
			lNewPass.setFont(new Font("Dialog", Font.BOLD, 15));
			lNewPass.setBounds(10, 120, 206, 20);
		}
		return lNewPass;
	}
	public JPasswordField getJNewPassword() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setText("******");
			passwordField.setForeground(Color.LIGHT_GRAY);
			passwordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
			passwordField.setBorder(null);
			passwordField.setBounds(10, 140, 310, 25);
		}
		return passwordField;
	}
	public JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
			separator_1.setForeground(Color.BLACK);
			separator_1.setBounds(10, 168, 310, 1);
		}
		return separator_1;
	}
	public JLabel getLTypeUser() {
		if (lTypeUser == null) {
			lTypeUser = new JLabel("Tipo de usuario");
			lTypeUser.setFont(new Font("Dialog", Font.BOLD, 15));
			lTypeUser.setBounds(10, 190, 206, 20);
		}
		return lTypeUser;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public JComboBox getCXTypeUser() {
		if (CXTypeUser == null) {
			CXTypeUser = new JComboBox();
			CXTypeUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			CXTypeUser.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar:", "Administrador", "Colaborador"}));
			CXTypeUser.setRequestFocusEnabled(false);
			CXTypeUser.setName("");
			CXTypeUser.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 13));
			CXTypeUser.setBorder(null);
			CXTypeUser.setBounds(10, 219, 113, 20);
		}
		return CXTypeUser;
	}
	public JLabel getLState() {
		if (lState == null) {
			lState = new JLabel("Estado");
			lState.setFont(new Font("Dialog", Font.BOLD, 15));
			lState.setBounds(10, 250, 206, 20);
		}
		return lState;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public JComboBox getCxState() {
		if (cxState == null) {
			cxState = new JComboBox();
			cxState.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			cxState.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar:", "Activo", "Inactivo"}));
			cxState.setRequestFocusEnabled(false);
			cxState.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 13));
			cxState.setBounds(10, 278, 100, 20);
		}
		return cxState;
	}
	
	
	public void cleanForm() {
		tUser.setText("Crear nuevo usuario");
		passwordField.setText("******");
		CXTypeUser.setSelectedIndex(0);
		cxState.setSelectedIndex(0);
		
	}
}
