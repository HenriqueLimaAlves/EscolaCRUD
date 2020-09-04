package com.secretaria.escola.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.secretaria.escola.model.Alunos;

@Repository
public interface AlunoRepository extends JpaRepository<Alunos, Long>{
	public List<Alunos> findAllByNomeContainingIgnoreCase (String nome);
}
