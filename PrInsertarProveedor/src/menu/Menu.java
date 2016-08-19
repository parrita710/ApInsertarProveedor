package menu;

import java.io.IOException;

import utilidades.UtilidadesES;

/**
 * Encapsula el proceso de mostrar el men煤 y devolver la opci贸n seleccionada.
 */
public class Menu {
    /**
     * Encapsula el proceso de comunicaci贸n con el usuario.
     * @aggregation shared
     */
    private UtilidadesES utilidades;

    /**
     * Constructor que recibe el preceso de comunicaci贸n con el usuario.
     * @param utilidadesES
     */
    public Menu(UtilidadesES utilidadesES) {
        this.utilidades = utilidadesES;
    }

    /**
     * Presenta en pantalla el men煤 principal de la aplicaci贸n
     * @param opcionesMenu, recibe las opciones a presentar.
     * @return opc, devuelve la opci贸n seleccionada.
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
                utilidades.mostrarln("Esa opci髇 no esta disponible, intentelo otra vez.");
            }
            ;
        } while (opc <= -1 || opc > (numOpciones-1));
        return opc;
    }

    /**
     * Obtiene la opci贸n seleccionada por el usuario.
     * @return devuelve la opci贸n seleccionada.
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