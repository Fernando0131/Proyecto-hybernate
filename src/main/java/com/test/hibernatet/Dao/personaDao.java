/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.hibernatet.Dao;

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


public class personaDao {
    
    protected EntityManager em;
    private EntityManagerFactory tran = null;
    
    
    public personaDao (){
    
        tran = Persistence.createEntityManagerFactory("HibernatePU");
    
    }
    
    public Persona fyndbyId(Persona p){
        em = getEntityManager();
        return em.find(Persona.class, p.getCodigo());
    }
    
    
    private EntityManager getEntityManager(){
        
        return tran.createEntityManager();     
    
    }
    
    
    public void selectall(){
    
    //Iniciamos variable que contiene la sentencia a ejecutar
        String hql = "SELECT p from Persona p";
        em = getEntityManager();
        Query query = em.createQuery(hql);
        List<Persona> lista = query.getResultList();
        for (Persona p : lista){
        System.out.print(p + "\n");
        }
        
    }

    
    
    
    public void Insertar (Persona persona){
    
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(persona);
            em.getTransaction().commit();
            

        }catch (Exception ex){
        
            System.out.println("Error al insertar el objeto:" + ex.getMessage());
        
        
        }finally{
        
        if(em !=null){
            em.close();
            }
        
        }
    }

        
     public void actualizar (Persona persona){
     try{
         em = getEntityManager();
         em.getTransaction().begin();
         em.merge(persona);
         em.getTransaction().commit();
         
     
     }catch (Exception ex){
     
         System.out.println("Error al actualizar el objeto:"+ex.getMessage());
     
     
        }finally{
            if(em !=null){
                
                em.close();
            
            }
        }  
         
     }
    
    
    public void eliminar (Persona persona){
    try{
        em = getEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(persona));
        em.getTransaction().commit();

   
    
    }catch (Exception ex){
        System.out.println("Error al eliminar el objeto persona:"+ ex.getMessage());
    
    
        }finally{
    
        if(em !=null){
            em.close();
            
            }
        
        }
    
    }
    
    
}
