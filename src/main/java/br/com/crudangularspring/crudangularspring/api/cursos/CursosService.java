package br.com.crudangularspring.crudangularspring.api.cursos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.crudangularspring.crudangularspring.api.cursos.entity.CursoEntity;
import br.com.crudangularspring.crudangularspring.api.cursos.repository.CursosRepository;

@Service
public class CursosService {
	
	@Autowired
	CursosRepository cursosRepository;

	public List<CursoEntity> listarCursos() {
		List<CursoEntity> cursos = new ArrayList<>();
		
		try {
			cursos = cursosRepository.findAll();
		} catch(NullPointerException e) {
			throw new NullPointerException("Nenhum curso encontrado.");
		}
		
		return cursos;
	}
	
}
