/*
 * @ Autor: Profa: Adriana Vega Palos

 * @ fecha: 
 * @ Versi�n: 1.0
 * @ Descripci�n: Lleva a cabo operaciones y recibe parametros
 */


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

 public class Ejemplo13 extends JFrame implements ActionListener{
     //@@Declara variables publicas ylas inicializa
        public int incremento = 0; 
        public int retiro = 0;
        public int compra, var= 0;
        
        //@LLama objetos
        private JButton regresar; //@@para volver al men� principal
        public JTextField nvoinc = new JTextField(); //@para ingresar la cantidad 
        public JLabel cantidad = new JLabel("Ingrese la Cantidad y presiona ENTER ");
        
        public int sal = 0; //@@variable a la que se le asignar� el valor del par�metro 
        private Ejemplo12 sigue; //@@clase 
 
        public Ejemplo13( int saldo){ //@pasa la variable saldo de la clase principal 
               this.setLayout(null);
               this.setSize(400, 400); //@tama�o de ventana
               this.setTitle("..:: Operacion :::.."); //@t�tulo de ventana
               this.setVisible(true);
               this.setResizable(true);
               this.setLocationRelativeTo(null);
               
               add(nvoinc);
               nvoinc.setBounds(100, 90, 200, 50); //@posiciona al cuadro de texto 
               nvoinc.addActionListener(this);     //@le asigna un evento 
     
               add(cantidad);
               cantidad.setBounds(100, 50, 220, 50); //@posiciona en el JLabel 
               regresar = new JButton ("Regresar");
               
               add(regresar);
               regresar.setBounds(100,150,100,25);//@posiciona el bot�n de regreso
               regresar.addActionListener(this);  //@le asigna un evento 
               sal=saldo;                         //@iguala las variables para poder manejar el valor real.
         }
        
        public void actionPerformed(ActionEvent event) { //@evento 
               if(event.getSource()==regresar){ //@si se oprime el bot�n de regresar
                
                 String nvoincVariable;
                 int nvoincVar;
                 
                 nvoincVariable = nvoinc.getText();
                 incremento= Integer.parseInt(nvoincVariable);
                 
                 
                 //incremento = nvoincVar;
                 sal=sal+incremento;
                 //JOptionPane.showMessageDialog(null, "valor digitado" + "    " + incremento + "variable sal  " + sal);
                    dispose(); //@destruye la ventana anterior
                    var=1; //@bandera 
                    new Ejemplo12(sal); //@nueva clase 
                }
               if(var==0){ //@si  no se ha oprimido el bot�n de regresar
 
                 if(nvoinc.getText().length() == 0 || nvoinc.getText().length()>8  ){ 
                      JOptionPane.showMessageDialog(null, "Por favor ingrese datos validos",
                       "::::: ERROR :::::", JOptionPane.WARNING_MESSAGE); //@mensaje de error
                  }
                 else{
                     incremento = Integer.parseInt(nvoinc.getText()); 
                     if(incremento==0){ //@si el incremento dado es nulo 
                          JOptionPane.showMessageDialog(null, 
                                 "Por favor ingrese valores num�ricos",
                              "::::: ERROR :::::", JOptionPane.WARNING_MESSAGE); //@mensaje de error
                      }
       
                      else{
                          //@ ESTE HACE QUE SE VEA DE NUEVO EL SALDO AL REGRESAR A MENU Y LO INCREMENTA
                          sal=sal+incremento; //@si cumple Aumenta el saldo 
                          JOptionPane.showMessageDialog(null, "Se Aumento la cantidad  "+incremento+"   ", 
                           "::::: Listo :::::", JOptionPane.INFORMATION_MESSAGE);
                          dispose(); //@destruye ventana
                          JOptionPane.showMessageDialog(null, "valor digitado" + incremento + "variable sal" + sal);
                          new Ejemplo12(sal); //@el nuevo saldo va a la clase principal
     
                      }
                }
             }
         }
 }  