/**  
** @Clase: 		Name.java
** @Autor: 		Karla Jazmín Ramírez Domínguez
** @Grupo:		62B
** @Profesora: 	Adriana Vega Palos
** @Fecha: 		Diciembre2021-Enero2022
** @Descripción: Pantalla de verificación del nombre
*/ 
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Name extends JFrame implements ActionListener {
	private JLabel fin;
	private JLabel nombre;
	public JTextField player = new JTextField();
	private JButton continuar;
	String jugador;
	private JPanel panel1;
	private ImageIcon  img1;
	
	public static void main (String [] ar) 
	{
		new Name ();
		
		
	}
	
	public Name() {
		this.setBounds(50,50, 800, 600);
		this.setTitle("Nombre jugador");
		this.setVisible(true);
		setLayout(null);
		this.getContentPane().setBackground(new Color(39, 75, 138));
		Font letra = new Font("Comic Sans MS",Font.BOLD,30);
		Font letra2 = new Font("Comic Sans MS",Font.BOLD,20);
		
		fin = new JLabel("Ingresa tu nombre de jugador: ");
		//fin = new JLabel("GANASTE");
		fin.setBounds(180, 30, 810, 50);
		fin.setFont(letra);
		fin.setForeground(Color.WHITE);
		add(fin);
		
		
		player.setBounds(220, 120, 350, 70); 
        player.addActionListener(this);
        player.setFont(letra2);
    	add(player);
    	
    	panel1 = new JPanel ();
		panel1.setBounds(150, 330, 460, 220);
		panel1.setBackground(new Color(39, 75, 138));
		add(panel1);
		
    	continuar = new JButton ("Continuar");
    	continuar.setBounds(270, 240, 180, 50);
    	continuar.setFont(letra2);
    	continuar.addActionListener(this);
		add(continuar);
	}
	public void paint(Graphics g) {

        super.paint(g);
        img1 = new ImageIcon(new ImageIcon("puppie.png").getImage().getScaledInstance(220, 220, Image.SCALE_DEFAULT));
        Graphics lic = panel1.getGraphics();

        img1.paintIcon(this, lic, 110,0);
	}
	
	public void actionPerformed(ActionEvent event) {
		
		Object origen= event.getSource();
		if (origen==continuar) {
			
			if(player.getText().length() == 0  ){ 
                JOptionPane.showMessageDialog(null, "Por favor ingrese su nombre."); //@mensaje de error
            }
			else if(player.getText().length()>8) {
				JOptionPane.showMessageDialog(null, "El nombre del jugador debe ser menor o igual a 8 carácteres. \nIntente de nuevo."); 
			}
			else
			{
				jugador = player.getText();
				new Ventana(jugador);
				dispose();
			}
        }
	}

	
}
