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
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

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
	private JSeparator separator;
	private JButton btnReadUsers;
	private JLabel lUser;
	private JLabel lNewPass;
	private JPasswordField jPassword;
	private JSeparator separator_1;
	private JLabel lTypeUser;
	@SuppressWarnings("rawtypes")
	private JComboBox CXTypeUser;
	private JLabel lState;
	@SuppressWarnings("rawtypes")
	private JComboBox cxState;
	private JButton btnRegister;
	private JLabel lUser_1;
	private JTextField tUserAdd;
	private JLabel lOperationUser;
	private JTextField txtEscribirElNombre;
      
	
	public GUIUserManage() {
		setTitle("Airline Software");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 860, 703);
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
		contentPane.add(getSeparator());
		contentPane.add(getLUser());
		contentPane.add(getLNewPass());
		contentPane.add(getJNewPassword());
		contentPane.add(getSeparator_1());
		contentPane.add(getLTypeUser());
		contentPane.add(getCXTypeUser());
		contentPane.add(getLState());
		contentPane.add(getCxState());
		contentPane.add(getLUser_1());
		contentPane.add(getTUserAdd());
		contentPane.add(getLOperationUser());
		contentPane.add(getTxtEscribirElNombre());
		
		setVisible(true);
	}
	public JLabel getLWelcomeUserManage() {
		if (lWelcomeUserManage == null) {
			lWelcomeUserManage = new JLabel("Bienvenido a Gestión de Usuarios");
			lWelcomeUserManage.setForeground(new Color(255, 255, 255));
			lWelcomeUserManage.setOpaque(true);
			lWelcomeUserManage.setHorizontalAlignment(SwingConstants.CENTER);
			lWelcomeUserManage.setFont(new Font("Segoe UI", Font.PLAIN, 18));
			lWelcomeUserManage.setBorder(new LineBorder(new Color(0, 0, 0)));
			lWelcomeUserManage.setBackground(new Color(0, 0, 255));
			lWelcomeUserManage.setBounds(10, 10, 828, 40);
		}
		return lWelcomeUserManage;
	}
	public JButton getBtnConsultUser() {
		if (btnConsultUser == null) {
			btnConsultUser = new JButton("Consultar");
			btnConsultUser.setIcon(new ImageIcon(GUIUserManage.class.getResource("/images/icons_consult.png")));
			btnConsultUser.setOpaque(false);
			btnConsultUser.setForeground(new Color(0, 0, 128));
			btnConsultUser.setFont(new Font("Segoe UI", Font.BOLD, 15));
			btnConsultUser.setContentAreaFilled(false);
			btnConsultUser.setBorder(null);
			btnConsultUser.setBounds(728, 372, 110, 35);
		}
		return btnConsultUser;
	}
	public JButton getBtnEditUsers() {
		if (btnEditUsers == null) {
			btnEditUsers = new JButton("Editar");
			btnEditUsers.setIcon(new ImageIcon(GUIUserManage.class.getResource("/images/icons_edit.png")));
			btnEditUsers.setOpaque(false);
			btnEditUsers.setForeground(new Color(0, 0, 128));
			btnEditUsers.setFont(new Font("Segoe UI", Font.BOLD, 15));
			btnEditUsers.setContentAreaFilled(false);
			btnEditUsers.setBorder(null);
			btnEditUsers.setBounds(616, 109, 75, 25);
		}
		return btnEditUsers;
	}
	public JButton getBtnUpdateUsers() {
		if (btnUpdateUsers == null) {
			btnUpdateUsers = new JButton("Salir");
			btnUpdateUsers.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnUpdateUsers.setOpaque(false);
			btnUpdateUsers.setForeground(new Color(0, 0, 128));
			btnUpdateUsers.setFont(new Font("Segoe UI", Font.BOLD, 15));
			btnUpdateUsers.setContentAreaFilled(false);
			btnUpdateUsers.setBorder(null);
			btnUpdateUsers.setBounds(500, 109, 80, 25);
		}
		return btnUpdateUsers;
	}
	public JButton getBtnRemoveUser() {
		if (btnRemoveUser == null) {
			btnRemoveUser = new JButton("Eliminar");
			btnRemoveUser.setIcon(new ImageIcon(GUIUserManage.class.getResource("/images/icons_remove.png")));
			btnRemoveUser.setOpaque(false);
			btnRemoveUser.setForeground(new Color(0, 0, 128));
			btnRemoveUser.setFont(new Font("Segoe UI", Font.BOLD, 15));
			btnRemoveUser.setContentAreaFilled(false);
			btnRemoveUser.setBorder(null);
			btnRemoveUser.setBounds(748, 109, 90, 25);
		}
		return btnRemoveUser;
	}
	
	public JButton getBtnRegister() {
		if (btnRegister == null) {
			btnRegister = new JButton("Registrar");
			btnRegister.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnRegister.setIcon(new ImageIcon(GUIUserManage.class.getResource("/images/icons_add.png")));
			btnRegister.setForeground(new Color(0, 0, 128));
			btnRegister.setFont(new Font("Segoe UI", Font.BOLD, 15));
			btnRegister.setContentAreaFilled(false);
			btnRegister.setBorder(null);
			btnRegister.setBounds(379, 110, 105, 25);
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
		tUsers.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tUsers.setEnabled(false);
		tUsers.getTableHeader().setReorderingAllowed(false);
		tUsers.getTableHeader().setResizingAllowed(false);
	}
	public JTable getTUsers() {
		return this.tUsers;
	}
	
	public void setSPTUsers(JTable tBrands) {
		spTUsers = new JScrollPane(tBrands);
		spTUsers.setBorder(new TitledBorder(null, "Datos de usuarios", TitledBorder.LEFT, TitledBorder.ABOVE_TOP, null, null));
		spTUsers.setBounds(10, 417, 828, 247);
	}
	public JScrollPane getSPTPeople() {
		return this.spTUsers;
	}
	
	public String[] getColumnsNames() {
		String columnsName[] = {"Usuario","Contraseña","Tipo de Usuario","Estado del Usuario"};
		return columnsName;
	}
	public JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setForeground(new Color(0, 0, 0));
			separator.setBounds(10, 138, 288, 1);
		}
		return separator;
	}
	public JButton getBtnReadUsers() {
		if (btnReadUsers == null) {
			btnReadUsers = new JButton("Mostrar");
			btnReadUsers.setIcon(new ImageIcon(GUIUserManage.class.getResource("/images/icons_show.png")));
			btnReadUsers.setOpaque(false);
			btnReadUsers.setForeground(new Color(0, 0, 128));
			btnReadUsers.setFont(new Font("Segoe UI", Font.BOLD, 15));
			btnReadUsers.setContentAreaFilled(false);
			btnReadUsers.setBorder(null);
			btnReadUsers.setBounds(315, 372, 95, 35);
		}
		return btnReadUsers;
	}
	public JLabel getLUser() {
		if (lUser == null) {
			lUser = new JLabel("Usuario");
			lUser.setHorizontalAlignment(SwingConstants.CENTER);
			lUser.setFont(new Font("Dialog", Font.BOLD, 15));
			lUser.setBorder(null);
			lUser.setBackground(Color.WHITE);
			lUser.setBounds(10, 62, 64, 38);
		}
		return lUser;
	}
	public JLabel getLNewPass() {
		if (lNewPass == null) {
			lNewPass = new JLabel("Contraseña");
			lNewPass.setFont(new Font("Dialog", Font.BOLD, 15));
			lNewPass.setBounds(10, 164, 206, 20);
		}
		return lNewPass;
	}
	public JPasswordField getJNewPassword() {
		if (jPassword == null) {
			jPassword = new JPasswordField();
			jPassword.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
					if(String.valueOf(jPassword.getPassword()).equals("******")) {
						jPassword.setText("");
						jPassword.setForeground(Color.black);
					}
					if(tUserAdd.getText().isEmpty()) {
						tUserAdd.setText("Escribir usuario");
						tUserAdd.setForeground(Color.gray);
					}
				}
			});
			jPassword.setText("******");
			jPassword.setForeground(Color.LIGHT_GRAY);
			jPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
			jPassword.setBorder(null);
			jPassword.setBounds(10, 184, 310, 25);
		}
		return jPassword;
	}
	public JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
			separator_1.setForeground(Color.BLACK);
			separator_1.setBounds(10, 212, 310, 1);
		}
		return separator_1;
	}
	public JLabel getLTypeUser() {
		if (lTypeUser == null) {
			lTypeUser = new JLabel("Tipo de usuario");
			lTypeUser.setFont(new Font("Dialog", Font.BOLD, 15));
			lTypeUser.setBounds(10, 241, 206, 20);
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
			CXTypeUser.setBounds(10, 270, 113, 25);
		}
		return CXTypeUser;
	}
	public JLabel getLState() {
		if (lState == null) {
			lState = new JLabel("Estado");
			lState.setFont(new Font("Dialog", Font.BOLD, 15));
			lState.setBounds(10, 305, 206, 20);
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
			cxState.setBounds(10, 333, 100, 25);
		}
		return cxState;
	}
	
	
	public void cleanForm() {
		tUserAdd.setText("Escribir usuario");
		jPassword.setText("******");
		CXTypeUser.setSelectedIndex(0);
		cxState.setSelectedIndex(0);
		
	}
	public JLabel getLUser_1() {
		if (lUser_1 == null) {
			lUser_1 = new JLabel("");
			lUser_1.setRequestFocusEnabled(false);
			lUser_1.setForeground(new Color(30, 144, 255));
			lUser_1.setIcon(new ImageIcon("C:\\Users\\UNA\\Downloads\\icons8-usuario-masculino-en-círculo-32.png"));
			lUser_1.setHorizontalAlignment(SwingConstants.CENTER);
			lUser_1.setFont(new Font("Dialog", Font.BOLD, 15));
			lUser_1.setBorder(null);
			lUser_1.setBackground(Color.WHITE);
			lUser_1.setBounds(10, 99, 40, 38);
		}
		return lUser_1;
	}
	public JTextField getTUserAdd() {
		if (tUserAdd == null) {
			tUserAdd = new JTextField();
			tUserAdd.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
					if(tUserAdd.getText().equals("Escribir usuario")) {
						tUserAdd.setText("");
						tUserAdd.setForeground(Color.black);
					}
					if(String.valueOf(jPassword.getPassword()).isEmpty()) {
						jPassword.setText("******");
						jPassword.setForeground(Color.gray);
					}
				}
			});
			tUserAdd.setText("Escribir usuario");
			tUserAdd.setForeground(Color.LIGHT_GRAY);
			tUserAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));
			tUserAdd.setColumns(10);
			tUserAdd.setBorder(null);
			tUserAdd.setBounds(52, 110, 245, 25);
		}
		return tUserAdd;
	}
	public JLabel getLOperationUser() {
		if (lOperationUser == null) {
			lOperationUser = new JLabel("Operaciones");
			lOperationUser.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			lOperationUser.setFont(new Font("Segoe UI", Font.BOLD, 15));
			lOperationUser.setBounds(379, 69, 459, 25);
		}
		return lOperationUser;
	}
	public JTextField getTxtEscribirElNombre() {
		if (txtEscribirElNombre == null) {
			txtEscribirElNombre = new JTextField();
			txtEscribirElNombre.setText("Escribir el nombre usuario que desea consultar/mostrar");
			txtEscribirElNombre.setForeground(Color.LIGHT_GRAY);
			txtEscribirElNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtEscribirElNombre.setColumns(10);
			txtEscribirElNombre.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			txtEscribirElNombre.setBounds(415, 372, 310, 30);
		}
		return txtEscribirElNombre;
	}
}
