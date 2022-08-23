package com.example.fala_fatec.repository;

import com.example.fala_fatec.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
