/*
 * @ Autor: Profa: Adriana Vega Palos
 * @ fecha: 
 * @ Versión: 1.0
 * @ Descripción: Muestra un menú creado con botones y llama a otra clase
 */


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Ejemplo12 extends JFrame implements ActionListener{
     private JButton incrementar,consultar,imprimir,salir; 
     private JPanel panel;
     public JTextField nvoinc = new JTextField();
     static int cantidad = 0; //@@variable parámetro 
     public int incremento = 0;
     public int ya=0;
     private Ejemplo13 sigue;

     public static void main(String args[]){
         new Ejemplo12(cantidad); //@Llamo a la clase 
     }
  
  public Ejemplo12(int sal){ //@sal es el parámetro, la variable cantidad. 
      cantidad=sal; //@se igualan las variables para tener el nuevo valor 
      this.setLayout(null);
      this.setSize(400, 400); //@tamaño de ventana
      this.setTitle("..:: Menu2  :::.."); //@título de la ventana 
      this.setVisible(true);
      this.setResizable(true);
      this.setLocationRelativeTo(null);
 
         incrementar = new JButton("Incrementar  ");
         add(incrementar);
         incrementar.setBounds(100, 150, 200, 25);
         incrementar.addActionListener(this);
        
         consultar = new JButton("Consultar ");
         add(consultar);
         consultar.setBounds(100, 200, 200, 25);
         consultar.addActionListener(this);
 
         imprimir = new JButton("Mensaje");
         add(imprimir);
         imprimir.setBounds(100, 250, 200, 25);
         imprimir.addActionListener(this);
         
         salir = new JButton("salir");
         add(salir);
         salir.setBounds(100, 300, 200, 25);
         salir.addActionListener(this);
        
 }


     public void actionPerformed(ActionEvent event) { //@evento 
           if (event.getSource()== incrementar){ //@si el usuario decide pasar alguna cantidad 
                dispose(); //@destruye la ventana 
                new Ejemplo13 (cantidad); /*llama a la clase operacion, la cual incrementa la cantidad de 
                                           *acuerdo a la cantidad  que quiera ingresar el usuario */
            }
       
           if (event.getSource()== consultar){ //@si se necesita consultar el cantidad 
                  JOptionPane.showMessageDialog(null, "Muestra cantidad \nque se tiene en este momento   \n " + cantidad, ":: Listo :: ", 
                                                JOptionPane.INFORMATION_MESSAGE); //@pop up con cantidad 
            }
           if (event.getSource()== imprimir){
                  JOptionPane.showMessageDialog(null, " Esta es una aplicación que une varias clases...", "::::: Listo :::::",
                                               JOptionPane.INFORMATION_MESSAGE); //@pop up de mensaje 
    
      }
           if (event.getSource()== salir){
               JOptionPane.showMessageDialog(null, " Se Cerrará la aplicación...", "::::: Ok :::::",
                                            JOptionPane.INFORMATION_MESSAGE); //@pop up de mensaje 
                  System.exit(0);
   }

           
}

}