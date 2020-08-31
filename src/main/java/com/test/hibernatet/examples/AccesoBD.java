/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.hibernatet.examples;

import com.test.hibernatet.modelo.Persona;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


/**
 *
 * @author GERSON
 */
public class AccesoBD {
    
     
        protected EntityManager em;
    private EntityManagerFactory tran = null;
    
    
    public AccesoBD (){
    
        tran = Persistence.createEntityManagerFactory("HibernatePU");
    
    }
    
      
    
    private EntityManager getEntityManager(){
        
        return tran.createEntityManager();     
    
    }
        
        
    public void consultar(){
    em = getEntityManager();
    String sql = "SELECT * FROM PERSONA";
    Query query = em.createNativeQuery(sql,Persona.class);
    List<Persona> lista = query.getResultList();
    for (Persona p : lista){
        System.out.print(p + "\n");
        }
    }
    
    
    public void Insertar(Integer id, String nombres, String apellidos, String direccion, String correo, String dui, String tipo_sangre){
        
        try{
        em=getEntityManager();
        em.getTransaction().begin();
        String sql = "INSERT INTO PERSONA(ID,NOMBRES,APELLIDOS,DIRECCION,EMAIL,DUI,TIP_SANGRE)VALUES(?,?,?,?,?,?,?)";
        Query query = em.createNativeQuery(sql);
        query.setParameter(1, id);
        query.setParameter(2, nombres);
        query.setParameter(3, apellidos);
        query.setParameter(4, direccion);
        query.setParameter(5, correo);
        query.setParameter(6, dui);
        query.setParameter(7, tipo_sangre);
        query.executeUpdate();
        em.getTransaction().commit();
        System.out.println("Inserción de persona con exito");
    
        }catch(Exception ex){
        System.out.println("Sucedio un error en el programa " + ex.getMessage());
        
        
        }finally{
    
        if(em !=null){
            em.close();
            
            }
    
        }
    
    
    }
  
    public void actualizar(String nombres, String apellidos, String direccion, String correo, String dui, String tipo_sangre,Integer id){
        try{ 
            em=getEntityManager();
            em.getTransaction().begin();
            String sql = "UPDATE PERSONA SET NOMBRES=?,APELLIDOS=?,DIRECCION=?,EMAIL=?,DUI=?,TIP_SANGRE=? WHERE ID=?";
            Query query = em.createNativeQuery(sql);
            query.setParameter(1, nombres);
            query.setParameter(2, apellidos);
            query.setParameter(3, direccion);
            query.setParameter(4, correo);
            query.setParameter(5, dui);
            query.setParameter(6, tipo_sangre);
            query.setParameter(7, id);
            query.executeUpdate();
            em.getTransaction().commit();
            System.out.println("Actualización de persona con exito");
    
        }catch(Exception ex){
            System.out.println("Sucedio un error en el programa " + ex.getMessage());
                
        }finally{
        if(em !=null){
            em.close();
            
            }
                      
        }
    
    }
    
  
 
    public void eliminar(Integer id) {
    
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            String sql = "DELETE FROM PERSONA WHERE ID = ?";
            Query query = em.createNativeQuery(sql).setParameter(1, id);
            query.executeUpdate();
            em.getTransaction().commit();
            System.out.println("Borrado de persona satisfactorio");
           
        }catch(Exception ex){
            
            System.out.println("Sucedio un error en el programa"+ex.getMessage());
       
        }finally{
    
        if(em !=null){
            em.close();
            
            }
    
        }
             
        
    }


}
    
    

