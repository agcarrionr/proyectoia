package configuracion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import menu.MenuPrincipal;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;


public class GuiConfiCantidadOptima extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;
	private JTextField txtCantidadoptima;
	private JButton btnAceptar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GuiConfiCantidadOptima dialog = new GuiConfiCantidadOptima();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GuiConfiCantidadOptima() {
		setTitle("Configuracion cantidad optima");
		setBounds(100, 100, 450, 122);
		getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("Cantidad optima de unidades vendidas");
		lblNewLabel.setBounds(10, 22, 244, 19);
		getContentPane().add(lblNewLabel);
		
		txtCantidadoptima = new JTextField();
		txtCantidadoptima.setBounds(252, 21, 69, 20);
		getContentPane().add(txtCantidadoptima);
		txtCantidadoptima.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(331, 20, 93, 23);
		getContentPane().add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(332, 49, 92, 23);
		getContentPane().add(btnCancelar);
		
		Salida ();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnNewButton_1(e);
		}
	}
	protected void actionPerformedBtnNewButton_1(ActionEvent e) {
		
		
		dispose();
		
	}
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		
		Prueba ();
		dispose();
		JOptionPane.showMessageDialog(null, "Cambios Guardados");
	}
	void Prueba () {
		MenuPrincipal.cantidadOptima=Integer.parseInt(txtCantidadoptima.getText());
	}
	void Salida() {
		
		txtCantidadoptima.setText(""+MenuPrincipal.cantidadOptima);
		}


		
	}

