package com.fiap.global_solution.global_solution.controller;

import com.fiap.global_solution.global_solution.modelling.LeituraModelling;
import com.fiap.global_solution.global_solution.service.LeituraSVC;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leituras")
public class LeituraControl {

    private final LeituraSVC service;

    public LeituraControl(LeituraSVC service) {
        this.service = service;
    }

    @GetMapping("/listar")
    public List<LeituraModelling> listar() {
        return service.listarTodas();
    }

    @PutMapping("/registrar")
    public ResponseEntity<?> registrar(@RequestBody LeituraModelling leitura) {
        return service.salvar(leitura);
    }

    @PostMapping("/nova-estacao")
    public ResponseEntity<?> criarEstacao(@RequestBody LeituraModelling leitura) {
        return service.criarEstacao(leitura);
    }


    @GetMapping("/estacao/{id}")
    public ResponseEntity<?> porEstacao(@PathVariable String id) {
        return service.buscarPorEstacao(id);
    }

    @DeleteMapping("/del-estacao")
    public ResponseEntity<?> deletarEstacao(@RequestParam LeituraModelling idEstacao){
        return service.apagarEstacao(idEstacao);
    }
}
