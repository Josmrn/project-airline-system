package presentation;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import javax.swing.JSeparator;

@SuppressWarnings("serial")
public class GUIHisFlights extends JInternalFrame {
	private JLabel lWelcome;
	private JLabel lblNewLabel;
	private JTextField tWriteCod;
	private JButton btnSearchFlight;

	private DefaultTableModel dtmTHistoryF;
	private JTable tHistoryF;
	private JScrollPane spTHistoryF;
	private Object dataTable[][];
	private JSeparator separator;

	public GUIHisFlights() {
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 1345, 539);
		getContentPane().setLayout(null);
		getContentPane().add(getLWelcome());
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getTWriteCod());
		getContentPane().add(getBtnSearchFlight());
		setDTMTHistoryF(dataTable, getColumnsNames());
		setTHistoryF(dtmTHistoryF);
		setSPTHistoryF(tHistoryF);
		getContentPane().add(spTHistoryF);
		getContentPane().add(getSeparator());
		setVisible(true);
	}

	public JLabel getLWelcome() {
		if (lWelcome == null) {
			lWelcome = new JLabel("Historial de vuelos");
			lWelcome.setOpaque(true);
			lWelcome.setHorizontalAlignment(SwingConstants.CENTER);
			lWelcome.setForeground(Color.WHITE);
			lWelcome.setFont(new Font("Roboto Light", Font.BOLD, 18));
			lWelcome.setBackground(new Color(0, 0, 102));
			lWelcome.setBounds(10, 10, 1313, 30);
		}
		return lWelcome;
	}

	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Buscar por código: ");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
			lblNewLabel.setBounds(20, 50, 131, 25);
		}
		return lblNewLabel;
	}

	public JTextField getTWriteCod() {
		if (tWriteCod == null) {
			tWriteCod = new JTextField();
			tWriteCod.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if(tWriteCod.getText().equals("#Vuelo")) {
						tWriteCod.setText("");
						tWriteCod.setForeground(Color.black);
					}
				}
			});
			tWriteCod.setForeground(new Color(192, 192, 192));
			tWriteCod.setText("#Vuelo");
			tWriteCod.setFont(new Font("Tahoma", Font.PLAIN, 14));
			tWriteCod.setBounds(161, 50, 96, 25);
			tWriteCod.setColumns(10);
		}
		return tWriteCod;
	}

	public JButton getBtnSearchFlight() {
		if (btnSearchFlight == null) {
			btnSearchFlight = new JButton("Buscar");
			btnSearchFlight.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnSearchFlight.setIcon(new ImageIcon(GUIHisFlights.class.getResource("/images/icons_consult.png")));
			btnSearchFlight.setOpaque(false);
			btnSearchFlight.setForeground(new Color(0, 0, 128));
			btnSearchFlight.setFont(new Font("Segoe UI", Font.BOLD, 15));
			btnSearchFlight.setContentAreaFilled(false);
			btnSearchFlight.setBorder(null);
			btnSearchFlight.setBounds(267, 50, 109, 28);
		}
		return btnSearchFlight;
	}
	
	public void setDTMTHistoryF(Object data[][], String[] columnsNames) {
		dtmTHistoryF = new DefaultTableModel(data, columnsNames);
	}
	public DefaultTableModel getDTMTHistoryF() {
		return dtmTHistoryF;
	}
	public void setTHistoryF(DefaultTableModel dtmTHistoryF) {
		tHistoryF = new JTable(dtmTHistoryF);
		tHistoryF.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("unchecked")
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				int selectedRow = tHistoryF.getSelectedRow(); //Variable que va a obtener lo que se encuentra en tUsers
	            DefaultTableModel model = (DefaultTableModel) tHistoryF.getModel(); //Me va a obtener los datos asociados a tTickets que están en la tabla
	            Vector<Object> rowData = model.getDataVector().elementAt(selectedRow); //Es el vector del objeto seleccionado en la tabla
	            
	            tWriteCod.setText((String)rowData.get(0));
	           
			}
		});
		tHistoryF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tHistoryF.setEnabled(true);
		tHistoryF.getTableHeader().setReorderingAllowed(false);
		tHistoryF.getTableHeader().setResizingAllowed(false);
	}
	public JTable getTHistoryF() {
		return this.tHistoryF;
	}
	public void setSPTHistoryF(JTable tHistoryF) {
		spTHistoryF = new JScrollPane(tHistoryF);
		spTHistoryF.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Datos de aviones registrados", TitledBorder.LEFT, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		spTHistoryF.setFont(new Font("Tahoma", Font.PLAIN, 11));
		spTHistoryF.setToolTipText("");
		spTHistoryF.setBackground(new Color(255, 255, 255));
		spTHistoryF.setBounds(10, 116, 1313, 384);
	}
	public JScrollPane getSPTHistoryF() {
		return this.spTHistoryF;
	}
	
	public String[] getColumnsNames() {
		String columnsName[] = { "Num. vuelo", "Aerolínea", "Avion", "Origen", "Fecha de salida", "Destino",
				"Fecha llegada", "C.A.V.Ejecutivos", "C.A.V. Turistas", "C.A.V.Economicos", "C.A.D. Ejecutivos",
				"C.A.D. Turistas", "C.A.D. Economicos", "Monto del vuelo" };
		return columnsName;
	}

	public void cleanForm() {
		tWriteCod.setText(" ");
	}
	public JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(10, 90, 1313, 2);
		}
		return separator;
	}
}
