package presentation;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import domain.Airlines;
import domain.Flights;
import domain.Tickets;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Cursor;

@SuppressWarnings("serial")
public class GUIPrintTickets extends JInternalFrame {
	private JLabel lblNewLabel;
	private JLabel lblNmeroDeVuelo;
	private JLabel lTickets;
	private JTextField tPassport;
	private JLabel lblPasaporte;
	private JComboBox<String> cxTicketNum;
	private JLabel lblClase;
	private JComboBox<String> cxTypeClass;
	private JTextField tAmountTotal;
	private JLabel lblMonto;
	private JButton btnContinue;
	private JComboBox<String> cxFlightNum;
	private JLabel lblAerolnea;
	private JComboBox<String> cxAirline;
	private JTextField tRegisterAircrf;
	private JLabel lblMatrcula;
	private DefaultTableModel dtmTPrint;
	private JTable tPrint;
	private JScrollPane spTPrint;
	private Object dataTable[][];
	private JButton btnPrint;
	private JLabel lblNewLabel_1;

	public GUIPrintTickets() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Impresión de tiquete");
		getContentPane().setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 985, 752);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getLblNmeroDeVuelo());
		getContentPane().add(getLTickets());
		getContentPane().add(getTPassport());
		getContentPane().add(getLblPasaporte());
		getContentPane().add(getCxTicketNum());
		getContentPane().add(getLblClase());
		getContentPane().add(getCxTypeClass());
		getContentPane().add(getTAmountTotal());
		getContentPane().add(getLblMonto());
		getContentPane().add(getBtnContinue());
		getContentPane().add(getCxFlightNum());
		getContentPane().add(getLblAerolnea());
		getContentPane().add(getCxAirline());
		getContentPane().add(getTRegisterAircrf());
		getContentPane().add(getLblMatrcula());
		
		setDTMTPrint(dataTable, getColumnsNames());
		setTPrint(dtmTPrint);
		setSPTPrint(tPrint);
		getContentPane().add(spTPrint);
		getContentPane().add(getBtnPrint());
		getContentPane().add(getLblNewLabel_1());
		
		setVisible(true);
	}

	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Ingreso de datos");
			lblNewLabel.setOpaque(true);
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setBackground(new Color(0, 0, 205));
			lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 18));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(10, 10, 950, 30);
		}
		return lblNewLabel;
	}
	public JLabel getLblNmeroDeVuelo() {
		if (lblNmeroDeVuelo == null) {
			lblNmeroDeVuelo = new JLabel("Número de vuelo");
			lblNmeroDeVuelo.setHorizontalTextPosition(SwingConstants.LEFT);
			lblNmeroDeVuelo.setHorizontalAlignment(SwingConstants.CENTER);
			lblNmeroDeVuelo.setFont(new Font("Segoe UI", Font.BOLD, 14));
			lblNmeroDeVuelo.setBounds(175, 50, 118, 25);
		}
		return lblNmeroDeVuelo;
	}
	public JLabel getLTickets() {
		if (lTickets == null) {
			lTickets = new JLabel("Número de tiquete");
			lTickets.setHorizontalAlignment(SwingConstants.CENTER);
			lTickets.setFont(new Font("Segoe UI", Font.BOLD, 14));
			lTickets.setBounds(175, 126, 131, 25);
		}
		return lTickets;
	}
	public JTextField getTPassport() {
		if (tPassport == null) {
			tPassport = new JTextField();
			tPassport.setBorder(new LineBorder(new Color(171, 173, 179)));
			tPassport.setColumns(10);
			tPassport.setBounds(10, 85, 150, 25);
		}
		return tPassport;
	}
	public JLabel getLblPasaporte() {
		if (lblPasaporte == null) {
			lblPasaporte = new JLabel("Pasaporte");
			lblPasaporte.setHorizontalTextPosition(SwingConstants.CENTER);
			lblPasaporte.setHorizontalAlignment(SwingConstants.LEFT);
			lblPasaporte.setFont(new Font("Segoe UI", Font.BOLD, 14));
			lblPasaporte.setBounds(10, 50, 91, 25);
		}
		return lblPasaporte;
	}
	public JComboBox<String> getCxTicketNum() {
		if (cxTicketNum == null) {
			cxTicketNum = new JComboBox<String>();
			cxTicketNum.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			cxTicketNum.setBounds(175, 161, 131, 25);
		}
		return cxTicketNum;
	}
	
	public void fillTicketNum(ArrayList<Tickets> tickets) {
		cxTicketNum.addItem("Seleccionar:");
		for(Tickets ticket : tickets) {
			cxTicketNum.addItem(String.valueOf(ticket.getTicketNum()));
		}
	}
	
	public JLabel getLblClase() {
		if (lblClase == null) {
			lblClase = new JLabel("Clase");
			lblClase.setHorizontalTextPosition(SwingConstants.CENTER);
			lblClase.setHorizontalAlignment(SwingConstants.LEFT);
			lblClase.setFont(new Font("Segoe UI", Font.BOLD, 14));
			lblClase.setBounds(325, 126, 91, 25);
		}
		return lblClase;
	}
	public JComboBox<String> getCxTypeClass() {
		if (cxTypeClass == null) {
			cxTypeClass = new JComboBox<String>();
			cxTypeClass.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			cxTypeClass.setModel(new DefaultComboBoxModel<String>(new String[] {"Seleccione:", "Ejecutiva", "Turista", "Económica"}));
			cxTypeClass.setBounds(325, 161, 131, 25);
		}
		return cxTypeClass;
	}
	
	public JTextField getTAmountTotal() {
		if (tAmountTotal == null) {
			tAmountTotal = new JTextField();
			tAmountTotal.setColumns(10);
			tAmountTotal.setBorder(new LineBorder(new Color(171, 173, 179)));
			tAmountTotal.setBounds(475, 85, 150, 25);
		}
		return tAmountTotal;
	}
	public JLabel getLblMonto() {
		if (lblMonto == null) {
			lblMonto = new JLabel("Monto del tiquete:");
			lblMonto.setHorizontalTextPosition(SwingConstants.CENTER);
			lblMonto.setHorizontalAlignment(SwingConstants.LEFT);
			lblMonto.setFont(new Font("Segoe UI", Font.BOLD, 14));
			lblMonto.setBounds(475, 50, 131, 25);
		}
		return lblMonto;
	}
	public JButton getBtnContinue() {
		if (btnContinue == null) {
			btnContinue = new JButton("Aceptar");
			btnContinue.setOpaque(false);
			btnContinue.setHideActionText(true);
			btnContinue.setBackground(new Color(204, 255, 255));
			btnContinue.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnContinue.setIcon(new ImageIcon("C:\\Users\\UNA\\Downloads\\icons8-aceptar-28.png"));
			btnContinue.setForeground(new Color(0, 0, 128));
			btnContinue.setFont(new Font("Segoe UI", Font.BOLD, 16));
			btnContinue.setBorder(new LineBorder(new Color(0, 0, 0)));
			btnContinue.setBounds(10, 230, 256, 30);
		}
		return btnContinue;
	}
	public JComboBox<String> getCxFlightNum() {
		if (cxFlightNum == null) {
			cxFlightNum = new JComboBox<String>();
			cxFlightNum.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			cxFlightNum.setBounds(175, 85, 131, 25);
		}
		return cxFlightNum;
	}
	
	public void fillFlightNum(ArrayList<Flights> flights) {
		cxFlightNum.addItem("Seleccionar:");
		
		for(Flights flight : flights) {
			cxFlightNum.addItem(String.valueOf(flight.getFlightNum()));
		}
	}
	
	public JLabel getLblAerolnea() {
		if (lblAerolnea == null) {
			lblAerolnea = new JLabel("Aerolínea");
			lblAerolnea.setHorizontalTextPosition(SwingConstants.CENTER);
			lblAerolnea.setHorizontalAlignment(SwingConstants.LEFT);
			lblAerolnea.setFont(new Font("Segoe UI", Font.BOLD, 14));
			lblAerolnea.setBounds(325, 50, 91, 25);
		}
		return lblAerolnea;
	}
	public JComboBox<String> getCxAirline() {
		if (cxAirline == null) {
			cxAirline = new JComboBox<String>();
			cxAirline.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			cxAirline.setBounds(325, 85, 131, 25);
		}
		return cxAirline;
	}
	
	public void fillAirlineName(ArrayList<Airlines> airlines) {
		cxAirline.addItem("Seleccionar:");
		
		for(Airlines airline : airlines) {
			cxAirline.addItem(String.valueOf(airline.getNameAirline()));
		}
	}
	
	public JTextField getTRegisterAircrf() {
		if (tRegisterAircrf == null) {
			tRegisterAircrf = new JTextField();
			tRegisterAircrf.setColumns(10);
			tRegisterAircrf.setBorder(new LineBorder(new Color(171, 173, 179)));
			tRegisterAircrf.setBounds(10, 161, 150, 25);
		}
		return tRegisterAircrf;
	}
	public JLabel getLblMatrcula() {
		if (lblMatrcula == null) {
			lblMatrcula = new JLabel("Matrícula");
			lblMatrcula.setHorizontalTextPosition(SwingConstants.CENTER);
			lblMatrcula.setHorizontalAlignment(SwingConstants.LEFT);
			lblMatrcula.setFont(new Font("Segoe UI", Font.BOLD, 14));
			lblMatrcula.setBounds(10, 126, 91, 25);
		}
		return lblMatrcula;
	}
	
	public void setDTMTPrint(Object data[][], String[] columnsNames) {
		dtmTPrint = new DefaultTableModel(data, columnsNames);
	}
	public DefaultTableModel getDTMTPrint() {
		return dtmTPrint;
	}
	public void setTPrint(DefaultTableModel dtmtPrint) {
		tPrint = new JTable(dtmTPrint);
		
		tPrint.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tPrint.setEnabled(true);
		tPrint.getTableHeader().setReorderingAllowed(false);
		tPrint.getTableHeader().setResizingAllowed(false);
	}
	public JTable getTPrint() {
		return this.tPrint;
	}
	public void setSPTPrint(JTable tPrint) {
		spTPrint = new JScrollPane(tPrint);
		spTPrint.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Datos de tiquete", TitledBorder.LEFT, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		spTPrint.setFont(new Font("Tahoma", Font.PLAIN, 11));
		spTPrint.setToolTipText("");
		spTPrint.setBackground(new Color(255, 255, 255));
		spTPrint.setBounds(10, 395, 950, 317);
	}
	public JScrollPane getSPTPrint() {
		return this.spTPrint;
	}
	public String[] getColumnsNames() {
		String columnsName[] = {"Pasajero","Tiquete","Datos de avión","Datos de venta"};
		return columnsName;
	}
	public JButton getBtnPrint() {
		if (btnPrint == null) {
			btnPrint = new JButton("Imprimir");
			btnPrint.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnPrint.setIcon(new ImageIcon(GUIPrintTickets.class.getResource("/images/icons8-imprimir-24.png")));
			btnPrint.setOpaque(false);
			btnPrint.setHorizontalAlignment(SwingConstants.LEADING);
			btnPrint.setForeground(new Color(0, 0, 128));
			btnPrint.setFont(new Font("Segoe UI", Font.BOLD, 16));
			btnPrint.setContentAreaFilled(false);
			btnPrint.setBorder(null);
			btnPrint.setBounds(840, 355, 100, 30);
		}
		return btnPrint;
	}
	public JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Impresión de tiquetes");
			lblNewLabel_1.setOpaque(true);
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setForeground(Color.WHITE);
			lblNewLabel_1.setFont(new Font("Roboto", Font.BOLD, 18));
			lblNewLabel_1.setBackground(new Color(0, 0, 205));
			lblNewLabel_1.setBounds(10, 307, 950, 30);
		}
		return lblNewLabel_1;
	}
}
