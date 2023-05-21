/**  
** @Clase: 		Juego.java
** @Autor: 		Karla Jazmín Ramírez Domínguez
** @Grupo:		62B
** @Profesora: 	Adriana Vega Palos
** @Fecha: 		Diciembre2021-Enero2022
** @Descripción: Parte lógica y de componentes deljuego
*/ 
import javax.imageio.ImageIO;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.util.Random;

public class Juego  {
	//private JPanel prueba = new JPanel ();

	//	Atributos
	
	private String jugador;
	private int obX, iniobY, iniobX, obY, obAlto, obAncho, iniobX2, iniobY2, obX2, obY2, obAlto2, obAncho2;
	private int jugadorX, jugadorY, jugadorAncho, jugadorAlto, finX, finY, finAlto, finAncho;
	private Image imagen, imgFin, zombie1, zombie2, fondo; //Gurda el mapa de bits, no la imagen
	static int vidas = 0;
	private int cuenta=0;
	//Constructor
	public Juego () {
		jugadorX=10;
		jugadorY=10;
		
		jugadorAncho = 105;
		jugadorAlto = 96;
		
		finX = 580;
		finY = 385;
		
		finAncho = 200;
		finAlto = 170;
		
		obX = 865;
		obY = -100;
		obAncho = 57;
		obAlto = 95;
		
		obX2 = 900;
		obY2= -100;
		obAncho2 = 57;
		obAlto2 = 95;
		
		iniobY = -105;
		
		ImageIcon img = new ImageIcon(this.getClass().getResource("puppie.png"));
		imagen = img.getImage();
		
		ImageIcon fin = new ImageIcon(this.getClass().getResource("casa.png"));
		imgFin = fin.getImage();
		
		ImageIcon zo1 = new ImageIcon(this.getClass().getResource("zombie1.png"));
		zombie1 = zo1.getImage();
		
		ImageIcon zo2 = new ImageIcon(this.getClass().getResource("zombie1.png"));
		zombie2 = zo2.getImage();
		
		ImageIcon fon = new ImageIcon(this.getClass().getResource("fondo.png"));
		fondo = fon.getImage();
	}
	//Método para detectar teclas
	public void keyPressed (KeyEvent e) {
		if(e.getKeyCode()==37) //izquierda
		{
		
			if(jugadorX>0)
			{
				jugadorX-=7;
			}
		
		}
		if(e.getKeyCode()==39) //derecha
		{
			if(jugadorX<680)
			{
				jugadorX+=7;
			}
		}
		
		if(e.getKeyCode()==38) //arriba
		{
			if(jugadorY>0)
			{
				jugadorY-=7;
			}
		}
		if(e.getKeyCode()==40) //abajo
		{
			if(jugadorY<480)
			{
				jugadorY+=7;
			}
		}
	}
	//Mover a los zombies
		public void inicioZ1(){
			Random random = new Random();
			int z = random.nextInt(2)+1;
			int y =z;
			int x = random.nextInt(480)+20;
			
			obX = x;
			if(y==1) {
				iniobY = -105;
			}
			else if (y==2) {
				iniobY = 705;
			}
			obY = iniobY;
			System.out.println("numero Y"+ z);
		
		}
		public void inicioZ2(){
			Random random = new Random();
			
			int y = random.nextInt(500)+1;
			obY2 = y;
			obX2 = 865;
			
			//obY2 = iniobY2;
			
			System.out.println("numero X------");
		}
		
		public void moverZ1(){
			if(iniobY==-105)
			{
				obY+=4;
			}
			else {
				obY-=4;
			}
			
		}
		public void moverZ2(){
			
			obX2 -=4;
			
		}
		public boolean salioPantalla1(){
			boolean indicador = false;
			if(obY<-105 || obY>705) {
				indicador = true;
			}
			return indicador;
		}
		public boolean salioPantalla2(){
			boolean indicador = false;
			if(obX2<0 || obX2>865) {
				indicador = true;
			}
			return indicador;
		}
	//para tener coordenadas
	public int tenerX () {
		return jugadorX;
	}
	public int tenerY () {
		return jugadorY;
	}
	public  Image tenerImagen() {
		return imagen;
	}
	public  Image tenerImgFin() {
		return imgFin;
	}
	public int casaX () {
		return finX;
	}
	public int casaY () {
		return finY;
	}
	
	public  Image fondoImg() {
		return fondo;
	}
	//para zombies
	public  Image imgZo1() {
		return zombie1;
	}
	
	public  Image imgZo2() {
		return zombie2;
	}
	public int zomX () {
		return obX;
	}
	public int zomY () {
		return obY;
	}
	public int zomX2 () {
		return obX2;
	}
	public int zomY2 () {
		return obY2;
	}
	
	
	
	public boolean ganar () {
		boolean resultado;
		if(jugadorX > finX+70+finAncho)
		{
			 resultado = false;
		}
		else if(jugadorX+jugadorAncho< finX+70)
		{
			resultado = false;
		}
		else if(jugadorY > finY+finAlto+95)
		{
			resultado = false;
			
		}
		else if(jugadorY+jugadorAlto < finY+95)
		{
			resultado = false;
			
		}
		else
		{
			resultado = true;
		}
		return resultado;
		
		
	}
	
	//colisiones con zombies
	public boolean choque () {
		boolean resultado;
		if(jugadorX > obX+obAncho )//&& jugadorX > obX2+obAncho2)
		{
			 resultado = false;
		}
		else if(jugadorX+jugadorAncho< obX )//&& jugadorX+jugadorAncho< obX2)
		{
			resultado = false;
		}
		else if(jugadorY > obY+obAlto)// && jugadorY > obY2+obAlto2)
		{
			resultado = false;
		}
		else if(jugadorY+jugadorAlto < obY )//&& jugadorY+jugadorAlto < obY2)
		{
			resultado = false;
			
		}
		
		
		else
		{
			resultado = true;
		}
		return resultado;
		
		
	}
	
	public boolean choque2 () {
		boolean resultado;
		if( jugadorX > obX2+obAncho2)
		{
			 resultado = false;
		}
		else if( jugadorX+jugadorAncho< obX2)
		{
			resultado = false;
		}
		else if( jugadorY > obY2+obAlto2)
		{
			resultado = false;
		}
		else if( jugadorY+jugadorAlto < obY2)
		{
			resultado = false;
			
		}
		
		
		else
		{
			resultado = true;
		}
		return resultado;
		
		
	}
	
	public void iniValores () {
		jugadorX=10;
		jugadorY=10;
	}
}
	/*public void keyPressed (KeyEvent e) {
		if(e.getKeyCode()==37) //izquierda
		{
			
		}
		if(e.getKeyCode()==39) //derecha
		{
					
		}
		
		if(e.getKeyCode()==38) //arriba
		{
			
		}
		if(e.getKeyCode()==40) //abajo
		{
			
		}
	}
	public Juego () {
		addKeyListener(new KeyListener () {
			public void kyPressed(KeyEvent e) {
				keyPressed(e)
			}
		});
	}*/
	/*public void keyTyped(KeyEvent event) {
	    if (event.getKeyChar() == 37) {
	       
	    }
	    if (event.getKeyChar() == 39) {
	       
	    }
	    if (event.getKeyChar() == 38) {
	       
	    }
	    if (event.getKeyChar() == 40) {
	       
	    }
	}*/
	
	
