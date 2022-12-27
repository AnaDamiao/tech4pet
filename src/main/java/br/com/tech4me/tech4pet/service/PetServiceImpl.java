package br.com.tech4me.tech4pet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.tech4pet.model.PetShop;
import br.com.tech4me.tech4pet.repository.PetRepository;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    private PetRepository repositorio;


    @Override
    public PetShop cadastrar(PetShop petshop) {
        return repositorio.save(petshop);
    }
    @Override
    public List<PetShop> obterTodos() {
      return repositorio.findAll();
    }

    
  @Override
  public Optional<PetShop> obterPorId(String id) {
    return repositorio.findById(id);
  }
  
  @Override
  public void excluirPorId(String id) {
    repositorio.deleteById(id);
  }
  @Override
  public Optional<PetShop> atualizarPorId(String id, PetShop petshop) {
    Optional<PetShop> retorno =   repositorio.findById(id);

    if (retorno.isPresent()) {
      petshop.setId(id);
      return Optional.of(repositorio.save(petshop));
    } else {
      return Optional.empty();
    }
  }

}
