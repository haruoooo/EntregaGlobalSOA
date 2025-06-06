package com.fiap.global_solution.global_solution.repositories;

import com.fiap.global_solution.global_solution.modelling.LeituraModelling;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeituraJPArep extends JpaRepository<LeituraModelling, String> {
    List<LeituraModelling> findByEstacaoId(String estacaoId);
}
