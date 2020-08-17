/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.hibernatet.Operations;

import com.test.hibernatet.Dao.personaDao;
import com.test.hibernatet.modelo.Persona;
import java.util.Scanner;

/**
 *
 * @author GERSON
 */
public class OperHibernate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        personaDao persona = new personaDao();
        
        Persona p1 = null;
        int opcion = -1;
        Scanner entrada = new Scanner(System.in);
        String id, nombres, apellidos, direccion, email, dui, tip_sangre;
  
        while (opcion !=0){
        
        try{
            System.out.println("Elige una opcion:\n1.-Listar Personas" + 
          "\n2.-Buscar persona por Id\n" +
                    "3.-Agregar a una persona\n" +
                    "4.-Modificar una persona\n"+
                    "5.-Eliminar una persona\n" +
                    "0.-Salir\n");

            opcion = Integer.parseInt(entrada.nextLine());
            
            switch (opcion){
                case 1:
                    System.out.println("\n1.Listado***********");
                    persona.selectall();
                    break;
                    
                case 2:
                    System.out.println("\n2.Buscar persona por Id***********");
                    System.out.println("Introduce el Id de la persona a buscar:");
                    id = entrada.nextLine();
                    p1 = new Persona();
                    p1.setCodigo(new Integer(id));
                    p1 = persona.fyndbyId(p1);
                    System.out.println("Registro encontrado:" + p1);
                    break;
                case 3:
                    System.out.println("\n3.Insertar***********");
                    System.out.println("Introduce los nombres de la persona a agregar");
                    nombres = entrada.nextLine();
                    
                    System.out.println("Introduce los apellidos de la persona a agregar");
                    apellidos = entrada.nextLine();
                    
                    System.out.println("Introduce la direccion de la persona a agregar");
                    direccion = entrada.nextLine();
                    
                    System.out.println("Introduce el correo");
                    email = entrada.nextLine();
                    
                    System.out.println("Introduce numero de DUI");
                    dui = entrada.nextLine();
                    
                    System.out.println("Introduce tipo de sangre");
                    tip_sangre = entrada.nextLine();
                                  
                    p1 = new Persona();
                    p1.setNombres(nombres);
                    p1.setApellidos(apellidos);
                    p1.setDireccion(direccion);
                    p1.setCorreo(email);
                    p1.setDui(dui);
                    p1.setTipo_sangre(tip_sangre);
                    persona.Insertar(p1);
                    break;
                case 4:
                    System.out.println("\n4.Modificar***********");
                    //primero buscamos la persona a modificar
                    System.out.println("Introducir el Id de persona a modificar");
                    id = entrada.nextLine();
                    p1= new Persona();
                    p1.setCodigo(new Integer(id));
                    persona.fyndbyId(p1);
                    
                    System.out.println("Introduce el nombre de la persona a modificar");
                    nombres = entrada.nextLine();
                    
                    System.out.println("Introduce el apellido de la persona a buscar");
                    apellidos = entrada.nextLine();
                    
                    System.out.println("Introduce la direccion a modificar");
                    direccion = entrada.nextLine();
                    
                    System.out.println("introduce el correo a modificar");
                    email = entrada.nextLine();
                    
                    System.out.println("Introduce el duia modificar");
                    dui = entrada.nextLine();
                    
                    System.out.println("Introduce tipo de sangre a modificar");
                    tip_sangre = entrada.nextLine();
                    
                    p1.setNombres(nombres);
                    p1.setApellidos(apellidos);
                    p1.setDireccion(direccion);
                    p1.setCorreo(email);
                    p1.setDui(dui);
                    p1.setTipo_sangre(tip_sangre);
                    persona.actualizar(p1);
                    break;
                case 5:
                    System.out.println("\n5.Eliminar***********");
                    //buscamos la persona a eliminar
                    System.out.println("Introuce el id de la persona a eliminar");
                    id= entrada.nextLine();
                    p1 = new Persona();
                    p1.setCodigo(new Integer(id));
                    p1 = persona.fyndbyId(p1);
                    //Eliminar el registro encontrado
                    persona.eliminar(p1);
                    break;
                case 0:
                    System.out.println("Salida efectuada");
                    System.exit(0);
                    break;
                    
            
                } 
                    System.out.println("\n");
            
               }catch(Exception ex){
                    System.out.println("Surgio una falla en la ejecucion del programa:" + ex.getMessage());
            }
        
        } 
    }
    
}
