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
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class GuiCliente extends JDialog implements MouseListener {

	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField textField;
	private JScrollPane scrollPane;
	private JTable table;
	private JFrame parent;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			
			GuiBoletaVenta frame = new GuiBoletaVenta();
		
			GuiCliente dialog = new GuiCliente(frame);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			
			dialog.setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GuiCliente(JFrame parent) {
		
		 super(parent, "Seleccionar Datos", true);
		 setTitle("Lista Clientes");
		 this.parent = parent;
		 
		 setResizable(false);
		setBounds(100, 100, 710, 385);
		getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("CLIENTES FRECUENTES");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(256, 11, 181, 23);
		getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Buscar :");
		lblNewLabel_1.setBounds(34, 58, 104, 14);
		getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(140, 55, 244, 20);
		getContentPane().add(textField);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 105, 629, 186);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(this);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"01", "Ariana, Castilla C\u00E1rdenas", "Calle 4 norte # 10B-66 Barrio Modelo", "938147441", "73052947"},
				{"02", "Santiago, Sotelo Pasi\u00F3n", "Calle 28 # 2-27 Barrio Centro ", "978845325", "51202039"},
				{"03", "Ian, Ramos Ram\u00EDrez", "Avenida 30 de agosto # 26-37", "986541234", "43073120"},
				{"04", "Mauracio, Aleta Pajuelo", "Avenida 3 norte # 50N-20", "925347861", "41091274"},
				{"05", "Anghi, Rodr\u00EDguez Carri\u00F3n", "Avenida 19 No. 98-03, sexto piso, Edificio", "950291732", "53169756"},
			},
			new String[] {
				"N\u00B0", "NOMBRE", "DIRECCI\u00D3N", "TELEFONO", "DNI"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(29);
		table.getColumnModel().getColumn(1).setPreferredWidth(132);
		table.getColumnModel().getColumn(2).setPreferredWidth(207);
		table.getColumnModel().getColumn(3).setPreferredWidth(71);
		scrollPane.setViewportView(table);
	}
	
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == table) {
			mouseClickedTable(e);
		}
	}
	
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mouseClickedTable(MouseEvent e) {
		 if (e.getClickCount() == 2) {
             int selectedRow = table.getSelectedRow();
             if (selectedRow != -1) {
                 String nombre = table.getValueAt(selectedRow, 1).toString();
                 String direccion = table.getValueAt(selectedRow, 2).toString();
                 String DNI = table.getValueAt(selectedRow, 4).toString();
                 
                 //GuiBoletaVenta boleta=new GuiBoletaVenta();
              
                // boleta.setDatosCliente(id, nombre, apellido);  
               
                 GuiBoletaVenta boleta = (GuiBoletaVenta) parent;
                 
                 // Llamar al método del JFrame para pasar los datos
                 boleta.setDatosCliente(nombre, direccion, DNI);
                 
                 // Cerrar el diálogo
                 dispose();
             }
         }
	}
}
