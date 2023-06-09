package presentation;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Cursor;
import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import java.awt.CardLayout;
import java.awt.Font;

@SuppressWarnings("serial")

public class GUIMain extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mUsers;
	private JMenu mBrand;
	private JMenu mModels;
	private JMenu mAirlines;
	private JMenuItem miUsersManag;
	private JMenu mAircraft;
	private JMenu mFlight;
	private JMenu mPassenger;
	private JMenu mTickets;
	private JMenu mHelp;
	private JMenuItem miAboutAdmin;
	private JMenuItem miAboutColab;
	private JMenuItem miExit;
	private JMenuItem miAddBrand;
	private JMenuItem miEditModels;
	private JMenuItem miManageAirline;
	private JMenuItem miManageAircraft;
	private JMenuItem miManageFlight;
	private JMenuItem miManagePassenger;
	private JMenuItem miManageTickets;
	private JMenuItem miPrintTicket;
	private JMenuItem miTicketsHistory;
	private JMenuItem miConsultflight;
	private JSeparator separator;
	private JSeparator separator_1;
	private JDesktopPane desktopMain;
	private JMenu mManagement;
	private JMenu mOperations;

	public GUIMain(String userType) {

		if (userType.equals("Administrador")) {
			setTitle("Airline Software");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 550, 500);
			setJMenuBar(getMenuBar_1(userType));
			contentPane = new JPanel();
			contentPane.setBackground(Color.WHITE);
			contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

			setContentPane(contentPane);
			contentPane.setLayout(new CardLayout(0, 0));
			contentPane.add(getDesktopMain(), "name_264125534228499");
			// contentPane.setLayout(null);
			setExtendedState(MAXIMIZED_BOTH);
			setLocationRelativeTo(null);
			setVisible(true);
		} else if (userType.equals("Colaborador")) {
			setTitle("Airline Software");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 550, 500);
			setJMenuBar(getMenuBar_1(userType));
			contentPane = new JPanel();
			contentPane.setBackground(Color.WHITE);
			contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

			setContentPane(contentPane);
			contentPane.setLayout(new CardLayout(0, 0));
			contentPane.add(getDesktopMain(), "name_264125534228499");
			// contentPane.setLayout(null);
			setExtendedState(MAXIMIZED_BOTH);
			setLocationRelativeTo(null);
			setVisible(true);
		}

	}

	public JMenuBar getMenuBar_1(String userType) {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.setBorderPainted(false);
			menuBar.add(getMManagement(userType));
			menuBar.add(getMOperations());
			menuBar.add(getMHelp(userType));
		}
		return menuBar;
	}

	public JMenu getMUsers(String userType) {
		if (mUsers == null) {
			if (userType.equals("Administrador")) {
				mUsers = new JMenu("Usuarios");
				mUsers.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				mUsers.add(getMiUsersManag());
			} else {
				mUsers = new JMenu("Usuarios");
				mUsers.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				mUsers.add(getMiUsersManag());
				mUsers.setVisible(false);
			}
		}
		return mUsers;
	}

	public JMenu getMBrand() {
		if (mBrand == null) {
			mBrand = new JMenu("Marcas");
			mBrand.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			mBrand.add(getMiAddBrand());
		}
		return mBrand;
	}

	public JMenu getMModels() {
		if (mModels == null) {
			mModels = new JMenu("Modelos");
			mModels.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			mModels.add(getMiEditModels());
		}
		return mModels;
	}

	public JMenu getMAirlines() {
		if (mAirlines == null) {
			mAirlines = new JMenu("Aerolíneas");
			mAirlines.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			mAirlines.add(getMiManageAirline());
		}
		return mAirlines;
	}

	public JMenuItem getMiUsersManag() {
		if (miUsersManag == null) {
			miUsersManag = new JMenuItem("Gestión Cuentas Usuarios ");
			miUsersManag.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		}
		return miUsersManag;
	}

	public JMenu getMAircraft() {
		if (mAircraft == null) {
			mAircraft = new JMenu("Aviones");
			mAircraft.add(getMiManageAircraft());
		}
		return mAircraft;
	}

	public JMenu getMFlight() {
		if (mFlight == null) {
			mFlight = new JMenu("Vuelos");
			mFlight.add(getMiManageFlight());
		}
		return mFlight;
	}

	public JMenu getMPassenger() {
		if (mPassenger == null) {
			mPassenger = new JMenu("Pasajeros");
			mPassenger.add(getMiManagePassenger());
		}
		return mPassenger;
	}

	public JMenu getMTickets() {
		if (mTickets == null) {
			mTickets = new JMenu("Tiquetes");
			mTickets.add(getMiManageTickets());
		}
		return mTickets;
	}

	public JMenu getMHelp(String userType) {
		if (mHelp == null) {
			if (userType.equals("Administrador")) {
				mHelp = new JMenu("Ayuda");
				mHelp.setFont(new Font("Roboto Black", Font.PLAIN, 15));
				mHelp.add(getMiAboutAdmin(userType));
				mHelp.add(getMiAboutColab());
				mHelp.add(getMiExit());
			} else if (userType.equals("Colaborador")) {
				mHelp = new JMenu("Ayuda");
				mHelp.setFont(new Font("Roboto Black", Font.PLAIN, 15));
				mHelp.add(getMiAboutAdmin(userType));
				mHelp.add(getMiAboutColab());
				mHelp.add(getMiExit());
			}
		}
		return mHelp;
	}

	public JMenuItem getMiAboutAdmin(String userType) {
		if (miAboutAdmin == null) {
			if (userType.equals("Administrador")) {
				miAboutAdmin = new JMenuItem("Acerca de Administrador");
			} else if (userType.equals("Colaborador")) {
				miAboutAdmin = new JMenuItem("Acerca de Administrador");
				miAboutAdmin.setVisible(false);
			}
		}
		return miAboutAdmin;
	}

	public JMenuItem getMiAboutColab() {
		if (miAboutColab == null) {
			miAboutColab = new JMenuItem("Acerca de Colaborador");
		}
		return miAboutColab;
	}

	public JMenuItem getMiExit() {
		if (miExit == null) {
			miExit = new JMenuItem("Salir");
			miExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return miExit;
	}

	public JMenuItem getMiAddBrand() {
		if (miAddBrand == null) {
			miAddBrand = new JMenuItem("Gestión de Marcas");
			miAddBrand.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		}
		return miAddBrand;
	}

	public JMenuItem getMiEditModels() {
		if (miEditModels == null) {
			miEditModels = new JMenuItem("Gestión de Modelos");
			miEditModels.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		}
		return miEditModels;
	}

	public JMenuItem getMiManageAirline() {
		if (miManageAirline == null) {
			miManageAirline = new JMenuItem("Gestión de Aerolíneas");
		}
		return miManageAirline;
	}

	public JMenuItem getMiManageAircraft() {
		if (miManageAircraft == null) {
			miManageAircraft = new JMenuItem("Gestión de Aviones");
		}
		return miManageAircraft;
	}

	public JMenuItem getMiManageFlight() {
		if (miManageFlight == null) {
			miManageFlight = new JMenuItem("Gestión de Vuelos");
		}
		return miManageFlight;
	}

	public JMenuItem getMiManagePassenger() {
		if (miManagePassenger == null) {
			miManagePassenger = new JMenuItem("Gestión de Pasajeros");
		}
		return miManagePassenger;
	}

	public JMenuItem getMiManageTickets() {
		if (miManageTickets == null) {
			miManageTickets = new JMenuItem("Gestion de Tiquetes");
		}
		return miManageTickets;
	}

	public JMenuItem getMiPrintTicket() {
		if (miPrintTicket == null) {
			miPrintTicket = new JMenuItem("Imprimir Tiquete");
		}
		return miPrintTicket;
	}

	public JMenuItem getMiTicketsHistory() {
		if (miTicketsHistory == null) {
			miTicketsHistory = new JMenuItem("Registros de tiquetes");
		}
		return miTicketsHistory;
	}

	public JMenuItem getMiConsultFlight() {
		if (miConsultflight == null) {
			miConsultflight = new JMenuItem("Registros de vuelos");
		}
		return miConsultflight;
	}

	public JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
		}
		return separator;
	}

	public JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
		}
		return separator_1;
	}

	public JDesktopPane getDesktopMain() {
		if (desktopMain == null) {
			desktopMain = new JDesktopPane();
			desktopMain.setBackground(new Color(255, 255, 255));
		}
		return desktopMain;
	}

	public JMenu getMManagement(String userType) {
		if (mManagement == null) {
			mManagement = new JMenu("Gestiones");
			mManagement.setFont(new Font("Roboto Black", Font.PLAIN, 15));
			mManagement.add(getMUsers(userType));
			mManagement.add(getMBrand());
			mManagement.add(getMModels());
			mManagement.add(getMAirlines());
			mManagement.add(getMAircraft());
			mManagement.add(getMFlight());
			mManagement.add(getMPassenger());
			mManagement.add(getMTickets());
		}
		return mManagement;
	}

	public JMenu getMOperations() {
		if (mOperations == null) {
			mOperations = new JMenu("Operaciones");
			mOperations.setFont(new Font("Roboto Black", Font.PLAIN, 15));
			mOperations.add(getMiPrintTicket());
			mOperations.add(getMiTicketsHistory());
			mOperations.add(getMiConsultFlight());
		}
		return mOperations;
	}
}
