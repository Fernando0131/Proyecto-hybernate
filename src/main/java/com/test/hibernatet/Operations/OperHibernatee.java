/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.hibernatet.Operations;

import com.test.hibernatet.Dao.CUENTADAO;
import com.test.hibernatet.modelo.CUENTA;
import java.util.Scanner;
/**
 *
 * @author FERNANDO
 */
public class OperHibernatee {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         CUENTADAO cuenta = new CUENTADAO();
        
        CUENTA p1 = null;
        int opcion = -1;
        Scanner entrada = new Scanner(System.in);
        String id, nombre_cuenta, fecha,cuenta_1, cuenta_2;
  
        while (opcion !=0){
        
        try{
            System.out.println("Elige una opcion:\n1.-Listar Cuentas" + 
          "\n2.-Buscar cuenta por Id\n" +
                    "3.-Agregar a una cuenta\n" +
                    "4.-Modificar una cuenta\n"+
                    "5.-Eliminar una cuenta\n" +
                    "0.-Salir\n");

            opcion = Integer.parseInt(entrada.nextLine());
            
            switch (opcion){
                case 1:
                    System.out.println("\n1.Listado***********");
                    cuenta.selectall();
                    break;
                    
                case 2:
                    System.out.println("\n2.Buscar cuenta por Id***********");
                    System.out.println("Introduce el Id de la cuenta a buscar:");
                    id = entrada.nextLine();
                    p1 = new CUENTA();
                    p1.setCodigo(new Integer(id));
                    p1 = cuenta.fyndbyId(p1);
                    System.out.println("Registro encontrado:" + p1);
                    break;
                case 3:
                    System.out.println("\n3.Insertar***********");
                    System.out.println("Introduce los nombres de la cuenta a agregar");
                    nombre_cuenta = entrada.nextLine();
                    
                    System.out.println("Introduce la fecha de la cuenta a agregar");
                    fecha = entrada.nextLine();
                    
                    System.out.println("Introduce el contenido de la cuenta 1 a agregar");
                    cuenta_1 = entrada.nextLine();
                    
                    System.out.println("Introduce el contenido de la cuenta 2 a agregar");
                    cuenta_2 = entrada.nextLine();
                    
                                 
                    p1 = new CUENTA();
                    p1.setNombres(nombre_cuenta);
                    p1.setFecha(fecha);
                    p1.setCuenta_1(cuenta_1);
                    p1.setCuenta_2(cuenta_2);
                    cuenta.Insertar(p1);
                    break;
                case 4:
                    System.out.println("\n4.Modificar***********");
                    //primero buscamos la persona a modificar
                    System.out.println("Introducir el Id de la cuenta a modificar");
                    id = entrada.nextLine();
                    p1= new CUENTA();
                    p1.setCodigo(new Integer(id));
                    cuenta.fyndbyId(p1);
                    
                    System.out.println("Introduce el nombre de la cuenta a modificar");
                    nombre_cuenta = entrada.nextLine();
                    
                    System.out.println("Introduce la fecha de la cuenta a modificar");
                    fecha = entrada.nextLine();
                    
                    System.out.println("Introduce el contenido de la cuenta_1 a modificar");
                    cuenta_1 = entrada.nextLine();
                    
                    System.out.println("introduce el contenido de la cuenta_2 a modificar");
                    cuenta_2 = entrada.nextLine();
                    
                    
                    p1.setNombres(nombre_cuenta);
                    p1.setFecha(fecha);
                    p1.setCuenta_1(cuenta_1);
                    p1.setCuenta_2(cuenta_2);
                    cuenta.actualizar(p1);
                    break;
                case 5:
                    System.out.println("\n5.Eliminar***********");
                    //buscamos la persona a eliminar
                    System.out.println("Introuce el id de la cuenta a eliminar");
                    id= entrada.nextLine();
                    p1 = new CUENTA();
                    p1.setCodigo(new Integer(id));
                    p1 = cuenta.fyndbyId(p1);
                    //Eliminar el registro encontrado
                    cuenta.eliminar(p1);
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
