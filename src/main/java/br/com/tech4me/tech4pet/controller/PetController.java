package br.com.tech4me.tech4pet.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4me.tech4pet.model.PetShop;
import br.com.tech4me.tech4pet.service.PetService;



@RestController
@RequestMapping("/petshop")
public class PetController {
    
@Autowired
private PetService servico;

@PostMapping
public ResponseEntity<PetShop> cadastrarPet(@RequestBody PetShop petshop){
    return new ResponseEntity<>(servico.cadastrar(petshop), HttpStatus.CREATED);
}

@GetMapping()
public ResponseEntity<List<PetShop>> obterPetshop() {
    return new ResponseEntity<>(servico.obterTodos(),HttpStatus.OK);
}
@GetMapping("/{id}")
public ResponseEntity<PetShop> obterPet(@PathVariable String id){
    Optional<PetShop> retorno = servico.obterPorId(id);

    if(retorno.isPresent()){
        return new ResponseEntity<>(retorno.get(), HttpStatus.FOUND);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
@DeleteMapping("/{id}")
public ResponseEntity<Void> excluirPet(@PathVariable String id){
    servico.excluirPorId(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}

@PutMapping("/{id}")
public ResponseEntity<PetShop> atualizarPet(@PathVariable String id, @RequestBody PetShop petshop){
Optional<PetShop> retorno = servico.atualizarPorId(id, petshop);

if(retorno.isPresent()){
    return new ResponseEntity<>(retorno.get(), HttpStatus.ACCEPTED);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }
}    
    

}

