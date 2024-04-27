/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testes;

import DAO.CategoriaDAO;
import Model.Categoria;



/**
 *
 * @author User
 */
public class Categorias_testes {
    public static void main(String[] args) {
       ;
        
        CategoriaDAO categoriaDAO = new CategoriaDAO();
//        
//        Categoria categoria = categoriaDAO.findById(3);
//        System.out.println("Descricao  "+categoria.getDescricao());
         categoriaDAO.remove(2);
     for(Categoria categoria: categoriaDAO.findAll()){
         System.out.println("Descricao:  "+categoria.getDescricao());
     }
    }
   
}
