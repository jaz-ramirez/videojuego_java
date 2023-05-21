import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Instrucciones extends JFrame implements ActionListener{
	private JPanel panel1;
	private JLabel titulo;
	public static void main (String [] ar) 
	{
		new Instrucciones ();
		
	}
	public Instrucciones() {
		this.setBounds(50,50, 800, 600);
		this.setTitle("Inicio");
		this.setVisible(true);
		this.setDefaultCloseOperation(PantallaInicial.EXIT_ON_CLOSE);
		setLayout(null);
		Color colPanel = new Color(122, 178, 255);
		
		
		panel1 = new JPanel ();
		panel1.setBounds(50, 50, 680, 450);
		panel1.setBackground(colPanel);
		add(panel1);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
