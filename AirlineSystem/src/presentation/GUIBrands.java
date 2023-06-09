package presentation;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;
import javax.swing.border.EtchedBorder;

@SuppressWarnings("serial")
public class GUIBrands extends JInternalFrame {
	private JLabel lWelcomeBrand;
	private JLabel lNameBrands;
	private JTextField tAddBrand;
	private JButton btnRegisterBrand;
	private JLabel lTextBrandsReg;
	private JButton btnConsultBrand;
	private JButton btnEditBrands;
	private JButton btnRemoveBrand;

	private DefaultTableModel dtmTBrands;
	private JTable tBrands;

	private JScrollPane spTBrands;
	private Object dataTable[][];
	private JLabel lOperationUser;
	private JTextField tWriteBrand;

	public GUIBrands(String userType) {
		getContentPane().setBackground(Color.WHITE);
		setTitle("Registro de Marcas");
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 524, 669);
		getContentPane().setLayout(null);
		getContentPane().add(getLWelcomeBrand());
		getContentPane().add(getLNameBrands());
		getContentPane().add(getTAddBrand());
		getContentPane().add(getBtnRegisterBrand());
		getContentPane().add(getLTextBrandsReg());
		getContentPane().add(getBtnConsultBrand());
		getContentPane().add(getBtnEditBrands(userType));
		getContentPane().add(getBtnRemoveBrand(userType));
		setDTMTBrands(dataTable, getColumnsNames());
		setTBrands(dtmTBrands);
		setSPTBrands(tBrands);
		getContentPane().add(spTBrands);
		getContentPane().add(getLOperationUser());
		getContentPane().add(getTWriteBrand());
		setVisible(true);
	}

	public JLabel getLWelcomeBrand() {
		if (lWelcomeBrand == null) {
			lWelcomeBrand = new JLabel("Bienvenido a Gestión de Marcas de Aviones");
			lWelcomeBrand.setForeground(new Color(255, 255, 255));
			lWelcomeBrand.setOpaque(true);
			lWelcomeBrand.setHorizontalAlignment(SwingConstants.CENTER);
			lWelcomeBrand.setFont(new Font("Roboto Black", Font.PLAIN, 18));
			lWelcomeBrand.setBorder(new LineBorder(new Color(0, 0, 0)));
			lWelcomeBrand.setBackground(new Color(0, 102, 204));
			lWelcomeBrand.setBounds(10, 10, 472, 40);
		}
		return lWelcomeBrand;
	}

	public JLabel getLNameBrands() {
		if (lNameBrands == null) {
			lNameBrands = new JLabel("Ingrese la Marca del Avión");
			lNameBrands.setHorizontalAlignment(SwingConstants.LEFT);
			lNameBrands.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			lNameBrands.setBackground(new Color(0, 128, 128));
			lNameBrands.setBounds(10, 80, 200, 25);
		}
		return lNameBrands;
	}

	public JTextField getTAddBrand() {
		if (tAddBrand == null) {
			tAddBrand = new JTextField();
			tAddBrand.setColumns(10);
			tAddBrand.setBorder(new LineBorder(new Color(0, 0, 0)));
			tAddBrand.setBounds(10, 113, 300, 30);
		}
		return tAddBrand;
	}

	public JButton getBtnRegisterBrand() {
		if (btnRegisterBrand == null) {
			btnRegisterBrand = new JButton("Registrar");
			btnRegisterBrand.setIcon(new ImageIcon(GUIBrands.class.getResource("/images/icons_add.png")));
			btnRegisterBrand.setHorizontalAlignment(SwingConstants.LEFT);
			btnRegisterBrand.setOpaque(false);
			btnRegisterBrand.setForeground(new Color(0, 0, 128));
			btnRegisterBrand.setFont(new Font("Segoe UI", Font.BOLD, 15));
			btnRegisterBrand.setContentAreaFilled(false);
			btnRegisterBrand.setBorder(null);
			btnRegisterBrand.setBackground(new Color(95, 158, 160));
			btnRegisterBrand.setBounds(10, 232, 100, 25);
		}
		return btnRegisterBrand;
	}

	public JLabel getLTextBrandsReg() {
		if (lTextBrandsReg == null) {
			lTextBrandsReg = new JLabel("Marcas registradas");
			lTextBrandsReg.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			lTextBrandsReg.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			lTextBrandsReg.setBounds(10, 348, 132, 25);
		}
		return lTextBrandsReg;
	}

	public JButton getBtnConsultBrand() {
		if (btnConsultBrand == null) {
			btnConsultBrand = new JButton("Consultar");
			btnConsultBrand.setIcon(new ImageIcon(GUIBrands.class.getResource("/images/icons_consult.png")));
			btnConsultBrand.setOpaque(false);
			btnConsultBrand.setForeground(new Color(0, 0, 128));
			btnConsultBrand.setFont(new Font("Segoe UI", Font.BOLD, 15));
			btnConsultBrand.setContentAreaFilled(false);
			btnConsultBrand.setBorder(null);
			btnConsultBrand.setBounds(373, 285, 109, 28);
		}
		return btnConsultBrand;
	}

	public JButton getBtnEditBrands(String userType) {
		if (btnEditBrands == null) {
			
			if(userType.equals("Administrador")) {
				btnEditBrands = new JButton("Editar");
				btnEditBrands.setIcon(new ImageIcon(GUIBrands.class.getResource("/images/icons_edit.png")));
				btnEditBrands.setOpaque(false);
				btnEditBrands.setForeground(new Color(0, 0, 128));
				btnEditBrands.setFont(new Font("Segoe UI", Font.BOLD, 15));
				btnEditBrands.setContentAreaFilled(false);
				btnEditBrands.setBorder(null);
				btnEditBrands.setBounds(378, 232, 84, 25);
			}else if(userType.equals("Colaborador")) {
				btnEditBrands = new JButton("Editar");
				btnEditBrands.setIcon(new ImageIcon(GUIBrands.class.getResource("/images/icons_edit.png")));
				btnEditBrands.setOpaque(false);
				btnEditBrands.setForeground(new Color(0, 0, 128));
				btnEditBrands.setFont(new Font("Segoe UI", Font.BOLD, 15));
				btnEditBrands.setContentAreaFilled(false);
				btnEditBrands.setBorder(null);
				btnEditBrands.setBounds(378, 232, 84, 25);
				btnEditBrands.setVisible(false);
			}
			
		}
		return btnEditBrands;
	}

	public JButton getBtnRemoveBrand(String userType) {
		if (btnRemoveBrand == null) {
			
			if(userType.equals("Administrador")) {
				btnRemoveBrand = new JButton("Eliminar");
				btnRemoveBrand.setIcon(new ImageIcon(GUIBrands.class.getResource("/images/icons_remove.png")));
				btnRemoveBrand.setOpaque(false);
				btnRemoveBrand.setForeground(new Color(0, 0, 128));
				btnRemoveBrand.setFont(new Font("Segoe UI", Font.BOLD, 15));
				btnRemoveBrand.setContentAreaFilled(false);
				btnRemoveBrand.setBorder(null);
				btnRemoveBrand.setBounds(10, 285, 88, 25);
			}else if(userType.equals("Colaborador")) {
				btnRemoveBrand = new JButton("Eliminar");
				btnRemoveBrand.setIcon(new ImageIcon(GUIBrands.class.getResource("/images/icons_remove.png")));
				btnRemoveBrand.setOpaque(false);
				btnRemoveBrand.setForeground(new Color(0, 0, 128));
				btnRemoveBrand.setFont(new Font("Segoe UI", Font.BOLD, 15));
				btnRemoveBrand.setContentAreaFilled(false);
				btnRemoveBrand.setBorder(null);
				btnRemoveBrand.setBounds(10, 285, 88, 25);
				btnRemoveBrand.setVisible(false);
			}
			
			
		}
		return btnRemoveBrand;
	}

	public void setDTMTBrands(Object data[][], String[] columnsNames) {
		dtmTBrands = new DefaultTableModel(data, columnsNames);
	}

	public DefaultTableModel getDTMTBrands() {
		return dtmTBrands;
	}

	public void setTBrands(DefaultTableModel dtmTBrands) {
	    tBrands = new JTable(dtmTBrands);
	    tBrands.setEnabled(false);
	    tBrands.getTableHeader().setReorderingAllowed(false);
	    tBrands.getTableHeader().setResizingAllowed(false);
	}

	public JTable getTBrands() {
		return this.tBrands;
	}

	public void setSPTBrands(JTable tBrands) {
		spTBrands = new JScrollPane(tBrands);
		spTBrands.setBounds(10, 383, 452, 247);
	}

	public JScrollPane getSPTPeople() {
		return this.spTBrands;
	}

	public String[] getColumnsNames() {
		String columnsName[] = { "Marca de Avión" };
		return columnsName;
	}

	public void cleanForm() {
		tAddBrand.setText("");
	}

	public JLabel getLOperationUser() {
		if (lOperationUser == null) {
			lOperationUser = new JLabel("Operaciones");
			lOperationUser.setFont(new Font("Segoe UI", Font.BOLD, 15));
			lOperationUser.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			lOperationUser.setBounds(10, 190, 472, 25);
		}
		return lOperationUser;
	}

	public JTextField getTWriteBrand() {
		if (tWriteBrand == null) {
			tWriteBrand = new JTextField();
			tWriteBrand.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent e) {
					if (tWriteBrand.getText().equals("Escribir la marca de avión que desea eliminar y/o consultar")) {
						tWriteBrand.setText("");
						tWriteBrand.setForeground(Color.black);
					}
				}
			});
			tWriteBrand.setText("Escribir la marca de avión que desea eliminar y/o consultar");
			tWriteBrand.setForeground(Color.LIGHT_GRAY);
			tWriteBrand.setFont(new Font("Tahoma", Font.PLAIN, 12));
			tWriteBrand.setColumns(10);
			tWriteBrand.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			tWriteBrand.setBounds(105, 285, 258, 30);
		}
		return tWriteBrand;
	}
}
