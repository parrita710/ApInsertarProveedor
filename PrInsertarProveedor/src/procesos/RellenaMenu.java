package procesos;

import menu.OpcionesMenu;

public class RellenaMenu {


    public OpcionesMenu rellenaOpcionesPrincipal(OpcionesMenu opcionesMenu) {

        opcionesMenu.add("Salir");
        opcionesMenu.add("Login");
        opcionesMenu.add("Añadir Proveedor");
        opcionesMenu.add("Borrar Proveedor");
        opcionesMenu.add("Modificar Proveedor");
        opcionesMenu.add("Mostrar Proveedores");
        return opcionesMenu;
    }
    
    public OpcionesMenu rellenaOpcionesLogin(OpcionesMenu opcionesMenu){
        
        opcionesMenu.add("Salir");
        opcionesMenu.add("Introducir datos de la conexión");
        opcionesMenu.add("Probar Conexión");
        return opcionesMenu;
    }

    public OpcionesMenu rellenaOpcionesMostrarProveedores(OpcionesMenu opcionesMenu) {

        opcionesMenu.add("Salir");
        opcionesMenu.add("Mostrar todos los proveedores");
        opcionesMenu.add("Buscar un proveedor");
        return opcionesMenu;
    }
    
    public OpcionesMenu rellenaOpcionesModificarProveedores(OpcionesMenu opcionesMenu) {
        opcionesMenu.add("Salir");
        opcionesMenu.add("Modificar nombre");
        opcionesMenu.add("Modificar telefono");
        return opcionesMenu;
    }
}
