/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLConnection;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alumno
 */
public class ConfigSQL {
    private Connection conexion;
    private final String host;
    private final String db;
    private final String username;
    private final String password;

    public ConfigSQL() {
        this.host = "jdbc:mysql://188.241.222.210:3306/";
        this.db = "clubtip3_java";
        this.username = "clubtip3_java";
        this.password = "clubtip3_java";
    }

    private void abrirConexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // Establecemos la conexión con la base de datos. 
            conexion = (Connection) DriverManager.getConnection (host+db,username, password);
            if(!conexion.isClosed()){
                System.out.println("Conexión abierta");
            }
        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(ConfigSQL.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("RIP");
        } catch (SQLException ex) {
            //Logger.getLogger(ConfigSQL.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("RIP");
        }
    }
    
    public void realizarConsulta(String Consulta){
        abrirConexion();
        //MENUS - SELECCIONAR FICHEROS - PROYECTO
        try {
            Statement statement = (Statement) conexion.createStatement();
            ResultSet resultset = statement.executeQuery(Consulta);
            while(resultset.next()){
                System.out.println("** ID: "+resultset.getString(1));
                System.out.println("** NOMBRE: "+resultset.getString(2));
                System.out.println("** EDAD: "+resultset.getString(3));
                System.out.println("** USERNAME: "+resultset.getString(4));
                System.out.println("** PASSWORD: "+resultset.getString(5));
                System.out.println("** DIRECCION: "+resultset.getString(6));
                System.out.println("** BLOB: "+resultset.getString(7));
                System.out.println("***************************************");
            }
        } catch (SQLException ex) {
            //Logger.getLogger(ConfigSQL.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error realizando Consulta");
        }
        cerrarConexion();
    }
    
    private void cerrarConexion(){
        try {
            conexion.close();
            if(conexion.isClosed()){
                System.out.println("Conexión cerrada");
            }
        } catch (SQLException ex) {
            //Logger.getLogger(ConfigSQL.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error cerrando Conexión a la base de datos");
        }
    }
    
    
    
}
