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

public class GuiConfiCuotaDiaria extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtCuotadiaria;
	private JButton btnCancelar;
	private JButton btnAceptar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GuiConfiCuotaDiaria dialog = new GuiConfiCuotaDiaria();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GuiConfiCuotaDiaria() {
		setTitle("Configurar cuota diaria");
		setBounds(100, 100, 450, 124);
		getContentPane().setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Cuota diaria esperada (S/.)");
			lblNewLabel.setBounds(27, 13, 206, 17);
			getContentPane().add(lblNewLabel);
		}
		{
			txtCuotadiaria = new JTextField();
			txtCuotadiaria.setBounds(246, 11, 73, 20);
			getContentPane().add(txtCuotadiaria);
			txtCuotadiaria.setColumns(10);
		}
		{
			btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(this);
			btnAceptar.setBounds(342, 10, 82, 23);
			getContentPane().add(btnAceptar);
		}
		{
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(this);
			btnCancelar.setBounds(342, 44, 82, 23);
			getContentPane().add(btnCancelar);
		}
		
		Salida ();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnNewButton(e);
		}
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnNewButton_1(e);
		}
	}
	protected void actionPerformedBtnNewButton_1(ActionEvent e) {
		
		dispose();
		
		
		
	}
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		
		Prueba ();
		dispose();
		JOptionPane.showMessageDialog(null, "Cambios Guardados");
	}
	void Prueba () {
		MenuPrincipal.cuotaDiaria=Double.parseDouble(txtCuotadiaria.getText());
	}
	void Salida() {
		
		txtCuotadiaria.setText(""+MenuPrincipal.cuotaDiaria);
	}
		
		
		
		
		
		
		
	}

