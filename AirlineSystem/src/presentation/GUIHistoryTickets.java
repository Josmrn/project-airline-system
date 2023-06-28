package presentation;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import java.awt.Color;

import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.JComboBox;
import javax.swing.JSeparator;
import java.awt.Cursor;
import javax.swing.JButton;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class GUIHistoryTickets extends JInternalFrame {
	private JLabel lWelcomePrint;
	private JComboBox<?> cxTicketsHistory;
	private JLabel lCodTicket;
	private JLabel lDepurDate;
	private JComboBox cxDepurateDateHis;
	private JLabel lArrivDate;
	private JComboBox cxArrivDateHis;
	private JLabel lReserDate;
	private JComboBox cxReservTickets;
	private JLabel lOrigin;
	private JComboBox cxDeparture;
	private JLabel lArrival;
	private JComboBox cxArrival;
	private DefaultTableModel dtmTHTickets;
	private JTable tHTickts;
	private JScrollPane spTHTickts;
	private Object dataTable[][];
	private JSeparator separator;
	private JButton btnFilter;

	public GUIHistoryTickets() {
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 872, 569);
		getContentPane().setLayout(null);
		getContentPane().add(getLWelcomePrint());
		getContentPane().add(getCxTicketsHistory());
		getContentPane().add(getLCodTicket());
		getContentPane().add(getLDepurDate());
		getContentPane().add(getCxDepurateDateHis());
		getContentPane().add(getLArrivDate());
		getContentPane().add(getCxArrivDateHis());
		getContentPane().add(getLReserDate());
		getContentPane().add(getCxReservTickets());
		getContentPane().add(getLOrigin());
		getContentPane().add(getCxDeparture());
		getContentPane().add(getLArrival());
		getContentPane().add(getCxArrival());
		setDTMTHTickets(dataTable, getColumnsNames());
		setTHTickts(dtmTHTickets);
		setSPTTickts(tHTickts);
		getContentPane().add(spTHTickts);
		getContentPane().add(getSeparator());
		getContentPane().add(getBtnFilter());
		setVisible(true);
	}

	public JLabel getLWelcomePrint() {
		if (lWelcomePrint == null) {
			lWelcomePrint = new JLabel("Historial de tiquetes");
			lWelcomePrint.setForeground(new Color(255, 255, 255));
			lWelcomePrint.setBackground(new Color(0, 0, 102));
			lWelcomePrint.setOpaque(true);
			lWelcomePrint.setHorizontalAlignment(SwingConstants.CENTER);
			lWelcomePrint.setFont(new Font("Roboto Light", Font.BOLD, 18));
			lWelcomePrint.setBounds(10, 10, 840, 30);
		}
		return lWelcomePrint;
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getCxTicketsHistory() {
	    if (cxTicketsHistory == null) {
	        cxTicketsHistory = new JComboBox<>();
	        cxTicketsHistory.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	        cxTicketsHistory.setFont(new Font("Roboto", Font.PLAIN, 14));
	        cxTicketsHistory.setBounds(10, 95, 125, 25);
	    }
	    return cxTicketsHistory;
	}

	public JLabel getLCodTicket() {
		if (lCodTicket == null) {
			lCodTicket = new JLabel("Número de tiquete");
			lCodTicket.setForeground(new Color(0, 0, 102));
			lCodTicket.setFont(new Font("Roboto", Font.BOLD, 14));
			lCodTicket.setBounds(10, 70, 125, 25);
		}
		return lCodTicket;
	}

	public JLabel getLDepurDate() {
		if (lDepurDate == null) {
			lDepurDate = new JLabel("Fecha de salida");
			lDepurDate.setForeground(new Color(0, 0, 102));
			lDepurDate.setFont(new Font("Roboto", Font.BOLD, 14));
			lDepurDate.setBounds(145, 70, 125, 25);
		}
		return lDepurDate;
	}

	public JComboBox getCxDepurateDateHis() {
		if (cxDepurateDateHis == null) {
			cxDepurateDateHis = new JComboBox();
			cxDepurateDateHis.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			cxDepurateDateHis.setFont(new Font("Roboto", Font.PLAIN, 14));
			cxDepurateDateHis.setBounds(145, 95, 125, 25);
		}
		return cxDepurateDateHis;
	}

	public JLabel getLArrivDate() {
		if (lArrivDate == null) {
			lArrivDate = new JLabel("Fecha de llegada");
			lArrivDate.setForeground(new Color(0, 0, 102));
			lArrivDate.setFont(new Font("Roboto", Font.BOLD, 14));
			lArrivDate.setBounds(280, 70, 125, 25);
		}
		return lArrivDate;
	}

	public JComboBox getCxArrivDateHis() {
		if (cxArrivDateHis == null) {
			cxArrivDateHis = new JComboBox();
			cxArrivDateHis.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			cxArrivDateHis.setFont(new Font("Roboto", Font.PLAIN, 14));
			cxArrivDateHis.setBounds(280, 95, 125, 25);
		}
		return cxArrivDateHis;
	}

	public JLabel getLReserDate() {
		if (lReserDate == null) {
			lReserDate = new JLabel("Fecha reservación");
			lReserDate.setForeground(new Color(0, 0, 102));
			lReserDate.setFont(new Font("Roboto", Font.BOLD, 14));
			lReserDate.setBounds(415, 70, 125, 25);
		}
		return lReserDate;
	}

	public JComboBox getCxReservTickets() {
		if (cxReservTickets == null) {
			cxReservTickets = new JComboBox();
			cxReservTickets.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			cxReservTickets.setFont(new Font("Roboto", Font.PLAIN, 14));
			cxReservTickets.setBounds(415, 95, 125, 25);
		}
		return cxReservTickets;
	}

	public JLabel getLOrigin() {
		if (lOrigin == null) {
			lOrigin = new JLabel("Origen");
			lOrigin.setForeground(new Color(0, 0, 102));
			lOrigin.setFont(new Font("Roboto", Font.BOLD, 14));
			lOrigin.setBounds(550, 70, 125, 25);
		}
		return lOrigin;
	}

	public JComboBox getCxDeparture() {
		if (cxDeparture == null) {
			cxDeparture = new JComboBox();
			cxDeparture.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			cxDeparture.setFont(new Font("Roboto", Font.PLAIN, 14));
			cxDeparture.setBounds(550, 95, 145, 25);
		}
		return cxDeparture;
	}

	public JLabel getLArrival() {
		if (lArrival == null) {
			lArrival = new JLabel("Destino");
			lArrival.setForeground(new Color(0, 0, 102));
			lArrival.setFont(new Font("Roboto", Font.BOLD, 14));
			lArrival.setBounds(705, 70, 125, 25);
		}
		return lArrival;
	}

	public JComboBox getCxArrival() {
		if (cxArrival == null) {
			cxArrival = new JComboBox();
			cxArrival.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			cxArrival.setFont(new Font("Roboto", Font.PLAIN, 14));
			cxArrival.setBounds(705, 95, 145, 25);
		}
		return cxArrival;
	}
	
	public void setDTMTHTickets(Object data[][], String[] columnsNames) {
		dtmTHTickets = new DefaultTableModel(data, columnsNames);
	}
	
	public DefaultTableModel getDTMTPlanes() {
		return dtmTHTickets;
	}
	public void setTHTickts(DefaultTableModel dtmtPlanes) {
		tHTickts = new JTable(dtmtPlanes);
		tHTickts.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("unchecked")
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				int selectedRow = tHTickts.getSelectedRow(); //Variable que va a obtener lo que se encuentra en tUsers
	            DefaultTableModel model = (DefaultTableModel) tHTickts.getModel(); //Me va a obtener los datos asociados a tTickets que están en la tabla
	            Vector<Object> rowData = model.getDataVector().elementAt(selectedRow); //Es el vector del objeto seleccionado en la tabla
	           
	            cxTicketsHistory.setSelectedIndex((int) rowData.get(0));
	            cxDepurateDateHis.setSelectedIndex((int) rowData.get(1));
	            cxArrivDateHis.setSelectedIndex((int) rowData.get(2));
	            cxReservTickets.setSelectedIndex((int) rowData.get(2));
	            cxDeparture.setSelectedIndex((int) rowData.get(2));
	            cxDeparture.setSelectedIndex((int) rowData.get(2));
	        
			}
		});
		tHTickts.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tHTickts.setEnabled(true);
		tHTickts.getTableHeader().setReorderingAllowed(false);
		tHTickts.getTableHeader().setResizingAllowed(false);
	}
	public JTable getTHTickts() {
		return this.tHTickts;
	}
	public void setSPTTickts(JTable tModels) {
		spTHTickts = new JScrollPane(tModels);
		spTHTickts.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "HISTORIAL ", TitledBorder.LEFT, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		spTHTickts.setFont(new Font("Tahoma", Font.PLAIN, 11));
		spTHTickts.setToolTipText("");
		spTHTickts.setBackground(new Color(255, 255, 255));
		spTHTickts.setBounds(10, 252, 840, 278);
	}
	public JScrollPane setSPTTickts() {
		return this.spTHTickts;
	}
	public String[] getColumnsNames() {
		String columnsName[] = {"Num Tickets","Fecha de salida","Fecha de llegada","Reservación","Origen","Destino"};
		return columnsName;
	}
	
	public void cleanForm() {
		cxTicketsHistory.setSelectedIndex(0);
		cxDepurateDateHis.setSelectedIndex(0);
		cxDeparture.setSelectedIndex(0);
		cxReservTickets.setSelectedIndex(0);
		cxArrivDateHis.setSelectedIndex(0);
		cxArrival.setSelectedIndex(0);
	}
	public JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(10, 135, 840, 2);
		}
		return separator;
	}
	public JButton getBtnFilter() {
		if (btnFilter == null) {
			btnFilter = new JButton("Filtrar");
			btnFilter.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnFilter.setIcon(new ImageIcon(GUIHistoryTickets.class.getResource("/images/icons_consult.png")));
			btnFilter.setOpaque(false);
			btnFilter.setHorizontalAlignment(SwingConstants.LEFT);
			btnFilter.setForeground(new Color(0, 0, 128));
			btnFilter.setFont(new Font("Segoe UI", Font.BOLD, 15));
			btnFilter.setContentAreaFilled(false);
			btnFilter.setBorder(null);
			btnFilter.setBounds(755, 147, 95, 35);
		}
		return btnFilter;
	}
}
