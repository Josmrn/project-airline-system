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
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


@SuppressWarnings("serial")
public class GUIAirlines extends JInternalFrame {
	private JLabel lAirlineManag;
	private JLabel lName;
	private JTextField tWriteAirlines;
	private JSeparator separator;
	private JLabel lOpeCenter;
	private JLabel lOperationAirlines;
	private JButton btnRemoveAirlines;
	private JButton btnEditAirlines;
	private JButton btnConsultAirlines;
	private JButton btnShowAirlines;
	private JButton btnAddAirlines;
	private JTextArea taInfo;
	private DefaultTableModel dtmTAirlines;
	private JTable tAirlines;
	private JScrollPane spTAirlines;
	private Object dataTableM[][];
	private JSeparator separator_1;
	private JTextField tSearchAirline;
	private JTextField tOpeCenter;
	private JSeparator separator_2;

	
	public GUIAirlines() {
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
		getContentPane().add(getSeparator());
		getContentPane().add(getLOpeCenter());
		getContentPane().add(getLOperationAirlines());
		getContentPane().add(getBtnRemoveAirlines());
		getContentPane().add(getBtnEditAirlines());
		getContentPane().add(getBtnConsultAirlines());
		getContentPane().add(getBtnShowAirlines());
		getContentPane().add(getBtnAddAirlines());
		getContentPane().add(getTaInfo());
		setDTMTAirlines(dataTableM, getColumnsNamesM());
		setTAirlines(dtmTAirlines);
		setSPTAirlines(tAirlines);
		getContentPane().add(spTAirlines);
		getContentPane().add(getTaInfo());
		getContentPane().add(getSeparator_1());
		getContentPane().add(getTSearchAirline());
		getContentPane().add(getTOpeCenter());
		getContentPane().add(getSeparator_2());
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
			lName.setBounds(10, 180, 150, 25);
		}
		return lName;
	}
	public JTextField getTWriteAirlines() {
		if (tWriteAirlines == null) {
			tWriteAirlines = new JTextField();
			tWriteAirlines.setFont(new Font("Tahoma", Font.PLAIN, 10));
			tWriteAirlines.setColumns(10);
			tWriteAirlines.setBorder(null);
			tWriteAirlines.setBounds(10, 210, 300, 25);
		}
		return tWriteAirlines;
	}
	public JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(10, 236, 300, 1);
		}
		return separator;
	}
	public JLabel getLOpeCenter() {
		if (lOpeCenter == null) {
			lOpeCenter = new JLabel("Centro de Operaciones");
			lOpeCenter.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			lOpeCenter.setBounds(10, 244, 161, 25);
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
	public JButton getBtnRemoveAirlines() {
		if (btnRemoveAirlines == null) {
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
		}
		return btnRemoveAirlines;
	}
	public JButton getBtnEditAirlines() {
		if (btnEditAirlines == null) {
			btnEditAirlines = new JButton("Editar");
			btnEditAirlines.setIcon(new ImageIcon(GUIAirlines.class.getResource("/images/icons_edit.png")));
			btnEditAirlines.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnEditAirlines.setOpaque(false);
			btnEditAirlines.setForeground(new Color(0, 0, 128));
			btnEditAirlines.setFont(new Font("Segoe UI", Font.BOLD, 15));
			btnEditAirlines.setContentAreaFilled(false);
			btnEditAirlines.setBorder(null);
			btnEditAirlines.setBounds(10, 110, 80, 35);
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
	public JButton getBtnShowAirlines() {
		if (btnShowAirlines == null) {
			btnShowAirlines = new JButton("Mostrar");
			btnShowAirlines.setIcon(new ImageIcon(GUIAirlines.class.getResource("/images/icons_show.png")));
			btnShowAirlines.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnShowAirlines.setOpaque(false);
			btnShowAirlines.setForeground(new Color(0, 0, 128));
			btnShowAirlines.setFont(new Font("Segoe UI", Font.BOLD, 15));
			btnShowAirlines.setContentAreaFilled(false);
			btnShowAirlines.setBorder(null);
			btnShowAirlines.setBounds(448, 110, 97, 35);
		}
		return btnShowAirlines;
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
			btnAddAirlines.setBounds(10, 460, 110, 35);
		}
		return btnAddAirlines;
	}
	public JTextArea getTaInfo() {
		if (taInfo == null) {
			taInfo = new JTextArea();
			taInfo.setBorder(null);
			taInfo.setWrapStyleWord(true);
			taInfo.setText("Consultar o mostrar las aerolineas registradas, se puede hacer individual o grupal, según su preferencia.");
			taInfo.setLineWrap(true);
			taInfo.setForeground(new Color(102, 102, 102));
			taInfo.setEditable(false);
			taInfo.setBounds(448, 183, 540, 54);
		}
		return taInfo;
	}
	public void setDTMTAirlines(Object data[][], String[] columnsNamesM) {
		dtmTAirlines = new DefaultTableModel(data, columnsNamesM);
	}
	public DefaultTableModel getDTMTAirlines() {
		return dtmTAirlines;
	}
	public void setTAirlines(DefaultTableModel dtmtAirlines) {
		tAirlines = new JTable(dtmTAirlines);
		tAirlines.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tAirlines.setEnabled(false);
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
		spTAirlines.setBounds(448, 249, 540, 245);
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
			tSearchAirline.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			tSearchAirline.setForeground(new Color(192, 192, 192));
			tSearchAirline.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if(tSearchAirline.getText().equals("Escribir el aerolinea que desea consultar")) {
						tSearchAirline.setText("");
						tSearchAirline.setForeground(Color.black);
					}
				}
			});
			tSearchAirline.setText("Escribir la Aerolinea que desea consultar/mostrar");
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
			tOpeCenter.setBorder(null);
			tOpeCenter.setBounds(10, 280, 300, 25);
		}
		return tOpeCenter;
	}
	public JSeparator getSeparator_2() {
		if (separator_2 == null) {
			separator_2 = new JSeparator();
			separator_2.setBounds(10, 306, 300, 1);
		}
		return separator_2;
	}
}
