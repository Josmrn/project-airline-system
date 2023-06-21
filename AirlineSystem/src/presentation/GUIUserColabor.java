package presentation;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import java.awt.Cursor;

@SuppressWarnings("serial")
public class GUIUserColabor extends JFrame {

	private JPanel contentPane;
	private JLabel lWelcomeUserManage;
	private JSeparator separator;
	private JTextField tWriteUs;
	private JLabel lUser_1;
	private JLabel lUser;
	private JLabel lNewPass;
	private JPasswordField jPassUs;
	private JSeparator separator_1;
	private JLabel lTypeUser;
	@SuppressWarnings("rawtypes")
	private JComboBox CXTypeUser;
	private JLabel lState;
	@SuppressWarnings("rawtypes")
	private JComboBox cxState;
	private JLabel lPassword;
	private JButton btnRegister;
	private JTextField textField_1;
	private JButton btnConsultUser;
	
	private DefaultTableModel dtmTUsersCol;
	private JTable tUsersCol;
	private Object dataTable[][];
	private JScrollPane spTUsersCol;

	public GUIUserColabor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 909, 472);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLWelcomeUserManage());
		contentPane.add(getSeparator());
		contentPane.add(getTWriteUs());
		contentPane.add(getLUser_1());
		contentPane.add(getLUser());
		contentPane.add(getLNewPass());
		contentPane.add(getJPassUs());
		contentPane.add(getSeparator_1());
		contentPane.add(getLTypeUser());
		contentPane.add(getCXTypeUser());
		contentPane.add(getLState());
		contentPane.add(getCxState());
		contentPane.add(getLPassword());
		contentPane.add(getBtnRegister());
		contentPane.add(getTextField_1());
		contentPane.add(getBtnConsultUser());
		
		setDTMTUsers(dataTable, getColumnsNames());
		setTUsers(dtmTUsersCol);
		setSPTUsers(tUsersCol);
		getContentPane().add(spTUsersCol);
		
		setVisible(true);
	}
	public JLabel getLWelcomeUserManage() {
		if (lWelcomeUserManage == null) {
			lWelcomeUserManage = new JLabel("Bienvenido a Gestión de Usuarios");
			lWelcomeUserManage.setOpaque(true);
			lWelcomeUserManage.setHorizontalAlignment(SwingConstants.CENTER);
			lWelcomeUserManage.setForeground(Color.WHITE);
			lWelcomeUserManage.setFont(new Font("Segoe UI", Font.PLAIN, 18));
			lWelcomeUserManage.setBorder(new LineBorder(new Color(0, 0, 0)));
			lWelcomeUserManage.setBackground(Color.BLUE);
			lWelcomeUserManage.setBounds(10, 10, 875, 40);
		}
		return lWelcomeUserManage;
	}
	public JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setForeground(Color.BLACK);
			separator.setBounds(12, 146, 288, 1);
		}
		return separator;
	}
	public JTextField getTWriteUs() {
		if (tWriteUs == null) {
			tWriteUs = new JTextField();
			tWriteUs.setBackground(new Color(255, 255, 255));
			tWriteUs.setText("Escribir usuario");
			tWriteUs.setForeground(Color.LIGHT_GRAY);
			tWriteUs.setFont(new Font("Tahoma", Font.PLAIN, 14));
			tWriteUs.setColumns(10);
			tWriteUs.setBorder(null);
			tWriteUs.setBounds(54, 118, 245, 25);
		}
		return tWriteUs;
	}
	public JLabel getLUser_1() {
		if (lUser_1 == null) {
			lUser_1 = new JLabel("");
			lUser_1.setIcon(new ImageIcon(GUIUserColabor.class.getResource("/images/user.png")));
			lUser_1.setRequestFocusEnabled(false);
			lUser_1.setHorizontalAlignment(SwingConstants.CENTER);
			lUser_1.setForeground(new Color(30, 144, 255));
			lUser_1.setFont(new Font("Dialog", Font.BOLD, 15));
			lUser_1.setBorder(null);
			lUser_1.setBackground(Color.WHITE);
			lUser_1.setBounds(10, 107, 40, 38);
		}
		return lUser_1;
	}
	public JLabel getLUser() {
		if (lUser == null) {
			lUser = new JLabel("Usuario");
			lUser.setHorizontalAlignment(SwingConstants.CENTER);
			lUser.setFont(new Font("Dialog", Font.BOLD, 15));
			lUser.setBorder(null);
			lUser.setBackground(Color.WHITE);
			lUser.setBounds(12, 70, 64, 38);
		}
		return lUser;
	}
	public JLabel getLNewPass() {
		if (lNewPass == null) {
			lNewPass = new JLabel("Contraseña");
			lNewPass.setFont(new Font("Dialog", Font.BOLD, 15));
			lNewPass.setBounds(14, 157, 206, 20);
		}
		return lNewPass;
	}
	public JPasswordField getJPassUs() {
		if (jPassUs == null) {
			jPassUs = new JPasswordField();
			jPassUs.setText("******");
			jPassUs.setForeground(Color.LIGHT_GRAY);
			jPassUs.setFont(new Font("Tahoma", Font.PLAIN, 14));
			jPassUs.setBorder(null);
			jPassUs.setBounds(47, 189, 252, 25);
		}
		return jPassUs;
	}
	public JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
			separator_1.setForeground(Color.BLACK);
			separator_1.setBounds(14, 217, 288, 1);
		}
		return separator_1;
	}
	public JLabel getLTypeUser() {
		if (lTypeUser == null) {
			lTypeUser = new JLabel("Tipo de usuario");
			lTypeUser.setFont(new Font("Dialog", Font.BOLD, 15));
			lTypeUser.setBounds(14, 243, 206, 20);
		}
		return lTypeUser;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public JComboBox getCXTypeUser() {
		if (CXTypeUser == null) {
			CXTypeUser = new JComboBox();
			CXTypeUser.setModel(new DefaultComboBoxModel(new String[] {"Administrador", "Colaborador"}));
			CXTypeUser.setRequestFocusEnabled(false);
			CXTypeUser.setName("");
			CXTypeUser.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 15));
			CXTypeUser.setBorder(null);
			CXTypeUser.setBounds(14, 272, 123, 25);
		}
		return CXTypeUser;
	}
	public JLabel getLState() {
		if (lState == null) {
			lState = new JLabel("Estado");
			lState.setFont(new Font("Dialog", Font.BOLD, 15));
			lState.setBounds(14, 307, 206, 20);
		}
		return lState;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public JComboBox getCxState() {
		if (cxState == null) {
			cxState = new JComboBox();
			cxState.setModel(new DefaultComboBoxModel(new String[] {"Activo", "Inactivo"}));
			cxState.setRequestFocusEnabled(false);
			cxState.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
			cxState.setBounds(14, 335, 100, 25);
		}
		return cxState;
	}
	public JLabel getLPassword() {
		if (lPassword == null) {
			lPassword = new JLabel("");
			lPassword.setIcon(new ImageIcon(GUIUserColabor.class.getResource("/images/password.png")));
			lPassword.setRequestFocusEnabled(false);
			lPassword.setHorizontalAlignment(SwingConstants.CENTER);
			lPassword.setForeground(new Color(30, 144, 255));
			lPassword.setFont(new Font("Dialog", Font.BOLD, 15));
			lPassword.setBorder(null);
			lPassword.setBackground(Color.WHITE);
			lPassword.setBounds(10, 187, 26, 30);
		}
		return lPassword;
	}
	public JButton getBtnRegister() {
		if (btnRegister == null) {
			btnRegister = new JButton("Registrar");
			btnRegister.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnRegister.setIconTextGap(10);
			btnRegister.setIcon(new ImageIcon("C:\\Users\\UNA\\Downloads\\icons8-agregar-usuario-32.png"));
			btnRegister.setForeground(new Color(0, 0, 128));
			btnRegister.setFont(new Font("Segoe UI", Font.BOLD, 15));
			btnRegister.setContentAreaFilled(false);
			btnRegister.setBorder(new LineBorder(new Color(0, 0, 0)));
			btnRegister.setBounds(9, 387, 291, 38);
		}
		return btnRegister;
	}
	public JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setText("Escribir el nombre usuario que desea consultar/mostrar");
			textField_1.setForeground(Color.LIGHT_GRAY);
			textField_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			textField_1.setColumns(10);
			textField_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			textField_1.setBounds(406, 75, 310, 30);
		}
		return textField_1;
	}
	public JButton getBtnConsultUser() {
		if (btnConsultUser == null) {
			btnConsultUser = new JButton("Consultar");
			btnConsultUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnConsultUser.setIcon(new ImageIcon(GUIUserColabor.class.getResource("/images/icons_consult.png")));
			btnConsultUser.setOpaque(false);
			btnConsultUser.setForeground(new Color(0, 0, 128));
			btnConsultUser.setFont(new Font("Segoe UI", Font.BOLD, 15));
			btnConsultUser.setContentAreaFilled(false);
			btnConsultUser.setBorder(null);
			btnConsultUser.setBounds(726, 70, 110, 35);
		}
		return btnConsultUser;
	}
	
	public void setDTMTUsers(Object data[][], String [] columnsNames) {
		dtmTUsersCol = new DefaultTableModel(data, columnsNames);
	}
	public DefaultTableModel getDTMTUsers() {
		return dtmTUsersCol;
	}
	
	public void setTUsers(DefaultTableModel dtmTBrands) {
		tUsersCol = new JTable(dtmTBrands);
		tUsersCol.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tUsersCol.setEnabled(false);
		tUsersCol.getTableHeader().setReorderingAllowed(false);
		tUsersCol.getTableHeader().setResizingAllowed(false);
	}
	public JTable getTUsers() {
		return this.tUsersCol;
	}
	
	public void setSPTUsers(JTable tBrands) {
		spTUsersCol = new JScrollPane(tBrands);
		spTUsersCol.setBorder(new TitledBorder(null, "Datos de usuarios", TitledBorder.LEFT, TitledBorder.ABOVE_TOP, null, null));
		spTUsersCol.setBounds(406, 146, 479, 273);
	}
	public JScrollPane getSPTPeople() {
		return this.spTUsersCol;
	}
	
	public String[] getColumnsNames() {
		String columnsName[] = {"Usuario","Contraseña","Tipo de Usuario","Estado del Usuario"};
		return columnsName;
	}
	public void cleanForm() {
		tWriteUs.setText("Escribir usuario");
		jPassUs.setText("******");
		CXTypeUser.setSelectedIndex(0);
		cxState.setSelectedIndex(0);
		
	}
}
