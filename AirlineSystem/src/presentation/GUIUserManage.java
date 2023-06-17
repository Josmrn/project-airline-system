package presentation;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import domain.Users;

import java.awt.Font;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JSeparator;

@SuppressWarnings("serial")

public class GUIUserManage extends JInternalFrame {

	private JPanel contentPane;
	private JLabel lWelcomeUserManage;
	private JButton btnConsultUser;
	private JButton btnEditUsers;
	private JButton btnReadUsers;
	private JButton btnRemoveUser;
	
	private DefaultTableModel dtmTUsers;
	private JTable tUsers;
	private Object dataTable[][];
	private JScrollPane spTUsers;
	private JTextField tUser;
	private JSeparator separator;

	
	public GUIUserManage() {
		setTitle("Airline Software");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 859, 485);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLWelcomeUserManage());
		contentPane.add(getBtnConsultUser());
		contentPane.add(getBtnEditUsers());
		contentPane.add(getBtnReadUsers());
		contentPane.add(getBtnRemoveUser());
		setDTMTUsers(dataTable, getColumnsNames());
		setTUsers(dtmTUsers);
		setSPTUsers(tUsers);
		getContentPane().add(spTUsers);
		contentPane.add(getTUser());
		contentPane.add(getSeparator());
		
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
			btnConsultUser.setBounds(358, 120, 80, 25);
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
			btnEditUsers.setBounds(448, 120, 50, 25);
		}
		return btnEditUsers;
	}
	public JButton getBtnReadUsers() {
		if (btnReadUsers == null) {
			btnReadUsers = new JButton("Mostrar");
			btnReadUsers.setOpaque(false);
			btnReadUsers.setForeground(new Color(0, 0, 128));
			btnReadUsers.setFont(new Font("Segoe UI", Font.BOLD, 15));
			btnReadUsers.setContentAreaFilled(false);
			btnReadUsers.setBorder(null);
			btnReadUsers.setBounds(508, 120, 80, 25);
		}
		return btnReadUsers;
	}
	public JButton getBtnRemoveUser() {
		if (btnRemoveUser == null) {
			btnRemoveUser = new JButton("Eliminar");
			btnRemoveUser.setOpaque(false);
			btnRemoveUser.setForeground(new Color(0, 0, 128));
			btnRemoveUser.setFont(new Font("Segoe UI", Font.BOLD, 15));
			btnRemoveUser.setContentAreaFilled(false);
			btnRemoveUser.setBorder(null);
			btnRemoveUser.setBounds(598, 120, 85, 25);
		}
		return btnRemoveUser;
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
		spTUsers.setBounds(10, 156, 673, 247);
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
			tUser.setBounds(10, 118, 350, 25);
		}
		return tUser;
	}
	public JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(10, 144, 350, 1);
		}
		return separator;
	}
	
}
