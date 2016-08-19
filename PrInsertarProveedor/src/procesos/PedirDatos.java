package procesos;

import BBDD.BeanDAO;

import beans.Proveedor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import utilidades.UtilidadesES;

public class PedirDatos {

    private Proveedor proveedor;
    private UtilidadesES utilidadesES;
    private BeanDAO beanDAO;

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
    
    public String pedirDominio(){
        String dominio;
        String puerto;
        dominio = null;
        puerto = null;

        try {
            dominio = utilidadesES.pideCadena("Introduce la dirección de la base de datos: dominio.com");
        } catch (IOException e) {
            System.out.println("Error entrada de teclado: " + e);
        }
        
        try {
            puerto = utilidadesES.pideCadena("Introduce el puerto de la base de datos: 3306");
        } catch (IOException e) {
            System.out.println("Error entrada de teclado: " + e);
        }
        
        return "jdbc:mysql://"+ dominio + ":" + puerto + "/";
    }


    public String pedirNombreBD() {
        String nombreBD;
            nombreBD = null;

        try {
            nombreBD = utilidadesES.pideCadena("Introduce el nombre de la base de datos");
        } catch (IOException e) {
            System.out.println("Error entrada de teclado: " + e);
        }
        return nombreBD;
    }

    public String pedirUsuario() {
        String usuario;
        usuario = null;

        try {
            usuario = utilidadesES.pideCadena("Introduce el nombre de usuario de la base de datos");
        } catch (IOException e) {
            System.out.println("Error entrada de teclado: " + e);
        }
        return usuario;
    }

    public String pedirPass() {
        String pass;
        pass = null;

        try {
            pass = utilidadesES.pideCadena("Introduce la contraseña de la base de datos");
        } catch (IOException e) {
            System.out.println("Error entrada de teclado: " + e);
        }
        return pass;
    }
}
