package br.com.crudangularspring.crudangularspring.api.cursos;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.crudangularspring.crudangularspring.api.cursos.dto.CursoResponseDTO;

@RestController
@RequestMapping("/crud-angular-api/cursos")
public class CursosResource {

	
	public CursoResponseDTO listarCursos() {
		return null;
	}
	
}
