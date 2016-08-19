package utilidades;


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Platilla creacion de GUI
 * @author Diego Gonzalez del Rio
 */


public class GUI {

  //Componentes de la GUI instanciados
  private JFrame ventana;
  private JLabel etiqueta;
  private JTextField campo;
  private JButton boton;

  //Construcor sin parámetros
  public GUI(){
    iniciarGUI();
  }

  /**
  * Método encargado de crear la GUI y mostrarla
  */
  private void iniciarGUI(){
    instanciarGUI();
    configurarGUI();
    agregarAGUI();
    accionesGUI();
    mostrarGUI();
  }

  /**
  * Método encargado de Instancia los elementos que forman la GUI
  */
  private void instanciarGUI(){
    ventana = new JFrame("Ejemplo de ventana");
    etiqueta = new JLabel("Ejemplo de etiqueta");
    campo = new JTextField(10); //Tamaño del campo
    boton = new JButton("Boton de ejemplo");
  }
  /**
  * Método encargado de configurar los elementos
  */
  private void configurarGUI(){
  ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  ventana.setLayout(new FlowLayout());
  }

  /**
  * Método que añade los elementos a la ventana
  */
  private void agregarAGUI(){
  ventana.add(etiqueta);
  ventana.add(campo);
  ventana.add(boton);
  //Se llama a pack después de haber agregado componenetes a la ventana
  ventana.pack();
  }

  /**
  * Método encargado de añadir los listenners
  */
  private void accionesGUI(){
    //Ejemplo de como añadir un listener de acción a un botón:
  boton.addActionListener(new ActionListener(){
   public void actionPerformed(ActionEvent e) {
    //Ponemos aquí las acciones a realizar si damos click al botón:
    accionesBoton();
    }});
  }

  private void accionesBoton(){
  JOptionPane.showMessageDialog(null, "Has dado click en el botón");
 }


    private void mostrarGUI() {
        ventana.setVisible(true);
    }
}
