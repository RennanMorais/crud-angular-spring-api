package br.com.crudangularspring.crudangularspring.api.cursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.crudangularspring.crudangularspring.api.cursos.entity.CursoEntity;

@RestController
@RequestMapping("/crud-angular-api/cursos")
public class CursosResource {

	@Autowired
	CursosService cursosService;
	
	@GetMapping("")
	public List<CursoEntity> listarCursos() {
		return cursosService.listarCursos();
	}
	
}
