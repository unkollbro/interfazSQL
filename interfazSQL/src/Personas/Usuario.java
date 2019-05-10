/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personas;

import com.mysql.jdbc.Blob;
import java.util.ArrayList;

/**
 *
 * @author alumno
 */
public class Usuario {
   private int id;
   private String nombre;
   private int edad;
   private String username;
   private String passwd;
   private String direccion;
   private Blob vNotas;

    public Usuario(int id, String nombre, int edad, String username, String passwd, String direccion, Blob vNotas) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.username = username;
        this.passwd = passwd;
        this.direccion = direccion;
        this.vNotas = vNotas;
    }

    
   
}
