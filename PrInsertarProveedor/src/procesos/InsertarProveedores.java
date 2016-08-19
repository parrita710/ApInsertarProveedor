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
    private OpcionesMenu opcionesMenuLogin;
    private RellenaMenu rellenaMenu;
    private Menu menuPrincipal;
    private Menu rellenaOpcionesMostrarProveedores;
    private Menu rellenaOpcionesModificarProveedor;
    private Menu rellenaOpcionesLogin;
    private int opcion;

    public InsertarProveedores() {
        pedirDatos = new PedirDatos();
        utilidadesES = new UtilidadesES(new BufferedReader(new InputStreamReader(System.in)), System.out);
        opcionesMenuPrincipal = new OpcionesMenu();
        opcionesMostrarProveedores = new OpcionesMenu();
        opcionesMenuLogin = new OpcionesMenu();
        opcionesModificarProveedor = new OpcionesMenu();
        rellenaMenu = new RellenaMenu();
        rellenaMenu.rellenaOpcionesPrincipal(opcionesMenuPrincipal).toString();
        rellenaMenu.rellenaOpcionesMostrarProveedores(opcionesMostrarProveedores).toString();
        rellenaMenu.rellenaOpcionesLogin(opcionesMenuLogin).toString();
        rellenaMenu.rellenaOpcionesModificarProveedores(opcionesModificarProveedor).toString();
        menuPrincipal = new Menu(utilidadesES);
        rellenaOpcionesMostrarProveedores = new Menu(utilidadesES);
        rellenaOpcionesLogin = new Menu(utilidadesES);
        rellenaOpcionesModificarProveedor = new Menu(utilidadesES);
    }

    public void insertarProveedores() {
        boolean terminar = false;

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
            login();
            break;
        case 2:
            insertarProveedor();
            break;
        case 3:
            borrarProveedor();
            break;
        case 4:
            modificarProveedor();
            break;
        case 5:
            mostrarProveedor();
            break;
        }
    }


    private void login() {
        boolean terminar = false;

        do {
            opcion = rellenaOpcionesLogin.presentaMenu(opcionesMenuLogin);
            if (opcion == 0) {
                terminar = true;
            }
            if (opcion > 0 && opcion <= (opcionesMenuLogin.size())) {
                gestionOpcionesMenuLogin();
            }

        } while (!terminar);

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

    private void gestionOpcionesMenuLogin() {
        switch (opcion) {
        case 1:
            pedirDatosBD();
            break;
        case 2:
            probarConexion();
        }
    }

    private void pedirDatosBD() {
        beanDAO = new BeanDAO("com.mysql.jdbc.Driver", pedirDatos.pedirDominio(), 
                              pedirDatos.pedirNombreBD(), pedirDatos.pedirUsuario(), pedirDatos.pedirPass());
    }

    private void probarConexion() {
        try {
            beanDAO.getConexion();
        } catch (SQLException e) {
            System.out.println("Error en la conexión con la base de datos:" + e);
        } finally {
            insertarProveedores();
        }
    }
}
