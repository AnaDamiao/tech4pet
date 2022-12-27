package br.com.tech4me.tech4pet.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.tech4pet.model.PetShop;

public interface PetService {
   List<PetShop> obterTodos();
   PetShop cadastrar(PetShop petshop);
   Optional<PetShop> obterPorId(String id);
   void excluirPorId(String id);
   Optional<PetShop> atualizarPorId(String id, PetShop petshop);
   
    

}
