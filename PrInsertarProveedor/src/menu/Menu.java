package menu;

import java.io.IOException;

import utilidades.UtilidadesES;

/**
 * Encapsula el proceso de mostrar el menú y devolver la opción seleccionada.
 */
public class Menu {
    /**
     * Encapsula el proceso de comunicación con el usuario.
     * @aggregation shared
     */
    private UtilidadesES utilidades;

    /**
     * Constructor que recibe el preceso de comunicación con el usuario.
     * @param utilidadesES
     */
    public Menu(UtilidadesES utilidadesES) {
        this.utilidades = utilidadesES;
    }

    /**
     * Presenta en pantalla el menú principal de la aplicación
     * @param opcionesMenu, recibe las opciones a presentar.
     * @return opc, devuelve la opción seleccionada.
     */
    public int presentaMenu(OpcionesMenu opcionesMenu) {
        int opc;
        int numOpciones;
        do {
            numOpciones = 0;
            int indice = 0;
            for (String opcion : opcionesMenu) {
                utilidades.mostrarln(indice + " " + opcion);
                indice++;
                numOpciones++;
            }
            opc = leeOpcMenu();
            if (opc <= -1 || opc > (numOpciones-1)) {
                utilidades.mostrarln("Esa opci�n no esta disponible, intentelo otra vez.");
            }
            ;
        } while (opc <= -1 || opc > (numOpciones-1));
        return opc;
    }

    /**
     * Obtiene la opción seleccionada por el usuario.
     * @return devuelve la opción seleccionada.
     */
    private int leeOpcMenu() {
        int opc = -1;
        try {
            opc = Integer.parseInt(utilidades.pideCadena("Seleccione una opcion:"));
        } catch (NumberFormatException ex) {
            utilidades.mostrarln("No es un numero, intentelo otra vez.");
        } catch (IOException ioe) {
            utilidades.mostrarln("Se ha producido un error al leer desde teclado.");
        }
        return opc;
    }
}