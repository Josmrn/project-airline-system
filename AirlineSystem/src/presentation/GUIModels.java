package presentation;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Cursor;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


@SuppressWarnings("serial")
public class GUIModels extends JFrame {

	private JPanel contentPane;
	private JLabel lModelManag;
	private JLabel lblNewLabel;
	private JTextField tWriteModel;
	private JLabel lAircraftBrand;
	@SuppressWarnings("rawtypes")
	private JComboBox cxBrandAircraft;
	private JLabel lNumberOfSeats;
	private JTextField tExecutiveSeats;
	private JTextField tTouristSeats;
	private JTextField tEconomicSeats;
	private JButton btnRegisterModels;
	private JSeparator separator;
	private JButton btnEditModels;
	private JButton btnRemoveModels;
	private JButton btnConsultModel;
	private JButton btnShowModel;
	//-------------------------------------------
	private DefaultTableModel dtmTModels;
	private JTable tModels;
	private JScrollPane spTModels;
	private Object dataTableM[][];
	private JTextArea taInfo;
	//-------------------------------------------

	public GUIModels() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1010, 455);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLModelManag());
		contentPane.add(getLblNewLabel());
		contentPane.add(getTWriteModel());
		contentPane.add(getLAircraftBrand());
		contentPane.add(getCxBrandAircraft());
		contentPane.add(getLNumberOfSeats());
		contentPane.add(getTExecutiveSeats());
		contentPane.add(getTTouristSeats());
		contentPane.add(getTEconomicSeats());
		contentPane.add(getBtnRegisterModels());
		contentPane.add(getSeparator());
		contentPane.add(getBtnEditModels());
		contentPane.add(getBtnRemoveModels());
		contentPane.add(getBtnConsultModel());
		contentPane.add(getBtnShowModel());
		//------------------------------------------
		setDTMTModels(dataTableM, getColumnsNamesM());
		setTModels(dtmTModels);
		setSPTModels(tModels);
		contentPane.add(spTModels);
		contentPane.add(getTaInfo());
		//------------------------------------------
		setVisible(true);
	}
	public JLabel getLModelManag() {
		if (lModelManag == null) {
			lModelManag = new JLabel("Bienvenidos a la Gestión de Modelos");
			lModelManag.setBorder(new LineBorder(new Color(0, 0, 0)));
			lModelManag.setHorizontalAlignment(SwingConstants.CENTER);
			lModelManag.setFont(new Font("Roboto Black", Font.PLAIN, 18));
			lModelManag.setBounds(10, 10, 975, 40);
		}
		return lModelManag;
	}
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Modelo");
			lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			lblNewLabel.setBounds(10, 70, 60, 25);
		}
		return lblNewLabel;
	}
	public JTextField getTWriteModel() {
		if (tWriteModel == null) {
			tWriteModel = new JTextField();
			tWriteModel.setBorder(null);
			tWriteModel.setFont(new Font("Tahoma", Font.PLAIN, 10));
			tWriteModel.setBounds(10, 105, 300, 25);
			tWriteModel.setColumns(10);
		}
		return tWriteModel;
	}
	public JLabel getLAircraftBrand() {
		if (lAircraftBrand == null) {
			lAircraftBrand = new JLabel("Marca de Avión");
			lAircraftBrand.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			lAircraftBrand.setBounds(10, 140, 110, 25);
		}
		return lAircraftBrand;
	}
	@SuppressWarnings("rawtypes")
	public JComboBox getCxBrandAircraft() {
		if (cxBrandAircraft == null) {
			cxBrandAircraft = new JComboBox();
			cxBrandAircraft.setFont(new Font("Tahoma", Font.PLAIN, 14));
			cxBrandAircraft.setBounds(10, 175, 150, 25);
		}
		return cxBrandAircraft;
	}
	public JLabel getLNumberOfSeats() {
		if (lNumberOfSeats == null) {
			lNumberOfSeats = new JLabel("Cantidad de Asientos");
			lNumberOfSeats.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			lNumberOfSeats.setBounds(10, 210, 150, 25);
		}
		return lNumberOfSeats;
	}
	public JTextField getTExecutiveSeats() {
		if (tExecutiveSeats == null) {
			tExecutiveSeats = new JTextField();
			tExecutiveSeats.setBackground(new Color(255,255,255));
			tExecutiveSeats.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if(tExecutiveSeats.getText().equals("Clase Ejecutiva")) {
						tExecutiveSeats.setText("");
						tExecutiveSeats.setForeground(Color.black);
					}
					if(tTouristSeats.getText().isEmpty()) {
						tTouristSeats.setText("Turista");
						tTouristSeats.setForeground(Color.gray);
					}
					if(tEconomicSeats.getText().isEmpty()) {
						tEconomicSeats.setText("Económico");
						tEconomicSeats.setForeground(Color.gray);
					}
				}
			});
			tExecutiveSeats.setForeground(new Color(192, 192, 192));
			tExecutiveSeats.setHorizontalAlignment(SwingConstants.LEFT);
			tExecutiveSeats.setFont(new Font("Tahoma", Font.PLAIN, 14));
			tExecutiveSeats.setText("Clase Ejecutiva");
			tExecutiveSeats.setBounds(10, 245, 150, 25);
			tExecutiveSeats.setColumns(10);
		}
		return tExecutiveSeats;
	}
	public JTextField getTTouristSeats() {
		if (tTouristSeats == null) {
			tTouristSeats = new JTextField();
			tTouristSeats.setBackground(new Color(255,255,255));
			tTouristSeats.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if(tTouristSeats.getText().equals("Turista")) {
						tTouristSeats.setText("");
						tTouristSeats.setForeground(Color.black);
					}
					if(tExecutiveSeats.getText().isEmpty()) {
						tExecutiveSeats.setText("Clase Ejecutiva");
						tExecutiveSeats.setForeground(Color.gray);
					}
					if(tEconomicSeats.getText().isEmpty()) {
						tEconomicSeats.setText("Económico");
						tEconomicSeats.setForeground(Color.gray);
					}
				}
			});
			tTouristSeats.setForeground(new Color(192, 192, 192));
			tTouristSeats.setText("Turista");
			tTouristSeats.setFont(new Font("Tahoma", Font.PLAIN, 14));
			tTouristSeats.setColumns(10);
			tTouristSeats.setBounds(10, 281, 150, 25);
		}
		return tTouristSeats;
	}
	public JTextField getTEconomicSeats() {
		if (tEconomicSeats == null) {
			tEconomicSeats = new JTextField();
			tEconomicSeats.setBackground(new Color(255,255,255));
			tEconomicSeats.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if(tEconomicSeats.getText().equals("Económico")) {
						tEconomicSeats.setText("");
						tEconomicSeats.setForeground(Color.black);
					}
					if(tExecutiveSeats.getText().isEmpty()) {
						tExecutiveSeats.setText("Clase Ejecutiva");
						tExecutiveSeats.setForeground(Color.gray);
					}
					if(tTouristSeats.getText().isEmpty()) {
						tTouristSeats.setText("Turista");
						tTouristSeats.setForeground(Color.gray);
					}
				}
			});
			tEconomicSeats.setForeground(new Color(192, 192, 192));
			tEconomicSeats.setText("Económico");
			tEconomicSeats.setFont(new Font("Tahoma", Font.PLAIN, 14));
			tEconomicSeats.setColumns(10);
			tEconomicSeats.setBounds(10, 316, 150, 25);
		}
		return tEconomicSeats;
	}
	public JButton getBtnRegisterModels() {
		if (btnRegisterModels == null) {
			btnRegisterModels = new JButton("Registrar");
			btnRegisterModels.setContentAreaFilled(false);
			btnRegisterModels.setOpaque(false);
			btnRegisterModels.setHorizontalAlignment(SwingConstants.LEADING);
			btnRegisterModels.setForeground(new Color(0, 0, 128));
			btnRegisterModels.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnRegisterModels.setBorder(null);
			btnRegisterModels.setFont(new Font("Segoe UI", Font.BOLD, 15));
			btnRegisterModels.setBounds(10, 383, 80, 25);
		}
		return btnRegisterModels;
	}
	public JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(10, 130, 300, 1);
		}
		return separator;
	}
	public JButton getBtnEditModels() {
		if (btnEditModels == null) {
			btnEditModels = new JButton("Editar");
			btnEditModels.setContentAreaFilled(false);
			btnEditModels.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnEditModels.setOpaque(false);
			btnEditModels.setForeground(new Color(0, 0, 128));
			btnEditModels.setFont(new Font("Segoe UI", Font.BOLD, 15));
			btnEditModels.setBorder(null);
			btnEditModels.setBounds(120, 383, 80, 25);
		}
		return btnEditModels;
	}
	public JButton getBtnRemoveModels() {
		if (btnRemoveModels == null) {
			btnRemoveModels = new JButton("Eliminar");
			btnRemoveModels.setContentAreaFilled(false);
			btnRemoveModels.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnRemoveModels.setOpaque(false);
			btnRemoveModels.setForeground(new Color(0, 0, 128));
			btnRemoveModels.setFont(new Font("Segoe UI", Font.BOLD, 15));
			btnRemoveModels.setBorder(null);
			btnRemoveModels.setBounds(230, 383, 80, 25);
		}
		return btnRemoveModels;
	}
	public JButton getBtnConsultModel() {
		if (btnConsultModel == null) {
			btnConsultModel = new JButton("Consultar");
			btnConsultModel.setContentAreaFilled(false);
			btnConsultModel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnConsultModel.setOpaque(false);
			btnConsultModel.setForeground(new Color(0, 0, 128));
			btnConsultModel.setFont(new Font("Segoe UI", Font.BOLD, 15));
			btnConsultModel.setBorder(null);
			btnConsultModel.setBounds(446, 383, 80, 25);
		}
		return btnConsultModel;
	}
	public JButton getBtnShowModel() {
		if (btnShowModel == null) {
			btnShowModel = new JButton("Mostrar");
			btnShowModel.setContentAreaFilled(false);
			btnShowModel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnShowModel.setOpaque(false);
			btnShowModel.setForeground(new Color(0, 0, 128));
			btnShowModel.setFont(new Font("Segoe UI", Font.BOLD, 15));
			btnShowModel.setBorder(null);
			btnShowModel.setBounds(905, 383, 80, 25);
		}
		return btnShowModel;
	}
	//------------------------------------------------------------------------------
	public void setDTMTModels(Object data[][], String[] columnsNamesM) {
		dtmTModels = new DefaultTableModel(data, columnsNamesM);
	}
	public DefaultTableModel getDTMTModels() {
		return dtmTModels;
	}
	public void setTModels(DefaultTableModel dtmtModels) {
		tModels = new JTable(dtmTModels);
		tModels.setEnabled(false);
		tModels.getTableHeader().setReorderingAllowed(false);
		tModels.getTableHeader().setResizingAllowed(false);
	}
	public JTable getTModels() {
		return this.tModels;
	}
	public void setSPTModels(JTable tModels) {
		spTModels = new JScrollPane(tModels);
		spTModels.setBackground(new Color(255, 255, 255));
		spTModels.setBounds(445, 130, 540, 245);
	}
	public JScrollPane getSPTModels() {
		return this.spTModels;
	}
	public String[] getColumnsNamesM() {
		String columnsName[] = {"Modelo","Marca","Ejecutivo","Turista","Económico"};
		return columnsName;
	}
	//-------------------------------------------------------------------------------
	public JTextArea getTaInfo() {
		if (taInfo == null) {
			taInfo = new JTextArea();
			taInfo.setForeground(Color.DARK_GRAY);
			taInfo.setLineWrap(true);
			taInfo.setWrapStyleWord(true);
			taInfo.setEditable(false);
			taInfo.setText("Consultar o mostrar los modelos de aviones registrados, se puede hacer individual o grupal, según su preferencia.");
			taInfo.setBounds(445, 73, 540, 54);
		}
		return taInfo;
	}
}
