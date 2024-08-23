package configuracion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuiConfiDescuentos extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField txtD1;
	private JTextField txtD2;
	private JTextField txtD3;
	private JTextField txtD4;
	private JButton btnAceptar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GuiConfiDescuentos dialog = new GuiConfiDescuentos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GuiConfiDescuentos() {
		setTitle("Configurar porcentajes de descuento");
		setBounds(100, 100, 412, 190);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblNewLabel = new JLabel("De 1 a 5 unidades");
		lblNewLabel.setBounds(33, 38, 108, 14);
		contentPanel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("De 6 a 10 unidades");
		lblNewLabel_1.setBounds(33, 63, 108, 14);
		contentPanel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("De 11 a 15 unidades");
		lblNewLabel_2.setBounds(33, 88, 108, 14);
		contentPanel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Mas de 15 unidades");
		lblNewLabel_3.setBounds(33, 113, 108, 14);
		contentPanel.add(lblNewLabel_3);
		
		txtD1 = new JTextField();
		txtD1.setText("7.5");
		txtD1.setBounds(162, 35, 86, 20);
		contentPanel.add(txtD1);
		txtD1.setColumns(10);
		
		txtD2 = new JTextField();
		txtD2.setText("10.0");
		txtD2.setBounds(162, 60, 86, 20);
		contentPanel.add(txtD2);
		txtD2.setColumns(10);
		
		txtD3 = new JTextField();
		txtD3.setText("12.5");
		txtD3.setBounds(162, 85, 86, 20);
		contentPanel.add(txtD3);
		txtD3.setColumns(10);
		
		txtD4 = new JTextField();
		txtD4.setText("15.0");
		txtD4.setBounds(162, 110, 86, 20);
		contentPanel.add(txtD4);
		txtD4.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(286, 38, 89, 23);
		contentPanel.add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(286, 79, 89, 23);
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
//--------------------------------------------------------------------
	
	// Declarar variables globales
	
		double porcentaje1, porcentaje2, porcentaje3, porcentaje4;
	
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		
		//Llamada de métodos
		ingresoDescuento();
		
	}
	
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		System.exit(WIDTH);
	}
	
	//Método para ingresar datos
		void ingresoDescuento() {
			porcentaje1 = Double.parseDouble(txtD1.getText());
			porcentaje2 = Double.parseDouble(txtD2.getText());
			porcentaje3 = Double.parseDouble(txtD3.getText());
			porcentaje4 = Double.parseDouble(txtD4.getText());
			
		}
}
