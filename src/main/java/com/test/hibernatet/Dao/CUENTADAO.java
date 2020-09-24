/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.hibernatet.Dao;
import com.test.hibernatet.modelo.CUENTA;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
/**
 *
 * @author FERNANDO
 */
public class CUENTADAO {
      protected EntityManager em;
    private EntityManagerFactory tran = null;
    
     public CUENTADAO (){
    
        tran = Persistence.createEntityManagerFactory("HibernatePU");
    
    }
    
    public CUENTA fyndbyId(CUENTA p){
        em = getEntityManager();
        return em.find(CUENTA.class, p.getCodigo());
    }
    
    
    private EntityManager getEntityManager(){
        
        return tran.createEntityManager();     
    
    }
    
    
    public void selectall(){
    
    //Iniciamos variable que contiene la sentencia a ejecutar
        String hql = "SELECT p from CUENTA p";
        em = getEntityManager();
        Query query = em.createQuery(hql);
        List<CUENTA> lista = query.getResultList();
        for (CUENTA p : lista){
        System.out.print(p + "\n");
        }
        
    }

    
    
    
    public void Insertar (CUENTA cuenta){
    
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(cuenta);
            em.getTransaction().commit();
            

        }catch (Exception ex){
        
            System.out.println("Error al insertar el objeto:" + ex.getMessage());
        
        
        }finally{
        
        if(em !=null){
            em.close();
            }
        
        }
    }

        
     public void actualizar (CUENTA cuenta){
     try{
         em = getEntityManager();
         em.getTransaction().begin();
         em.merge(cuenta);
         em.getTransaction().commit();
         
     
     }catch (Exception ex){
     
         System.out.println("Error al actualizar el objeto:"+ex.getMessage());
     
     
        }finally{
            if(em !=null){
                
                em.close();
            
            }
        }  
         
     }
    
    
    public void eliminar (CUENTA cuenta){
    try{
        em = getEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(cuenta));
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
