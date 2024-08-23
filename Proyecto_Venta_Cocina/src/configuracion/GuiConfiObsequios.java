package configuracion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuiConfiObsequios extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtObs3;
	private JTextField txtObs2;
	private JTextField txtObs1;
	private JButton btnCancelar;
	private JButton btnAceptar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GuiConfiObsequios dialog = new GuiConfiObsequios();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GuiConfiObsequios() {
		setTitle("Configurar obsequios");
		setBounds(100, 100, 410, 168);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("De 1 unidad");
			lblNewLabel.setBounds(29, 35, 114, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("De 2 a 5 unidades");
			lblNewLabel_1.setBounds(29, 60, 114, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("De 6 a mas unidades");
			lblNewLabel_2.setBounds(29, 85, 114, 14);
			contentPanel.add(lblNewLabel_2);
		}
		{
			txtObs3 = new JTextField();
			txtObs3.setText("Extractor");
			txtObs3.setBounds(153, 82, 86, 20);
			contentPanel.add(txtObs3);
			txtObs3.setColumns(10);
		}
		{
			txtObs2 = new JTextField();
			txtObs2.setText("Licuadora");
			txtObs2.setBounds(153, 57, 86, 20);
			contentPanel.add(txtObs2);
			txtObs2.setColumns(10);
		}
		{
			txtObs1 = new JTextField();
			txtObs1.setText("Cafetera");
			txtObs1.setBounds(153, 32, 86, 20);
			contentPanel.add(txtObs1);
			txtObs1.setColumns(10);
		}
		{
			btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(this);
			btnAceptar.setBounds(279, 35, 89, 23);
			contentPanel.add(btnAceptar);
		}
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(279, 60, 89, 23);
		contentPanel.add(btnCancelar);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
	}
	
//--------------------------------------------------------------
	
	//Declarar variables globales
		String obsequio1, obsequio2, obsequio3;
	
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		
	}
	
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		System.exit(WIDTH);
	}
	
	//metodo para ingresar datos
		void ingresoObsequios() {
			obsequio1 = txtObs1.getText();
			obsequio2 = txtObs2.getText();
			obsequio3 = txtObs3.getText();
		}
	
}
