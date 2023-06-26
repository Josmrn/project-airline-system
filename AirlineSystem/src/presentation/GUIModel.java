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
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import domain.Brands;

@SuppressWarnings("serial")
public class GUIModel extends JInternalFrame {
	
	private JLabel lModelManag;
	private JLabel lblNewLabel;
	private JTextField tWriteModels;
	private JLabel lAircraftBrand;
	private JComboBox<String> cxBrandAircraft;
	private JLabel lNumberOfSeats;
	private JTextField tExecutiveSeats;
	private JTextField tTouristSeats;
	private JTextField tEconomicSeats;
	private JLabel lOperationModels;
	private JButton btnRemoveModels;
	private JButton btnEditModels;
	private JButton btnConsultModel;
	private JButton btnAddModels;
	private DefaultTableModel dtmTModels;
	private JTable tModels;
	private JScrollPane spTModels;
	private Object dataTableM[][];
	private JSeparator separator_1;
	private JTextField tSearchModels;

	

	
	public GUIModel() {
	    getContentPane().setBackground(new Color(255, 255, 255));
	    setTitle("Gestión de Modelos");
	    setMaximizable(true);
	    setIconifiable(true);
	    setClosable(true);
	    setBounds(100, 100, 928, 550);
	    getContentPane().setLayout(null);
	    getContentPane().add(getLModelManag());
	    getContentPane().add(getLblNewLabel());
	    getContentPane().add(getTWriteModels());
	    getContentPane().add(getLAircraftBrand());
	    getContentPane().add(getCxBrandAircraft());
	    getContentPane().add(getLNumberOfSeats());
	    getContentPane().add(getTExecutiveSeats());
	    getContentPane().add(getTTouristSeats());
	    getContentPane().add(getTEconomicSeats());
	    getContentPane().add(getLOperationModels());
	    getContentPane().add(getBtnRemoveModels());
	    getContentPane().add(getBtnEditModels());
	    getContentPane().add(getBtnConsultModel());
	    getContentPane().add(getBtnAddModels());
	    setDTMTModels(dataTableM, getColumnsNamesM());
	    setTModels(dtmTModels);
	    setSPTModels(tModels);
	    getContentPane().add(spTModels);
	    getContentPane().add(getSeparator_1());
	    getContentPane().add(getTSearchModels());

	    //fLXML = new FilesLogicXML(); // Inicializar fLXML
	    
	    setVisible(true);
	}
	
	public JLabel getLModelManag() {
		if (lModelManag == null) {
			lModelManag = new JLabel("Bienvenidos a la Gestión de Modelos");
			lModelManag.setHorizontalAlignment(SwingConstants.CENTER);
			lModelManag.setFont(new Font("Roboto Black", Font.PLAIN, 18));
			lModelManag.setBorder(new LineBorder(new Color(0, 0, 0)));
			lModelManag.setBounds(10, 10, 895, 40);
		}
		return lModelManag;
	}
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Modelo");
			lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			lblNewLabel.setBounds(10, 155, 60, 25);
		}
		return lblNewLabel;
	}
	public JTextField getTWriteModels() {
		if (tWriteModels == null) {
			tWriteModels = new JTextField();
			tWriteModels.setFont(new Font("Tahoma", Font.PLAIN, 14));
			tWriteModels.setColumns(10);
			tWriteModels.setBorder(new LineBorder(new Color(0, 0, 0)));
			tWriteModels.setBounds(10, 178, 255, 25);
		}
		return tWriteModels;
	}
	public JLabel getLAircraftBrand() {
		if (lAircraftBrand == null) {
			lAircraftBrand = new JLabel("Marca de Avión");
			lAircraftBrand.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			lAircraftBrand.setBounds(275, 155, 110, 25);
		}
		return lAircraftBrand;
	}
	
	public JComboBox<String> getCxBrandAircraft() {
		if (cxBrandAircraft == null) {
			cxBrandAircraft = new JComboBox<String>();
			cxBrandAircraft.setFont(new Font("Tahoma", Font.PLAIN, 14));
			cxBrandAircraft.setBounds(275, 178, 150, 25);
		}
		return cxBrandAircraft;
	}
	
	public void fillBrandCXComboBox(ArrayList<Brands> brands) {
	    cxBrandAircraft.addItem("Seleccionar:");

	    for (Brands brand : brands) {
	        cxBrandAircraft.addItem(brand.getNameBrands());
	    }
	}
	
	public JLabel getLNumberOfSeats() {
		if (lNumberOfSeats == null) {
			lNumberOfSeats = new JLabel("Cantidad de Asientos");
			lNumberOfSeats.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			lNumberOfSeats.setBounds(435, 155, 150, 25);
		}
		return lNumberOfSeats;
	}
	public JTextField getTExecutiveSeats() {
		if (tExecutiveSeats == null) {
			tExecutiveSeats = new JTextField();
			tExecutiveSeats.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
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
			tExecutiveSeats.setText("Clase Ejecutiva");
			tExecutiveSeats.setHorizontalAlignment(SwingConstants.LEFT);
			tExecutiveSeats.setForeground(Color.LIGHT_GRAY);
			tExecutiveSeats.setFont(new Font("Tahoma", Font.PLAIN, 14));
			tExecutiveSeats.setColumns(10);
			tExecutiveSeats.setBackground(Color.WHITE);
			tExecutiveSeats.setBounds(435, 178, 150, 25);
		}
		return tExecutiveSeats;
	}
	public JTextField getTTouristSeats() {
		if (tTouristSeats == null) {
			tTouristSeats = new JTextField();
			tTouristSeats.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
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
			tTouristSeats.setText("Turista");
			tTouristSeats.setForeground(Color.LIGHT_GRAY);
			tTouristSeats.setFont(new Font("Tahoma", Font.PLAIN, 14));
			tTouristSeats.setColumns(10);
			tTouristSeats.setBackground(Color.WHITE);
			tTouristSeats.setBounds(595, 178, 150, 25);
		}
		return tTouristSeats;
	}
	public JTextField getTEconomicSeats() {
		if (tEconomicSeats == null) {
			tEconomicSeats = new JTextField();
			tEconomicSeats.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					if(tEconomicSeats.getText().equals("Económico")) {
						tEconomicSeats.setText("");
						tEconomicSeats.setForeground(Color.black);
					}
					if(tTouristSeats.getText().isEmpty()) {
						tTouristSeats.setText("Turista");
						tTouristSeats.setForeground(Color.gray);
					}
					if(tExecutiveSeats.getText().isEmpty()) {
						tExecutiveSeats.setText("Clase Ejecutiva");
						tExecutiveSeats.setForeground(Color.gray);
					}
				}
			});
			tEconomicSeats.setText("Económico");
			tEconomicSeats.setForeground(Color.LIGHT_GRAY);
			tEconomicSeats.setFont(new Font("Tahoma", Font.PLAIN, 14));
			tEconomicSeats.setColumns(10);
			tEconomicSeats.setBackground(Color.WHITE);
			tEconomicSeats.setBounds(755, 178, 150, 25);
		}
		return tEconomicSeats;
	}
	public JLabel getLOperationModels() {
		if (lOperationModels == null) {
			lOperationModels = new JLabel("Operaciones");
			lOperationModels.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			lOperationModels.setFont(new Font("Segoe UI", Font.BOLD, 15));
			lOperationModels.setBounds(10, 75, 895, 25);
		}
		return lOperationModels;
	}
	public JButton getBtnRemoveModels() {
		if (btnRemoveModels == null) {
			btnRemoveModels = new JButton("Eliminar");
			btnRemoveModels.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnRemoveModels.setIcon(new ImageIcon(GUIModel.class.getResource("/images/icons_remove.png")));
			btnRemoveModels.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnRemoveModels.setOpaque(false);
			btnRemoveModels.setForeground(new Color(0, 0, 128));
			btnRemoveModels.setFont(new Font("Segoe UI", Font.BOLD, 15));
			btnRemoveModels.setContentAreaFilled(false);
			btnRemoveModels.setBorder(null);
			btnRemoveModels.setBounds(150, 110, 90, 35);
		}
		return btnRemoveModels;
	}
	public JButton getBtnEditModels() {
		if (btnEditModels == null) {
			btnEditModels = new JButton("Editar");
			btnEditModels.setIcon(new ImageIcon(GUIModel.class.getResource("/images/icons_edit.png")));
			btnEditModels.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnEditModels.setOpaque(false);
			btnEditModels.setForeground(new Color(0, 0, 128));
			btnEditModels.setFont(new Font("Segoe UI", Font.BOLD, 15));
			btnEditModels.setContentAreaFilled(false);
			btnEditModels.setBorder(null);
			btnEditModels.setBounds(10, 110, 80, 35);
		}
		return btnEditModels;
	}
	public JButton getBtnConsultModel() {
		if (btnConsultModel == null) {
			btnConsultModel = new JButton("Consultar");
			btnConsultModel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnConsultModel.setHorizontalAlignment(SwingConstants.LEFT);
			btnConsultModel.setIcon(new ImageIcon(GUIModel.class.getResource("/images/icons_consult.png")));
			btnConsultModel.setOpaque(false);
			btnConsultModel.setForeground(new Color(0, 0, 128));
			btnConsultModel.setFont(new Font("Segoe UI", Font.BOLD, 15));
			btnConsultModel.setContentAreaFilled(false);
			btnConsultModel.setBorder(null);
			btnConsultModel.setBounds(785, 110, 120, 35);
		}
		return btnConsultModel;
	}
	public JButton getBtnAddModels() {
		if (btnAddModels == null) {
			btnAddModels = new JButton("Agregar");
			btnAddModels.setIcon(new ImageIcon(GUIModel.class.getResource("/images/icons_add.png")));
			btnAddModels.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnAddModels.setOpaque(false);
			btnAddModels.setHorizontalAlignment(SwingConstants.LEADING);
			btnAddModels.setForeground(new Color(0, 0, 128));
			btnAddModels.setFont(new Font("Segoe UI", Font.BOLD, 16));
			btnAddModels.setContentAreaFilled(false);
			btnAddModels.setBorder(null);
			btnAddModels.setBounds(350, 110, 110, 35);
		}
		return btnAddModels;
	}
	public void setDTMTModels(Object data[][], String[] columnsNamesM) {
		dtmTModels = new DefaultTableModel(data, columnsNamesM);
	}
	public DefaultTableModel getDTMTModels() {
		return dtmTModels;
	}
	public void setTModels(DefaultTableModel dtmtModels) {
		tModels = new JTable(dtmTModels);
		tModels.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tModels.setEnabled(false);
		tModels.getTableHeader().setReorderingAllowed(false);
		tModels.getTableHeader().setResizingAllowed(false);
	}
	public JTable getTModels() {
		return this.tModels;
	}
	public void setSPTModels(JTable tModels) {
		spTModels = new JScrollPane(tModels);
		spTModels.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Datos de modelos registrados", TitledBorder.LEFT, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		spTModels.setFont(new Font("Tahoma", Font.PLAIN, 11));
		spTModels.setToolTipText("");
		spTModels.setBackground(new Color(255, 255, 255));
		spTModels.setBounds(10, 231, 895, 280);
	}
	public JScrollPane getSPTModels() {
		return this.spTModels;
	}
	public String[] getColumnsNamesM() {
		String columnsName[] = {"Modelo","Marca","Ejecutivo","Turista","Económico"};
		return columnsName;
	}
	public JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
			separator_1.setBounds(10, 150, 895, 1);
		}
		return separator_1;
	}
	public JTextField getTSearchModels() {
		if (tSearchModels == null) {
			tSearchModels = new JTextField();
			tSearchModels.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			tSearchModels.setForeground(new Color(192, 192, 192));
			tSearchModels.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if(tSearchModels.getText().equals("Escribir el modelo que desea consultar")) {
						tSearchModels.setText("");
						tSearchModels.setForeground(Color.black);
					}
				}
			});
			tSearchModels.setText("Escribir el modelo que desea consultar/mostrar");
			tSearchModels.setFont(new Font("Tahoma", Font.PLAIN, 12));
			tSearchModels.setBounds(470, 115, 300, 30);
			tSearchModels.setColumns(10);
		}
		return tSearchModels;
	}
	
	public void cleanForm() {
		tWriteModels.setText("");
		cxBrandAircraft.setSelectedIndex(0);
		tExecutiveSeats.setText("");
		tTouristSeats.setText("");
		tEconomicSeats.setText("");
		
	}
}
