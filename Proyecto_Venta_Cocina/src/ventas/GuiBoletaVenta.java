package ventas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.StringContent;

import configuracion.GuiConfiObsequios;
import menu.MenuPrincipal;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JLayeredPane;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class GuiBoletaVenta extends JFrame implements ActionListener, KeyListener {

	LocalDate fechaActual = LocalDate.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	String fechaFormateada = fechaActual.format(formatter);
	 DecimalFormat df = new DecimalFormat("0.00");
	private static final long serialVersionUID = 1L;
	protected static final int PAGE_EXISTS = 0;
	protected static final int NO_SUCH_PAGE = 0;
	private JPanel contentPane;
	private JLabel lblModel;
	private JLabel lblCliente;
	private JLabel lblDirec;
	private JButton btnBuscarCliente;
	private JTextField txtCliente;
	private JTextField txtDirecc;
	private JLabel lblDNI;
	private JLabel lblPre;
	private JLabel lblNewLabel_5;
	private JScrollPane scrollPane;
	private JComboBox cboModelo;
	private JTextField txtDNI;
	private JTextField txtFecha;
	private JLabel lblFecha;
	private JTable TableVenta;
	private JLabel lblStock;
	private JTextField txtCanti;
	private JButton btnSuma;
	private JButton btnMenos;
	private JButton btnNuevo;
	private JButton btnImpri;
	private JButton btnCerrar;
	private JLabel lblSubTo;
	private JLabel lblIGV;
	private JLabel lblTpagar;
	private JTextField txtSub;
	private JTextField txtIGV;
	private JTextField txtPagar;
	private JLayeredPane layeredPane;
	private JLabel lblRUC;
	private JTextField txtN;
	private JTextField txtPrecio;
	private JLabel lblCanti;
	private JTextField txtStock;
	private JLabel lblIcon;
	private JTextField txtBoleta;
	private JButton btnRegistrar;
	//parámetros globales 
	public static int totalVendido = 0;
	public static int totalVentasAcumulado = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiBoletaVenta frame = new GuiBoletaVenta();
					frame.setVisible(true);
					frame.setResizable(false); 
					frame.setLocationRelativeTo(null);
					 
				
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,"Error en la base de Datos");
					e.printStackTrace();
				}
			}
			
		
		
			
		});
	}

	/**
	 * Create the frame.
	 */
	
	public GuiBoletaVenta() {
		setTitle("Registro de Venta");
		setForeground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		// Crear un ImageIcon con la ruta de la imagen
        ImageIcon icon = new ImageIcon("ruta/de/la/imagen.jpg");
		
		
		lblModel = new JLabel("Modelo :");
		lblModel.setBounds(36, 66, 86, 14);
		contentPane.add(lblModel);
		
		lblCliente = new JLabel("Cliente :");
		lblCliente.setBounds(36, 100, 86, 14);
		contentPane.add(lblCliente);
		
		lblDirec = new JLabel("Dirección :");
		lblDirec.setBounds(36, 125, 86, 14);
		contentPane.add(lblDirec);
		
		btnBuscarCliente = new JButton("New button");
		btnBuscarCliente.addActionListener(this);
		btnBuscarCliente.setBounds(368, 91, 46, 23);
		contentPane.add(btnBuscarCliente);
		
		txtCliente = new JTextField();
		txtCliente.setBounds(116, 94, 242, 20);
		contentPane.add(txtCliente);
		txtCliente.setColumns(10);
		
		txtDirecc = new JTextField();
		txtDirecc.setBounds(116, 119, 298, 20);
		contentPane.add(txtDirecc);
		txtDirecc.setColumns(10);
		
		lblDNI = new JLabel("DNI :");
		lblDNI.setBounds(467, 100, 46, 14);
		contentPane.add(lblDNI);
		
		lblPre = new JLabel("Precio :");
		lblPre.setBounds(36, 150, 71, 22);
		contentPane.add(lblPre);
		
		lblNewLabel_5 = new JLabel("Inter Kitchen");
		lblNewLabel_5.setFont(new Font("Impact", Font.PLAIN, 17));
		lblNewLabel_5.setBounds(64, 11, 163, 44);
		contentPane.add(lblNewLabel_5);
		
		scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setBounds(35, 217, 627, 100);
		contentPane.add(scrollPane);
		
		TableVenta = new JTable();
		TableVenta.setEnabled(false);
		TableVenta.setForeground(new Color(0, 0, 0));
		TableVenta.setBackground(new Color(192, 192, 192));
		TableVenta.setFont(new Font("Tahoma", Font.PLAIN, 11));
		TableVenta.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {
						"Modelo", "Precio", "Cantidad", "Importe Compra", "Importe Descuento", "Importe Pagar", "Obsequio"
						}
				) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		TableVenta.getColumnModel().getColumn(0).setPreferredWidth(76);
		TableVenta.getColumnModel().getColumn(3).setPreferredWidth(90);
		TableVenta.getColumnModel().getColumn(4).setPreferredWidth(105);
		TableVenta.getColumnModel().getColumn(5).setPreferredWidth(85);
		 // Obtener el encabezado de la tabla
        JTableHeader tableHeader = TableVenta.getTableHeader();
        tableHeader.setReorderingAllowed(false);
        // Ajustar la altura del encabezado
        tableHeader.setPreferredSize(new Dimension(tableHeader.getWidth(), 50)); // 50 es la altura deseada en píxeles
                      
        
        
		//TableVenta.setRowHeight(50);
		scrollPane.setViewportView(TableVenta);
		
		cboModelo = new JComboBox();
		cboModelo.addActionListener(this);
		cboModelo.setModel(new DefaultComboBoxModel(new String[] {"---Seleccione---","Mabe EMP6120PG0", "Indurama Parma", "Sole COSOL027", "Coldex CX602", "Reco Dakota"}));
		cboModelo.setBounds(118, 62, 177, 22);
		contentPane.add(cboModelo);
		
		txtDNI = new JTextField();
		txtDNI.setBounds(523, 96, 114, 20);
		contentPane.add(txtDNI);
		txtDNI.setColumns(10);
		
		txtFecha = new JTextField();
		txtFecha.setBounds(523, 121, 114, 20);
		txtFecha.setText(fechaFormateada);
		txtFecha.setEditable(false);
		txtFecha.setColumns(10);
		txtFecha.setHorizontalAlignment(JTextField.CENTER);
		contentPane.add(txtFecha);
		
		lblFecha = new JLabel("Fecha :");
		lblFecha.setBounds(467, 125, 46, 14);
		contentPane.add(lblFecha);
		
		lblStock = new JLabel("Stock :");
		lblStock.setBounds(235, 158, 46, 14);
		contentPane.add(lblStock);
		
		txtCanti = new JTextField();
		txtCanti.addKeyListener(this);
		txtCanti.setBounds(116, 178, 86, 20);
		contentPane.add(txtCanti);
		txtCanti.setColumns(10);
		
		btnSuma = new JButton("+");
		btnSuma.addActionListener(this);
		btnSuma.setBounds(523, 177, 52, 23);
		contentPane.add(btnSuma);
		
		btnMenos = new JButton("-");
		btnMenos.addActionListener(this);
		btnMenos.setBounds(585, 177, 52, 23);
		contentPane.add(btnMenos);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(35, 342, 72, 23);
		contentPane.add(btnNuevo);
		
		btnImpri = new JButton("Imprimir");
		btnImpri.addActionListener(this);
		btnImpri.setBounds(127, 342, 85, 23);
		contentPane.add(btnImpri);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(222, 342, 85, 23);
		contentPane.add(btnCerrar);
		
		lblSubTo = new JLabel("Sub Total :");
		lblSubTo.setBounds(452, 331, 123, 14);
		contentPane.add(lblSubTo);
		
		lblIGV = new JLabel("IGV :");
		lblIGV.setBounds(452, 362, 46, 14);
		contentPane.add(lblIGV);
		
		lblTpagar = new JLabel("Total a pagar :");
		lblTpagar.setBounds(452, 390, 123, 14);
		contentPane.add(lblTpagar);
		
		txtSub = new JTextField();
		txtSub.setEditable(false);
		txtSub.setBounds(576, 328, 86, 20);
		contentPane.add(txtSub);
		txtSub.setColumns(10);
		
		txtIGV = new JTextField();
		txtIGV.setEditable(false);
		txtIGV.setBounds(576, 359, 86, 20);
		contentPane.add(txtIGV);
		txtIGV.setColumns(10);
		
		txtPagar = new JTextField();
		txtPagar.setEditable(false);
		txtPagar.setBounds(576, 387, 86, 20);
		contentPane.add(txtPagar);
		txtPagar.setColumns(10);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		layeredPane.setBackground(new Color(128, 128, 128));
		layeredPane.setBounds(452, 15, 210, 65);
		contentPane.add(layeredPane);
		
		lblRUC = new JLabel("   R.U.C 10157464626");
		lblRUC.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRUC.setBounds(21, 0, 168, 22);
		layeredPane.add(lblRUC);
		
		txtN = new JTextField();
		txtN.setEditable(false);
		txtN.setText("      N° 001");
		txtN.setBounds(66, 45, 77, 17);
		layeredPane.add(txtN);
		txtN.setColumns(10);
		
		txtBoleta = new JTextField();
		txtBoleta.setEditable(false);
		txtBoleta.setBackground(Color.LIGHT_GRAY);
		txtBoleta.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtBoleta.setText("     BOLETA DE VENTA");
		txtBoleta.setBounds(34, 21, 142, 20);
		layeredPane.add(txtBoleta);
		txtBoleta.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(116, 150, 60, 20);
		contentPane.add(txtPrecio);
		txtPrecio.setEditable(false);
		txtPrecio.addActionListener(cboModelo);
		
		lblCanti = new JLabel("Cantidad :");
		lblCanti.setBounds(36, 183, 71, 14);
		contentPane.add(lblCanti);
		
		txtStock = new JTextField();
		txtStock.setColumns(10);
		txtStock.setBounds(291, 155, 72, 20);
		contentPane.add(txtStock);
		txtStock.setEditable(false);
		txtStock.addActionListener(cboModelo);
		
		lblIcon = new JLabel(icon);
		lblIcon.setBounds(237, 11, 58, 44);
		contentPane.add(lblIcon);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(325, 342, 89, 23);
		contentPane.add(btnRegistrar);
		AbrirGUI();
		
		
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRegistrar) {
			actionPerformedBtnNewButton_1(e);
		}
		if (e.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
		if (e.getSource() == btnMenos) {
			actionPerformedBtnMenos(e);
		}
		if (e.getSource() == btnBuscarCliente) {
			actionPerformedBtnNewButton(e);
		}
		if (e.getSource() == btnImpri) {
			actionPerformedBtnImpri(e);
		}
		if (e.getSource() == btnSuma) {
			actionPerformedBtnSuma(e);
		}
		if (e.getSource() == cboModelo) {
			actionPerformedCboModelo(e);
		}
	}
	
	//DATOS MOSTRADO AL ABRIR EL GUICONSULTARCOCINA
		void AbrirGUI() {
			//txtPrecio.setText(""+MenuPrincipal.precio0);
			//txtStock.setText(""+MenuPrincipal.stock01);				
		}
		
		protected void actionPerformedCboModelo(ActionEvent e) {
			
			int modelo, stock;
			double precio;
			
			modelo=cboModelo.getSelectedIndex();	
			
			switch(modelo) {
			case 0: precio=0; stock=0;break;
			case 1: precio=MenuPrincipal.precio0; stock=MenuPrincipal.stock01;break;
			case 2: precio=MenuPrincipal.precio1; stock=MenuPrincipal.stock02;break;
			case 3: precio=MenuPrincipal.precio2; stock=MenuPrincipal.stock03;break;
			case 4: precio=MenuPrincipal.precio3; stock=MenuPrincipal.stock04;break;
			default: precio=MenuPrincipal.precio4; stock=MenuPrincipal.stock05;
			}
			
			if(modelo==0) {
				txtPrecio.setText("");
				txtStock.setText("");
			}else {
				txtPrecio.setText(""+precio);
				txtStock.setText(""+stock);
			}
		}
		
	protected void actionPerformedBtnSuma(ActionEvent e) {
		int modelo;
		modelo=cboModelo.getSelectedIndex();
	
		 if (modelo==0 ) {
	            // Mostrar mensaje de error si algún campo está vacío
	            JOptionPane.showMessageDialog(null, "Por favor, seleccione un modelo de Producto.", "Error", JOptionPane.INFORMATION_MESSAGE);
	            return; // Salir del método si los campos no están completos
	        }
		
		
		String Textmodelo = (String) cboModelo.getSelectedItem();
        String precio = txtPrecio.getText();
        String cantidad = txtCanti.getText();
        String stock = txtStock.getText();
 //Declaración de varibales Locales
		
		int modelovalor,cantientero;
		String obs;
		double pre,icom,ipagar,desc=0;
     // Validar que los campos no estén vacíos
        if (Textmodelo == null || Textmodelo.isEmpty() || precio.isEmpty() || cantidad.isEmpty()) {
            // Mostrar mensaje de error si algún campo está vacío
            JOptionPane.showMessageDialog(null, "Por favor, complete el campo cantidad.", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            return; // Salir del método si los campos no están completos
        }
        if (Integer.parseInt(cantidad)  >Integer.parseInt(stock)) {
            // Mostrar mensaje de error si algún campo está vacío
            JOptionPane.showMessageDialog(null, "La cantidad es superior al stock permitido.", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            return; // Salir del método si los campos no están completos
        }
        
		 
		//Entrada de datos
		 
        modelovalor=cboModelo.getSelectedIndex();
		cantientero=Integer.parseInt(txtCanti.getText());
		
		//Proceso
		if(modelovalor==0){
			pre=0;
		}	
		else if(modelovalor==1){
			pre=949.0;
		}	
		else if(modelovalor==2){	
			pre=1089.0;
		}
		else if(modelovalor==3) {
			pre=850.0;
		}
		else if(modelovalor==4) {
			pre=629.0;
		}
		else {
			pre=849.0;
		}
		
		//Calculando importe compra 
		
		icom=pre*cantientero;
		
		//Calculando importe descuento
		
		if(cantientero>=1&&cantientero<5)
			desc=icom*7.5/100;
		else if(cantientero>=6&&cantientero<10)
			desc=icom*10/100;
		else if(cantientero>=11&&cantientero<15)
			desc=icom*12.5/100;
		else 
			desc=icom*15/100;
		
		//Calculando importe pagar 
		
		ipagar=icom-desc;
		
		//Calculando obsequio
		
		if(cantientero==1)
			obs="Cafetera";
		else if(cantientero>1&&cantientero<=5)
			obs="Licuadora";
		else
			obs="Extractor";
		

   
        // Asegurarse de que el modelo de la tabla es un DefaultTableModel
        DefaultTableModel model = (DefaultTableModel) TableVenta.getModel();
        
        boolean agregar=true;
        for (int i = 0; i < model.getRowCount(); i++) {
           if(model.getValueAt(i, 0)==Textmodelo) {
        	   agregar=false;
        	    Object cantidadActual = model.getValueAt(i, 2);
                int nuevaCantidad = 0;
         	   if (cantidadActual instanceof String) {
         		    // Si es un String, convertirlo a double
         		   nuevaCantidad = Integer.parseInt((String) cantidadActual)+ cantientero;
         		} else if (cantidadActual instanceof Integer) {
         		    // Si ya es un Double, solo asignarlo
         			nuevaCantidad = (Integer) cantidadActual + cantientero;
         		}
          
                // Actualizar la celda con la nueva cantidad
         	   if(nuevaCantidad> Integer.parseInt( txtStock.getText())) {
         		  JOptionPane.showMessageDialog(null, "El producto no puede superar al stock permitido.", "Error", JOptionPane.INFORMATION_MESSAGE);
  	            return; // Salir del método si los campos no están completos
         		   
         	   }      	   
         	   	model.setValueAt(nuevaCantidad, i, 2); 
              
       
                       
               Object importeCompra = model.getValueAt(i, 3);
        	   double nuevoimporteCompra = 0;
        	   if (importeCompra instanceof String) {
        		    // Si es un String, convertirlo a double
        		   nuevoimporteCompra = Double.parseDouble((String) importeCompra)+ icom;
        		} else if (importeCompra instanceof Double) {
        		    // Si ya es un Double, solo asignarlo
        			nuevoimporteCompra = (Double) importeCompra + icom;
        		}
        	   System.out.print("totalimporte:" + nuevoimporteCompra);
        	   
                             
              // double importeCom = Double.parseDouble(importeCompra);
               // Incrementar la cantidad
           //    double nuevoimporteCompra = importeCompra + icom;
               // Actualizar la celda con la nueva cantidad
               model.setValueAt(nuevoimporteCompra, i, 3);
               
               Object importeDescuento = model.getValueAt(i, 4);
               
               double nuevoimporteDescuento = 0;
        	   if (importeDescuento instanceof String) {
        		    // Si es un String, convertirlo a double
        		   nuevoimporteDescuento = Double.parseDouble((String) importeDescuento)+ desc;
        		} else if (importeDescuento instanceof Double) {
        		    // Si ya es un Double, solo asignarlo
        			nuevoimporteDescuento = (Double) importeDescuento + desc;
        		}
              // double importeDesc = Double.parseDouble(importeDescuento);
               // Incrementar la cantidad
              // double nuevoimporteDescuento = importeDescuento + desc;
               // Actualizar la celda con la nueva cantidad
               model.setValueAt(df.format(nuevoimporteDescuento), i, 4);

               System.out.print("total descuento:" + nuevoimporteDescuento);
               
               
               Object importePagar =  model.getValueAt(i, 5);
               double nuevaimportePagar = 0;
               
               if (importePagar instanceof String) {
       		    // Si es un String, convertirlo a double
            	   nuevaimportePagar = Double.parseDouble((String) importePagar)+ ipagar;
       			} else if (importePagar instanceof Double) {
       		    // Si ya es un Double, solo asignarlo
       				nuevaimportePagar = (Double) importePagar + ipagar;
       			}
            //  double importePa = Double.parseDouble(importePagar);
               // Incrementar la cantidad
              // double nuevaimportePagar = importePagar + ipagar;
               // Actualizar la celda con la nueva cantidad
               model.setValueAt(df.format(nuevaimportePagar), i, 5);
               
               System.out.print("total pagar:" + nuevaimportePagar);
               
               if(nuevaCantidad==1)
       			obs="Cafetera";
       		else if(nuevaCantidad>1&&nuevaCantidad<=5)
       			obs="Licuadora";
       		else
       			obs="Extractor";
               // Actualizar la celda con la nueva cantidad
               model.setValueAt(obs, i, 6);
        	   
           }
                              
        }
        
        // Agregar los valores como una nueva fila en el JTable
        if(model.getRowCount()==0 || agregar) {        	        	
        	model.addRow(new Object[]{Textmodelo, precio, cantidad,icom,desc,ipagar,obs});               	
       //      int StockActual=Integer.parseInt(txtStock.getText());
      	//   	txtStock.setText(""+(StockActual-cantientero));
        }
        
        
        int columnIndex = 5; // Índice de la columna que quieres sumar
        double sum = 0.0;

        for (int i = 0; i < model.getRowCount(); i++) {
            Object value = model.getValueAt(i, columnIndex);
            if (value != null && value instanceof Number) {
                sum += ((Number) value).doubleValue();
            }else if(value != null && value instanceof String) {
            	 sum += Double.parseDouble((String) value);
            }
        }
        
        if(sum > 0) {
        	  txtSub.setText(String.valueOf(df.format(sum)));
  	        txtIGV.setText(String.valueOf(df.format(sum*0.18)));
  	        txtPagar.setText(String.valueOf(df.format(sum+sum*0.18)));
	        }else {
	        	 txtSub.setText("");
	 	        txtIGV.setText("");
	 	        txtPagar.setText("");
	        	
	        }
	}
	
	
	protected void actionPerformedBtnImpri(ActionEvent e) {
		
		 String DNI = txtDNI.getText();
		 DefaultTableModel model = (DefaultTableModel) TableVenta.getModel();
		 if (DNI.isEmpty() ) {
	            // Mostrar mensaje de error si algún campo está vacío
	            JOptionPane.showMessageDialog(null, "Por favor, seleccione un cliente para poder imprimir.", "Error", JOptionPane.INFORMATION_MESSAGE);
	            return; // Salir del método si los campos no están completos
	        }
		 
		 if(model.getRowCount()==0) {
			    JOptionPane.showMessageDialog(null, "No hay ningun producto ingresado para poder imprimir.", "Error", JOptionPane.INFORMATION_MESSAGE);
	            return; // Salir del método si los campos no están completos
			 
		 }
		 
			int[] columnsToInclude = {0, 1, 2, 5, 6};
			DefaultTableModel newModel = CreacionTableColumnasSeleccionadas(model, columnsToInclude);
	        
		 GuiImpreBoletaVenta impreBoleta=new GuiImpreBoletaVenta(this,newModel,txtCliente.getText(),txtDirecc.getText(),txtDNI.getText(),txtPagar.getText());
		 impreBoleta.setVisible(true);
	}
	
	  private DefaultTableModel CreacionTableColumnasSeleccionadas(DefaultTableModel originalModel, int[] columnas) {
	        // Obtener los nombres de las columnas seleccionadas
	        String[] columnNames = new String[] {
					"Modelo", "Precio.Unit", "Cantidad", "Importe Pagar", "Obsequio"
				};
	              

	        // Crear un nuevo DefaultTableModel con las columnas seleccionadas
	        DefaultTableModel newModel = new DefaultTableModel(columnNames, 0);

	        // Copiar los datos de las columnas seleccionadas
	        for (int i = 0; i < originalModel.getRowCount(); i++) {
	            Object[] rowData = new Object[columnas.length];
	            for (int j = 0; j < columnas.length; j++) {
	                rowData[j] = originalModel.getValueAt(i, columnas[j]);
	            }
	            newModel.addRow(rowData);
	        }

	        return newModel;
	    }
	
	
	
	protected void actionPerformedBtnNewButton(ActionEvent e) {
	
		GuiCliente cliente=new GuiCliente(this);
		cliente.setVisible(true);
		
	}
	
	
	
	 public void setDatosCliente(String cliente, String direccion, String dni) {
		 txtCliente.setText(cliente);
		 txtDirecc.setText(direccion);
	     txtDNI.setText(dni);
	     
	     
	    }
	protected void actionPerformedBtnMenos(ActionEvent e) {
		
		DefaultTableModel model = (DefaultTableModel) TableVenta.getModel();	
		//String Textmodelo = (String) cboModelo.getSelectedItem();				
		int lastRowIndex = model.getRowCount() - 1;
			
		if (lastRowIndex >= 0) {
			
	    //     if(model.getValueAt(lastRowIndex, 0)==Textmodelo) {
	        	   
	     //   	   Object cantidadActual = model.getValueAt(lastRowIndex, 2);
	     //           int nuevaCantidad = 0;
	      //   	   if (cantidadActual instanceof String) {
	         		    // Si es un String, convertirlo a double
	        // 		   nuevaCantidad = Integer.parseInt((String) cantidadActual);
	      //   		} else if (cantidadActual instanceof Integer) {
	         		    // Si ya es un Double, solo asignarlo
	      //   			nuevaCantidad = (Integer) cantidadActual ;
	       //  		}
	        	   
	        //	   if(Textmodelo=="Mabe EMP6120PG0") {
	         //		   MenuPrincipal.stock01+=nuevaCantidad;	         		   
	        // 	   }else if(Textmodelo=="Indurama Parma") {
	         //		   MenuPrincipal.stock02+=nuevaCantidad;	         		   
	        // 	   }else if(Textmodelo=="Sole COSOL027") {
	         //		   MenuPrincipal.stock03+=nuevaCantidad;         		   
	        // 	   }else if(Textmodelo=="Coldex CX602") {	         		   
	        // 		   MenuPrincipal.stock04+=nuevaCantidad;
	         //	   }else if(Textmodelo=="Reco Dakota") {
	        // 		   MenuPrincipal.stock05+=nuevaCantidad;	         		   
	        // 	   }	        	   	        	   
	         //  }
			
		    model.removeRow(lastRowIndex);
		    
		 
		}else {
			 // Mostrar mensaje de error si algún campo está vacío
            JOptionPane.showMessageDialog(null, "No hay ningun producto para eliminar.", "informacion", JOptionPane.INFORMATION_MESSAGE);
			
		}
		
		 int columnIndex = 5; // Índice de la columna que quieres sumar
	        double sum = 0.0;

	        for (int i = 0; i < model.getRowCount(); i++) {
	            Object value = model.getValueAt(i, columnIndex);
	            if (value != null && value instanceof Number) {
	                sum += ((Number) value).doubleValue();
	            }
	        }
	        
	        if(sum>0) {
	        txtSub.setText(String.valueOf(df.format(sum)));
	        txtIGV.setText(String.valueOf(df.format(sum*0.18)));
	        txtPagar.setText(String.valueOf(df.format(sum+sum*0.18)));
	        }else {
	        	 txtSub.setText("");
	 	        txtIGV.setText("");
	 	        txtPagar.setText("");
	        	
	        }
		
	}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
	protected void actionPerformedBtnNuevo(ActionEvent e) {
		LimpiarFormulario();
	}
	
	public void LimpiarFormulario() {
		
		txtCliente.setText("");
		txtDirecc.setText("");
		txtDNI.setText("");
		txtCanti.setText("");
		txtSub.setText("");
		txtIGV.setText("");
		txtPagar.setText("");
		DefaultTableModel model = (DefaultTableModel) TableVenta.getModel();
		model.setRowCount(0);
	}
	
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtCanti) {
			keyTypedTxtCanti(e);
		}
	}
	protected void keyTypedTxtCanti(KeyEvent e) {
		char c = e.getKeyChar();
        // Si no es un dígito, consume el evento
        if (!Character.isDigit(c)) {
            e.consume();
        }
	}
	protected void actionPerformedBtnNewButton_1(ActionEvent e) {
	    DefaultTableModel model = (DefaultTableModel) TableVenta.getModel();
	    String DNI = txtDNI.getText();

	    if (DNI.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "Por favor, seleccione un cliente para poder imprimir.", "Error", JOptionPane.INFORMATION_MESSAGE);
	        return; // Salir del método si los campos no están completos
	    }

	    if (model.getRowCount() == 0) {
	        JOptionPane.showMessageDialog(null, "No hay ningun producto ingresado para poder imprimir.", "Error", JOptionPane.INFORMATION_MESSAGE);
	        return; // Salir del método si no hay productos
	    }

	    // Reiniciar totalVendido antes de procesar las nuevas ventas
	    totalVendido = 0;

	    for (int i = 0; i < model.getRowCount(); i++) {
	        Object cantidadActual = model.getValueAt(i, 2);

	        if (cantidadActual instanceof String) {
	            try {
	                // Convertir el String a entero
	                totalVendido += Integer.parseInt((String) cantidadActual);
	            } catch (NumberFormatException ex) {
	                // Manejar el caso en el que el String no pueda ser convertido a Integer
	                JOptionPane.showMessageDialog(null, "Error en la cantidad de ventas: " + cantidadActual, "Error", JOptionPane.ERROR_MESSAGE);
	                return; // Salir del método si hay un error en el formato
	            }
	        } else if (cantidadActual instanceof Integer) {
	            // Sumar el valor si ya es un entero
	            totalVendido += (Integer) cantidadActual;
	        } else {
	            // Manejar otros posibles tipos de datos
	            JOptionPane.showMessageDialog(null, "Tipo de dato inesperado en la tabla: " + cantidadActual.getClass().getName(), "Error", JOptionPane.ERROR_MESSAGE);
	            return; // Salir del método si hay un tipo de dato inesperado
	        }

	        // Actualizar stock basado en el producto
	        String producto = (String) model.getValueAt(i, 0);
	        if ("Mabe EMP6120PG0".equals(producto)) {
	            MenuPrincipal.stock01 -= totalVendido; // Ajustar según la lógica de stock
	        } else if ("Indurama Parma".equals(producto)) {
	            MenuPrincipal.stock02 -= totalVendido; // Ajustar según la lógica de stock
	        } else if ("Sole COSOL027".equals(producto)) {
	            MenuPrincipal.stock03 -= totalVendido; // Ajustar según la lógica de stock
	        } else if ("Coldex CX602".equals(producto)) {
	            MenuPrincipal.stock04 -= totalVendido; // Ajustar según la lógica de stock
	        } else if ("Reco Dakota".equals(producto)) {
	            MenuPrincipal.stock05 -= totalVendido; // Ajustar según la lógica de stock
	        }
	    }

	    int option = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea realizar el registro de la Venta?", "Confirmar Registro", JOptionPane.YES_NO_OPTION);

	    if (option == JOptionPane.YES_OPTION) {
	        // Registrar la venta
	        agregarVenta(totalVendido);

	        // Mostrar un mensaje de que el registro se realizó correctamente
	        JOptionPane.showMessageDialog(null, "Registro realizado correctamente.", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);

	        // Limpiar el formulario después del registro
	        LimpiarFormulario();
	    } else {
	        JOptionPane.showMessageDialog(null, "Registro cancelado.", "Registro Cancelado", JOptionPane.INFORMATION_MESSAGE);
	    }
	}

	public static int agregarVenta(int cantidadVendida) {
	    System.out.println("Cantidad vendida recibida: " + cantidadVendida);
	    GuiBoletaVenta.totalVentasAcumulado += cantidadVendida;
	    System.out.println("Total vendido acumulado: " + totalVentasAcumulado);
	    return totalVentasAcumulado;
	}
}
