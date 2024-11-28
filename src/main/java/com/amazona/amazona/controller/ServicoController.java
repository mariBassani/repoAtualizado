package com.amazona.amazona.controller;

import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.StreamSupport;
    
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.amazona.amazona.model.Servico;
import com.amazona.amazona.repository.ServicoRepository;
    
@RestController
@RequestMapping("/servico")
public class ServicoController {
    
    @Autowired
    ServicoRepository servicoRepository;
    @GetMapping
    public List<Servico> getAllServicos() {
        return (List<Servico>) servicoRepository.findAll();
    }
    
    
    @GetMapping("/{id}")
    public Servico getservicoById(@PathVariable Long id) {
        return servicoRepository.findById(id).orElse(null);
    }
    
    @PostMapping
    public Servico createNewservico(@RequestBody Servico newservico) {
        return servicoRepository.save(newservico);
    }
    
    @DeleteMapping("/{id}")
    public void deleteservicoById(@PathVariable Long id) {
        servicoRepository.deleteById(id);
    }
}
