package procesos;

import BBDD.BeanDAO;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.sql.SQLException;

import menu.Menu;
import menu.OpcionesMenu;

import utilidades.UtilidadesES;


public class InsertarProveedores {

    private BeanDAO beanDAO;
    private UtilidadesES utilidadesES;
    private PedirDatos pedirDatos;
    private OpcionesMenu opcionesMenuPrincipal;
    private OpcionesMenu opcionesMostrarProveedores;
    private OpcionesMenu opcionesModificarProveedor;
    private RellenaMenu rellenaMenu;
    private Menu menuPrincipal;
    private Menu rellenaOpcionesMostrarProveedores;
    private Menu rellenaOpcionesModificarProveedor;
    private int opcion;

    public InsertarProveedores() {
        beanDAO =
            new BeanDAO("com.mysql.jdbc.Driver", "jdbc:mysql://domain.com:port/", "BD_name", "account",
                        "password");
        pedirDatos = new PedirDatos();
        utilidadesES = new UtilidadesES(new BufferedReader(new InputStreamReader(System.in)), System.out);
        opcionesMenuPrincipal = new OpcionesMenu();
        opcionesMostrarProveedores = new OpcionesMenu();
        rellenaMenu = new RellenaMenu();
        rellenaMenu.rellenaOpcionesPrincipal(opcionesMenuPrincipal).toString();
        rellenaMenu.rellenaOpcionesMostrarProveedores(opcionesMostrarProveedores).toString();
        menuPrincipal = new Menu(utilidadesES);
        rellenaOpcionesMostrarProveedores = new Menu(utilidadesES);
        opcionesModificarProveedor = new OpcionesMenu();
        rellenaOpcionesModificarProveedor = new Menu(utilidadesES);
        rellenaMenu.rellenaOpcionesModificarProveedores(opcionesModificarProveedor).toString();
    }

    public void insertarProveedores() {
        boolean terminar = false;

        try {
            beanDAO.getConexion();
        } catch (SQLException e) {
            utilidadesES.mostrarln("Error en la conexi�n con la base de datos: " + e);
        }

        do {
            opcion = menuPrincipal.presentaMenu(opcionesMenuPrincipal);
            if (opcion == 0) {
                terminar = true;
            }
            if (opcion > 0 && opcion <= (opcionesMenuPrincipal.size())) {
                gestionOpcionPrincipal();
            }

        } while (!terminar);

    }

    private void gestionOpcionPrincipal() {
        switch (opcion) {
        case 1:
            insertarProveedor();
            break;
        case 2:
            borrarProveedor();
            break;
        case 3:
            modificarProveedor();
            break;
        case 4:
            mostrarProveedor();
            break;
        }
    }

    private void insertarProveedor() {
        try {
            beanDAO.insertarProveedor(pedirDatos.crearProveedor());
        } catch (SQLException e) {
            utilidadesES.mostrarln("Error al a�adir el proveedor: " + e);
        }
    }

    private void borrarProveedor() {
        try {
            beanDAO.borrarProveedor(pedirDatos.buscarProveedor());
        } catch (SQLException e) {
            utilidadesES.mostrarln("Error al recuperar los proveedores: " + e);
        }
    }

    private void modificarProveedor() {
        boolean terminar = false;

        do {
            opcion = rellenaOpcionesModificarProveedor.presentaMenu(opcionesModificarProveedor);
            if (opcion == 0) {
                terminar = true;
            }
            if (opcion > 0 && opcion <= (opcionesMostrarProveedores.size())) {
                gestionOpcionesModificarProveedor();
            }

        } while (!terminar);

    }

    private void mostrarProveedor() {
        boolean terminar = false;

        do {
            opcion = rellenaOpcionesMostrarProveedores.presentaMenu(opcionesMostrarProveedores);
            if (opcion == 0) {
                terminar = true;
            }
            if (opcion > 0 && opcion <= (opcionesMostrarProveedores.size())) {
                gestionOpcionesMostrarProveedores();
            }

        } while (!terminar);

    }

    private void gestionOpcionesMostrarProveedores() {
        switch (opcion) {
        case 1:
            listarProveedores();
            break;
        case 2:
            buscarProveedor();
            break;
        }
    }

    private void listarProveedores() {
        try {
            beanDAO.listarProveedores();
        } catch (SQLException e) {
            utilidadesES.mostrarln("Error al recuperar los proveedores: " + e);
        }
    }

    private void buscarProveedor() {
        try {
            beanDAO.buscarProveedor(pedirDatos.buscarProveedor());
        } catch (SQLException e) {
            utilidadesES.mostrarln("Error al buscar los proveedores: " + e);
            
        }
    }

    private void gestionOpcionesModificarProveedor() {
        switch (opcion) {
        case 1:
            modificarNombre();
            break;
        case 2:
            ModificarTelefono();
            break;
        } 
    }

    private void modificarNombre() {
        try {
            beanDAO.modificarNombreProveedor(pedirDatos.pedirNombreProveedor(), pedirDatos.pedirNuevoNombre());
        } catch (SQLException e) {
            utilidadesES.mostrarln("Error al buscar los proveedores: " + e);
        }
    }

    private void ModificarTelefono() {
        try {
            beanDAO.modificarNombreProveedor(pedirDatos.pedirTelefonoProveedor(), pedirDatos.pedirNuevoTelefono());
        } catch (SQLException e) {
            utilidadesES.mostrarln("Error al buscar los proveedores: " + e);
        }
    }
}
