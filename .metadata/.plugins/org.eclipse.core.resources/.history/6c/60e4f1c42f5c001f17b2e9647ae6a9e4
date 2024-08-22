package menu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import configuracion.GuiConfiCantidadOptima;
import configuracion.GuiConfiCuotaDiaria;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import mantenimiento.GuiConsultarCocina;
import mantenimiento.GuiListadoCocinas;
import mantenimiento.GuiModificarCocina;
import ventas.GuiGenerarReportes;
import ventas.GuiVender;

public class MenuPrincipal extends JFrame implements ActionListener {
	
	// Datos mínimos de la primera cocina
	public static String modelo0 = "Mabe EMP6120PG0";
	public static double precio0 = 949.0;
	public static double fondo0 = 58.6;
	public static double ancho0 = 60.0;
	public static double alto0 = 91.0;
	public static int quemadores0 = 4;
	// Datos mínimos de la segunda cocina
	public static String modelo1 = "Indurama Parma";
	public static double precio1 = 1089.0;
	public static double ancho1 = 80.0;
	public static double alto1 = 94.0;
	public static double fondo1 = 67.5;
	public static int quemadores1 = 6;
	// Datos mínimos de la tercera cocina
	public static String modelo2 = "Sole COSOL027";
	public static double precio2 = 850.0;
	public static double ancho2 = 60.0;
	public static double alto2 = 90.0;
	public static double fondo2 = 50.0;
	public static int quemadores2 = 4;
	// Datos mínimos de la cuarta cocina
	public static String modelo3 = "Coldex CX602";
	public static double precio3 = 629.0;
	public static double ancho3 = 61.6;
	public static double alto3 = 95.0;
	public static double fondo3 = 51.5;
	public static int quemadores3 = 5;
	// Datos mínimos de la quinta cocina
	public static String modelo4 = "Reco Dakota";
	public static double precio4 = 849.0;
	public static double ancho4 = 75.4;
	public static double alto4 = 94.5;
	public static double fondo4 = 66.0;
	public static int quemadores4 = 5;
	// Porcentajes de descuento
	public static double porcentaje1 = 7.5;
	public static double porcentaje2 = 10.0;
	public static double porcentaje3 = 12.5;
	public static double porcentaje4 = 15.0;
	// Obsequios
	public static String obsequio1 = "Cafetera";
	public static String obsequio2 = "Licuadora";
	public static String obsequio3 = "Extractor";
	// Cantidad óptima de unidades vendidas
	public static int cantidadOptima = 30;
	// Cuota diaria
	public static double cuotaDiaria = 75000;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenu mnMantenimiento;
	private JMenu mnVentas;
	private JMenu mnConfiguración;
	private JMenu mnAyuda;
	private JMenuItem mntmSalir;
	private JMenuItem mntmConsultarCocina;
	private JMenuItem mntmModificarCocina;
	private JMenuItem mntmListadeCocinas;
	private JMenuItem mntmVender;
	private JMenuItem mntmGenerarReportes;
	private JMenuItem mntmDescuentos;
	private JMenuItem mntmObsequios;
	private JMenuItem mntmCantidadOptima;
	private JMenuItem mntmCuotaDiaria;
	private JMenuItem mntmAcercadeTienda;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
					frame.setVisible(true);
					frame.setExtendedState(MAXIMIZED_BOTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuPrincipal() {
		setTitle("Tienda 2.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 418);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		mnArchivo.add(mntmSalir);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);
		
		mntmConsultarCocina = new JMenuItem("Consultar cocina");
		mntmConsultarCocina.addActionListener(this);
		mnMantenimiento.add(mntmConsultarCocina);
		
		mntmModificarCocina = new JMenuItem("Modificar cocina");
		mntmModificarCocina.addActionListener(this);
		mnMantenimiento.add(mntmModificarCocina);
		
		mntmListadeCocinas = new JMenuItem("Lista de cocinas");
		mntmListadeCocinas.addActionListener(this);
		mnMantenimiento.add(mntmListadeCocinas);
		
		mnVentas = new JMenu("Ventas");
		menuBar.add(mnVentas);
		
		mntmVender = new JMenuItem("Vender");
		mntmVender.addActionListener(this);
		mnVentas.add(mntmVender);
		
		mntmGenerarReportes = new JMenuItem("Generar reportes");
		mntmGenerarReportes.addActionListener(this);
		mnVentas.add(mntmGenerarReportes);
		
		mnConfiguración = new JMenu("Configuración");
		menuBar.add(mnConfiguración);
		
		mntmDescuentos = new JMenuItem("Configurar descuentos");
		mntmDescuentos.addActionListener(this);
		mnConfiguración.add(mntmDescuentos);
		
		mntmObsequios = new JMenuItem("Configurar obsequios");
		mntmObsequios.addActionListener(this);
		mnConfiguración.add(mntmObsequios);
		
		mntmCantidadOptima = new JMenuItem("Configurar cantidad óptima");
		mntmCantidadOptima.addActionListener(this);
		mnConfiguración.add(mntmCantidadOptima);
		
		mntmCuotaDiaria = new JMenuItem("Configurar cuota diaria");
		mnConfiguración.add(mntmCuotaDiaria);
		
		mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		mntmAcercadeTienda = new JMenuItem("Acerca de tienda");
		mnAyuda.add(mntmAcercadeTienda);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmCantidadOptima) {
			actionPerformedMntmCantidadOptima(e);
		}
		if (e.getSource() == mntmObsequios) {
			actionPerformedMntmObsequios(e);
		}
		if (e.getSource() == mntmDescuentos) {
			actionPerformedMntmDescuentos(e);
		}
		if (e.getSource() == mntmGenerarReportes) {
			actionPerformedMntmGenerarReportes(e);
		}
		if (e.getSource() == mntmVender) {
			actionPerformedMntmVender(e);
		}
		if (e.getSource() == mntmListadeCocinas) {
			actionPerformedMntmNewMenuItem_3(e);
		}
		if (e.getSource() == mntmModificarCocina) {
			actionPerformedMntmNewMenuItem_2(e);
		}
		if (e.getSource() == mntmSalir) {
			actionPerformedMntmNewMenuItem(e);
		}
		if (e.getSource() == mntmConsultarCocina) {
			actionPerformedMntmNewMenuItem_1(e);
		}
	}
    protected void actionPerformedMntmNewMenuItem(ActionEvent e) {
		System.exit(0);
	}
	protected void actionPerformedMntmNewMenuItem_1(ActionEvent e) {	
		GuiConsultarCocina consulta=new GuiConsultarCocina();
		consulta.setVisible(true);	
		dispose();
	}
	protected void actionPerformedMntmNewMenuItem_2(ActionEvent e) {
		GuiModificarCocina modificar=new GuiModificarCocina();
		modificar.setVisible(true);
	}
	protected void actionPerformedMntmNewMenuItem_3(ActionEvent e) {
		GuiListadoCocinas lista=new GuiListadoCocinas();
		lista.setVisible(true);
	}
	protected void actionPerformedMntmVender(ActionEvent e) {
		GuiVender vender=new GuiVender();
		vender.setVisible(true);
	}
	protected void actionPerformedMntmGenerarReportes(ActionEvent e) {
		GuiGenerarReportes reporte=new GuiGenerarReportes();
		reporte.setVisible(true);
	}
	protected void actionPerformedMntmDescuentos(ActionEvent e) {
		GuiConfiDescuentos descuentos=new GuiConfiDescuentos();
		descuentos.setVisible(true);
	}
	protected void actionPerformedMntmObsequios(ActionEvent e) {
		GuiConfiCuotaDiaria cuotadiaria=new GuiConfiCuotaDiaria();
		cuotadiaria.setVisible(true);
	}
	protected void actionPerformedMntmCantidadOptima(ActionEvent e) {
		GuiConfiCantidadOptima cantidadoptima=new GuiConfiCantidadOptima();
		cantidadoptima.setVisible(true);
	}
}
