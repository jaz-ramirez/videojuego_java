/**  
** @Clase: 		Videojuego.java
** @Autor: 		Karla Jazmín Ramírez Domínguez
** @Grupo:		62B
** @Profesora: 	Adriana Vega Palos
** @Fecha: 		Diciembre2021-Enero2022
** @Descripción: Parte gráfica del videojuego, creador del panel
*/ 
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.JPanel;

public class Videojuego extends JPanel implements ActionListener {
	
	Juego jugador = new Juego();
	
	Timer timer = new Timer(5, this);
	static int vidas = 5;
	public boolean chocar= false, chocar2= false, salirPantalla1=false, salirPantalla2=false, win=false;
	//Constructor
	 public static void main(String args[]){
         new Videojuego(vidas);
     }
	public Videojuego (int life) {
		this.setBackground(new Color(0,0,0));
		setFocusable(true);
		addKeyListener (new teclado());
		timer.start ();
		life=vidas;
	}
	
	public void paint (Graphics grafica) {
		super.paint(grafica);
		Graphics2D g2 = (Graphics2D)grafica;
		
		
		g2.drawImage(jugador.fondoImg(), -30,0, null);
		
		
		g2.drawImage(jugador.tenerImgFin(), jugador.casaX(), jugador.casaY(), null);
		g2.drawImage(jugador.tenerImagen(), jugador.tenerX(), jugador.tenerY(), null);
		
		g2.drawImage(jugador.imgZo1(), jugador.zomX(), jugador.zomY(), null);
		g2.drawImage(jugador.imgZo2(), jugador.zomX2(), jugador.zomY2(), null);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		chocar = jugador.choque();
		chocar2 = jugador.choque2();
		//System.out.println("Valor " + chocar);
		salirPantalla1 = jugador.salioPantalla1();
		salirPantalla2 = jugador.salioPantalla2();
		win = jugador.ganar();
		
		jugador.moverZ1();
		jugador.moverZ2();
		
		if(salirPantalla1)
		{
			jugador.inicioZ1();
		}
		if(salirPantalla2)
		{
			jugador.inicioZ2();
			
		}
	
		if(chocar||chocar2)
		{
			vidas--;
			jugador.iniValores();
			jugador.inicioZ1();
			jugador.inicioZ2();
			if(vidas > 0)
			JOptionPane.showMessageDialog(null, "Haz perdido una vida, te quedan " + vidas + " vidas" );
		}
		if(vidas >= 1 )
		{
			repaint();
			
		}
		else if(vidas == 0 )
		{
			
			JOptionPane.showMessageDialog(null,"xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n"
					+ "							                GAME OVER\n                  PERDISTE\n"
					+ "							xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			System.exit(0);
			new Ganar();
		}
		if(win)
		{
			JOptionPane.showMessageDialog(null,"xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n"
					+ "							               FELICIDADES\n                GANASTE\n"
					+ "							xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			System.exit(0);
			jugador.iniValores();
			
		}
		
	}
	
	

	class teclado extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			jugador.keyPressed(e);
		}
	}

	
	
	//private JPanel panel1;
	//private int jugadorX, jugadorY, jugadorAncho, jugadorAlto, finX, finAlto, finAncho;
	
	
	

	/*public static void main (String [] ar) 
	{
		JFrame ventana = new JFrame ("Teclado");
		ventana.add(new Juego());
		ventana.setSize(400, 400);
		ventana.setVisible(true);
		
	}
	public Videojuego(){

		this.setBounds(50,50, 1000, 700);
		this.setTitle("Juego");
		this.setVisible(true);
		setLayout(null);
		
		panel1 = new JPanel ();
		panel1.setBounds(10,10, 100, 100);
		panel1.setBackground(Color.pink);
		add(panel1);
		
		
	}
	public void paint (Graphics g) {
		ImageIcon personaje = new ImageIcon(getClass().getResource(""));
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}*/
}