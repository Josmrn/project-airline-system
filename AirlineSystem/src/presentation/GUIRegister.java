package presentation;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Cursor;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class GUIRegister extends JInternalFrame {
	private JLabel lTitleUser;
	private JLabel lTextAddUser;
	private JTextField tAddUser;
	private JLabel lNewPass;
	private JPasswordField jNewPassword;
	private JSeparator separator_1;
	private JLabel lTypeUser;
	@SuppressWarnings("rawtypes")
	private JComboBox CXTypeUser;
	private JLabel lState;
	@SuppressWarnings("rawtypes")
	private JComboBox cxState;
	private JButton btnNewRegister;
	private JSeparator separator_1_1;

	public GUIRegister() {
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		getContentPane().setBackground(new Color(255, 255, 255));
		setTitle("Registro de usuario");
		setBounds(700, 300, 347, 443);
		getContentPane().setLayout(null);
		getContentPane().add(getLTitleUser());
		getContentPane().add(getLTextAddUser());
		getContentPane().add(getTAddUser());
		getContentPane().add(getLNewPass());
		getContentPane().add(getJNewPassword());
		getContentPane().add(getSeparator_1());
		getContentPane().add(getLTypeUser());
		getContentPane().add(getCXTypeUser());
		getContentPane().add(getLState());
		getContentPane().add(getCxState());
		getContentPane().add(getBtnNewRegister());
		getContentPane().add(getSeparator_1_1());

		setVisible(true);
	}

	public JLabel getLTitleUser() {
		if (lTitleUser == null) {
			lTitleUser = new JLabel("  Crear usuario");
			lTitleUser.setIcon(new ImageIcon(GUIRegister.class.getResource("/images/User Add 48x48.png")));
			lTitleUser.setHorizontalAlignment(SwingConstants.LEFT);
			lTitleUser.setFont(new Font("Roboto", Font.BOLD, 18));
			lTitleUser.setBounds(10, 10, 200, 40);
		}
		return lTitleUser;
	}
	public JLabel getLTextAddUser() {
		if (lTextAddUser == null) {
			lTextAddUser = new JLabel("Ingresar nombre de usuario");
			lTextAddUser.setFont(new Font("Roboto Light", Font.BOLD, 15));
			lTextAddUser.setBounds(10, 80, 206, 20);
		}
		return lTextAddUser;
	}
	public JTextField getTAddUser() {
		if (tAddUser == null) {
			tAddUser = new JTextField();
			tAddUser.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if(tAddUser.getText().equals("Crear nuevo usuario")) {
						tAddUser.setText("");
						tAddUser.setForeground(Color.black);
					}
					if(String.valueOf(jNewPassword.getPassword()).isEmpty()) {
						jNewPassword.setText("******");
						jNewPassword.setForeground(Color.gray);
					}
				}
			});
			tAddUser.setText("Crear nuevo usuario");
			tAddUser.setForeground(Color.LIGHT_GRAY);
			tAddUser.setFont(new Font("Tahoma", Font.PLAIN, 14));
			tAddUser.setColumns(10);
			tAddUser.setBorder(null);
			tAddUser.setBounds(10, 105, 310, 25);
		}
		return tAddUser;
	}
	public JLabel getLNewPass() {
		if (lNewPass == null) {
			lNewPass = new JLabel("Nueva contraseña");
			lNewPass.setFont(new Font("Roboto Light", Font.BOLD, 15));
			lNewPass.setBounds(10, 160, 206, 20);
		}
		return lNewPass;
	}
	public JPasswordField getJNewPassword() {
		if (jNewPassword == null) {
			jNewPassword = new JPasswordField();
			jNewPassword.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if(String.valueOf(jNewPassword.getPassword()).equals("******")) {
						jNewPassword.setText("");
						jNewPassword.setForeground(Color.black);
					}
					if(tAddUser.getText().isEmpty()) {
						tAddUser.setText("Crear nuevo usuario");
						tAddUser.setForeground(Color.gray);
					}
				}
			});
			jNewPassword.setText("******");
			jNewPassword.setForeground(Color.LIGHT_GRAY);
			jNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
			jNewPassword.setBorder(null);
			jNewPassword.setBounds(10, 180, 310, 25);
		}
		return jNewPassword;
	}
	public JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
			separator_1.setForeground(Color.BLACK);
			separator_1.setBounds(10, 208, 310, 1);
		}
		return separator_1;
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
			CXTypeUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			CXTypeUser.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar:", "Administrador", "Colaborador"}));
			CXTypeUser.setRequestFocusEnabled(false);
			CXTypeUser.setName("");
			CXTypeUser.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 13));
			CXTypeUser.setBorder(null);
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
	public JComboBox getCxState() {
		if (cxState == null) {
			cxState = new JComboBox();
			cxState.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			cxState.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar:", "Activo", "Inactivo"}));
			cxState.setRequestFocusEnabled(false);
			cxState.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 13));
			cxState.setBounds(10, 320, 100, 20);
		}
		return cxState;
	}
	public JButton getBtnNewRegister() {
		if (btnNewRegister == null) {
			btnNewRegister = new JButton("Registrar");
			btnNewRegister.setBorder(null);
			btnNewRegister.setForeground(new Color(0, 0, 51));
			btnNewRegister.setHorizontalTextPosition(SwingConstants.RIGHT);
			btnNewRegister.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnNewRegister.setContentAreaFilled(false);
			btnNewRegister.setFont(new Font("Roboto Light", Font.BOLD, 14));
			btnNewRegister.setBounds(235, 379, 100, 25);
		}
		return btnNewRegister;
	}
	public JSeparator getSeparator_1_1() {
		if (separator_1_1 == null) {
			separator_1_1 = new JSeparator();
			separator_1_1.setForeground(Color.BLACK);
			separator_1_1.setBounds(10, 130, 310, 1);
		}
		return separator_1_1;
	}
	
	public void cleanForm() {
		tAddUser.setText("Crear nuevo usuario");
		jNewPassword.setText("******");
		CXTypeUser.setSelectedIndex(0);
		cxState.setSelectedIndex(0);
		
	}
}
