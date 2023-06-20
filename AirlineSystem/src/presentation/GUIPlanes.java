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
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


@SuppressWarnings("serial")
public class GUIPlanes extends JInternalFrame {
	private JLabel lPlaneManag;
	private JLabel lId;
	private JTextField tWritePlanes;
	private JSeparator separator;
	private JLabel lAirline;
	@SuppressWarnings("rawtypes")
	private JComboBox cxPlaneAirline;
	private JLabel lYear;
	private JTextField tYear;
	private JLabel lOperationPlanes;
	private JButton btnRemovePlanes;
	private JButton btnEditPlanes;
	private JButton btnConsultPlane;
	private JButton btnShowPlanes;
	private JButton btnAddPlanes;
	private JTextArea taInfo;
	private DefaultTableModel dtmTPlanes;
	private JTable tPlanes;
	private JScrollPane spTPlanes;
	private Object dataTableM[][];
	private JSeparator separator_1;
	private JTextField tSearchPlanes;
	private JLabel lPlane;
	@SuppressWarnings("rawtypes")
	private JComboBox cxPlaneModel;

	
	public GUIPlanes() {
		getContentPane().setBackground(new Color(255, 255, 255));
		setTitle("Gestión de Aviones");
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 1010, 535);
		getContentPane().setLayout(null);
		getContentPane().add(getLPlaneManag());
		getContentPane().add(getLId());
		getContentPane().add(getTWritePlanes());
		getContentPane().add(getSeparator());
		getContentPane().add(getLAirline());
		getContentPane().add(getCxPlaneAirline());
		getContentPane().add(getLYear());
		getContentPane().add(getTYear());
		getContentPane().add(getLOperationPlanes());
		getContentPane().add(getBtnRemovePlanes());
		getContentPane().add(getBtnEditPlanes());
		getContentPane().add(getBtnConsultPlane());
		getContentPane().add(getBtnShowPlanes());
		getContentPane().add(getBtnAddPlanes());
		getContentPane().add(getTaInfo());
		setDTMTPlanes(dataTableM, getColumnsNamesM());
		setTPlanes(dtmTPlanes);
		setSPTPlanes(tPlanes);
		getContentPane().add(spTPlanes);
		getContentPane().add(getTaInfo());
		getContentPane().add(getSeparator_1());
		getContentPane().add(getTSearchPlanes());
		getContentPane().add(getLModel());
		getContentPane().add(getCxPlaneModel());
		setVisible(true);
	}
	public JLabel getLPlaneManag() {
		if (lPlaneManag == null) {
			lPlaneManag = new JLabel("Bienvenidos a la Gestión de Aviones");
			lPlaneManag.setHorizontalAlignment(SwingConstants.CENTER);
			lPlaneManag.setFont(new Font("Roboto Black", Font.PLAIN, 18));
			lPlaneManag.setBorder(new LineBorder(new Color(0, 0, 0)));
			lPlaneManag.setBounds(10, 10, 975, 40);
		}
		return lPlaneManag;
	}
	public JLabel getLId() {
		if (lId == null) {
			lId = new JLabel("Matricula");
			lId.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			lId.setBounds(10, 180, 68, 25);
		}
		return lId;
	}
	public JTextField getTWritePlanes() {
		if (tWritePlanes == null) {
			tWritePlanes = new JTextField();
			tWritePlanes.setFont(new Font("Tahoma", Font.PLAIN, 10));
			tWritePlanes.setColumns(10);
			tWritePlanes.setBorder(null);
			tWritePlanes.setBounds(10, 210, 300, 25);
		}
		return tWritePlanes;
	}
	public JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(10, 236, 300, 1);
		}
		return separator;
	}
	public JLabel getLAirline() {
		if (lAirline == null) {
			lAirline = new JLabel("Aerolinea de Avión");
			lAirline.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			lAirline.setBounds(10, 307, 127, 25);
		}
		return lAirline;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public JComboBox getCxPlaneAirline() {
		if (cxPlaneAirline == null) {
			cxPlaneAirline = new JComboBox();
			cxPlaneAirline.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar:"}));
			cxPlaneAirline.setFont(new Font("Tahoma", Font.PLAIN, 14));
			cxPlaneAirline.setBounds(10, 342, 150, 25);
		}
		return cxPlaneAirline;
	}
	public JLabel getLYear() {
		if (lYear == null) {
			lYear = new JLabel("Año del Avion");
			lYear.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			lYear.setBounds(10, 236, 97, 25);
		}
		return lYear;
	}
	public JTextField getTYear() {
		if (tYear == null) {
			tYear = new JTextField();
			tYear.setText("Año");
			tYear.setHorizontalAlignment(SwingConstants.LEFT);
			tYear.setForeground(Color.LIGHT_GRAY);
			tYear.setFont(new Font("Tahoma", Font.PLAIN, 14));
			tYear.setColumns(10);
			tYear.setBackground(Color.WHITE);
			tYear.setBounds(10, 271, 150, 25);
		}
		return tYear;
	}
	public JLabel getLOperationPlanes() {
		if (lOperationPlanes == null) {
			lOperationPlanes = new JLabel("Operaciones");
			lOperationPlanes.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			lOperationPlanes.setFont(new Font("Segoe UI", Font.BOLD, 15));
			lOperationPlanes.setBounds(10, 75, 975, 25);
		}
		return lOperationPlanes;
	}
	public JButton getBtnRemovePlanes() {
		if (btnRemovePlanes == null) {
			btnRemovePlanes = new JButton("Eliminar");
			btnRemovePlanes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnRemovePlanes.setIcon(new ImageIcon(GUIPlanes.class.getResource("/images/icons_remove.png")));
			btnRemovePlanes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnRemovePlanes.setOpaque(false);
			btnRemovePlanes.setForeground(new Color(0, 0, 128));
			btnRemovePlanes.setFont(new Font("Segoe UI", Font.BOLD, 15));
			btnRemovePlanes.setContentAreaFilled(false);
			btnRemovePlanes.setBorder(null);
			btnRemovePlanes.setBounds(220, 110, 90, 35);
		}
		return btnRemovePlanes;
	}
	public JButton getBtnEditPlanes() {
		if (btnEditPlanes == null) {
			btnEditPlanes = new JButton("Editar");
			btnEditPlanes.setIcon(new ImageIcon(GUIPlanes.class.getResource("/images/icons_edit.png")));
			btnEditPlanes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnEditPlanes.setOpaque(false);
			btnEditPlanes.setForeground(new Color(0, 0, 128));
			btnEditPlanes.setFont(new Font("Segoe UI", Font.BOLD, 15));
			btnEditPlanes.setContentAreaFilled(false);
			btnEditPlanes.setBorder(null);
			btnEditPlanes.setBounds(10, 110, 80, 35);
		}
		return btnEditPlanes;
	}
	public JButton getBtnConsultPlane() {
		if (btnConsultPlane == null) {
			btnConsultPlane = new JButton("Consultar");
			btnConsultPlane.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnConsultPlane.setHorizontalAlignment(SwingConstants.LEFT);
			btnConsultPlane.setIcon(new ImageIcon(GUIPlanes.class.getResource("/images/icons_consult.png")));
			btnConsultPlane.setOpaque(false);
			btnConsultPlane.setForeground(new Color(0, 0, 128));
			btnConsultPlane.setFont(new Font("Segoe UI", Font.BOLD, 15));
			btnConsultPlane.setContentAreaFilled(false);
			btnConsultPlane.setBorder(null);
			btnConsultPlane.setBounds(865, 110, 120, 35);
		}
		return btnConsultPlane;
	}
	public JButton getBtnShowPlanes() {
		if (btnShowPlanes == null) {
			btnShowPlanes = new JButton("Mostrar");
			btnShowPlanes.setIcon(new ImageIcon(GUIPlanes.class.getResource("/images/icons_show.png")));
			btnShowPlanes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnShowPlanes.setOpaque(false);
			btnShowPlanes.setForeground(new Color(0, 0, 128));
			btnShowPlanes.setFont(new Font("Segoe UI", Font.BOLD, 15));
			btnShowPlanes.setContentAreaFilled(false);
			btnShowPlanes.setBorder(null);
			btnShowPlanes.setBounds(448, 110, 97, 35);
		}
		return btnShowPlanes;
	}
	public JButton getBtnAddPlanes() {
		if (btnAddPlanes == null) {
			btnAddPlanes = new JButton("Agregar");
			btnAddPlanes.setIcon(new ImageIcon(GUIPlanes.class.getResource("/images/icons_add.png")));
			btnAddPlanes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnAddPlanes.setOpaque(false);
			btnAddPlanes.setHorizontalAlignment(SwingConstants.LEADING);
			btnAddPlanes.setForeground(new Color(0, 0, 128));
			btnAddPlanes.setFont(new Font("Segoe UI", Font.BOLD, 16));
			btnAddPlanes.setContentAreaFilled(false);
			btnAddPlanes.setBorder(null);
			btnAddPlanes.setBounds(10, 460, 110, 35);
		}
		return btnAddPlanes;
	}
	public JTextArea getTaInfo() {
		if (taInfo == null) {
			taInfo = new JTextArea();
			taInfo.setBorder(null);
			taInfo.setWrapStyleWord(true);
			taInfo.setText("Consultar o mostrar los aviones registrados, se puede hacer individual o grupal, según su preferencia.");
			taInfo.setLineWrap(true);
			taInfo.setForeground(new Color(102, 102, 102));
			taInfo.setEditable(false);
			taInfo.setBounds(448, 183, 540, 54);
		}
		return taInfo;
	}
	public void setDTMTPlanes(Object data[][], String[] columnsNamesM) {
		dtmTPlanes = new DefaultTableModel(data, columnsNamesM);
	}
	public DefaultTableModel getDTMTPlanes() {
		return dtmTPlanes;
	}
	public void setTPlanes(DefaultTableModel dtmtPlanes) {
		tPlanes = new JTable(dtmTPlanes);
		tPlanes.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tPlanes.setEnabled(false);
		tPlanes.getTableHeader().setReorderingAllowed(false);
		tPlanes.getTableHeader().setResizingAllowed(false);
	}
	public JTable getTPlanes() {
		return this.tPlanes;
	}
	public void setSPTPlanes(JTable tModels) {
		spTPlanes = new JScrollPane(tModels);
		spTPlanes.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Datos de aviones registrados", TitledBorder.LEFT, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		spTPlanes.setFont(new Font("Tahoma", Font.PLAIN, 11));
		spTPlanes.setToolTipText("");
		spTPlanes.setBackground(new Color(255, 255, 255));
		spTPlanes.setBounds(448, 249, 540, 245);
	}
	public JScrollPane getSPTPlanes() {
		return this.spTPlanes;
	}
	public String[] getColumnsNamesM() {
		String columnsName[] = {"Matricula","Aerolinea","Modelo","Año"};
		return columnsName;
	}
	public JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
			separator_1.setBounds(10, 150, 975, 1);
		}
		return separator_1;
	}
	public JTextField getTSearchPlanes() {
		if (tSearchPlanes == null) {
			tSearchPlanes = new JTextField();
			tSearchPlanes.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			tSearchPlanes.setForeground(new Color(192, 192, 192));
			tSearchPlanes.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if(tSearchPlanes.getText().equals("Escribir el avion que desea consultar")) {
						tSearchPlanes.setText("");
						tSearchPlanes.setForeground(Color.black);
					}
				}
			});
			tSearchPlanes.setText("Escribir el Avion que desea consultar/mostrar");
			tSearchPlanes.setFont(new Font("Tahoma", Font.PLAIN, 12));
			tSearchPlanes.setBounds(555, 115, 300, 30);
			tSearchPlanes.setColumns(10);
		}
		return tSearchPlanes;
	}
	public JLabel getLModel() {
		if (lPlane == null) {
			lPlane = new JLabel("Modelo del Avion");
			lPlane.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			lPlane.setBounds(10, 378, 127, 25);
		}
		return lPlane;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public JComboBox getCxPlaneModel() {
		if (cxPlaneModel == null) {
			cxPlaneModel = new JComboBox();
			cxPlaneModel.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar:"}));
			cxPlaneModel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			cxPlaneModel.setBounds(10, 413, 150, 25);
		}
		return cxPlaneModel;
	}
}
