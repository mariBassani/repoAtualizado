package com.amazona.amazona.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.amazona.amazona.model.Servico;
import com.amazona.amazona.repository.ServicoRepository;

@RestController
@RequestMapping("/servico")
public class ServicoController {

    @Autowired
    private ServicoRepository servicoRepository;

    @GetMapping
    public List<Servico> getAllServicos() {
        return (List<Servico>) servicoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Servico getServicoById(@PathVariable Long id) {
        return servicoRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Servico createNewServico(@RequestBody Servico newServico) {
        return servicoRepository.save(newServico);
    }

    @PutMapping("/{id}")
    public Servico updateServicoById(@PathVariable Long id, @RequestBody Servico updatedServico) {
        Optional<Servico> existingServico = servicoRepository.findById(id);
        if (existingServico.isPresent()) {
            Servico servico = existingServico.get();
            servico.setNomeSrvc(updatedServico.getNomeSrvc());
            servico.setPreco(updatedServico.getPreco());
            servico.setTempo(updatedServico.getTempo());
            return servicoRepository.save(servico);
        }
        return null; // Alternativamente, pode-se lançar uma exceção ou retornar uma resposta específica.
    }

    @DeleteMapping("/{id}")
    public void deleteServicoById(@PathVariable Long id) {
        servicoRepository.deleteById(id);
    }
}
