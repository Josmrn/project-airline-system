package presentation;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class GUIUser extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lNewUser;
	private JTextField txtCrearNuevoUsuario;
	private JSeparator separator;
	private JLabel lNewPassword;
	private JPasswordField pwdIngresarContrasea;
	private JSeparator separator_1;
	private JButton btnNewRegister;
	private JLabel lTypeUser;
	@SuppressWarnings("rawtypes")
	private JComboBox CXTypeUser;
	private JLabel lState;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;
	private JButton btnReturn;

	public GUIUser() {
		setTitle("Registro usuario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 386, 443);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getLNewUser());
		contentPane.add(getTxtCrearNuevoUsuario());
		contentPane.add(getSeparator());
		contentPane.add(getLNewPassword());
		contentPane.add(getPwdIngresarContrasea());
		contentPane.add(getSeparator_1());
		contentPane.add(getBtnNewRegister());
		contentPane.add(getLTypeUser());
		contentPane.add(getCXTypeUser());
		contentPane.add(getLState());
		contentPane.add(getComboBox());
		contentPane.add(getBtnReturn());
		setVisible(true);
	}

	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("  Crear usuario");
			lblNewLabel.setIcon(new ImageIcon("C:\\Users\\UNA\\OneDrive\\Documentos\\Universidad\\Java-Eclipse\\AirlineSystem\\src\\images\\User Add 48x48.png"));
			lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 18));
			lblNewLabel.setBounds(10, 10, 200, 40);
		}
		return lblNewLabel;
	}
	public JLabel getLNewUser() {
		if (lNewUser == null) {
			lNewUser = new JLabel("Ingresar nombre de usuario");
			lNewUser.setFont(new Font("Roboto Light", Font.BOLD, 15));
			lNewUser.setBounds(10, 80, 206, 20);
		}
		return lNewUser;
	}
	public JTextField getTxtCrearNuevoUsuario() {
		if (txtCrearNuevoUsuario == null) {
			txtCrearNuevoUsuario = new JTextField();
			txtCrearNuevoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtCrearNuevoUsuario.setBorder(null);
			txtCrearNuevoUsuario.setForeground(new Color(192, 192, 192));
			txtCrearNuevoUsuario.setText("Crear nuevo usuario");
			txtCrearNuevoUsuario.setBounds(10, 105, 310, 25);
			txtCrearNuevoUsuario.setColumns(10);
		}
		return txtCrearNuevoUsuario;
	}
	public JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setForeground(new Color(0, 0, 0));
			separator.setBounds(10, 132, 310, 1);
		}
		return separator;
	}
	public JLabel getLNewPassword() {
		if (lNewPassword == null) {
			lNewPassword = new JLabel("Nueva contraseña");
			lNewPassword.setFont(new Font("Roboto Light", Font.BOLD, 15));
			lNewPassword.setBounds(10, 160, 206, 20);
		}
		return lNewPassword;
	}
	public JPasswordField getPwdIngresarContrasea() {
		if (pwdIngresarContrasea == null) {
			pwdIngresarContrasea = new JPasswordField();
			pwdIngresarContrasea.setFont(new Font("Tahoma", Font.PLAIN, 14));
			pwdIngresarContrasea.setForeground(new Color(192, 192, 192));
			pwdIngresarContrasea.setText("******");
			pwdIngresarContrasea.setBorder(null);
			pwdIngresarContrasea.setBounds(10, 180, 310, 25);
		}
		return pwdIngresarContrasea;
	}
	public JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
			separator_1.setForeground(Color.BLACK);
			separator_1.setBounds(10, 208, 310, 1);
		}
		return separator_1;
	}
	public JButton getBtnNewRegister() {
		if (btnNewRegister == null) {
			btnNewRegister = new JButton("Registrar");
			btnNewRegister.setFont(new Font("Roboto Light", Font.BOLD, 12));
			btnNewRegister.setBounds(10, 370, 85, 25);
		}
		return btnNewRegister;
	}
	public JLabel getLTypeUser() {
		if (lTypeUser == null) {
			lTypeUser = new JLabel("Tipo de usuario");
			lTypeUser.setFont(new Font("Roboto Light", Font.BOLD, 15));
			lTypeUser.setBounds(10, 230, 206, 20);
		}
		return lTypeUser;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public JComboBox getCXTypeUser() {
		if (CXTypeUser == null) {
			CXTypeUser = new JComboBox();
			CXTypeUser.setRequestFocusEnabled(false);
			CXTypeUser.setBorder(null);
			CXTypeUser.setName("");
			CXTypeUser.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 13));
			CXTypeUser.setModel(new DefaultComboBoxModel(new String[] {"", "Administrador", "Colaborador"}));
			CXTypeUser.setBounds(10, 260, 113, 20);
		}
		return CXTypeUser;
	}
	public JLabel getLState() {
		if (lState == null) {
			lState = new JLabel("Estado");
			lState.setFont(new Font("Roboto Light", Font.BOLD, 15));
			lState.setBounds(10, 290, 206, 20);
		}
		return lState;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setRequestFocusEnabled(false);
			comboBox.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 13));
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Activo", "Inactivo"}));
			comboBox.setBounds(10, 320, 100, 20);
		}
		return comboBox;
	}
	public JButton getBtnReturn() {
		if (btnReturn == null) {
			btnReturn = new JButton("Regresar");
			btnReturn.setFont(new Font("Roboto Light", Font.BOLD, 12));
			btnReturn.setBounds(235, 370, 85, 25);
		}
		return btnReturn;
	}
}
