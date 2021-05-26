package br.uniso.demo.controller;

import br.uniso.demo.model.entity.Aluno;
import br.uniso.demo.model.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class AlunoController {

    @Autowired
    private AlunoRepository repository;

   // criar um endpoint para gravar no banco
    @PostMapping("/alunos")
    public boolean gravarAluno(@RequestBody Aluno aluno){


        Aluno gravado = repository.save(aluno);
        if(gravado == null){
            //nao gravou
            return false;
        }
        else {
            // gravou no banco sucesso
            return true;
        }
    }

    //criar um endpoint para ler no banco

    @GetMapping("/alunos")
    public List<Aluno> listarAlunos(){
        return repository.findAll();
    }



    @GetMapping("/alunos/ra")
    public Aluno listarAlunoPorRa(@RequestParam int ra){
        Aluno retornado = repository.findAlunoByRa(ra);
        return retornado;
    }



    @GetMapping("/alunos/nome")
    public Aluno listarAlunoPorNome(@RequestParam String nome){
        Aluno retornado = repository.findAlunoByNome(nome);
        return retornado;
    }



}
