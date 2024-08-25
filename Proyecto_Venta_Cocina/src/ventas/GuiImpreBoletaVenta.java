package ventas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GuiImpreBoletaVenta extends JDialog {

	LocalDate fechaActual = LocalDate.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	String fechaFormateada = fechaActual.format(formatter);
	 DecimalFormat df = new DecimalFormat("0.00");
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblDi;
	private JPanel panel_1;
	private JLayeredPane layeredPane;
	private JLabel lblNewLabel_3;
	private JTextField textField;
	private JLayeredPane layeredPane_1;
	private JLabel lblCli;
	private JLabel lbl;
	private JLabel lblDNI;
	private JLabel lblFecha;
	private JLabel lblNewLabel_8;
	private JScrollPane scrollPane;
	private JTable tableImpre;
	private JLabel lblTotal;
	private JTextField txtCli;
	private JTextField txtDirec;
	private JTextField txtDNI;
	private JTextField txtFecha;
	private JTextField txtTotal;
	private JFrame parent;
	private JTextField txtBoleta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			//GuiBoletaVenta frame = new GuiBoletaVenta();
			//GuiImpreBoletaVenta dialog = new GuiImpreBoletaVenta(frame,);
			//dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			//dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GuiImpreBoletaVenta(JFrame parent,DefaultTableModel tableModel,String cliente,String direccion,String DNI, String TotalPagar) {
		 super(parent, "Seleccionar Datos", true);
		 setTitle("Impresión Boleta");
		 this.parent = parent;
		 
		 setResizable(false); 
		setBounds(100, 100, 710, 385);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblDi = new JLabel("Avenida Calle 26 No 59-51 Edificio Argos");
		lblDi.setBounds(45, 105, 267, 14);
		contentPanel.add(lblDi);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_1.setBackground(SystemColor.inactiveCaption);
		panel_1.setBounds(32, 21, 232, 56);
		contentPanel.add(panel_1);
		
		lblNewLabel = new JLabel("Inter Kitchen");
		lblNewLabel.setBounds(10, 11, 111, 19);
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Impact", Font.PLAIN, 20));
		
		lblNewLabel_1 = new JLabel("Calidad y Garantia ");
		lblNewLabel_1.setBounds(10, 34, 111, 11);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 11));
		
		layeredPane = new JLayeredPane();
		layeredPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		layeredPane.setBackground(Color.GRAY);
		layeredPane.setBounds(484, 21, 184, 65);
		contentPanel.add(layeredPane);
		
		lblNewLabel_3 = new JLabel("R.U.C 10157464626");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(21, 0, 155, 22);
		layeredPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setText("      N° 001");
		textField.setColumns(10);
		textField.setBounds(52, 45, 77, 16);
		layeredPane.add(textField);
		
		txtBoleta = new JTextField();
		txtBoleta.setEditable(false);
		txtBoleta.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtBoleta.setBackground(Color.LIGHT_GRAY);
		txtBoleta.setText("   BOLETA DE VENTA");
		txtBoleta.setBounds(31, 22, 120, 20);
		layeredPane.add(txtBoleta);
		txtBoleta.setColumns(10);
		
		layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		layeredPane_1.setBackground(Color.GRAY);
		layeredPane_1.setBounds(32, 130, 636, 60);
		contentPanel.add(layeredPane_1);
		
		lblCli = new JLabel("Ciente :");
		lblCli.setBounds(10, 11, 81, 14);
		layeredPane_1.add(lblCli);
		
		lbl = new JLabel("Dirección :");
		lbl.setBounds(10, 36, 89, 14);
		layeredPane_1.add(lbl);
		
		lblDNI = new JLabel("DNI : ");
		lblDNI.setBounds(411, 11, 68, 14);
		layeredPane_1.add(lblDNI);
		
		lblFecha = new JLabel("Fecha Emisión :");
		lblFecha.setBounds(411, 36, 96, 14);
		layeredPane_1.add(lblFecha);
		
		txtCli = new JTextField();
		txtCli.setEditable(false);
		txtCli.setForeground(Color.BLACK);
		txtCli.setBackground(SystemColor.LIGHT_GRAY);
		txtCli.setBounds(101, 9, 253, 17);
		layeredPane_1.add(txtCli);
		txtCli.setText(cliente);
		txtCli.setColumns(10);
		
		txtDirec = new JTextField();
		txtDirec.setEditable(false);
		txtDirec.setForeground(Color.BLACK);
		txtDirec.setColumns(10);
		txtDirec.setBackground(SystemColor.LIGHT_GRAY);
		txtDirec.setBounds(101, 34, 280, 17);
		txtDirec.setText(direccion);
		layeredPane_1.add(txtDirec);
		
		txtDNI = new JTextField();
		txtDNI.setEditable(false);
		txtDNI.setForeground(Color.BLACK);
		txtDNI.setColumns(10);
		txtDNI.setBackground(SystemColor.LIGHT_GRAY);
		txtDNI.setBounds(508, 11, 118, 17);
		txtDNI.setText(DNI);
		layeredPane_1.add(txtDNI);
		
		txtFecha = new JTextField();
		txtFecha.setForeground(Color.BLACK);
		txtFecha.setColumns(10);
		txtFecha.setBackground(SystemColor.LIGHT_GRAY);
		txtFecha.setBounds(508, 33, 118, 17);
		txtFecha.setText(fechaFormateada);
		txtFecha.setEditable(false);
		txtFecha.setHorizontalAlignment(JTextField.CENTER);
		layeredPane_1.add(txtFecha);
						
		
		lblNewLabel_8 = new JLabel("De Carbajal Aguilar Eduardo Pedro");
		lblNewLabel_8.setBounds(54, 88, 237, 12);
		contentPanel.add(lblNewLabel_8);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 197, 636, 85);
		contentPanel.add(scrollPane);
		
		tableImpre = new JTable(tableModel);
		tableImpre.setEnabled(false);
		tableImpre.setBorder(null);
		tableImpre.setForeground(SystemColor.BLACK);
	
		tableImpre.setBackground(new Color(192, 192, 192));
		tableImpre.getColumnModel().getColumn(3).setPreferredWidth(82);
		scrollPane.setViewportView(tableImpre);
		
		lblTotal = new JLabel("Total a pagar :");
		lblTotal.setBounds(428, 301, 134, 19);
		contentPanel.add(lblTotal);
		
		txtTotal = new JTextField();
		txtTotal.setEditable(false);
		txtTotal.setBackground(SystemColor.LIGHT_GRAY);
		txtTotal.setBounds(569, 300, 99, 20);
		contentPanel.add(txtTotal);
		txtTotal.setColumns(10);
		txtTotal.setText(TotalPagar);
		
	}
}
