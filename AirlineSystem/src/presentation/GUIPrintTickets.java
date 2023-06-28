package presentation;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import javax.swing.JSeparator;

@SuppressWarnings("serial")
public class GUIPrintTickets extends JInternalFrame {
	private JLabel lblNewLabel;
	private JLabel lblNmeroDeVuelo;
	private JLabel lTickets;
	private JTextField tPassport;
	private JLabel lblPasaporte;
	private JComboBox cxTicketNum;
	private JLabel lblClase;
	private JComboBox cxTypeClass;
	private JTextField tAmountTotal;
	private JLabel lblMonto;
	private JButton btnContinue;
	private JComboBox cxFlightNum;
	private JLabel lblAerolnea;
	private JComboBox cxAirline;
	private JTextField tRegisterAircrf;
	private JLabel lblMatrcula;
	private DefaultTableModel dtmTPrint;
	private JTable tPrint;
	private JScrollPane spTPrint;
	private Object dataTable[][];
	private JSeparator separator;

	public GUIPrintTickets() {
		getContentPane().setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 985, 586);
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
		getContentPane().add(getSeparator());
		
		setVisible(true);
	}

	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Impresión de tiquetes");
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
	public JComboBox getCxTicketNum() {
		if (cxTicketNum == null) {
			cxTicketNum = new JComboBox();
			cxTicketNum.setBounds(175, 161, 131, 25);
		}
		return cxTicketNum;
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
	public JComboBox getCxTypeClass() {
		if (cxTypeClass == null) {
			cxTypeClass = new JComboBox();
			cxTypeClass.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			cxTypeClass.setModel(new DefaultComboBoxModel(new String[] {"Seleccione:", "Ejecutiva", "Turista", "Económica"}));
			cxTypeClass.setBounds(325, 161, 131, 25);
		}
		return cxTypeClass;
	}
	public JTextField getTAmountTotal() {
		if (tAmountTotal == null) {
			tAmountTotal = new JTextField();
			tAmountTotal.setColumns(10);
			tAmountTotal.setBorder(new LineBorder(new Color(171, 173, 179)));
			tAmountTotal.setBounds(810, 85, 150, 25);
		}
		return tAmountTotal;
	}
	public JLabel getLblMonto() {
		if (lblMonto == null) {
			lblMonto = new JLabel("Monto del tiquete:");
			lblMonto.setHorizontalTextPosition(SwingConstants.CENTER);
			lblMonto.setHorizontalAlignment(SwingConstants.LEFT);
			lblMonto.setFont(new Font("Segoe UI", Font.BOLD, 14));
			lblMonto.setBounds(677, 83, 131, 25);
		}
		return lblMonto;
	}
	public JButton getBtnContinue() {
		if (btnContinue == null) {
			btnContinue = new JButton("Aceptar");
			btnContinue.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnContinue.setIcon(new ImageIcon("C:\\Users\\UNA\\Downloads\\icons8-aceptar-28.png"));
			btnContinue.setOpaque(false);
			btnContinue.setHorizontalAlignment(SwingConstants.LEADING);
			btnContinue.setForeground(new Color(0, 0, 128));
			btnContinue.setFont(new Font("Segoe UI", Font.BOLD, 16));
			btnContinue.setContentAreaFilled(false);
			btnContinue.setBorder(new LineBorder(new Color(0, 0, 0)));
			btnContinue.setBounds(860, 161, 100, 30);
		}
		return btnContinue;
	}
	public JComboBox getCxFlightNum() {
		if (cxFlightNum == null) {
			cxFlightNum = new JComboBox();
			cxFlightNum.setBounds(175, 85, 131, 25);
		}
		return cxFlightNum;
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
	public JComboBox getCxAirline() {
		if (cxAirline == null) {
			cxAirline = new JComboBox();
			cxAirline.setBounds(325, 85, 131, 25);
		}
		return cxAirline;
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
		spTPrint.setBounds(10, 230, 950, 317);
	}
	public JScrollPane getSPTPrint() {
		return this.spTPrint;
	}
	public String[] getColumnsNames() {
		String columnsName[] = {"Pasajero","Tiquete","Datos de avión","Datos de venta"};
		return columnsName;
	}
	public JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(10, 200, 950, 2);
		}
		return separator;
	}
}
