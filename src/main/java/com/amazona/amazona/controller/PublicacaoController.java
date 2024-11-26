package com.amazona.amazona.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazona.amazona.model.Publicacao;
import com.amazona.amazona.repository.PublicacaoRepository;

@RestController
@RequestMapping("/publicacoes")
public class PublicacaoController {

    @Autowired
    PublicacaoRepository publicacaoRepository;

    @GetMapping
    public List<Publicacao> getPublicacoes() {
        return StreamSupport.stream(publicacaoRepository
                .findAll()
                .spliterator(), false)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Publicacao getPublicacaoById(@PathVariable Long id) {
        return publicacaoRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Publicacao createNewPublicacao(@RequestBody Publicacao newPublicacao) {
        return publicacaoRepository.save(newPublicacao);
    }

    @DeleteMapping("/{id}")
    public void deletePublicacaoById(@PathVariable Long id) {
        publicacaoRepository.deleteById(id);
    }
}

