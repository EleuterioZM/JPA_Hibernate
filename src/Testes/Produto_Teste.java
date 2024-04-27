/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testes;

import DAO.ProdutoDAO;
import Model.Categoria;
import Model.Produto;

/**
 *
 * @author User
 */
public class Produto_Teste {

    public static void main(String[] args) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        // Produto produto = new Produto();

        for (Produto produto : produtoDAO.getAll()) {
        System.out.println("Descricao :" + produto.getDescricao());
        System.out.println("Quantidade :" + produto.getQuantidade());
        System.out.println("Valor :" + produto.getValor());
        System.out.println("Categoria :" + produto.getCategoria().getDescricao() );
            System.out.println("---------------------------------------------------------------------");
        }
       

//        Categoria categoria = new Categoria();
//        categoria.setId(1);
//     //   produto.setId(1);
//        produto.setDescricao("Arroz");
//        produto.setQuantidade(3);
//        produto.setValor(1500.30);
//        produto.setCategoria(categoria);
//        
//        produtoDAO.save(produto);
    }

}
