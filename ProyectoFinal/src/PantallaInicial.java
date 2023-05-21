/**  
** @Clase: 		PantallaInicial.java
** @Autor: 		Karla Jazmín Ramírez Domínguez
** @Grupo:		62B
** @Profesora: 	Adriana Vega Palos
** @Fecha: 		Diciembre2021-Enero2022
** @Descripción: Pantalla principal del videojuego
*/ 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import static javax.swing.JOptionPane.showMessageDialog;

public class PantallaInicial extends JFrame implements ActionListener, ItemListener {
	private JLabel nombre, nameJugador;
	private JPanel panel1;
	private JButton salir, instrucciones, creditos, jugar;
	public JTextField player = new JTextField();
	private ImageIcon  img1, dog, zombie;
	
	
	public static void main (String [] ar) 
	{
		new PantallaInicial ();
		
	}
	public PantallaInicial() {
		this.setBounds(50,50, 800, 600);
		this.setTitle("Inicio");
		this.setVisible(true);
		this.setDefaultCloseOperation(PantallaInicial.EXIT_ON_CLOSE);
		Color fondoColor = new Color(39, 75, 138);
		Color colPanel = new Color(189, 235, 255);
		Color let = new Color(191, 235, 255);
		Font letra = new Font("Comic Sans MS",Font.BOLD,18);
		Font titulo = new Font("Ravie",Font.BOLD,57);
		this.getContentPane().setBackground(fondoColor);
		setLayout(null);
		
		//Panels con imágenes
		panel1 = new JPanel ();
		panel1.setBounds(40, 150, 390, 330);
		//panel1.setBackground(fondoColor);
		add(panel1);
		
    	
	
		nombre = new JLabel("RUN, RUN ¡GO!");
		nombre.setBounds(130, 25, 810, 100);
		nombre.setFont(titulo);
		nombre.setBackground(colPanel);
		nombre.setForeground(Color.WHITE);
		add(nombre);
		
		instrucciones = new JButton ("Instrucciones");
		instrucciones.setBounds(500, 150, 180, 50);
		instrucciones.setFont(letra);
		instrucciones.addActionListener(this);
		add(instrucciones);
		
		jugar = new JButton ("Jugar");
		jugar.setBounds(500, 250, 180, 50);
		jugar.setFont(letra);
		jugar.addActionListener(this);
		add(jugar);
		
		
		creditos = new JButton ("Créditos");
		creditos.setBounds(500, 350, 180, 50);
		creditos.setFont(letra);
		creditos.addActionListener(this);
		add(creditos);
		
		salir = new JButton ("Salir");
		salir.setBounds(500, 450, 180, 50);
		salir.setFont(letra);
		salir.addActionListener(this);
		add(salir);
		
	}
	public void paint(Graphics g) {

        super.paint(g);
        img1 = new ImageIcon(new ImageIcon("fondo.png").getImage().getScaledInstance(390, 330, Image.SCALE_DEFAULT));
        dog = new ImageIcon(new ImageIcon("puppie.png").getImage().getScaledInstance(110, 110, Image.SCALE_DEFAULT));
        zombie = new ImageIcon(new ImageIcon("zombie1.png").getImage().getScaledInstance(80, 120, Image.SCALE_DEFAULT));
        Graphics lic = panel1.getGraphics();

        img1.paintIcon(this, lic, 0,0);
        zombie.paintIcon(this, lic, 280,100);
        dog.paintIcon(this, lic, 39,100);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		Object origen= event.getSource();
		if (origen==creditos) {
			dispose();  
			new PantallaDatos ();
        }
		else if (origen==instrucciones) {
			JOptionPane.showMessageDialog(null,"                           ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n"
					+ "					                                           Bienvenido al juego Run, Run ¡Go!\n"
					+ "							                           ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n"
					+ "					\n-El objetivo principal del juego es que nuestro perrito, que se "
					+ "					ha quedado solo en el jardín de su casa, logre llegar\na salvo a su casa, "
					+ "					evitando ser devorado por los terroríficos zombies que ya acechan su jardín."
					+ "					\n\n"
					+ "					\n-El personaje se puede mover en las distintas direcciones (arriba, abajo,"
					+ "					dercha o a la izquierda) con ayuda\n de las teclas de dirección (las flechas) "
					+ "					de nuestro teclado."
					+ "					\n-El personaje comenzará con un estado inicial de 5 vidas."
					+ "					\n-Se considera que el zombie se ha comido al perrito al mínimo toque entre "
					+ "					el perrito y el zombie."
					+ "					\n-Una vez perdidas las 5 vidas, el juego termina.\n"
					+ "					-Se gana el juego cuando el personaje llega a su casa con mínimo una vida.\n"
					+ "					\n\n¿Te atreves a adentrarte a esta aventura?" );
        }
		else if (origen==jugar) {
			dispose();
			new Name();
			
        }
		else if (origen==salir) {
			System.exit(0);
        }
		
	}
}

