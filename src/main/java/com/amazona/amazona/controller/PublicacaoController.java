package com.amazona.amazona.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.amazona.amazona.model.Publicacao;
import com.amazona.amazona.repository.PublicacaoRepository;

@RestController
@RequestMapping("/publicacoes")
public class PublicacaoController {

    @Autowired
    PublicacaoRepository publicacaoRepository;

    // Método GET para buscar todas as publicações
    @GetMapping
    public List<Publicacao> getAllPublicacoes() {
        return (List<Publicacao>) publicacaoRepository.findAll();
    }

    // Método GET para buscar publicação por ID
    @GetMapping("/{id}")
    public Publicacao getPublicacaoById(@PathVariable Long id) {
        return publicacaoRepository.findById(id).orElse(null);
    }

    // Método POST para criar uma nova publicação
    @PostMapping
    public Publicacao createNewPublicacao(@RequestBody Publicacao newPublicacao) {
        return publicacaoRepository.save(newPublicacao);
    }

    // Método DELETE para excluir publicação por ID
    @DeleteMapping("/{id}")
    public void deletePublicacaoById(@PathVariable Long id) {
        publicacaoRepository.deleteById(id);
    }

    // Método PUT para atualizar publicação existente
    @PutMapping("/{id}")
    public Publicacao updatePublicacaoById(
            @PathVariable Long id,
            @RequestBody Publicacao publicacaoToUpdate) {

        // Verifica se a publicação existe
        return publicacaoRepository.findById(id)
                .map(publicacaoFromDb -> {
                    // Atualiza os campos da publicação
                    publicacaoFromDb.setData(publicacaoToUpdate.getData());
                    publicacaoFromDb.setUrl(publicacaoToUpdate.getUrl());
                    publicacaoFromDb.setDescricao(publicacaoToUpdate.getDescricao());
                    
                    // Salva e retorna a publicação atualizada
                    return publicacaoRepository.save(publicacaoFromDb);
                })
                .orElse(null); // Se não encontrar a publicação, retorna null
    }
}
