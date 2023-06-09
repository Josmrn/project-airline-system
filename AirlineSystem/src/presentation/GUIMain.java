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
	private JMenuItem miAbout;
	private JMenuItem miExit;
	private JMenuItem miEditBrand;
	private JMenuItem miEditModels;
	private JMenuItem miEditAirline;
	private JMenuItem miEditAircraft;
	private JMenuItem miEditFlight;
	private JMenuItem miEditPassenger;
	private JMenuItem miEditTickets;
	private JMenuItem miPrintTicket;
	private JMenuItem miTicketsHistory;
	private JMenuItem miConsult;
	private JSeparator separator;
	private JSeparator separator_1;
	private JMenuItem miCreateUser;
	private JMenuItem miSearchUsers;
	private JMenuItem miAddBrand;
	private JMenuItem miSearchBrand;
	private JMenuItem miAddModels;
	private JMenuItem miSearchModels;
	private JMenuItem miAddAirline;
	private JMenuItem miSearchAirline;
	private JMenuItem miAddAircraft;
	private JMenuItem miSearchAircraft;
	private JMenuItem miAddFlight;
	private JMenuItem miSearchFlight;
	private JMenuItem miAddPassenger;
	private JMenuItem miSearchPassenger;
	private JMenuItem miAddTickets;
	private JMenuItem miSearchTickets;
	
	public GUIMain() {
		setTitle("Airline Software");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setSize(getMaximumSize());
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMUsers());
			menuBar.add(getMBrand());
			menuBar.add(getMModels());
			menuBar.add(getMAirlines());
			menuBar.add(getMAircraft());
			menuBar.add(getMFlight());
			menuBar.add(getMPassenger());
			menuBar.add(getMTickets());
			menuBar.add(getMHelp());
		}
		return menuBar;
	}
	public JMenu getMUsers() {
		if (mUsers == null) {
			mUsers = new JMenu("Usuarios");
			mUsers.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			mUsers.add(getMiUsersManag());
			mUsers.add(getMiCreateUser());
			mUsers.add(getMiSearchUsers());
		}
		return mUsers;
	}
	public JMenu getMBrand() {
		if (mBrand == null) {
			mBrand = new JMenu("Marcas");
			mBrand.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			mBrand.add(getMiEditBrand());
			mBrand.add(getMiAddBrand());
			mBrand.add(getMiSearchBrand());
		}
		return mBrand;
	}
	public JMenu getMModels() {
		if (mModels == null) {
			mModels = new JMenu("Modelos");
			mModels.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			mModels.add(getMiEditModels());
			mModels.add(getMiAddModels());
			mModels.add(getMiSearchModels());
		}
		return mModels;
	}
	public JMenu getMAirlines() {
		if (mAirlines == null) {
			mAirlines = new JMenu("Aerolíneas");
			mAirlines.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			mAirlines.add(getMiEditAirline());
			mAirlines.add(getMiAddAirline());
			mAirlines.add(getMiSearchAirline());
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
			mAircraft.add(getMiEditAircraft());
			mAircraft.add(getMiAddAircraft());
			mAircraft.add(getMiSearchAircraft());
		}
		return mAircraft;
	}
	public JMenu getMFlight() {
		if (mFlight == null) {
			mFlight = new JMenu("Vuelos");
			mFlight.add(getMiEditFlight());
			mFlight.add(getMiAddFlight());
			mFlight.add(getMiSearchFlight());
			mFlight.add(getSeparator_1());
			mFlight.add(getMiConsult());
		}
		return mFlight;
	}
	public JMenu getMPassenger() {
		if (mPassenger == null) {
			mPassenger = new JMenu("Pasajeros");
			mPassenger.add(getMiEditPassenger());
			mPassenger.add(getMiAddPassenger());
			mPassenger.add(getMiSearchPassenger());
		}
		return mPassenger;
	}
	public JMenu getMTickets() {
		if (mTickets == null) {
			mTickets = new JMenu("Tiquetes");
			mTickets.add(getMiEditTickets());
			mTickets.add(getMiAddTickets());
			mTickets.add(getMiSearchTickets());
			mTickets.add(getSeparator());
			mTickets.add(getMiPrintTicket());
			mTickets.add(getMiTicketsHistory());
		}
		return mTickets;
	}
	public JMenu getMHelp() {
		if (mHelp == null) {
			mHelp = new JMenu("Ayuda");
			mHelp.add(getMiAbout());
			mHelp.add(getMiExit());
		}
		return mHelp;
	}
	public JMenuItem getMiAbout() {
		if (miAbout == null) {
			miAbout = new JMenuItem("Acerca de");
		}
		return miAbout;
	}
	public JMenuItem getMiExit() {
		if (miExit == null) {
			miExit = new JMenuItem("Salir");
		}
		return miExit;
	}
	public JMenuItem getMiEditBrand() {
		if (miEditBrand == null) {
			miEditBrand = new JMenuItem("Gestión de Marcas");
			miEditBrand.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		}
		return miEditBrand;
	}
	public JMenuItem getMiEditModels() {
		if (miEditModels == null) {
			miEditModels = new JMenuItem("Gestión de Marcas");
			miEditModels.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		}
		return miEditModels;
	}
	public JMenuItem getMiEditAirline() {
		if (miEditAirline == null) {
			miEditAirline = new JMenuItem("Gestión de Aerolíneas");
		}
		return miEditAirline;
	}
	public JMenuItem getMiEditAircraft() {
		if (miEditAircraft == null) {
			miEditAircraft = new JMenuItem("Gestión de Aviones");
		}
		return miEditAircraft;
	}
	public JMenuItem getMiEditFlight() {
		if (miEditFlight == null) {
			miEditFlight = new JMenuItem("Gestión de Vuelos");
		}
		return miEditFlight;
	}
	public JMenuItem getMiEditPassenger() {
		if (miEditPassenger == null) {
			miEditPassenger = new JMenuItem("Gestión de Pasajeros");
		}
		return miEditPassenger;
	}
	public JMenuItem getMiEditTickets() {
		if (miEditTickets == null) {
			miEditTickets = new JMenuItem("Gestion de Tiquetes");
		}
		return miEditTickets;
	}
	public JMenuItem getMiPrintTicket() {
		if (miPrintTicket == null) {
			miPrintTicket = new JMenuItem("Imprimir Tiquete");
		}
		return miPrintTicket;
	}
	public JMenuItem getMiTicketsHistory() {
		if (miTicketsHistory == null) {
			miTicketsHistory = new JMenuItem("Historial ");
		}
		return miTicketsHistory;
	}
	public JMenuItem getMiConsult() {
		if (miConsult == null) {
			miConsult = new JMenuItem("Consultar Vuelos");
		}
		return miConsult;
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
	public JMenuItem getMiCreateUser() {
		if (miCreateUser == null) {
			miCreateUser = new JMenuItem("Crear Usuario");
		}
		return miCreateUser;
	}
	public JMenuItem getMiSearchUsers() {
		if (miSearchUsers == null) {
			miSearchUsers = new JMenuItem("Buscar ");
		}
		return miSearchUsers;
	}
	public JMenuItem getMiAddBrand() {
		if (miAddBrand == null) {
			miAddBrand = new JMenuItem("Agregar");
		}
		return miAddBrand;
	}
	public JMenuItem getMiSearchBrand() {
		if (miSearchBrand == null) {
			miSearchBrand = new JMenuItem("Buscar");
		}
		return miSearchBrand;
	}
	public JMenuItem getMiAddModels() {
		if (miAddModels == null) {
			miAddModels = new JMenuItem("Agregar");
		}
		return miAddModels;
	}
	public JMenuItem getMiSearchModels() {
		if (miSearchModels == null) {
			miSearchModels = new JMenuItem("Buscar");
		}
		return miSearchModels;
	}
	public JMenuItem getMiAddAirline() {
		if (miAddAirline == null) {
			miAddAirline = new JMenuItem("Agregar");
		}
		return miAddAirline;
	}
	public JMenuItem getMiSearchAirline() {
		if (miSearchAirline == null) {
			miSearchAirline = new JMenuItem("Buscar");
		}
		return miSearchAirline;
	}
	public JMenuItem getMiAddAircraft() {
		if (miAddAircraft == null) {
			miAddAircraft = new JMenuItem("Agregar");
		}
		return miAddAircraft;
	}
	public JMenuItem getMiSearchAircraft() {
		if (miSearchAircraft == null) {
			miSearchAircraft = new JMenuItem("Buscar");
		}
		return miSearchAircraft;
	}
	public JMenuItem getMiAddFlight() {
		if (miAddFlight == null) {
			miAddFlight = new JMenuItem("Agregar");
		}
		return miAddFlight;
	}
	public JMenuItem getMiSearchFlight() {
		if (miSearchFlight == null) {
			miSearchFlight = new JMenuItem("Buscar");
		}
		return miSearchFlight;
	}
	public JMenuItem getMiAddPassenger() {
		if (miAddPassenger == null) {
			miAddPassenger = new JMenuItem("Agregar");
		}
		return miAddPassenger;
	}
	public JMenuItem getMiSearchPassenger() {
		if (miSearchPassenger == null) {
			miSearchPassenger = new JMenuItem("Buscar");
		}
		return miSearchPassenger;
	}
	public JMenuItem getMiAddTickets() {
		if (miAddTickets == null) {
			miAddTickets = new JMenuItem("Agregar");
		}
		return miAddTickets;
	}
	public JMenuItem getMiSearchTickets() {
		if (miSearchTickets == null) {
			miSearchTickets = new JMenuItem("Buscar");
		}
		return miSearchTickets;
	}
}
