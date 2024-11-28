package com.amazona.amazona.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.amazona.amazona.model.Usuaria;

@Repository
public interface UsuariaRepository extends CrudRepository<Usuaria, Long>{ 
    
}