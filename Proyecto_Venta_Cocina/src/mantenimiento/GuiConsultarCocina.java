package mantenimiento;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import menu.MenuPrincipal;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.security.PublicKey;
import java.awt.event.ActionEvent;

public class GuiConsultarCocina extends JDialog implements ActionListener {
	
	

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblPrecio;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblModelo;
	private JTextField txtPrecio;
	private JTextField txtAncho;
	private JTextField txtAlto;
	private JTextField txtFondo;
	private JTextField txtQuemadores;
	private JButton btnCerrar;
	private JComboBox cboModelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) { 
		try {
			GuiConsultarCocina dialog = new GuiConsultarCocina();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GuiConsultarCocina() {
		setTitle("Consultar cocina");
		setBounds(100, 100, 454, 201);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblPrecio = new JLabel("Precio (S/)");
		lblPrecio.setBounds(10, 36, 66, 14);
		contentPanel.add(lblPrecio);
		
		lblNewLabel_1 = new JLabel("Ancho (cm)");
		lblNewLabel_1.setBounds(10, 61, 66, 14);
		contentPanel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Alto (cm)");
		lblNewLabel_2.setBounds(10, 86, 66, 14);
		contentPanel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Fondo (cm)");
		lblNewLabel_3.setBounds(10, 111, 66, 14);
		contentPanel.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Quemadores");
		lblNewLabel_4.setBounds(10, 136, 66, 14);
		contentPanel.add(lblNewLabel_4);
		
		lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(10, 11, 94, 14);
		contentPanel.add(lblModelo);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(114, 33, 169, 20);
		contentPanel.add(txtPrecio);
		txtPrecio.setColumns(10);
		txtPrecio.setEditable(false);
		txtPrecio.addActionListener(cboModelo);
		
		txtAncho = new JTextField();
		txtAncho.setBounds(114, 58, 169, 20);
		contentPanel.add(txtAncho);
		txtAncho.setColumns(10);
		txtAncho.setEditable(false);
		
		txtAlto = new JTextField();
		txtAlto.setBounds(114, 83, 169, 20);
		contentPanel.add(txtAlto);
		txtAlto.setColumns(10);
		txtAlto.setEditable(false);
		
		txtFondo = new JTextField();
		txtFondo.setBounds(114, 108, 169, 20);
		contentPanel.add(txtFondo);
		txtFondo.setColumns(10);
		txtFondo.setEditable(false);
		
		txtQuemadores = new JTextField();
		txtQuemadores.setBounds(114, 133, 169, 20);
		contentPanel.add(txtQuemadores);
		txtQuemadores.setColumns(10);
		txtQuemadores.setEditable(false);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(342, 7, 89, 23);
		contentPanel.add(btnCerrar);
		
		cboModelo = new JComboBox();
		cboModelo.addActionListener(this);
		cboModelo.setModel(new DefaultComboBoxModel(new String[] {"Mabe EMP6120PG0", "Indurama Parma", "Sole COSOL027", "Coldex CX602", "Reco Dakota"}));
		cboModelo.setBounds(114, 7, 169, 22);
		contentPanel.add(cboModelo);
		
		AbrirGUI();
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cboModelo) {
			actionPerformedCboModelo(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		
		dispose();
		MenuPrincipal Menu=new MenuPrincipal();
		Menu.setVisible(true);
		Menu.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
	}
	protected void actionPerformedCboModelo(ActionEvent e) {
		
		int modelo, quemadores;
		double precio, ancho, alto, fondo;
		
		modelo=cboModelo.getSelectedIndex();	
		
		switch(modelo) {
		case 0: precio=MenuPrincipal.precio0; ancho=MenuPrincipal.ancho0; alto=MenuPrincipal.alto0; fondo=MenuPrincipal.fondo0; quemadores=MenuPrincipal.quemadores0;break;
		case 1: precio=MenuPrincipal.precio1; ancho=MenuPrincipal.ancho1; alto=MenuPrincipal.alto1; fondo=MenuPrincipal.fondo1; quemadores=MenuPrincipal.quemadores1;break;
		case 2: precio=MenuPrincipal.precio2; ancho=MenuPrincipal.ancho2; alto=MenuPrincipal.alto2; fondo=MenuPrincipal.fondo2; quemadores=MenuPrincipal.quemadores2;break;
		case 3: precio=MenuPrincipal.precio3; ancho=MenuPrincipal.ancho3; alto=MenuPrincipal.alto3; fondo=MenuPrincipal.fondo3; quemadores=MenuPrincipal.quemadores3;break;
		default: precio=MenuPrincipal.precio4; ancho=MenuPrincipal.ancho4; alto=MenuPrincipal.alto4; fondo=MenuPrincipal.fondo4; quemadores=MenuPrincipal.quemadores4;
		}
		
		txtPrecio.setText(""+precio);
		txtAncho.setText(""+ancho);
		txtAlto.setText(""+alto);
		txtFondo.setText(""+fondo);
		txtQuemadores.setText(""+quemadores);
		
		}
	//DATOS MOSTRADO AL ABRIR EL GUICONSULTARCOCINA
	void AbrirGUI() {
		txtPrecio.setText(""+MenuPrincipal.precio0);
		txtAncho.setText(""+MenuPrincipal.ancho0);
		txtAlto.setText(""+MenuPrincipal.alto0);
		txtFondo.setText(""+MenuPrincipal.fondo0);
		txtQuemadores.setText(""+MenuPrincipal.quemadores0);
		
	}
}