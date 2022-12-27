package br.com.tech4me.tech4pet.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.tech4me.tech4pet.model.PetShop;

    public interface PetRepository extends MongoRepository<PetShop, String>{
        
    }

