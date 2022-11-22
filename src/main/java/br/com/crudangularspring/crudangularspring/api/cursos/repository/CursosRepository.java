package br.com.crudangularspring.crudangularspring.api.cursos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.crudangularspring.crudangularspring.api.cursos.entity.CursoEntity;

public interface CursosRepository extends JpaRepository<CursoEntity, Long> {
	
}
