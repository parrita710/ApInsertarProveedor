package procesos;

import GUI.GUI;

import javax.swing.SwingUtilities;


public class Principal {
    public static void main(String[] args) {
        /**
        InsertarProveedores insertarProveedores;
        insertarProveedores = new InsertarProveedores();
        insertarProveedores.insertarProveedores();
        */
        //GUI gui;
        //gui = new GUI();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GUI();
            }
        });
    }
}
