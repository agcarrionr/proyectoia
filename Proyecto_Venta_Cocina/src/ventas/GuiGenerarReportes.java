package ventas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;

public class GuiGenerarReportes extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblTipoReporte;
	private JComboBox cboTipoRepor;
	private JButton btnCerrar;
	private JScrollPane spReportes;

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
		setBounds(100, 100, 650, 454);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblTipoReporte = new JLabel("Tipo de reporte");
		lblTipoReporte.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblTipoReporte.setBounds(25, 36, 119, 19);
		contentPanel.add(lblTipoReporte);
		
		cboTipoRepor = new JComboBox();
		cboTipoRepor.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar", "Ventas por modelo", "Promedios menores y mayores", "Precios en relación al precio promedio", "Venta en relación a la venta óptima"}));
		cboTipoRepor.setBounds(139, 30, 304, 34);
		contentPanel.add(cboTipoRepor);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(493, 33, 117, 29);
		contentPanel.add(btnCerrar);
		
		spReportes = new JScrollPane();
		spReportes.setBounds(49, 75, 531, 323);
		contentPanel.add(spReportes);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnNewButtonJButton(e);
		}
	}
	protected void actionPerformedBtnNewButtonJButton(ActionEvent e) {
		dispose();
	}
}
