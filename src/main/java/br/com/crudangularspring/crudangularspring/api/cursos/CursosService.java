package br.com.crudangularspring.crudangularspring.api.cursos;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.crudangularspring.crudangularspring.api.cursos.dto.CursoRequestDTO;
import br.com.crudangularspring.crudangularspring.api.cursos.dto.CursoResponseDTO;
import br.com.crudangularspring.crudangularspring.api.cursos.entity.CursoEntity;
import br.com.crudangularspring.crudangularspring.api.cursos.repository.CursosRepository;

@Service
public class CursosService {
	
	@Autowired
	CursosRepository cursosRepository;

	public List<CursoEntity> listarCursos() {
		List<CursoEntity> cursos = new ArrayList<>();
		cursos = cursosRepository.findAll();
		
		return cursos;
	}
	
	public CursoResponseDTO incluirCurso(CursoRequestDTO request) {
		
		if(request != null) {
			CursoEntity curso = new CursoEntity();
			curso.setCurso(request.getCurso());
			curso.setCategoria(request.getCategoria());
			try {
				cursosRepository.save(curso);
			} catch(InvalidParameterException ex) {
				CursoResponseDTO response = new CursoResponseDTO();
				response.setCodigo("400");
				response.setMensagem("Não foi possivel salvar o curso. Tente novamente.");
				return response;
			}
			
			CursoResponseDTO response = new CursoResponseDTO();
			response.setCodigo("200");
			response.setMensagem("Curso incluido com sucesso.");
			
			return response;
		}
		
		CursoResponseDTO response = new CursoResponseDTO();
		response.setCodigo("400");
		response.setMensagem("Não foi possivel salvar o curso. Tente novamente.");
		return response;
	}
	
}
