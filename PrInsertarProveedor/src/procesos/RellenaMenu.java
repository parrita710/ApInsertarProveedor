package procesos;

import menu.OpcionesMenu;

public class RellenaMenu {

    public OpcionesMenu rellenaOpcionesPrincipal(OpcionesMenu opcionesMenu) {

        opcionesMenu.add("Salir");
        opcionesMenu.add("A�adir Proveedor");
        opcionesMenu.add("Borrar Proveedor");
        opcionesMenu.add("Modificar Proveedor");
        opcionesMenu.add("Mostrar Proveedores");
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
