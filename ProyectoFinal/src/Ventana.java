/**  
** @Clase: 		Ventana.java
** @Autor: 		Karla Jazmín Ramírez Domínguez
** @Grupo:		62B
** @Profesora: 	Adriana Vega Palos
** @Fecha: 		Diciembre2021-Enero2022
** @Descripción: Ventana del juego
*/ 
import java.awt.Color;

import javax.swing.JFrame;

public class Ventana {
	static int vidas = 5;
	static String jugador = "Usuario";
	public static void main(String args[]){
        new Ventana(jugador);  
    }
	public Ventana(String nombree){
		JFrame ventana = new JFrame("Teclado");
		jugador = nombree;
		
		ventana.getContentPane().setBackground(new Color(0, 0,0));
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.add(new Videojuego(vidas));
		ventana.setTitle("GAME by " + jugador);
		ventana.setSize(800, 600);
		ventana.setVisible(true);
		ventana.setLocationRelativeTo(null);
		ventana.setResizable(false);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	


}
