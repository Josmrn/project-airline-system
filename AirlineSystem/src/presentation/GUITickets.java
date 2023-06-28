package presentation;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.Cursor;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;



@SuppressWarnings("serial")
public class GUITickets extends JInternalFrame {
	private JLabel lTicketsManag;
	private JLabel lTicketNumber;
	private JTextField tTicketNumber;
	private JLabel lPassportNumber;
	private JLabel lOperationTickets;
	private JButton btnRemoveTickets;
	private JButton btnEditTickets;
	private JButton btnConsultTickets;
	private JButton btnAddTickets;
	private DefaultTableModel dtmTTickets;
	private JTable tTickets;
	private JScrollPane spTTickets;
	private Object dataTableT[][];
	private JSeparator separator_1;
	private JTextField tSearchTickets;
	private JTextField tPassportNumber;
	private JLabel lFlightNumber;
	private JTextField tFlightNumber;

	
	public GUITickets(String userType) {
		getContentPane().setBackground(new Color(255, 255, 255));
		setTitle("Gestión de Tickets");
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 1017, 639);
		getContentPane().setLayout(null);
		getContentPane().add(getLTicketsManag());
		getContentPane().add(getLTicketNumber());
		getContentPane().add(getTTicketNumber());
		getContentPane().add(getLPassportNumber());
		getContentPane().add(getLOperationTickets());
		getContentPane().add(getBtnRemoveTickets(userType));
		getContentPane().add(getBtnEditTickets(userType));
		getContentPane().add(getBtnConsultTickets());
		getContentPane().add(getBtnAddTickets());
		getContentPane().add(getSeparator_1());
		getContentPane().add(getTSearchTickets());
		getContentPane().add(getTPassportNumber());
		getContentPane().add(getLFlightNumber());
		getContentPane().add(getTFlightNumber());
		setDTMTTickets(dataTableT, getColumnsNamesM());
		setTTickets(dtmTTickets);
		setSPTTickets(tTickets);
		getContentPane().add(spTTickets);
		setVisible(true);
	}
	public JLabel getLTicketsManag() {
		if (lTicketsManag == null) {
			lTicketsManag = new JLabel("Bienvenidos a la Gestión de Tickets");
			lTicketsManag.setBackground(new Color(255, 255, 255));
			lTicketsManag.setBounds(10, 10, 975, 40);
			lTicketsManag.setHorizontalAlignment(SwingConstants.CENTER);
			lTicketsManag.setFont(new Font("Roboto Black", Font.PLAIN, 18));
			lTicketsManag.setBorder(new LineBorder(new Color(0, 0, 0)));
		}
		return lTicketsManag;
	}
	public JLabel getLTicketNumber() {
		if (lTicketNumber == null) {
			lTicketNumber = new JLabel("Numero de Ticket");
			lTicketNumber.setBounds(10, 172, 150, 25);
			lTicketNumber.setFont(new Font("Segoe UI", Font.PLAIN, 15));

		}
		return lTicketNumber;
	}
	public JTextField getTTicketNumber() {
		if (tTicketNumber == null) {
			tTicketNumber = new JTextField();
			tTicketNumber.setBounds(10, 200, 300, 25);
			tTicketNumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
			tTicketNumber.setColumns(10);
			tTicketNumber.setBorder(new LineBorder(new Color(0, 0, 0)));
		}
		return tTicketNumber;
	}
	public JLabel getLPassportNumber() {
		if (lPassportNumber == null) {
			lPassportNumber = new JLabel("Numero de Pasaporte");
			lPassportNumber.setBounds(341, 172, 150, 25);
			lPassportNumber.setFont(new Font("Segoe UI", Font.PLAIN, 15));

		}
		return lPassportNumber;
	}
	public JLabel getLOperationTickets() {
		if (lOperationTickets == null) {
			lOperationTickets = new JLabel("Operaciones");
			lOperationTickets.setBounds(10, 75, 975, 25);
			lOperationTickets.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			lOperationTickets.setFont(new Font("Segoe UI", Font.BOLD, 15));
		}
		return lOperationTickets;
	}
	public JButton getBtnRemoveTickets(String userType) {
		if (btnRemoveTickets == null) {
			
			if(userType.equals("Administrador")) {

				btnRemoveTickets = new JButton("Eliminar");
				btnRemoveTickets.setBounds(220, 110, 90, 35);
				btnRemoveTickets.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btnRemoveTickets.setIcon(new ImageIcon(GUITickets.class.getResource("/images/icons_remove.png")));
				btnRemoveTickets.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnRemoveTickets.setOpaque(false);
				btnRemoveTickets.setForeground(new Color(0, 0, 128));
				btnRemoveTickets.setFont(new Font("Segoe UI", Font.BOLD, 15));
				btnRemoveTickets.setContentAreaFilled(false);
				btnRemoveTickets.setBorder(null);
			}else if(userType.equals("Colaborador")) {

				btnRemoveTickets = new JButton("Eliminar");
				btnRemoveTickets.setBounds(220, 110, 90, 35);
				btnRemoveTickets.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btnRemoveTickets.setIcon(new ImageIcon(GUITickets.class.getResource("/images/icons_remove.png")));
				btnRemoveTickets.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnRemoveTickets.setOpaque(false);
				btnRemoveTickets.setForeground(new Color(0, 0, 128));
				btnRemoveTickets.setFont(new Font("Segoe UI", Font.BOLD, 15));
				btnRemoveTickets.setContentAreaFilled(false);
				btnRemoveTickets.setBorder(null);
				btnRemoveTickets.setVisible(false);
			}
			
		}
		return btnRemoveTickets;
	}
	public JButton getBtnEditTickets(String userType) {
		if (btnEditTickets == null) {
			if(userType.equals("Administrador")) {
				btnEditTickets = new JButton("Editar");
				btnEditTickets.setBounds(10, 110, 80, 35);
				btnEditTickets.setIcon(new ImageIcon(GUITickets.class.getResource("/images/icons_edit.png")));
				btnEditTickets.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnEditTickets.setOpaque(false);
				btnEditTickets.setForeground(new Color(0, 0, 128));
				btnEditTickets.setFont(new Font("Segoe UI", Font.BOLD, 15));
				btnEditTickets.setContentAreaFilled(false);
				btnEditTickets.setBorder(null);
			}else if(userType.equals("Colaborador")) {
				btnEditTickets = new JButton("Editar");
				btnEditTickets.setBounds(10, 110, 80, 35);
				btnEditTickets.setIcon(new ImageIcon(GUITickets.class.getResource("/images/icons_edit.png")));
				btnEditTickets.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnEditTickets.setOpaque(false);
				btnEditTickets.setForeground(new Color(0, 0, 128));
				btnEditTickets.setFont(new Font("Segoe UI", Font.BOLD, 15));
				btnEditTickets.setContentAreaFilled(false);
				btnEditTickets.setBorder(null);
				btnEditTickets.setVisible(false);
			}
		}
		return btnEditTickets;
	}
	public JButton getBtnConsultTickets() {
		if (btnConsultTickets == null) {
			btnConsultTickets = new JButton("Consultar");
			btnConsultTickets.setBounds(865, 110, 120, 35);
			btnConsultTickets.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnConsultTickets.setHorizontalAlignment(SwingConstants.LEFT);
			btnConsultTickets.setIcon(new ImageIcon(GUITickets.class.getResource("/images/icons_consult.png")));
			btnConsultTickets.setOpaque(false);
			btnConsultTickets.setForeground(new Color(0, 0, 128));
			btnConsultTickets.setFont(new Font("Segoe UI", Font.BOLD, 15));
			btnConsultTickets.setContentAreaFilled(false);
			btnConsultTickets.setBorder(null);
		}
		return btnConsultTickets;
	}
	public JButton getBtnAddTickets() {
		if (btnAddTickets == null) {
			btnAddTickets = new JButton("Agregar");
			btnAddTickets.setBounds(388, 110, 124, 35);
			btnAddTickets.setIcon(new ImageIcon(GUITickets.class.getResource("/images/icons_add.png")));
			btnAddTickets.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnAddTickets.setOpaque(false);
			btnAddTickets.setHorizontalAlignment(SwingConstants.LEADING);
			btnAddTickets.setForeground(new Color(0, 0, 128));
			btnAddTickets.setFont(new Font("Segoe UI", Font.BOLD, 16));
			btnAddTickets.setContentAreaFilled(false);
			btnAddTickets.setBorder(null);
		}
		return btnAddTickets;
	}
	public void setDTMTTickets(Object data[][], String[] columnsNamesM) {
		dtmTTickets = new DefaultTableModel(data, columnsNamesM);
	}
	public DefaultTableModel getDTMTTickets() {
		return dtmTTickets;
	}
	public void setTTickets(DefaultTableModel dtmtTickets) {
		tTickets = new JTable(dtmTTickets);
		tTickets.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("unchecked")
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int selectedRow = tTickets.getSelectedRow(); //Variable que va a obtener lo que se encuentra en tUsers
	            DefaultTableModel model = (DefaultTableModel) tTickets.getModel(); //Me va a obtener los datos asociados a tTickets que están en la tabla
	            Vector<Object> rowData = model.getDataVector().elementAt(selectedRow); //Es el vector del objeto seleccionado en la tabla
	           //Se agregan los componentes al los campos de texto y combo box
	            tTicketNumber.setText(String.valueOf((int) rowData.get(0)));
	            tPassportNumber.setText(String.valueOf((int) rowData.get(1)));
	            tFlightNumber.setText(String.valueOf((int) rowData.get(2)));
	            
			}
		});
		tTickets.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tTickets.setEnabled(true);
		tTickets.getTableHeader().setReorderingAllowed(false);
		tTickets.getTableHeader().setResizingAllowed(false);
	}
	public JTable getTTickets() {
		return this.tTickets;
	}
	public void setSPTTickets(JTable tTickets) {
		spTTickets = new JScrollPane(tTickets);
		spTTickets.setBounds(10, 272, 610, 328);
		spTTickets.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Datos de tickets registrados", TitledBorder.LEFT, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		spTTickets.setFont(new Font("Tahoma", Font.PLAIN, 11));
		spTTickets.setToolTipText("");
		spTTickets.setBackground(new Color(255, 255, 255));
	}
	public JScrollPane getSPTTickets() {
		return this.spTTickets;
	}
	public String[] getColumnsNamesM() {
		String columnsName[] = {"Numero de Ticket","Numero de Pasaporte","Numero de vuelo"};
		return columnsName;
	}
	public JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
			separator_1.setBounds(10, 150, 975, 1);

		}
		return separator_1;
	}
	public JTextField getTSearchTickets() {
		if (tSearchTickets == null) {
			tSearchTickets = new JTextField();
			tSearchTickets.setBounds(555, 110, 300, 30);
			tSearchTickets.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			tSearchTickets.setForeground(new Color(192, 192, 192));
			tSearchTickets.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if(tSearchTickets.getText().equals("Escribir el ticket que desea consultar/eliminar")) {
						tSearchTickets.setText("");
						tSearchTickets.setForeground(Color.black);
					}
				}
			});
			tSearchTickets.setText("Escribir el ticket que desea consultar/eliminar");
			tSearchTickets.setFont(new Font("Tahoma", Font.PLAIN, 12));
			tSearchTickets.setColumns(10);
		}
		return tSearchTickets;
	}
	public JTextField getTPassportNumber() {
		if (tPassportNumber == null) {
			tPassportNumber = new JTextField();
			tPassportNumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
			tPassportNumber.setColumns(10);
			tPassportNumber.setBorder(new LineBorder(new Color(0, 0, 0)));
			tPassportNumber.setBounds(320, 200, 300, 25);
		
		}
		return tPassportNumber;
	}
	public JLabel getLFlightNumber() {
		if (lFlightNumber == null) {
			lFlightNumber = new JLabel("Numero de Vuelo");
			lFlightNumber.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			lFlightNumber.setBounds(633, 172, 123, 25);

		}
		return lFlightNumber;
	}
	public JTextField getTFlightNumber() {
		if (tFlightNumber == null) {
			tFlightNumber = new JTextField();
			tFlightNumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
			tFlightNumber.setColumns(10);
			tFlightNumber.setBorder(new LineBorder(new Color(0, 0, 0)));
			tFlightNumber.setBounds(630, 200, 300, 25);

		}
		return tFlightNumber;
	}
}
