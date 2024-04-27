/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Categoria;
import connection.ConnectionFactory;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author User
 */
public class CategoriaDAO {

    public Categoria save(Categoria categoria) {

        EntityManager em = new ConnectionFactory().getConnectio();
        try {

            em.getTransaction().begin();
            if (categoria.getId() == null) {
                em.persist(categoria);
            } else {
                em.merge(categoria);
            }

            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
        return categoria;

    }

    public Categoria findById(Integer id) {
        EntityManager em = new ConnectionFactory().getConnectio();
        Categoria categoria = null;
        try {
            categoria = em.find(Categoria.class, id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
        return categoria;
    }
    public List<Categoria> findAll(){
         EntityManager em = new ConnectionFactory().getConnectio();
         List<Categoria> categorias = null;
         
         try {
            categorias = em.createQuery("from Categoria c").getResultList();
        } catch (Exception e) {
             System.out.println(e.getMessage());
        }finally{
             em.close();
         }
        return categorias;
         
    }
    public Categoria remove(Integer id){
        EntityManager em = new ConnectionFactory().getConnectio();
        Categoria categoria = null;
        try {
             categoria = em.find(Categoria.class, id);
             em.getTransaction().begin();
             em.remove(categoria);
             em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
        }finally{
            em.close();
        }
        return categoria;
    }
}
