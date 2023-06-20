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
public class GUIFlights extends JInternalFrame {
	private JLabel lFlightsManag;
	private JLabel lDepartureCity;
	private JTextField tDepartureCity;
	private JSeparator separator;
	private JLabel lDepartureDate;
	private JLabel lOperationFlights;
	private JButton btnRemoveFlights;
	private JButton btnEditFlights;
	private JButton btnConsultFlight;
	private JButton btnShowFlights;
	private JButton btnAddFlight;
	private JTextArea taInfo;
	private DefaultTableModel dtmTFlights;
	private JTable tFlights;
	private JScrollPane spTFlights;
	private Object dataTableM[][];
	private JSeparator separator_1;
	private JTextField tSearchFlights;
	private JTextField tDate;
	private JSeparator separator_2;
	private JLabel lDepartureHour;
	private JTextField tDepartureHour;
	private JSeparator separator_2_1;
	private JLabel lArrivalDate;
	private JTextField tArrivalDate;
	private JSeparator separator_2_2;
	private JLabel lArrivalHour;
	private JTextField tArrivalHour;
	private JSeparator separator_2_1_1;
	private JLabel lPlane;
	private JLabel lSeatsAmount;
	private JTextField tExecutive;
	private JTextField tTourist;
	private JTextField tEconomic;
	@SuppressWarnings("rawtypes")
	private JComboBox cxFlightAirline;

	
	public GUIFlights() {
		getContentPane().setBackground(new Color(255, 255, 255));
		setTitle("Gestión de Modelos");
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 1549, 734);
		getContentPane().setLayout(null);
		getContentPane().add(getLFlightsManag());
		getContentPane().add(getLDepartureCity());
		getContentPane().add(getTDepartureCity());
		getContentPane().add(getSeparator());
		getContentPane().add(getLDepartureDate());
		getContentPane().add(getLOperationFlights());
		getContentPane().add(getBtnRemoveFlights());
		getContentPane().add(getBtnEditFlights());
		getContentPane().add(getBtnConsultFlight());
		getContentPane().add(getBtnShowFlights());
		getContentPane().add(getBtnAddFlight());
		getContentPane().add(getTaInfo());
		setDTMTFlights(dataTableM, getColumnsNamesM());
		setTFlights(dtmTFlights);
		setSPTFlights(tFlights);
		getContentPane().add(spTFlights);
		getContentPane().add(getTaInfo());
		getContentPane().add(getSeparator_1());
		getContentPane().add(getTSearchFlights());
		getContentPane().add(getTDate());
		getContentPane().add(getSeparator_2());
		getContentPane().add(getLDepartureHour());
		getContentPane().add(getTDepartureHour());
		getContentPane().add(getSeparator_2_1());
		getContentPane().add(getLArrivalDate());
		getContentPane().add(getTArrivalDate());
		getContentPane().add(getSeparator_2_2());
		getContentPane().add(getLArrivalHour());
		getContentPane().add(getTArrivalHour());
		getContentPane().add(getSeparator_2_1_1());
		getContentPane().add(getLPlane());
		getContentPane().add(getLSeatsAmount());
		getContentPane().add(getTExecutive());
		getContentPane().add(getTTourist());
		getContentPane().add(getTEconomic());
		getContentPane().add(getCxFlightAirline());
		setVisible(true);
	}
	public JLabel getLFlightsManag() {
		if (lFlightsManag == null) {
			lFlightsManag = new JLabel("Bienvenidos a la Gestión de Vuelos");
			lFlightsManag.setBounds(10, 10, 975, 40);
			lFlightsManag.setHorizontalAlignment(SwingConstants.CENTER);
			lFlightsManag.setFont(new Font("Roboto Black", Font.PLAIN, 18));
			lFlightsManag.setBorder(new LineBorder(new Color(0, 0, 0)));
		}
		return lFlightsManag;
	}
	public JLabel getLDepartureCity() {
		if (lDepartureCity == null) {
			lDepartureCity = new JLabel("Ciudad de salida");
			lDepartureCity.setBounds(10, 180, 120, 25);
			lDepartureCity.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return lDepartureCity;
	}
	public JTextField getTDepartureCity() {
		if (tDepartureCity == null) {
			tDepartureCity = new JTextField();
			tDepartureCity.setBounds(10, 202, 300, 25);
			tDepartureCity.setFont(new Font("Tahoma", Font.PLAIN, 10));
			tDepartureCity.setColumns(10);
			tDepartureCity.setBorder(null);
		}
		return tDepartureCity;
	}
	public JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(10, 228, 300, 1);
		}
		return separator;
	}
	public JLabel getLDepartureDate() {
		if (lDepartureDate == null) {
			lDepartureDate = new JLabel("Fecha de salida");
			lDepartureDate.setBounds(10, 244, 110, 25);
			lDepartureDate.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return lDepartureDate;
	}
	public JLabel getLOperationFlights() {
		if (lOperationFlights == null) {
			lOperationFlights = new JLabel("Operaciones");
			lOperationFlights.setBounds(10, 75, 975, 25);
			lOperationFlights.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			lOperationFlights.setFont(new Font("Segoe UI", Font.BOLD, 15));
		}
		return lOperationFlights;
	}
	public JButton getBtnRemoveFlights() {
		if (btnRemoveFlights == null) {
			btnRemoveFlights = new JButton("Eliminar");
			btnRemoveFlights.setBounds(220, 110, 90, 35);
			btnRemoveFlights.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnRemoveFlights.setIcon(new ImageIcon(GUIFlights.class.getResource("/images/icons_remove.png")));
			btnRemoveFlights.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnRemoveFlights.setOpaque(false);
			btnRemoveFlights.setForeground(new Color(0, 0, 128));
			btnRemoveFlights.setFont(new Font("Segoe UI", Font.BOLD, 15));
			btnRemoveFlights.setContentAreaFilled(false);
			btnRemoveFlights.setBorder(null);
		}
		return btnRemoveFlights;
	}
	public JButton getBtnEditFlights() {
		if (btnEditFlights == null) {
			btnEditFlights = new JButton("Editar");
			btnEditFlights.setBounds(10, 110, 80, 35);
			btnEditFlights.setIcon(new ImageIcon(GUIFlights.class.getResource("/images/icons_edit.png")));
			btnEditFlights.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnEditFlights.setOpaque(false);
			btnEditFlights.setForeground(new Color(0, 0, 128));
			btnEditFlights.setFont(new Font("Segoe UI", Font.BOLD, 15));
			btnEditFlights.setContentAreaFilled(false);
			btnEditFlights.setBorder(null);
		}
		return btnEditFlights;
	}
	public JButton getBtnConsultFlight() {
		if (btnConsultFlight == null) {
			btnConsultFlight = new JButton("Consultar");
			btnConsultFlight.setBounds(865, 110, 120, 35);
			btnConsultFlight.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnConsultFlight.setHorizontalAlignment(SwingConstants.LEFT);
			btnConsultFlight.setIcon(new ImageIcon(GUIFlights.class.getResource("/images/icons_consult.png")));
			btnConsultFlight.setOpaque(false);
			btnConsultFlight.setForeground(new Color(0, 0, 128));
			btnConsultFlight.setFont(new Font("Segoe UI", Font.BOLD, 15));
			btnConsultFlight.setContentAreaFilled(false);
			btnConsultFlight.setBorder(null);
		}
		return btnConsultFlight;
	}
	public JButton getBtnShowFlights() {
		if (btnShowFlights == null) {
			btnShowFlights = new JButton("Mostrar");
			btnShowFlights.setBounds(448, 110, 97, 35);
			btnShowFlights.setIcon(new ImageIcon(GUIFlights.class.getResource("/images/icons_show.png")));
			btnShowFlights.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnShowFlights.setOpaque(false);
			btnShowFlights.setForeground(new Color(0, 0, 128));
			btnShowFlights.setFont(new Font("Segoe UI", Font.BOLD, 15));
			btnShowFlights.setContentAreaFilled(false);
			btnShowFlights.setBorder(null);
		}
		return btnShowFlights;
	}
	public JButton getBtnAddFlight() {
		if (btnAddFlight == null) {
			btnAddFlight = new JButton("Agregar");
			btnAddFlight.setBounds(328, 656, 110, 35);
			btnAddFlight.setIcon(new ImageIcon(GUIFlights.class.getResource("/images/icons_add.png")));
			btnAddFlight.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnAddFlight.setOpaque(false);
			btnAddFlight.setHorizontalAlignment(SwingConstants.LEADING);
			btnAddFlight.setForeground(new Color(0, 0, 128));
			btnAddFlight.setFont(new Font("Segoe UI", Font.BOLD, 16));
			btnAddFlight.setContentAreaFilled(false);
			btnAddFlight.setBorder(null);
		}
		return btnAddFlight;
	}
	public JTextArea getTaInfo() {
		if (taInfo == null) {
			taInfo = new JTextArea();
			taInfo.setBounds(448, 183, 540, 54);
			taInfo.setBorder(null);
			taInfo.setWrapStyleWord(true);
			taInfo.setText("Consultar o mostrar los vuelos registrados, se puede hacer individual o grupal, según su preferencia.");
			taInfo.setLineWrap(true);
			taInfo.setForeground(new Color(102, 102, 102));
			taInfo.setEditable(false);
		}
		return taInfo;
	}
	public void setDTMTFlights(Object data[][], String[] columnsNamesM) {
		dtmTFlights = new DefaultTableModel(data, columnsNamesM);
	}
	public DefaultTableModel getDTMTModels() {
		return dtmTFlights;
	}
	public void setTFlights(DefaultTableModel dtmtFlights) {
		tFlights = new JTable(dtmTFlights);
		tFlights.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tFlights.setEnabled(false);
		tFlights.getTableHeader().setReorderingAllowed(false);
		tFlights.getTableHeader().setResizingAllowed(false);
	}
	public JTable getTFlights() {
		return this.tFlights;
	}
	public void setSPTFlights(JTable tFlights) {
		spTFlights = new JScrollPane(tFlights);
		spTFlights.setBounds(448, 233, 1055, 458);
		spTFlights.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Datos de vuelos registrados", TitledBorder.LEFT, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		spTFlights.setFont(new Font("Tahoma", Font.PLAIN, 11));
		spTFlights.setToolTipText("");
		spTFlights.setBackground(new Color(255, 255, 255));
	}
	public JScrollPane getSPTFlights() {
		return this.spTFlights;
	}
	public String[] getColumnsNamesM() {
		String columnsName[] = {"Numero de vuelo","Ciudad de salida","Fecha de salida","Hora de salida","Ciudad de llegada","Fecha de llegada","Hora de llegada"
				,"Avion","Monto Ejecutivo","Monto Turista","Monto Economico"};
		return columnsName;
	}
	public JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
			separator_1.setBounds(10, 150, 975, 1);
		}
		return separator_1;
	}
	public JTextField getTSearchFlights() {
		if (tSearchFlights == null) {
			tSearchFlights = new JTextField();
			tSearchFlights.setBounds(555, 115, 300, 30);
			tSearchFlights.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			tSearchFlights.setForeground(new Color(192, 192, 192));
			tSearchFlights.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if(tSearchFlights.getText().equals("Escribir el modelo que desea consultar")) {
						tSearchFlights.setText("");
						tSearchFlights.setForeground(Color.black);
					}
				}
			});
			tSearchFlights.setText("Escribir el vuelo que desea consultar/mostrar");
			tSearchFlights.setFont(new Font("Tahoma", Font.PLAIN, 12));
			tSearchFlights.setColumns(10);
		}
		return tSearchFlights;
	}
	public JTextField getTDate() {
		if (tDate == null) {
			tDate = new JTextField();
			tDate.setFont(new Font("Tahoma", Font.PLAIN, 10));
			tDate.setColumns(10);
			tDate.setBorder(null);
			tDate.setBounds(10, 268, 300, 25);
		}
		return tDate;
	}
	public JSeparator getSeparator_2() {
		if (separator_2 == null) {
			separator_2 = new JSeparator();
			separator_2.setBounds(10, 293, 300, 1);
		}
		return separator_2;
	}
	public JLabel getLDepartureHour() {
		if (lDepartureHour == null) {
			lDepartureHour = new JLabel("Hora de salida");
			lDepartureHour.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			lDepartureHour.setBounds(10, 304, 110, 25);
		}
		return lDepartureHour;
	}
	public JTextField getTDepartureHour() {
		if (tDepartureHour == null) {
			tDepartureHour = new JTextField();
			tDepartureHour.setFont(new Font("Tahoma", Font.PLAIN, 10));
			tDepartureHour.setColumns(10);
			tDepartureHour.setBorder(null);
			tDepartureHour.setBounds(10, 328, 300, 25);
		}
		return tDepartureHour;
	}
	public JSeparator getSeparator_2_1() {
		if (separator_2_1 == null) {
			separator_2_1 = new JSeparator();
			separator_2_1.setBounds(10, 353, 300, 1);
		}
		return separator_2_1;
	}
	public JLabel getLArrivalDate() {
		if (lArrivalDate == null) {
			lArrivalDate = new JLabel("Fecha de llegada");
			lArrivalDate.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			lArrivalDate.setBounds(10, 364, 120, 25);
		}
		return lArrivalDate;
	}
	public JTextField getTArrivalDate() {
		if (tArrivalDate == null) {
			tArrivalDate = new JTextField();
			tArrivalDate.setFont(new Font("Tahoma", Font.PLAIN, 10));
			tArrivalDate.setColumns(10);
			tArrivalDate.setBorder(null);
			tArrivalDate.setBounds(10, 388, 300, 25);
		}
		return tArrivalDate;
	}
	public JSeparator getSeparator_2_2() {
		if (separator_2_2 == null) {
			separator_2_2 = new JSeparator();
			separator_2_2.setBounds(10, 413, 300, 1);
		}
		return separator_2_2;
	}
	public JLabel getLArrivalHour() {
		if (lArrivalHour == null) {
			lArrivalHour = new JLabel("Hora de llegada");
			lArrivalHour.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			lArrivalHour.setBounds(10, 424, 110, 25);
		}
		return lArrivalHour;
	}
	public JTextField getTArrivalHour() {
		if (tArrivalHour == null) {
			tArrivalHour = new JTextField();
			tArrivalHour.setFont(new Font("Tahoma", Font.PLAIN, 10));
			tArrivalHour.setColumns(10);
			tArrivalHour.setBorder(null);
			tArrivalHour.setBounds(10, 448, 300, 25);
		}
		return tArrivalHour;
	}
	public JSeparator getSeparator_2_1_1() {
		if (separator_2_1_1 == null) {
			separator_2_1_1 = new JSeparator();
			separator_2_1_1.setBounds(10, 473, 300, 1);
		}
		return separator_2_1_1;
	}
	public JLabel getLPlane() {
		if (lPlane == null) {
			lPlane = new JLabel("Avion");
			lPlane.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			lPlane.setBounds(10, 484, 110, 25);
		}
		return lPlane;
	}
	public JLabel getLSeatsAmount() {
		if (lSeatsAmount == null) {
			lSeatsAmount = new JLabel("Monto de Asientos");
			lSeatsAmount.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			lSeatsAmount.setBounds(10, 556, 150, 25);
		}
		return lSeatsAmount;
	}
	public JTextField getTExecutive() {
		if (tExecutive == null) {
			tExecutive = new JTextField();
			tExecutive.setText("Clase Ejecutiva");
			tExecutive.setHorizontalAlignment(SwingConstants.LEFT);
			tExecutive.setForeground(Color.LIGHT_GRAY);
			tExecutive.setFont(new Font("Tahoma", Font.PLAIN, 14));
			tExecutive.setColumns(10);
			tExecutive.setBackground(Color.WHITE);
			tExecutive.setBounds(10, 591, 150, 25);
		}
		return tExecutive;
	}
	public JTextField getTTourist() {
		if (tTourist == null) {
			tTourist = new JTextField();
			tTourist.setText("Turista");
			tTourist.setForeground(Color.LIGHT_GRAY);
			tTourist.setFont(new Font("Tahoma", Font.PLAIN, 14));
			tTourist.setColumns(10);
			tTourist.setBackground(Color.WHITE);
			tTourist.setBounds(10, 627, 150, 25);
		}
		return tTourist;
	}
	public JTextField getTEconomic() {
		if (tEconomic == null) {
			tEconomic = new JTextField();
			tEconomic.setText("Económico");
			tEconomic.setForeground(Color.LIGHT_GRAY);
			tEconomic.setFont(new Font("Tahoma", Font.PLAIN, 14));
			tEconomic.setColumns(10);
			tEconomic.setBackground(Color.WHITE);
			tEconomic.setBounds(10, 662, 150, 25);
		}
		return tEconomic;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public JComboBox getCxFlightAirline() {
		if (cxFlightAirline == null) {
			cxFlightAirline = new JComboBox();
			cxFlightAirline.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar:"}));
			cxFlightAirline.setFont(new Font("Tahoma", Font.PLAIN, 14));
			cxFlightAirline.setBounds(10, 520, 150, 25);
		}
		return cxFlightAirline;
	}
}
