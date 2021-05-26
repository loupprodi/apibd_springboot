package br.uniso.demo.model.repository;

import br.uniso.demo.model.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AlunoRepository extends JpaRepository<Aluno, Integer>, JpaSpecificationExecutor<Aluno> {

    Aluno findAlunoByRa(int ra);

    Aluno findAlunoByNome(String nome);


}