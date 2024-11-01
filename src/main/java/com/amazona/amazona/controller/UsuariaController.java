package com.amazona.amazona.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.amazona.amazona.model.Usuaria;
import com.amazona.amazona.repository.UsuariaRepository;

@RestController
@RequestMapping("/usuaria")
public class UsuariaController {

    @Autowired
    UsuariaRepository usuariaRepository;

    @GetMapping
    public List<Usuaria> getAllUsuarias() {
        return StreamSupport.stream(usuariaRepository
                .findAll()
                .spliterator(), false)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Usuaria getUsuariaById(@PathVariable Long id) {
        return usuariaRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Usuaria createNewUsuaria(@RequestBody Usuaria newUsuaria) {
        return usuariaRepository.save(newUsuaria);
    }

    @PutMapping("/{id}")
    public Usuaria updateUsuariaById(
            @PathVariable Long id,
            @RequestBody Usuaria usuariaToUpdate) {
        return usuariaRepository.findById(id)
                .map(usuariaFromDb -> {
                    usuariaFromDb.setNome(usuariaToUpdate.getNome());
                    usuariaFromDb.setIdade(usuariaToUpdate.getIdade());
                    usuariaFromDb.setCpf(usuariaToUpdate.getCpf());
                    usuariaFromDb.setAssinante(usuariaToUpdate.getAssinante());
                    return usuariaRepository.save(usuariaFromDb);
                })
                .orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteUsuariaById(@PathVariable Long id) {
        usuariaRepository.deleteById(id);
    }
}
