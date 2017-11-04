import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JToolBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

public class sNomina {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sNomina window = new sNomina();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public sNomina() {
		initialize();
		nombre[0] = "Emilio Cantón";
		sueldo[0] = 12500;
		cargo[0] = "Dueño del programa";
		fechaIngreso[0] = "12/08/17";
	}
	// Base de datos en arreglos (la nómina es asignada de acuerdo al índice
	private String[] nombre = new String[10];
	private int[] sueldo = new int[10];
	private String[] cargo = new String[10];
	private String[] fechaIngreso = new String[10];
	private JTextField txtNomina;
	private JTextField altaNombre;
	private JButton btnAlta;
	private JLabel lblNombre;
	private JTextField altaCargo;
	private JLabel lblCargo;
	private JTextField altaSueldo;
	private JLabel lblSueldo;
	private JTextField altaFecha;
	private JLabel lblFecha;
	private JButton btnBaja;
	private JButton btnAsignar;
	private JLabel lblDias;
	private JTextField txtLaborados;

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 634, 430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		btnAlta = new JButton("Alta");
		btnAlta.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {
				String n,c,f;
				int s;
				try {
					n = altaNombre.getText();
					altaNombre.setText("");
					c = altaCargo.getText();
					altaCargo.setText("");
					f = altaFecha.getText();
					altaFecha.setText("");
					s = Integer.parseInt(altaSueldo.getText());
					altaSueldo.setText("");
					for (int i = 0; i < nombre.length; i++) {
						if(nombre[i] == null) {
							nombre[i] = n;
							cargo[i] = c;
							sueldo[i] = s;
							fechaIngreso[i] = f;
							JOptionPane.showMessageDialog(null, n + " registrado con la nomina "+ i);
							break;
						}
					}
					
				}
				catch(Exception e2) {
					JOptionPane.showMessageDialog(null, "Valores incorrectos.");
				}
			}
		});
		
		txtNomina = new JTextField();
		GridBagConstraints gbc_txtNomina = new GridBagConstraints();
		gbc_txtNomina.fill = GridBagConstraints.BOTH;
		gbc_txtNomina.gridwidth = 3;
		gbc_txtNomina.insets = new Insets(0, 0, 5, 5);
		gbc_txtNomina.gridx = 1;
		gbc_txtNomina.gridy = 0;
		frame.getContentPane().add(txtNomina, gbc_txtNomina);
		txtNomina.setColumns(10);
		
		btnBaja = new JButton("Baja");
		btnBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int nomina;
				try {
					nomina = Integer.parseInt(txtNomina.getText());
					nombre[nomina] = null;
					cargo[nomina] = null;
					sueldo[nomina] = 0;
					fechaIngreso[nomina] = null;
				}
				catch (Exception e3) {
					JOptionPane.showMessageDialog(null, "Ingresa una nómina válida.");
				}
			}
		});
		
		JButton btnNomina = new JButton("Buscar");
		GridBagConstraints gbc_btnNomina = new GridBagConstraints();
		gbc_btnNomina.insets = new Insets(0, 0, 5, 5);
		gbc_btnNomina.gridx = 2;
		gbc_btnNomina.gridy = 1;
		frame.getContentPane().add(btnNomina, gbc_btnNomina);
		btnNomina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				int nomina;
					nomina = Integer.parseInt(txtNomina.getText());
					if(nombre[nomina] == null) {
						JOptionPane.showMessageDialog(null, "Esta nómina no está asignada.");
					}
					else {
						JOptionPane.showMessageDialog(null,
								"Nómina: " + nomina + "\n"+
								"Nombre: " + nombre[nomina] + "\n"+
								"Cargo: " + cargo[nomina] + "\n"+
								"Sueldo: $" + sueldo[nomina] + " mx\n"+
								"Fecha de Ingreso: " + fechaIngreso[nomina] + "\n");
					}
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "Ingresa una nómina válida.");
				}
				
			}
		});
		GridBagConstraints gbc_btnBaja = new GridBagConstraints();
		gbc_btnBaja.insets = new Insets(0, 0, 5, 5);
		gbc_btnBaja.gridx = 3;
		gbc_btnBaja.gridy = 1;
		frame.getContentPane().add(btnBaja, gbc_btnBaja);
		
		btnAsignar = new JButton("Asignar");
		GridBagConstraints gbc_btnAsignar = new GridBagConstraints();
		gbc_btnAsignar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAsignar.gridx = 1;
		gbc_btnAsignar.gridy = 2;
		frame.getContentPane().add(btnAsignar, gbc_btnAsignar);
		GridBagConstraints gbc_btnAlta = new GridBagConstraints();
		gbc_btnAlta.insets = new Insets(0, 0, 5, 0);
		gbc_btnAlta.gridx = 7;
		gbc_btnAlta.gridy = 2;
		frame.getContentPane().add(btnAlta, gbc_btnAlta);
		
		lblDias = new JLabel("Días laborados");
		GridBagConstraints gbc_lblDias = new GridBagConstraints();
		gbc_lblDias.insets = new Insets(0, 0, 5, 5);
		gbc_lblDias.gridx = 1;
		gbc_lblDias.gridy = 3;
		frame.getContentPane().add(lblDias, gbc_lblDias);
		
		lblNombre = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.gridx = 6;
		gbc_lblNombre.gridy = 3;
		frame.getContentPane().add(lblNombre, gbc_lblNombre);
		
		altaNombre = new JTextField();
		GridBagConstraints gbc_altaNombre = new GridBagConstraints();
		gbc_altaNombre.insets = new Insets(0, 0, 5, 0);
		gbc_altaNombre.gridx = 7;
		gbc_altaNombre.gridy = 3;
		frame.getContentPane().add(altaNombre, gbc_altaNombre);
		altaNombre.setColumns(10);
		
		txtLaborados = new JTextField();
		GridBagConstraints gbc_txtLaborados = new GridBagConstraints();
		gbc_txtLaborados.insets = new Insets(0, 0, 5, 5);
		gbc_txtLaborados.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLaborados.gridx = 1;
		gbc_txtLaborados.gridy = 4;
		frame.getContentPane().add(txtLaborados, gbc_txtLaborados);
		txtLaborados.setColumns(10);
		
		lblCargo = new JLabel("Cargo");
		GridBagConstraints gbc_lblCargo = new GridBagConstraints();
		gbc_lblCargo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCargo.anchor = GridBagConstraints.EAST;
		gbc_lblCargo.gridx = 6;
		gbc_lblCargo.gridy = 4;
		frame.getContentPane().add(lblCargo, gbc_lblCargo);
		
		altaCargo = new JTextField();
		GridBagConstraints gbc_altaCargo = new GridBagConstraints();
		gbc_altaCargo.insets = new Insets(0, 0, 5, 0);
		gbc_altaCargo.gridx = 7;
		gbc_altaCargo.gridy = 4;
		frame.getContentPane().add(altaCargo, gbc_altaCargo);
		altaCargo.setColumns(10);
		
		lblSueldo = new JLabel("Sueldo");
		GridBagConstraints gbc_lblSueldo = new GridBagConstraints();
		gbc_lblSueldo.insets = new Insets(0, 0, 5, 5);
		gbc_lblSueldo.anchor = GridBagConstraints.EAST;
		gbc_lblSueldo.gridx = 6;
		gbc_lblSueldo.gridy = 5;
		frame.getContentPane().add(lblSueldo, gbc_lblSueldo);
		
		altaSueldo = new JTextField();
		GridBagConstraints gbc_altaSueldo = new GridBagConstraints();
		gbc_altaSueldo.insets = new Insets(0, 0, 5, 0);
		gbc_altaSueldo.gridx = 7;
		gbc_altaSueldo.gridy = 5;
		frame.getContentPane().add(altaSueldo, gbc_altaSueldo);
		altaSueldo.setColumns(10);
		
		lblFecha = new JLabel("Fecha");
		GridBagConstraints gbc_lblFecha = new GridBagConstraints();
		gbc_lblFecha.insets = new Insets(0, 0, 0, 5);
		gbc_lblFecha.anchor = GridBagConstraints.EAST;
		gbc_lblFecha.gridx = 6;
		gbc_lblFecha.gridy = 6;
		frame.getContentPane().add(lblFecha, gbc_lblFecha);
		
		altaFecha = new JTextField();
		GridBagConstraints gbc_altaFecha = new GridBagConstraints();
		gbc_altaFecha.gridx = 7;
		gbc_altaFecha.gridy = 6;
		frame.getContentPane().add(altaFecha, gbc_altaFecha);
		altaFecha.setColumns(10);
	}
}
