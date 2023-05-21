/**  
** @Clase: 		PantallaDatos.java
** @Autor: 		Karla Jazmín Ramírez Domínguez
** @Grupo:		62B
** @Profesora: 	Adriana Vega Palos
** @Fecha: 		Diciembre2021-Enero2022
** @Descripción: Pantalla de datos
*/ 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import static javax.swing.JOptionPane.showMessageDialog;

public class PantallaDatos extends JFrame implements ActionListener, ItemListener {
	private JLabel escuela, unam, nombre, profe, grupo, fecha, derechos;
	private JPanel panel1, panelLic, panel;
	private JButton salir, inicio;
	private ImageIcon  img1;
	
	public static void main (String [] ar) 
	{
		new PantallaDatos ();
		
		
	}
	public PantallaDatos() {
		this.setBounds(50,50, 800, 600);
		this.setTitle("Inicio");
		this.setVisible(true);
		Color fondoColor = new Color(39, 75, 138);
		Color colPanel = new Color(122, 178, 255);
		Font letra = new Font("SERIF",Font.BOLD,22);
		Font titulo = new Font("Comic Sans MS",Font.BOLD,24);
		this.getContentPane().setBackground(fondoColor);
		setLayout(null);
		
		/*Panels con imágenes*/
		panel1 = new JPanel ();
		panel1.setBounds(50, 410, 220, 80);
		panel1.setBackground(colPanel);
		add(panel1);
		
		unam = new JLabel("UNAM");
		unam.setBounds(340, 10, 810, 50);
		unam.setFont(titulo);
		unam.setForeground(Color.WHITE);
		add(unam);
		
		escuela = new JLabel("Escuela Nacional preparatoria Plantel No. 6 \"Antonio Caso\"");
		escuela.setBounds(50, 60, 810, 50);
		escuela.setFont(titulo);
		escuela.setForeground(Color.WHITE);
		add(escuela);
		
		profe = new JLabel("Profesora: Adrianan Vega Palos");
		profe.setBounds(200, 350, 810, 50);
		profe.setFont(titulo);
		profe.setForeground(Color.WHITE);
		add(profe);
		
		grupo = new JLabel("Grupo: 61B, segundo año ETEC");
		grupo.setBounds(170, 140, 810, 50);
		grupo.setFont(titulo);
		grupo.setForeground(Color.WHITE);
		add(grupo);
		
		nombre = new JLabel("Creado por: Karla Jazmín Ramírez Domínguez");
		nombre.setBounds(110, 240, 810, 50);
		nombre.setFont(titulo);
		nombre.setForeground(Color.WHITE);
		add(nombre);
		
		fecha = new JLabel("ENERO 2022   -Todos los derechos reservados-");
		fecha.setBounds(310, 497, 710, 50);
		fecha.setFont(letra);
		fecha.setForeground(Color.WHITE);
		add(fecha);
		
		
		
		inicio = new JButton ("Inicio");
		inicio.setBounds(400, 450, 120, 30);
		//inicio.setFont(letra);
		inicio.addActionListener(this);
		add(inicio);
		
		salir = new JButton ("Salir");
		salir.setBounds(550, 450, 120, 30);
		//salir.setFont(letra);
		salir.addActionListener(this);
		add(salir);
	}
	
	public void paint(Graphics g) {

        super.paint(g);
        img1 = new ImageIcon(new ImageIcon("commons.png").getImage().getScaledInstance(220, 80, Image.SCALE_DEFAULT));
        Graphics lic = panel1.getGraphics();

        img1.paintIcon(this, lic, 0,0);
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		Object origen= event.getSource();
		if (origen==inicio) {
			dispose();  
			new PantallaInicial ();
        }
		else if (origen==salir) {
			System.exit(0);
        }
		
	}
}


