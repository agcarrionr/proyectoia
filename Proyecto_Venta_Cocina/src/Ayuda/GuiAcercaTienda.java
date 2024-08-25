package Ayuda;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import java.awt.Component;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;

public class GuiAcercaTienda extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblTitle;
	private JSeparator separator;
	private JLabel lblAutores;
	private JLabel lblNewLabel;
	private JButton btnCerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GuiAcercaTienda dialog = new GuiAcercaTienda();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GuiAcercaTienda() {
		setTitle("Acerca del sistema de venta de cocinas");
		setBounds(100, 100, 532, 368);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblTitle = new JLabel("<html>Sistema de Venta<br/>de Cocinas V.1.0.</html>");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		lblTitle.setBounds(132, 22, 286, 62);
		contentPanel.add(lblTitle);
		
		separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setBounds(108, 79, 338, 12);
		contentPanel.add(separator);
		
		lblAutores = new JLabel("Autores:");
		lblAutores.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblAutores.setHorizontalAlignment(SwingConstants.CENTER);
		lblAutores.setBounds(197, 98, 143, 24);
		contentPanel.add(lblAutores);
		
		lblNewLabel = new JLabel("<html>"
				+ "Ariana Nataly Castilla Cárdenas <br/> "
				+ "Santiago Sotelo Pasión <br/> "
				+ "Ian Andre Ramos Ramirez <br/> "
				+ "Mauricio Pajuelo Aleta <br/> "
				+ "Anghi Ghianella Rodríguez Carrión <br/>"
				+ "</html>");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(108, 134, 338, 109);
		contentPanel.add(lblNewLabel);
		{
			btnCerrar = new JButton("Cerrar");
			btnCerrar.setBorder(new LineBorder(new Color(65, 105, 225), 1, true));
			btnCerrar.setBounds(221, 274, 75, 29);
			contentPanel.add(btnCerrar);
			btnCerrar.addActionListener(this);
			btnCerrar.setActionCommand("OK");
			getRootPane().setDefaultButton(btnCerrar);
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(null);
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedOkButtonJButton(e);
		}
	}
	protected void actionPerformedOkButtonJButton(ActionEvent e) {
		dispose();
	}
	
}
