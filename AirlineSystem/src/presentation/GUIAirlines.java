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
public class GUIAirlines extends JInternalFrame {
	private JLabel lAirlineManag;
	private JLabel lName;
	private JTextField tWriteAirlines;
	private JLabel lOpeCenter;
	private JLabel lOperationAirlines;
	private JButton btnRemoveAirlines;
	private JButton btnEditAirlines;
	private JButton btnConsultAirlines;
	private JButton btnAddAirlines;
	private DefaultTableModel dtmTAirlines;
	private JTable tAirlines;
	private JScrollPane spTAirlines;
	private Object dataTableM[][];
	private JSeparator separator_1;
	private JTextField tSearchAirline;
	private JTextField tOpeCenter;

	
	public GUIAirlines(String userType) {
		getContentPane().setBackground(new Color(255, 255, 255));
		setTitle("Gestión de Aerolineas");
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 1010, 535);
		getContentPane().setLayout(null);
		getContentPane().add(getLAirlineManag());
		getContentPane().add(getLName());
		getContentPane().add(getTWriteAirlines());
		getContentPane().add(getLOpeCenter());
		getContentPane().add(getLOperationAirlines());
		getContentPane().add(getBtnRemoveAirlines(userType));
		getContentPane().add(getBtnEditAirlines(userType));
		getContentPane().add(getBtnConsultAirlines());
		getContentPane().add(getBtnAddAirlines());
		getContentPane().add(getSeparator_1());
		getContentPane().add(getTSearchAirline());
		getContentPane().add(getTOpeCenter());
		setDTMTAirlines(dataTableM, getColumnsNamesM());
		setTAirlines(dtmTAirlines);
		setSPTAirlines(tAirlines);
		getContentPane().add(spTAirlines);
		setVisible(true);
	}
	public JLabel getLAirlineManag() {
		if (lAirlineManag == null) {
			lAirlineManag = new JLabel("Bienvenidos a la Gestión de Aerolineas");
			lAirlineManag.setHorizontalAlignment(SwingConstants.CENTER);
			lAirlineManag.setFont(new Font("Roboto Black", Font.PLAIN, 18));
			lAirlineManag.setBorder(new LineBorder(new Color(0, 0, 0)));
			lAirlineManag.setBounds(10, 10, 975, 40);
		}
		return lAirlineManag;
	}
	public JLabel getLName() {
		if (lName == null) {
			lName = new JLabel("Nombre de Aerolinea");
			lName.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			lName.setBounds(10, 155, 150, 25);
		}
		return lName;
	}
	public JTextField getTWriteAirlines() {
		if (tWriteAirlines == null) {
			tWriteAirlines = new JTextField();
			tWriteAirlines.setFont(new Font("Tahoma", Font.PLAIN, 10));
			tWriteAirlines.setColumns(10);
			tWriteAirlines.setBorder(new LineBorder(new Color(0, 0, 0)));
			tWriteAirlines.setBounds(10, 178, 300, 25);
		}
		return tWriteAirlines;
	}
	public JLabel getLOpeCenter() {
		if (lOpeCenter == null) {
			lOpeCenter = new JLabel("Centro de Operaciones");
			lOpeCenter.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			lOpeCenter.setBounds(320, 155, 161, 25);
		}
		return lOpeCenter;
	}
	public JLabel getLOperationAirlines() {
		if (lOperationAirlines == null) {
			lOperationAirlines = new JLabel("Operaciones");
			lOperationAirlines.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			lOperationAirlines.setFont(new Font("Segoe UI", Font.BOLD, 15));
			lOperationAirlines.setBounds(10, 75, 975, 25);
		}
		return lOperationAirlines;
	}
	public JButton getBtnRemoveAirlines(String userType) {
		if (btnRemoveAirlines == null) {
			
			if(userType.equals("Administrador")) {
				btnRemoveAirlines = new JButton("Eliminar");
				btnRemoveAirlines.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btnRemoveAirlines.setIcon(new ImageIcon(GUIAirlines.class.getResource("/images/icons_remove.png")));
				btnRemoveAirlines.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnRemoveAirlines.setOpaque(false);
				btnRemoveAirlines.setForeground(new Color(0, 0, 128));
				btnRemoveAirlines.setFont(new Font("Segoe UI", Font.BOLD, 15));
				btnRemoveAirlines.setContentAreaFilled(false);
				btnRemoveAirlines.setBorder(null);
				btnRemoveAirlines.setBounds(220, 110, 90, 35);
			}else if(userType.equals("Colaborador")) {
				btnRemoveAirlines = new JButton("Eliminar");
				btnRemoveAirlines.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btnRemoveAirlines.setIcon(new ImageIcon(GUIAirlines.class.getResource("/images/icons_remove.png")));
				btnRemoveAirlines.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnRemoveAirlines.setOpaque(false);
				btnRemoveAirlines.setForeground(new Color(0, 0, 128));
				btnRemoveAirlines.setFont(new Font("Segoe UI", Font.BOLD, 15));
				btnRemoveAirlines.setContentAreaFilled(false);
				btnRemoveAirlines.setBorder(null);
				btnRemoveAirlines.setBounds(220, 110, 90, 35);
				btnRemoveAirlines.setVisible(false);
			}
			
		}
		return btnRemoveAirlines;
	}
	public JButton getBtnEditAirlines(String userType) {
		if (btnEditAirlines == null) {
			if(userType.equals("Administrador")) {
				btnEditAirlines = new JButton("Editar");
				btnEditAirlines.setIcon(new ImageIcon(GUIAirlines.class.getResource("/images/icons_edit.png")));
				btnEditAirlines.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnEditAirlines.setOpaque(false);
				btnEditAirlines.setForeground(new Color(0, 0, 128));
				btnEditAirlines.setFont(new Font("Segoe UI", Font.BOLD, 15));
				btnEditAirlines.setContentAreaFilled(false);
				btnEditAirlines.setBorder(null);
				btnEditAirlines.setBounds(10, 110, 80, 35);
			}else if(userType.equals("Colaborador")) {
				btnEditAirlines = new JButton("Editar");
				btnEditAirlines.setIcon(new ImageIcon(GUIAirlines.class.getResource("/images/icons_edit.png")));
				btnEditAirlines.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnEditAirlines.setOpaque(false);
				btnEditAirlines.setForeground(new Color(0, 0, 128));
				btnEditAirlines.setFont(new Font("Segoe UI", Font.BOLD, 15));
				btnEditAirlines.setContentAreaFilled(false);
				btnEditAirlines.setBorder(null);
				btnEditAirlines.setBounds(10, 110, 80, 35);
				btnEditAirlines.setVisible(false);
			}
		}
		return btnEditAirlines;
	}
	public JButton getBtnConsultAirlines() {
		if (btnConsultAirlines == null) {
			btnConsultAirlines = new JButton("Consultar");
			btnConsultAirlines.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnConsultAirlines.setHorizontalAlignment(SwingConstants.LEFT);
			btnConsultAirlines.setIcon(new ImageIcon(GUIAirlines.class.getResource("/images/icons_consult.png")));
			btnConsultAirlines.setOpaque(false);
			btnConsultAirlines.setForeground(new Color(0, 0, 128));
			btnConsultAirlines.setFont(new Font("Segoe UI", Font.BOLD, 15));
			btnConsultAirlines.setContentAreaFilled(false);
			btnConsultAirlines.setBorder(null);
			btnConsultAirlines.setBounds(865, 110, 120, 35);
		}
		return btnConsultAirlines;
	}
	public JButton getBtnAddAirlines() {
		if (btnAddAirlines == null) {
			btnAddAirlines = new JButton("Agregar");
			btnAddAirlines.setIcon(new ImageIcon(GUIAirlines.class.getResource("/images/icons_add.png")));
			btnAddAirlines.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnAddAirlines.setOpaque(false);
			btnAddAirlines.setHorizontalAlignment(SwingConstants.LEADING);
			btnAddAirlines.setForeground(new Color(0, 0, 128));
			btnAddAirlines.setFont(new Font("Segoe UI", Font.BOLD, 16));
			btnAddAirlines.setContentAreaFilled(false);
			btnAddAirlines.setBorder(null);
			btnAddAirlines.setBounds(435, 110, 110, 35);
		}
		return btnAddAirlines;
	}
	public void setDTMTAirlines(Object data[][], String[] columnsNamesM) {
		dtmTAirlines = new DefaultTableModel(data, columnsNamesM);
	}
	public DefaultTableModel getDTMTAirlines() {
		return dtmTAirlines;
	}
	public void setTAirlines(DefaultTableModel dtmtAirlines) {
		tAirlines = new JTable(dtmTAirlines);
		tAirlines.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("unchecked")
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int selectedRow = tAirlines.getSelectedRow(); //Variable que va a obtener lo que se encuentra en tUsers
	            DefaultTableModel model = (DefaultTableModel) tAirlines.getModel(); //Me va a obtener los datos asociados a tTickets que están en la tabla
	            Vector<Object> rowData = model.getDataVector().elementAt(selectedRow); //Es el vector del objeto seleccionado en la tabla
	           //Se agregan los componentes al los campos de texto y combo box
	            tWriteAirlines.setText((String) rowData.get(0));
	            tOpeCenter.setText((String) rowData.get(1));
	            
			}
		});
		tAirlines.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tAirlines.setEnabled(true);
		tAirlines.getTableHeader().setReorderingAllowed(false);
		tAirlines.getTableHeader().setResizingAllowed(false);
	}
	public JTable getTAirlines() {
		return this.tAirlines;
	}
	public void setSPTAirlines(JTable tAirlines) {
		spTAirlines = new JScrollPane(tAirlines);
		spTAirlines.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Datos de aerolineas registrados", TitledBorder.LEFT, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		spTAirlines.setFont(new Font("Tahoma", Font.PLAIN, 11));
		spTAirlines.setToolTipText("");
		spTAirlines.setBackground(new Color(255, 255, 255));
		spTAirlines.setBounds(10, 214, 975, 280);
	}
	public JScrollPane getSPTModels() {
		return this.spTAirlines;
	}
	public String[] getColumnsNamesM() {
		String columnsName[] = {"Nombre","Centro de Operaciones"};
		return columnsName;
	}
	public JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
			separator_1.setBounds(10, 150, 975, 1);
		}
		return separator_1;
	}
	public JTextField getTSearchAirline() {
		if (tSearchAirline == null) {
			tSearchAirline = new JTextField();
			tSearchAirline.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent e) {
					if (tSearchAirline.getText().equals("Escribir la aerolinea que desea eliminar y/o consultar")) {
						tSearchAirline.setText("");
						tSearchAirline.setForeground(Color.black);
					}
				}
			});
			tSearchAirline.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			tSearchAirline.setForeground(new Color(192, 192, 192));
			tSearchAirline.setText("Escribir la aerolinea que desea eliminar y/o consultar");
			tSearchAirline.setFont(new Font("Tahoma", Font.PLAIN, 12));
			tSearchAirline.setBounds(555, 115, 300, 30);
			tSearchAirline.setColumns(10);
		}
		return tSearchAirline;
	}
	public JTextField getTOpeCenter() {
		if (tOpeCenter == null) {
			tOpeCenter = new JTextField();
			tOpeCenter.setFont(new Font("Tahoma", Font.PLAIN, 10));
			tOpeCenter.setColumns(10);
			tOpeCenter.setBorder(new LineBorder(new Color(0, 0, 0)));
			tOpeCenter.setBounds(320, 178, 300, 25);
		}
		return tOpeCenter;
	}
}
