/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.hibernatet.examples;



/**
 *
 * @author GERSON
 */
public class Example1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        AccesoBD select = new AccesoBD(); //Instanciamos el objeto que maneja las operaciones sobre la base de datos
         select.consultar(); //para consultar los registros
       // select.eliminar(6); //metodo para eliminar pasando el id como parametro
       // select.Insertar(11, "aracely", "buenaventura", "panchimalco", "test@gmail.com", "125478", "orh");  //metodo para insertar un registro             
       // select.actualizar("aracelyasf", "buenaventuraqwe", "panchimalcoas", "test@gmail.com", "12547823", "orh",11);  //metodo para actualizar un registro pasando como parametro el id
    
    }
}
