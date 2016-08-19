package procesos;

import beans.Proveedor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import utilidades.UtilidadesES;

public class PedirDatos {

    private Proveedor proveedor;
    private UtilidadesES utilidadesES;

    public PedirDatos() {
        utilidadesES = new UtilidadesES(new BufferedReader(new InputStreamReader(System.in)), System.out);
    }
    
    public Proveedor crearProveedor(){
        String nombre;
        String telefono;
        
        nombre = this.pedirNombre();
        telefono = this.pedirTelfono();
        proveedor = new Proveedor(nombre, telefono);
        
        return proveedor;
    }
    
    private String pedirNombre() {
        String nombre;
        nombre = null;
        try {
            nombre = utilidadesES.pideCadena("Introduce el nombre completo");
        } catch (IOException e) {
            System.out.println("Error entrada de teclado" + e);
        }
        return nombre;
    }

    private String pedirTelfono() {
        String telefono;
        telefono = null;
        try {
            telefono = utilidadesES.pideCadena("Introduce el telefono sin espacios");
        } catch (IOException e) {
            System.out.println("Error entrada de teclado: " + e);
        }
        return telefono;
    }

    public String buscarProveedor() {
        return pedirNombre();
    }

    public String pedirNombreProveedor() {
        return pedirNombre();
    }

    public String pedirNuevoNombre() {
        return pedirNombre();
    }

    public String pedirTelefonoProveedor() {
        return pedirTelfono();
    }

    public String pedirNuevoTelefono() {
        return pedirTelfono();
    }
}
