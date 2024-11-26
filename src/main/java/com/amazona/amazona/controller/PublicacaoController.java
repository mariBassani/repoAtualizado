package com.amazona.amazona.controller;

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

