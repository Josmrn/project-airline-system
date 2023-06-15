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
	private JMenuItem miAddBrand;
	private JMenuItem miAddAirline;
	private JMenuItem miAddAircraft;
	private JMenuItem miAddFlight;
	private JMenuItem miAddPassenger;
	private JMenuItem miAddTickets;
	private JDesktopPane desktopMain;
	
	public GUIMain() {
		setTitle("Airline Software");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 500);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		contentPane.add(getDesktopMain(), "name_264125534228499");
		//contentPane.setLayout(null);
		setExtendedState(MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.setBorderPainted(false);
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
			mUsers.add(getMiCreateUser());
			mUsers.add(getMiUsersManag());
		}
		return mUsers;
	}
	public JMenu getMBrand() {
		if (mBrand == null) {
			mBrand = new JMenu("Marcas");
			mBrand.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			mBrand.add(getMiAddBrand());
			mBrand.add(getMiEditBrand());
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
			mAirlines.add(getMiAddAirline());
			mAirlines.add(getMiEditAirline());
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
			mAircraft.add(getMiAddAircraft());
			mAircraft.add(getMiEditAircraft());
		}
		return mAircraft;
	}
	public JMenu getMFlight() {
		if (mFlight == null) {
			mFlight = new JMenu("Vuelos");
			mFlight.add(getMiAddFlight());
			mFlight.add(getMiEditFlight());
			mFlight.add(getSeparator_1());
			mFlight.add(getMiConsult());
		}
		return mFlight;
	}
	public JMenu getMPassenger() {
		if (mPassenger == null) {
			mPassenger = new JMenu("Pasajeros");
			mPassenger.add(getMiAddPassenger());
			mPassenger.add(getMiEditPassenger());
		}
		return mPassenger;
	}
	public JMenu getMTickets() {
		if (mTickets == null) {
			mTickets = new JMenu("Tiquetes");
			mTickets.add(getMiAddTickets());
			mTickets.add(getMiEditTickets());
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
			miExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
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
			miEditModels = new JMenuItem("Gestión de Modelos");
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
			miCreateUser.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					/*GUIRegister guiR = new GUIRegister();
					 Dimension desktopSize = desktopRegister.getSize();
					 Dimension FrameSize = guiR.getSize();
					 guiR.setLocation((desktopSize.width-FrameSize.width)/2, (desktopSize.height-FrameSize.height)/2);
					 desktopRegister.add(guiR);
					 setVisible(true);*/
				}
			});
		}
		return miCreateUser;
	}
	public JMenuItem getMiAddBrand() {
		if (miAddBrand == null) {
			miAddBrand = new JMenuItem("Agregar");
		}
		return miAddBrand;
	}
	public JMenuItem getMiAddAirline() {
		if (miAddAirline == null) {
			miAddAirline = new JMenuItem("Agregar");
		}
		return miAddAirline;
	}
	public JMenuItem getMiAddAircraft() {
		if (miAddAircraft == null) {
			miAddAircraft = new JMenuItem("Agregar");
		}
		return miAddAircraft;
	}
	public JMenuItem getMiAddFlight() {
		if (miAddFlight == null) {
			miAddFlight = new JMenuItem("Agregar");
		}
		return miAddFlight;
	}
	public JMenuItem getMiAddPassenger() {
		if (miAddPassenger == null) {
			miAddPassenger = new JMenuItem("Agregar");
		}
		return miAddPassenger;
	}
	public JMenuItem getMiAddTickets() {
		if (miAddTickets == null) {
			miAddTickets = new JMenuItem("Agregar");
		}
		return miAddTickets;
	}
	public JDesktopPane getDesktopMain() {
		if (desktopMain == null) {
			desktopMain = new JDesktopPane();
			desktopMain.setBackground(new Color(255, 255, 255));
		}
		return desktopMain;
	}
}
