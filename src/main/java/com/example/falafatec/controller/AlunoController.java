package com.example.falafatec.controller;

import com.example.falafatec.entity.Aluno;
import com.example.falafatec.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/api/aluno")
public class AlunoController {

    @Autowired
    AlunoRepository repository;

    @GetMapping
    public List<Aluno> list (){
        System.out.println("Recuperando os alunos");
        return repository.findAll();
    }

    @PostMapping
    public void salvar (@RequestBody Aluno aluno){
        System.out.println("Salvando aluno" + aluno.getNome());
        repository.save(aluno);
    }


}
