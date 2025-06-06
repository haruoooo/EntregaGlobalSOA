package com.fiap.global_solution.global_solution.service;

import com.fiap.global_solution.global_solution.modelling.LeituraModelling;
import com.fiap.global_solution.global_solution.repositories.LeituraJPArep;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeituraSVC {

    private final LeituraJPArep repository;

    public LeituraSVC(LeituraJPArep repository) {
        this.repository = repository;
    }

    public List<LeituraModelling> listarTodas() {
        return repository.findAll();
    }

    public ResponseEntity<?> salvar(LeituraModelling leitura) {
        if (leitura.getNivelAgua() >= 100) {
            leitura.setNivelAgua(100);
        }

        Optional<LeituraModelling> existente = repository.findById(leitura.getEstacaoId());
        if (existente.isPresent()) {
            LeituraModelling atual = existente.get();
            atual.setNivelAgua(leitura.getNivelAgua());
            LeituraModelling salvo = repository.save(atual);
            return ResponseEntity.ok("Nível de água no máximmo!");
        } else {
            return ResponseEntity.badRequest().body("Id não encontrado");
        }
    }


    public ResponseEntity<?> criarEstacao(LeituraModelling leitura) {
        Optional<LeituraModelling> existente = repository.findById(leitura.getEstacaoId());
        if (existente.isPresent()) {
            return ResponseEntity.badRequest().body("Estação com esse ID já existe.");
        } else {
            LeituraModelling salvo = repository.save(leitura);
            return ResponseEntity.ok(salvo);
        }
    }

    public ResponseEntity<?> apagarEstacao(LeituraModelling idEstacao) {
        Optional<LeituraModelling> existente = repository.findById(idEstacao.getEstacaoId());
        if (existente.isPresent()) {
            repository.deleteById(idEstacao.getEstacaoId());
            return ResponseEntity.ok("Estação removida com sucesso");
        } else {
            return ResponseEntity.badRequest().body("Id não encontrado.");
        }
    }



    public ResponseEntity<?> buscarPorEstacao(String estacaoId) {
        Optional<LeituraModelling> existente = repository.findById(estacaoId);
        if (existente.isPresent()) {
            return ResponseEntity.ok(existente.get());
        } else {
            return ResponseEntity.badRequest().body("Id não encontrado.");
        }
    }

}
