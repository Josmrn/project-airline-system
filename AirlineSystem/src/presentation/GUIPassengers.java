package presentation;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


@SuppressWarnings("serial")
public class GUIPassengers extends JInternalFrame {
	private JLabel lPassengersManag;
	private JLabel lPassport;
	private JTextField tPassport;
	private JSeparator separator;
	private JLabel lName;
	private JLabel lOperationPassengers;
	private JButton btnRemovePassengers;
	private JButton btnEditPassengers;
	private JButton btnConsultPassenger;
	private JButton btnAddPassenger;
	private DefaultTableModel dtmTPassengers;
	private JTable tPassengers;
	private JScrollPane spTPassengers;
	private Object dataTableP[][];
	private JSeparator separator_1;
	private JTextField tSearchPassenger;
	private JTextField tName;
	private JSeparator separator_2;
	private JLabel lBirthDate;
	private JTextField tBirthDate;
	private JSeparator separator_2_1;
	private JLabel lEmail;
	private JTextField tEmail;
	private JSeparator separator_2_2;
	private JLabel lCellphone;
	private JTextField tCellphone;
	private JSeparator separator_2_1_1;
	private JLabel lLastName;
	private JTextField tLastName;
	private JSeparator separator_2_3;

	
	public GUIPassengers() {
		getContentPane().setBackground(new Color(255, 255, 255));
		setTitle("Gestión de Modelos");
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 1378, 639);
		getContentPane().setLayout(null);
		getContentPane().add(getLPassengersManag());
		getContentPane().add(getLPassport());
		getContentPane().add(getTPassport());
		getContentPane().add(getSeparator());
		getContentPane().add(getLName());
		getContentPane().add(getLOperationPassengers());
		getContentPane().add(getBtnRemovePassengers());
		getContentPane().add(getBtnEditPassengers());
		getContentPane().add(getBtnConsultPassenger());
		getContentPane().add(getBtnAddPassenger());
		getContentPane().add(getSeparator_1());
		getContentPane().add(getTSearchPassenger());
		getContentPane().add(getTName());
		getContentPane().add(getSeparator_2());
		getContentPane().add(getLBirthDate());
		getContentPane().add(getTBirthDate());
		getContentPane().add(getSeparator_2_1());
		getContentPane().add(getLEmail());
		getContentPane().add(getTEmail());
		getContentPane().add(getSeparator_2_2());
		getContentPane().add(getLCellphone());
		getContentPane().add(getTCellphone());
		getContentPane().add(getSeparator_2_1_1());
		getContentPane().add(getLLastName());
		getContentPane().add(getTLastName());
		getContentPane().add(getSeparator_2_3());
		setDTMTPassengers(dataTableP, getColumnsNamesM());
		setTPassengers(dtmTPassengers);
		setSPTPassengers(tPassengers);
		getContentPane().add(spTPassengers);
		setVisible(true);
	}
	public JLabel getLPassengersManag() {
		if (lPassengersManag == null) {
			lPassengersManag = new JLabel("Bienvenidos a la Gestión de Pasajeros");
			lPassengersManag.setBounds(10, 10, 975, 40);
			lPassengersManag.setHorizontalAlignment(SwingConstants.CENTER);
			lPassengersManag.setFont(new Font("Roboto Black", Font.PLAIN, 18));
			lPassengersManag.setBorder(new LineBorder(new Color(0, 0, 0)));
		}
		return lPassengersManag;
	}
	public JLabel getLPassport() {
		if (lPassport == null) {
			lPassport = new JLabel("Numero de Pasaporte");
			lPassport.setBounds(10, 155, 150, 25);
			lPassport.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return lPassport;
	}
	public JTextField getTPassport() {
		if (tPassport == null) {
			tPassport = new JTextField();
			tPassport.setBounds(10, 175, 252, 25);
			tPassport.setFont(new Font("Tahoma", Font.PLAIN, 10));
			tPassport.setColumns(10);
			tPassport.setBorder(null);
		}
		return tPassport;
	}
	public JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(10, 200, 250, 1);
		}
		return separator;
	}
	public JLabel getLName() {
		if (lName == null) {
			lName = new JLabel("Nombre/s");
			lName.setBounds(272, 155, 123, 25);
			lName.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return lName;
	}
	public JLabel getLOperationPassengers() {
		if (lOperationPassengers == null) {
			lOperationPassengers = new JLabel("Operaciones");
			lOperationPassengers.setBounds(10, 75, 975, 25);
			lOperationPassengers.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			lOperationPassengers.setFont(new Font("Segoe UI", Font.BOLD, 15));
		}
		return lOperationPassengers;
	}
	public JButton getBtnRemovePassengers() {
		if (btnRemovePassengers == null) {
			btnRemovePassengers = new JButton("Eliminar");
			btnRemovePassengers.setBounds(220, 110, 90, 35);
			btnRemovePassengers.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnRemovePassengers.setIcon(new ImageIcon(GUIPassengers.class.getResource("/images/icons_remove.png")));
			btnRemovePassengers.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnRemovePassengers.setOpaque(false);
			btnRemovePassengers.setForeground(new Color(0, 0, 128));
			btnRemovePassengers.setFont(new Font("Segoe UI", Font.BOLD, 15));
			btnRemovePassengers.setContentAreaFilled(false);
			btnRemovePassengers.setBorder(null);
		}
		return btnRemovePassengers;
	}
	public JButton getBtnEditPassengers() {
		if (btnEditPassengers == null) {
			btnEditPassengers = new JButton("Editar");
			btnEditPassengers.setBounds(10, 110, 80, 35);
			btnEditPassengers.setIcon(new ImageIcon(GUIPassengers.class.getResource("/images/icons_edit.png")));
			btnEditPassengers.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnEditPassengers.setOpaque(false);
			btnEditPassengers.setForeground(new Color(0, 0, 128));
			btnEditPassengers.setFont(new Font("Segoe UI", Font.BOLD, 15));
			btnEditPassengers.setContentAreaFilled(false);
			btnEditPassengers.setBorder(null);
		}
		return btnEditPassengers;
	}
	public JButton getBtnConsultPassenger() {
		if (btnConsultPassenger == null) {
			btnConsultPassenger = new JButton("Consultar");
			btnConsultPassenger.setBounds(865, 110, 120, 35);
			btnConsultPassenger.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnConsultPassenger.setHorizontalAlignment(SwingConstants.LEFT);
			btnConsultPassenger.setIcon(new ImageIcon(GUIPassengers.class.getResource("/images/icons_consult.png")));
			btnConsultPassenger.setOpaque(false);
			btnConsultPassenger.setForeground(new Color(0, 0, 128));
			btnConsultPassenger.setFont(new Font("Segoe UI", Font.BOLD, 15));
			btnConsultPassenger.setContentAreaFilled(false);
			btnConsultPassenger.setBorder(null);
		}
		return btnConsultPassenger;
	}
	public JButton getBtnAddPassenger() {
		if (btnAddPassenger == null) {
			btnAddPassenger = new JButton("Agregar");
			btnAddPassenger.setBounds(397, 110, 110, 35);
			btnAddPassenger.setIcon(new ImageIcon(GUIPassengers.class.getResource("/images/icons_add.png")));
			btnAddPassenger.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnAddPassenger.setOpaque(false);
			btnAddPassenger.setHorizontalAlignment(SwingConstants.LEADING);
			btnAddPassenger.setForeground(new Color(0, 0, 128));
			btnAddPassenger.setFont(new Font("Segoe UI", Font.BOLD, 16));
			btnAddPassenger.setContentAreaFilled(false);
			btnAddPassenger.setBorder(null);
		}
		return btnAddPassenger;
	}
	public void setDTMTPassengers(Object data[][], String[] columnsNamesM) {
		dtmTPassengers = new DefaultTableModel(data, columnsNamesM);
	}
	public DefaultTableModel getDTMTPassengers() {
		return dtmTPassengers;
	}
	public void setTPassengers(DefaultTableModel dtmtPassengers) {
		tPassengers = new JTable(dtmTPassengers);
		tPassengers.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("unchecked")
			@Override
			//Método para poder seleccionar datos en la tabla y ser mostrados en los campos respectivos 
			public void mouseClicked(MouseEvent e) {
								
				int selectedRow = tPassengers.getSelectedRow(); //Variable que va a obtener lo que se encuentra en tPassengers
	            DefaultTableModel model = (DefaultTableModel) tPassengers.getModel(); //Me va a obtener los datos asociados a tUsers que están en la tabla
	            Vector<Object> rowData = model.getDataVector().elementAt(selectedRow); //Es el vector del objeto seleccionado en la tabla
	           //Se agregan los componentes al los campos de texto
	            tPassport.setText(String.valueOf((int) rowData.get(0)));
	            tName.setText((String) rowData.get(1));
	            tLastName.setText((String) rowData.get(2));
	            tBirthDate.setText((String) rowData.get(3));
	            tEmail.setText((String) rowData.get(4));
	            tCellphone.setText(String.valueOf((int) rowData.get(5)));
	         
			}
		});
		tPassengers.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tPassengers.setEnabled(true);
		tPassengers.getTableHeader().setReorderingAllowed(false);
		tPassengers.getTableHeader().setResizingAllowed(false);
	}
	public JTable getTPassengers() {
		return this.tPassengers;
	}
	public void setSPTPassengers(JTable tPassengers) {
		spTPassengers = new JScrollPane(tPassengers);
		spTPassengers.setBounds(10, 243, 1312, 355);
		spTPassengers.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Datos de pasajeros registrados", TitledBorder.LEFT, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		spTPassengers.setFont(new Font("Tahoma", Font.PLAIN, 11));
		spTPassengers.setToolTipText("");
		spTPassengers.setBackground(new Color(255, 255, 255));
	}
	public JScrollPane getSPTPassengers() {
		return this.spTPassengers;
	}
	public String[] getColumnsNamesM() {
		String columnsName[] = {"Numero de Pasaporte","Nombre/s","Apellido/s","Fecha de Nacimiento","Correo Electronico","Numero Celular"};
		return columnsName;
	}
	public JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
			separator_1.setBounds(10, 150, 975, 1);

		}
		return separator_1;
	}
	public JTextField getTSearchPassenger() {
		if (tSearchPassenger == null) {
			tSearchPassenger = new JTextField();
			tSearchPassenger.setBounds(555, 115, 300, 30);
			tSearchPassenger.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			tSearchPassenger.setForeground(new Color(192, 192, 192));
			tSearchPassenger.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if(tSearchPassenger.getText().equals("Escribir el pasajero que desea consultar/eliminar")) {
						tSearchPassenger.setText("");
						tSearchPassenger.setForeground(Color.black);
					}
				}
			});
			tSearchPassenger.setText("Escribir el pasajero que desea consultar/eliminar");
			tSearchPassenger.setFont(new Font("Tahoma", Font.PLAIN, 12));
			tSearchPassenger.setColumns(10);
		}
		return tSearchPassenger;
	}
	public JTextField getTName() {
		if (tName == null) {
			tName = new JTextField();
			tName.setFont(new Font("Tahoma", Font.PLAIN, 10));
			tName.setColumns(10);
			tName.setBorder(null);
			tName.setBounds(272, 175, 123, 25);
		}
		return tName;
	}
	public JSeparator getSeparator_2() {
		if (separator_2 == null) {
			separator_2 = new JSeparator();
			separator_2.setBounds(272, 200, 123, 1);
		}
		return separator_2;
	}
	public JLabel getLBirthDate() {
		if (lBirthDate == null) {
			lBirthDate = new JLabel("Fecha de Nacimiento");
			lBirthDate.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			lBirthDate.setBounds(534, 155, 252, 25);
		}
		return lBirthDate;
	}
	public JTextField getTBirthDate() {
		if (tBirthDate == null) {
			tBirthDate = new JTextField();
			tBirthDate.setFont(new Font("Tahoma", Font.PLAIN, 10));
			tBirthDate.setColumns(10);
			tBirthDate.setBorder(null);
			tBirthDate.setBounds(534, 175, 252, 25);
		}
		return tBirthDate;
	}
	public JSeparator getSeparator_2_1() {
		if (separator_2_1 == null) {
			separator_2_1 = new JSeparator();
			separator_2_1.setBounds(534, 200, 252, 1);
		}
		return separator_2_1;
	}
	public JLabel getLEmail() {
		if (lEmail == null) {
			lEmail = new JLabel("Correo Electronico");
			lEmail.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			lEmail.setBounds(808, 155, 123, 25);
		}
		return lEmail;
	}
	public JTextField getTEmail() {
		if (tEmail == null) {
			tEmail = new JTextField();
			tEmail.setFont(new Font("Tahoma", Font.PLAIN, 10));
			tEmail.setColumns(10);
			tEmail.setBorder(null);
			tEmail.setBounds(808, 179, 252, 25);
		}
		return tEmail;
	}
	public JSeparator getSeparator_2_2() {
		if (separator_2_2 == null) {
			separator_2_2 = new JSeparator();
			separator_2_2.setBounds(808, 204, 250, 1);
		}
		return separator_2_2;
	}
	public JLabel getLCellphone() {
		if (lCellphone == null) {
			lCellphone = new JLabel("Numero celular");
			lCellphone.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			lCellphone.setBounds(1070, 155, 110, 25);
		}
		return lCellphone;
	}
	public JTextField getTCellphone() {
		if (tCellphone == null) {
			tCellphone = new JTextField();
			tCellphone.setFont(new Font("Tahoma", Font.PLAIN, 10));
			tCellphone.setColumns(10);
			tCellphone.setBorder(null);
			tCellphone.setBounds(1070, 179, 252, 25);
		}
		return tCellphone;
	}
	public JSeparator getSeparator_2_1_1() {
		if (separator_2_1_1 == null) {
			separator_2_1_1 = new JSeparator();
			separator_2_1_1.setBounds(1070, 204, 250, 1);
		}
		return separator_2_1_1;
	}
	public JLabel getLLastName() {
		if (lLastName == null) {
			lLastName = new JLabel("Apellido/s");
			lLastName.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			lLastName.setBounds(397, 155, 123, 25);
		}
		return lLastName;
	}
	public JTextField getTLastName() {
		if (tLastName == null) {
			tLastName = new JTextField();
			tLastName.setFont(new Font("Tahoma", Font.PLAIN, 10));
			tLastName.setColumns(10);
			tLastName.setBorder(null);
			tLastName.setBounds(397, 175, 123, 25);
		}
		return tLastName;
	}
	public JSeparator getSeparator_2_3() {
		if (separator_2_3 == null) {
			separator_2_3 = new JSeparator();
			separator_2_3.setBounds(397, 200, 123, 1);
		}
		return separator_2_3;
	}
}

