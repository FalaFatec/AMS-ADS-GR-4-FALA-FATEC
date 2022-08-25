package br.com.falafatecpi.repository;

import br.com.falafatecpi.model.AlunoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlunoRepository extends JpaRepository<AlunoModel, Integer> {

    Optional<AlunoModel> findByEmailAndSenha(String email, String senha);

}
