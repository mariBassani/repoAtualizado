package com.amazona.amazona.repository;
import org.springframework.data.repository.CrudRepository;
import com.amazona.amazona.model.Usuaria;

public interface UsuariaRepository extends CrudRepository<Usuaria, Long>{ 
    // @SuppressWarnings("unchecked")
    // Usuaria save(Usuaria newServico);
}