/*
 * @ Autor: Profa: Adriana Vega Palos


 * @ fecha: 
 * @ Versión: 1.0
 * @ Descripción: LLama a otra Clase
 */


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Ejemplo11 extends JFrame implements ActionListener {
    private JButton continuar;                     //@llama botón
    public JLabel clave, mensaje;                  //@instancia Etiqueta
    static int saldo=20000;                       //@Variable se pasa como parámetro 
    public JPasswordField password = new JPasswordField();
    public JTextField contra = new JTextField();  /*Instancia Caja de Texto
                                                   *Para que el usuario ingrese 
                                                   *su clave*/
 
    public static void main(String[] args) {    //@Declara clase 
            new Ejemplo11();                   //@ instancia clase
        
       
    }
   public Ejemplo11(){
	   this.setLayout(null);
	   this.setSize(400, 400);                    //@tamaño de la ventana
	   this.setTitle("..:: Conectarse ::.."); //@título de laventana
	   this.setVisible(true);
	   this.setResizable(true);
	   this.setLocationRelativeTo(null);
	   this.setDefaultCloseOperation(Ejemplo11.EXIT_ON_CLOSE);
   
      continuar = new JButton("Da click"); //@botón para pasar a la siguiente ventana 
      add(continuar);
      continuar.setBounds(100, 90, 100, 25);
      continuar.addActionListener(this);
   
      add(password);
      password.setBounds(100, 50, 100, 22);
      
      clave=new JLabel ("LLame a Menu ");
      add(clave);
      clave.setBounds(100,20,100,25);
      
      mensaje=new JLabel ("escribe 4 números o letras");
      add(mensaje);
      mensaje.setBounds(200,20,180,25);
      
    }
    
    
 public void actionPerformed(ActionEvent event) { //@evento 
     if (event.getSource()== continuar){           //@Valida Botón 
        
    /*@ valida que la caja de texto tenga un valor y 
     * length indica el numero de caracteres que acepta la clave 
     * 
     */
    if(password.getPassword().length == 0 || password.getPassword().length>4){ 
             JOptionPane.showMessageDialog(null, "Por favor ingrese solo 4 caracteres", 
      "::::: ERROR :::::", JOptionPane.WARNING_MESSAGE); //@mensaje de error
          }
          else{
             dispose();           //@destruye formulario 
            new Ejemplo12(saldo);  /*@llama a laclase  y 
                                      *pasa la variable PARA INCREMENTAR
                                     *el valor como parámetro*/
          }
       }
    }
 }