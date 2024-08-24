package ventas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GuiGenerarReportes extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTable table;

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
		setBounds(100, 100, 525, 300);
		getContentPane().setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Tipo de Reporte :");
			lblNewLabel.setBounds(21, 24, 111, 20);
			getContentPane().add(lblNewLabel);
		}
		{
			JComboBox cbo = new JComboBox();
			cbo.setBounds(126, 23, 151, 22);
			getContentPane().add(cbo);
		}
		{
			JButton btnNewButton = new JButton("Cerrar");
			btnNewButton.setBounds(425, 24, 72, 23);
			getContentPane().add(btnNewButton);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(21, 82, 476, 153);
			getContentPane().add(scrollPane);
			{
				table = new JTable();
				table.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"Modelo", "Cantidad de Venta", "Unid Vendidas", "Importe Pagar", "Obsequio"
					}
				));
				table.getColumnModel().getColumn(1).setPreferredWidth(107);
				table.getColumnModel().getColumn(2).setPreferredWidth(83);
				table.getColumnModel().getColumn(3).setPreferredWidth(84);
				scrollPane.setViewportView(table);
			}
		}
	}

}
