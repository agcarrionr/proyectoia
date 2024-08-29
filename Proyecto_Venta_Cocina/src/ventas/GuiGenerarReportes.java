package ventas;

import java.awt.BorderLayout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import menu.MenuPrincipal;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import java.util.ArrayList;

public class GuiGenerarReportes extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblTipoReporte;
	private JComboBox cboTipoRepor;
	private JButton btnCerrar;
	private JScrollPane spReportes;
	private JTextArea textArea;
	private JButton btnProcesar;
	
	private double precioPromedio = 0.0;
	private int cantidadVendida =  0;
	private int ventaOptima = 30;
	private String textoResult = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GuiGenerarReportes dialog = new GuiGenerarReportes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GuiGenerarReportes() {
		setTitle("Generar Reportes");
		setBounds(100, 100, 652, 487);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblTipoReporte = new JLabel("Tipo de reporte");
		lblTipoReporte.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblTipoReporte.setBounds(25, 36, 119, 19);
		contentPanel.add(lblTipoReporte);
		
		cboTipoRepor = new JComboBox();
		cboTipoRepor.setModel(new DefaultComboBoxModel(new String[] {"-----Seleccionar-----", "Ventas por modelo", "Promedios menores y mayores", "Precios en relación al precio promedio", "Venta en relación a la venta óptima"}));
		cboTipoRepor.setBounds(139, 30, 312, 34);
		contentPanel.add(cboTipoRepor);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(259, 414, 117, 29);
		contentPanel.add(btnCerrar);
		
		spReportes = new JScrollPane();
		spReportes.setBounds(49, 75, 531, 323);
		
		contentPanel.add(spReportes);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		spReportes.setViewportView(textArea);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(463, 33, 117, 29);
		contentPanel.add(btnProcesar);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnCerrar_1JButton(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnNewButtonJButton(e);
		}
	}
	protected void actionPerformedBtnNewButtonJButton(ActionEvent e) {
		dispose();
	}
	int leerTipoReporte() {
	    return cboTipoRepor.getSelectedIndex();
	}
	
	String  calcularReporte(int tipo) {
		String reporte = "";
		switch(tipo) {
		case 1: reporte = mostrarVentasModelo();
			break;
		case 2:
			reporte = mostrarPromedios();
			break;
			
		case 3: reporte = compararPrecio();
			break;
		case 4: reporte = mostrarRelacionVentaOp();
;			break;
		}
		return reporte;
	}

	String mostrarPromedios() {
		double menorPrecio = Double.MAX_VALUE;
		double mayorPrecio = Double.MIN_VALUE;
        double sumaPrecio = 0.0 ;
		for (ProductoVendido producto :  GuiBoletaVenta.productos) {
            double precio = producto.getPrecio();
            sumaPrecio += precio;
            if (precio < menorPrecio) {
            	menorPrecio = precio;
            }
            if (precio > mayorPrecio) {
            	mayorPrecio = precio;
            }
            precioPromedio= sumaPrecio / GuiBoletaVenta.productos.size();;
        }

	    StringBuilder reporte = new StringBuilder();
	    reporte.append("-------------------------------------------------------"+ "\n");
	    reporte.append("PROMEDIOS MENORES Y MAYORES\n");
	    reporte.append("-------------------------------------------------------"+ "\n\n");
	    reporte.append("Precio Promedio                           :   S/." +precioPromedio + "\n\n");
	    reporte.append("Precio Menor                                :   S/." + menorPrecio + "\n\n");
	    reporte.append("Precio Mayor                                :   S/." + mayorPrecio + "\n\n");
	    return reporte.toString();
	}
	String compararPrecio() {
	        ArrayList<Double> preciosModelos = new ArrayList<>();
	        preciosModelos.add(949.0);
	        preciosModelos.add(1089.0);
	        preciosModelos.add(850.0);
	        preciosModelos.add(629.0);
	        preciosModelos.add(849.0);
	        
	        ArrayList<String> cocinasModelo = new ArrayList<>();
	        cocinasModelo.add("Mabe EMP6120PG0");
	        cocinasModelo.add("Indurama Parma");
	        cocinasModelo.add("Sole COSOL027");
	        cocinasModelo.add("Coldex CX602");
	        cocinasModelo.add("Reco Dakota");
	        
	        StringBuilder reporte = new StringBuilder();
	        reporte.append("-------------------------------------------------------\n");
	        reporte.append("PRECIOS EN RELACIÓN AL PRECIO PROMEDIO \n");
	        reporte.append("Precio promedio:   " + precioPromedio  + "\n\n" );
	        reporte.append("-------------------------------------------------------\n\n");

	        for (int i = 0; i < preciosModelos.size(); i++) {
	            double precio = preciosModelos.get(i);
	            String modelo = cocinasModelo.get(i);
	            if (precio > precioPromedio) {
	                textoResult = "MAYOR";
	            } else if (precio < precioPromedio) {
	                textoResult = "MENOR";
	            } else {
	                textoResult = "IGUAL";
	            }

	            reporte.append("Modelo          :   " + modelo + ".\n" + "Precio            :   S/." + precio + " (" + textoResult + " al Promedio)" + "\n");
	    	    reporte.append("-------------------------------------------------------"+ "\n\n");
	        }

	        return reporte.toString();
	}
	
	String mostrarVentasModelo() {
	    StringBuilder reporte = new StringBuilder();
	    reporte.append("-------------------------------------------------------"+ "\n");
	    reporte.append("VENTAS POR MODELO\n");
	    reporte.append("-------------------------------------------------------"+ "\n\n");
	    for (ProductoVendido producto : GuiBoletaVenta.productos) {
		    reporte.append(getModeloString(producto));
        }
	    return reporte.toString();
	}
	
	
	String getModeloString(ProductoVendido producto){
		StringBuilder reporte = new StringBuilder();
	    reporte.append("Modelo                                   :   " + producto.getModelo() + "\n");
	    reporte.append("Total unidades vendidas        :   " + producto.getCantidad() + "\n");
	    reporte.append("Importe total                          :   S/." + producto.getImporte() + "\n");
	    reporte.append("Descuentos                            :   S/." + producto.getDescuento() + "\n");
	    reporte.append("-------------------------------------------------------"+ "\n\n");
	    return reporte.toString();
	}
	
	String getRelacionVentaOp(ProductoVendido producto){
		cantidadVendida = producto.getCantidad();
		if (cantidadVendida > ventaOptima) {
            textoResult = "MAYOR";
		} else if (cantidadVendida < ventaOptima) {
            textoResult = "MENOR";
		} else {
            textoResult = "IGUAL";
        }
		StringBuilder reporte = new StringBuilder();
	    reporte.append("Modelo                                   :   " + producto.getModelo() + "\n");
	    reporte.append("Unidades vendidas                 :   " + cantidadVendida + " (" + textoResult + " a la venta óptima)" + "\n");
	    reporte.append("-------------------------------------------------------"+ "\n\n");
	    return reporte.toString();
	}
	
	String mostrarRelacionVentaOp() {
		int totalVendidos = Integer.parseInt(getTotalVendidos());
	    String txtResultTotal = "";
	    if (totalVendidos > ventaOptima) {
	    	txtResultTotal = "MAYOR";
		} else if (totalVendidos < ventaOptima) {
			txtResultTotal = "MENOR";
		} else {
			txtResultTotal = "IGUAL";
        }
	    StringBuilder reporte = new StringBuilder();
	    reporte.append("-------------------------------------------------------"+ "\n");
	    reporte.append("VENTAS EN RELACIÓN A LA VENTA ÓPTIMA" + "\n\n");
	    reporte.append("Venta óptima:   " + ventaOptima  + "\n\n" );
	    reporte.append("Total unidades vendidas        :   " + getTotalVendidos() + " (" + txtResultTotal + " a la venta óptima)" + "\n");
	    
	    reporte.append("-------------------------------------------------------"+ "\n\n");
	    for (ProductoVendido producto : GuiBoletaVenta.productos) {
		    reporte.append(getRelacionVentaOp(producto));
        }
	    return reporte.toString();
	}
	
	protected void actionPerformedBtnCerrar_1JButton(ActionEvent e) {
		textArea.setText(calcularReporte(leerTipoReporte()));
	}
	
	protected String getTotalVendidos() {
		return Integer.toString(GuiBoletaVenta.totalVentasAcumulado);
		
	}
}
