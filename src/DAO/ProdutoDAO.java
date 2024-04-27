/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Produto;
import connection.ConnectionFactory;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author User
 */
public class ProdutoDAO {

    public Produto save(Produto produto) {
        EntityManager em = new ConnectionFactory().getConnectio();
        try {
            em.getTransaction().begin();
            if (produto.getId() == null) {
                em.persist(produto);
            } else {
                em.merge(produto);
            }

            em.getTransaction().commit();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return produto;

    }

    public Produto getById(Integer id) {
        EntityManager em = new ConnectionFactory().getConnectio();
        Produto produto = null;

        try {
            produto = em.find(Produto.class, id);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return produto;
    }

    public List<Produto> getAll() {
        EntityManager em = new ConnectionFactory().getConnectio();
        List<Produto> produtos = null;

        try {
            produtos = em.createQuery("from Produto p").getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
        return produtos;
    }
}
