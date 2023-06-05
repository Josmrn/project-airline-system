package presentation;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.SystemColor;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class GUILogin extends JFrame {

	private JPanel contentPane;
	private JLabel lUsers;
	private JLabel lPassword;
	private JTextField tUser;
	private JPasswordField jPassword;
	private JButton btnLogin;
	private JButton btnRegister;
	private JLabel lSesion;
	private JSeparator separator;
	private JSeparator separator_1;

	public GUILogin() {
		setTitle("Airline System");
		setLocationByPlatform(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 300, 452, 330);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLUsers());
		contentPane.add(getLPassword());
		contentPane.add(getTUser());
		contentPane.add(getJPassword());
		contentPane.add(getBtnLogin());
		contentPane.add(getBtnRegister());
		contentPane.add(getLSesion());
		contentPane.add(getSeparator());
		contentPane.add(getSeparator_1());
		setVisible(true);
	}
	public JLabel getLUsers() {
		if (lUsers == null) {
			lUsers = new JLabel("Usuario");
			lUsers.setBackground(new Color(0, 0, 51));
			lUsers.setForeground(new Color(0, 0, 51));
			lUsers.setHorizontalAlignment(SwingConstants.LEFT);
			lUsers.setFont(new Font("Roboto Light", Font.BOLD, 14));
			lUsers.setBounds(10, 125, 100, 20);
		}
		return lUsers;
	}
	public JLabel getLPassword() {
		if (lPassword == null) {
			lPassword = new JLabel("Contraseña");
			lPassword.setForeground(new Color(0, 0, 51));
			lPassword.setHorizontalAlignment(SwingConstants.LEFT);
			lPassword.setFont(new Font("Roboto Light", Font.BOLD, 14));
			lPassword.setBounds(10, 182, 100, 20);
		}
		return lPassword;
	}
	public JTextField getTUser() {
		if (tUser == null) {
			tUser = new JTextField();
			tUser.setBackground(new Color(255, 255, 255));
			tUser.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if(tUser.getText().equals(" Ingrese su nombre de usuario")) {
						tUser.setText("");
						tUser.setForeground(Color.black);
					}
					if(String.valueOf(jPassword.getPassword()).isEmpty()) {
						jPassword.setText("******");
						jPassword.setForeground(Color.gray);
					}
				}
			});
			tUser.setHorizontalAlignment(SwingConstants.LEFT);
			tUser.setBorder(null);
			tUser.setForeground(new Color(192, 192, 192));
			tUser.setText(" Ingrese su nombre de usuario");
			tUser.setBounds(122, 115, 255, 30);
			tUser.setColumns(10);
		}
		return tUser;
	}
	public JPasswordField getJPassword() {
		if (jPassword == null) {
			jPassword = new JPasswordField();
			jPassword.setBackground(new Color(255, 255, 255));
			jPassword.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if(String.valueOf(jPassword.getPassword()).equals("******")) {
						jPassword.setText("");
						jPassword.setForeground(Color.black);
					}
					if(tUser.getText().isEmpty()) {
						tUser.setText(" Ingrese su nombre de usuario");
						tUser.setForeground(Color.gray);
					}
				}
			});
			jPassword.setForeground(new Color(192, 192, 192));
			jPassword.setBorder(null);
			jPassword.setText("******");
			jPassword.setToolTipText("");
			jPassword.setBounds(122, 175, 255, 30);
		}
		return jPassword;
	}
	public JButton getBtnLogin() {
		if (btnLogin == null) {
			btnLogin = new JButton("Ingresar");
			btnLogin.setBorder(new EmptyBorder(0, 0, 0, 0));
			btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnLogin.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					btnLogin.setBackground(new Color(25, 80, 80));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					btnLogin.setBackground(new Color(0, 51, 51));
				}
			});
			btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnLogin.setForeground(SystemColor.menu);
			btnLogin.setBackground(new Color(0, 51, 51));
			btnLogin.setFont(new Font("Roboto", Font.BOLD, 15));
			btnLogin.setBounds(122, 247, 100, 25);
		}
		return btnLogin;
	}
	public JButton getBtnRegister() {
		if (btnRegister == null) {
			btnRegister = new JButton("Registrar");
			btnRegister.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					btnRegister.setBackground(new Color(140, 3, 13));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					btnRegister.setBackground(new Color(204, 102, 51));
				}
			});
			btnRegister.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnRegister.setBorder(new EmptyBorder(0, 0, 0, 0));
			btnRegister.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnRegister.setForeground(new Color(0, 0, 51));
			btnRegister.setBackground(new Color(204, 51, 51));
			btnRegister.setFont(new Font("Roboto", Font.BOLD, 15));
			btnRegister.setBounds(277, 247, 100, 25);
		}
		return btnRegister;
	}
	public JLabel getLSesion() {
		if (lSesion == null) {
			lSesion = new JLabel("INICIAR SESIÓN");
			lSesion.setBackground(new Color(0, 0, 51));
			lSesion.setIcon(new ImageIcon("C:\\Users\\UNA\\OneDrive\\Documentos\\Universidad\\Eclipse-Práctica\\Ui\\src\\images\\clientes_.png"));
			lSesion.setHorizontalAlignment(SwingConstants.CENTER);
			lSesion.setFont(new Font("Roboto Black", Font.BOLD, 22));
			lSesion.setForeground(new Color(0, 0, 51));
			lSesion.setBounds(55, 43, 235, 30);
		}
		return lSesion;
	}
	public JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setForeground(new Color(0, 0, 0));
			separator.setBounds(122, 148, 255, 2);
		}
		return separator;
	}
	public JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
			separator_1.setForeground(new Color(0, 0, 0));
			separator_1.setBounds(122, 205, 255, 2);
		}
		return separator_1;
	}
	
	public void cleanForm() {
		tUser.setText("Crear nuevo usuario");
		jPassword.setText("******");
		
	}
}
