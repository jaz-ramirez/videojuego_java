import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ganar extends JFrame{
	private JLabel fin;
	
	public static void main (String [] ar) 
	{
		new Ganar ();
		
		
	}
	
	public Ganar() {
		this.setBounds(50,50, 800, 600);
		this.setTitle("Inicio");
		this.setVisible(true);
		
		Font titulo = new Font("SERIF",Font.BOLD,24);
		
		fin = new JLabel("GAME OVER");
		//fin = new JLabel("GANASTE");
		fin.setBounds(390, 10, 810, 30);
		fin.setFont(titulo);
		add(fin);
	}
}
