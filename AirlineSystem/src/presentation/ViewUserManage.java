package presentation;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import java.awt.Cursor;

@SuppressWarnings("serial")
public class ViewUserManage extends JFrame {

	private JPanel contentPane;
	private JLabel lWelcomeUserManage;
	private JButton btnConsultUser;
	private JButton btnEditUsers;
	private JButton btnRemoveUser;
	private JButton btnReadUsers;
	private JButton btnRegister;
	private JSeparator separator;
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
	private JLabel lUser_1;
	private JTextField tUserAdd;
	private JLabel lOperationUser;
	private JTextField tWriteName;
	private JLabel lPassword;
	
	private DefaultTableModel dtmTUsers;
	private JTable tUsers;
	private Object dataTable[][];
	private JScrollPane spTUsers;

	public ViewUserManage() {
		
		setTitle("Airline Software");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 860, 703);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLWelcomeUserManage());
		contentPane.add(getBtnConsultUser());
		contentPane.add(getBtnEditUsers());
		contentPane.add(getBtnRemoveUser());
		contentPane.add(getBtnReadUsers());
		contentPane.add(getBtnRegister());
		contentPane.add(getSeparator());
		contentPane.add(getLUser());
		contentPane.add(getLNewPass());
		contentPane.add(getJPassword());
		contentPane.add(getSeparator_1());
		contentPane.add(getLTypeUser());
		contentPane.add(getCXTypeUser());
		contentPane.add(getLState());
		contentPane.add(getCxState());
		contentPane.add(getLUser_1());
		contentPane.add(getTUserAdd());
		contentPane.add(getLOperationUser());
		contentPane.add(getTWriteName());
		contentPane.add(getLPassword());
		
		setDTMTUsers(dataTable, getColumnsNames());
		setTUsers(dtmTUsers);
		setSPTUsers(tUsers);
		getContentPane().add(spTUsers);
		
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
			lWelcomeUserManage.setBounds(12, 10, 828, 40);
		}
		return lWelcomeUserManage;
	}
	public JButton getBtnConsultUser() {
		if (btnConsultUser == null) {
			btnConsultUser = new JButton("Consultar");
			btnConsultUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnConsultUser.setContentAreaFilled(false);
			btnConsultUser.setIcon(new ImageIcon(ViewUserManage.class.getResource("/images/icons_consult.png")));
			btnConsultUser.setOpaque(false);
			btnConsultUser.setForeground(new Color(0, 0, 128));
			btnConsultUser.setFont(new Font("Segoe UI", Font.BOLD, 15));
			btnConsultUser.setBorder(null);
			btnConsultUser.setBounds(730, 372, 110, 35);
		}
		return btnConsultUser;
	}
	public JButton getBtnEditUsers() {
		if (btnEditUsers == null) {
			btnEditUsers = new JButton("Editar");
			btnEditUsers.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnEditUsers.setIcon(new ImageIcon(ViewUserManage.class.getResource("/images/icons_edit.png")));
			btnEditUsers.setOpaque(false);
			btnEditUsers.setForeground(new Color(0, 0, 128));
			btnEditUsers.setFont(new Font("Segoe UI", Font.BOLD, 15));
			btnEditUsers.setContentAreaFilled(false);
			btnEditUsers.setBorder(null);
			btnEditUsers.setBounds(564, 109, 106, 25);
		}
		return btnEditUsers;
	}
	public JButton getBtnRemoveUser() {
		if (btnRemoveUser == null) {
			btnRemoveUser = new JButton("Eliminar");
			btnRemoveUser.setIcon(new ImageIcon(ViewUserManage.class.getResource("/images/icons_remove.png")));
			btnRemoveUser.setOpaque(false);
			btnRemoveUser.setForeground(new Color(0, 0, 128));
			btnRemoveUser.setFont(new Font("Segoe UI", Font.BOLD, 15));
			btnRemoveUser.setContentAreaFilled(false);
			btnRemoveUser.setBorder(null);
			btnRemoveUser.setBounds(750, 109, 90, 25);
		}
		return btnRemoveUser;
	}
	public JButton getBtnReadUsers() {
		if (btnReadUsers == null) {
			btnReadUsers = new JButton("Mostrar");
			btnReadUsers.setIcon(new ImageIcon(ViewUserManage.class.getResource("/images/icons_show.png")));
			btnReadUsers.setOpaque(false);
			btnReadUsers.setForeground(new Color(0, 0, 128));
			btnReadUsers.setFont(new Font("Segoe UI", Font.BOLD, 15));
			btnReadUsers.setContentAreaFilled(false);
			btnReadUsers.setBorder(null);
			btnReadUsers.setBounds(317, 372, 95, 35);
		}
		return btnReadUsers;
	}
	public JButton getBtnRegister() {
		if (btnRegister == null) {
			btnRegister = new JButton("Registrar");
			btnRegister.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnRegister.setIcon(new ImageIcon(ViewUserManage.class.getResource("/images/icons_add.png")));
			btnRegister.setForeground(new Color(0, 0, 128));
			btnRegister.setFont(new Font("Segoe UI", Font.BOLD, 15));
			btnRegister.setContentAreaFilled(false);
			btnRegister.setBorder(null);
			btnRegister.setBounds(381, 110, 105, 25);
		}
		return btnRegister;
	}
	
	public JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setForeground(Color.BLACK);
			separator.setBounds(12, 138, 288, 1);
		}
		return separator;
	}
	public JLabel getLUser() {
		if (lUser == null) {
			lUser = new JLabel("Usuario");
			lUser.setHorizontalAlignment(SwingConstants.CENTER);
			lUser.setFont(new Font("Dialog", Font.BOLD, 15));
			lUser.setBorder(null);
			lUser.setBackground(Color.WHITE);
			lUser.setBounds(12, 62, 64, 38);
		}
		return lUser;
	}
	public JLabel getLNewPass() {
		if (lNewPass == null) {
			lNewPass = new JLabel("Contraseña");
			lNewPass.setFont(new Font("Dialog", Font.BOLD, 15));
			lNewPass.setBounds(12, 170, 206, 20);
		}
		return lNewPass;
	}
	public JPasswordField getJPassword() {
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
			jPassword.setBounds(45, 202, 252, 25);
		}
		return jPassword;
	}
	public JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
			separator_1.setForeground(Color.BLACK);
			separator_1.setBounds(12, 230, 288, 1);
		}
		return separator_1;
	}
	public JLabel getLTypeUser() {
		if (lTypeUser == null) {
			lTypeUser = new JLabel("Tipo de usuario");
			lTypeUser.setFont(new Font("Dialog", Font.BOLD, 15));
			lTypeUser.setBounds(12, 256, 206, 20);
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
			CXTypeUser.setBounds(12, 285, 123, 25);
		}
		return CXTypeUser;
	}
	public JLabel getLState() {
		if (lState == null) {
			lState = new JLabel("Estado");
			lState.setFont(new Font("Dialog", Font.BOLD, 15));
			lState.setBounds(12, 320, 206, 20);
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
			cxState.setBounds(12, 348, 100, 25);
		}
		return cxState;
	}
	public JLabel getLUser_1() {
		if (lUser_1 == null) {
			lUser_1 = new JLabel("");
			lUser_1.setIcon(new ImageIcon(ViewUserManage.class.getResource("/images/user.png")));
			lUser_1.setRequestFocusEnabled(false);
			lUser_1.setHorizontalAlignment(SwingConstants.CENTER);
			lUser_1.setForeground(new Color(30, 144, 255));
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
			tUserAdd.setBounds(54, 110, 245, 25);
		}
		return tUserAdd;
	}
	public JLabel getLOperationUser() {
		if (lOperationUser == null) {
			lOperationUser = new JLabel("Operaciones");
			lOperationUser.setFont(new Font("Segoe UI", Font.BOLD, 15));
			lOperationUser.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			lOperationUser.setBounds(381, 69, 459, 25);
		}
		return lOperationUser;
	}
	public JTextField getTWriteName() {
		if (tWriteName == null) {
			tWriteName = new JTextField();
			tWriteName.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
					if(tWriteName.getText().equals("Escribir el nombre usuario que desea consultar/mostrar")) {
						tWriteName.setText("");
						tWriteName.setForeground(Color.black);
					}
				}
			});
			tWriteName.setText("Escribir el nombre usuario que desea consultar/mostrar");
			tWriteName.setForeground(Color.LIGHT_GRAY);
			tWriteName.setFont(new Font("Tahoma", Font.PLAIN, 12));
			tWriteName.setColumns(10);
			tWriteName.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			tWriteName.setBounds(417, 372, 310, 30);
		}
		return tWriteName;
	}
	public JLabel getLPassword() {
		if (lPassword == null) {
			lPassword = new JLabel("");
			lPassword.setIcon(new ImageIcon("C:\\Users\\UNA\\Downloads\\icons8-bloquear-26.png"));
			lPassword.setRequestFocusEnabled(false);
			lPassword.setHorizontalAlignment(SwingConstants.CENTER);
			lPassword.setForeground(new Color(30, 144, 255));
			lPassword.setFont(new Font("Dialog", Font.BOLD, 15));
			lPassword.setBorder(null);
			lPassword.setBackground(Color.WHITE);
			lPassword.setBounds(8, 200, 26, 30);
		}
		return lPassword;
	}
	//----------------------------------------------------------------------------------------------------------------------
	public void setDTMTUsers(Object data[][], String [] columnsNames) {
		dtmTUsers = new DefaultTableModel(data, columnsNames);
		
	}
	public DefaultTableModel getDTMTUsers() {
		return dtmTUsers;
	}
	
	public void setTUsers(DefaultTableModel dtmTUsers) {
		tUsers = new JTable(dtmTUsers);
		tUsers.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("unchecked")
			@Override
			//Método para poder seleccionar datos en la tabla y ser mostrados en los campos respectivos 
			public void mouseClicked(MouseEvent e) {
				
				int index = 0;
				
				int selectedRow = tUsers.getSelectedRow(); //Variable que va a obtener lo que se encuentra en tUsers
	            DefaultTableModel model = (DefaultTableModel) tUsers.getModel(); //Me va a obtener los datos asociados a tUsers que están en la tabla
	            Vector<Object> rowData = model.getDataVector().elementAt(selectedRow); //Es el vector del objeto seleccionado en la tabla
	           //Se agregan los componentes al los campos de texto y combo box
	            tUserAdd.setText((String) rowData.get(0));
	            jPassword.setText((String) rowData.get(1));
	         
	            index = (rowData.get(2).equals("Administrador")) ? 0 : 1 ;
	            CXTypeUser.setSelectedIndex(index);
	            
	            index = (rowData.get(3).equals("Activo")) ? 0 : 1 ;
	            cxState.setSelectedIndex(index);
			}
		});
		tUsers.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tUsers.setEnabled(true);
		tUsers.getTableHeader().setReorderingAllowed(false);
		tUsers.getTableHeader().setResizingAllowed(false);
	}
	public JTable getTUsers() {
		return this.tUsers;
	}
	
	public void setSPTUsers(JTable tUsers) {
		spTUsers = new JScrollPane(tUsers);
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
	public void cleanForm() {
		tUserAdd.setText("Escribir usuario");
		jPassword.setText("******");
		CXTypeUser.setSelectedIndex(0);
		cxState.setSelectedIndex(0);
		
	}
}
