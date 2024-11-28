package com.amazona.amazona.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.amazona.amazona.model.Publicacao;

@Repository
public interface PublicacaoRepository extends CrudRepository<Publicacao, Long>{
    
    
}
