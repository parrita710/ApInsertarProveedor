package BBDD;

import beans.Proveedor;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utilidades.UtilidadesES;

public class BeanDAO {
    /**
     * Contiene el nombre de la clase Driver.
     * @uml.property  name="driver"
     */
    private String driver = "com.mysql.jdbc.Driver";

    /**
     * URL base para el acceso a la base de datos
     * @uml.property  name="urlBase"
     */
    private String urlBase = "jdbc:mysql://domanain.com:port/";

    /**
     * Nombre de la base datos
     * @uml.property  name="baseDatos"
     */
    private String baseDatos = null;

    /**
     * Nombre del usuario con el que se acceder� a la base de datos
     * @uml.property  name="usuario"
     */
    private String usuario = null;

    /**
     * Clave de usuario
     * @uml.property  name="clave"
     */
    private String clave = null;

    /**
     * Representa una conexi�n a la base de datos
     * @uml.property  name="conexion"
     */
    private Connection conexion = null;

    /**
     * Construye un bean de DAO a partir de driver, url base,
     * base de datos, nombre de usuario y clave
     */
    private UtilidadesES utilidadesES;

    public BeanDAO(String driver, String urlBase, String baseDatos, String usuario, String clave) {
        this.driver = driver;
        this.urlBase = urlBase;
        this.baseDatos = baseDatos;
        this.usuario = usuario;
        this.clave = clave;
        utilidadesES = new UtilidadesES(new BufferedReader(new InputStreamReader(System.in)), System.out);
    }

    /**
     * Metodo encargado de abrir la conexion
     */
    public void CreaConexion() {
        if (conexion == null)
            try {
                conexion =
                    DriverManager.getConnection("jdbc:mysql://domanain.com:port/" + "BD_Name", "account",
                                                "password");
            } catch (SQLException e) {
                utilidadesES.mostrarln("Error con la conexión a la base de datos: " + e);
            }

    }

    /**
     *Metodo getter que devuelve la conexion
     * @return Conection
     * @throws SQLException
     */
    public Connection getConexion() throws SQLException {
        if (conexion == null)
            conexion = DriverManager.getConnection(urlBase + baseDatos, usuario, clave);
        return conexion;
    }


    public void close() throws SQLException {
        if (conexion != null) {
            conexion.close();
            conexion = null;
        }
    }


    public void listarProveedores() throws SQLException {
        ResultSet rs = null;
        Statement st = null;
        try {
            st = conexion.createStatement();
            rs = st.executeQuery("SELECT * FROM Proveedores");
            while (rs.next()) {
                utilidadesES.mostrar(rs.getNString("nombre") + " - ");
                utilidadesES.mostrarln(rs.getNString("telefono"));
                //System.out.print(rs.getNString("nombre") + " - ");
                //System.out.println(rs.getNString("telefono"));

            }

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
        }
    }

    public void insertarProveedor(Proveedor proveedor) throws SQLException {
        String insert = null;
        Statement st = null;


        try {
            st = conexion.createStatement();
            insert =
                "INSERT INTO Proveedores(nombre, telefono)" + " VALUES " + "(" + "'" + proveedor.getNombre() + "'" +
                "," + "'" + proveedor.getTelefono() + "'" + ")";
            System.out.println(insert);
            st.executeUpdate(insert);
        } catch (SQLException f) {
            System.out.println("Error al a�adir el proveedor");
            System.out.println(f);
        } finally {
            if (st != null)
                st.close();
        }
    }

    public void buscarProveedor(String nombre) throws SQLException {
        ResultSet rs = null;
        Statement st = null;
        try {
            st = conexion.createStatement();
            rs = st.executeQuery("select * from Proveedores where nombre like '" + "%" + nombre + "%'");
            while (rs.next()) {
                utilidadesES.mostrar(rs.getNString("nombre") + " - ");
                utilidadesES.mostrarln(rs.getNString("telefono"));
                //System.out.print(rs.getNString("nombre") + " - ");
                //System.out.println(rs.getNString("telefono"));
            }

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
        }
    }

    public void borrarProveedor(String nombre) throws SQLException {
        ResultSet rs = null;
        Statement st = null;
        try {
            st = conexion.createStatement();
            rs = st.executeQuery("DELETE from Proveedores where nombre like '" + "%" + nombre + "%'" + "limit 1");
            rs = st.executeQuery("select * from Proveedores where nombre like '" + "%" + nombre + "%'");
            while (rs.next()) {
                utilidadesES.mostrar(rs.getNString("nombre") + " - ");
                utilidadesES.mostrarln(rs.getNString("telefono"));
                //System.out.print(rs.getNString("nombre") + " - ");
                //System.out.println(rs.getNString("telefono"));
            }

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
        }
    }

    public void modificarNombreProveedor(String nombre, String nuevoNombre) throws SQLException {
        ResultSet rs = null;
        Statement st = null;
        try {
            st = conexion.createStatement();
            rs =
                st.executeQuery("UPDATE Proveedores SET nombre =" + "'" + nuevoNombre + "'" + "where nombre like '" +
                                nombre + "'" + "limit 1");
            rs = st.executeQuery("select * from Proveedores where nombre like '" + "%" + nombre + "%'");
            rs = st.executeQuery("select * from Proveedores where nombre like '" + "%" + nuevoNombre + "%'");
            while (rs.next()) {
                utilidadesES.mostrar(rs.getNString("nombre") + " - ");
                utilidadesES.mostrarln(rs.getNString("telefono"));
            }


        } finally {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
        }
    }

    public void modificarTelefonoProveedor(String telefono, String nuevoTelefono) throws SQLException {
        ResultSet rs = null;
        Statement st = null;
        try {
            st = conexion.createStatement();
            rs =
                st.executeQuery("UPDATE Proveedores SET nombre =" + "'" + nuevoTelefono + "'" + "where nombre like '" +
                                telefono + "'" + "limit 1");
            rs = st.executeQuery("select * from Proveedores where nombre like '" + "%" + telefono + "%'");
            rs = st.executeQuery("select * from Proveedores where nombre like '" + "%" + nuevoTelefono + "%'");
            while (rs.next()) {
                utilidadesES.mostrar(rs.getNString("nombre") + " - ");
                utilidadesES.mostrarln(rs.getNString("telefono"));
            }


        } finally {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
        }
    }
}
