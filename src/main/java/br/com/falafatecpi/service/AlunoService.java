package br.com.falafatecpi.service;

import br.com.falafatecpi.model.AlunoModel;
import br.com.falafatecpi.repository.AlunoRepository;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }


    public AlunoModel registerUser(Integer ra, String email, String senha){
        if(ra == null || email == null || senha == null){
            return null;
        }else {
            AlunoModel alunoModel = new AlunoModel();
            alunoModel.setRa(ra);
            alunoModel.setEmail(email);
            alunoModel.setSenha(senha);
            return alunoRepository.save(alunoModel);
        }
    }

    public AlunoModel authenticate(String email, String senha){
        return alunoRepository.findByEmailAndSenha(email, senha).orElse(null);
        }



}
